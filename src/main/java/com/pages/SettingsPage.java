/**
 * @author UmaMaheswararao
 */

package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.BasePage;
import com.util.ActionUtils;
import com.util.JavascriptLibrary;

public class SettingsPage extends BasePage {
	// Initializing the Page Objects:................................................................
	public SettingsPage() {
		PageFactory.initElements(driver, this);
	}

	// Objects Repository(OR):........................................................................
	@FindBy(xpath="//span[text()='Custom Fields']")
	WebElement customFieldsPage;

	@FindBy(xpath="//a[contains(text(),'Custom Fields')]")
	WebElement customFieldsLink;

	@FindBy(xpath="//span[text()='Control Units']")
	WebElement controlUnitsPage;

	@FindBy(xpath="//a[contains(text(),'Control Units')]")
	WebElement controlUnitsLink;

	@FindBy(xpath="//span[text()='Test Results']")
	WebElement testResultsPage;

	@FindBy(linkText="Test Results")
	WebElement testResultsLink;

	// Custom fields
	// Create new field in Asset fields
	By AssetFileds = By.xpath("(//td[contains(.,'AssetsFields')])[1]");
	By assetFieldNameTextBox = By.xpath("(//input[@placeholder='Double click the field to input text.'])[1]");

	// Manufacturer
	By Manufacturer = By.xpath("(//td[contains(.,'Manufacturer')])[1]");
	By manufacturerFieldNameTextBox = By.xpath("(//input[@placeholder='Double click the field to input text.'])[2]");

	// Types
	By Types = By.xpath("(//td[contains(.,'Types')])[1]");
	By typesFieldNameTextBox = By.xpath("(//input[@placeholder='Double click the field to input text.'])[3]");

	// Calibration status
	By CalibrationStatus = By.xpath("(//td[contains(.,'Calibration Status')])[1]");
	By selectCalibrationStatus = By.xpath("(//td[@class='col-md-7']//select)[4]");
	By calibrationStatusField = By.xpath("(//td[@class='col-md-5']//input)[4]");

	// Status
	By Status = By.xpath("(//td[contains(text(),'Status')])[2]");
	By statusTextBox = By.xpath("(//input[@placeholder='Double click the field to input text.'])[5]");

	// Edit Field
	By editableField = By.xpath("(//input[@placeholder='Double click the field to input text.'])[1]/preceding::tr[2]//input[@placeholder='Please enter the field name.']");
	By firstEditableField = By.xpath("(//input[@placeholder='Please enter the field name.'])[1]");
	By saveFailedInvalidNameMsg = By.xpath("//div[contains(text(),'Save failed :Invalid Name.')]");

	// Move active to archive and archive to active
	By moveToArchive = By.xpath("//button[contains(@id,'activeToArchived')]");
	By moveToActive = By.xpath("//button[contains(@id,'archivedToActive')]");

	// Search custom field
	By customFieldSeacrhBox = By.xpath("//input[contains(@id,'searchbox')]");
	By customFieldSearchButton = By.xpath("//a[contains(@title,'Search')]");

	// Custom fields location
	By locationTab = By.linkText("Location");
	By addLocationBtn = By.xpath("//a[@title='Create a Location']");
	By nameFieldLocation = By.id("FL_Name");
	By saveLocationBtn = By.id("btnSaveLocation");
	By nextBtn = By.linkText("Next");
	By lastPage = By.xpath("//a[text()='Next']/../preceding::li[1]/a");

	// Enable and Disable location
	By locationEnableStatus = By.xpath("//a[@name='fromA'][contains(.,'LOC6')]/../..//td[4]//input");

	// Rename location
	By cancelLocBtn = By.xpath("//button[contains(@onclick,'CloseLocationModal')]");

	// Control units
	// Add unit
	By unitName = By.xpath("//input[contains(@id,'NewUnitName')]");
	By quantity = By.xpath("//input[contains(@id,'AddNewUnit')]");
	By savedFailedNameAlreadyExistsMsg = By.xpath("//div[contains(.,'Save failed Name already exists')]");
	By removeLastUnitBtn = By.xpath("(//i[contains(@title,'Remove')])[last()]");

	// Test results
	By addSheetBtn = By.xpath("//a[contains(@title,'ADD')]");
	By saveSheetBtn = By.xpath("//a[contains(@title,'Save')]");
	By sheetNameField = By.xpath("//input[contains(@id,'SheetName')]");
	By sheetTitle = By.xpath("//span[contains(@id,'mainTitle')]");
	By sheetBackBtn = By.xpath("//a[contains(@onclick,'Sheet.Back')]");
	By sheetSearchBox = By.xpath("//input[contains(@id,'searchResult')]");
	By sheetSearchBtn = By.xpath("//a[contains(@title,'Search')]");
	By newRowField = By.xpath("//input[contains(@placeholder,'New Row')]");
	By newColumnField = By.xpath("//input[contains(@placeholder,'New Column')]");
	By noOfRows = By.xpath("//table[contains(@class,'text-center')]//tr//td[1]");
	By noOfColumns = By.xpath("//table[contains(@class,'text-center')]//th");
	By removeRowOrColumn = By.xpath("//button[text()='X']");
	By moreDD = By.xpath("//a[contains(.,'MORE')]");
	By copyOption = By.xpath("//a[contains(@onclick,'SheetCopy')]");
	By upVersionOption = By.xpath("//font[text()='Up Version']");
	By versionDD = By.xpath("//select[contains(@id,'Version')]");
	By publishBtn = By.xpath("//button[@onclick='Sheet.Publish()']");
	By versionAlertMsg = By.xpath("//div[@class='bootbox-body'][contains(.,'This operation is irreversible."
			+ "It will Publish Version 2 of this Sheet and will immediately be available for capturing.Would like continue?')]");
	By okBtn = By.xpath("//button[@data-bb-handler='confirm'][contains(.,'OK')]");
	By publishedMsg = By.xpath("//span[contains(text(),' Published')]");


















	// Actions:......................................................................................
	public void verify_Custom_fields_page() {
		ActionUtils.waitForElementVisibility(driver, customFieldsPage);
		JavascriptLibrary.javascriptClickElement(driver, customFieldsPage);
		Assert.assertTrue(customFieldsLink.isDisplayed(), "Unable to Navigate Custom Fields Page");
	}

	public void verify_Control_units_page() {
		ActionUtils.waitForElementVisibility(driver, controlUnitsPage);
		JavascriptLibrary.javascriptClickElement(driver, controlUnitsPage);
		Assert.assertTrue(controlUnitsLink.isDisplayed(), "Unable to Navigate Control Units Page");
	}

	public void verify_Test_results_page() {
		ActionUtils.waitForElementVisibility(driver, testResultsPage);
		JavascriptLibrary.javascriptClickElement(driver, testResultsPage);
		Assert.assertTrue(testResultsLink.isDisplayed(), "Unable to Navigate Terms & Options Page");
	}

	// Custom Fields:---------------------------------------------------------------------------------------------------------------------
	public void verify_Add_field_to_Assets_fields(String fieldName) throws Exception {
		ActionUtils.jsClick(driver, AssetFileds);
		ActionUtils.doubleClickWebelement(driver, assetFieldNameTextBox);
		ActionUtils.clearAndType(driver, assetFieldNameTextBox, fieldName + Keys.ENTER);
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='"+fieldName+"']")).isDisplayed(), "New Asset field not added");
		Reporter.log("New Assets field added", true);
	}

	public void verify_Add_field_to_Manufacturer(String fieldName) throws Exception {
		ActionUtils.jsClick(driver, Manufacturer);
		ActionUtils.doubleClickWebelement(driver, manufacturerFieldNameTextBox);
		ActionUtils.clearAndType(driver, manufacturerFieldNameTextBox, fieldName + Keys.ENTER);
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='"+fieldName+"']")).isDisplayed(), "New Manufacturer field not added");
		Reporter.log("New Manufacturer field added", true);
	}

	public void verify_Add_field_to_Types(String fieldName) throws Exception {
		ActionUtils.jsClick(driver, Types);
		ActionUtils.doubleClickWebelement(driver, typesFieldNameTextBox);
		ActionUtils.clearAndType(driver, typesFieldNameTextBox, fieldName + Keys.ENTER);
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='"+fieldName+"']")).isDisplayed(), "New Types field not added");
		Reporter.log("New Types field added", true);
	}

	public void verify_Add_Calibration_status(String option, String status) throws Exception {
		ActionUtils.jsClick(driver, CalibrationStatus);
		ActionUtils.doubleClickWebelement(driver, calibrationStatusField);
		ActionUtils.ajaxSelectElementByVisibleText(driver, selectCalibrationStatus, option);
		ActionUtils.clearAndType(driver, calibrationStatusField, status + Keys.ENTER);
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='"+status+"']")).isDisplayed(), "New Calibration status not added");
		Reporter.log("New Calibration status added", true);
	}

	public void verify_Add_Status(String fieldName) throws Exception {
		ActionUtils.jsClick(driver, Status);
		ActionUtils.doubleClickWebelement(driver, statusTextBox);
		ActionUtils.clearAndType(driver, statusTextBox, fieldName);
		ActionUtils.getElement(driver, statusTextBox).sendKeys(Keys.ENTER);
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='"+fieldName+"']")).isDisplayed(), "New Status not added");
		Reporter.log("New Status added", true);
	}

	public void verify_Edit_field_name(String fieldName, String newName) throws Exception {
		ActionUtils.jsClick(driver, AssetFileds);
		ActionUtils.doubleClickWebelement(driver, assetFieldNameTextBox);
		ActionUtils.clearAndType(driver, assetFieldNameTextBox, fieldName + Keys.ENTER);
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='"+fieldName+"']")).isDisplayed(), "Field not added");
		Reporter.log("Field added", true);
		// Edit name
		ActionUtils.doubleClickWebelement(driver, driver.findElement(By.xpath("//p[text()='"+fieldName+"']")));
		ActionUtils.clearAndType(driver, editableField, newName + Keys.ENTER);
		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.xpath("//p[text()='"+newName+"']")).isDisplayed(), "Field not updated");
		Reporter.log("Field updated", true);
	}

	public void verify_Edit_field_name_with_no_value() throws Exception {
		ActionUtils.jsClick(driver, AssetFileds);
		List<WebElement> fields = ActionUtils.getElements(driver, By.xpath("//p"));
		ActionUtils.doubleClickWebelement(driver, fields.get(0));
		ActionUtils.getElement(driver, firstEditableField).sendKeys(Keys.CONTROL+"a" + Keys.BACK_SPACE + Keys.ENTER);
		Assert.assertTrue(ActionUtils.getElement(driver, saveFailedInvalidNameMsg).isDisplayed(), "No error message displayed for no input value");
		Reporter.log("Error message displayed for no input value", true);
	}

	public void verify_Select_all_sub_fields_from_the_main_field(String field) throws Exception {
		ActionUtils.jsClick(driver, By.xpath("(//td[contains(.,'"+field+"')])[1]"));
		List<WebElement> checkBoxList = ActionUtils.getElements(driver, By.xpath("(//td[contains(.,'"+field+"')])[1]//ancestor::div[@class='panel panel-default']//span[@class='box']"));
		int unCheckedCount = checkBoxList.size()-1;
		Reporter.log("No.of unselected fields: "+unCheckedCount, true);
		ActionUtils.jsClick(driver, By.xpath("(//td[contains(.,'"+field+"')])[1]//preceding::span[1]"));
		List<WebElement> tickList = ActionUtils.getElements(driver, By.xpath("(//td[contains(.,'"+field+"')])[1]//ancestor::div[@class='panel panel-default']//span[@class='check']"));
		int checkedCount = tickList.size()-1;
		Reporter.log("No.of selected fields after selecting all: "+checkedCount, true);
		Assert.assertEquals(unCheckedCount, checkedCount, "All sub fileds not selected");
		Reporter.log("All sub fileds selected", true);
	}

	public void verify_Move_active_fields_to_archived_and_archive_field_to_active(String field) throws Exception {
		SoftAssert a = new SoftAssert();
		// Active to Archive
		ActionUtils.jsClick(driver, By.xpath("(//td[contains(.,'"+field+"')])[1]"));
		int activeCount = Integer.parseInt(ActionUtils.readText(driver, By.xpath("(//td[contains(.,'"+field+"')])[1]//span")));
		int archiveCount = Integer.parseInt(ActionUtils.readText(driver, By.xpath("(//td[contains(.,'"+field+"')])[2]//span")));
		Reporter.log("No.of ACTIVE fields count before moving to ARCHIVE: "+activeCount, true);
		Reporter.log("No.of ARCHIVE fields count before moving to ARCHIVE: "+archiveCount, true);
		List<WebElement> checkBoxList = ActionUtils.getElements(driver, By.xpath("(//td[contains(.,'"+field+"')])[1]//ancestor::div[@class='panel panel-default']//span[@class='box']"));
		ActionUtils.jsClick(driver, checkBoxList.get(checkBoxList.size()-1));
		ActionUtils.jsClick(driver, moveToArchive);
		Thread.sleep(1000);
		int activeCount2 = Integer.parseInt(ActionUtils.readText(driver, By.xpath("(//td[contains(.,'"+field+"')])[1]//span")));
		int archiveCount2 = Integer.parseInt(ActionUtils.readText(driver, By.xpath("(//td[contains(.,'"+field+"')])[2]//span")));
		Reporter.log("No.of ACTIVE fields count after moving to ARCHIVE: "+activeCount2, true);
		Reporter.log("No.of ARCHIVE fields count after moving to ARCHIVE: "+archiveCount2, true);
		a.assertTrue(activeCount2 < activeCount && archiveCount2 > archiveCount, "Field not moved to Archive");
		Reporter.log("Field moved to Archive", true);
		// Archive to Active
		ActionUtils.jsClick(driver, By.xpath("(//td[contains(.,'"+field+"')])[2]"));
		int activeCount3 = Integer.parseInt(ActionUtils.readText(driver, By.xpath("(//td[contains(.,'"+field+"')])[1]//span")));
		int archiveCount3 = Integer.parseInt(ActionUtils.readText(driver, By.xpath("(//td[contains(.,'"+field+"')])[2]//span")));
		Reporter.log("No.of ACTIVE fields count before moving to ACTIVE: "+activeCount3, true);
		Reporter.log("No.of ARCHIVE fields count before moving to ACTIVE: "+archiveCount3, true);
		List<WebElement> checkBoxList2 = ActionUtils.getElements(driver, By.xpath("(//td[contains(.,'"+field+"')])[2]//ancestor::div[@class='panel panel-default']//span[@class='box']"));
		ActionUtils.jsClick(driver, checkBoxList2.get(checkBoxList2.size()-1));
		ActionUtils.jsClick(driver, moveToActive);
		Thread.sleep(1000);
		int activeCount4 = Integer.parseInt(ActionUtils.readText(driver, By.xpath("(//td[contains(.,'"+field+"')])[1]//span")));
		int archiveCount4 = Integer.parseInt(ActionUtils.readText(driver, By.xpath("(//td[contains(.,'"+field+"')])[2]//span")));
		Reporter.log("No.of ACTIVE fields count after moving to ACTIVE: "+activeCount4, true);
		Reporter.log("No.of ARCHIVE fields count after moving to ACTIVE: "+archiveCount4, true);
		a.assertTrue(archiveCount4 < archiveCount3 && activeCount4 > activeCount3, "Field not moved to Active");
		Reporter.log("Field moved to Active", true);
		a.assertAll();
	}

	public void verify_Search_custom_field(String field) throws Exception {
		SoftAssert a = new SoftAssert();
		// Search
		ActionUtils.jsClick(driver, By.xpath("(//td[contains(.,'"+field+"')])[1]"));
		List<WebElement> fields = ActionUtils.getElements(driver, By.xpath("//p"));
		String searchItem = fields.get(0).getText();
		ActionUtils.clearAndType(driver, customFieldSeacrhBox, searchItem);
		ActionUtils.ajaxClick(driver, customFieldSearchButton);
		Thread.sleep(1000);
		a.assertTrue(driver.findElement(By.xpath("//p[text()='"+searchItem+"']")).isDisplayed(), "Custom field search option is not functional");
		Reporter.log("Custom field search option is functional", true);
		int resultCount = Integer.parseInt(ActionUtils.readText(driver, By.xpath("(//td[contains(.,'"+field+"')])[1]//span")));
		a.assertEquals(resultCount, 1, "Unique item not found for the search");
		Reporter.log("Unique item found for the search", true);
		// Clear search
		ActionUtils.getElement(driver, customFieldSeacrhBox).clear();
		ActionUtils.ajaxClick(driver, customFieldSearchButton);
		int resultCountAfterClear = Integer.parseInt(ActionUtils.readText(driver, By.xpath("(//td[contains(.,'"+field+"')])[1]//span")));
		a.assertTrue(resultCountAfterClear >= resultCount, "Search not cleared");
		Reporter.log("Search cleared", true);
		a.assertAll();
	}

	public void verify_Add_location_to_custom_fields(String name) {
		ActionUtils.ajaxJsClick(driver, locationTab);
		ActionUtils.jsClick(driver, addLocationBtn);
		ActionUtils.jsType(driver, nameFieldLocation, name);
		ActionUtils.ajaxJsClick(driver, saveLocationBtn);
		ActionUtils.ajaxJsClick(driver, lastPage);
		try {
			Assert.assertTrue(driver.findElement(By.linkText(name)).isDisplayed());
			Reporter.log("Location added", true);
		} catch (Exception e) {
			Assert.fail("Added location not found in the list");
		}
	}

	public void verify_Add_Area_manager_to_the_location(String name, String newUser) throws Exception {
		boolean loc = false;
		ActionUtils.ajaxJsClick(driver, locationTab);
		ActionUtils.ajaxJsClick(driver, lastPage);
		try {
			ActionUtils.click(driver, driver.findElement(By.xpath("//a[@name='fromA'][contains(.,'"+name+"')]/../..//td[3]")));
			Reporter.log("Given Location found", true);
			loc = true;
		} catch (Exception e) {
			Reporter.log("Added location not found in the list", true);
		}
		if (loc) {
			ActionUtils.ajaxClickSelectAndType(driver, driver.findElement(By.xpath("//a[@name='fromA'][contains(.,'"+name+"')]/../..//td[3]/div")), 
					driver.findElement(By.xpath("//a[@name='fromA'][contains(.,'"+name+"')]/../..//td[3]/input")), newUser);
			Thread.sleep(2000);
			ActionUtils.jsClick(driver, By.xpath("//a[contains(.,'"+newUser+"')]"));
			Thread.sleep(1000);
			Assert.assertTrue(ActionUtils.getElement(driver, By.xpath("//a[@name='fromA'][contains(.,'"+name+"')]/../..//span[contains(text(),'"+newUser+"')]")).isDisplayed(), "Area manager not added");
			Reporter.log("Area manager added", true);
		} else {
			Reporter.log("Given location not found in list", true);
		}
		
	}

	public void verify_Enable_and_Disable_locations_and_verify_its_presence_in_assets_creation_page(String name) {
		SoftAssert a = new SoftAssert();
		boolean loc = false;
		ActionUtils.ajaxJsClick(driver, locationTab);
		ActionUtils.ajaxJsClick(driver, lastPage);
		try {
			Assert.assertTrue(driver.findElement(By.linkText(name)).isDisplayed());
			loc = true;
			Reporter.log("Location added", true);
		} catch (Exception e) {
			Reporter.log("Given location not found the list", true);
		}
		if (loc) {
			// Enable 
			try {
				driver.findElement(By.xpath("//a[@name='fromA'][contains(.,'"+name+"')]/../..//td[4]//input")).getAttribute("checked").equals("checked");
				Reporter.log("Given loaction already enabled", true);
			} catch (Exception e) {
				ActionUtils.ajaxClick(driver, By.xpath("//a[@name='fromA'][contains(.,'"+name+"')]/../..//td[4]//span[contains(text(),'OFF')]"));
				Reporter.log("Location is enabled", true);
			} 
			ActionUtils.ajaxJsClick(driver, AssetsPage.assetsTab);
			ActionUtils.ajaxJsClick(driver, AssetsPage.addAssetsBtn);
			// Current location status
			List<WebElement> clList = ActionUtils.getAllOptionsFromTheDropdown(driver, AssetsPage.currentLocationDD);
			boolean currLocStatus = false;
			for (WebElement ele : clList) {
				if (ele.getText().contains(name)) {
					currLocStatus = true;
					break;
				}
			}
			a.assertTrue(currLocStatus, "Enabled location not found in current location dropdown");
			Reporter.log("Enabled location found in current location dropdown", true);
			// Storage location status
			List<WebElement> slList = ActionUtils.getAllOptionsFromTheDropdown(driver, AssetsPage.storageLocationDD);
			boolean storLocStatus = false;
			for (WebElement ele : slList) {
				if (ele.getText().contains(name)) {
					storLocStatus = true;
					break;
				}
			}
			a.assertTrue(storLocStatus, "Enabled location not found in storage location dropdown");
			Reporter.log("Enabled location found in storage location dropdown", true);
			// Navigate to Settings again and disable the location
			driver.navigate().back();
			driver.navigate().back();
			boolean loc2 = false;
			ActionUtils.ajaxJsClick(driver, locationTab);
			ActionUtils.ajaxJsClick(driver, lastPage);
			try {
				Assert.assertTrue(driver.findElement(By.linkText(name)).isDisplayed());
				loc = true;
				Reporter.log("Location added", true);
			} catch (Exception e) {
				Reporter.log("Given location not found the list", true);
			}
			if (loc2) {
				ActionUtils.ajaxClick(driver, By.xpath("//a[@name='fromA'][contains(.,'"+name+"')]/../..//td[4]//span[contains(text(),'ON')]"));
				try {
					driver.findElement(By.xpath("//a[@name='fromA'][contains(.,'"+name+"')]/../..//td[4]//input")).getAttribute("checked").equals("checked");
					Reporter.log("Given loaction enabled", true);
				} catch (Exception e) {
					Reporter.log("Given Location is disabled", true);
				} 
				ActionUtils.ajaxJsClick(driver, AssetsPage.assetsTab);
				ActionUtils.ajaxJsClick(driver, AssetsPage.addAssetsBtn);
				// Current location status
				List<WebElement> clList2 = ActionUtils.getAllOptionsFromTheDropdown(driver, AssetsPage.currentLocationDD);
				boolean currLocStatus2 = false;
				for (WebElement ele : clList2) {
					if (ele.getText().contains(name)) {
						currLocStatus2 = true;
						break;
					}
				}
				a.assertFalse(currLocStatus2, "Disabled location found in current location dropdown");
				Reporter.log("Disabled location not found in current location dropdown", true);
				// Storage location status
				List<WebElement> slList2 = ActionUtils.getAllOptionsFromTheDropdown(driver, AssetsPage.storageLocationDD);
				boolean storLocStatus2 = false;
				for (WebElement ele : slList2) {
					if (ele.getText().contains(name)) {
						storLocStatus2 = true;
						break;
					}
				}
				a.assertFalse(storLocStatus2, "Disabled location found in storage location dropdown");
				Reporter.log("Disabled location not found in current location dropdown", true);
			} else {
				Reporter.log("Given location not found in list to disable location", true);
			}
		} else {
			Reporter.log("Given location not found in list", true);
		}
		a.assertAll();
	}

	public void verify_Edit_loaction_name() throws Exception {
		ActionUtils.ajaxJsClick(driver, locationTab);
		String currLoc = ActionUtils.readText(driver, By.xpath("(//a[@name='fromA'])[1]"));
		ActionUtils.click(driver, By.xpath("(//a[@name='fromA'])[1]"));
		String newLoc = currLoc+" 1";
		ActionUtils.clearAndType(driver, nameFieldLocation, newLoc);
		ActionUtils.ajaxClick(driver, saveLocationBtn);
		ActionUtils.ajaxClick(driver, cancelLocBtn);
		String updatedLoc = ActionUtils.readText(driver, By.xpath("(//a[@name='fromA'])[1]"));
		Assert.assertEquals(updatedLoc, newLoc, "Location not renamed");
		Reporter.log("Location renamed", true);
	}

	// Control Units:---------------------------------------------------------------------------------------------------------------------
	public void verify_Add_unit(String unit, String qty) throws Exception {
		SoftAssert a = new SoftAssert();
		ActionUtils.clearAndType(driver, unitName, unit);
		ActionUtils.ajaxType(driver, quantity, qty + Keys.ENTER);
		a.assertEquals(ActionUtils.readText(driver, By.xpath("//input[contains(@id,'NewUnitName')]/../../preceding::span[2]")), unit, "Unit name not added");
		Reporter.log("Unit name added", true);
		a.assertEquals(ActionUtils.readText(driver, By.xpath("//input[contains(@id,'NewUnitName')]/../../preceding::span[1]")), qty, "Quantity not added");
		Reporter.log("Quantity added", true);
		a.assertAll();
	}

	public void verify_Add_existing_unit_and_verify_the_error_message(String unit, String qty, String expected) throws Exception {
		ActionUtils.clearAndType(driver, unitName, unit);
		ActionUtils.ajaxType(driver, quantity, qty + Keys.ENTER);
		Assert.assertEquals(ActionUtils.readText(driver, savedFailedNameAlreadyExistsMsg), expected, "No warning/error message on adding existing unit");		
		Reporter.log("Warning/error message displayed on adding existing unit");
	}

	public void verify_Edit_and_Delete_unit(String unit, String qty, String newName) throws Exception {
		SoftAssert a = new SoftAssert();
		// Add unit
		ActionUtils.clearAndType(driver, unitName, unit);
		ActionUtils.ajaxType(driver, quantity, qty + Keys.ENTER);
		String u1 = ActionUtils.readText(driver, By.xpath("//input[contains(@id,'NewUnitName')]/../../preceding::span[2]"));
		Reporter.log("Given unit: "+u1, true);
		a.assertEquals(u1, unit, "Unit name not added");
		Reporter.log("Unit name added", true);
		String q1 = ActionUtils.readText(driver, By.xpath("//input[contains(@id,'NewUnitName')]/../../preceding::span[1]"));
		Reporter.log("Given quantity: "+q1, true);
		a.assertEquals(q1, qty, "Quantity not added");
		Reporter.log("Quantity added", true);
		// Edit unit
		ActionUtils.doubleClickWebelement(driver, By.xpath("//input[contains(@id,'NewUnitName')]/../../preceding::span[2]"));
		ActionUtils.clearAndType(driver, By.xpath("(//span[text()='"+unit+"']/following::input)[1]"), newName + Keys.ENTER);
		Thread.sleep(1000);
		String u2 = ActionUtils.readText(driver, By.xpath("//input[contains(@id,'NewUnitName')]/../../preceding::span[2]"));
		Reporter.log("Updated unit name: "+u2, true);
		a.assertEquals(u2, newName, "Unit not edited");
		Reporter.log("Unit edited", true);
		// Delete unit
		List<WebElement> removeBtnsList = ActionUtils.getElements(driver, By.xpath("//i[contains(@title,'Remove')]"));
		Reporter.log("No.of units before deletion: "+removeBtnsList.size(), true);
		ActionUtils.ajaxClick(driver, removeLastUnitBtn);
		List<WebElement> removeBtnsList2 = ActionUtils.getElements(driver, By.xpath("//i[contains(@title,'Remove')]"));
		Reporter.log("No.of units after deletion: "+removeBtnsList2.size(), true);
		a.assertNotEquals(removeBtnsList.size(), removeBtnsList2.size(), "Unit not deleted");
		Reporter.log("Unit deleted", true);
		a.assertAll();
	}

	// Test results page:---------------------------------------------------------------------------------------------------------------------
	public void verify_Add_result_sheet_and_verify_its_presence_in_assets_creation_page_result_sheet_dropdown(String sheetName) {
		SoftAssert a = new SoftAssert();
		// Add sheet
		ActionUtils.jsClick(driver, addSheetBtn);
		ActionUtils.jsType(driver, sheetNameField, sheetName);
		ActionUtils.ajaxJsClick(driver, saveSheetBtn);
		a.assertEquals(ActionUtils.readText(driver, sheetTitle), sheetName, "Sheet not created and no sheet title present");
		Reporter.log("Sheet created and sheet title present", true);
		ActionUtils.ajaxJsClick(driver, sheetBackBtn);
		ActionUtils.jsType(driver, sheetSearchBox, sheetName);
		ActionUtils.ajaxJsClick(driver, sheetSearchBtn);
		a.assertTrue(ActionUtils.getElement(driver, By.xpath("//h3[text()='"+sheetName+"']")).isDisplayed(), "Sheet not found in search results");
		Reporter.log("Sheet found in search results", true);
		// Verify in Assets result sheet dropdown
		ActionUtils.ajaxJsClick(driver, AssetsPage.assetsTab);
		ActionUtils.ajaxJsClick(driver, AssetsPage.addAssetsBtn);
		List<WebElement> sheets = ActionUtils.getAllOptionsFromTheDropdown(driver, AssetsPage.resultsSheetDD);
		boolean sheetPresence = false;
		for (WebElement sheet : sheets) {
			if (sheet.getText().equalsIgnoreCase(sheetName)) {
				sheetPresence = true;
			}
		}
		a.assertTrue(sheetPresence, "Results sheet not found in assets page results sheet dropdown");
		Reporter.log("Results sheet found in assets page results sheet dropdown", true);
		a.assertAll();
	}

	public void verify_Add_and_Delete_results_sheet_rows_and_columns(String sheetName, String rowName, String columnField) throws Exception {
		SoftAssert a = new SoftAssert();
		// Add sheet and Add rows and columns
		ActionUtils.jsClick(driver, addSheetBtn);
		ActionUtils.jsType(driver, sheetNameField, sheetName);
		ActionUtils.ajaxJsClick(driver, saveSheetBtn);
		List<WebElement> rows = ActionUtils.getElements(driver, noOfRows);
		List<WebElement> columns = ActionUtils.getElements(driver, noOfColumns);
		int rCount = rows.size();
		int cCount = columns.size();
		Reporter.log("Default no.of rows: "+rCount, true);
		Reporter.log("Default no.of columns: "+cCount, true);
		ActionUtils.clickClearAndType(driver, newRowField, rowName + Keys.ENTER);
		Thread.sleep(1000);
		ActionUtils.clickClearAndType(driver, newColumnField, columnField + Keys.ENTER);
		Thread.sleep(1000);
		List<WebElement> rows1 = ActionUtils.getElements(driver, noOfRows);
		List<WebElement> columns1 = ActionUtils.getElements(driver, noOfColumns);
		int rCount1 = rows1.size();
		int cCount1 = columns1.size();
		Reporter.log("No.of rows after adding new row: "+rCount1, true);
		Reporter.log("No.of columns after adding new column: "+cCount1, true);
		a.assertTrue(rCount1 > rCount, "New row not added");
		Reporter.log("New row added", true);
		a.assertTrue(cCount1 > cCount, "New column not added");
		Reporter.log("New column added", true);
		// Delete rows and columns
		// Row
		ActionUtils.doubleClickWebelement(driver, rows1.get(rCount1-2));
		ActionUtils.jsClick(driver, removeRowOrColumn);
		Thread.sleep(1000);
		ActionUtils.doubleClickWebelement(driver, columns1.get(cCount1-2));
		ActionUtils.jsClick(driver, removeRowOrColumn);
		Thread.sleep(1000);
		List<WebElement> rows2 = ActionUtils.getElements(driver, noOfRows);
		List<WebElement> columns2 = ActionUtils.getElements(driver, noOfColumns);
		int rCount2 = rows2.size();
		int cCount2 = columns2.size();
		Reporter.log("No.of rows after deleting one row: "+rCount2, true);
		Reporter.log("No.of columns after deleting one column: "+cCount2, true);
		a.assertTrue(rCount2 < rCount1, "Row not deleted");
		Reporter.log("Row deleted", true);
		a.assertTrue(cCount2 < cCount1, "Column not deleted");
		Reporter.log("Column deleted", true);
		a.assertAll();
	}

	public void verify_Copy_template(String sheetName) {
		SoftAssert a = new SoftAssert();
		ActionUtils.jsClick(driver, addSheetBtn);
		ActionUtils.jsType(driver, sheetNameField, sheetName);
		ActionUtils.ajaxJsClick(driver, saveSheetBtn);
		// Copy template
		ActionUtils.jsClick(driver, moreDD);
		ActionUtils.ajaxJsClick(driver, copyOption);
		ActionUtils.jsType(driver, sheetSearchBox, sheetName);
		ActionUtils.ajaxJsClick(driver, sheetSearchBtn);
		a.assertTrue(ActionUtils.getElement(driver, By.xpath("//h3[text()='"+sheetName+" Copy"+"']")).isDisplayed(), "Template not copied");
		Reporter.log("Template copied", true);
		a.assertAll();
	}

	public void verify_Up_version_and_Publish_up_version(String sheetName, String verionMsg) {
		SoftAssert a = new SoftAssert();
		ActionUtils.jsClick(driver, addSheetBtn);
		ActionUtils.jsType(driver, sheetNameField, sheetName);
		ActionUtils.ajaxJsClick(driver, saveSheetBtn);
		// Up version
		ActionUtils.jsClick(driver, moreDD);
		ActionUtils.ajaxJsClick(driver, upVersionOption);
		List<WebElement> versionList = ActionUtils.getAllOptionsFromTheDropdown(driver, versionDD);
		boolean version2 = false;
		for (WebElement ele : versionList) {
			if (ele.getText().equalsIgnoreCase("Version 2")) {
				version2 = true;
			}
		}
		a.assertTrue(version2, "New version not created");
		Reporter.log("New version created", true);
		// Publish version
		ActionUtils.jsClick(driver, publishBtn);
		ActionUtils.waitForElementVisibility(driver, versionAlertMsg);
		a.assertEquals(ActionUtils.readText(driver, versionAlertMsg), verionMsg, "Version confirmation alert message not displayed");
		Reporter.log("Version confirmation alert message displayed", true);
		ActionUtils.ajaxJsClick(driver, okBtn);
		a.assertTrue(ActionUtils.getElement(driver, publishedMsg).isDisplayed(), "Template not published");
		Reporter.log("Template published", true);
		a.assertAll();
	}












}
