/**
 * 
 */
package com.gtkv1qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gtkv1qa.base.LaunchConfigBase;

/**
 * @author mahenderd
 *
 */
public class HomePage extends LaunchConfigBase {

	@FindBy(className="logoutout")
	WebElement Logoutbutton;
	

	public HomePage() {
	PageFactory.initElements(driver, this);
}	
	
	public void Logout() {
		Logoutbutton.click();
	}
	
	
}
