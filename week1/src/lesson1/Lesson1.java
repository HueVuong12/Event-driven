package lesson1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.JobAttributes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Lesson1 extends JFrame {
	private JTextField jTextFieldA;
	private JTextField jTextFieldB;
	private JTextField jTextFieldC;
	private JTextField jTextFieldanswer;
	private Color background;
	private JButton jbHandle, jbDelete, jbExit;

	public Lesson1() throws HeadlessException {
		this.init();
		this.event();
	}

	private void init() {
		this.setTitle("^_^");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);

		Font font = new Font("Arial", Font.BOLD, 30);
		Font font_IP = new Font("Arial", Font.BOLD, 20);

		JPanel jPanel_header = new JPanel();
		JLabel jLabel_header = new JLabel("GIẢI PHƯƠNG TRÌNH BẬC HAI", JLabel.CENTER);

		jPanel_header.add(jLabel_header);
		jLabel_header.setFont(font);
		jPanel_header.setBackground(Color.cyan);
		JPanel jPanel_content_ = new JPanel();

		JLabel jLabel_A = new JLabel("Nhập a:", JLabel.CENTER);
		jLabel_A.setFont(font_IP);
		jTextFieldA = new JTextField(50);
		
		JLabel jLabel_B = new JLabel("Nhập b:", JLabel.CENTER);
		jLabel_B.setFont(font_IP);
		jTextFieldB = new JTextField(50);

		JLabel jLabel_C = new JLabel("Nhập c:", JLabel.CENTER);
		jLabel_C.setFont(font_IP);
		jTextFieldC = new JTextField(50);

		JLabel jLabel_answer = new JLabel("Kết quả:", JLabel.CENTER);
		jLabel_answer.setFont(font_IP);
		jTextFieldanswer = new JTextField(50);
		jTextFieldanswer.setEnabled(false);
		
		jPanel_content_.setLayout(new GridLayout(4, 2, 20, 20));

		jPanel_content_.add(jLabel_A);
		jPanel_content_.add(jTextFieldA);
		jPanel_content_.add(jLabel_B);
		jPanel_content_.add(jTextFieldB);
		jPanel_content_.add(jLabel_C);
		jPanel_content_.add(jTextFieldC);
		jPanel_content_.add(jLabel_answer);
		jPanel_content_.add(jTextFieldanswer);

		JPanel jPanel_fotter = new JPanel();

		jPanel_fotter.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));

		jbHandle = new JButton("Giải");
		jbDelete = new JButton("Xóa rỗng");
		jbExit = new JButton("Thoát");

		jPanel_fotter.add(jbHandle);
		jPanel_fotter.add(jbDelete);
		jPanel_fotter.add(jbExit);

		this.setLayout(new BorderLayout(20, 20));

		this.add(jPanel_header, BorderLayout.NORTH);
		this.add(jPanel_content_, BorderLayout.CENTER);
		this.add(jPanel_fotter, BorderLayout.SOUTH);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new Lesson1();
	}

	public void event() {
		jbHandle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double a = Double.parseDouble(jTextFieldA.getText());
					double b = Double.parseDouble(jTextFieldB.getText());
					double c = Double.parseDouble(jTextFieldC.getText());
					double x1, x2;

					double delta = b * b - 4 * a * c;
					if (delta < 0) {
						jTextFieldanswer.setText("Phương trình vô nghiệm");
					} else if (delta == 0) {
						x1 = -b / (2 * a);
						jTextFieldanswer.setText("Phương trình có nghiệm kép x1 = x2 = " + x1);
					} else {
						x1 = (-b - Math.sqrt(delta)) / (2 * a);
						x2 = (-b + Math.sqrt(delta)) / (2 * a);
						jTextFieldanswer.setText("x1 = " + x1 + " và x2 = " + x2);
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Không hợp lệ", "Thông báo", JOptionPane.ERROR_MESSAGE);
				}
			}
		});

//		cách 1

		jbDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jTextFieldA.setText("");
				jTextFieldB.setText("");
				jTextFieldC.setText("");
				jTextFieldanswer.setText("");
			}
		});

//		cách 2

//		jbDelete.addMouseListener(new MouseListener() {
//		
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void mousePressed(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void mouseExited(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void mouseEntered(MouseEvent e) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//		@Override
//		public void mouseClicked(MouseEvent e) {
//			jTextFieldA.setText("");
//			jTextFieldB.setText("");
//			jTextFieldC.setText("");
//			jTextFieldanswer.setText("");
//
//		}
//	});

//		cách 1

		jbExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});

//		cách 2
//		jbExit.addMouseListener(new MouseListener() {
//			@Override
////			được gọi khi chuột nhả ra trên một thành phần
//			public void mouseReleased(MouseEvent e) {
//
//			}
//
////			được triệu hồi khi nút chuột được nhấn trên 1 thành phần
//			@Override
//			public void mousePressed(MouseEvent e) {
//
//			}
//
////			được gọi khi chuột thoát ra khỏi thành phần đấy
//			@Override
//			public void mouseExited(MouseEvent e) {
//
//			}
////			được gọi khi chuột nhập vào một thành phần
//
//			@Override
//			public void mouseEntered(MouseEvent e) {
//
//			}
//
////			Được triệu hồi khi nút chuột đc click
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				System.exit(1);
//			}
//		});

	}
}
