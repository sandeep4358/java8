package com.stingray;

public class TestMethodReferences {

	public static void main(String[] args) {
		Sandeep s = new SandeepImplementation()::checkFiesibility;
		s.checkFiesibility(10, 11);
	};
}

interface Sandeep {
	public void checkFiesibility(int k, int j);
}

class SandeepImplementation {
	public void checkFiesibility(int k, int j) {
		System.out.println(k + j);
	}
}