package com.rahul.test;

import com.rahul.sdp.TicketBookingServlet;

public class MultithreadingSIngletonTest2 {

	public static void main(String[] args) {
		TicketBookingServlet servlet = null;
		Thread req1 = null;
		Thread req2 = null;
		
		servlet = new TicketBookingServlet();
		req1 = new Thread(servlet);
		req2 = new Thread(servlet);
		
		req1.start();
		req2.start();
	}

}
