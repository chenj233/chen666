/** 
 * function: qq client login page
 */
package com.qq.client.view;

import javax.swing.*;

import com.qq.client.model.QqClientUser;
import com.qq.common.User;

import java.awt.*;
import java.awt.event.*;
public class QqClientLogin extends JFrame implements ActionListener {

	// North part
	
	JLabel jbl1;
	
	// Middle part
	// middle part has 3 JPanel, operated by choice section
	JTabbedPane jtp;
	JPanel jp2,jp3,jp4;
	JLabel jp2_jbl1,jp2_jbl2,jp2_jbl3,jp2_jbl4;
	JButton jp2_jbl;
	JTextField jp2_jtf;
	JPasswordField jp2_jpf;
	JCheckBox jp2_jcb1,jp2_jcb2;
	

	
	// South part
	
	JPanel jp1;
	JButton jp1_jb1,jp1_jb2,jp1_jb3;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqClientLogin qqClientLogin = new QqClientLogin();
	}
	
	public QqClientLogin() {
		
		// North part first
		jbl1 = new JLabel(new ImageIcon("image/dingbu.jpg"));
		
		// middle part
		jp2 = new JPanel(new GridLayout(3,3));
		
		jp2_jbl1 = new JLabel("qqºÅÂë",JLabel.CENTER);
		jp2_jbl2 = new JLabel("qqÃÜÂë",JLabel.CENTER);
		jp2_jbl3 = new JLabel("Íü¼ÇÃÜÂë",JLabel.CENTER);
		jp2_jbl4 = new JLabel("ÉêÇëÃÜÂë±£»¤",JLabel.CENTER);
		
		jp2_jbl3.setForeground(Color.blue);
		
		jp2_jbl = new JButton(new ImageIcon("Çå³ýºÅÂë"));
		jp2_jtf = new JTextField();
		jp2_jpf = new JPasswordField();
		jp2_jcb1 = new JCheckBox("ÒþÉíµÇÂ¼");
		jp2_jcb2 = new JCheckBox("¼Ç×¡ÃÜÂë");
		
		// add above to jp2
		
		jp2.add(jp2_jbl1);
		jp2.add(jp2_jtf);
		jp2.add(jp2_jbl);
		jp2.add(jp2_jbl2);
		jp2.add(jp2_jpf);
		jp2.add(jp2_jbl3);
		jp2.add(jp2_jcb1);
		jp2.add(jp2_jcb2);
		jp2.add(jp2_jbl4);
		
		//create choice section
		jtp = new JTabbedPane();
		jtp.add("QQºÅÂë", jp2);
		jp3 = new JPanel();
		jtp.add("ÊÖ»úºÅÂë", jp3);
		jp4 = new JPanel();
		jtp.add("µç×ÓÓÊ¼þ", jp4);
		
		
		// then South part
		jp1 = new JPanel();
		jp1_jb1 = new JButton(new ImageIcon("image/denglu.jpg"));
		// receive request from user
		jp1_jb1.addActionListener(this);
		
		jp1_jb2 = new JButton(new ImageIcon("image/quxiao.jpg"));
		jp1_jb3 = new JButton(new ImageIcon("image/zhuce.jpg"));
		
		// put 3 buttons in jp1
		
		jp1.add(jp1_jb1);
		jp1.add(jp1_jb2);
		jp1.add(jp1_jb3);
		
		
		this.add(jbl1, "North");
		this.add(jtp,"Center");
		this.add(jp1, "South");
		this.setSize(270, 61);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}


	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// if user clicked login
		if (e.getSource() == jp1_jb1) {
			QqClientUser qqClientUser = new QqClientUser();
			User u = new User();
			u.setUserId(jp2_jtf.getText().trim());
			u.setPassWord(new String(jp2_jpf.getPassword()));
			
			if(qqClientUser.checkUser(u)) {
				new QqFriendList();
				// close login page
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(this,"UserId or Password is wrong");
			}
			
		}
	}
}
