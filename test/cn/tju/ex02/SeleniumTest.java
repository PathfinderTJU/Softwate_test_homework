package cn.tju.ex02;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumTest {
	
	File file;
	WebDriver driver;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	@Before
	public void setUp() {
		//����ChromeWebdriver�����ò���
		String driverPath = System.getProperty("user.dir") + "/src/driver/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		
		//����webdriver
		String url = "http://103.120.226.190/selenium-demo/git-repo";
		
		driver.get(url);
		
		try {		
			
			//��xlsx�ļ�
			FileInputStream is = new FileInputStream(System.getProperty("user.dir") + "/assets/Selenium+Lab2020.xlsx");
			wb = new XSSFWorkbook(is); //xlsx������
			sheet = wb.getSheetAt(0); //xlsx��������һ��sheet
			
		}catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown() {
		try {
			wb.close(); //�رչ�����
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void Test() {
		
		//����������Ŀ
		int caseNumber = 20;
			
		for (int i = 0 ; i < caseNumber ; i++) {
			XSSFRow row = sheet.getRow(i); //��ȡ��i������
			Object username = row.getCell(1); //��ȡ��1������
			Object password = row.getCell(2);
			
			//����
		    driver.findElement(By.name("user_number")).click();
		    driver.findElement(By.name("user_number")).sendKeys(username.toString());
		    driver.findElement(By.name("password")).click();
		    driver.findElement(By.name("password")).sendKeys(password.toString());
		    driver.findElement(By.cssSelector(".btn")).click();
		    
		    //����
		    assertThat(driver.findElement(By.cssSelector(".mb-2:nth-child(6) > code")).getText(), is(password.toString()));;
		}
				
	}
	
}
