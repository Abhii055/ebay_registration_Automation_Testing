package EbayTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import test.utility.testUtil;

public class ebayClass {
    ChromeDriver driver;
    String url = "https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2Fn%2Ferror";

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhin\\eclipse-workspace\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get(url);
    }

    @DataProvider
    public Iterator<Object[]> getTestData(){
        ArrayList<Object[]> testData = testUtil.getDataFromExcel();
        return testData.iterator();
    }

    @Test(dataProvider = "getTestData")
    public void halfEbayRegistration(String businessName, String businessEmail, String bizPassword, String Country) {
        driver.findElement(By.xpath("//input[@id='businessName']")).sendKeys(businessName);
        driver.findElement(By.xpath("//input[@id='businessEmail']")).sendKeys(businessEmail);
        driver.findElement(By.xpath("//input[@id='bizPassword']")).sendKeys(bizPassword);
        
        Select country = new Select(driver.findElement(By.xpath("//span/select[@id='businessCountry']")));
        country.selectByVisibleText(Country);
        
        driver.findElement(By.xpath("//button[@id='BUSINESS_REG_FORM_SUBMIT']")).click();
    }

    @AfterMethod
    public void tearDown() {
    	driver.navigate().refresh();
        driver.quit();
    }
}





//package EbayTest;
//
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.Iterator;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//import test.utility.testUtil;
//
//public class ebayClass {
//ChromeDriver driver;
//String url="https://signup.ebay.com/pa/crte?ru=https%3A%2F%2Fwww.ebay.com%2Fn%2Ferror";
//@Test
//public void invokeBrowser() 
//{
//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhin\\eclipse-workspace\\libs\\chromedriver.exe");
//	driver = new ChromeDriver();
//	driver.manage().window().maximize();
//	driver.manage().deleteAllCookies();
//	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//	driver.get(url);
//}
//
//@DataProvider
//public Iterator<Object[]> getTestData(){
//	ArrayList<Object[]> testData = testUtil.getDataFromExcel();
//	return testData.iterator();
//}
//@Test(dataProvider = "getTestData")
//public void halfEbayRegistration(String businessName, String businessEmail,  String bizPassword, String Country
//) {
//    // These lines are attempting to interact with elements, but driver is null , String bizPassword, String Country
////    driver.findElement(By.xpath("//input[@id='businessName']")).clear();
//    driver.findElement(By.xpath("//input[@id='businessName']")).sendKeys(businessName);
//    
////    driver.findElement(By.xpath("//input[@id='businessEmail']")).clear();
//    driver.findElement(By.xpath("//input[@id='businXessEmail']")).sendKeys(businessEmail);
//    
////    driver.findElement(By.xpath("//input[@id='bizPassword']")).clear();
//    driver.findElement(By.xpath("//input[@id='bizPassword']")).sendKeys(bizPassword);
//    
//    Select country = new Select(driver.findElement(By.xpath("//span/select[@id='businessCountry']")));
//    country.selectByVisibleText(Country);
//    
//    driver.findElement(By.xpath("//button[@id='BUSINESS_REG_FORM_SUBMIT']")).click();
//}
//
//
//
//@Test(dependsOnMethods = "halfEbayRegistration")
//public void tearDown() {
//    driver.navigate().refresh();
//    driver.quit();
//}
//}