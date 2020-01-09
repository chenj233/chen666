/*
 * this is the real server, it's waiting for connection
 */

package com.qq.server.model;
import com.qq.common.*;
import java.net.*;
import java.io.*;
import java.util.*;
public class MyQqServer {

	public MyQqServer() {
		
		try {
			// listening in 9999
			System.out.println("I am the server, listening in 9999");
			ServerSocket ss = new ServerSocket(9999);
			// waiting for connection
			Socket s = ss.accept();
			
			//receive message from client
			
			ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
			User u = (User)ois.readObject();
			System.out.println("Server receive UserId: " + u.getUserId() + " password: "+ u.getPassWord());
			Message m = new Message();
			if(u.getPassWord().equals("123456")) {
				// return login successfully
				m.setMesType("1");
			}else {
				m.setMesType("2");
			}
			ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(m);
			
			
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			
		}
		
	}

}
