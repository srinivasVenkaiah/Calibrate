/**
 * @author UmaMaheswararao
 */

package com.testcases;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.AssetsPage;
import com.pages.CapturePage;
import com.pages.LoginPage;
import com.util.ExcelUtility;

public class CapturePageTest extends BasePage {
	
	LoginPage loginPage;
	AssetsPage assetsPage;
	CapturePage capturePage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		assetsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		capturePage = assetsPage.navigate_to_Capture();
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void verify_CapturePage_Test() {
		capturePage.verify_CapturePage();
		Reporter.log("Capture Page Verified Successfully",true);
	}

	@Test
	public void verify_Create_usage_log_without_job_number_and_verify_error_msg_Test() throws Exception {
		capturePage.verify_Create_usage_log_without_job_number_and_verify_error_msg(reader.getCellData("Assets", 0, 1));
	}
	
	@Test
	public void verify_Create_usage_log_Test() throws Exception {
		capturePage.verify_Create_usage_log(reader.getCellData("Assets", 0, 1), 
				reader.getCellData("Capture", 0, 1).replace(".0", ""), reader.getCellData("Settings", 0, 12), 
				reader.getCellData("Capture", 1, 1), reader.getCellData("Capture", 2, 1).replace(".0", ""), 
				reader.getCellData("Capture", 3, 1).replace(".0", ""));
	}
	
	@Test(dependsOnMethods="verify_Create_usage_log_Test")
	public void capture_asset_greater_than_70_percent_and_lessthan_100_percent_and_verify_the_asset_presence_in_Upcoming_calibrations_list_Test() throws Exception {
		capturePage.capture_asset_greater_than_70_percent_and_lessthan_100_percent_and_verify_the_asset_presence_in_Upcoming_calibrations_list(reader.getCellData("Assets", 0, 1), 
				reader.getCellData("Capture", 0, 2), reader.getCellData("Capture", 0, 2).replace(".0", ""), 
				reader.getCellData("Capture", 1, 2).replace(".0", ""));
	}
	
	@Test(dependsOnMethods="capture_asset_greater_than_70_percent_and_lessthan_100_percent_and_verify_the_asset_presence_in_Upcoming_calibrations_list_Test")
	public void capture_asset_100_percent_and_verify_the_asset_presence_in_Out_of_calibration_list_Test() throws Exception {
		capturePage.capture_asset_100_percent_and_verify_the_asset_presence_in_Out_of_calibration_list(reader.getCellData("Assets", 0, 1), 
				reader.getCellData("Capture", 0, 3).replace(".0", ""), reader.getCellData("Capture", 1, 3).replace(".0", ""));
	}
	
	@Test(dependsOnMethods="verify_Create_usage_log_Test")
	public void verify_Add_multiple_jobs_Test() throws Exception {
		capturePage.verify_Add_multiple_jobs(reader.getCellData("Assets", 0, 1), 
				reader.getCellData("Capture", 0, 4).replace(".0", ""), reader.getCellData("Capture", 1, 4).replace(".0", ""), 
				reader.getCellData("Capture", 2, 4).replace(".0", ""), reader.getCellData("Capture", 3, 4).replace(".0", ""));
		Reporter.log("Multiple jobs added", true);
	}
	
	@Test(dependsOnMethods="verify_Create_usage_log_Test")
	public void verify_Mandatory_fields_in_asset_log_page_Test() throws Exception {
		capturePage.verify_Mandatory_fields_in_asset_log_page(reader.getCellData("Assets", 0, 1), 
				reader.getCellData("Capture", 0, 4).replace(".0", ""));
	}
	
	@Test(dependsOnMethods="verify_Create_usage_log_Test")
	public void verify_Delete_job_Test() throws Exception {
		capturePage.verify_Delete_job(reader.getCellData("Assets", 0, 1), 
				reader.getCellData("Capture", 0, 5).replace(".0", ""), reader.getCellData("Capture", 1, 5).replace(".0", ""));
	}
	
	
	
	
	
	
}
