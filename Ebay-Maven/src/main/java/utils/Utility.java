package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.TakesScreenshot;

public class Utility {
	public  static void captureScreen(WebDriver driver,String testId) throws IOException {
		
		//public static WebDriver driver;
		
		Date d = new Date();
		Random random =new Random();
		
		
		String Filename = d.toString().replace(":", "_").replace(" ", "_");
		
		
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//File  DestiFile =new File( "‪E:\\New folder2\\Test"+random.nextInt(10000)+" "+Filename+".jpg");
		File  DestiFile =new File( "‪test-output\\FailedScreenshots\\Test"+testId+" "+Filename+".jpg");
		
		FileHandler.copy(screenshot, DestiFile);
	}
	
	
	public static String getExceldata(String sht,int r,int c) throws IOException {
        //String path = "E:\\Book1.xlsx";
		String path = "src/main/resources/data/Book1.xlsx";
		
		FileInputStream file = new FileInputStream(path);
		Workbook  book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet("Velocity");
		Row row = sheet.getRow(2);
		Cell cell = row.getCell(0);
		//String data = cell.getStringCellValue();
		//double data = cell.getNumericCellValue();
		//Date date = cell.getDateCellValue();
		
		String exceldata;
		try {
			exceldata = cell.getStringCellValue();
		}
		catch(IllegalStateException e) {
			double value = cell.getNumericCellValue();
			exceldata = String.valueOf(value);
		}
		//String exceldata = cell.getStringCellValue();
		//String s = String.valueOf(data);
		//System.out.println(s);
		//return s;
		return exceldata;
	}
	
	
	

}
