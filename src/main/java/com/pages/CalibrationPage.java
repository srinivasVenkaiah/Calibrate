/**
 * @author UmaMaheswararao
 */

package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.BasePage;
import com.util.ActionUtils;

public class CalibrationPage extends BasePage {

	// Objects Repository(OR):........................................................................
	// Page verification
	@FindBy(xpath="//a[contains(text(),'Calibration')]")
	WebElement calibrationLink;

	// Tabs
	By outOfCalibrationTab = By.xpath("//div[text()[normalize-space()='Out of Calibration']]");
	By calibrationTab = By.xpath("//div[text()[normalize-space()='Calibration']] ");
	static By requestsTab = By.xpath("//div[text()[normalize-space()='Requests']]");
	By upcomingCalibrationsTab = By.xpath("//div[text()[normalize-space()='Upcoming Calibrations']]");

	static By lastPage = By.xpath("(//a[text()='Next']/../preceding::li[1]/a)[2]");
	By lastPage_OutOfCalibration = By.xpath("(//a[text()='Next']/../preceding::li[1]/a)[1]");
	By lastPage_Requests = By.xpath("(//a[text()='Next']/../preceding::li[1]/a)[2]");
	By lastPage_UpcomingCalibration = By.xpath("(//a[text()='Next']/../preceding::li[1]/a)[2]");
	By lastPage_CalibrationQueue = By.xpath("(//a[text()='Next'])[2]/../preceding::li[1]/a");
	By lastPage_CalibrationExternal = By.xpath("(//a[text()='Next'])[3]/../preceding::li[1]/a");
	static By nextBtn = By.cssSelector("li#RequestAssetsTable_next>a");
	By nextBtn_OutOfCalibration = By.cssSelector("li#OutAssetsList_next>a");
	By nextBtn_Requests = By.cssSelector("li#RequestAssetsTable_next>a");
	By nextBtn_UpcomingCalibration = By.cssSelector("li#UpCAssetsTable_next>a");
	By nextBtn_CalibrationQueue = By.cssSelector("li#QueueAssetsTable_next>a");
	By nextBtn_CalibrationExternal = By.cssSelector("li#ExternalAssetsTable_next>a");
	
	// Tab count verification 
	static By outOfCalibrationCount = By.xpath("//span[contains(@id,'OutTotal')]");
	By outOfCalibrationAssetsInfo = By.xpath("//div[contains(@id,'OutAssetsList_info')]");
	By issueRecallBtn_OutOfCalibration = By.xpath("//button[contains(@id,'OutRecBtn')]");
	By recallBtn = By.xpath("//button[contains(@id,'RecallEmail')]");
	By emailSendSeccessAlert = By.xpath("//div[contains(@class,'success alert')][contains(.,'Email sent successfully')]");
	By calibrationBtn_OutOfCalibration = By.xpath("//button[contains(@id,'OutCalBtn')]");
	By pleaseSelectAssetErrorMsg = By.xpath("//div[contains(.,'Please select assets.')]");
	By inCalibrationCount = By.xpath("//span[contains(@id,'InTotal')]"); 
	By targetDateBtn = By.xpath("//i[contains(@title,'Change Date')]");
	By sendBtn = By.xpath("//div[text()[normalize-space()='SCHEDULE CALIBRATION']]//following::button[2]");
	By queueAssetRecordsInfo = By.xpath("//div[contains(@id,'QueueAssetsTable_info')]");
	By externalAssetRecordsInfo = By.xpath("//div[contains(@id,'ExternalAssetsTable_info')]");
	By externalCalibrationBtn = By.xpath("//button[contains(@id,'QueueExtBtn')]");
	By supplierSearchBox = By.xpath("//input[contains(@id,'CompanyList')]");
	By submitBtn = By.xpath("//button[text()[normalize-space()='Submit']]");
	By agreedDate = By.xpath("//div[contains(@id,'AgreedDate')]");
	By orderNoField = By.xpath("//input[contains(@id,'OrderNumber')]");
	By sendSupplierInfoBtn = By.xpath("//button[contains(@id,'sendInfoBtn')]");
	By changeCompanyBtn = By.linkText("CHANGE COMPANY");

	// Internal Calibration
	By onlyReferenceEquipementCheckBox = By.xpath("//input[contains(@id,'OnlyReference')]");
	By onlyCalibratedEquipementCheckBox = By.xpath("//input[contains(@id,'OnlyCalibrated')]");
	By nextStepBtn = By.xpath("//i[contains(@id,'stepOneNext')]");

	// Book-in
	By checkBox_BookIn = By.xpath("//span[contains(@class,'box')]");
	By uploadBtn_BookInPage = By.cssSelector("div#Uploadlist>form");
	By bookInBtn = By.xpath("//button[contains(@id,'SendBook')]");
	By bookInFileUploadErrorMsg = By.xpath("//div[contains(@class,'alert-dismissible')][contains(.,'Please upload file')]");

	// Requests
	By requestsCount = By.xpath("//span[contains(@id,'RequestTotal')]");
	By requestsRecordsInfo = By.xpath("//div[contains(@id,'RequestAssetsTable_info')]");
	By issueRecallBtn_Requests = By.xpath("//button[contains(@id,'ReqRecBtn')]");
	By calibrationBtn_Requests = By.xpath("//button[contains(@id,'ReqCalBtn')]");

	// Upcoming calibrations 
	static By upcomingCalibrationsCount = By.xpath("//span[contains(@id,'UpcTotal')]");
	By upcomingCalibRecordsInfo = By.xpath("//div[contains(@id,'UpCAssetsTable_info')]");
	By issueRecallBtn_UpcomingCalibrations = By.xpath("//button[contains(@id,'UpcRecBtn')]");
	By calibrationBtn_UpcomingCalibrations = By.xpath("//button[contains(@id,'UpcCalBtn')]");
















	// Initializing the Page Objects:................................................................
	public CalibrationPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public void verify_CalibrationPage() {
		SoftAssert a = new SoftAssert();
		a.assertTrue(calibrationLink.isDisplayed(), "Unable to Navigate calibration page");
		Reporter.log("Navigated to calibration page",true);
		a.assertTrue(ActionUtils.getElement(driver, outOfCalibrationTab).isDisplayed(), "Out of calibration tab not displayed");
		Reporter.log("Out of calibration tab displayed", true);
		a.assertTrue(ActionUtils.getElement(driver, calibrationTab).isDisplayed(), "Calibration tab not displayed");
		Reporter.log("Calibration tab displayed", true);
		a.assertTrue(ActionUtils.getElement(driver, requestsTab).isDisplayed(), "Requests tab not displayed");
		Reporter.log("Requests tab displayed", true);
		a.assertTrue(ActionUtils.getElement(driver, upcomingCalibrationsTab).isDisplayed(), "Upcoming of calibration tab not displayed");
		Reporter.log("Upcoming of calibration tab not displayed", true);
		a.assertAll();
	}

	public void verify_Out_of_calibration_records() {
		ActionUtils.ajaxJsClick(driver, outOfCalibrationCount);
		int tabCount = Integer.parseInt(ActionUtils.readText(driver, outOfCalibrationCount).trim());
		Reporter.log("Tab count: "+tabCount, true);
		if (tabCount != 0) {
			String info = ActionUtils.readText(driver, outOfCalibrationAssetsInfo);
			String[] list= info.split("of");
			int recordsCount = Integer.parseInt(list[1].replaceAll("[^0-9]", ""));
			Reporter.log("Records count: "+recordsCount, true);
			Assert.assertEquals(tabCount, recordsCount, "Out of calibration tab count and resultant records count not matched");
			Reporter.log("Out of calibration tab count and resultant records count matched", true);
		} else {
			Reporter.log("No records found for out of calibration", true);
		}
	}

	public void verify_Issue_recall_option_for_out_of_calibration_assets() throws Exception {
		ActionUtils.ajaxJsClick(driver, outOfCalibrationCount);
		int tabCount = Integer.parseInt(ActionUtils.readText(driver, outOfCalibrationCount).trim());
		Reporter.log("Tab count: "+tabCount, true);
		if (tabCount != 0) {
			int n = Integer.parseInt(ActionUtils.readText(driver, lastPage_OutOfCalibration));
			for (int i = 0; i < n; i++) {
				try {
					ActionUtils.checkbox_Checking(driver, By.xpath("(//input[contains(@name,'OutCheckBox')])[1]"));
					break;
				} catch (Exception e) {
					ActionUtils.ajaxJsClick(driver, nextBtn_OutOfCalibration);
					Thread.sleep(1000);
				}
			}
			ActionUtils.jsClick(driver, issueRecallBtn_OutOfCalibration);
			try {
				ActionUtils.ajaxClick(driver, recallBtn);
				Assert.assertTrue(ActionUtils.getElement(driver, emailSendSeccessAlert).isDisplayed(), "Recall option is not functional");
				Reporter.log("Recall option is functional - 'Email sent successfully' to owner", true);
			} catch (Exception e) {
				Reporter.log("No assets to recall", true);
			}
		} else {
			Reporter.log("No records found for out of calibration", true);
		}
	}

	public void verify_Send_asset_to_calibration_option() throws Exception {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsClick(driver, outOfCalibrationCount);
		int outTabCount = Integer.parseInt(ActionUtils.readText(driver, outOfCalibrationCount).trim());
		Reporter.log("Out of calibration tab count: "+outTabCount, true);
		int inTabCount = Integer.parseInt(ActionUtils.readText(driver, inCalibrationCount).trim());
		Reporter.log("In calibration tab count before sending asset to calibration: "+inTabCount, true);
		if (outTabCount != 0) {
			String id=null;
			int n = Integer.parseInt(ActionUtils.readText(driver, lastPage_OutOfCalibration));
			for (int i = 0; i < n; i++) {
				try {
					id = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]/../..//td[2]")).getText();
					ActionUtils.ajaxCheckbox_Checking(driver, By.xpath("(//input[@type='checkbox'])[1]"));
					break;
				} catch (Exception e) {
					ActionUtils.ajaxJsClick(driver, nextBtn_OutOfCalibration);
					Thread.sleep(1000);
				}
			}
			ActionUtils.ajaxClick(driver, calibrationBtn_OutOfCalibration);
			ActionUtils.ajaxClick(driver, targetDateBtn);
			List<WebElement> dateList = driver.findElements(By.xpath("//td[@class='day']"));
			for (WebElement ele : dateList) {
				if (ele.getText().contains("20")) {
					ActionUtils.jsClick(driver, ele);
					break;
				}
			}
			ActionUtils.ajaxClick(driver, sendBtn);
			int inTabCount2 = Integer.parseInt(ActionUtils.readText(driver, inCalibrationCount).trim());
			Reporter.log("In calibration tab count after sending asset to calibration: "+inTabCount2, true);
			a.assertTrue(inTabCount2 > inTabCount, "Asset not sent to calibration");
			Reporter.log("Asset sent to calibration", true);
			// Verify 'At calibration'
			String text = ActionUtils.readText(driver, By.xpath("//td[text()='"+id+"']/..//td[1]/span"));
			a.assertEquals(text, "At Calibration", "Checkbox not changed to 'At Calibration'");
			Reporter.log("Checkbox changed to 'At Calibration'", true);
		} else {
			Reporter.log("No records found for out of calibration", true);
		}
		a.assertAll();
	}

	public void verify_Clibration_records() {
		ActionUtils.ajaxJsClick(driver, inCalibrationCount);
		int tabCount = Integer.parseInt(ActionUtils.readText(driver, inCalibrationCount).trim());
		Reporter.log("Tab count: "+tabCount, true);
		if (tabCount != 0) {
			int n = Integer.parseInt(ActionUtils.readText(driver, lastPage_CalibrationQueue));
			int totalCalibrateCount=0;
			for (int i = 0; i < n; i++) {
				int calibrateCount = driver.findElements(By.xpath("//button[@name='editAssetBtn']")).size();
				totalCalibrateCount = totalCalibrateCount + calibrateCount;
				ActionUtils.ajaxJsClick(driver, nextBtn_CalibrationQueue);
			}
			Reporter.log("No.of assets to Calibrate: "+totalCalibrateCount, true);
			int n1 = Integer.parseInt(ActionUtils.readText(driver, lastPage_CalibrationExternal));
			int totalBookInCount=0;
			for (int i = 0; i < n1; i++) {
				int bookInCount = driver.findElements(By.xpath("//button[contains(.,'BookIn')]")).size();
				totalBookInCount = totalBookInCount + bookInCount;
				ActionUtils.ajaxJsClick(driver, nextBtn_CalibrationExternal);
			}
			Reporter.log("No.of assets to BookIn: "+totalBookInCount, true);
			int totalRecordsCount = totalCalibrateCount + totalBookInCount;
			Assert.assertEquals(totalRecordsCount, tabCount, "Calibration tab count and resultant records count not matched");
			Reporter.log("Calibration tab count and resultant records count matched", true);
		} else {
			Reporter.log("No records found for out of calibration", true);
		}
	}

	public void verify_Send_asset_to_external_calibration(String company, String date, String orderNo) throws Exception {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsClick(driver, inCalibrationCount);
		int tabCount = Integer.parseInt(ActionUtils.readText(driver, inCalibrationCount).trim());
		Reporter.log("Tab count: "+tabCount, true);
		if (tabCount != 0) {
			String[] queueInfo = ActionUtils.readText(driver, queueAssetRecordsInfo).split("of");
			int queueRecordsCount = Integer.parseInt(queueInfo[1].replaceAll("[^0-9]", ""));
			Reporter.log("Queue records count before sending asset to External Calibration: "+queueRecordsCount, true);
			if (queueRecordsCount != 0) {
				String[] externalInfo = ActionUtils.readText(driver, externalAssetRecordsInfo).split("of");
				int externalRecordsCount = Integer.parseInt(externalInfo[1].replaceAll("[^0-9]", ""));
				Reporter.log("External records count before sending asset to External Calibration: "+externalRecordsCount, true);
				ActionUtils.ajaxJsClick(driver, By.xpath("(//input[@name='QueueCheckBox'])[1]"));
				ActionUtils.ajaxJsClick(driver, externalCalibrationBtn);
				ActionUtils.clickClearAndType(driver, supplierSearchBox, company);
				ActionUtils.ajaxJsClick(driver, By.xpath("//div[contains(text(),'"+company+"')]/..//button[1]"));
				ActionUtils.ajaxJsClick(driver, submitBtn);
				List<WebElement> dateList = driver.findElements(By.xpath("//td[@class='day']"));
				for (WebElement ele : dateList) {
					if (ele.getText().contains(date)) {
						ActionUtils.jsClick(driver, ele);
						break;
					}
				}
				a.assertTrue(ActionUtils.readText(driver, agreedDate) != null, "Agreed date not updated");
				Reporter.log("Agreed date updated", true);
				ActionUtils.jsType(driver, orderNoField, orderNo);
				ActionUtils.ajaxJsClick(driver, sendSupplierInfoBtn);
				String[] queueInfo2 = ActionUtils.readText(driver, queueAssetRecordsInfo).split("of");
				int queueRecordsCount2 = Integer.parseInt(queueInfo2[1].replaceAll("[^0-9]", ""));
				Reporter.log("Queue records count after sending asset to External Calibration: "+queueRecordsCount2, true);
				String[] externalInfo2 = ActionUtils.readText(driver, externalAssetRecordsInfo).split("of");
				int externalRecordsCount2 = Integer.parseInt(externalInfo2[1].replaceAll("[^0-9]", ""));
				Reporter.log("External records count before sending asset to External Calibration: "+externalRecordsCount2, true);
				a.assertTrue(queueRecordsCount2 < queueRecordsCount && externalRecordsCount2 > externalRecordsCount, "Asset not sent to external calibration");
				Reporter.log("Asset sent to external calibration", true);
			} else {
				Reporter.log("No records found in the Queue", true);
			}
		} else {
			Reporter.log("No assets available in calibration", true);
		}
		a.assertAll();
	}

	public void verify_Change_supplier_company(String company) throws Exception {
		ActionUtils.ajaxJsClick(driver, inCalibrationCount);
		int tabCount = Integer.parseInt(ActionUtils.readText(driver, inCalibrationCount).trim());
		Reporter.log("Tab count: "+tabCount, true);
		if (tabCount != 0) {
			String[] queueInfo = ActionUtils.readText(driver, queueAssetRecordsInfo).split("of");
			int queueRecordsCount = Integer.parseInt(queueInfo[1].replaceAll("[^0-9]", ""));
			Reporter.log("Queue records count before sending asset to External Calibration: "+queueRecordsCount, true);
			if (queueRecordsCount != 0) {
				ActionUtils.ajaxJsClick(driver, By.xpath("(//input[@name='QueueCheckBox'])[1]"));
				ActionUtils.ajaxJsClick(driver, externalCalibrationBtn);
				ActionUtils.clickClearAndType(driver, supplierSearchBox, company);
				ActionUtils.ajaxJsClick(driver, By.xpath("//div[contains(text(),'"+company+"')]/..//button[1]"));
				ActionUtils.ajaxJsClick(driver, submitBtn);
				Assert.assertTrue(ActionUtils.getElement(driver, By.xpath("(//div[text()='"+company+"'])[2]")).isDisplayed(), "Supplier company not added");
				Reporter.log("Supplier company added", true);
				ActionUtils.ajaxJsClick(driver, changeCompanyBtn);
				try {
					Assert.assertTrue(driver.findElement(By.xpath("(//div[text()='"+company+"'])[2]")).isDisplayed());
					Assert.fail("Company not changed");
				} catch (NoSuchElementException e) {
					Reporter.log("Company changed", true);
				}	
			} else {
				Reporter.log("No records found in the Queue", true);
			}
		} else {
			Reporter.log("No assets available in calibration", true);
		}
	}

	public void verify_Internal_calibration() throws Exception {
		ActionUtils.ajaxJsClick(driver, inCalibrationCount);
		int tabCount = Integer.parseInt(ActionUtils.readText(driver, inCalibrationCount).trim());
		Reporter.log("Tab count: "+tabCount, true);
		if (tabCount != 0) {
			String[] queueInfo = ActionUtils.readText(driver, queueAssetRecordsInfo).split("of");
			int queueRecordsCount = Integer.parseInt(queueInfo[1].replaceAll("[^0-9]", ""));
			Reporter.log("Queue records count before sending asset to External Calibration: "+queueRecordsCount, true);
			if (queueRecordsCount != 0) {
				ActionUtils.ajaxJsClick(driver, By.xpath("(//input[@name='QueueCheckBox'])[1]"));
				ActionUtils.ajaxJsClick(driver, By.xpath("(//button[text()='Calibrate'])[1]"));
				Thread.sleep(1000);
				ActionUtils.ajaxCheckbox_Checking(driver, onlyReferenceEquipementCheckBox);
				ActionUtils.ajaxCheckbox_Checking(driver, onlyCalibratedEquipementCheckBox);
				ActionUtils.ajaxJsClick(driver, By.xpath("(//div[contains(@id,'AssetsBox')]//h4)[1]"));
				ActionUtils.ajaxClick(driver, By.xpath("(//div[contains(@id,'AssetsBox')]//h4)[1]//ancestor::div[@class='panel panel-default']//img[1]"));
				ActionUtils.ajaxJsClick(driver, nextStepBtn);
				
				Thread.sleep(5000);

			} else {
				Reporter.log("No records found in the Queue", true);
			}
		} else {
			Reporter.log("No assets available in calibration", true);
		}

	}

	public void verify_Remove_allocated_asset() throws Exception {
		ActionUtils.ajaxJsClick(driver, inCalibrationCount);
		int tabCount = Integer.parseInt(ActionUtils.readText(driver, inCalibrationCount).trim());
		Reporter.log("Tab count: "+tabCount, true);
		if (tabCount != 0) {
			String[] queueInfo = ActionUtils.readText(driver, queueAssetRecordsInfo).split("of");
			int queueRecordsCount = Integer.parseInt(queueInfo[1].replaceAll("[^0-9]", ""));
			Reporter.log("Queue records count before sending asset to External Calibration: "+queueRecordsCount, true);
			if (queueRecordsCount != 0) {
				ActionUtils.ajaxJsClick(driver, By.xpath("(//input[@name='QueueCheckBox'])[1]"));
				ActionUtils.ajaxJsClick(driver, By.xpath("(//button[text()='Calibrate'])[1]"));
				Thread.sleep(1000);
				ActionUtils.ajaxCheckbox_Checking(driver, onlyReferenceEquipementCheckBox);
				ActionUtils.ajaxCheckbox_Checking(driver, onlyCalibratedEquipementCheckBox);
				String tool = ActionUtils.readText(driver, By.xpath("(//div[contains(@id,'AssetsBox')]//h4)[1]"));
				Reporter.log("Selected tool: "+tool, true);
				ActionUtils.ajaxJsClick(driver, By.xpath("(//div[contains(@id,'AssetsBox')]//h4)[1]"));
				Thread.sleep(1000);
				String assetSelected = ActionUtils.readText(driver, By.xpath("(//div[contains(@id,'AssetsBox')]//h4)[1]//ancestor::div[@class='panel panel-default']//span"));
				Reporter.log("Selected asset: "+assetSelected, true);
				ActionUtils.ajaxClick(driver, By.xpath("(//div[contains(@id,'AssetsBox')]//h4)[1]//ancestor::div[@class='panel panel-default']//img[1]"));
				ActionUtils.ajaxJsClick(driver, By.xpath("//div[contains(@id,'AddAssete')]//h4[contains(.,'"+tool+"')]"));
				Thread.sleep(1000);
				String assetReflected = ActionUtils.readText(driver, By.xpath("//div[contains(@id,'AddAssete')]//h4[contains(.,'"+tool+"')]//ancestor::div[@class='panel panel-default']//span[contains(.,'"+assetSelected+"')]"));
				Assert.assertEquals(assetReflected, assetSelected, "Asset not added to allocated list");
				Reporter.log("Asset added to allocated list", true);
				ActionUtils.ajaxJsClick(driver, By.xpath("//div[contains(@id,'AddAssete')]//h4[contains(.,'"+tool+"')]//ancestor::div[@class='panel panel-default']//span[contains(.,'"+assetSelected+"')]/..//img"));
				try {
					Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@id,'AddAssete')]//h4[contains(.,'"+tool+"')]//ancestor::div[@class='panel panel-default']//span[contains(.,'"+assetSelected+"')]")).isDisplayed());
					Assert.fail("Allocated asset not removed");
				} catch (NoSuchElementException e) {
					Reporter.log("Allocated asset removed", true);
				}
			} else {
				Reporter.log("No records found in the Queue", true);
			}
		} else {
			Reporter.log("No assets available in calibration", true);
		}
	}

	public void verify_Book_in_asset_for_external_calibration(String filePath) throws Exception {
		ActionUtils.ajaxJsClick(driver, inCalibrationCount);
		int tabCount = Integer.parseInt(ActionUtils.readText(driver, inCalibrationCount).trim());
		Reporter.log("Tab count: "+tabCount, true);
		if (tabCount != 0) {
			String[] queueInfo = ActionUtils.readText(driver, externalAssetRecordsInfo).split("of");
			int queueRecordsCount = Integer.parseInt(queueInfo[1].replaceAll("[^0-9]", ""));
			Reporter.log("External records count: "+queueRecordsCount, true);
			if (queueRecordsCount != 0) {
				String assertOrderNo = ActionUtils.readText(driver, By.xpath("//*[@id='ExternalAssetsTable_wrapper']//tr[1]/td[1]"));
				ActionUtils.ajaxJsClick(driver, By.xpath("(//button[contains(@name,'BookInBtn')])[1]"));
				ActionUtils.ajaxJsClick(driver, checkBox_BookIn);
				ActionUtils.ajaxUploadFile(driver, uploadBtn_BookInPage, filePath);
				ActionUtils.ajaxJsClick(driver, bookInBtn);	





			} else {
				Reporter.log("No records found in the Queue", true);
			}
		} else {
			Reporter.log("No assets available in calibration", true);
		}
	}

	public void verify_Book_in_without_uploading_file_and_verify_error_message() throws Exception {
		ActionUtils.ajaxJsClick(driver, inCalibrationCount);
		int tabCount = Integer.parseInt(ActionUtils.readText(driver, inCalibrationCount).trim());
		Reporter.log("Tab count: "+tabCount, true);
		if (tabCount != 0) {
			String[] queueInfo = ActionUtils.readText(driver, externalAssetRecordsInfo).split("of");
			int queueRecordsCount = Integer.parseInt(queueInfo[1].replaceAll("[^0-9]", ""));
			Reporter.log("External records count: "+queueRecordsCount, true);
			if (queueRecordsCount != 0) {
				ActionUtils.ajaxJsClick(driver, By.xpath("(//button[contains(@name,'BookInBtn')])[1]"));
				ActionUtils.ajaxJsClick(driver, checkBox_BookIn);
				ActionUtils.ajaxJsClick(driver, bookInBtn);	
				Assert.assertTrue(ActionUtils.getElement(driver, bookInFileUploadErrorMsg).isDisplayed(), "No error msg displayed on book-in without file");
				Reporter.log("Error msg displayed on book-in without file", true);
			} else {
				Reporter.log("No records found in the Queue", true);
			}
		} else {
			Reporter.log("No assets available in calibration", true);
		}
	}

	public void verify_Requests_tab_records() {
		ActionUtils.ajaxJsClick(driver, requestsCount);
		int tabCount = Integer.parseInt(ActionUtils.readText(driver, requestsCount).trim());
		Reporter.log("Tab count: "+tabCount, true);
		if (tabCount != 0) {
			String[] info = ActionUtils.readText(driver, requestsRecordsInfo).split("of");
			int count = Integer.parseInt(info[1].replaceAll("[^0-9]", ""));
			Reporter.log("Queue records count: "+count, true);
			Assert.assertEquals(count, tabCount, "Requests tab count and resultant records count not matched");
			Reporter.log("Requests tab count and resultant records count matched", true);
		} else {
			Reporter.log("No records found under requests tab", true);
		}
	}

	public void verify_Issue_recall_option_for_requests_tab_assets() throws Exception {
		ActionUtils.ajaxJsClick(driver, requestsCount);
		int tabCount = Integer.parseInt(ActionUtils.readText(driver, requestsCount).trim());
		Reporter.log("Tab count: "+tabCount, true);
		if (tabCount != 0) {
			int n = Integer.parseInt(ActionUtils.readText(driver, lastPage_Requests));
			for (int i = 0; i < n; i++) {
				try {
					ActionUtils.ajaxCheckbox_Checking(driver, By.xpath("(//input[contains(@name,'RequestCheckBox')])[1]"));
					break;
				} catch (Exception e) {
					ActionUtils.ajaxJsClick(driver, nextBtn_Requests);
					Thread.sleep(1000);
				}
			}
			ActionUtils.click(driver, issueRecallBtn_Requests);
			try {
				ActionUtils.ajaxClick(driver, recallBtn);
				Assert.assertTrue(ActionUtils.getElement(driver, emailSendSeccessAlert).isDisplayed(), "Recall option is not functional");
				Reporter.log("Recall option is functional - 'Email sent successfully' to owner", true);
			} catch (Exception e) {
				Reporter.log("No assets to recall", true);
			}
		} else {
			Reporter.log("No records found under out of calibration tab", true);
		}
	}

	public void verify_Send_requested_asset_for_calibration() throws Exception {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsClick(driver, requestsCount);
		int reqTabCount = Integer.parseInt(ActionUtils.readText(driver, requestsCount).trim());
		Reporter.log("Request tab count before sending asset to calibration: "+reqTabCount, true);
		int calibTabCount = Integer.parseInt(ActionUtils.readText(driver, inCalibrationCount).trim());
		Reporter.log("Calibration tab count before sending asset to calibration: "+calibTabCount, true);
		if (reqTabCount != 0) {
			String id=null;
			int n = Integer.parseInt(ActionUtils.readText(driver, lastPage_Requests));
			for (int i = 0; i < n; i++) {
				try {
					id = driver.findElement(By.xpath("(//input[@name='RequestCheckBox'])[1]/../..//td[2]")).getText();
					ActionUtils.ajaxCheckbox_Checking(driver, By.xpath("(//input[contains(@name,'RequestCheckBox')])[1]"));
					break;
				} catch (Exception e) {
					ActionUtils.ajaxJsClick(driver, nextBtn_Requests);
					Thread.sleep(1000);
				}
			}
			ActionUtils.ajaxJsClick(driver, calibrationBtn_Requests);
			ActionUtils.ajaxClick(driver, targetDateBtn);
			List<WebElement> dateList = driver.findElements(By.xpath("//td[@class='day']"));
			for (WebElement ele : dateList) {
				if (ele.getText().contains("20")) {
					ActionUtils.jsClick(driver, ele);
					break;
				}
			}
			ActionUtils.ajaxClick(driver, sendBtn);
			int calibTabCount2 = Integer.parseInt(ActionUtils.readText(driver, inCalibrationCount).trim());
			Reporter.log("Calibration tab count after sending asset to calibration: "+calibTabCount2, true);
			a.assertTrue(calibTabCount2 > calibTabCount, "Requested asset not sent to calibration");
			Reporter.log("Requested asset sent to calibration", true);
			// Verify 'At calibration'
			String text = ActionUtils.readText(driver, By.xpath("//td[text()='"+id+"']/..//td[1]/span"));
			a.assertEquals(text, "At Calibration", "Checkbox not changed to 'At Calibration'");
			Reporter.log("Checkbox changed to 'At Calibration'", true);
		} else {
			Reporter.log("No records found under requests tab", true);
		}
		a.assertAll();
	}

	public void verify_Send_asset_to_calibration_without_selecting_asset_and_verify_error_message() {
		ActionUtils.ajaxJsClick(driver, outOfCalibrationCount);
		int outTabCount = Integer.parseInt(ActionUtils.readText(driver, outOfCalibrationCount).trim());
		Reporter.log("Request tab count before sending asset to calibration: "+outTabCount, true);
		if (outTabCount != 0) {
			ActionUtils.jsClick(driver, calibrationBtn_OutOfCalibration);
			Assert.assertTrue(ActionUtils.getElement(driver, pleaseSelectAssetErrorMsg).isDisplayed(), "No error message displayed");
			Reporter.log("Error message diplayed", true);
		} else {
			Reporter.log("No records found under out of calibration tab", true);
		}
	}

	public void verify_Upcoming_calibrations_tab_records() {
		ActionUtils.ajaxJsClick(driver, upcomingCalibrationsCount);
		int tabCount = Integer.parseInt(ActionUtils.readText(driver, upcomingCalibrationsCount).trim());
		Reporter.log("Tab count: "+tabCount, true);
		if (tabCount != 0) {
			String[] info = ActionUtils.readText(driver, upcomingCalibRecordsInfo).split("of");
			int count = Integer.parseInt(info[1].replaceAll("[^0-9]", ""));
			Reporter.log("Upcoming calibrations tab records count: "+count, true);
			Assert.assertEquals(count, tabCount, "Upcoming calibrations tab count and resultant records count not matched");
			Reporter.log("Upcoming calibrations tab count and resultant records count matched", true);
		} else {
			Reporter.log("No records found under requests tab", true);
		}
	}

	public void verify_Issue_recall_option_for_upcoming_calibrations_tab_assets() throws Exception {
		ActionUtils.ajaxJsClick(driver, upcomingCalibrationsCount);
		int tabCount = Integer.parseInt(ActionUtils.readText(driver, upcomingCalibrationsCount).trim());
		Reporter.log("Tab count: "+tabCount, true);
		if (tabCount != 0) {
			int n = Integer.parseInt(ActionUtils.readText(driver, lastPage_UpcomingCalibration));
			for (int i = 0; i < n; i++) {
				try {
					ActionUtils.ajaxCheckbox_Checking(driver, By.xpath("(//input[contains(@name,'UpCCheckBox')])[1]"));
					break;
				} catch (Exception e) {
					ActionUtils.ajaxJsClick(driver, nextBtn_UpcomingCalibration);
					Thread.sleep(1000);
				}
			}
			ActionUtils.click(driver, issueRecallBtn_UpcomingCalibrations);
			try {
				ActionUtils.ajaxClick(driver, recallBtn);
				Assert.assertTrue(ActionUtils.getElement(driver, emailSendSeccessAlert).isDisplayed(), "Recall option is not functional");
				Reporter.log("Recall option is functional - 'Email sent successfully' to owner", true);
			} catch (Exception e) {
				Reporter.log("No assets to recall", true);
			}
		} else {
			Reporter.log("No records found under out of calibration tab", true);
		}
	}

	public void verify_Send_upcoming_calibration_asset_to_calibration() {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsClick(driver, upcomingCalibrationsCount);
		int upCalTabCount = Integer.parseInt(ActionUtils.readText(driver, upcomingCalibrationsCount).trim());
		Reporter.log("Upcoming calibration tab count before sending asset to calibration: "+upCalTabCount, true);
		int calibTabCount = Integer.parseInt(ActionUtils.readText(driver, inCalibrationCount).trim());
		Reporter.log("Calibration tab count before sending asset to calibration: "+calibTabCount, true);
		if (upCalTabCount != 0) {
			String id;
			try {
				id = driver.findElement(By.xpath("(//input[@name='UpCCheckBox'])[1]/../..//td[2]")).getText();
				//id = ActionUtils.readText(driver, By.xpath("(//input[@name='UpCCheckBox'])[1]/../..//td[2]"));
				ActionUtils.checkbox_Checking(driver, ActionUtils.getElements(driver, By.xpath("//input[@name='UpCCheckBox']")).get(0));
				ActionUtils.ajaxJsClick(driver, calibrationBtn_UpcomingCalibrations);
				ActionUtils.ajaxClick(driver, targetDateBtn);
				List<WebElement> dateList = driver.findElements(By.xpath("//td[@class='day']"));
				for (WebElement ele : dateList) {
					if (ele.getText().contains("20")) {
						ActionUtils.jsClick(driver, ele);
						break;
					}
				}
				ActionUtils.ajaxClick(driver, sendBtn);
				int calibTabCount2 = Integer.parseInt(ActionUtils.readText(driver, inCalibrationCount).trim());
				Reporter.log("Calibration tab count after sending asset to calibration: "+calibTabCount2, true);
				a.assertTrue(calibTabCount2 > calibTabCount, "Upcoming calibration asset not sent to calibration");
				Reporter.log("Upcoming calibration asset sent to calibration", true);
				// Verify 'At calibration'
				String text = ActionUtils.readText(driver, By.xpath("//td[text()='"+id+"']/..//td[1]/span"));
				a.assertEquals(text, "At Calibration", "Checkbox not changed to 'At Calibration'");
				Reporter.log("Checkbox changed to 'At Calibration'", true);
			} catch (NoSuchElementException e) {
				Reporter.log("No records available to send to calibration", true);
			}
		} else {
			Reporter.log("No records found under upcoming calibration tab", true);
		}
		a.assertAll();
	}



















}












