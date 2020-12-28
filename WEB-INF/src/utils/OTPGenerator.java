package utils;

import java.util.Random;

public class OTPGenerator{	
	public static String generateOTP(){
		String str = "";
		Random r = new Random();

		for(int i=0;i<6;i++)
			str = str + r.nextInt(10);
		System.out.println(str);
		return str;
	}
}