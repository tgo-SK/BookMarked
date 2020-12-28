package utils;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.io.InputStream;
import javax.json.Json;
import javax.json.JsonReader;
import javax.json.JsonObject;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

public class GoogleReCaptcha{
	public static boolean signUpCaptcha(String gReCaptcha)throws IOException,MalformedURLException,ProtocolException{
	
	String requestURL = "https://www.google.com/recaptcha/api/siteverify";
	String requestParameter = "secret=6Le0w9QZAAAAAPqAEN3K1V5wuWAZDvEfMlMWwbuJ&response="+gReCaptcha;
	
	URL url = new URL(requestURL+"?"+requestParameter);
	HttpURLConnection con = (HttpURLConnection)url.openConnection();

	con.setRequestMethod("POST");
	con.setDoOutput(true);

	DataOutputStream dos = new DataOutputStream(con.getOutputStream());
	dos.flush();
	dos.close();

	InputStream inputStream;
	int status = con.getResponseCode();
	if(status != HttpURLConnection.HTTP_OK){
		inputStream = con.getErrorStream();
	}else{
		inputStream = con.getInputStream();
	}

	JsonReader jsonReader =	Json.createReader(inputStream);	
	JsonObject jsonObject =	jsonReader.readObject();

	boolean flag = jsonObject.getBoolean("success");

	return flag;	
	}
}