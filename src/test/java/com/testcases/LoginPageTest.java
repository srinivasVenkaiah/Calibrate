/**
 * @author UmaMaheswararao
 */

package com.testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.AssetsPage;
import com.pages.LoginPage;

public class LoginPageTest extends BasePage {
	
	LoginPage loginPage;
	AssetsPage assetsPage;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verify_LoginPage_title_Test(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "login");
		Reporter.log("LoginPage Title Verified", true);
	}
	
	@Test(dependsOnMethods="verify_LoginPage_title_Test")
	public void LoginTest() throws Exception{
		assetsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(dependsOnMethods="verify_LoginPage_title_Test")
	public void verify_Valuechain_wesite_navigation_on_clicking_Valuechain_logo_Test() throws Exception{
		loginPage.verify_Valuechain_wesite_navigation_on_clicking_Valuechain_logo("Valuechain | Smart Manufacturing Software to Create World-Class Supply Chains");
		Reporter.log("User able to navigate valuechain website on clicking Valuechain log", true);
	}
	
	
	
	

}
