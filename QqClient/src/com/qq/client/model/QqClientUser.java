// this is a login check

package com.qq.client.model;


import java.net.Socket;

import com.qq.common.*;

public class QqClientUser {

	public boolean checkUser(User u) {
		
		return new QqClientConServer().SendLoginInfoToServer(u);
	
	}
}
