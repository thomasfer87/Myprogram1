package com.app.flipkart.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	static TakesScreenshot tk;

	public static void launchBrowserMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void urlPass(String url) {
		driver.get(url);
	}

	public static void sendAttributeValue(WebElement element, String value) {

		element.sendKeys(value);
	}

	public static void clickMethod(WebElement element) {
		element.click();
	}

	public static WebElement findElementid(String id) {
		return driver.findElement(By.id(id));
	}

	public static WebElement findElemenname(String name) {
		return driver.findElement(By.name(name));
	}

	public static void selectbyvalue(WebElement element, String data) {
		Select s = new Select(element);
		s.selectByValue(data);
	}

	public static void selectbyindex(WebElement element, int data) {
		Select s = new Select(element);
		s.selectByIndex(data);
	}

	public static void screenShot() throws IOException {
		tk = (TakesScreenshot) driver;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime now = LocalDateTime.now();
		String current_date_time = dtf.format(now);
		File screenshot = tk.getScreenshotAs(OutputType.FILE);
		File sysFile = new File("F:\\Screenshots" + current_date_time + ".png");
		FileHandler.copy(screenshot, sysFile);
	}

	public static String excelreuseRead(int row, int cell) {
		String value = null;
		try {
			// file -> locate
			File f = new File(
					"C:\\Users\\User\\eclipse-workspace\\com.java.base\\src\\test\\resources\\TestData\\Mydata.xlsx");
			FileInputStream fis = new FileInputStream(f);

			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			Row row1 = sheet.getRow(row);
			Cell cell1 = row1.getCell(cell);
			CellType cellType = cell1.getCellType();
			System.out.println(cellType);
			if (cellType == CellType.STRING) {
				value = cell1.getStringCellValue();
			} else if (cellType == CellType.NUMERIC) {
				double numericCellValue = cell1.getNumericCellValue();
				long l = (long) numericCellValue;
				String valueOf = String.valueOf(l);
				value = valueOf;
			} else if (DateUtil.isCellDateFormatted(cell1)) {
				Date dateCellValue = cell1.getDateCellValue();
				SimpleDateFormat sf = new SimpleDateFormat("dd-mm-yyy");
				String format = sf.format(dateCellValue);
				value = format;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return value;

	}

	public static String propertiesMethod(String a) {
		String out = null;
		File file = new File(
				"C:\\Users\\User\\eclipse-workspace\\com.java.base\\src\\test\\resources\\TestData\\Test.Properties");
		try {
			FileInputStream fileInput = new FileInputStream(file);
			Properties prop = new Properties();
			try {
				prop.load(fileInput);
			} catch (IOException e) {
				e.printStackTrace();
			}
			out = prop.getProperty(a);
			System.out.println(out);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return out;
	}

	public static void timwWait(long l) {
		driver.manage().timeouts().implicitlyWait(l, TimeUnit.SECONDS);
	}

	public static List<WebElement> listofProducts(List<WebElement> list) {

		String[] a = new String[list.size() - 1];

		for (int i = 0; i < list.size()-1; i++) {

			a[i] = list.get(i).getText();

		}
		for (String c : a) {
			System.out.println(c);
		}

		return list;
	}

}