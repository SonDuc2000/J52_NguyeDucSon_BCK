package Main;

import java.io.IOException;
import java.util.Scanner;

import Data.LoadFile;
import Manager.QuanLyBangDiem;
import Manager.QuanLyMonHoc;
import Manager.QuanLySinhVien;

public class Main {
	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
			for (int j = 0; j < 20; j++) {
				System.out.println(j);
				break;
			}
			break;
		}
		String[] s = new String[1];
		s[0] = "-dir=C:\\data";
		getFile(s);
		LoadFile.openAllFile();
		QuanLySinhVien quanLySinhVien = new QuanLySinhVien();
		QuanLyMonHoc quanLyMonHoc = new QuanLyMonHoc();
		QuanLyBangDiem quanLyBangDiem = new QuanLyBangDiem();
		QuanLyMonHoc.showListMonHoc();
		quanLySinhVien.showListSinhVien();
		//quanLyMonHoc.showMonHoc();
		//System.out.println("Nhaapj id muon xoa");
		//String id = sc.nextLine();
		//quanLySinhVien.deleteSVById(id);
		//quanLySinhVien.showListSinhVien();
		try {
			LoadFile.updateSV("C:\\data", quanLySinhVien.getSinhViens());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void getFile(String[] s) {
		int index = s[0].indexOf("dir=");
		if(s.length > 1) {
			LoadFile.setDirFile(s[0].substring(index + 4).concat(" " + s[1]));
		}
		else
			LoadFile.setDirFile(s[0].substring(index + 4));
	}

}
