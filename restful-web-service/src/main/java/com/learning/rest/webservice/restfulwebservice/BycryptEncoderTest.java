package com.learning.rest.webservice.restfulwebservice;

import java.util.Iterator;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BycryptEncoderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		
		for (int i = 0; i < 10; i++) {
			String encode = encoder.encode("rishav@875");
			System.out.println(encode);
		}

	}

}
