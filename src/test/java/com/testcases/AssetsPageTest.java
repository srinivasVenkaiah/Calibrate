/**
 * @author UmaMaheswararao
 */

package com.testcases;

import java.nio.file.Paths;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.AssetsPage;
import com.pages.LoginPage;
import com.util.ExcelUtility;

public class AssetsPageTest extends BasePage {
	
	LoginPage loginPage;
	AssetsPage assetsPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		assetsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verify_AssetsPage_Test() {
		assetsPage.verify_AssetsPage();
		Reporter.log("Assets Page Verified Successfully",true);
	}

	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_Create_Asset_Test() throws Exception {
		assetsPage.verify_Create_Asset(reader.getOrderedRandomData("Assets", 0, 1), reader.getCellData("Assets", 1, 1), 
				reader.getCellData("Assets", 2, 1), reader.getCellData("Settings", 0, 2), 
				reader.getCellData("Settings", 0, 10), reader.getCellData("Settings", 0, 10), 
				reader.getCellData("Settings", 0, 3), reader.getCellData("Settings", 1, 4), 
				reader.getCellData("Settings", 0, 15), reader.getCellData("Assets", 3, 1).replace(".0", ""),
				reader.getCellData("Assets", 4, 1).replace(".0", ""), reader.getCellData("Assets", 5, 1),
				reader.getCellData("Assets", 6, 1).replace(".0", ""), reader.getCellData("Assets", 7, 1).replace(".0", ""), 
				reader.getCellData("Assets", 8, 1).replace(".0", ""), reader.getCellData("Assets", 9, 1).replace(".0", ""), 
				reader.getCellData("Settings", 0, 1), reader.getCellData("Assets", 10, 1),
				System.getProperty("user.dir")+"\\Files\\volvo.png", System.getProperty("user.dir")+"\\Files\\Empty Report.xlsx", 
				System.getProperty("user.dir")+"\\Files\\Empty Report.xlsx", System.getProperty("user.dir")+"\\Files\\Empty Report.xlsx");
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_mandatory_fields_error_msgs_in_asset_creation_page_Test() {
		assetsPage.verify_mandatory_fields_error_msgs_in_asset_creation_page(reader.getCellData("Assets", 0, 2), 
				reader.getCellData("Assets", 1, 2), reader.getCellData("Assets", 2, 2), 
				reader.getCellData("Settings", 1, 4), reader.getCellData("Assets", 3, 2), 
				reader.getCellData("Settings", 0, 10), reader.getCellData("Assets", 4, 2));
	}

	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_Sort_assets_page_fields_Test() {
		assetsPage.verify_Sort_assets_page_fields();
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_View_total_records_Test() {
		assetsPage.verify_View_total_records();
		Reporter.log("Total no.of assets displayed", true);
	}
	
	@Test(dependsOnMethods="verify_Create_Asset_Test")
	public void verify_Edit_asset_image_and_files_Test() throws Exception {
		assetsPage.verify_Edit_asset_image_and_files(reader.getCellData("Assets", 0, 1), 
				System.getProperty("user.dir")+"\\Files\\aeroindia.jpg", System.getProperty("user.dir")+"\\Files\\Empty Report.xlsx", 
				Paths.get(System.getProperty("user.home"),"Downloads").toString());
	}
	
	@Test(dependsOnMethods="verify_Create_Asset_Test")
	public void verify_Create_existing_asset_and_verify_warning_alert_Test() throws Exception {
		assetsPage.verify_Create_existing_asset_and_verify_warning_alert(
				reader.getCellData("Assets", 0, 1), reader.getCellData("Settings", 0, 10), 
				reader.getCellData("Settings", 0, 10), reader.getCellData("Settings", 1, 4));
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_Add_comment_for_the_asset_Test() throws Exception {
		assetsPage.verify_Add_comment_for_the_asset(reader.getOrderedRandomData("Assets", 0, 3));
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_Close_asset_Test() throws Exception {
		assetsPage.verify_Close_asset();
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_Filter_items_Test() throws Exception {
		assetsPage.verify_Filter_items();
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_Filter_by_manufacturer_Test() throws Exception {
		assetsPage.verify_Filter_by_manufacturer();
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_Filter_by_locations_Test() throws Exception {
		assetsPage.verify_Filter_by_locations(reader.getCellData("Assets", 0, 5));
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_Filter_by_types_Test() throws Exception {
		assetsPage.verify_Filter_by_types(reader.getCellData("Assets", 0, 6));
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_Filter_by_status_Test() throws Exception {
		assetsPage.verify_Filter_by_status(reader.getCellData("Assets", 0, 7));
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_Filter_by_Calibration_status_Test() throws Exception {
		assetsPage.verify_Filter_by_Calibration_status(reader.getCellData("Assets", 0, 8));
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_Filter_by_range_Test() throws Exception {
		assetsPage.verify_Filter_by_range(reader.getCellData("Assets", 0, 9).replace(".0", ""), 
				reader.getCellData("Assets", 0, 10).replace(".0", ""));
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_Request_for_calibration_and_verify_the_requested_asset_in_calibration_requests_list_Test() throws Exception {
		assetsPage.verify_Request_for_calibration_and_verify_the_requested_asset_in_calibration_requests_list(reader.getCellData("Assets", 0, 1));
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_Add_filter_by_custom_fields_Test() throws Exception {
		assetsPage.verify_Add_filter_by_custom_fields(reader.getCellData("Settings", 0, 1));
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_Add_control_for_the_asset_Test() throws Exception {
		assetsPage.verify_Add_control_for_the_asset(
				reader.getCellData("Assets", 0, 11).replace(".0", ""), reader.getCellData("Settings", 0, 12));
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test", enabled=false)
	public void verify_Change_asset_calibration_status_to_out_of_calibration_Test() throws Exception {
		assetsPage.verify_Change_asset_calibration_status_to_out_of_calibration();
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_View_asset_history_Test() throws Exception {
		assetsPage.verify_View_asset_history();
	}
	
	@Test(dependsOnMethods="verify_AssetsPage_Test")
	public void verify_Download_crtificate_Test() throws Exception {
		assetsPage.verify_Download_crtificate(Paths.get(System.getProperty("user.home"),"\\Downloads").toString(), 
				reader.getCellData("Assets", 0, 12));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


	
}
