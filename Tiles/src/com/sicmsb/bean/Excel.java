package com.sicmsb.bean;

import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Excel {

	private CellStyle cs = null;
	private CellStyle csBold = null;
	private CellStyle csBlueBackground = null;

	//public static void main(String[] args) {

		//Excel myReport = new Excel();
		//myReport.createExcel(1,2015);

	//}

	public void createExcel(int month,int year) {

		try {

			Workbook wb = new HSSFWorkbook();
			Sheet sheet = wb.createSheet("TimeSheet");
			int y = year;
			int m = month;
			// Setup some styles that we need for the Cells
			setCellStyles(wb);

			// Set Column Widths
			sheet.setColumnWidth(1, 5000);
			sheet.setColumnWidth(2, 20000);

			int rowIndex = 0;
			rowIndex = insertHeaderInfo(sheet, rowIndex);
			rowIndex = insertDetailInfo(sheet, rowIndex, m, y);

			// Write the Excel file
			FileOutputStream fileOut = null;
			fileOut = new FileOutputStream(
					"C:\\Users\\yageswaran.ramar\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\Tiles\\upload\\Timesheet-"+month+"-"+year+".xls");
			// HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
			wb.write(fileOut);
			HSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
			fileOut.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	private void setCellStyles(Workbook wb) {

		// font size 10
		Font f = wb.createFont();
		f.setFontName("Calibri");
		f.setFontHeightInPoints((short) 11);

		// Simple style
		cs = wb.createCellStyle();
		cs.setFont(f);
		cs.setBorderBottom(CellStyle.BORDER_THIN);
		cs.setBorderLeft(CellStyle.BORDER_THIN);
		cs.setBorderRight(CellStyle.BORDER_THIN);
		cs.setBorderTop(CellStyle.BORDER_THIN);
		short df = wb.createDataFormat().getFormat("dd-mmm-yyyy (ddd)");
		cs.setDataFormat(df);

		csBlueBackground = wb.createCellStyle();
		csBlueBackground.cloneStyleFrom(cs);
		// csBlueBackground.setFillBackgroundColor();
		csBlueBackground
				.setFillForegroundColor(new HSSFColor.AQUA().getIndex());
		csBlueBackground.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

		// Bold Fond
		Font bold = wb.createFont();
		bold.setFontName("Calibri");
		bold.setBoldweight(Font.BOLDWEIGHT_BOLD);
		bold.setFontHeightInPoints((short) 11);

		// Bold style
		csBold = wb.createCellStyle();
		csBold.setBorderBottom(CellStyle.BORDER_THIN);
		csBold.setBorderLeft(CellStyle.BORDER_THIN);
		csBold.setBorderRight(CellStyle.BORDER_THIN);
		csBold.setBorderTop(CellStyle.BORDER_THIN);
		csBold.setBottomBorderColor(IndexedColors.BLACK.getIndex());
		csBold.setFont(bold);
		csBold.setFillForegroundColor(new HSSFColor.AQUA().getIndex());
		csBold.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		csBold.setAlignment(HSSFCellStyle.ALIGN_LEFT);
		csBold.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

	}

	private int insertHeaderInfo(Sheet sheet, int index) {

		int rowIndex = index;
		Row row = null;
		Cell c = null;

		rowIndex++;
		row = sheet.createRow(rowIndex);
		rowIndex = rowIndex++;
		row = sheet.createRow(rowIndex);
		c = row.createCell(1);
		c.setCellValue("Date");
		c.setCellStyle(csBold);
		c = row.createCell(2);
		c.setCellValue("Task");
		c.setCellStyle(csBold);

		return rowIndex;

	}

	private int insertDetailInfo(Sheet sheet, int index, int month, int year) {

		int rowIndex = 1;
		Row row = null;
		Cell c = null;
		Cell r = null;

		for (int i = 1; i <= 31; i++) {

			rowIndex = index + i;
			// r = row.createCell(2);
			// r.setCellStyle(cs);
			row = sheet.createRow(rowIndex);
			c = row.createCell(1);
			r = row.createCell(2);
			c.setCellStyle(cs);
			// c.setCellType(HSSFCell.CELL_TYPE_FORMULA);
			// String d = "DATE("+year+","+month+"," + i + ")";
			Calendar cal = new GregorianCalendar(year, month, i);
			// c.setCellFormula(d);
			c.setCellValue(cal);
			if (cal.get(Calendar.DAY_OF_WEEK) == 1
					|| cal.get(Calendar.DAY_OF_WEEK) == 7) {
				c.setCellStyle(csBlueBackground);
				 r.setCellStyle(csBlueBackground);
			} else {
				c.setCellStyle(cs);
				 r.setCellStyle(cs);
			}

			//r = row.createCell(2);
			//r.setCellStyle(cs);

		}

		return rowIndex;

	}
}