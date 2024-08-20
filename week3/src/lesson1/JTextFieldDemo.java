package lesson1;

import javax.swing.*;
public class JTextFieldDemo extends JFrame {
   	JTextField textFN, textLN;
  
   	public JTextFieldDemo()   {
   	 	super("Input data");	 	
		JLabel l1, l2;
		JPanel jp = new JPanel();

		jp.add(l1 = new JLabel("First name:"));
		jp.add (textFN=new JTextField (10));
		jp.add(l2 = new JLabel("Last name:"));
		jp.add (textLN=new JTextField (10));
		add(jp);		

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(250, 100);     	
		setVisible(true);
  	}
	public static void main(String[] args) {  new JTextFieldDemo();  }
}
