package Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Lib {
	
	public static String getTitle(WebDriver driver) {
		String title = driver.getTitle();
		return title;
	}
	
	public static WebElement findElem(WebDriver driver, String xpath) {
		WebElement elem = driver.findElement(By.xpath(xpath));
		return elem;
	}
	
	public static String readProperty(String key) throws IOException {
		File file = new File("src\\test\\resources\\ObjectRepository\\locator.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		String value = prop.getProperty(key);
		return value;
	}
	
	public static String readExcel(WebDriver driver, int row, int col) throws IOException {
		File file = new File("");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wk = new XSSFWorkbook(fis);
		XSSFSheet sh = wk.getSheetAt(0);
		XSSFRow rw = sh.getRow(row - 1);
		XSSFCell cell = rw.getCell(col - 1);
		String value = cell.getStringCellValue();
		return value;
	}
	
	public static void takeScreenshot(WebDriver driver, String name) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\xxthe\\Google Drive\\PIIT\\Selenium\\Java\\AutomationPractice\\Screenshot_" + name + ".png"));
	}
	
	public static void switchWindow(WebDriver driver) {
		String win1 = driver.getWindowHandle();
		Set<String> wins = driver.getWindowHandles();
		for(String win2 : wins) {
			if(!win2.equals(win1)) {
				driver.switchTo().window(win2);
			}
		}
	}
	
	public static void switchFrame(WebDriver driver, int num) {
		driver.switchTo().frame(num);
	}
	
}
