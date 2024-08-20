package lesson1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class View extends JFrame implements ActionListener, MouseListener {
	private JLabel lblTitle;
	private JLabel lblMaNV, lblHo, lblTenNV, lblTuoi, lblLuong, lblPhai, lblMaTim;
	private Color foreground;
	private JTextField txtMaNV, txtHo, txtTuoi, txtLuong, txtTen, txtMaTim;
	private JRadioButton radioNam, radioNu;
	DefaultTableModel model;
	private JTable tblNV;
	private JButton btnThem, btnXoaTrang, btnXoa, btnLuu, btnTim;
	private List<NhanVien> dsNV;

	public View() throws HeadlessException {
		this.gui();
	}

	public void gui() {
		dsNV = new ArrayList<NhanVien>();
		Font font = new Font("Arial", Font.BOLD, 30);

		lblTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblTitle.setFont(font);

		JPanel jPanel_top = new JPanel();
		lblTitle.setForeground(Color.blue);

		lblMaNV = new JLabel("Mã nhân viên:");
		lblHo = new JLabel("Họ:");
		lblHo.setPreferredSize(lblMaNV.getPreferredSize());
		lblTenNV = new JLabel("Tên nhân viên:");
		lblTuoi = new JLabel("Tuổi:");
		lblTuoi.setPreferredSize(lblMaNV.getPreferredSize());
		lblPhai = new JLabel("Phái:");
		lblLuong = new JLabel("Tiền lương:");
		lblLuong.setPreferredSize(lblMaNV.getPreferredSize());
		lblMaTim = new JLabel("Nhập mã số cần tìm");

		txtMaNV = new JTextField();
		txtHo = new JTextField();
		txtTen = new JTextField();
		txtTuoi = new JTextField();
		txtLuong = new JTextField();
		txtMaTim = new JTextField(9);

		ButtonGroup buttonGroup = new ButtonGroup();

		radioNam = new JRadioButton("Nam");
		radioNu = new JRadioButton("Nữ");

		buttonGroup.add(radioNam);
		buttonGroup.add(radioNu);

		Box b = new Box(BoxLayout.Y_AXIS);
		Box b1 = new Box(BoxLayout.X_AXIS);
		Box b2 = new Box(BoxLayout.X_AXIS);
		Box b3 = new Box(BoxLayout.X_AXIS);
		Box b4 = new Box(BoxLayout.X_AXIS);

		b1.add(lblMaNV);
		b1.add(txtMaNV);
		b2.add(lblHo);
		b2.add(txtHo);
		b2.add(lblTenNV);
		b2.add(txtTen);
		b3.add(lblTuoi);
		b3.add(txtTuoi);
		b3.add(lblPhai);
		b3.add(radioNam);
		b3.add(radioNu);
		b4.add(lblLuong);
		b4.add(txtLuong);

		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b.add(lblTitle);
		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b.add(b1);
		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b.add(b2);
		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b.add(b3);
		b.add(Box.createRigidArea(new Dimension(10, 10)));
		b.add(b4);
		b.add(Box.createRigidArea(new Dimension(10, 10)));

		this.setLayout(new BorderLayout());

		btnTim = new JButton("Tìm");
		btnThem = new JButton("Thêm");
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoa = new JButton("Xóa");
		btnLuu = new JButton("Lưu");

		JPanel jPanel_footer = new JPanel();
		JSplitPane jSplitPane;
		JPanel jPanel_TimKiem = new JPanel();
		jPanel_TimKiem.setLayout(new FlowLayout());
		JPanel jPanel_ChucNang = new JPanel();
		jPanel_ChucNang.setLayout(new FlowLayout());

		jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jPanel_TimKiem, jPanel_ChucNang);

//		jPanel_TimKiem.setLayout(new FlowLayout());
//		jPanel_ChucNang.setLayout(new FlowLayout());
		jPanel_TimKiem.add(lblMaTim);
		jPanel_TimKiem.add(txtMaTim);
		jPanel_TimKiem.add(btnTim);

		jPanel_ChucNang.add(btnThem);
		jPanel_ChucNang.add(btnXoaTrang);
		jPanel_ChucNang.add(btnXoa);
		jPanel_ChucNang.add(btnLuu);

		Border cnborder = BorderFactory.createLineBorder(Color.gray);

		this.setTitle("^-^");
		this.setSize(700, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		this.add(b, BorderLayout.NORTH);
		this.add(jSplitPane, BorderLayout.SOUTH);

		btnThem.addActionListener(this);
		btnLuu.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		radioNam.addActionListener(this);
		radioNu.addActionListener(this);

		taobang();
		btnThem.addActionListener(new ActionListener() {
//tìm hiểu thêm về chỗ này
//			
//			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtHo.getText().equals("") || txtMaNV.getText().equals("") || txtTen.getText().equals("")
						|| txtTuoi.getText().equals("") || txtLuong.getText().equals("")
						|| (!radioNam.isSelected() && !radioNu.isSelected())) {
					JOptionPane.showMessageDialog(btnThem, "Vui lòng nhập đủ dữ liệu", "Thông báo",
							JOptionPane.ERROR_MESSAGE);
				} else {
					String[] src = new String[6];
					src[0] = txtMaNV.getText();
					src[1] = txtHo.getText();
					src[2] = txtTen.getText();
//					
					if (radioNam.isSelected())
						src[3] = "Nam";
					else if (radioNu.isSelected())
						src[3] = "Nữ";
//					
					src[4] = txtTuoi.getText();
					src[5] = txtLuong.getText();

//					if(!dsNV.themnv)
					model.addRow(src);

//					String maNV, String hoNV, String tenNV, String phai, int tuoi, double luong
					String maNV = txtMaNV.getText();
					String maHo = txtHo.getText();

					String maTen = txtTen.getText();
					String phai = "Nu";
//					chuyển từ string sang int
					int maTuoi = Integer.parseInt(txtTuoi.getText());
					Double Luong = Double.parseDouble(txtLuong.getText());

					NhanVien nv = new NhanVien(maNV, maHo, maTen, phai, maTuoi, Luong);
					dsNV.add(nv);
				}
			}
		});
//		btnXoaTrang.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				txtMaNV.setText("");
//				txtHo.setText("");
//				txtTen.setText("");
//				txtTuoi.setText("");
//				txtLuong.setText("");
//			}
//		});

//		btnXoa.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				if (tblNV.getSelectedRow() == -1) {
//					JOptionPane.showMessageDialog(btnXoa, "Vui lòng chọn dòng để xóa", "Thông báo",
//							JOptionPane.INFORMATION_MESSAGE);
//				} else {
//					if (JOptionPane.showConfirmDialog(btnXoa, "Bạn có chắc chắn không", "Thông báo",
//							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
//						model.removeRow(tblNV.getSelectedRow());
//				}
//			}
//		});

		btnLuu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

//		tìm hiểu thêm về chỗ này
//		
//		
		btnTim.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String maCanTim = txtMaTim.getText();
				boolean found = false;
				for (NhanVien nv : dsNV) {
					if (maCanTim.equals(nv.getMaNV())) {
						int i = dsNV.indexOf(nv);
						JOptionPane.showMessageDialog(btnTim, "Đã tìm thấy tại vị trí " + i);
						tblNV.setRowSelectionInterval(i, i);
						found = true;
						break;
					}
					
				}
				if (!found) {
					JOptionPane.showMessageDialog(btnTim, "Không tìm thấy");
				}
				
			}
		});
	}

	public void taobang() {
		JPanel jPanel_tb = new JPanel();

		model = new DefaultTableModel();
		tblNV = new JTable(model);
		model.addColumn("Mã NV");
		model.addColumn("Họ");
		model.addColumn("Tên");
		model.addColumn("Phái");
		model.addColumn("Tuổi");
		model.addColumn("Tiền Lương");

		JScrollPane sp = new JScrollPane(tblNV, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");

		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		TableColumn tableColumn = tblNV.getColumnModel().getColumn(3);

		cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

		this.add(sp, BorderLayout.CENTER);

	}

	public static void main(String[] args) {
		new View();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
//			String ma = txtMaNV.getText();
//			String ho = txtHo.getText();
//			String ten = txtTen.getText();
//			int tuoi = Integer.parseInt(txtTuoi.getText());
////			boolean phai = radioNu.isSelected();
//			double luong = Double.parseDouble(txtLuong.getText());

//			NhanVien nv = new NhanVien(ma, ho, ten, tuoi, luong);

//			if (txtHo.getText().equals("") || txtMaNV.getText().equals("") || txtTen.getText().equals("")
//					|| txtTuoi.getText().equals("") || txtLuong.getText().equals("")) {
//				JOptionPane.showMessageDialog(btnThem, "Vui lòng nhập đủ dữ liệu", "Thông báo",
//						JOptionPane.ERROR_MESSAGE);
//			} else {
//				String[] src = new String[6];
//				src[0] = txtMaNV.getText();
//				src[1] = txtHo.getText();
//				src[2] = txtTen.getText();
////				src[3] = 
//				src[4] = txtTuoi.getText();
//				src[5] = txtLuong.getText();
//
//				model.addRow(src);
////				model.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getTuoi(), nv.getLuong() });
//			}
		} else if (o.equals(btnXoa)) {
			if (tblNV.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(btnXoa, "Vui lòng chọn dòng để xóa", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				if (JOptionPane.showConfirmDialog(btnXoa, "Bạn có chắc chắn không", "Thông báo",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
					model.removeRow(tblNV.getSelectedRow());
			}
		} else if (o.equals(btnXoaTrang)) {
			txtMaNV.setText("");
			txtHo.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
			txtLuong.setText("");
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
//		int row = table.gets
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

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
