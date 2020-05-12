package com.rahul.sdp;

import java.io.Serializable;

import com.rahul.commons.CommonUtils;

public class Printer extends CommonUtils {
	// private static Printer INSTANCE = new Printer(); //(eager instantiation bad
	// practice)
	private static Printer INSTANCE1;
	private static final long serialVersionUID = 14242L;
	private static boolean flag = false;
	/*
	 * static { INSTANCE = new Printer(); }
	 * 
	 * public static Printer getInstance() { return INSTANCE; // eager instantiation
	 * }
	 */

	private Printer() {
		
		if(flag == true)
			throw new IllegalArgumentException("Object already created.");
		flag = true;
		System.out.println("Printer.Printer()");
	}

	public void printData(String data) {
		System.out.println(data);
	}

	/*
	 * public static Printer getInstance() { return INSTANCE; }
	 */
	/*
	 * public synchronized static Printer getInstance() { if (INSTANCE == null) {
	 * INSTANCE = new Printer(); // lazy instantiation good practice. } return
	 * INSTANCE; }
	 */

	public static Printer getInstance() {
		if (INSTANCE1 == null) {    // 1st null check
			synchronized (Printer.class) {
				if (INSTANCE1 == null) {  //2nd null check
					INSTANCE1 = new Printer(); // lazy instantiation good practice.
				}// if
			}// synchronized
		}//if
		return INSTANCE1;
	}// method

	//solving cloning problem of singleton(recommended)
	
	@Override
	public Object clone()throws CloneNotSupportedException{
		throw new CloneNotSupportedException("Cloning is not allowed on this singleton class");
	}
	
	//solving cloning problem of singleton( not recommended)
	
		/*@Override
		public Object clone()throws CloneNotSupportedException{
			return this.INSTANCE;
		}*/
	
	//solving deserialization problem
	public Object readResolve() {
		System.out.println("Printer.readResolve()");
		return INSTANCE1;
	}
	
	
}