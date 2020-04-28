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
import com.pages.LoginPage;
import com.pages.SettingsPage;
import com.util.ExcelUtility;

public class SettingsPageTest extends BasePage {
	
	LoginPage loginPage;
	AssetsPage assetsPage;
	SettingsPage settingsPage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		assetsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		settingsPage = assetsPage.navigate_to_Settings();
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void verify_Custom_fields_page_Test() {
		settingsPage.verify_Custom_fields_page();
		Reporter.log("Custom Fields Page Verified Successfully",true);
	}
	
	@Test
	public void verify_Control_units_page_Test() {
		settingsPage.verify_Control_units_page();
		Reporter.log("Control Units Page Verified Successfully",true);
	}
	
	@Test
	public void verify_Test_results_page_Test() {
		settingsPage.verify_Test_results_page();
		Reporter.log("Test Results Page Verified Successfully",true);
	}
	
	// Custom fields page
	@Test(dependsOnMethods="verify_Custom_fields_page_Test")
	public void verify_Add_field_to_Assets_fields_Test() throws Exception {
		settingsPage.verify_Custom_fields_page();
		settingsPage.verify_Add_field_to_Assets_fields(reader.getOrderedRandomData("Settings", 0, 1));
	}
	
	@Test(dependsOnMethods="verify_Custom_fields_page_Test")
	public void verify_Add_field_to_Manufacturer_Test() throws Exception {
		settingsPage.verify_Custom_fields_page();
		settingsPage.verify_Add_field_to_Manufacturer(reader.getOrderedRandomData("Settings", 0, 2));
	}
	
	@Test(dependsOnMethods="verify_Custom_fields_page_Test")
	public void verify_Add_field_to_Types_Test() throws Exception {
		settingsPage.verify_Custom_fields_page();
		settingsPage.verify_Add_field_to_Types(reader.getOrderedRandomData("Settings", 0, 3));
	}
	
	@Test(dependsOnMethods="verify_Custom_fields_page_Test")
	public void verify_Add_Calibration_status_Test() throws Exception {
		settingsPage.verify_Custom_fields_page();
		settingsPage.verify_Add_Calibration_status(reader.getCellData("Settings", 0, 4), 
				reader.getOrderedRandomData("Settings", 1, 4));
	}
	
	@Test(dependsOnMethods="verify_Custom_fields_page_Test")
	public void verify_Add_Status_Test() throws Exception {
		settingsPage.verify_Custom_fields_page();
		settingsPage.verify_Add_Status(reader.getOrderedRandomData("Settings", 0, 5));
	}
	
	@Test(dependsOnMethods="verify_Custom_fields_page_Test")
	public void verify_Edit_field_name_Test() throws Exception {
		settingsPage.verify_Custom_fields_page();
		settingsPage.verify_Edit_field_name(reader.getOrderedRandomData("Settings", 0, 6), 
				reader.getOrderedRandomData("Settings", 1, 6));
	}
	
	@Test(dependsOnMethods="verify_Custom_fields_page_Test")
	public void verify_Edit_field_name_with_no_value_Test() throws Exception {
		settingsPage.verify_Custom_fields_page();
		settingsPage.verify_Edit_field_name_with_no_value();
	}
	
	@Test(dependsOnMethods="verify_Custom_fields_page_Test")
	public void verify_Select_all_sub_fields_from_the_main_field_Test() throws Exception {
		settingsPage.verify_Custom_fields_page();
		settingsPage.verify_Select_all_sub_fields_from_the_main_field(reader.getCellData("Settings", 0, 7));
	}
	
	@Test(dependsOnMethods="verify_Custom_fields_page_Test")
	public void verify_Move_active_fields_to_archived_and_archive_field_to_active_Test() throws Exception {
		settingsPage.verify_Custom_fields_page();
		settingsPage.verify_Move_active_fields_to_archived_and_archive_field_to_active(reader.getCellData("Settings", 0, 8));
	}
	
	@Test(dependsOnMethods="verify_Custom_fields_page_Test")
	public void verify_Search_custom_field_Test() throws Exception {
		settingsPage.verify_Custom_fields_page();
		settingsPage.verify_Search_custom_field(reader.getCellData("Settings", 0, 9));
	}
	
	@Test(dependsOnMethods="verify_Custom_fields_page_Test")
	public void verify_Add_location_to_custom_fields_Test() {
		settingsPage.verify_Custom_fields_page();
		settingsPage.verify_Add_location_to_custom_fields(reader.getOrderedRandomData("Settings", 0, 10));
	}
	
	@Test(dependsOnMethods="verify_Add_location_to_custom_fields_Test")
	public void verify_Add_Area_manager_to_the_location_Test() throws Exception {
		settingsPage.verify_Custom_fields_page();
		settingsPage.verify_Add_Area_manager_to_the_location(reader.getCellData("Settings", 0, 10), 
				 reader.getCellData("Settings", 1, 11));
	}
	
	@Test(dependsOnMethods="verify_Add_location_to_custom_fields_Test")
	public void verify_Enable_and_Disable_locations_and_verify_its_presence_in_assets_creation_page_Test() throws Exception {
		settingsPage.verify_Custom_fields_page();
		settingsPage.verify_Enable_and_Disable_locations_and_verify_its_presence_in_assets_creation_page(reader.getCellData("Settings", 0, 10));
	}
	
	@Test(dependsOnMethods="verify_Add_location_to_custom_fields_Test")
	public void verify_Edit_loaction_name_Test() throws Exception {
		settingsPage.verify_Custom_fields_page();
		settingsPage.verify_Edit_loaction_name();
	}
	
	// Control units page
	@Test(dependsOnMethods="verify_Control_units_page_Test")
	public void verify_Add_unit_Test() throws Exception {
		settingsPage.verify_Control_units_page();
		settingsPage.verify_Add_unit(reader.getOrderedRandomData("Settings", 0, 12), 
				reader.getCellData("Settings", 1, 12).replace(".0", ""));
	}
	
	@Test(dependsOnMethods="verify_Add_unit_Test")
	public void verify_Add_existing_unit_and_verify_the_error_message_Test() throws Exception {
		settingsPage.verify_Control_units_page();
		settingsPage.verify_Add_existing_unit_and_verify_the_error_message(reader.getCellData("Settings", 0, 12), 
				reader.getCellData("Settings", 1, 12).replace(".0", ""), reader.getCellData("Settings", 0, 13));
	}
	
	@Test(dependsOnMethods="verify_Control_units_page_Test")
	public void verify_Edit_and_Delete_unit_Test() throws Exception {
		settingsPage.verify_Control_units_page();
		settingsPage.verify_Edit_and_Delete_unit(reader.getOrderedRandomData("Settings", 0, 14), 
				reader.getCellData("Settings", 1, 14).replace(".0", ""), reader.getOrderedRandomData("Settings", 2, 14));
	}
	
	// Test results page
	@Test(dependsOnMethods="verify_Test_results_page_Test")
	public void verify_Add_result_sheet_and_verify_its_presence_in_assets_creation_page_result_sheet_dropdown_Test() throws Exception {
		settingsPage.verify_Test_results_page();
		settingsPage.verify_Add_result_sheet_and_verify_its_presence_in_assets_creation_page_result_sheet_dropdown(reader.getOrderedRandomData("Settings", 0, 15));
	}
	
	@Test(dependsOnMethods="verify_Test_results_page_Test")
	public void verify_Add_and_Delete_results_sheet_rows_and_columns_Test() throws Exception {
		settingsPage.verify_Test_results_page();
		settingsPage.verify_Add_and_Delete_results_sheet_rows_and_columns(reader.getOrderedRandomData("Settings", 0, 16),
				reader.getCellData("Settings", 1, 16), reader.getCellData("Settings", 2, 16));
	}
	
	@Test(dependsOnMethods="verify_Test_results_page_Test")
	public void verify_Copy_template_Test() throws Exception {
		settingsPage.verify_Test_results_page();
		settingsPage.verify_Copy_template(reader.getOrderedRandomData("Settings", 0, 17));
	}
	
	@Test(dependsOnMethods="verify_Test_results_page_Test")
	public void verify_Up_version_and_Publish_up_version_Test() throws Exception {
		settingsPage.verify_Test_results_page();
		settingsPage.verify_Up_version_and_Publish_up_version(reader.getOrderedRandomData("Settings", 0, 18), 
				reader.getCellData("Settings", 1, 18));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
