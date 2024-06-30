package lesson2;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;

public class Lesson2 extends JFrame {
	private JTextField jTextField_header;
	private JTextArea jTextArea;
	private JButton jb;

	public Lesson2() throws HeadlessException {
		super();
		this.init();
	}

	private void init() {
		this.setTitle("Primes");
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);

		JPanel jPanel_header = new JPanel();

		jTextField_header = new JTextField(30);
		jb = new JButton("Generate");

		jPanel_header.setLayout(new GridLayout(1, 2, 20, 20));

		jPanel_header.add(jTextField_header);
		jPanel_header.add(jb);

		JPanel jPanel_fotter = new JPanel();
		jPanel_fotter.setLayout(new BorderLayout(10, 10));
		jTextArea = new JTextArea(20, 20);

		jPanel_fotter.add(jTextArea);

		this.setLayout(new BorderLayout());

		this.add(jPanel_header, BorderLayout.NORTH);
		this.add(jPanel_fotter, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setVisible(true);
	}

	public void Event() {
		jTextField_header.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}

	public static void main(String[] args) {
		new Lesson2();
	}
}
