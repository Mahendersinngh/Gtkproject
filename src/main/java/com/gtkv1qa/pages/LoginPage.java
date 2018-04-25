/**
 * 
 */
package com.gtkv1qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gtkv1qa.base.LaunchConfigBase;

/**
 * @author mahenderd
 *
 */
public class LoginPage extends LaunchConfigBase {

	
	@FindBy(xpath="//div[@class='logo_login']")
	WebElement LoginpageLogo;
	
	@FindBy(id="txtUserCode")
	WebElement username1;
	
	@FindBy(id="txtPassword")
	WebElement password1;
	
	@FindBy(id="txtUserCode")
	WebElement username2;
	
	@FindBy(id="txtPassword")
	WebElement password2;
	
	@FindBy(id="txtUserCode")
	WebElement username3;
	
	@FindBy(id="txtPassword")
	WebElement password3;
	
	
	
	
	@FindBy(id="btnLogin")
	WebElement loginbutton;
	
	@FindBy(xpath="//input[@checked='checked']")
	WebElement SaveRadioButtonChecked;
	
	@FindBy(xpath="//input[@value='0']")
	WebElement SaveMyUserValue0;
	
	@FindBy(xpath="//input[@value='1']")
	WebElement SaveMyUserValue1;
	
	@FindBy(xpath="//div[@class='gtk_logo']")
	WebElement GtkLogoAfterLogin;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public String validateLoginPageTitile() {
		
		return driver.getTitle();
		
	}
	
	
	public boolean validateLogoimage() {
		return LoginpageLogo.isDisplayed();
	}
	
	
	public HomePage LoginUser1(String user1, String pwd1) {
		username1.clear();
		username1.sendKeys(user1);
		password1.clear();
		password1.sendKeys(pwd1);
		return new HomePage();
		
		
	}
	
	public HomePage LoginUser2(String user2, String pwd2) {
		username2.clear();
		username2.sendKeys(user2);
		password2.clear();
		password2.sendKeys(pwd2);
		return new HomePage();
		
		
	}
	
	
	public HomePage LoginUser3(String user3,String pwd3) {
		username3.clear();
		username3.sendKeys(user3);
		password3.clear();
		password3.sendKeys(pwd3);
		return new HomePage();
		
		
	}
	
	
	public HomePage  SelectRadiobutton() {
		if (driver.findElement(By.xpath("//input[@value='0']")).isSelected()){
			System.out.println("Save MyUserCode and Pwd Radiobutton ALREADY Selected/Checked");
		} else {
			
			driver.findElement(By.xpath("//input[@value='0']")).click();
			System.out.println("Save MyUserCode and Pwd Radiobutton is Selected now");
		}
		return null;
	}
	
	public HomePage ClickonLoginButton() {
		loginbutton.click();
		return new HomePage();
	}
	
	public boolean ValidateGTKLogoAfterLogin() {
		return GtkLogoAfterLogin.isDisplayed();
	}
	
}
