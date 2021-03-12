package Manager;

import java.util.ArrayList;
import java.util.Scanner;

import Data.LoadFile;
import Main.BangDiem;
import Main.SinhVien;

public class QuanLyBangDiem {
	
	private ArrayList<BangDiem> diems;
	
	private static Scanner sc = new Scanner(System.in);

	public QuanLyBangDiem() {
		diems = new ArrayList<>();
		for (BangDiem bangDiem : LoadFile.getBd()) {
			diems.add(bangDiem);
		}
	}
	
	public static String getIdMh(String IdSv) {
		for (BangDiem bangDiem : LoadFile.getBd()) {
			if(bangDiem.getIdSV().equals(IdSv))
				return bangDiem.getIdMH();
		}
		return "";
	}
	
	public static String getIdSv(String idMh) {
		for (BangDiem bangDiem : LoadFile.getBd()) {
			if(bangDiem.getIdMH().equals(idMh))
				return bangDiem.getIdSV();
		}
		return "";
	}
	
	public static float getDiem(String idMh, String idSv) {
		for (BangDiem bangDiem : LoadFile.getBd()) {
			if(bangDiem.getIdMH().equals(idMh) && bangDiem.getIdSV().equals(idSv))
				return bangDiem.getDiem();
		}
		return 0;
	}
	
	public void addBangDiem() {
		BangDiem bangDiem = new BangDiem();
		boolean checkSV = false;
		boolean checkMH = false;
		System.out.println("  Nhap diem theo dang:  \n{ma SV;ma MH; diem}");
		String data = sc.nextLine();
		String[] spl = LoadFile.subString(data);
		for (SinhVien sinhvien : LoadFile.getSv()) {
			if(sinhvien.getMaSv().equals(spl[0]))
			{
				checkSV = true;
				if (QuanLyBangDiem.getIdMh(spl[0]).equals(spl[1])) {
					checkMH = true;
					System.out.println("  Sinh vien da co diem mon nay, khong the them.");
				}else {
					bangDiem.setIdSV(spl[0]);
					bangDiem.setIdMH(spl[1]);
					bangDiem.setDiem(Float.parseFloat(spl[2]));
					diems.add(bangDiem);
				}
			}	
		}
		if(checkSV == false) System.out.println("  Khong tim thay sinh vien trong danh sach");
		else {
			if(checkMH == false) System.out.println("  Khong tim thay mon hoc trong danh sach");
		}
	}
	
	public void editBangDiem() {
		boolean checkSV = false;
		boolean checkMH = false;
		System.out.println("  Nhap ma sinh vien muon sua");
		String data = sc.nextLine();
		for (SinhVien sinhVien : LoadFile.getSv()) {
			if(sinhVien.getMaSv().equals(data)) {
				checkSV = true;
				QuanLyBangDiem.showBangDiem(sinhVien);
				System.out.println("  Nhap diem muon sua theo dang:\n  {ma MH;diem}");
				String diem = sc.nextLine();
				String[] spl = diem.split(";");
				for (BangDiem bDiem : diems) {
					if(bDiem.getIdMH().equals(spl[0])) {
						checkMH = true;
						bDiem.setDiem(Float.parseFloat(spl[1]));
					}
				}
			}
		}
		
		if(checkSV == false) System.out.println("  Khong tim thay sinh vien nay");
		else if(checkMH == false) System.out.println("  Khong tim thay mon hoc");
	}
	
	public void deleteBangDiem() {
		boolean checkSV = false;
		boolean checkMH = false;
		System.out.println("  Nhap ma sinh vien: ");
		String id = sc.nextLine();
		for (SinhVien sinhVien : LoadFile.getSv()) {
			if(sinhVien.getMaSv().equals(id)) {
				checkSV = true;
				QuanLyBangDiem.showBangDiem(sinhVien);
				System.out.println("  Nhap ma mon hoc muon xoa: ");
				String idMH = sc.nextLine();
				for (BangDiem bangDiem : diems) {
					if(bangDiem.getIdMH().equals(idMH)) {
						checkMH = true;
						diems.remove(bangDiem);
						System.out.println("  Xoa thanh cong");
					}
				}
			}
		}
		if(checkSV == false) System.out.println("  Khong tim thay sinh vien");
		else if(checkMH == false) System.out.println("  Khong tim thay mon hoc");
	}
	
	
	public static void showBangDiem(SinhVien sv) {
		float size = 0f;
		float DTK = 0.00f;
		System.out.format("  %-10s%40s\n", sv.getMaSv(), sv.getFullName());
		System.out.println("  ---------------------------------------------------");
		for (BangDiem bangDiem : LoadFile.getBd()) {
			if(bangDiem.getIdSV().equals(sv.getMaSv())) {
				System.out.format("  %-10s%30%10\r", bangDiem.getIdMH(), QuanLyMonHoc.getTenMh(bangDiem.getIdMH()), 
						QuanLyBangDiem.getDiem(bangDiem.getIdMH(), sv.getMaSv()));
				size += 1;
				DTK += QuanLyBangDiem.getDiem(bangDiem.getIdMH(), sv.getMaSv());
			}
		}
		if(size != 0)
		System.out.format("  DTK:%46.2f\n\n", DTK/size);
		else System.out.format("  DTK:%46.2f\n\n", 0.00);
	}

}
