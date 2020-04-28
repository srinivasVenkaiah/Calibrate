/**
 * @author UmaMaheswararao
 */

package com.pages;

import java.util.List;

import org.apache.poi.poifs.crypt.dsig.services.TSPTimeStampService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.BasePage;
import com.util.ActionUtils;


public class DashBoardPage extends BasePage {

	// Objects Repository(OR):........................................................................
	// DashBoard
	@FindBy(xpath="//a[contains(text(),'Dashboard')]")
	WebElement dashBoardLink;

	// Create Board
	By addTabBtn = By.xpath("//a[contains(@title,'Add Tab')]");
	By editDashboardBtn = By.xpath("//a[contains(@id,'btnEdit')]");
	By dropDownBtn = By.xpath("//span[contains(@id,'SelectedText')]");
	By newBoardOption = By.xpath("//li[contains(.,'New Board')]");
	By tabNameTextBox = By.xpath("//div[@class='modal-header'][contains(.,'Tab Name')]//following::input[1]");
	By saveTabBtn = By.xpath("//button[contains(@id,'btnSave')]");
	// Add Reports to tab
	By addReportBtn = By.xpath("(//button[@data-target='#reportSelection'])[1]");
	By searchReportTextBox = By.xpath("//input[contains(@placeholder,'Search')]");
	// Delete tab
	By deleteTabBtn = By.xpath("//a[contains(@id,'btnDelete')]");
	// Preview
	By previewBtn = By.xpath("//a[contains(@title,'Preview')]");
	// Share tab
	By shareBtn = By.xpath("//a[@title='Share'][contains(.,'Share')]");
	

	
	
	
	
	
	
	
	
	
	
	
	



	// Initializing the Page Objects:................................................................
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:......................................................................................
	public boolean verify_DashBoard(){
		return dashBoardLink.isDisplayed();
	}
	
	public void Create_New_Board_functionality(String tabName) throws Exception {
		try {
			ActionUtils.click(driver, editDashboardBtn);
			ActionUtils.jsClick(driver, dropDownBtn);
			ActionUtils.jsClick(driver, newBoardOption);
		} catch (Exception e) {
			ActionUtils.jsClick(driver, addTabBtn);
		}
		Thread.sleep(1000);
		ActionUtils.ajaxClickClearAndType(driver, tabNameTextBox, tabName);
		ActionUtils.ajaxClick(driver, saveTabBtn);
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='"+tabName+"']")).isDisplayed(), "New tab Not created");
		Reporter.log("New tab created successfully",true);
	}

	public void verify_Add_Reports_to_Board(String tabToSelect, String r1, String r2) throws Exception {
		ActionUtils.click(driver, editDashboardBtn);
		ActionUtils.jsClick(driver, dropDownBtn);
		ActionUtils.ajaxJsClick(driver, By.xpath("//li[contains(text(),'"+tabToSelect+"')]"));
		Thread.sleep(1000);
		// R1
		ActionUtils.ajaxJsClick(driver, addReportBtn);
		ActionUtils.ajaxJsClickClearAndType(driver, searchReportTextBox, r1);
		ActionUtils.ajaxClick(driver, By.xpath("//td[text()='"+r1+"']//following::button[1]"));
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(.,'"+r1+"')]")).isDisplayed(), "Report not added to Tab");
		Reporter.log("'"+r1+"' added to the Tab Successfully",true);
		// R2
		ActionUtils.click(driver, addReportBtn);
		Thread.sleep(1000);
		ActionUtils.ajaxClickClearAndType(driver, searchReportTextBox, r2);
		ActionUtils.ajaxClick(driver, By.xpath("//td[text()='"+r2+"']//following::button[1]"));
		Assert.assertTrue(driver.findElement(By.xpath("//span[contains(.,'"+r2+"')]")).isDisplayed(), "Report not added to Tab");
		Reporter.log("'"+r2+"' added to the Tab Successfully",true);
	}

	public void verify_Delete_selective_report_from_the_Board(String tabToSelect) throws Exception {
		Thread.sleep(1000);
		ActionUtils.jsClick(driver, dropDownBtn);
		ActionUtils.ajaxJsClick(driver, By.xpath("//li[text()='"+tabToSelect+"']"));
		ActionUtils.ajaxJsClick(driver, editDashboardBtn);
		Thread.sleep(1000);
		List<WebElement> deleteReportBtnList = driver.findElements(By.xpath("//img[@src='/Calibration/Content/images/toolbar/chacha.png']"));
		int count1 = deleteReportBtnList.size();
		ActionUtils.ajaxJsClick(driver, By.xpath("(//img[@src='/Calibration/Content/images/toolbar/chacha.png'])[1]"));
		List<WebElement> deleteReportBtnList2 = driver.findElements(By.xpath("//img[@src='/Calibration/Content/images/toolbar/chacha.png']"));
		int count2 = deleteReportBtnList2.size();
		Assert.assertTrue(count2 < count1, "Report not deleted");
		Reporter.log("Report deleted",true);
		ActionUtils.waitForAjax(driver);
	}

	public void verify_Delete_selective_Board(String tabName) throws Exception {
		ActionUtils.click(driver, editDashboardBtn);
		ActionUtils.jsClick(driver, dropDownBtn);
		ActionUtils.jsClick(driver, newBoardOption);
		ActionUtils.ajaxClickClearAndType(driver, tabNameTextBox, tabName);
		ActionUtils.ajaxClick(driver, saveTabBtn);
		ActionUtils.waitForElementVisibility(driver, By.xpath("//span[text()='"+tabName+"']"));
		ActionUtils.ajaxJsClick(driver, deleteTabBtn);
		ActionUtils.jsClick(driver, dropDownBtn);
		List<WebElement> tabDDList = driver.findElements(By.cssSelector("#tabmenuDetail>li"));
		for (WebElement ele : tabDDList) {
			if (ele.getText().equals(tabName)) {
				Assert.fail("Tab not deleted");
			}
		}
	}

	public void verify_Preview_Option() {
		ActionUtils.ajaxClick(driver, editDashboardBtn);
		Assert.assertTrue(ActionUtils.getElement(driver, previewBtn).isDisplayed(), "Preview Button not found");
		ActionUtils.ajaxJsClick(driver, previewBtn);
		Assert.assertTrue(ActionUtils.getElement(driver, editDashboardBtn).isDisplayed(), "Preview Option is not Functional");
	}

	public void verify_Share_Report_Option(String tabToSelect, String user) {
		ActionUtils.click(driver, editDashboardBtn);
		ActionUtils.jsClick(driver, dropDownBtn);
		ActionUtils.ajaxJsClick(driver, By.xpath("//li[contains(text(),'"+tabToSelect+"')]"));
		ActionUtils.click(driver, editDashboardBtn);
		ActionUtils.jsClick(driver, shareBtn);
		
		
		/*GenericLibrary.waitForElementVisibility(driver, dropDownBtn);
		JavascriptLibrary.javascriptClickElement(driver, dropDownBtn);
		WebElement tab = driver.findElement(By.xpath("//li[text()='"+tabToSelect+"']"));
		JavascriptLibrary.javascriptClickElement(driver, tab);
		GenericLibrary.waitForElementVisibility(driver, editDashBoardBtn);
		JavascriptLibrary.javascriptClickElement(driver, editDashBoardBtn);
		
		GenericLibrary.waitForElementVisibility(driver, shareBtn);
		JavascriptLibrary.javascriptClickElement(driver, shareBtn);
		GenericLibrary.waitForElementVisibility(driver, searchBox);
		searchBox.sendKeys(user);
		GenericLibrary.click(driver, searchBtn);
		GenericLibrary.waitForAjax(driver);
		try {
			JavascriptLibrary.javascriptClickElement(driver, addUserBtn);
			GenericLibrary.waitForAjax(driver);
			WebElement addedUser = driver.findElement(By.xpath("//li[contains(.,'"+user+"')]"));
			Assert.assertTrue(addedUser.isDisplayed(), "User not Added");
			Reporter.log("User Added Successfully", true);
		} catch (NoSuchElementException e) {
			Assert.assertTrue(noRecordsFound.isDisplayed(),"'No records found' not displayed");
			Reporter.log("User Not Found", true);
		} catch (AssertionError e) {
			Assert.assertTrue(false, "User not Added");
		}*/
	}

	
























}

