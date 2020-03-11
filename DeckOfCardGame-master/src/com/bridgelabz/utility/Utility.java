package com.bridgelabz.utility;

import java.util.Random;

public class Utility {


	public static int getRandomNumber() {
		Random r = new Random();
		
			int n = 0+r.nextInt(51);
//			System.out.println(n);
	
		return n;
	}


}
