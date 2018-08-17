package com.ares.exam.ntil;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class SheetReadTest {
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream(new File("D:\\题库建设模板.xls"));
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet xs=workbook.getSheet("data");
		if(xs!=null) {
			System.out.println("OK!!!");
		}
		workbook.close();
		fis.close();
	}
}
