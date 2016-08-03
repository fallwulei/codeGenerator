package com.suncreate.codergen.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.zip.ZipOutputStream;

public class ZipUtil {

	/**
	 * @param inputFileName 输入一个文件夹
	 * @param zipFileName 输出一个压缩文件夹
	 */
	public static void zip(String inputFilePath, String zipFileName) {
		zip(zipFileName, new File(inputFilePath));
	}

	private static void zip(String zipFileName, File inputFilePath) {
		ZipOutputStream out;
		try {
			out = new ZipOutputStream(new FileOutputStream(zipFileName));
			zip(out, inputFilePath, "");
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void zip(ZipOutputStream out, File f, String base) throws Exception {
		if (f.isDirectory()) {
			File[] fl = f.listFiles();
			out.putNextEntry(new org.apache.tools.zip.ZipEntry(base + "/"));
			base = base.length() == 0 ? "" : base + "/";
			for (int i = 0; i < fl.length; i++) {
				zip(out, fl[i], base + fl[i].getName());
			}
		} else {
			out.putNextEntry(new org.apache.tools.zip.ZipEntry(base));
			FileInputStream in = new FileInputStream(f);
			int b;
			while ((b = in.read()) != -1) {
				out.write(b);
			}
			in.close();
		}
	}
}
