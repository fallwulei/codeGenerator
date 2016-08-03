package com.suncreate.codergen;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.suncreate.codergen.generator.GeneratorFacatory;
import com.suncreate.codergen.internal.config.Configuration;
import com.suncreate.codergen.utils.Messages;
import com.suncreate.codergen.utils.UtilsString;
import com.suncreate.codergen.utils.ZipUtil;

public class Runner {
	
	public static void main(String[] args) throws SQLException, IOException {
		new Runner().run();
	}

	public void run() throws SQLException {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "spring-context.xml" });
		BeanFactory factory = (BeanFactory) context;

		GeneratorFacatory generatorFacatory = (GeneratorFacatory) factory.getBean("generatorFacatory");
		Configuration config = (Configuration) factory.getBean("config");
		Messages internal = (Messages) factory.getBean("internal");

		Date startTime = new Date();
		generatorFacatory.getDomainGenerator().generate();
		generatorFacatory.getDaoGenerator().generate();
		generatorFacatory.getDaoImplGenerator().generate();
		generatorFacatory.getIbatisSqlMapXmlGenerator().generate();
		generatorFacatory.getServiceGenerator().generate();
		generatorFacatory.getServiceImplGenerator().generate();
		generatorFacatory.getFacadeGenerator().generate();
		generatorFacatory.getFacadeImplGenerator().generate();
		generatorFacatory.getIbatisSqlMapConfigXmlGenerator().generate();
		Date endTime = new Date();

		System.out.println(internal.getString("log.generator.run.time", getTimeInterval(startTime, endTime), config
				.getRealpath()));

		String filePath = config.getRealpath();
		traverseFiles(filePath);
		if (new Boolean(UtilsString.removeQuote(config.getWorkspace_zip()).trim())) {

			System.out.println(internal.getString("log.zip.going"));

			Date zipStartTime = new Date();
			String zipFilePath = config.getWorkspace() + config.getName() + "_v"
					+ new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".zip";
			ZipUtil.zip(config.getRealpath(), zipFilePath);
			Date zipEndTime = new Date();

			System.out.println(internal
					.getString("log.zip.end", getTimeInterval(zipStartTime, zipEndTime), zipFilePath));
		}

	}

	public String getTimeInterval(Date start, Date end) {
		Long sec = (end.getTime() - start.getTime()) / 1000;
		return sec == 0 ? String.valueOf(end.getTime() - start.getTime()) + "ms" : sec.toString() + "s";
	}

	 /**
	  * 通过递归得到某一路径下所有的目录及其文件
	  */
	 private void traverseFiles(String filePath){
		File root = new File(filePath);
		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				traverseFiles(file.getAbsolutePath());
			} else {
				encodingConverter(file);
			}
		}
	 }

	/**
	 * 转换编码
	 * @param file
	 */
	private void encodingConverter(File file) {
		BufferedReader reader = null;
		 BufferedWriter writer = null;
		 try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
			StringBuffer stringBuffer = new StringBuffer();
			String line = null;
			while((line=reader.readLine())!=null){
				stringBuffer.append(line+System.getProperty("line.separator"));
			}
			file.delete();
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "gbk"));
			writer.write(stringBuffer.toString());
		} catch (Exception e) {
			System.out.println("文件转换编码异常");
		}finally{
			if(null != reader){
				try {
					reader.close();
				} catch (IOException e) {
					System.out.println("输入流关闭失败！");
				}
			}
			if(null != writer){
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println("输出流关闭失败！");
				}
			}
		}
	}
	
}
