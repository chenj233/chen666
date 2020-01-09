/*
 * this is the back-end that connect server
 */
package com.qq.client.model;

import java.util.*;
import com.qq.common.*;


import java.net.*;
import java.io.*;
public class QqClientConServer {

	
		
		// send first request
		
		public boolean SendLoginInfoToServer(Object o) {
			
			boolean b = false;
			try {
				System.out.println("kk");
				Socket s = new Socket("10.24.108.125",9999);
				ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
				oos.writeObject(o);
				
				ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
				
				Message ms = (Message)ois.readObject();
				if(ms.getMesType().contentEquals("1")) {
					b = true;
				} 
			} 	catch(Exception e){
					e.printStackTrace();
			} 	finally {
				
			}
			return b;
		}
	
	
}
