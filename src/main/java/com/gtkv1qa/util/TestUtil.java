/**
 * 
 */
package com.gtkv1qa.util;
  
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
  
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import com.gtkv1qa.base.GTKTestBase;

  
/**
 * @author mahenderd
 *
 */
public class TestUtil extends GTKTestBase {
  
      
    public static long PAGE_LOAD_TIMEOUT =30;
    public static long IMPLICIT_WAIT = 30;
    public static long SCRIPT_WAIT = 30;
   
    // Groups and Project Update
    /*public static String TESTDATA_SHEET_PATH = "E:\\MavenprojectGTK\\KonnectPortal\\src\\main\\java\\com\\konnect\\testdata\\Groups and Project Update.xlsx";
    static Workbook book;
    static Sheet sheet;*/
    
    // Groups and Project Creation -- CREATION
    public static String TESTDATA_SHEET_PATH = "E:\\MavenprojectTFS\\GTKV1QA\\src\\main\\java\\com\\gtkv1qa\\testdata\\GTKV1QA_Testdatasheet.xlsx";
    static Workbook book;
    static Sheet sheet;
   
    // Groups and Project  --- UPDATE
    public static String TESTDATA_SHEET_PATH1 = "E:\\MavenprojectTFS\\KonnectPortal\\src\\main\\java\\com\\konnect\\testdata\\Groups and Project Update.xlsx";
    static Workbook book1;
    static Sheet sheet1;
      
      
    public void switchToFrame(){
        driver.switchTo().frame("GTKCntMstIframe");
    }
      
    public void switchToDefaultFrame()
    {
        driver.switchTo().defaultContent();
    }
      
    public void switchToInnerFrame() {
        // -- //iframe[contains(@src,'javascript:"')]
        WebElement frame = driver.findElement(By.xpath("//div[@class='col-md-12 no-padding']//table//tbody//tr//td//iframe[@class='k-content']"));
        driver.switchTo().frame(frame);
         
        //driver.switchTo().frame(2);
        //driver.switchTo().frame("ae9dbe573bed089db1ad9c594c60f94b");
          
        //driver.switchTo().frame();
    }
      
    public void switchToDefaultinnerFrame()
    {
    	//WebElement frame = driver.findElement(By.xpath("//div[@class='Tags']"));
    	WebElement frame = driver.findElement(By.xpath("//div[@id='comments']//div[@class='col-md-12 no-padding']"));
        
    	JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", frame);
        driver.switchTo().frame(frame);
    	
    	//driver.switchTo().defaultContent();
    }
    public void switchToParentFrame()
    {
    	driver.switchTo().parentFrame();
 	    //driver.switchTo().defaultContent();
    	
    	//driver.switchTo().defaultContent();
    }  
    // ChatFrame
    public void SwitchToChatFrame() {
		driver.switchTo().frame("GTKChatIframe");
	}
    
    
    public void SwitchToFrameofTextinChat() {
		driver.switchTo().frame(0);
	}
    
    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        // 
        //System.out.println(sheet.getLastRowNum() + "--------" +
        // sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                // System.out.println(data[i][k]);
            }
        }
        return data;
    }
        
        
        public static Object[][] getTestDataUpdate(String sheetName1) {
            FileInputStream file = null;
            try {
                file = new FileInputStream(TESTDATA_SHEET_PATH1);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                book1 = WorkbookFactory.create(file);
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            sheet1 = book1.getSheet(sheetName1);
            Object[][] data = new Object[sheet1.getLastRowNum()][sheet1.getRow(0).getLastCellNum()];
            // 
            //System.out.println(sheet.getLastRowNum() + "--------" +
            // sheet.getRow(0).getLastCellNum());
            for (int i = 0; i < sheet1.getLastRowNum(); i++) {
                for (int k = 0; k < sheet1.getRow(0).getLastCellNum(); k++) {
                    data[i][k] = sheet1.getRow(i + 1).getCell(k).toString();
                    // System.out.println(data[i][k]);
                }
            }
            return data;
        
    }
      
    public static void takeScreenshotAtEndOfTest() throws IOException {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
          
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
          
        }
   
      
}

