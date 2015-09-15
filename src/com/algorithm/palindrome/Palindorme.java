package com.algorithm.palindrome;

public class Palindorme {
	
	private boolean ifPalindorem(String s) {
		char[] chars = s.toCharArray();
		int length = s.length();
		int mid = 0;
		if(length == 1) {
			return true;
		}
		else if(length == 0) {
			return false;
		}
		else if(length%2==0) {
			mid = length/2;
		}
//		else {
//
//		}
//
//		for(;mid<)
//
//
		return false;
	}

	private int check(String s, int mid) {
		char[] chars = s.toCharArray();
		
		int i=0;
		for(;i<mid;i++) {
			if(chars[i] == chars[mid+i]) {
				;
			}
		}
		return i;
	}
	
	public static void main(String[] args) {

	}

}
