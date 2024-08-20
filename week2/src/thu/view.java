package thu;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class view extends JFrame {
	private JTextField txtMaNV, txtHo, txtTen, txtTuoi, txtLuong, txtPhai, txtTim;
	private Color foreground;
	private JRadioButton radioNam, radioNu;
	private JTable tblNV;
	DefaultTableModel model;
	private JButton btnThem, btnXoaTrang, btnXoa, btnLuu, btnTim;
	public view() throws HeadlessException {
		this.init();
	}

	public void init() {
		Font font = new Font("Arial", Font.BOLD, 30);

		JLabel lblTitle = new JLabel("Thông tin nhân viên");
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.blue);

		JLabel lblMaNV = new JLabel("Mã nhân viên");
		JLabel lblHo = new JLabel("Họ");
		lblHo.setPreferredSize(lblMaNV.getPreferredSize());
		JLabel lblTen = new JLabel("Tên nhân viên");
		JLabel lblTuoi = new JLabel("Tuổi");
		lblTuoi.setPreferredSize(lblMaNV.getPreferredSize());
		JLabel lblPhai = new JLabel("Phái");
		JLabel lblTienLuong = new JLabel("Tiền Lương");
		lblTienLuong.setPreferredSize(lblMaNV.getPreferredSize());
		JLabel lblTim = new JLabel("Nhập mã số cần tìm");
		
		txtMaNV = new JTextField();
		txtHo = new JTextField();
		txtTen = new JTextField();
		txtTuoi = new JTextField();
		txtLuong = new JTextField();
		txtTim = new JTextField();
		
		ButtonGroup btg = new ButtonGroup();

		radioNam = new JRadioButton("Nam");
		radioNu = new JRadioButton("Nữ");

		btg.add(radioNam);
		btg.add(radioNu);
//
		Box b = new Box(BoxLayout.Y_AXIS);
		Box b1 = new Box(BoxLayout.X_AXIS);
		Box b2 = new Box(BoxLayout.X_AXIS);
		Box b3 = new Box(BoxLayout.X_AXIS);
		Box b4 = new Box(BoxLayout.X_AXIS);
//
		b1.add(lblMaNV);
		b1.add(txtMaNV);
		b2.add(lblHo);
		b2.add(txtHo);
		b2.add(lblTen);
		b2.add(txtTen);
		b3.add(lblTuoi);
		b3.add(txtTuoi);
		b3.add(lblPhai);
		b3.add(radioNam);
		b3.add(radioNu);
		b4.add(lblTienLuong);
		b4.add(txtLuong);
//
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

		
		JPanel JPanel_Tim = new JPanel();
		JPanel_Tim.setLayout(new FlowLayout());
		JPanel jPanel_ChucNang = new JPanel();
		jPanel_ChucNang.setLayout(new FlowLayout());
		JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,JPanel_Tim, jPanel_ChucNang);

		btnTim = new JButton("Tìm");
		btnThem = new JButton("Thêm");
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoa = new JButton("Xóa");
		btnLuu = new JButton("Lưu");

		JPanel_Tim.add(lblTim);
		JPanel_Tim.add(txtTim);
		JPanel_Tim.add(btnTim);
		jPanel_ChucNang.add(btnThem);
		jPanel_ChucNang.add(btnXoaTrang);
		jPanel_ChucNang.add(btnXoa);
		jPanel_ChucNang.add(btnLuu);

		this.setTitle("^-^");
		this.setSize(700, 700);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		this.setLayout(new BorderLayout());
		this.add(b, BorderLayout.NORTH);
		this.add(jSplitPane, BorderLayout.SOUTH);
		
		taoBang();
	}

	public void taoBang() {
		JPanel jPanel_center = new JPanel();
		model = new DefaultTableModel();
		tblNV = new JTable(model);
		model.addColumn("Mã NV ");
		model.addColumn("Họ");
		model.addColumn("Tên ");
		model.addColumn("Phái ");
		model.addColumn("Tuổi");
		model.addColumn("Tiền lương");
		JScrollPane pane = new JScrollPane(tblNV, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");

		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		TableColumn tableColumn = tblNV.getColumnModel().getColumn(3);

		cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);

		this.add(pane, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new view();
	}
}
