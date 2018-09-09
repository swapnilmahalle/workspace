package com.invmgmt.excel;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.invmgmt.model.QuotationExcelModel;

public class ExcelWriter {

	public String[] columnNames = { "Sr#", "Invetory Name", "Description", "Quantity", "Available Quantity" };

	public void writeExcel() throws IOException {
		List<QuotationExcelModel> quotationExcel = new ArrayList<QuotationExcelModel>();

		quotationExcel = populateData(quotationExcel);

		Workbook workbook = new XSSFWorkbook();

		Sheet sheet = workbook.createSheet("Quotation");

		Font headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerFont.setColor(IndexedColors.BLUE.getIndex());

		CellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setFillBackgroundColor(IndexedColors.PINK.getIndex());
		cellStyle.setFont(headerFont);

		Row headerRow = sheet.createRow(0);

		for (int i = 0; i < columnNames.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columnNames[i]);
			cell.setCellStyle(cellStyle);
		}

		int rowNum = 1;

		for (QuotationExcelModel qExcel : quotationExcel) {
			Row otherRow = sheet.createRow(rowNum++);

			otherRow.createCell(0).setCellValue(qExcel.getSrNumber());
			otherRow.createCell(1).setCellValue(qExcel.getInvetoryName());
			otherRow.createCell(2).setCellValue(qExcel.getDescription());
			otherRow.createCell(3).setCellValue(qExcel.getQuantity());
			otherRow.createCell(4).setCellValue(qExcel.getAvailableQuantity());
		}

		for (int i = 0; i < columnNames.length; i++) {
			sheet.autoSizeColumn(i);
		}

		FileOutputStream fileOut = new FileOutputStream("C:\\humdule\\Quotation.xlsx");
		workbook.write(fileOut);
		fileOut.close();

		// Closing the workbook
		workbook.close();
	}

	public List populateData(List quotationExcel) {
		for (int i = 0; i < 5; i++) {
			QuotationExcelModel quotationExcelModel = new QuotationExcelModel(i, "invetoryName" + i, "description" + i,
					"quantity" + i, 15 + i);
			quotationExcel.add(quotationExcelModel);
		}

		return quotationExcel;
	}
}
