package com.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.AssetsPage;
import com.pages.CompaniesPage;
import com.pages.LoginPage;
import com.util.ExcelUtility;

public class CompaniesPageTest extends BasePage {
	LoginPage loginPage;
	AssetsPage assetsPage;
	CompaniesPage companiesPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		assetsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		companiesPage = assetsPage.navigate_to_Companies();
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void verify_CompaniesPage_Test() {
		companiesPage.verify_CompaniesPage();
		Reporter.log("Companies Page Verified Successfully",true);
	}

	@Test(dependsOnMethods="verify_CompaniesPage_Test")
	public void verify_Create_company_Test() throws Exception {
		companiesPage.verify_Create_new_company(reader.getOrderedRandomData("Companies", 0, 1), 
				reader.getCellData("Companies", 1, 1), reader.getCellData("Companies", 2, 1), 
				reader.getCellData("Companies", 3, 1), reader.getCellData("Companies", 4, 1), 
				reader.getCellData("Companies", 5, 1), reader.getCellData("Companies", 6, 1), 
				reader.getCellData("Companies", 7, 1), reader.getCellData("Companies", 8, 1), 
				reader.getCellData("Companies", 9, 1), System.getProperty("user.dir")+"\\Files\\volvo.png");
	}
	
	@Test(dependsOnMethods="verify_CompaniesPage_Test")
	public void verify_mandatory_fields_error_messages() throws Exception {
		companiesPage.verify_mandatory_fields_error_messages();
		Reporter.log("Company name field error message displayed successfully", true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
