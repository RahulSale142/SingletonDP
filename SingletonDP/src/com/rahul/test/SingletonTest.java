package com.rahul.test;

import com.rahul.sdp.Printer;

public class SingletonTest {

	public static void main(String[] args) {
		Printer p1 = null, p2 = null;
		//p1 = new Printer();
		p1 = Printer.getInstance();
		p2 = Printer.getInstance();
		System.out.println("p1.hashCode : "+ p1.hashCode()+" P2.hashCode :"+p2.hashCode());
		System.out.println("(p1 == p2 ?)"+ (p1 == p2));
		p1.printData("hi");
		p2.printData("by");
		
		try {
			Class.forName("com.rahul.sdp.Printer");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
