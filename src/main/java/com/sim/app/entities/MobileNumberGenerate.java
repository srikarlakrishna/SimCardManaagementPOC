package com.sim.app.entities;

import java.util.Random;

public class MobileNumberGenerate {
	public static String randomPhoneNumber() {
		Random random = new Random();
		StringBuilder randomNumber = new StringBuilder("9");
		for (int i = 0; i < 9; i++) {
			randomNumber.append(random.nextInt(9));
		}
		return randomNumber.toString();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 9; i++) {
			System.out.println(randomPhoneNumber());
		}
	}
}
