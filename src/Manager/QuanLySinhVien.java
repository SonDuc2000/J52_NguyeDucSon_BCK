package Manager;

import java.util.ArrayList;
import java.util.Scanner;

import Data.LoadFile;
import Main.BangDiem;
import Main.SinhVien;

public class QuanLySinhVien {
	
	private ArrayList<SinhVien> sinhViens;
	
	public QuanLySinhVien() {
		sinhViens = new ArrayList<>();
		for (SinhVien sinhVien : LoadFile.getSv()) {
			sinhViens.add(sinhVien);
		}
	}
	
	public ArrayList<SinhVien> getSinhViens() {
		return sinhViens;
	}

	public void setSinhViens(ArrayList<SinhVien> sinhViens) {
		this.sinhViens = sinhViens;
	}

	private static Scanner sc = new Scanner(System.in);
	
	public static void scanner(SinhVien sv) {
		System.out.println("Nhap thong tin sinh vien(ho ten;nam sinh;gioi tinh");
		String data = sc.nextLine();
		String[] spl = data.split(";");
		sv.setHoDem(LoadFile.getHoDem(spl[0]));
		sv.setTen(LoadFile.getTen(spl[0]));
		sv.setGioiTinh(spl[1]);
		sv.setNamSinh(spl[2]);
	}
	
	public void addSV() {
		String id = "SV" + String.format("%05d", sinhViens.size()+1);
		SinhVien sv = new SinhVien();
		sv.setMaSv(id);
		QuanLySinhVien.scanner(sv);
		sinhViens.add(sv);
		System.out.println("Thong tin sinh vien vua them: ");
		System.out.format("  %-10s%-25s%10s%5s", sv.getMaSv(), sv.getFullName(), sv.getNamSinh(), sv.getGioiTinh());
	}
	
	public void searchByName(String name) {
		sinhViens.stream().filter(o -> o.getFullName().contains(name)).forEach(o -> o.showInfoSv());
	}
	
	public void searchById(String id) {
		sinhViens.stream().filter(o -> o.getMaSv().equals(id)).findFirst().ifPresentOrElse(o -> o.showInfoSv(),
				null);
	}
	
	public void editSVById(String id) {
		sinhViens.stream().filter(o -> o.getMaSv().equals(id)).findFirst().ifPresent(o -> scanner(o));
	}
	
	public static boolean checkDiem(String id) {
		boolean check = false;
		for (BangDiem diem : LoadFile.getBd()) {
			if(diem.getIdSV().equals(id))
			{
				check = true;
				break;
			} else
				continue;
		}
		return check;
	}
	
	public void deleteSVById() {
		System.out.println("  Nhap ma sinh vien muon xoa");
		String ma = sc.nextLine();
		for (SinhVien sinhVien : sinhViens) {
			if(sinhVien.getMaSv().equals(ma)) {
				sinhVien.showInfoSv();
				String lua_chon;
				if(QuanLySinhVien.checkDiem(ma) == false)
				{
					System.out.println("Xoa?(Y/N)");
					do {
						lua_chon = sc.nextLine();
					} while(lua_chon == "y" || lua_chon == "n");
					if(lua_chon.equalsIgnoreCase("y") == true) {
						sinhViens.stream().filter(o -> o.getMaSv().equals(ma)).
						findFirst().ifPresent(o -> sinhViens.remove(o));
						System.out.println("Xoa thanh cong");
					} 
					
				}else {
					System.out.println("Sinh vien da co diem khong xoa duoc!");
				}
			}
		}
		
	}
	
	public void showListSinhVien() {
		System.out.println("------------------------Danh sach sinh vien------------------------");
		System.out.println("    _______________________________________________________    ");
		System.out.format("  %-10s%-25s%-15s%10s%10s\n", "   Ma", "   Ho dem", "  Ten", "   Ngay sinh", "    Gioi tinh");
		sinhViens.stream().forEach(o -> o.showInfoSv());
	}

}
