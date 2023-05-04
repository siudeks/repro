package com.example.demo;

import com.example.demo.qual.Address;
import com.example.demo.qual.Email;

public class DemoApplication {

	public static void main(String[] args) {
		// I would like to see any warning / errors based on the code below
		// currently compilation using SubtypeChecked does not work at all
		// so the code below is unfinished. just an example what my custome annotations I would like to use
		String emailAsString = "my email";
		String addressAsString = "my address";
		@Email String email = emailAsString;
		@Address String address = addressAsString;
		email = address;
	}

}
