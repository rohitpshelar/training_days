package com.cjc.action;

import java.util.Random;

public class RandomString {
	// Verison 1.0

	public static String autoGenrator() {
		String dCase = "abcdefghijklmnopqrstuvwxyz";
		String uCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String intChar = "0123456789";
		Random r = new Random();
		String pass = "";

		while (pass.length() != 10) {
			int rPick = r.nextInt(4);
			System.out.println(rPick);
			if (rPick == 0) {
				int spot = r.nextInt(25);
				pass += dCase.charAt(spot);
			} else if (rPick == 1) {
				int spot = r.nextInt(25);
				pass += uCase.charAt(spot);
			} else if (rPick == 3) {
				int spot = r.nextInt(9);
				pass += intChar.charAt(spot);
			}
		}
		System.out.println(pass);
		return pass;
	}

	public static void main(String[] args) {
		autoGenrator();
	}

}
