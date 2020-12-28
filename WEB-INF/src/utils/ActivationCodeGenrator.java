package utils;
import java.util.Random;
import java.util.Date;


public class ActivationCodeGenrator{
	public static String getActivationCode(){

		long activation1 =   new Random().nextLong();
		long activation2 = new Date().getTime();

		if(activation1 < 0)
			activation1 = activation1*(-1);
		System.out.println(activation1+"_"+activation2);
		return activation1+"_"+activation2;
	}
}