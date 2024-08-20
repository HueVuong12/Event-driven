package lesson1;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DSNhanVien implements Serializable {
	private ArrayList<NhanVien> dsNV;

	public DSNhanVien() {
		dsNV = new ArrayList<NhanVien>();
	}

	public boolean themNV(NhanVien nv) {
		if (dsNV.contains(nv))
			return false;
		dsNV.add(nv);
		return true;
	}
	
// lấy ra danh sách nhân viên
	public ArrayList<NhanVien> getNhanViens() {
		return dsNV;
	}

	public int getSize() {
		return dsNV.size();
	}
	
	public NhanVien kiemTra(String maNV) {
		for (NhanVien nhanVien : dsNV) {
			if(maNV.equalsIgnoreCase(nhanVien.getMaNV()))
				return nhanVien;
		}
		return null;
	}
//	public boolean xoa(int index) {
//		if (index >= 0 && index <= dsNV.size() - 1) {
//			dsNV.remove(index);
//			return true;
//		} else
//			return false;
//	}

//	public boolean xoa(String maNV) {
//		NhanVien nv = new NhanVien(maNV, hoNV, tenNV, phai, tuoi, luong);
//		if (dsNV.contains(nv)) {
//			dsNV.remove(maNV);
//			return true;
//		}
//		return false;
//	}
	
	

	

	public int timKiem(String maNV) {
		for (int i = 0; i < dsNV.size(); i++) {
			if (dsNV.get(i).getMaNV().equalsIgnoreCase(maNV));
			return i;
		}
		return -1;
	}
}
