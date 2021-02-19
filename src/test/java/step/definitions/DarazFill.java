package step.definitions;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ReadExcel.ExcelSheetDriver;
import io.cucumber.java.en.*;
import jxl.read.biff.BiffException;
public class DarazFill {
	static ExcelSheetDriver excelSheetDriver;
WebDriver driver = null;
public DarazFill() throws BiffException, IOException {
	// TODO Auto-generated constructor stub
	excelSheetDriver = new ExcelSheetDriver("E:\\test.xlsx");
};
@Given("browser is open")
public void browser_is_open() {
	System.out.println("Starting - browser is open");
	
	System.setProperty("webdriver.chrome.driver","/JxlTest/src/test/resources/drivers/chromedriver.exe");
	driver = new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
	
	System.out.println("Ending - browser is open");
}


@And("user is on daraz website")
public void user_is_on_google_search_page() throws BiffException, IOException {
	driver.navigate().to("https://www.daraz.com.np");//replace website name;	
}

@When("user enters search products")
public void user_enters_a_text_in_google_search_box() throws BiffException, IOException {
	int column=0;
	int row =0;
	driver.findElement(By.name("q")).sendKeys(ExcelSheetDriver.ReadCell(column, row));
}

@And("hits Enter")
public void hits_Enter() {
	driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
}

@Then("user read excel sheet and write over it")
public void user_is_navigated_to_Search_Results_page() {
	int column=0;
	int row=0;
	driver.getPageSource().contains(ExcelSheetDriver.ReadCell(column, row));
	driver.close();
	driver.quit();
}
}