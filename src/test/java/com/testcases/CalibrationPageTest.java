/**
 * @author UmaMaheswararao
 */

package com.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.AssetsPage;
import com.pages.CalibrationPage;
import com.pages.LoginPage;
import com.util.ExcelUtility;

public class CalibrationPageTest extends BasePage {
	
	LoginPage loginPage;
	AssetsPage assetsPage;
	CalibrationPage calibrationPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		assetsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		calibrationPage = assetsPage.navigate_to_Clibration();
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void calibrationPage_Verification_Test() throws Exception {
		calibrationPage.verify_CalibrationPage();
	}
	
	@Test
	public void verify_Out_of_calibration_records_Test() throws Exception {
		calibrationPage.verify_Out_of_calibration_records();
	}
	
	@Test
	public void verify_Issue_recall_option_for_out_of_calibration_assets_Test() throws Exception {
		calibrationPage.verify_Issue_recall_option_for_out_of_calibration_assets();
	}
	
	@Test
	public void verify_Send_asset_to_calibration_option_Test() throws Exception {
		calibrationPage.verify_Send_asset_to_calibration_option();
	}
	
	@Test
	public void verify_Clibration_records_Test() throws Exception {
		calibrationPage.verify_Clibration_records();
	}
	
	@Test
	public void verify_Send_asset_to_external_calibration_Test() throws Exception {
		calibrationPage.verify_Send_asset_to_external_calibration(reader.getCellData("Companies", 0, 1), 
				reader.getCellData("Calibration", 0, 1).replace(".0", ""), reader.getCellData("Calibration", 1, 1).replace(".0", ""));
	}
	
	@Test
	public void verify_Change_supplier_company_Test() throws Exception {
		calibrationPage.verify_Change_supplier_company(reader.getCellData("Companies", 0, 1));
	}
	
	@Test(enabled=false)
	public void verify_Internal_calibration_Test() throws Exception {
		calibrationPage.verify_Internal_calibration();
	}
	
	@Test
	public void verify_Remove_allocated_asset_Test() throws Exception {
		calibrationPage.verify_Remove_allocated_asset();
	}
	
	@Test(enabled=false)
	public void verify_Book_in_asset_for_external_calibration_Test() throws Exception {
		calibrationPage.verify_Book_in_asset_for_external_calibration(
				System.getProperty("user.dir")+"\\Files\\volvo.png");
	}
	
	@Test
	public void verify_Book_in_without_uploading_file_and_verify_error_message_Test() throws Exception {
		calibrationPage.verify_Book_in_without_uploading_file_and_verify_error_message();
	}
	
	@Test
	public void verify_Requests_tab_records_Test() throws Exception {
		calibrationPage.verify_Requests_tab_records();
	}
	
	@Test
	public void verify_Issue_recall_option_for_requests_tab_assets_Test() throws Exception {
		calibrationPage.verify_Issue_recall_option_for_requests_tab_assets();
	}
	
	@Test
	public void verify_Send_requested_asset_for_calibration_Test() throws Exception {
		calibrationPage.verify_Send_requested_asset_for_calibration();
	}
	
	@Test
	public void verify_Send_asset_to_calibration_without_selecting_asset_and_verify_error_message_Test() throws Exception {
		calibrationPage.verify_Send_asset_to_calibration_without_selecting_asset_and_verify_error_message();
	}
	
	@Test
	public void verify_Upcoming_calibrations_tab_records_Test() throws Exception {
		calibrationPage.verify_Upcoming_calibrations_tab_records();
	}
	
	@Test
	public void verify_Issue_recall_option_for_upcoming_calibrations_tab_assets_Test() throws Exception {
		calibrationPage.verify_Issue_recall_option_for_upcoming_calibrations_tab_assets();
	}
	
	@Test
	public void verify_Send_upcoming_calibration_asset_to_calibration_Test() throws Exception {
		calibrationPage.verify_Send_upcoming_calibration_asset_to_calibration();
	}
	
	
	
	
	
	
	
	
	
	
}
