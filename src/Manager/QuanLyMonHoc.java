package Manager;

import java.util.ArrayList;
import java.util.Scanner;

import Data.LoadFile;
import Main.BangDiem;
import Main.MonHoc;

public class QuanLyMonHoc {
	
	private Scanner sc = new Scanner(System.in);
	
	private ArrayList<MonHoc> monHocs;
	
	public QuanLyMonHoc() {
		monHocs = new ArrayList<>();
		for (MonHoc monHoc : LoadFile.getMh()) {
			monHocs.add(monHoc);
		}
	}

	public ArrayList<MonHoc> getMonHocs() {
		return monHocs;
	}

	public void setMonHocs(ArrayList<MonHoc> monHocs) {
		this.monHocs = monHocs;
	}
	
	public static float getHeSoMh(String idMH) {
		for (MonHoc monHoc : LoadFile.getMh()) {
			if(monHoc.getMaMH().equals(idMH))
				return monHoc.getHeSo();
		}
		return 0;
	}
	
	public static String getTenMh(String idMh) {
		for (MonHoc monHoc : LoadFile.getMh()) {
			if(monHoc.getMaMH().equals(idMh))
				return monHoc.getTenMH();
		}
		return "";
	}
	
	public void showMonHoc() {
		System.out.println("-----------------------------DANH SACH MON HOC-----------------------------");
		this.monHocs.stream().forEach(o -> o.showMonHoc());
	}
	
	public void addMonHoc() {
		int index = monHocs.size();
		System.out.println("Nhap thong tin mon hoc muon them: \r{ten mon hoc;he so diem}");
		String data = sc.nextLine();
		String[] split = data.split(";");
		MonHoc hoc = new MonHoc(String.valueOf(index+1), split[0], Float.parseFloat(split[1]));
		System.out.println("  Mon hoc vua them la:");
		hoc.showMonHoc();
		monHocs.add(hoc);
	}
	
	public void editMH() {
		System.out.println("  Nhap ma mon hoc muon sua:");
		String id = sc.nextLine();
		for (MonHoc monHoc : monHocs) {
			if(monHoc.getMaMH().equals(id)) {
				System.out.println("  Nhap lai thong tin theo dang:\n  {ten mon hoc;he so}");
				String[] edit = sc.nextLine().split(";");
				monHoc.setTenMH(edit[0]);
				monHoc.setHeSo(Float.parseFloat(edit[1]));
				System.out.println("  Thong tin mon hoc:"); monHoc.showMonHoc();
			}
		}
	}
	
	public void deleteMonHoc() {
		System.out.println("  Nhap ma mon hoc muon xoa: ");
		String ma = sc.nextLine();
		for (BangDiem bangDiem : LoadFile.getBd()) {
			
			if(bangDiem.getIdMH().equals(ma)) {
				
				System.out.println("  Mon hoc nay da co sinh vien hoc\r  Khong the xoa");
			} else {
				for (MonHoc monHoc : monHocs) {
					if(monHoc.getMaMH().equals(ma)) {
					
						monHocs.remove(monHoc);
						System.out.println("  Xoa thanh cong");
					}
				}
			}
		}
	}
	
	public static void showListMonHoc() {
		System.out.println("____________________________________________________\r");
		System.out.format("  %-10s|%30s|%10s\r", "Ma", "Ten mon hoc", "He so");
		System.out.println("____________________________________________________\r");
		for (MonHoc monHoc : LoadFile.getMh()) {
			monHoc.showMonHoc();
		}
	}

}
