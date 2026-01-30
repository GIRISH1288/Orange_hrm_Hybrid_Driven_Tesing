package com.crm.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {

	public static String[][] getCells(String path, String sheet) {

		try {

			FileInputStream fis = new FileInputStream(path);

			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheet);
			int row = sh.getPhysicalNumberOfRows();
			int col = sh.getRow(0).getPhysicalNumberOfCells();
			String[][] op = new String[row][col];
			for (int i = 0; i < row; i++) {

				for (int j = 0; j < col; j++) {
					op[i][j] = sh.getRow(i).getCell(j).toString();
				}
			}
			return op;

		} catch (Exception e) {
			// TODO: handle exception
		}
		// Return an empty string !
		return new String[][] { {} };

	}

	public static String getCell(String path, String sheet, int row, int col) {

		String ans = null;
		try {
			FileInputStream fis = new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheet);
			ans = sh.getRow(row).getCell(col).toString();

		} catch (Exception e) {
			System.out.println("Cannot read data ! Error occured ");
			e.printStackTrace();
		}

		return ans;

	}

}
