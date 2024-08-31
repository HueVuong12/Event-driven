package lesson3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Lesson3 extends JFrame {
	private JLabel lblTtitle, lblNhapA, lblNhapB, lblkq;
	private JTextField txtNhapA, txtNhapB, txtkq;
	private Color Foreground;
	private JRadioButton rdbCong, rdbTru, rdbNhan, rdbChia;
	ButtonGroup buttonGroup;
	private JButton btbGiai, btbXoa, btbThoat;

	public Lesson3() throws HeadlessException {
		this.init();
		this.event();
	}

	private void init() {
		this.setTitle("^_^");
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);

		JPanel jPanel_top = new JPanel();
		lblTtitle = new JLabel("Cộng trừ nhân chia");
		Font font = new Font("Arial", Font.BOLD, 30);
		lblTtitle.setFont(font);
		lblTtitle.setForeground(Color.blue);
		jPanel_top.add(lblTtitle);

		JPanel jPanel_center = new JPanel();
		lblNhapA = new JLabel("Nhập A: ");
		txtNhapA = new JTextField(30);
		lblNhapB = new JLabel("Nhập B:");
		txtNhapB = new JTextField(30);

		rdbCong = new JRadioButton("Cộng");
		rdbTru = new JRadioButton("Trừ");
		rdbNhan = new JRadioButton("Nhân");
		rdbChia = new JRadioButton("Chia");

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbCong);
		buttonGroup.add(rdbTru);
		buttonGroup.add(rdbNhan);
		buttonGroup.add(rdbChia);
		
		lblkq = new JLabel("Ket qua:");
		lblNhapA.setPreferredSize(lblkq.getPreferredSize());
		txtkq = new JTextField(30);
		txtkq.setEnabled(false);
		
		jPanel_center.setLayout(new GridLayout(7, 2, 20, 20));
		jPanel_center.setBorder(BorderFactory.createTitledBorder("Tính toán"));

		jPanel_center.add(lblNhapA);
		jPanel_center.add(txtNhapA);
		jPanel_center.add(lblNhapB);
		jPanel_center.add(txtNhapB);

		JPanel jPanel_center_new = new JPanel();

		jPanel_center_new.add(rdbCong);
		jPanel_center_new.add(rdbTru);
		jPanel_center_new.add(rdbNhan);
		jPanel_center_new.add(rdbChia);

		jPanel_center_new.setBorder(BorderFactory.createTitledBorder("Phép toán"));

		jPanel_center.add(jPanel_center_new);

		this.setLayout(new BorderLayout());
		jPanel_center_new.setLayout(new GridLayout(2, 2));
		jPanel_center.add(lblkq);
		jPanel_center.add(txtkq);

		JPanel jPanel_left = new JPanel();
		jPanel_left.setBorder(BorderFactory.createTitledBorder("Chọn tác vụ"));
		jPanel_left.setLayout(new GridLayout(3, 1));
		btbGiai = new JButton("Giai");
		btbXoa = new JButton("Xoa");
		btbThoat = new JButton("Thoat");

		jPanel_left.add(btbGiai);
		jPanel_left.add(btbXoa);
		jPanel_left.add(btbThoat);
		JPanel jPanel_footer = new JPanel();
		jPanel_footer.setPreferredSize(new Dimension(0, 30));
		jPanel_footer.setBackground(Color.pink);
		JPanel jPanel_footer1 = new JPanel();
		jPanel_footer1.setBackground(Color.BLUE);
		jPanel_footer.add(jPanel_footer1);
		JPanel jPanel_footer2 = new JPanel();
		jPanel_footer2.setBackground(Color.RED);
		jPanel_footer.add(jPanel_footer2);
		JPanel jPanel_footer3 = new JPanel();
		jPanel_footer3.setBackground(Color.YELLOW);
		jPanel_footer.add(jPanel_footer3);
		this.add(jPanel_top, BorderLayout.NORTH);
		this.add(jPanel_center, BorderLayout.CENTER);
		this.add(jPanel_left, BorderLayout.WEST);
		this.add(jPanel_footer, BorderLayout.SOUTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void event() {
		btbGiai.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (rdbCong.isSelected()) {
						double a = Double.parseDouble(txtNhapA.getText());
						double b = Double.parseDouble(txtNhapB.getText());
						double kq = a + b;
						txtkq.setText(kq + "");
					} else if (rdbTru.isSelected()) {
						double a = Double.parseDouble(txtNhapA.getText());
						Double b = Double.parseDouble(txtNhapB.getText());
						double kq = a - b;
						txtkq.setText(kq + "");
					} else if (rdbNhan.isSelected()) {
						double a = Double.parseDouble(txtNhapA.getText());
						Double b = Double.parseDouble(txtNhapB.getText());
						double kq = a * b;
						txtkq.setText(kq + "");
					} else if (rdbChia.isSelected()) {
						double a = Double.parseDouble(txtNhapA.getText());
						Double b = Double.parseDouble(txtNhapB.getText());
						double kq = a / b;
						txtkq.setText(kq + "");
					}

				} catch (Exception e2) {
				}
			}
		});
		btbXoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtNhapA.setText("");
				txtNhapB.setText("");
				txtkq.setText("");
				buttonGroup.clearSelection();
			}
		});
		btbThoat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

	public static void main(String[] args) {
		new Lesson3();
	}
}
