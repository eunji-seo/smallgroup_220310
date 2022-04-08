package com.smallgroup.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256 {

	 public String encrypt(String text)  {
	        MessageDigest md = null;
			try {
				md = MessageDigest.getInstance("SHA-256");
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        md.update(text.getBytes());

	        return bytesToHex(md.digest());
	    }

	    private String bytesToHex(byte[] bytes) {
	        StringBuilder builder = new StringBuilder();
	        for (byte b : bytes) {
	            builder.append(String.format("%02x", b));
	        }
	        return builder.toString();
	    }
	    public static void main(String[] args) {
	    	SHA256 s = new SHA256();
	    	System.out.println(s.encrypt("1"));
		}

}
