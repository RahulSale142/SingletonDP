package com.rahul.test;

import java.lang.reflect.Constructor;

import com.rahul.sdp.Printer;

public class ReflectionApiTest {

	public static void main(String[] args) {
		Printer p1 = null, p2 = null;
		//get printer class object
		p1 = Printer.getInstance();
		//load the Printer class
		try {
			Class clazz = Class.forName("com.rahul.sdp.Printer");
			//get all constructor
			Constructor[] cons = clazz.getDeclaredConstructors();
			//load the private constructor
			//get access to private constructor
			cons[0].setAccessible(true);
			p2 = (Printer) cons[0].newInstance();
			System.out.println("p1 : "+p1.hashCode()+" p2 : "+p2.hashCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
