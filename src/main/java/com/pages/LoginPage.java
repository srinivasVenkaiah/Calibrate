/**
 * @author UmaMaheswararao
 */

package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.base.BasePage;
import com.util.ActionUtils;

public class LoginPage extends BasePage {

	// Initializing the Page Objects:................................................................
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	// Objects Repository(OR):........................................................................
	By username = By.id("txtLoginName");
	By password = By.name("password");
	By loginBtn = By.id("btnLogin");
	By valuechainLogo = By.xpath("//img[contains(@src,'ex.png')]");
	By menuBtn = By.xpath("(//i[contains(@style,'color: #FFFFFF;')])[1]");
	By NewCalibrate = By.xpath("//span[text()='Calibrate']");
	By assetsLink = By.linkText("Assets");
	By dashBoardLink = By.xpath("//span[text()='Dashboard']");






	// Actions:......................................................................................
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}

	public AssetsPage login(String un, String pwd){
		ActionUtils.waitForVisibleThenType(driver, username, un);
		ActionUtils.waitForVisibleThenType(driver, password, pwd);
		ActionUtils.ajaxJsClick(driver, loginBtn);
		ActionUtils.ajaxJsClick(driver, menuBtn);
		ActionUtils.ajaxJsClick(driver, NewCalibrate);
		Assert.assertTrue(ActionUtils.getElement(driver, assetsLink).isDisplayed(), "Login in unsuccessful");
		Reporter.log("Login successful", true);
		return new AssetsPage();
	}

	public void verify_Valuechain_wesite_navigation_on_clicking_Valuechain_logo(String expTitle) throws Exception {
		ActionUtils.waitForAjax(driver);
		ActionUtils.click(driver, valuechainLogo);
		ActionUtils.waitForAjax(driver);
		ActionUtils.switchToNewWindow(driver);
		Thread.sleep(3000);
		String title = driver.getTitle();
		Reporter.log("Title of the page is: "+title, true);
		Assert.assertTrue(title.equalsIgnoreCase(expTitle), "Unable to navigate valuechain website");
	}





















}
