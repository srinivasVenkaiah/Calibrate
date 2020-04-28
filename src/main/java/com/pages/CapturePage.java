/**
 * @author UmaMaheswararao
 */

package com.pages;

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

public class CapturePage extends BasePage {

	// Objects Repository(OR):........................................................................
	// Page verification
	@FindBy(xpath="//a[contains(text(),'Capture')]")
	WebElement captureLink;

	// Create Usage Log
	By addNewLogBtn = By.cssSelector("span#addLog>a");
	By logSearchBox = By.xpath("//input[contains(@aria-label,'Search for option')]");
	By logBtn = By.xpath("//button[text()[normalize-space()='LOG']]");
	By searchBox = By.cssSelector("input#SereachTxt");
	By searchBtn = By.xpath("//a[@title='Search']");
	By pleaseCompleteJobInfoMsg = By.xpath("//div[text()='please complete job info']");
	By jobNumberTextBox = By.xpath("(//table[@id='jobListTable']//input)[1]");
	By timeUsedFrom = By.xpath("(//button[contains(@title,'Change date and time')])[1]");
	By timeUsedTo = By.xpath("(//button[contains(@title,'Change date and time')])[2]");
	By fromCurrentDate = By.xpath("(//span[contains(@class,'flatpickr-day today')])[1]");
	By toCurrentDate = By.xpath("(//span[contains(@class,'flatpickr-day today')])[2]");
	By toMinutesTextBox = By.xpath("(//input[contains(@aria-label,'Minute')])[2]");
	By quantityTextBox = By.xpath("(//input[@class='form-control'])[4]");
	By partNoTextBox = By.xpath("(//input[@class='form-control'])[5]");
	By issueNoTextBox = By.xpath("(//input[@class='form-control'])[6]");
	By ncrNoTextBox = By.xpath("//input[contains(@name,'NCRNo')]");
	By ncrQuantity = By.xpath("//input[contains(@name,'NCRQty')]");
	By addLogBtn = By.xpath("//a[@title='add new Log'][contains(.,'Add')]");
	By c1_usesLeft = By.xpath("(//div[@class='display']//span)[1]");
	By c2_usesLeft = By.xpath("(//div[@class='display']//span)[2]");
	By c1_usedPercent = By.xpath("(//div[@class='status-number']//span)[1]");
	By c2_usedPercent = By.xpath("(//div[@class='status-number']//span)[2]");

	// Log mandatory fields
	@FindBy(xpath="//div[contains(@class,'alert-danger alert-dismissible')][contains(.,'Job No. can‘t be blank')]")	WebElement jobNoErrMsg;
	@FindBy(xpath="//div[contains(@class,'alert-danger alert-dismissible')][contains(.,'Time can‘t be blank')]")	WebElement timeUsedErrMsg;
	@FindBy(xpath="//div[contains(@class,'alert-danger alert-dismissible')][contains(.,'Quantity can‘t be blank')]")	WebElement quantityErrMsg;
	@FindBy(xpath="//i[contains(@class,'icon-close')]")	WebElement removeJobBtn;
	

	// Initializing the Page Objects:................................................................
	public CapturePage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................

	public void verify_CapturePage() {
		Assert.assertTrue(captureLink.isDisplayed(), "Unable to Navigate Capture Page");
	}

	public void verify_Create_usage_log_without_job_number_and_verify_error_msg(String asset) throws Exception {
		ActionUtils.ajaxJsClick(driver, addNewLogBtn);
		ActionUtils.clickClearAndType(driver, logSearchBox, asset);
		ActionUtils.ajaxClick(driver, By.xpath("//li[@role='option'][contains(.,'"+asset+"')]"));
		ActionUtils.ajaxJsClick(driver, logBtn);
		Assert.assertTrue(driver.findElement(pleaseCompleteJobInfoMsg).isDisplayed(), "No error msg on creating log without job number");
		Reporter.log("Error msg displayed on creating log without job number", true);
	}

	public void verify_Create_usage_log(String asset, String value, String unit, String jobNo, String toMin, String qty) throws Exception {
		ActionUtils.ajaxJsClick(driver, AssetsPage.assetsTab);
		ActionUtils.jsType(driver, AssetsPage.assetsSearchBox, asset);
		ActionUtils.ajaxJsClick(driver, AssetsPage.assetsSearchBtn);
		ActionUtils.ajaxJsClick(driver, By.xpath("//td[@class=' table-td'][contains(.,'"+asset+"')]//following::a[@name='editAssetBtn']"));
		ActionUtils.ajaxJsClick(driver, AssetsPage.scheduleTab);
		// Control 1
		Reporter.log("===== Control 1 Settings =====", true);
		// Timer - Minutes - Capture
		try {
			ActionUtils.ajaxJsClick(driver, AssetsPage.control1);
			ActionUtils.ajaxJsClick(driver, AssetsPage.c1_Timer);
		} catch (Exception e) {
			ActionUtils.ajaxJsClick(driver, AssetsPage.control1);
			ActionUtils.ajaxJsClick(driver, AssetsPage.c1_Timer);
		}
		ActionUtils.ajaxJsClick(driver, AssetsPage.control1);
		ActionUtils.ajaxJsClick(driver, AssetsPage.c1_Minutes);
		Thread.sleep(1000);
		ActionUtils.clickClearAndType(driver, AssetsPage.c1_ValueField, value);
		ActionUtils.ajaxJsClick(driver, AssetsPage.c1_ApplyBtn);
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'TIMER')])[1]//following::span[contains(.,'"+value+"   MINUTES')]")).isDisplayed(), "Timer-Minutes-Location control not set");
		Reporter.log("Timer-Minutes-Location control set", true);
		// Control 2
		ActionUtils.ajaxJsClick(driver, AssetsPage.control2);
		Reporter.log("===== Control 2 Settings =====", true);
		// Counter
		ActionUtils.ajaxJsClick(driver, AssetsPage.c2_Counter);
		ActionUtils.clickClearAndType(driver, AssetsPage.c2_UnitField, unit+Keys.ENTER);
		ActionUtils.clickClearAndType(driver, AssetsPage.c2_ValueField, value);
		ActionUtils.ajaxJsClick(driver, AssetsPage.c2_ApplyBtn);
		Assert.assertTrue(driver.findElement(By.xpath("(//span[contains(.,'COUNTER')])[1]//following::span[contains(.,'"+value+"')][1]")).isDisplayed(), "Counter-Unit-Value control not set");
		Reporter.log("Counter-Unit-Value control set", true);
		// Capture the asset
		ActionUtils.ajaxJsClick(driver, AssetsPage.Capture);
		ActionUtils.ajaxJsClick(driver, addNewLogBtn);
		Thread.sleep(1000);
		ActionUtils.clickClearAndType(driver, logSearchBox, asset);
		ActionUtils.ajaxClick(driver, By.xpath("//li[@role='option'][contains(.,'"+asset+"')]"));
		ActionUtils.clickClearAndType(driver, jobNumberTextBox, jobNo);
		ActionUtils.ajaxClick(driver, timeUsedFrom);
		ActionUtils.ajaxClick(driver, fromCurrentDate);
		ActionUtils.ajaxClick(driver, timeUsedFrom);
		ActionUtils.ajaxClick(driver, timeUsedTo);
		ActionUtils.ajaxClick(driver, toCurrentDate);
		ActionUtils.clearAndType(driver, toMinutesTextBox, toMin);
		ActionUtils.ajaxClick(driver, timeUsedTo);
		ActionUtils.ajaxType(driver, quantityTextBox, qty);
		ActionUtils.ajaxJsClick(driver, addLogBtn);
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()[normalize-space()='"+jobNo+"']]")).isDisplayed(), "Log not added");
		Reporter.log("Log added", true);
		ActionUtils.ajaxJsClick(driver, logBtn);
		ActionUtils.jsType(driver, searchBox, asset);
		ActionUtils.ajaxJsClick(driver, searchBtn);
		Assert.assertTrue(driver.findElement(By.xpath("//td[contains(.,'"+asset+"')]/..//span[text()='"+qty+"']")).isDisplayed(), "Usage log not created");
		Reporter.log("Usage log created", true);
	}

	public void capture_asset_greater_than_70_percent_and_lessthan_100_percent_and_verify_the_asset_presence_in_Upcoming_calibrations_list(
			String asset, String percent, String jobNo, String toMin) throws Exception {
		// Calibration
		ActionUtils.ajaxJsClick(driver, AssetsPage.Calibration);
		int tabCountBefore = Integer.parseInt(ActionUtils.readText(driver, CalibrationPage.upcomingCalibrationsCount).trim());
		Reporter.log("Upcoming calibrations count before capture: "+tabCountBefore, true);
		// Capture
		ActionUtils.ajaxJsClick(driver, AssetsPage.Capture);
		ActionUtils.ajaxJsClick(driver, addNewLogBtn);
		Thread.sleep(1000);
		ActionUtils.clickClearAndType(driver, logSearchBox, asset);
		ActionUtils.ajaxClick(driver, By.xpath("//li[@role='option'][contains(.,'"+asset+"')]"));

		int c2Usesleft = Integer.parseInt(ActionUtils.readText(driver, c2_usesLeft));
		int c2UsedPercent = Integer.parseInt(ActionUtils.readText(driver, c2_usedPercent).replaceAll("%", ""));
		int c1UsedPercent = Integer.parseInt(ActionUtils.readText(driver, c1_usedPercent).replaceAll("%", ""));
		if (c2UsedPercent < 70 && c1UsedPercent < 70) {
			int total = ((100*c2Usesleft)/(100-c2UsedPercent));
			int used = (total*c2UsedPercent)/100;
			int givenPercent = Integer.parseInt(percent.replace(".0", ""));
			long qty = ((total*givenPercent)/100)-used; // Quantity >75 & <100 %
			Reporter.log("Quantity to be given: "+qty, true);

			ActionUtils.clickClearAndType(driver, jobNumberTextBox, jobNo);
			ActionUtils.ajaxClick(driver, timeUsedFrom);
			ActionUtils.ajaxClick(driver, fromCurrentDate);
			ActionUtils.ajaxClick(driver, timeUsedFrom);
			ActionUtils.ajaxClick(driver, timeUsedTo);
			ActionUtils.ajaxClick(driver, toCurrentDate);
			ActionUtils.clearAndType(driver, toMinutesTextBox, toMin);
			ActionUtils.ajaxClick(driver, timeUsedTo);
			ActionUtils.ajaxType(driver, quantityTextBox, String.valueOf(qty));
			ActionUtils.ajaxJsClick(driver, addLogBtn);
			Assert.assertTrue(driver.findElement(By.xpath("//td[text()[normalize-space()='"+jobNo+"']]")).isDisplayed(), "Log not added");
			Reporter.log("Log added", true);
			ActionUtils.ajaxJsClick(driver, logBtn);
			// Calibration
			ActionUtils.ajaxJsClick(driver, AssetsPage.Calibration);
			int tabCountAfter = Integer.parseInt(ActionUtils.readText(driver, CalibrationPage.upcomingCalibrationsCount).trim());
			Reporter.log("Upcoming calibrations count after capture: "+tabCountAfter, true);
			Assert.assertTrue(tabCountAfter > tabCountBefore, "Asset not moved to Upcoming calibrations even after >70% to <100% of capture");
			Reporter.log("Asset moved to Upcoming calibrations after >70% to <100% of capture", true);
		} else {
			Reporter.log("Asset already >70% captured", true);
		}
	}

	public void capture_asset_100_percent_and_verify_the_asset_presence_in_Out_of_calibration_list(
			String asset, String jobNo, String toMin) throws Exception {
		// Calibration
		ActionUtils.ajaxJsClick(driver, AssetsPage.Calibration);
		int tabCountBefore = Integer.parseInt(ActionUtils.readText(driver, CalibrationPage.outOfCalibrationCount).trim());
		Reporter.log("Out of calibration count before capture: "+tabCountBefore, true);
		// Capture
		ActionUtils.ajaxJsClick(driver, AssetsPage.Capture);
		ActionUtils.ajaxJsClick(driver, addNewLogBtn);
		Thread.sleep(1000);
		ActionUtils.clickClearAndType(driver, logSearchBox, asset);
		ActionUtils.ajaxClick(driver, By.xpath("//li[@role='option'][contains(.,'"+asset+"')]"));

		int c2Usesleft = Integer.parseInt(ActionUtils.readText(driver, c2_usesLeft));
		int c2UsedPercent = Integer.parseInt(ActionUtils.readText(driver, c2_usedPercent).replaceAll("%", ""));
		int c1UsedPercent = Integer.parseInt(ActionUtils.readText(driver, c1_usedPercent).replaceAll("%", ""));
		if (c2UsedPercent != 100 && c1UsedPercent != 100) {
			long qty = c2Usesleft; // Quantity = 100%
			Reporter.log("Quantity to be given: "+qty, true);

			ActionUtils.clickClearAndType(driver, jobNumberTextBox, jobNo);
			ActionUtils.ajaxClick(driver, timeUsedFrom);
			ActionUtils.ajaxClick(driver, fromCurrentDate);
			ActionUtils.ajaxClick(driver, timeUsedFrom);
			ActionUtils.ajaxClick(driver, timeUsedTo);
			ActionUtils.ajaxClick(driver, toCurrentDate);
			ActionUtils.clearAndType(driver, toMinutesTextBox, toMin);
			ActionUtils.ajaxClick(driver, timeUsedTo);
			ActionUtils.ajaxType(driver, quantityTextBox, String.valueOf(qty));
			ActionUtils.ajaxJsClick(driver, addLogBtn);
			Assert.assertTrue(driver.findElement(By.xpath("//td[text()[normalize-space()='"+jobNo+"']]")).isDisplayed(), "Log not added");
			Reporter.log("Log added", true);
			ActionUtils.ajaxJsClick(driver, logBtn);
			// Calibration
			ActionUtils.ajaxJsClick(driver, AssetsPage.Calibration);
			int tabCountAfter = Integer.parseInt(ActionUtils.readText(driver, CalibrationPage.outOfCalibrationCount).trim());
			Reporter.log("Out of calibration count after capture: "+tabCountAfter, true);
			Assert.assertTrue(tabCountAfter > tabCountBefore, "Asset not moved to Out of calibration even after 100% of capture");
			Reporter.log("Asset moved to Out of calibration after 100% capture", true);
		} else {
			Reporter.log("Asset already 100% captured", true);
		}
	}

	public void verify_Add_multiple_jobs(String asset, String jobNo1, String qty1, String jobNo2, String qty2) throws Exception {
		ActionUtils.ajaxJsClick(driver, addNewLogBtn);
		Thread.sleep(1000);
		ActionUtils.clickClearAndType(driver, logSearchBox, asset);
		ActionUtils.ajaxClick(driver, By.xpath("//li[@role='option'][contains(.,'"+asset+"')]"));
		// Job1
		ActionUtils.clickClearAndType(driver, jobNumberTextBox, jobNo1);
		ActionUtils.ajaxClick(driver, timeUsedFrom);
		ActionUtils.ajaxClick(driver, fromCurrentDate);
		ActionUtils.ajaxClick(driver, timeUsedFrom);
		ActionUtils.ajaxClick(driver, timeUsedTo);
		ActionUtils.ajaxClick(driver, toCurrentDate);
		ActionUtils.ajaxClick(driver, timeUsedTo);
		ActionUtils.ajaxType(driver, quantityTextBox, qty1);
		ActionUtils.ajaxJsClick(driver, addLogBtn);
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()[normalize-space()='"+jobNo1+"']]")).isDisplayed(), "Job1 Log not added");
		Reporter.log("Job1 Log added", true);
		// Job2
		ActionUtils.clickClearAndType(driver, jobNumberTextBox, jobNo2);
		ActionUtils.ajaxClick(driver, timeUsedFrom);
		ActionUtils.ajaxClick(driver, fromCurrentDate);
		ActionUtils.ajaxClick(driver, timeUsedFrom);
		ActionUtils.ajaxClick(driver, timeUsedTo);
		ActionUtils.ajaxClick(driver, toCurrentDate);
		ActionUtils.ajaxClick(driver, timeUsedTo);
		ActionUtils.ajaxType(driver, quantityTextBox, qty2);
		ActionUtils.ajaxJsClick(driver, addLogBtn);
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()[normalize-space()='"+jobNo2+"']]")).isDisplayed(), "Job2 Log not added");
		Reporter.log("Job2 Log added", true);
	}

	public void verify_Mandatory_fields_in_asset_log_page(String asset, String jobNo) throws Exception {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsClick(driver, addNewLogBtn);
		Thread.sleep(1000);
		ActionUtils.clickClearAndType(driver, logSearchBox, asset);
		ActionUtils.ajaxClick(driver, By.xpath("//li[@role='option'][contains(.,'"+asset+"')]"));
		// Job number
		ActionUtils.ajaxJsClick(driver, addLogBtn);
		try {
			a.assertTrue(jobNoErrMsg.isDisplayed());
			Reporter.log("Error message displayed on creating job without job number", true);
		} catch (Exception e) {
			a.fail("No Error message displayed on creating job without job number");
		}
		ActionUtils.clickClearAndType(driver, jobNumberTextBox, jobNo);
		// Time used
		ActionUtils.ajaxJsClick(driver, addLogBtn);
		try {
			a.assertTrue(timeUsedErrMsg.isDisplayed());
			Reporter.log("Error message displayed on creating job without time used", true);
		} catch (Exception e) {
			a.fail("No Error message displayed on creating job without time used");
		}
		ActionUtils.ajaxClick(driver, timeUsedFrom);
		ActionUtils.ajaxClick(driver, fromCurrentDate);
		ActionUtils.ajaxClick(driver, timeUsedFrom);
		ActionUtils.ajaxClick(driver, timeUsedTo);
		ActionUtils.ajaxClick(driver, toCurrentDate);
		ActionUtils.ajaxClick(driver, timeUsedTo);
		// Quantity
		ActionUtils.ajaxJsClick(driver, addLogBtn);
		try {
			a.assertTrue(quantityErrMsg.isDisplayed());
			Reporter.log("Error message displayed on creating job without quantity", true);
		} catch (Exception e) {
			a.fail("No Error message displayed on creating job without quantity");
		}
		a.assertAll();
	}

	public void verify_Delete_job(String asset, String jobNo, String qty) throws Exception {
		ActionUtils.ajaxJsClick(driver, addNewLogBtn);
		Thread.sleep(1000);
		ActionUtils.clickClearAndType(driver, logSearchBox, asset);
		ActionUtils.ajaxClick(driver, By.xpath("//li[@role='option'][contains(.,'"+asset+"')]"));
		// Create Job
		ActionUtils.clickClearAndType(driver, jobNumberTextBox, jobNo);
		ActionUtils.ajaxClick(driver, timeUsedFrom);
		ActionUtils.ajaxClick(driver, fromCurrentDate);
		ActionUtils.ajaxClick(driver, timeUsedFrom);
		ActionUtils.ajaxClick(driver, timeUsedTo);
		ActionUtils.ajaxClick(driver, toCurrentDate);
		ActionUtils.ajaxClick(driver, timeUsedTo);
		ActionUtils.ajaxType(driver, quantityTextBox, qty);
		ActionUtils.ajaxJsClick(driver, addLogBtn);
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()[normalize-space()='"+jobNo+"']]")).isDisplayed(), "Job Log not added");
		Reporter.log("Job Log added", true);
		// Delete Job
		ActionUtils.ajaxJsClick(driver, removeJobBtn);
		try {
			Assert.assertTrue(driver.findElement(By.xpath("//td[text()[normalize-space()='"+jobNo+"']]")).isDisplayed());
			Reporter.log("Job Log not deleted", true);
		} catch (Exception e) {
			Reporter.log("Job Log deleted", true);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	









}















