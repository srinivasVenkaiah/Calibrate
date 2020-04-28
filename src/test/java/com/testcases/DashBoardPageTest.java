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
import com.pages.DashBoardPage;
import com.pages.LoginPage;
import com.util.ExcelUtility;

public class DashBoardPageTest extends BasePage {
	
	LoginPage loginPage;
	AssetsPage assetsPage;
	DashBoardPage dashBoardPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		assetsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		dashBoardPage = assetsPage.navigate_to_DashBoard();
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verify_DashBoardPage_Test(){
		Assert.assertTrue(dashBoardPage.verify_DashBoard(), "Dashboard Page Not Present - Test FAIL");
		Reporter.log("DashBoard Page Verified", true);
	}
	
	@Test
	public void verify_Create_New_Board_functionality_Test() throws Exception{
		dashBoardPage.Create_New_Board_functionality(reader.getOrderedRandomData("Dashboard", 0, 1)); 
		Reporter.log("New tab creation is functional", true);
	}
	
	@Test(dependsOnMethods= "verify_Create_New_Board_functionality_Test")
	public void verify_Add_Reports_to_Board_Test() throws Exception {
		dashBoardPage.verify_Add_Reports_to_Board(reader.getCellData("Dashboard", 0, 1), 
				reader.getCellData("Analyse", 0, 1), reader.getCellData("Analyse", 0, 1));
		Reporter.log("All Selected Reports Added to the Tab Successfully",true);
	}
	
	@Test(dependsOnMethods= "verify_Add_Reports_to_Board_Test")
	public void verify_Delete_selective_report_from_the_Board_Test() throws Exception {
		dashBoardPage.verify_Delete_selective_report_from_the_Board(reader.getCellData("Dashboard", 0, 1));
		Reporter.log("Selected Report deleted from the Tab Successfully",true);
	}
	
	@Test(dependsOnMethods= {"verify_Create_New_Board_functionality_Test"})
	public void verify_Delete_selective_Board_Test() throws Exception {
		dashBoardPage.verify_Delete_selective_Board(reader.getCellData("Dashboard", 0, 2));
		Reporter.log("Tab Deleted Successfully",true);
	}
	
	@Test(dependsOnMethods= {"verify_Create_New_Board_functionality_Test"})
	public void Preview_Option_Test() throws Exception {
		dashBoardPage.verify_Preview_Option();
		Reporter.log("Preview Option is functional",true);
	}
	
	@Test(dependsOnMethods= {"verify_Create_New_Board_functionality_Test"}, enabled=false)
	public void Share_Report_Option_Test() throws Exception {
		dashBoardPage.verify_Share_Report_Option(reader.getCellData("Dashboard", 0, 1), 
				reader.getCellData("Dashboard", 0, 3));
		Reporter.log("Share Option is functional",true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
