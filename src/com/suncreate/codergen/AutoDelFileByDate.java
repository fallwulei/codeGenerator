package com.suncreate.codergen;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tools.ant.util.DateUtils;

import sun.misc.Cleaner;

public class AutoDelFileByDate {
	Map<String, Long> fileUD = new HashMap<String, Long>();
	String lastTime = "2015-09-29 10:00:00";
	String warFilePath = "";
	String resourceFilePath = "";

	public AutoDelFileByDate() {
	}

	public AutoDelFileByDate(String lastTime, String warFilePath, String resourceFilePath) {
		super();
		this.lastTime = lastTime;
		this.warFilePath = warFilePath;
		this.resourceFilePath = resourceFilePath;
	}

	public static void main(String[] args) {
		AutoDelFileByDate af = new AutoDelFileByDate("2015-09-29 00:30:00", "D:\\bwcrm","D:\\Java\\workspace10\\bwcrm");
		af.updateWar();
	}

	private void updateWar() {
		try {
			File warFile = new File(warFilePath);
			File resourceFile = new File(resourceFilePath);
			setFileUpdteDate(resourceFile);
			delAllFiles(warFile);
			// 要删除的目录 请勿以\\结尾，及最后一层目录后的分隔符不要
			List<File> list = getAllNullDirectorys(new File(warFilePath));
			removeNullFile(list, warFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** */
	/**
	 * 递归列出某文件夹下的最深层的空文件夹绝对路径，储存至list
	 * 
	 * @param root
	 * @return
	 */
	public static List<File> getAllNullDirectorys(File root) {
		List<File> list = new ArrayList<File>();
		File[] dirs = root.listFiles();
		if (dirs != null) {
			for (int i = 0; i < dirs.length; i++) {
				if (dirs[i].isDirectory() && dirs[i].listFiles().length == 0) {
					list.add(dirs[i]);
				}
				list.addAll(getAllNullDirectorys(dirs[i]));
			}
		}
		return list;
	}

	/**
	 * 由最深一层的空文件，向上（父文件夹）递归，删除空文件夹
	 * 
	 * @param list
	 * @param rootPath
	 */
	public static void removeNullFile(List<File> list, String rootPath) {
		if (list == null || list.size() == 0) {
			return;
		}
		List<File> plist = new ArrayList<File>();
		for (int i = 0; i < list.size(); i++) {
			File temp = list.get(i);
			if (temp.isDirectory() && temp.listFiles().length <= 0) {
				temp.delete();
				File pFile = temp.getParentFile();
				if (pFile.getPath().equals(rootPath)) {
					continue;
				}
				if (!plist.contains(pFile)) {// 父目录去重添加
					plist.add(pFile);
				}
			}
		}
		removeNullFile(plist, rootPath);
	}

	private void setFileUpdteDate(File dir) throws Exception {
		File[] fs = dir.listFiles();
		String fn;
		for (int i = 0; i < fs.length; i++) {
			if (fs[i].isDirectory()) {
				setFileUpdteDate(fs[i]);
			} else {
				fn = fs[i].getName();
				if (fn.endsWith(".java")) {
					System.out.println(fn+"--"+DateUtils.format(fs[i].lastModified(),"yyyy-MM-dd"));
					fileUD.put(fn.substring(0, fn.lastIndexOf(".")), fs[i].lastModified());
				}else{
					fileUD.put(fn, fs[i].lastModified());
				}
			}
		}
	}

	private void delAllFiles(File dir) throws Exception {
		File[] fs = dir.listFiles();
		String fn;
		Long ud;
		for (int i = 0; i < fs.length; i++) {
			if (fs[i].isDirectory()) {
				delAllFiles(fs[i]);
			} else {
				fn = fs[i].getName();
				if (fn.endsWith(".class")) {
					ud = fileUD.get(fn.substring(0, fn.lastIndexOf(".")));
				} else  {
					ud = fileUD.get(fn);
				}
				if (ud != null) {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					Long lt = sdf.parse(lastTime).getTime();
					if (ud < lt) {
						fs[i].delete();
						//System.out.println(fs[i].getName());
					}
				}
			}
		}
	}
}
