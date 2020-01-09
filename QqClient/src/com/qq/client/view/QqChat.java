/*
 * this is the window for chatting with friends
 */

package com.qq.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QqChat extends JFrame {

	JTextArea jta;
	JTextField jtf;
	JButton jb;
	JPanel jp;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqChat qqChat = new QqChat("1");
	}
	
	public QqChat(String friend) {
		jta = new JTextArea();
		jtf = new JTextField(15);
		jb = new JButton("·¢ËÍ");
		jp = new JPanel();
		
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jta,"Center");
		this.add(jp, "South");
		this.setTitle("You are chatting with " + friend + " ");
		this.setIconImage((new ImageIcon("image/touxiang.gif").getImage()));
		this.setSize(300,200);
		this.setVisible(true);
		
	}
}
