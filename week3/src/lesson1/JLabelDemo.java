package lesson1;

import javax.swing.*;
public  class JLabelDemo extends JFrame  {
	public JLabelDemo()  {
		super("Panel on a Frame");
		JLabel l1, l2;
		l1 = new JLabel("User Name: ", new ImageIcon("blue-ball.gif"), 					SwingConstants.CENTER);
		l2 = new JLabel("Password: ");
		JPanel jp = new JPanel();
		jp.add(l1);
		jp.add(l2);
		add(jp);
		setSize(400, 400);
		setVisible(true);			
	}	
	public static void main(String args[]){
		new JLabelDemo();
	}
}

