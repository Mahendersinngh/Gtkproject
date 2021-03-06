/**
 * 
 */
package com.gtkv1qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.annotations.Test;

import com.gtkv1qa.util.TestUtil;
import com.gtkv1qa.util.WebEventListener;


/**
 * @author mahenderd
 *
 */
public class LaunchConfigBase {

public static WebDriver driver;
public static Properties prop;
public static EventFiringWebDriver e_driver;
public static WebDriverEventListener eventListener;
public static TestUtil testUtil;

@Test
public LaunchConfigBase()
{
	try {
		prop = new Properties();
		
		
		FileInputStream ip = new FileInputStream("E:\\MavenprojectTFS\\GTKV1QA\\src\\main\\java\\com\\gtkv1qa\\config\\config.properties");
		prop.load(ip);
		
		
	} 
	catch (FileNotFoundException e) {
		e.printStackTrace();
		
	} catch (IOException e) {
		e.printStackTrace();
		}
	}

	public static void initialization()
	{
	//prop.getProperty("browser");
	String browserName = prop.getProperty("browser");
	if(browserName.equals("Chromebrowser")){
		System.out.println("Launching CHROME browser......");
		System.setProperty("webdriver.chrome.driver", "E:\\MavenprojectTFS\\GTKV1QA\\src\\main\\webdrivers\\chromedriver32v26march18.exe");	
		driver  = new ChromeDriver();
	  }
	
	else if(browserName.equals("Firefoxbrowser")){
		System.out.println("Launching FIREFOX browser......");
		System.setProperty("webdriver.gecko.driver", "E:\\MavenprojectTFS\\GTKV1QA\\src\\main\\webdrivers\\geckodriverx64.exe");	
		driver = new FirefoxDriver();
	  }
	
	else if(browserName.equals("IEbrowser")){
		System.out.println("Launching INTERNET EXPLORER browser.....");
		System.setProperty("webdriver.ie.driver", "E:\\MavenprojectTFS\\GTKV1QA\\src\\main\\webdrivers\\IEDriverServerx32bit.exe");
		driver= new InternetExplorerDriver();
	  }
	
	else if(browserName.equals("Edgebrowser")){
		System.out.println("Launching MICROSOFT EDGE browser.....");
		System.setProperty("webdriver.edge.driver", "E:\\MavenprojectTFS\\GTKV1QA\\src\\main\\webdrivers\\MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
	  }
	
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.manage().timeouts().setScriptTimeout(TestUtil.SCRIPT_WAIT, TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	}	

}
