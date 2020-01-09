/*
 * This is the control page for server,can load server and close server
 * and control the users
 */

package com.qq.server.view;

import javax.swing.*;

import com.qq.server.model.MyQqServer;

import java.awt.*;
import java.awt.event.*;

public class MyServerFrame extends JFrame implements ActionListener{

	JPanel jp1;
	JButton jb1, jb2;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyServerFrame myServerFrame = new MyServerFrame();
	}

	public MyServerFrame() {
		jp1 = new JPanel();
		jb1 = new JButton("Open server");
		jb1.addActionListener(this);
		jb2 = new JButton("Close server");
		
		jp1.add(jb1);
		jp1.add(jb2);
		
		this.add(jp1);
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jb1) {
			new MyQqServer();
		}
	}
}
