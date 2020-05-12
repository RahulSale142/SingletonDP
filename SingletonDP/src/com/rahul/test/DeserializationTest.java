package com.rahul.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.rahul.sdp.Printer;

public class DeserializationTest {

	public static void serialize(Object obj) {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("E:/stud.ser"));
			oos.writeObject(obj);
			oos.flush();
			oos.close();
			System.out.println("Object serialized");
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
			if(oos!= null)
				oos.close();
			}catch(IOException io) {
				io.printStackTrace();
			}
		}
	}
	
	public static Object deserialize() {
		ObjectInputStream ois = null;
		Object obj = null;
		try {
			ois = new ObjectInputStream(new FileInputStream("E:/stud.ser"));
			obj = ois.readObject();
			System.out.println("Deserialization done");
			return obj;
		} catch(IOException io) {
			io.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ois != null)
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return obj;
	}
	
	public static void main(String[] args) {
		
		Printer p1 = null;
		Printer p2 = null;
		//get singleton object
		p1 = Printer.getInstance();
		//perform serialization
		DeserializationTest.serialize(p1);
		
		p2 = (Printer) DeserializationTest.deserialize();
		System.out.println(p1.hashCode()+" "+p2.hashCode());
	}

}
