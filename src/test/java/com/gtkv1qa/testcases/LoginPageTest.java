/**
 * 
 */
package com.gtkv1qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gtkv1qa.base.GTKTestBase;
import com.gtkv1qa.pages.HomePage;
import com.gtkv1qa.pages.LoginPage;
import com.gtkv1qa.util.TestUtil;

/**
 * @author mahenderd
 *
 */
public class LoginPageTest extends GTKTestBase {

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	String LoginSheet="GTKLoginUsers";
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeClass
	public void Setup() throws InterruptedException{
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		testutil= new TestUtil();
		
	}
	
	@Test(priority=1)
	public void GTKLogoImageTestonLoginPage() {
		boolean flag = loginpage.validateLogoimage();
		Assert.assertTrue(flag);
	}
	
	@DataProvider(name="GTKLoginusers")
	public Object[][] getLoginTestData(){
		Object data[][]= TestUtil.getTestData(LoginSheet);
		return data;
	}
	
	@Test(priority=2,dataProvider="GTKLoginusers")
	public void LoginTest(String username1, String password1,String username2, String password2, String username3, String password3 ) throws InterruptedException
	{
		//loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		homepage = loginpage.LoginUser1(username1,password1);
		Thread.sleep(2000);
		
		// Second User Login
		/*homepage = loginpage.LoginUser2(username2,password2);*/
		
		// Third User Login
		/*homepage = loginpage.LoginUser3(username3,password3);*/
		
		
		homepage=loginpage.SelectRadiobutton();
		Thread.sleep(1000);
		//Click on Login Button
		homepage = loginpage.ClickonLoginButton();
		
		
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void GTKLogoTestAfterLogin() {
		boolean flag = loginpage.ValidateGTKLogoAfterLogin();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=4)
	public void Logout() {
		homepage.Logout();
	}
	
	
	
	@AfterClass
	public void tearDown(){
		//driver.quit();
	}	
	
	
}
