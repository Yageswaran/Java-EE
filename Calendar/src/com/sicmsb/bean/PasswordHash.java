package com.sicmsb.bean;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHash 
{
//    public static void main(String[] args)throws Exception
//    {
//    	String password = "test123";
//        String sha =  hash(password);
//        System.out.println(sha);
//
//    }
    
    public static String hash(String password) throws Exception{
    	
    	MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
 
        byte byteData[] = md.digest();
 
        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
    	return sb.toString();
    }
}