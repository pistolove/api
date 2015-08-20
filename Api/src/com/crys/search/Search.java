package com.crys.search;

import java.io.File;

import com.crys.utils.ConstantUtils;

public class Search {
	public static String con = "Controller";
	public static String dto = "Dto";

	public static int count = 0;
	
	public static void main(String[] args) {
		File dir = new File(ConstantUtils.PATH);
		// 要查找的关键字

		getFiles(dir);
		
		System.err.println(count);
	}

	private static void getFiles(File dir) {
		if (dir != null) {
			File[] listFiles = dir.listFiles();
			for (File file : listFiles) {
				if (file.isFile()) {
					if (file.getName().toLowerCase().endsWith(".java")
							&& file.getName().contains(dto) || file.getName().contains(con)) {
						System.out.println("file : " + file.getName() + "   ");
						count++;
					}
				} else if (file.isDirectory()) {
					getFiles(file);
				}
			}
		}
	}
}
