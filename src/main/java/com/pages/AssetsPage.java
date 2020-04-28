/**
 * @author UmaMaheswararao
 */

package com.pages;

import static org.testng.Assert.assertTrue;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.BasePage;
import com.util.ActionUtils;
import com.util.VerificationLibrary;

public class AssetsPage extends BasePage {

	// Objects Repository(OR):........................................................................
	// Page verification 
	@FindBy(xpath="//a[contains(text(),'Assets')]")
	@CacheLookup
	WebElement assetsLink;

	static By assetsTab = By.xpath("//span[@class='title'][contains(.,'Assets')]");

	By DashBoard = By.xpath("//span[contains(text(),'Dashboard')]");
	static By Capture = By.xpath("//span[contains(text(),'Capture')]");
	static By Calibration = By.xpath("//span[text()='Calibration']");
	By Companies = By.xpath("//span[text()='Companies']");
	By Analyse = By.xpath("//span[text()='Analyse']");
	By Settings = By.xpath("//span[contains(text(),'Settings')]");

	// DashBoard
	@FindBy(xpath="//a[contains(text(),'Dashboard')]")
	WebElement dashBoardLink;

	// Create Assets
	static By addAssetsBtn = By.xpath(".//*[@id='addAssets']");
	By assetNameTextBox = By.xpath("//input[contains(@id,'Name')]");
	By assetDescrptionTextBox = By.xpath("//textarea[contains(@id,'Description')]");
	By assignOwnerBtn = By.xpath("//div[contains(text(),'Click to assign Owner')]");
	By ownerSearchBox = By.xpath("//input[contains(@aria-label,'Search for option')]");
	By manufacturerDD = By.xpath("//label[contains(text(),'Manufacturer')]/..//select");
	static By currentLocationDD = By.xpath("//label[contains(text(),'Current Location')]/..//select");
	static By storageLocationDD = By.xpath("//label[contains(text(),'Storage Location')]/..//select");
	static By resultsSheetDD = By.xpath("//label[contains(text(),'Results Sheet')]/..//select");
	static By editAssetBtn = By.xpath("(//a[@name='editAssetBtn'])[1]");
	static By scheduleTab = By.linkText("Schedule");
	static By counterLabel = By.xpath("(//label[text()='COUNTER'])[1]");
	static By counterUnitSearchBox = By.xpath("(//label[contains(.,'UNIT:')])[1]/following::input[1]");
	By typeDD = By.xpath("//label[contains(text(),'Type')]/..//select");
	By calibrationStatusDD = By.xpath("//label[contains(text(),'Calibration Status')]/..//select");
	By unitsTextBox = By.xpath("//input[contains(@id,'Units')]");
	By dateAcquiredBtn = By.xpath("//i[contains(@title,'Change Date')]");
	By monthsSwitch = By.xpath("(//th[@class='datepicker-switch'])[1]");
	By yearSwitch = By.xpath("(//th[@class='datepicker-switch'])[2]");
	By resolutionField = By.xpath("(//label[text()='Resolution']/following::input)[1]");
	By range1Field = By.xpath("(//label[text()='Range1']/following::input)[1]");
	By range2Field = By.xpath("(//label[text()='Range2']/following::input)[1]");
	By standardUploadBtn = By.id("standardDropzone");
	By procedureUploadBtn = By.id("uploadProcedure");
	By uncertaintyUploadBtn = By.id("uploadUncertainty");
	By assetImageUploadBtn = By.xpath("//form[contains(@id,'filesDropzone')]");
	By assetSaveBtn = By.xpath(".//*[@id='btnSave']");
	By backBtn = By.xpath(".//*[@id='backbtn']");
	static By assetsSearchBox = By.xpath(".//*[@id='searchbox']");
	static By assetsSearchBtn = By.xpath("//a[contains(@title,'Search')]");
	By nameFieldErrorMsg = By.xpath("//span[contains(@id,'divError_assetname')]");
	By statusDDErrorMsg = By.xpath("//div[contains(text(),'The Calibration Status cannot be empty')]");
	By storageLocationErrorMsg = By.xpath("//div[contains(text(),'The Storage Location cannot be empty')]");
	By currentLocationErrorMsg = By.xpath("//div[contains(text(),'The Current Location cannot be empty')]");

	// Sort asset page fields
	By nameHeader = By.xpath("//th[text()='Name']");
	By descriptionHeader = By.xpath("//th[text()='Description']");
	By typeHeader = By.xpath("//th[text()='Type']");
	By locationHeader = By.xpath("//th[text()='Location']");

	By assetListInfo = By.xpath("//div[contains(@id,'assetsList_info')]");

	// Edit assets
	By assetImgUpdateBtn = By.xpath("//form[contains(@id,'DROP1')]");
	By savedSuccessfullyMsg = By.xpath("//div[text()='Save successfully!']");
	By standardFileUpdateBtn = By.xpath("//form[@id='Dropzonestandard']//div[1]");
	By procedureFileUpdateBtn = By.xpath("//form[@id='Dropzoneprocedure']//div[1]");
	By uncertaintyFileUpdateBtn = By.xpath("//form[@id='Dropzoneuncertainty']//div[1]");
	By standardFileName = By.xpath("//form[@id='Dropzonestandard']//div[1]/../..//a");
	By procedureFileName = By.xpath("//form[@id='Dropzoneprocedure']//div[1]/../..//a");
	By uncertaintyFileName = By.xpath("//form[@id='Dropzoneuncertainty']//div[1]/../..//a");
	By removeFileBtnList = By.xpath("//i[@class='icon-close']");

	// Add existing asset
	By saveFailedForExistingAsset = By.xpath("//div[text()='Save failed :This asset already exists.']");

	// Add Comment
	By editBtnList = By.xpath("//a[@name='editAssetBtn']");
	By commentField = By.xpath("//input[contains(@placeholder,'Type a comment  here')]");
	By cancelAssetBtn = By.xpath("//a[@data-dismiss='modal'][contains(.,'Cancel')]");

	// Filter Items
	By filterBtn = By.xpath("//a[contains(@title,'FILTER')]");
	By clearAllBtn = By.xpath("//a[contains(@onclick,'AssetsList.clearAll()')]");
	By filterByManufacturerSection = By.xpath("//div[text()[normalize-space()='Manufacturer']]");
	By filterByLocationsSection = By.xpath("//div[text()[normalize-space()='Locations']]");
	By filterByTypesSection = By.xpath("//div[text()[normalize-space()='Types']]");
	By filterByStatusSection = By.xpath("//div[text()[normalize-space()='Status']]");
	By filterByCalibrationSection = By.xpath("//div[text()[normalize-space()='Calibration Status']]");
	By filterByRangeSection = By.xpath("//div[text()[normalize-space()='Range']]");
	By statusDD = By.xpath("//label[contains(text(),'Status')]/..//select");
	By calibrationStatus = By.xpath("(//input[@readonly='readonly'])[1]");
	By sliderBar = By.xpath("//span[contains(@class,'irs-line')]");
	By sliderTo = By.xpath("//span[contains(@class,'irs-handle to')]//i[1]");
	By maxValue = By.xpath("//span[contains(@class,'irs-to')]");
	By sliderFrom = By.xpath("//span[contains(@class,'irs-handle from')]//i[1]");
	By minValue = By.xpath("//span[contains(@class,'irs-from')]");
	By completedCaliStatus = By.xpath("//input[@title='Completed']");

	// Request for calibration
	By requestForCalibrationBtn = By.id("DRequestCal");

	// Filter by custom fields
	By filterBtn2 = By.xpath("//a[contains(.,'Filters')]");
	By filterSearch = By.xpath("//input[@aria-label='Search for option']");

	// Set controls
	static By control1 = By.xpath("//span[text()='CONTROL 1']");
	static By control2 = By.xpath("//span[text()='CONTROL 2']");
	By c1_Calendar = By.xpath("(//label[text()='CALENDAR'])[1]");
	static By c1_Timer = By.xpath("(//label[text()='TIMER'])[1]");
	By c1_Counter = By.xpath("(//label[text()='COUNTER'])[1]");
	By c1_Ncr = By.xpath("(//label[text()='NCR'])[1]");
	By c1_Months = By.xpath("(//label[text()='MONTHS'])[1]");
	By c1_Weeks = By.xpath("(//label[text()='WEEKS'])[1]");
	By c1_Days = By.xpath("(//label[text()='DAYS'])[1]");
	static By c1_ValueField = By.xpath("(//div[@id='QuantityOne']//input)[1]");
	By c1_Hours = By.xpath("(//label[text()='HOURS'])[1]");
	static By c1_Minutes = By.xpath("(//label[text()='MINUTES'])[1]");
	By c1_Capture = By.xpath("(//label[text()='Capture'])[1]");
	By c1_Location = By.xpath("(//label[text()='Location'])[1]");
	By c1_UnitField = By.xpath("(//label[text()='UNIT:'])[1]//following::input[1]");
	static By c1_ApplyBtn = By.xpath("(//button[@id='ApplyOne'])[1]");

	By c2_Calendar = By.xpath("(//label[text()='CALENDAR'])[2]");
	By c2_Timer = By.xpath("(//label[text()='TIMER'])[2]");
	static By c2_Counter = By.xpath("(//label[text()='COUNTER'])[2]");
	By c2_Ncr = By.xpath("(//label[text()='NCR'])[2]");
	By c2_Months = By.xpath("(//label[text()='MONTHS'])[2]");
	By c2_Weeks = By.xpath("(//label[text()='WEEKS'])[2]");
	By c2_Days = By.xpath("(//label[text()='DAYS'])[2]");
	static By c2_ValueField = By.xpath("(//div[@id='QuantityOne']//input)[2]");
	By c2_Hours = By.xpath("(//label[text()='HOURS'])[2]");
	By c2_Minutes = By.xpath("(//label[text()='MINUTES'])[2]");
	By c2_Capture = By.xpath("(//label[text()='Capture'])[2]");
	By c2_Location = By.xpath("(//label[text()='Location'])[1]");
	static By c2_UnitField = By.xpath("(//label[text()='UNIT:'])[2]//following::input[1]");
	static By c2_ApplyBtn = By.xpath("(//button[@id='ApplyOne'])[2]");

	// Change calibration status
	By clearCurrentCalibrationStatusBtn = By.xpath("//div[@class='input-icon right']//i[1]");
	By calibrationStatusSearch = By.xpath("(//input[@aria-label='Search for option'])[2]");

	// View History
	By historyTab = By.linkText("History");
	By historyNameHeader = By.xpath("(//th[@class='sorting'][contains(.,'Name')])[1]");
	By historyEventHeader = By.xpath("(//th[@class='table-td sorting'][contains(.,'Event')])[1]");
	By historyDateAndTimeHeader = By.xpath("(//th[@class='sorting'][contains(.,'Date & Time')])[1]");
	By historyCalibrationStatusSection = By.xpath("(//div[text()[normalize-space()='Calibration Status']])[2]");
	By historyLocationsSection = By.xpath("(//div[text()[normalize-space()='Locations']])[2]");
	By historyUsersSection = By.xpath("//div[text()[normalize-space()='Users']]");
	By historyPeriodSection = By.xpath("//div[text()[normalize-space()='period']]");

	// Dwnload certificate
	By calibrationTab = By.cssSelector("li#tabCalibration>a");
	By downloadCertificateBtn = By.xpath("//button[text()[normalize-space()='CERTIFICATE']]");







	// Initializing the Page Objects:................................................................
	public AssetsPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public void verify_AssetsPage() {
		Assert.assertTrue(assetsLink.isDisplayed(), "Unable to Navigate Asserts Page");
	}

	public DashBoardPage navigate_to_DashBoard() {
		ActionUtils.ajaxJsClick(driver, DashBoard);
		return new DashBoardPage();
	}

	public CapturePage navigate_to_Capture() {
		ActionUtils.ajaxJsClick(driver, Capture);
		return new CapturePage();
	}

	public CalibrationPage navigate_to_Clibration() {
		ActionUtils.ajaxJsClick(driver, Calibration);
		return new CalibrationPage();
	}

	public CompaniesPage navigate_to_Companies() {
		ActionUtils.ajaxJsClick(driver, Companies);
		return new CompaniesPage();
	}

	public AnalysePage navigate_to_Analyse() {
		ActionUtils.ajaxJsClick(driver, Analyse);
		return new AnalysePage();
	}

	public SettingsPage navigate_to_Settings() {
		ActionUtils.ajaxJsClick(driver, Settings);
		return new SettingsPage();
	}


	public void verify_Create_Asset(String name, String description, String ownerName, String manufacturer,	String currentLocation, 
			String storageLocation, String equipementType, String calibrationStatus, String resultsSheet, String units, String year,
			String month, String date, String resolution, String range1, String range2, String cf, String cfv, 
			String assertImg, String stdFilePath, String procFilePath, String uncertFilePath) throws Exception {
		ActionUtils.ajaxClick(driver, addAssetsBtn);
		ActionUtils.clearAndType(driver, assetNameTextBox, name);
		ActionUtils.clearAndType(driver, assetDescrptionTextBox, description);
		ActionUtils.jsClick(driver, assignOwnerBtn);
		ActionUtils.clearAndType(driver, ownerSearchBox, ownerName);
		Thread.sleep(1000);
		ActionUtils.getElement(driver, ownerSearchBox).sendKeys(Keys.ENTER);
		ActionUtils.selectElementByVisibleText(driver, manufacturerDD, manufacturer);
		List<WebElement> curLocLsit = ActionUtils.getAllOptionsFromTheDropdown(driver, currentLocationDD);
		for (WebElement ele : curLocLsit) {
			if (ele.getText().contains(currentLocation)) {
				ele.click();
			}
		}
		List<WebElement> stoLocLsit = ActionUtils.getAllOptionsFromTheDropdown(driver, storageLocationDD);
		for (WebElement ele : stoLocLsit) {
			if (ele.getText().contains(storageLocation)) {
				ele.click();
			}
		}
		ActionUtils.selectElementByVisibleText(driver, typeDD, equipementType);
		ActionUtils.selectElementByVisibleText(driver, calibrationStatusDD, calibrationStatus);
		ActionUtils.selectElementByVisibleText(driver, resultsSheetDD, resultsSheet);
		ActionUtils.clearAndType(driver, unitsTextBox, units);
		ActionUtils.jsClick(driver, dateAcquiredBtn);
		ActionUtils.jsClick(driver, monthsSwitch);
		ActionUtils.jsClick(driver, yearSwitch);
		List<WebElement> yearsList = driver.findElements(By.cssSelector(".year"));
		for (WebElement ele : yearsList) {
			String text = ele.getText();
			if(text.equalsIgnoreCase(year)) {
				ele.click();
				break;
			}
		}
		List<WebElement> monthsList = driver.findElements(By.cssSelector(".month"));
		for (WebElement ele : monthsList) {
			String text = ele.getText();
			if(text.equalsIgnoreCase(month)) {
				ele.click();
				break;
			}
		}
		List<WebElement> dayList = driver.findElements(By.cssSelector(".day"));
		for (WebElement ele : dayList) {
			String text = ele.getText();
			if(text.equalsIgnoreCase(date)) {
				ele.click();
				break;
			}
		}
		ActionUtils.clearAndType(driver, resolutionField, resolution);
		ActionUtils.clearAndType(driver, range1Field, range1);
		ActionUtils.clearAndType(driver, range2Field, range2);
		ActionUtils.clearAndType(driver, By.xpath("//input[contains(@title,'"+cf+"')]"), cfv);
		ActionUtils.ajaxUploadFile(driver, assetImageUploadBtn, assertImg);
		ActionUtils.ajaxUploadFile(driver, standardUploadBtn, stdFilePath);
		ActionUtils.ajaxUploadFile(driver, procedureUploadBtn, procFilePath);
		ActionUtils.ajaxUploadFile(driver, uncertaintyUploadBtn, uncertFilePath);
		ActionUtils.ajaxJsClick(driver, assetSaveBtn);
		ActionUtils.jsType(driver, assetsSearchBox, name);
		ActionUtils.ajaxJsClick(driver, assetsSearchBtn);
		Assert.assertTrue(ActionUtils.getElement(driver, By.xpath("//td[text()='"+name+"']")).isDisplayed(), "Asset Not Created");
		Reporter.log("Asset created", true);
	}

	public void verify_mandatory_fields_error_msgs_in_asset_creation_page(String nameExpMsg, String name, String stausExpMsg,
			String calibrationStatus, String storageLocExpMsg, String storageLocation, String currentLocExpMsg) {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxClick(driver, addAssetsBtn);
		ActionUtils.ajaxJsClick(driver, assetSaveBtn);
		// Name
		a.assertEquals(ActionUtils.readText(driver, nameFieldErrorMsg), nameExpMsg, "No error message displayed for asset name field");
		Reporter.log("Error message displayed for asset name field", true);
		ActionUtils.clearAndType(driver, assetNameTextBox, name);
		// Calibration status
		ActionUtils.ajaxJsClick(driver, assetSaveBtn);
		a.assertEquals(ActionUtils.readText(driver, statusDDErrorMsg), stausExpMsg, "No error message displayed for calibration status field");
		Reporter.log("Error message displayed for calibration status field", true);
		ActionUtils.selectElementByVisibleText(driver, calibrationStatusDD, calibrationStatus);
		// Storage location
		ActionUtils.ajaxJsClick(driver, assetSaveBtn);
		a.assertEquals(ActionUtils.readText(driver, storageLocationErrorMsg), storageLocExpMsg, "No error message displayed for storage location field");
		Reporter.log("Error message displayed for storage location field", true);
		List<WebElement> stoLocLsit = ActionUtils.getAllOptionsFromTheDropdown(driver, storageLocationDD);
		for (WebElement ele : stoLocLsit) {
			if (ele.getText().contains(storageLocation)) {
				ele.click();
			}
		}
		// Current location
		ActionUtils.ajaxJsClick(driver, assetSaveBtn);
		a.assertEquals(ActionUtils.readText(driver, currentLocationErrorMsg), currentLocExpMsg, "No error message displayed for current location field");
		Reporter.log("Error message displayed for current location field", true);

		a.assertAll();
	}

	public void verify_Sort_assets_page_fields() {
		// Name header
		// Ascending 
		ActionUtils.ajaxJsClick(driver, nameHeader);
		List<WebElement> nameList = ActionUtils.getElements(driver, By.xpath("//tr//td[2][contains(@class,'table-td')]"));
		VerificationLibrary.verifyWebTableTextDataOrderWithoutCaseSensitive(driver, nameList, "Ascending");
		Reporter.log("'Name' field Ascending order is functional", true);
		// descending
		ActionUtils.ajaxJsClick(driver, nameHeader);
		List<WebElement> nameList2 = ActionUtils.getElements(driver, By.xpath("//tr//td[2][contains(@class,'table-td')]"));
		VerificationLibrary.verifyWebTableTextDataOrderWithoutCaseSensitive(driver, nameList2, "Descending");
		Reporter.log("'Name' field Descending order is functional", true);
		// Description header
		// Ascending 
		ActionUtils.ajaxJsClick(driver, descriptionHeader);
		List<WebElement> descList = ActionUtils.getElements(driver, By.xpath("//tr//td[3]"));
		VerificationLibrary.verifyWebTableTextDataOrderWithCaseSensitive(driver, descList, "Ascending");
		Reporter.log("'Description' field Ascending order is functional", true);
		// descending
		ActionUtils.ajaxJsClick(driver, descriptionHeader);
		List<WebElement> descList2 = ActionUtils.getElements(driver, By.xpath("//tr//td[3]"));
		VerificationLibrary.verifyWebTableTextDataOrderWithCaseSensitive(driver, descList2, "Descending");
		Reporter.log("'Description' field Descending order is functional", true);
		// Type header
		// Ascending 
		ActionUtils.ajaxJsClick(driver, typeHeader);
		List<WebElement> typeList = ActionUtils.getElements(driver, By.xpath("//tr//td[4]"));
		VerificationLibrary.verifyWebTableTextDataOrderWithoutCaseSensitive(driver, typeList, "Ascending");
		Reporter.log("'Type' field Ascending order is functional", true);
		// descending
		ActionUtils.ajaxJsClick(driver, typeHeader);
		List<WebElement> typeList2 = ActionUtils.getElements(driver, By.xpath("//tr//td[4]"));
		VerificationLibrary.verifyWebTableTextDataOrderWithoutCaseSensitive(driver, typeList2, "Descending");
		Reporter.log("'Type' field Descending order is functional", true);
		// Location Header
		// Ascending 
		ActionUtils.ajaxJsClick(driver, locationHeader);
		List<WebElement> locList = ActionUtils.getElements(driver, By.xpath("//tr//td[5]"));
		VerificationLibrary.verifyWebTableTextDataOrderWithCaseSensitive(driver, locList, "Ascending");
		Reporter.log("'Location' field Ascending order is functional", true);
		// descending
		ActionUtils.ajaxJsClick(driver, locationHeader);
		List<WebElement> locList2 = ActionUtils.getElements(driver, By.xpath("//tr//td[5]"));
		VerificationLibrary.verifyWebTableTextDataOrderWithCaseSensitive(driver, locList2, "Descending");
		Reporter.log("'Location' field Descending order is functional", true);
	}

	public void verify_View_total_records() {
		String noOfAssets = ActionUtils.readText(driver, assetListInfo);
		String[] list= noOfAssets.split("of");
		int count = Integer.parseInt(list[1].replaceAll("[^0-9]", ""));
		Reporter.log("No of Assets created: "+count, true);
	}

	public void verify_Edit_asset_image_and_files(String asset, String imgPath, String filePath, String downloadPath) throws Exception {
		SoftAssert a = new SoftAssert();
		// Update asset image
		ActionUtils.jsType(driver, assetsSearchBox, asset);
		ActionUtils.ajaxJsClick(driver, assetsSearchBtn);
		ActionUtils.ajaxJsClick(driver, By.xpath("//td[text()='"+asset+"']//following::a[@name='editAssetBtn']"));
		try {
			ActionUtils.uploadFile(driver, assetImgUpdateBtn, imgPath);
		} catch (Exception e) {
			try {
				ActionUtils.uploadFile(driver, assetImgUpdateBtn, imgPath);
			} catch (Exception e1) {
				ActionUtils.uploadFile(driver, assetImgUpdateBtn, imgPath);
			}
		}
		a.assertTrue(ActionUtils.getElement(driver, savedSuccessfullyMsg).isDisplayed(), "Asset image not updated");
		Reporter.log("Asset image updated", true);
		// Upload files
		// Standard
		ActionUtils.uploadFile(driver, standardFileUpdateBtn, filePath);
		a.assertTrue(ActionUtils.getElement(driver, standardFileName).isDisplayed(), "File standard file not uploaded");
		Reporter.log("Standard file uploaded", true);
		// Procedure
		ActionUtils.uploadFile(driver, procedureFileUpdateBtn, filePath);
		a.assertTrue(ActionUtils.getElement(driver, procedureFileName).isDisplayed(), "File procedure file not uploaded");
		Reporter.log("Procedure file uploaded", true);
		// Uncertainty
		ActionUtils.uploadFile(driver, uncertaintyFileUpdateBtn, filePath);
		a.assertTrue(ActionUtils.getElement(driver, uncertaintyFileName).isDisplayed(), "File uncertainty file not uploaded");
		Reporter.log("Uncertainty file uploaded", true);
		// Download file
		ActionUtils.ajaxJsClick(driver, standardFileName);
		Thread.sleep(2000);
		String fn = ActionUtils.readText(driver, standardFileName).toLowerCase().replaceAll(" ", "+");
		a.assertTrue(VerificationLibrary.isFileDownloaded(downloadPath, fn), "File not downloaded");
		Reporter.log("File downloaded", true);
		// Remove file
		List<WebElement> btnList = ActionUtils.getElements(driver, removeFileBtnList);
		int count1 = btnList.size();
		Reporter.log("No.of files before remove: "+count1, true);
		ActionUtils.ajaxJsClick(driver, btnList.get(0));
		List<WebElement> btnList2 = ActionUtils.getElements(driver, removeFileBtnList);
		int count2 = btnList2.size();
		Reporter.log("No.of files before remove: "+count2, true);
		a.assertTrue(count2 < count1, "File not removed");
		Reporter.log("File removed", true);

		a.assertAll();
	}

	public void verify_Create_existing_asset_and_verify_warning_alert(String name, String currentLocation, String storageLocation, String calibrationStatus) throws Exception {
		ActionUtils.ajaxClick(driver, addAssetsBtn);
		ActionUtils.clearAndType(driver, assetNameTextBox, name);
		List<WebElement> curLocLsit = ActionUtils.getAllOptionsFromTheDropdown(driver, currentLocationDD);
		for (WebElement ele : curLocLsit) {
			if (ele.getText().contains(currentLocation)) {
				ele.click();
			}
		}
		List<WebElement> stoLocLsit = ActionUtils.getAllOptionsFromTheDropdown(driver, storageLocationDD);
		for (WebElement ele : stoLocLsit) {
			if (ele.getText().contains(storageLocation)) {
				ele.click();
			}
		}
		ActionUtils.selectElementByVisibleText(driver, calibrationStatusDD, calibrationStatus);
		ActionUtils.ajaxJsClick(driver, assetSaveBtn);
		Assert.assertTrue(ActionUtils.getElement(driver, saveFailedForExistingAsset).isDisplayed(), "Warning alert not displayed on adding existing asset");
		Reporter.log("Warning alert displayed on adding existing asset", true);
	}

	public void verify_Add_comment_for_the_asset(String comment) throws Exception {
		List<WebElement> btnList = ActionUtils.getElements(driver, editBtnList);
		ActionUtils.ajaxJsClick(driver, btnList.get(0));
		ActionUtils.scrollIntoView(driver, commentField);
		ActionUtils.clickClearAndType(driver, commentField, comment);
		ActionUtils.getElement(driver, commentField).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		Assert.assertTrue(ActionUtils.getElement(driver, By.xpath("//div[text()='"+comment+"']")).isDisplayed(), "Comment not added");
		Reporter.log("Comment added", true);
	}

	public void verify_Close_asset() throws Exception {
		List<WebElement> btnList = ActionUtils.getElements(driver, editBtnList);
		ActionUtils.ajaxJsClick(driver, btnList.get(0));
		ActionUtils.ajaxJsClick(driver, cancelAssetBtn);
		Thread.sleep(1000);
		Assert.assertFalse(ActionUtils.getElement(driver, cancelAssetBtn).isDisplayed(), "Asset page not closed");
		Reporter.log("Asset page closed", true);
	}

	public void verify_Filter_items() {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsClick(driver, filterBtn);
		a.assertTrue(ActionUtils.getElement(driver, filterByManufacturerSection).isDisplayed(), "Filter by Manufacturer section is not displayed");
		Reporter.log("Filter by Manufacturer section is displayed", true);
		ActionUtils.scrollIntoView(driver, filterByLocationsSection);
		a.assertTrue(ActionUtils.getElement(driver, filterByLocationsSection).isDisplayed(), "Filter by Location section is not displayed");
		Reporter.log("Filter by Location section is displayed", true);
		ActionUtils.scrollIntoView(driver, filterByTypesSection);
		a.assertTrue(ActionUtils.getElement(driver, filterByTypesSection).isDisplayed(), "Filter by Type section is not displayed");
		Reporter.log("Filter by Type section is displayed", true);
		ActionUtils.scrollIntoView(driver, filterByStatusSection);
		a.assertTrue(ActionUtils.getElement(driver, filterByStatusSection).isDisplayed(), "Filter by Status section is not displayed");
		Reporter.log("Filter by Status section is displayed", true);
		ActionUtils.scrollIntoView(driver, filterByCalibrationSection);
		a.assertTrue(ActionUtils.getElement(driver, filterByCalibrationSection).isDisplayed(), "Filter by Calibration section is not displayed");
		Reporter.log("Filter by Calibration section is displayed", true);
		ActionUtils.scrollIntoView(driver, filterByRangeSection);
		a.assertTrue(ActionUtils.getElement(driver, filterByRangeSection).isDisplayed(), "Filter by Range section is not displayed");
		Reporter.log("Filter by Range section is displayed", true);

		a.assertAll();
	}

	public void verify_Filter_by_manufacturer() throws Exception {
		SoftAssert a = new SoftAssert();
		// Verify records count
		ActionUtils.ajaxJsClick(driver, filterBtn);
		List<WebElement> optList = driver.findElements(By.xpath("//*[@id='Manufacturerlist']/div/label"));
		int count = 0;
		String manufacturer = null;
		for (int i = 0; i < optList.size(); i++) {
			String text = optList.get(i).getText().replaceAll("[^0-9]", "");
			if (!text.equals("")) {
				count = Integer.parseInt(text);
				manufacturer = ActionUtils.readText(driver, By.xpath("//*[@id='Manufacturerlist']/div["+(i+1)+"]/span"));
				break;
			}
		}
		if (count != 0) {
			ActionUtils.ajaxJsClick(driver, By.xpath("//div[@id='Manufacturerlist']//span[contains(text(),'"+manufacturer+"')]/..//input"));
			String noOfAssets = ActionUtils.readText(driver, assetListInfo);
			String[] list= noOfAssets.split("of");
			int recordsCount = Integer.parseInt(list[1].replaceAll("[^0-9]", ""));
			Reporter.log("Records count for the given manufacturer: "+recordsCount, true);
			a.assertEquals(recordsCount, count, "Filter count and rceords count are not matched");
			Reporter.log("Filter count and records are matched", true);
			// Open asset check the manufacturer presence 
			ActionUtils.jsClick(driver, ActionUtils.getElements(driver, editBtnList).get(0));
			Thread.sleep(2000);
			List<WebElement> ddOptions = ActionUtils.getElements(driver, By.xpath("//label[contains(.,'Manufacturer')]//following::select/../label[text()='Manufacturer']/../select/option"));
			boolean status = false;
			for (WebElement ele : ddOptions) {
				 String option = ele.getText();
				 if (option.equals(manufacturer)) {
					status = true;
				}
			}
			a.assertTrue(status, "Given manufacturer not selected in asset manufacturer dropdown");
			Reporter.log("Given manufacturer selected in asset manufacturer dropdown", true);
		} else {
			Reporter.log("No records found for the given manufacturer at filter", true);
		}
		a.assertAll();
	}

	public void verify_Filter_by_locations(String location) throws Exception {
		SoftAssert a = new SoftAssert();
		// Verify records count
		ActionUtils.ajaxJsClick(driver, filterBtn);
		ActionUtils.ajaxScrollIntoView(driver, filterByLocationsSection);
		int countAtFilter = Integer.parseInt(ActionUtils.readText(driver, 
				By.xpath("//div[@id='Locationslist']//span[contains(text(),'"+location+"')]//following-sibling::label")).replaceAll("[^0-9]", ""));
		Reporter.log("Filter count for the given location: "+countAtFilter, true);
		if (countAtFilter != 0) {
			ActionUtils.ajaxJsClick(driver, By.xpath("//div[@id='Locationslist']//span[contains(text(),'"+location+"')]/..//input"));
			String noOfAssets = ActionUtils.readText(driver, assetListInfo);
			String[] list= noOfAssets.split("of");
			int recordsCount = Integer.parseInt(list[1].replaceAll("[^0-9]", ""));
			Reporter.log("Records count for the given location: "+recordsCount, true);
			a.assertEquals(recordsCount, countAtFilter, "Filter count and records count are not matched");
			Reporter.log("Filter count and records are matched", true);
			// Open asset check the manufacturer presence 
			ActionUtils.jsClick(driver, ActionUtils.getElements(driver, editBtnList).get(0));
			Thread.sleep(2000);
			String	ddOption = ActionUtils.getFirstSelectedOption(driver, currentLocationDD);
			Thread.sleep(1000);
			a.assertTrue(ddOption.contains(location), "Given location not selected in asset current location dropdown");
			Reporter.log("Given location selected in asset current location dropdown", true);

		} else {
			Reporter.log("No records found for the given location at filter", true);
		}
		a.assertAll();
	}

	public void verify_Filter_by_types(String type) throws Exception {
		SoftAssert a = new SoftAssert();
		// Verify records count
		ActionUtils.ajaxJsClick(driver, filterBtn);
		ActionUtils.ajaxJsClick(driver, clearAllBtn);
		ActionUtils.ajaxScrollIntoView(driver, filterByTypesSection);
		int countAtFilter = Integer.parseInt(ActionUtils.readText(driver, 
				By.xpath("//div[@id='Typeslist']//span[contains(text(),'"+type+"')]//following-sibling::label")).replaceAll("[^0-9]", ""));
		Reporter.log("Filter count for the given type: "+countAtFilter, true);
		if (countAtFilter != 0) {
			ActionUtils.ajaxJsClick(driver, By.xpath("//div[@id='Typeslist']//span[contains(text(),'"+type+"')]/..//input"));
			String noOfAssets = ActionUtils.readText(driver, assetListInfo);
			String[] list= noOfAssets.split("of");
			int recordsCount = Integer.parseInt(list[1].replaceAll("[^0-9]", ""));
			Reporter.log("Records count for the given type: "+recordsCount, true);
			a.assertEquals(recordsCount, countAtFilter, "Filter count and records count are not matched");
			Reporter.log("Filter count and records are matched", true);
			// Open asset check the manufacturer presence 
			ActionUtils.jsClick(driver, ActionUtils.getElements(driver, editBtnList).get(0));
			Thread.sleep(2000);
			String	ddOption = ActionUtils.getFirstSelectedOption(driver, typeDD);
			a.assertEquals(ddOption, type, "Given type not selected in asset type dropdown");
			Reporter.log("Given type selected in asset type dropdown", true);
		} else {
			Reporter.log("No records found for the given type at filter", true);
		}
		a.assertAll();
	}

	public void verify_Filter_by_status(String status) throws Exception {
		SoftAssert a = new SoftAssert();
		// Verify records count
		ActionUtils.ajaxJsClick(driver, filterBtn);
		ActionUtils.ajaxJsClick(driver, clearAllBtn);
		ActionUtils.ajaxScrollIntoView(driver, filterByStatusSection);
		int countAtFilter = Integer.parseInt(ActionUtils.readText(driver, 
				By.xpath("//div[@id='Statuslist']//span[contains(text(),'"+status+"')]//following-sibling::label")).replaceAll("[^0-9]", ""));
		Reporter.log("Filter count for the given status: "+countAtFilter, true);
		if (countAtFilter != 0) {
			ActionUtils.ajaxJsClick(driver, By.xpath("//div[@id='Statuslist']//span[contains(text(),'"+status+"')]/..//input"));
			String noOfAssets = ActionUtils.readText(driver, assetListInfo);
			String[] list= noOfAssets.split("of");
			int recordsCount = Integer.parseInt(list[1].replaceAll("[^0-9]", ""));
			Reporter.log("Records count for the given status: "+recordsCount, true);
			a.assertEquals(recordsCount, countAtFilter, "Filter count and records count are not matched");
			Reporter.log("Filter count and records are matched", true);
			// Open asset check the manufacturer presence 
			ActionUtils.jsClick(driver, ActionUtils.getElements(driver, editBtnList).get(0));
			Thread.sleep(2000);
			a.assertTrue(ActionUtils.getElement(driver, By.xpath("//label[text()='Status']//following::option[text()='"+status+"']")).isDisplayed(), "Given status not selected in asset status dropdown");
			Reporter.log("Given status selected in asset status dropdown",true);
	}
	}
		

	public void verify_Filter_by_Calibration_status(String status) throws Exception {
		SoftAssert a = new SoftAssert();
		// Verify records count
		ActionUtils.ajaxJsClick(driver, filterBtn);
		ActionUtils.ajaxScrollIntoView(driver, filterByCalibrationSection);
		int countAtFilter = Integer.parseInt(ActionUtils.readText(driver, 
				By.xpath("//div[@id='Calibrationlist']//span[contains(text(),'"+status+"')]//following-sibling::label")).replaceAll("[^0-9]", ""));
		Reporter.log("Filter count for the given calibration status: "+countAtFilter, true);
		if (countAtFilter != 0) {
			ActionUtils.ajaxJsClick(driver, By.xpath("//div[@id='Calibrationlist']//span[contains(text(),'"+status+"')]/..//input"));
			String noOfAssets = ActionUtils.readText(driver, assetListInfo);
			String[] list= noOfAssets.split("of");
			int recordsCount = Integer.parseInt(list[1].replaceAll("[^0-9]", ""));
			Reporter.log("Records count for the given calibration status: "+recordsCount, true);
			a.assertEquals(recordsCount, countAtFilter, "Filter count and records count are not matched");
			Reporter.log("Filter count and records are matched", true);
			// Open asset check the manufacturer presence 
			ActionUtils.jsClick(driver, ActionUtils.getElements(driver, editBtnList).get(0));
			Thread.sleep(2000);
			/*String calibStatus = ActionUtils.getAttributeValue(driver, calibrationStatus, "title");
			Thread.sleep(1000);
			a.assertEquals(calibStatus, status, "Given calibration status not found in asset");
			Reporter.log("Given calibration status found in asset", true);
		} else {
			Reporter.log("No records found for the given calibration status at filter", true);
		}*/
			a.assertTrue(ActionUtils.getElement(driver, By.xpath("//input[@title='"+status+"']")).isDisplayed(), "Given calibration status not found in asset");
			Reporter.log("Given calibration status found in asset", true);
		a.assertAll();
	}
	}
	
	public void verify_Filter_by_range(String to, String from) throws Exception {
		// Set min & max ranges
		ActionUtils.ajaxJsClick(driver, filterBtn);
		ActionUtils.ajaxJsClick(driver, clearAllBtn);
		ActionUtils.ajaxScrollIntoView(driver, filterByRangeSection);
		Thread.sleep(1000);
		ActionUtils.sliderDragAndDrap(driver, sliderBar, sliderTo, to);
		Thread.sleep(1000);
		ActionUtils.sliderDragAndDrap(driver, sliderBar, sliderFrom, from);
		ActionUtils.waitForAjax(driver);
		int n1 = Integer.parseInt(ActionUtils.readText(driver, minValue));
		int n2 = Integer.parseInt(ActionUtils.readText(driver, maxValue));
		Reporter.log("Given minimum range: "+n1, true);
		Reporter.log("Given maximum range: "+n2, true);
		// Verify the range in the resultant records
		ActionUtils.jsClick(driver, ActionUtils.getElements(driver, editBtnList).get(0));
		Thread.sleep(2000);
		int r1 = Integer.parseInt(ActionUtils.getAttributeValue(driver, range1Field, "value"));
		int r2 = Integer.parseInt(ActionUtils.getAttributeValue(driver, range2Field, "value"));
		Reporter.log("Asset range 1 field value: "+r1, true);
		Reporter.log("Asset range 1 field value: "+r2, true);
		Assert.assertTrue(((r1>=n1 && r1<=n2) && (r2>=n1 && r2<=n2)), "Resultant asset range values are not under the given range");
		Reporter.log("Resultant asset range values are not under the given range", true);
	}

	public void verify_Request_for_calibration_and_verify_the_requested_asset_in_calibration_requests_list(String asset) throws Exception {
		SoftAssert a = new SoftAssert();
		// Send request
		ActionUtils.jsType(driver, assetsSearchBox, asset);
		ActionUtils.ajaxJsClick(driver, assetsSearchBtn);
		ActionUtils.jsClick(driver, By.xpath("//td[@class=' table-td'][contains(.,'"+asset+"')]//following::a[@name='editAssetBtn']"));
		Thread.sleep(2000);
		ActionUtils.ajaxJsClick(driver, requestForCalibrationBtn);
		a.assertTrue(ActionUtils.getElement(driver, savedSuccessfullyMsg).isDisplayed(), "Calibration request not sent");
		Reporter.log("Calibration request sent", true);
		// Calibration page
		ActionUtils.ajaxJsClick(driver, Calibration);
		ActionUtils.ajaxJsClick(driver, CalibrationPage.requestsTab);
		ActionUtils.ajaxJsClick(driver, CalibrationPage.lastPage);
		boolean req = false;
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'"+asset+"')]")).isDisplayed());
			req = true;
		} catch (Exception e) {
			Reporter.log("Given asset not found in Calibration page requests list", true);
		}
		a.assertTrue(req, "Given asset not found in Calibration page requests list");
		Reporter.log("Given asset found in Calibration page requests list", true);
		a.assertAll();
	}

	public void verify_Add_filter_by_custom_fields(String field) throws Exception {
		ActionUtils.ajaxJsClick(driver, filterBtn);
		ActionUtils.ajaxScrollIntoView(driver, filterBtn2);
		ActionUtils.click(driver, filterBtn2);
		ActionUtils.clickClearAndType(driver, filterSearch, field);
		By option = By.xpath("//li[@role='option'][contains(.,'"+field+"')]");
		ActionUtils.scrollIntoView(driver, option);
		ActionUtils.click(driver, option);
		boolean result = ActionUtils.getElement(driver, By.xpath("//input[@placeholder='"+field+"']")).isDisplayed();
		Assert.assertTrue(result, "Field not added");
		Reporter.log("Field added", true);
		if (result) {
			ActionUtils.ajaxJsClick(driver, By.xpath("//input[@placeholder='"+field+"']//preceding::i[1]"));
			try {
				Assert.assertTrue(driver.findElement(By.xpath("//input[@placeholder='"+field+"']")).isDisplayed());
				Assert.fail("Field not removed at filter");
			} catch (NoSuchElementException e) {
				Reporter.log("Field removed at filter", true);
			} 			
		}
	}

	public void verify_Add_control_for_the_asset(String value, String unit) throws Exception {
		SoftAssert a = new SoftAssert();
		List<WebElement> btnList = ActionUtils.getElements(driver, editBtnList);
		ActionUtils.ajaxJsClick(driver, btnList.get(0));
		ActionUtils.ajaxJsClick(driver, scheduleTab);
		// Control 1
		Reporter.log("===== Control 1 Settings =====", true);
		// Calendar - Months
		ActionUtils.ajaxJsClick(driver, c1_Calendar);
		ActionUtils.ajaxJsClick(driver, c1_Months);
		ActionUtils.clickClearAndType(driver, c1_ValueField, value);
		ActionUtils.ajaxJsClick(driver, c1_ApplyBtn);
		a.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'CALENDAR')])[1]//following::span[contains(.,'"+value+"   MONTHS')]")).isDisplayed(), "Calender-Months control not set");
		Reporter.log("Calender-Months control set", true);
		// Calendar - Weeks
		ActionUtils.ajaxJsClick(driver, c1_Weeks);
		ActionUtils.ajaxJsClick(driver, c1_ApplyBtn);
		a.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'CALENDAR')])[1]//following::span[contains(.,'"+value+"   WEEKS')]")).isDisplayed(), "Calender-Weeks control not set");
		Reporter.log("Calender-Weeks control set", true);
		// Calendar - Days
		ActionUtils.ajaxJsClick(driver, c1_Days);
		ActionUtils.ajaxJsClick(driver, c1_ApplyBtn);
		a.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'CALENDAR')])[1]//following::span[contains(.,'"+value+"   DAYS')]")).isDisplayed(), "Calender-Days control not set");
		Reporter.log("Calender-Days control set", true);
		// Timer - Days - Capture
		ActionUtils.ajaxJsClick(driver, c1_Timer);
		ActionUtils.ajaxJsClick(driver, c1_Days);
		ActionUtils.clickClearAndType(driver, c1_ValueField, value);
		ActionUtils.ajaxJsClick(driver, c1_Capture);
		ActionUtils.ajaxJsClick(driver, c1_ApplyBtn);
		a.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'TIMER')])[1]//following::span[contains(.,'"+value+"   DAYS')]")).isDisplayed(), "Timer-Days-Capture control not set");
		Reporter.log("Timer-Days-Capture control set", true);
		// Timer - Hours - Location
		ActionUtils.ajaxJsClick(driver, c1_Hours);
		ActionUtils.clickClearAndType(driver, c1_ValueField, value);
		ActionUtils.ajaxJsClick(driver, c1_Location);
		ActionUtils.ajaxJsClick(driver, c1_ApplyBtn);
		a.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'TIMER')])[1]//following::span[contains(.,'"+value+"   HOURS')]")).isDisplayed(), "Timer-Hours-Location control not set");
		Reporter.log("Timer-Hours-Location control set", true);
		// Timer - Minutes - Location
		ActionUtils.ajaxJsClick(driver, c1_Minutes);
		ActionUtils.clickClearAndType(driver, c1_ValueField, value);
		ActionUtils.ajaxJsClick(driver, c1_Location);
		ActionUtils.ajaxJsClick(driver, c1_ApplyBtn);
		a.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'TIMER')])[1]//following::span[contains(.,'"+value+"   MINUTES')]")).isDisplayed(), "Timer-Minutes-Location control not set");
		Reporter.log("Timer-Minutes-Location control set", true);
		// Counter
		ActionUtils.ajaxJsClick(driver, c1_Counter);
		ActionUtils.clickClearAndType(driver, c1_UnitField, unit + Keys.ENTER);
		ActionUtils.clickClearAndType(driver, c1_ValueField, value);
		ActionUtils.ajaxJsClick(driver, c1_ApplyBtn);
		a.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'COUNTER')])[1]//following::span[contains(.,'"+value+"')][1]")).isDisplayed(), "Counter-Unit-Value control not set");
		Reporter.log("Counter-Unit-Value control set", true);
		// NCR
		ActionUtils.ajaxJsClick(driver, c1_Ncr);
		ActionUtils.clickClearAndType(driver, c1_ValueField, value);
		ActionUtils.ajaxJsClick(driver, c1_ApplyBtn);
		a.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'NCR')])[2]//following::span[contains(.,'"+value+"')]")).isDisplayed(), "NCR control not set");
		Reporter.log("NCR control set", true);
		// Control 2
		ActionUtils.ajaxJsClick(driver, control2);
		Reporter.log("===== Control 2 Settings =====", true);
		// Calendar - Months
		ActionUtils.ajaxJsClick(driver, c2_Calendar);
		ActionUtils.ajaxJsClick(driver, c2_Months);
		ActionUtils.clickClearAndType(driver, c2_ValueField, value);
		ActionUtils.ajaxJsClick(driver, c2_ApplyBtn);
		a.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'CALENDAR')])[1]//following::span[contains(.,'"+value+"   MONTHS')]")).isDisplayed(), "Calender-Months control not set");
		Reporter.log("Calender-Months control set", true);
		// Calendar - Weeks
		ActionUtils.ajaxJsClick(driver, c2_Weeks);
		ActionUtils.ajaxJsClick(driver, c2_ApplyBtn);
		a.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'CALENDAR')])[1]//following::span[contains(.,'"+value+"   WEEKS')]")).isDisplayed(), "Calender-Weeks control not set");
		Reporter.log("Calender-Weeks control set", true);
		// Calendar - Days
		ActionUtils.ajaxJsClick(driver, c2_Days);
		ActionUtils.ajaxJsClick(driver, c2_ApplyBtn);
		a.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'CALENDAR')])[1]//following::span[contains(.,'"+value+"   DAYS')]")).isDisplayed(), "Calender-Days control not set");
		Reporter.log("Calender-Days control set", true);
		// Timer - Days - Capture
		ActionUtils.ajaxJsClick(driver, c2_Timer);
		ActionUtils.ajaxJsClick(driver, c2_Days);
		ActionUtils.clickClearAndType(driver, c2_ValueField, value);
		ActionUtils.ajaxJsClick(driver, c2_Capture);
		ActionUtils.ajaxJsClick(driver, c2_ApplyBtn);
		a.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'TIMER')])[1]//following::span[contains(.,'"+value+"   DAYS')]")).isDisplayed(), "Timer-Days-Capture control not set");
		Reporter.log("Timer-Days-Capture control set", true);
		// Timer - Hours - Location
		ActionUtils.ajaxJsClick(driver, c2_Hours);
		ActionUtils.clickClearAndType(driver, c2_ValueField, value);
		ActionUtils.ajaxJsClick(driver, c2_Location);
		ActionUtils.ajaxJsClick(driver, c2_ApplyBtn);
		a.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'TIMER')])[1]//following::span[contains(.,'"+value+"   HOURS')]")).isDisplayed(), "Timer-Hours-Location control not set");
		Reporter.log("Timer-Hours-Location control set", true);
		// Timer - Minutes - Location
		ActionUtils.ajaxJsClick(driver, c2_Minutes);
		ActionUtils.clickClearAndType(driver, c2_ValueField, value);
		ActionUtils.ajaxJsClick(driver, c2_Location);
		ActionUtils.ajaxJsClick(driver, c2_ApplyBtn);
		a.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'TIMER')])[1]//following::span[contains(.,'"+value+"   MINUTES')]")).isDisplayed(), "Timer-Minutes-Location control not set");
		Reporter.log("Timer-Minutes-Location control set", true);
		// Counter
		ActionUtils.ajaxJsClick(driver, c2_Counter);
		ActionUtils.clickClearAndType(driver, c2_UnitField, unit + Keys.ENTER);
		ActionUtils.clickClearAndType(driver, c2_ValueField, value);
		ActionUtils.ajaxJsClick(driver, c2_ApplyBtn);
		a.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'COUNTER')])[1]//following::span[contains(.,'"+value+"')][1]")).isDisplayed(), "Counter-Unit-Value control not set");
		Reporter.log("Counter-Unit-Value control set", true);
		// NCR
		ActionUtils.ajaxJsClick(driver, c2_Ncr);
		ActionUtils.clickClearAndType(driver, c2_ValueField, value);
		ActionUtils.ajaxJsClick(driver, c2_ApplyBtn);
		a.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'NCR')])[3]//following::span[contains(.,'"+value+"')]")).isDisplayed(), "NCR control not set");
		Reporter.log("NCR control set", true);

		a.assertAll();
	}

	public void verify_Change_asset_calibration_status_to_out_of_calibration() {
		List<WebElement> btnList = ActionUtils.getElements(driver, editBtnList);
		ActionUtils.ajaxJsClick(driver, btnList.get(0));
		ActionUtils.ajaxJsClick(driver, clearCurrentCalibrationStatusBtn);




	}

	public void verify_View_asset_history() throws Exception {
		SoftAssert a= new SoftAssert();
		List<WebElement> btnList = ActionUtils.getElements(driver, editBtnList);
		ActionUtils.ajaxJsClick(driver, btnList.get(0));
		ActionUtils.ajaxJsClick(driver, historyTab);
		// History table headers
		a.assertTrue(ActionUtils.getElement(driver, historyNameHeader).isDisplayed(), "Name option is not displayed in history tab");
		Reporter.log("Name option is displayed in history tab", true);
		a.assertTrue(ActionUtils.getElement(driver, historyEventHeader).isDisplayed(), "Event option is not displayed in history tab");
		Reporter.log("Event option is displayed in history tab", true);
		a.assertTrue(ActionUtils.getElement(driver, historyDateAndTimeHeader).isDisplayed(), "Date & Time option is not displayed in history tab");
		Reporter.log("Date & Time option is displayed in history tab", true);
		// Filter by options
		a.assertTrue(ActionUtils.getElement(driver, historyCalibrationStatusSection).isDisplayed(), "Calibration status section is not displayed in history tab");
		Reporter.log("Calibration status section is displayed in history tab", true);
		a.assertTrue(ActionUtils.getElement(driver, historyLocationsSection).isDisplayed(), "Location section is not displayed in history tab");
		Reporter.log("Location section is displayed in history tab", true);
		ActionUtils.scrollIntoView(driver, historyUsersSection);
		a.assertTrue(ActionUtils.getElement(driver, historyUsersSection).isDisplayed(), "Users section is not displayed in history tab");
		Reporter.log("Users section is displayed in history tab", true);
		ActionUtils.scrollIntoView(driver, historyPeriodSection);
		a.assertTrue(ActionUtils.getElement(driver, historyPeriodSection).isDisplayed(), "Period section is not displayed in history tab");
		Reporter.log("Period section is displayed in history tab", true);

		a.assertAll();
	}

	public void verify_Download_crtificate(String downloadPath, String fileName) throws Exception {
		List<WebElement> btnList = ActionUtils.getElements(driver, editBtnList);
		ActionUtils.ajaxJsClick(driver, btnList.get(btnList.size()-1));
		Thread.sleep(2000);
		ActionUtils.ajaxClick(driver, calibrationTab);
		try {
			ActionUtils.ajaxJsClick(driver, downloadCertificateBtn);
			Thread.sleep(3000);
			Assert.assertTrue(VerificationLibrary.isFileDownloaded(downloadPath, fileName), "Certificate not downloaded");
			Reporter.log("Certificate downloaded", true);
		} catch (NoSuchElementException e) {
			Reporter.log("No calibration records found", true);
		}
	}

















}















