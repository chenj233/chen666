/**
 * my friend list(include unknowns and blacklist)
 */
package com.qq.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class QqFriendList extends JFrame implements ActionListener, MouseListener {

	// first card

	JPanel jphy1, jphy2, jphy3;
	JButton jphy_jb1, jphy_jb2, jphy_jb3;
	JScrollPane jsp1;

	// Second card

	JPanel jpms1, jpms2, jpms3;
	JButton jpms_jb1, jpms_jb2, jpms_jb3;
	JScrollPane jsp2;

	// Third card

	JPanel jpbl1, jpbl2, jpbl3;
	JButton jpbl_jb1, jpbl_jb2, jpbl_jb3;
	JScrollPane jsp3;

	// set the whole jframe as cardlayout
	CardLayout cl;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QqFriendList qqFriendList = new QqFriendList();
	}

	public QqFriendList() {

		// first card(Friend list)
		jphy_jb1 = new JButton("我的好友");
		jphy_jb2 = new JButton("陌生人");
		jphy_jb2.addActionListener(this);
		jphy_jb3 = new JButton("黑名单");
		jphy_jb3.addActionListener(this);

		jphy1 = new JPanel(new BorderLayout());
		// 50 friends
		jphy2 = new JPanel(new GridLayout(50, 1, 4, 4));

		// put 50 friends in jphy2
		JLabel[] jbls = new JLabel[50];

		for (int i = 0; i < jbls.length; i++) {
			jbls[i] = new JLabel(i + 1 + "", new ImageIcon("image/touxiang.gif"), JLabel.LEFT);
			jbls[i].addMouseListener(this);
			jphy2.add(jbls[i]);
		}
		// bottom
		jphy3 = new JPanel(new GridLayout(2, 1));
		// add 2 buttons in jphy3
		jphy3.add(jphy_jb2);
		jphy3.add(jphy_jb3);

		jsp1 = new JScrollPane(jphy2);

		// put everything in layout jphy1
		jphy1.add(jphy_jb1, "North");
		jphy1.add(jsp1, "Center");
		jphy1.add(jphy3, "South");

		// do second part

		jpms_jb1 = new JButton("我的好友");
		jpms_jb1.addActionListener(this);
		jpms_jb2 = new JButton("陌生人");
		jpms_jb3 = new JButton("黑名单");
		jpms_jb3.addActionListener(this);

		// second card(mosheng list)
		jpms1 = new JPanel(new BorderLayout());
		// 20 mosheng
		jpms2 = new JPanel(new GridLayout(20, 1, 4, 4));

		// put 20 moshengs in jphy2
		JLabel[] jbls2 = new JLabel[20];

		for (int i = 0; i < jbls2.length; i++) {
			jbls2[i] = new JLabel(i + 1 + "", new ImageIcon("image/touxiang.gif"), JLabel.LEFT);
			jbls2[i].addMouseListener(this);
			jpms2.add(jbls2[i]);
		}
		// top
		jpms3 = new JPanel(new GridLayout(2, 1));
		// add 2 buttons in jpms3
		jpms3.add(jpms_jb1);
		jpms3.add(jpms_jb2);

		jsp2 = new JScrollPane(jpms2);

		// put everything in layout jpms1
		jpms1.add(jpms3, "North");
		jpms1.add(jsp2, "Center");
		jpms1.add(jpms_jb3, "South");

		// do third part

		jpbl_jb1 = new JButton("我的好友");
		jpbl_jb1.addActionListener(this);
		jpbl_jb2 = new JButton("陌生人");
		jpbl_jb2.addActionListener(this);
		jpbl_jb3 = new JButton("黑名单");

		// third card(black list)
		jpbl1 = new JPanel(new BorderLayout());
		// 15 black list
		jpbl2 = new JPanel(new GridLayout(15, 1, 4, 4));

		// put 15 blacklist in jpbl2
		JLabel[] jbls3 = new JLabel[15];

		for (int i = 0; i < jbls3.length; i++) {
			jbls3[i] = new JLabel(i + 1 + "", new ImageIcon("image/touxiang.gif"), JLabel.LEFT);
			jbls3[i].addMouseListener(this);
			jpbl2.add(jbls3[i]);
		}

		// top
		jpbl3 = new JPanel(new GridLayout(3, 1));

		// add 3 buttons in jpbl3
		jpbl3.add(jpbl_jb1);
		jpbl3.add(jpbl_jb2);
		jpbl3.add(jpbl_jb3);

		jsp3 = new JScrollPane(jpbl2);

		// put everything in layout jpbl1
		jpbl1.add(jpbl3, "North");
		jpbl1.add(jsp3, "Center");

		cl = new CardLayout();
		this.setLayout(cl);
		this.add(jphy1, "1");
		this.add(jpms1, "2");
		this.add(jpbl1, "3");

		this.setSize(140, 400);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		// if user clicks mosheng button, then show second card
		if (e.getSource() == jphy_jb2) {
			cl.show(this.getContentPane(), "2");
		} else if (e.getSource() == jphy_jb3) {
			cl.show(this.getContentPane(), "3");
		} else if (e.getSource() == jpms_jb1) {
			cl.show(this.getContentPane(), "1");
		} else if (e.getSource() == jpms_jb3) {
			cl.show(this.getContentPane(), "3");
		} else if (e.getSource() == jpbl_jb1) {
			cl.show(this.getContentPane(), "1");
		} else if (e.getSource() == jpbl_jb2) {
			cl.show(this.getContentPane(), "2");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		// double clicked and get friends' No.
		if (e.getClickCount() == 2) {
			// get this friend's No.
			String friendNo = ((JLabel) e.getSource()).getText();
			//System.out.println("You want to chat with " + friendNo);
			new QqChat(friendNo);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl = (JLabel) e.getSource();
		jl.setForeground(Color.red);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel jl = (JLabel) e.getSource();
		jl.setForeground(Color.black);
	}

}
