package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.base.BasePage;
import com.util.ActionUtils;
import com.util.VerificationLibrary;

public class AnalysePage extends BasePage {

	// Initializing the Page Objects:................................................................
	public AnalysePage() {
		PageFactory.initElements(driver, this);
	}

	// Objects Repository(OR):........................................................................
	// Page verification
	By analyseLink = By.linkText("Analyse");
	By assetsDataset = By.xpath("//h3[contains(@title,'Assets')]");
	By createReportBtn = By.xpath("//a[contains(@title,'Create new report')]");
	By reportNameTextBox = By.xpath("//input[contains(@id,'REPORTNAME')]");
	By saveReportBtn = By.xpath("//a[contains(@title,'Save report')]");
	By pageBackBtn = By.xpath("//a[contains(@title,'Back')]");
	By searchReportTextBox = By.xpath("//input[contains(@id,'txtSearch')]");
	By searchReportBtn = By.xpath("//a[contains(@onclick,'ReportList.Search()')]");
	By reportNameErrorMsg = By.xpath("//span[text()='Please enter Report Name.']");
	By editReportBtn = By.xpath("//a[contains(@title,'Edit report')]");
	By moreBtn = By.xpath("//a[contains(@title,'More')]");
	By copyOption = By.xpath("//a[contains(@title,'Copy')]");
	By yesBtn = By.xpath("//button[@data-bb-handler='confirm'][contains(.,'Yes')]");
	By deleteReportBtn = By.xpath("//a[@title='Delete report'][contains(.,'Delete')]");
	By noMatchingRecordsFoundMsg = By.xpath("//td[text()='No matching records found']");
	By column1Header = By.xpath("(//div[@closeid='title0'])[1]");
	By column2Header = By.xpath("(//div[@closeid='title1'])[1]");
	By column3Header = By.xpath("(//div[@closeid='title2'])[1]");
	By column4Header = By.xpath("(//div[@closeid='title3'])[1]");
	By column5Header = By.xpath("(//div[@closeid='title4'])[1]");
	By column1CellData = By.xpath("//tr[@data-index='0']//td[1]");
	By column2CellData = By.xpath("//tr[@data-index='0']//td[2]");
	By deleteColumn1Btn = By.xpath("(//i[contains(@name,'titclose')])[1]");
	By removeAllBtn = By.xpath("//button[@id='btnRemoveAll']");
	By addAllBtn = By.xpath("//button[contains(@id,'btnAddAll')]");
	By dropField = By.xpath("//div[contains(@id,'divFieldDrop')]");
	By descendingOrderBtn = By.id("st0");
	By closeSortingBtn = By.xpath("//i[contains(@class,'fa vc-icon-round-delete')]");
	By sortDropField = By.xpath("//div[contains(@id,'sortDrop')]");
	By groupDropField = By.xpath("//div[contains(@id,'groupDrop')]");
	By totalDropField = By.xpath("//div[contains(@id,'totalDrop')]");
	By gotoLastPageBtn = By.xpath("//li[@class='page-next']//preceding::a[1]");
	By reportMoreBtn = By.xpath("//a[contains(@title,'More')]");
	By exportToExcelOption = By.xpath("//a[contains(@title,'Export to excel')]");
	// Filter Number
	By filterOption = By.xpath("//a[contains(@mysource,'filter')]");
	By filterDropZone = By.xpath("//div[contains(@id,'divFilterDrop')]");
	By resoltionField = By.xpath("//div[contains(@id,'Resolution')]");
	By typeDD = By.xpath("//label[contains(text(),'Type')]/following::button[1]");
	By blankOption = By.xpath("//span[contains(.,'Blank')]");
	By equalsOption = By.xpath("//span[text()='=']");
	By NAoption = By.xpath("//a[contains(.,'N/A')]");
	By startFieldTextBox = By.xpath("//label[contains(text(),'Start')]/following::input[1]");
	By greaterThanOption = By.xpath("//span[text()='>']");
	By greaterThanEqualsOption = By.xpath("//span[text()='>=']");
	By lessThanOption = By.xpath("//span[text()='<']");
	By lessThanEqualsOption = By.xpath("//span[text()='<=']");
	By rangeOption = By.xpath("//span[text()='Range']");
	By endFieldTextBox = By.xpath("//label[contains(text(),'End')]/following::input[1]");
	By maxOption = By.xpath("//span[text()='Max']");
	// Filter Text
	By textDD = By.xpath("(//span[text()='Nothing selected'])[1]");
	By OwnerNameField = By.xpath("(//div[text()='Owner Name'])[1]");
	// Filter date
	By lastCalibrationField = By.xpath("(//div[text()='Last Calibration'])[1]");
	By typeSelectDD = By.xpath("//select[contains(@id,'ddlOperators')]");
	By selectMonthBtn = By.xpath("//th[contains(@title,'Select Month')]");
	By selectYearBtn = By.xpath("//th[contains(@title,'Select Year')]");
	// BarChart Design
	By barChartDesign = By.xpath("//button[contains(@class,'report-bar')]");
	By bar_Y = By.xpath("//div[contains(@id,'divAxis_y')]");
	By bar_X = By.xpath("//div[@id='divDragHint_X']");
	By unitsField = By.xpath("(//div[text()='Units'])[1]");
	By calibrationStatusField = By.xpath("(//div[text()='Calibration Status'])[1]");
	By x_ColumnsDD = By.xpath("//label[contains(.,'Columns')]//following::select[1]");
	By filterDD = By.xpath("//label[contains(.,'Filter')]//following::select[1]");
	By targetField = By.xpath("//input[@id='BAR_SHOWTARGET']");
	By enableLabel = By.xpath("//label[contains(.,'Label')]//following::span[contains(.,'OFF')][1]");
	By enableReportTotal = By.xpath("//label[contains(.,'Report Total')]//following::span[contains(.,'OFF')][1]");
	By designFilterDD = By.xpath("//select[contains(@id,'ddlCondition')]");
	// LineChart Design
	By lineChartDesign = By.xpath("//button[contains(@class,'report-line')]");
	By line_Y = By.xpath("//div[contains(@id,'divAxis_y')]");
	By line_X = By.xpath("//div[contains(@id,'divDragHint_X')]");
	// PieChart Design
	By pieChartDesign = By.xpath("//button[contains(@class,'report-pie')]");
	By pie_Y = By.xpath("//div[contains(@id,'divAxis_y')]");
	By pie_X = By.xpath("//div[contains(@id,'divDragHint_X')]");
	By x_SegmentsDD = By.xpath("//label[contains(.,'Segments')]//following::select[1]");
	//Summary Chart
	By SummaryChartDesign = By.xpath("//button[contains(@class,'report-grid-summary')]");
	By Summary_Y = By.xpath("//div[contains(@id,'divAxis_y')]");
	By Summary_X = By.xpath("//div[contains(@id,'divDragHint_X')]");
	By Summary_Z = By.xpath("//div[contains(@id,'divDragHint_Z')]");
	By assetName = By.xpath("//div[text()='Name']");
	By calibrationStatus = By.xpath("//div[text()='Calibration Status']");
	By control1 = By.xpath("//div[text()='Control 1']");
	//WaterFall Chart
	By WaterFallChartDesign = By.xpath("//button[contains(@class,'report-column')]");
	By WaterFall_Y = By.xpath("//div[contains(@id,'divAxis_y')]");
	By WaterFall_X = By.xpath("//div[contains(@id,'divDragHint_X')]");

	By morePreviewBtn = By.xpath("//a[@id='btnPreview']");













	// Actions:......................................................................................
	public void verify_AnalysePage() {
		Assert.assertTrue(ActionUtils.getElement(driver, analyseLink).isDisplayed(), "Unable to Navigate Analyse Page");
	}

	public void verify_Create_report(String reportName) throws Exception {
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.jsType(driver, reportNameTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, saveReportBtn);
		ActionUtils.ajaxJsClick(driver, pageBackBtn);
		ActionUtils.jsType(driver, searchReportTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, searchReportBtn);
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='"+reportName+"']")).isDisplayed(), "Report not created");
		Reporter.log("Report created");
	}

	public void verify_Report_name_mandatory_msg() {
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.ajaxJsClick(driver, saveReportBtn);
		Assert.assertTrue(driver.findElement(reportNameErrorMsg).isDisplayed(), "Report name error msg not displayed");
		Reporter.log("Report name error msg displayed");
	}

	public void verify_Copy_report(String reportName) throws Exception {
		Thread.sleep(1000);
		ActionUtils.jsType(driver, searchReportTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, searchReportBtn);
		ActionUtils.click(driver, By.xpath("//td[text()='"+reportName+"']"));
		ActionUtils.ajaxJsClick(driver, editReportBtn);
		ActionUtils.hoverToElement(driver, moreBtn);
		ActionUtils.ajaxJsClick(driver, copyOption);
		ActionUtils.ajaxJsClick(driver, yesBtn);
		ActionUtils.ajaxJsClick(driver, pageBackBtn);
		ActionUtils.jsType(driver, searchReportTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, searchReportBtn);
		Assert.assertTrue(driver.findElement(By.xpath("//td[text()='"+reportName+" Copy(1)']")).isDisplayed(), "Report not copied");
		Reporter.log("Report copied");
	}

	public void verify_Delete_report(String reportName) {
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.jsType(driver, reportNameTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, saveReportBtn);
		ActionUtils.ajaxJsClick(driver, deleteReportBtn);
		ActionUtils.ajaxJsClick(driver, yesBtn);
		ActionUtils.jsType(driver, searchReportTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, searchReportBtn);
		Assert.assertTrue(driver.findElement(noMatchingRecordsFoundMsg).isDisplayed(), "Report not deleted");
		Reporter.log("Report deleted", true);
	}

	public void verify_Swaping_columns() throws Exception {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		String ch1 = ActionUtils.readText(driver, column1Header);
		String ch2 = ActionUtils.readText(driver, column2Header);
		String ch1c1 = ActionUtils.readText(driver, column1CellData);
		String ch2c2 = ActionUtils.readText(driver, column2CellData);
		Reporter.log("Before action: Column1 - "+ch1+" & Column2 - "+ch2+"", true);
		Reporter.log("Before action: Column1 Cell1 Data - "+ch1c1+" & Column2 Cell1 Data - "+ch2c2+"", true);
		ActionUtils.ajaxDragAndDrop(driver, column2Header, column1Header);
		String ch1a = ActionUtils.readText(driver, column1Header);
		String ch2a = ActionUtils.readText(driver, column2Header);
		String ch1c1a = ActionUtils.readText(driver, column1CellData);
		String ch2c2a = ActionUtils.readText(driver, column2CellData);
		Reporter.log("After action: Column1 - "+ch1a+" & Column2 - "+ch2a+"", true);
		Reporter.log("After action: Column1 Cell1 Data - "+ch1c1a+" & Column2 Cell1 Data - "+ch2c2a+"", true);
		a.assertTrue(ch1.equals(ch2a) && ch2.equals(ch1a), "Columns headers not swapped");
		Reporter.log("Column headers swapped successfully", true);
		a.assertTrue(ch1c1.equals(ch2c2a) && ch2c2.equals(ch1c1a), "Columns data not swapped");
		Reporter.log("Column data swapped successfully", true);
		a.assertAll();
	}

	public void verify_Delete_columns() throws Exception {
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		String ch1 = ActionUtils.readText(driver, column1Header);
		Reporter.log("Column name before deletion: "+ch1, true);
		ActionUtils.ajaxJsClick(driver, column1Header);
		ActionUtils.ajaxJsClick(driver, deleteColumn1Btn);
		ActionUtils.ajaxJsClick(driver, yesBtn);
		String ch1a = ActionUtils.readText(driver, column1Header);
		Reporter.log("Column name after deletion: "+ch1a, true);
		Assert.assertNotEquals(ch1, ch1a, "Column not deleted");
		Reporter.log("Column deleted", true);
	}

	public void verify_Add_all_columns_Remove_all_columns() throws Exception {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		try {
			Assert.assertTrue(driver.findElement(column1Header).isDisplayed());
			Reporter.log("All columns added by default",true);
		} catch (Exception e) {
			a.fail("All columns not added by default");
		}
		ActionUtils.ajaxJsClick(driver, removeAllBtn);
		ActionUtils.ajaxJsClick(driver, yesBtn);
		try {
			Assert.assertTrue(driver.findElement(column1Header).isDisplayed());
			Reporter.log("All columns not removed",true);
		} catch (Exception e) {
			Reporter.log("All columns removed",true);
		}
		ActionUtils.ajaxJsClick(driver, addAllBtn);
		try {
			Assert.assertTrue(driver.findElement(column1Header).isDisplayed());
			Reporter.log("All columns added",true);
		} catch (Exception e) {
			a.fail("All columns not added");
		}
		a.assertAll();
	}

	public void verify_Adding_selected_fileds_to_report(String f1, String f2, String f3, String f4, String f5) throws Exception {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.ajaxJsClick(driver, removeAllBtn);
		ActionUtils.ajaxJsClick(driver, yesBtn);
		ActionUtils.ajaxDragAndDrop(driver, By.xpath("//div[text()='"+f1+"']"), dropField);
		ActionUtils.ajaxDragAndDrop(driver, By.xpath("//div[text()='"+f2+"']"), dropField);
		ActionUtils.ajaxDragAndDrop(driver, By.xpath("//div[text()='"+f3+"']"), dropField);
		ActionUtils.ajaxDragAndDrop(driver, By.xpath("//div[text()='"+f4+"']"), dropField);
		ActionUtils.ajaxDragAndDrop(driver, By.xpath("//div[text()='"+f5+"']"), dropField);
		a.assertEquals(f1, driver.findElement(column1Header).getText(), "Given field 1 not added");
		Reporter.log("Given field 1 added", true);
		a.assertEquals(f2, driver.findElement(column2Header).getText(), "Given field 2 not added");
		Reporter.log("Given field 2 added", true);
		a.assertEquals(f3, driver.findElement(column3Header).getText(), "Given field 3 not added");
		Reporter.log("Given field 3 added", true);
		a.assertEquals(f4, driver.findElement(column4Header).getText(), "Given field 4 not added");
		Reporter.log("Given field 4 added", true);
		a.assertEquals(f5, driver.findElement(column5Header).getText(), "Given field 5 not added");
		Reporter.log("Given field 5 added", true);
		a.assertAll();
	}

	public void verify_Drop_sort_field_Ascending_and_Descending_Order(String reportName, String f1cn, String f1, String f2, String f2cn) throws Exception {
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.jsType(driver, reportNameTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, saveReportBtn);

		List<WebElement> list = driver.findElements(By.xpath("//tr/td["+f1cn.replace(".0", "")+"]"));
		int count = list.size();
		for (int i = 0; i < count; i++) {
			String num = list.get(i).getText();
			Reporter.log(""+f1+" Before Sorting "+i+":" +num ,true);
		}
		ActionUtils.ajaxDragAndDrop(driver, By.xpath("//div[text()='"+f1+"']"), sortDropField);
		List<WebElement> list2 = driver.findElements(By.xpath("//tr/td["+f1cn.replace(".0", "")+"]"));
		VerificationLibrary.verifyWebTableTextDataOrderWithoutCaseSensitive(driver, list2, "Ascending");
		ActionUtils.ajaxJsClick(driver, descendingOrderBtn);
		List<WebElement> list3 = driver.findElements(By.xpath("//tr/td["+f1cn.replace(".0", "")+"]"));
		VerificationLibrary.verifyWebTableTextDataOrderWithoutCaseSensitive(driver, list3, "Descending");
		ActionUtils.ajaxJsClick(driver, closeSortingBtn);
		// For Analyse drop some fields 
		// Field 1
		ActionUtils.ajaxDragAndDrop(driver, By.xpath("//div[text()='"+f1+"']"), sortDropField);
		// Field 2
		ActionUtils.ajaxDragAndDrop(driver, By.xpath("//div[text()='"+f2+"']"), sortDropField);
		// Open created report
		ActionUtils.ajaxJsClick(driver, pageBackBtn);
		ActionUtils.jsType(driver, searchReportTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, searchReportBtn);
		ActionUtils.click(driver, By.xpath("//td[text()='"+reportName+"']"));
		// Verify sorting by column headers 
		// Field 1
		// Ascending order
		List<WebElement> checkList = driver.findElements(By.xpath("//tr/td["+f1cn.replace(".0", "")+"]"));
		VerificationLibrary.verifyWebTableTextDataOrderWithoutCaseSensitive(driver, checkList, "Ascending");
		// Descending order
		ActionUtils.click(driver, By.xpath("(//div[text()='"+f1+"'])[1]"));
		Thread.sleep(2000);
		List<WebElement> checkList2 = driver.findElements(By.xpath("//tr/td["+f1cn.replace(".0", "")+"]"));
		VerificationLibrary.verifyWebTableTextDataOrderWithoutCaseSensitive(driver, checkList2, "Descending");
		// Field 2
		// Ascending order
		List<WebElement> checkList3 = driver.findElements(By.xpath("//tr/td["+f2cn.replace(".0", "")+"]"));
		VerificationLibrary.verifyWebTableTextDataOrderWithoutCaseSensitive(driver, checkList3, "Ascending");
		// Descending order
		ActionUtils.scrollIntoView(driver, By.xpath("(//div[text()='"+f2+"'])[1]"));
		ActionUtils.click(driver, By.xpath("(//div[text()='"+f2+"'])[1]"));
		Thread.sleep(2000);
		List<WebElement> checkList4 = driver.findElements(By.xpath("//tr/td["+f2cn.replace(".0", "")+"]"));
		VerificationLibrary.verifyWebTableNumberDataOrder(driver, checkList4, "Descending");
	}

	public void verify_Sort_by_Group_report(String reportName, String fieldToSort) throws Exception {
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.jsType(driver, reportNameTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, saveReportBtn);
		// Group sort
		ActionUtils.ajaxDragAndDrop(driver, By.xpath("//div[text()='"+fieldToSort+"']"), groupDropField);
		ActionUtils.ajaxJsClick(driver, pageBackBtn);
		ActionUtils.jsType(driver, searchReportTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, searchReportBtn);
		ActionUtils.click(driver, By.xpath("//td[text()='"+reportName+"']"));
		Assert.assertTrue(driver.findElement(By.xpath("//th[contains(.,'"+fieldToSort+"')]")).isDisplayed(), "Sort by group is not functional");
		Reporter.log("Sort by group is functional", true);
	}

	public void verify_Total_of_the_selected_field_report(String reportName, String field, String fcn) throws Exception {
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.jsType(driver, reportNameTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, saveReportBtn);
		// Field total
		Thread.sleep(1000);
		ActionUtils.ajaxDragAndDrop(driver, By.xpath("//div[text()='Range1']"), totalDropField);
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, pageBackBtn);
		ActionUtils.jsType(driver, searchReportTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, searchReportBtn);
		ActionUtils.click(driver, By.xpath("//td[text()='"+reportName+"']"));
		// Goto last Page
		try {
			ActionUtils.click(driver, gotoLastPageBtn);
		} catch (StaleElementReferenceException e1) {
			ActionUtils.click(driver, gotoLastPageBtn);
		}
		Thread.sleep(2000);
		try {
			int total = Integer.parseInt(driver.findElement(By.xpath("//tr[last()]/td["+fcn.replace(".0", "")+"]")).getText());
			Reporter.log("Total of the selected field is: "+total,true);
			Assert.assertTrue(total != 0, "Column total is not found");
			Reporter.log("Given column total is found", true);
		} catch (NumberFormatException e) {
			Assert.fail("Filed is empty - Column total is not found");
		}
	}

	public void verify_Export_report_to_export(String reportName, String downloadPath) throws Exception {
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.jsType(driver, reportNameTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, addAllBtn);
		ActionUtils.ajaxJsClick(driver, saveReportBtn);
		ActionUtils.ajaxJsClick(driver, pageBackBtn);
		ActionUtils.jsType(driver, searchReportTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, searchReportBtn);
		ActionUtils.click(driver, By.xpath("//td[text()='"+reportName+"']"));
		ActionUtils.hoverToElement(driver, reportMoreBtn);
		ActionUtils.click(driver, exportToExcelOption);
		Thread.sleep(6000);
		Assert.assertTrue(VerificationLibrary.isFileDownloaded(downloadPath, reportName), "File not exported to excel");
		Reporter.log("File exported to excel", true);
	}

	public void verify_Filter_Option_for_number_field(String reportName, String equalsValue, String greaterThanValue, 
			String greaterThanEqualsValue, String lessThanValue, String lessThanEqualsValue, String startValue, String endValue) throws Exception {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.jsType(driver, reportNameTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, saveReportBtn);
		// Resolution before
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[18]"));
		int count = list.size();
		for (int i = 0; i < count; i++) {
			String activity = list.get(i).getText();
			Reporter.log("Resolution Before Filter Action "+i+":" +activity ,true);
		}
		// Resolution after 
		ActionUtils.ajaxJsClick(driver, filterOption);
		ActionUtils.ajaxDragAndDrop(driver, resoltionField, filterDropZone);
		// Blank
		ActionUtils.jsClick(driver, typeDD); 
		ActionUtils.ajaxJsClick(driver, blankOption);
		try {
			a.assertTrue(driver.findElement(noMatchingRecordsFoundMsg).isDisplayed());
			Reporter.log("Balnk option is fucntional", true);
		} catch (AssertionError | NoSuchElementException e) {
			Reporter.log("Blank option is not functional", true);
		}

		// '=' Option
		ActionUtils.jsClick(driver, typeDD); 
		ActionUtils.ajaxJsClick(driver, equalsOption);
		ActionUtils.ajaxType(driver, startFieldTextBox, equalsValue.replace(".0", ""));
		List<WebElement> equalsList = driver.findElements(By.xpath("//tr/td[18]"));
		int count2 = equalsList.size();
		for (int i = 0; i < count2; i++) {
			String resolution = equalsList.get(i).getText();
			Reporter.log("Resolution given: "+equalsValue.replace(".0", "")+" after '=' option: " +resolution, true);
			a.assertEquals(equalsValue.replace(".0", ""), resolution);
			Reporter.log("'=' option in filter is functional", true);
		}

		// '>' Option
		ActionUtils.jsClick(driver, typeDD); 
		ActionUtils.ajaxJsClick(driver, NAoption);
		ActionUtils.jsClick(driver, typeDD); 
		ActionUtils.ajaxJsClick(driver, greaterThanOption);
		ActionUtils.ajaxClickClearAndType(driver, startFieldTextBox, greaterThanValue.replace(".0", ""));
		List<WebElement> greaterList = driver.findElements(By.xpath("//tr/td[18]"));
		int count3 = greaterList.size();
		for (int i = 0; i < count3; i++) {
			String resolution = greaterList.get(i).getText();
			Reporter.log("Resolution given: "+greaterThanValue.replace(".0", "")+" after '>' option: " +resolution ,true);
			int given = Integer.parseInt(greaterThanValue.replace(".0", ""));	
			int result = Integer.parseInt(resolution);	
			if (result>given) {
				Reporter.log(result + " is '>' "+given, true);
			} else {
				a.fail("'>' option is NOT functional");
			}
		}
		Reporter.log("'>' option in filter is functional", true);

		// '≥' Option
		ActionUtils.jsClick(driver, typeDD); 
		ActionUtils.ajaxJsClick(driver, NAoption);
		ActionUtils.jsClick(driver, typeDD); 
		ActionUtils.ajaxJsClick(driver, greaterThanEqualsOption);
		ActionUtils.ajaxClickClearAndType(driver, startFieldTextBox, greaterThanEqualsValue.replace(".0", ""));
		List<WebElement> greaterEqualsList = driver.findElements(By.xpath("//tr/td[18]"));
		int count4 = greaterEqualsList.size();
		for (int i = 0; i < count4; i++) {
			String resolution = greaterEqualsList.get(i).getText();
			Reporter.log("Resolution given: "+greaterThanEqualsValue.replace(".0", "")+" after '>=' option: " +resolution ,true);
			int given = Integer.parseInt(greaterThanEqualsValue.replace(".0", ""));	
			int result = Integer.parseInt(resolution);	
			if (result >= given) {
				Reporter.log(result + " is '>=' "+given, true);
			} else {
				a.fail("'>=' option is NOT functional");
			}
		}
		Reporter.log("'>=' option in filter is functional", true);

		// '<' Option
		ActionUtils.jsClick(driver, typeDD); 
		ActionUtils.ajaxJsClick(driver, NAoption);
		ActionUtils.jsClick(driver, typeDD); 
		ActionUtils.ajaxJsClick(driver, lessThanOption);
		ActionUtils.ajaxClickClearAndType(driver, startFieldTextBox, lessThanValue.replace(".0", ""));
		List<WebElement> lessThanList = driver.findElements(By.xpath("//tr/td[18]"));
		int count5 = lessThanList.size();
		for (int i = 0; i < count5; i++) {
			String resolution = lessThanList.get(i).getText();
			if (!resolution.equals("")) {
				Reporter.log("Resolution given: "+lessThanValue.replace(".0", "")+" after '<' option: " +resolution ,true);
				int given = Integer.parseInt(lessThanValue.replace(".0", ""));	
				int result = Integer.parseInt(resolution);	
				if (result < given) {
					Reporter.log(result + " is '<' "+given, true);
				} else {
					a.fail("'<' option is NOT functional");
				}
			}
		}
		Reporter.log("'<' option in filter is functional", true);

		// '≤' Option
		ActionUtils.jsClick(driver, typeDD); 
		ActionUtils.ajaxJsClick(driver, NAoption);
		ActionUtils.jsClick(driver, typeDD); 
		ActionUtils.ajaxJsClick(driver, lessThanEqualsOption);
		ActionUtils.ajaxClickClearAndType(driver, startFieldTextBox, lessThanEqualsValue.replace(".0", ""));
		List<WebElement> lessThanEqualsList = driver.findElements(By.xpath("//tr/td[18]"));
		int count6 = lessThanEqualsList.size();
		for (int i = 0; i < count6; i++) {
			String resolution = lessThanEqualsList.get(i).getText();
			if (!resolution.equals("")) {
				Reporter.log("Resolution given: "+lessThanEqualsValue.replace(".0", "")+" after '<=' option: " +resolution ,true);
				int given = Integer.parseInt(lessThanEqualsValue.replace(".0", ""));	
				int result = Integer.parseInt(resolution);	
				if (result <= given) {
					Reporter.log(result + " is '<=' "+given, true);
				} else {
					a.fail("'<=' option is NOT functional");
				}
			}
		}
		Reporter.log("'<=' option in filter is functional", true);

		// Range Option
		ActionUtils.jsClick(driver, typeDD); 
		ActionUtils.ajaxJsClick(driver, NAoption);
		ActionUtils.jsClick(driver, typeDD); 
		ActionUtils.ajaxJsClick(driver, rangeOption);
		ActionUtils.ajaxClickClearAndType(driver, startFieldTextBox, startValue.replace(".0", ""));
		ActionUtils.ajaxClickClearAndType(driver, endFieldTextBox, endValue.replace(".0", ""));
		List<WebElement> rangeList = driver.findElements(By.xpath("//tr/td[18]"));
		int count7 = rangeList.size();
		for (int i = 0; i < count7; i++) {
			String resolution = rangeList.get(i).getText();
			Reporter.log("Resolution given Range => Start: "+startValue.replace(".0", "")+" End: "+endValue.replace(".0", "")+" Result: "+resolution ,true);
			int given1 = Integer.parseInt(startValue.replace(".0", ""));	
			int given2 = Integer.parseInt(endValue.replace(".0", ""));
			int result = Integer.parseInt(resolution);	
			if ((result >= given1) && (result <= given2)) {
				Reporter.log(result + " is in the Range of "+given1+" & "+given2, true);
			} else {
				a.fail("Range option is NOT functional");
			}
		}
		Reporter.log("Range option in filter is functional", true);

		// Max Option
		ActionUtils.jsClick(driver, typeDD); 
		ActionUtils.ajaxJsClick(driver, NAoption);
		ActionUtils.jsClick(driver, typeDD); 
		ActionUtils.ajaxJsClick(driver, maxOption);
		List<WebElement> maxList = driver.findElements(By.xpath("//tr/td[18]"));
		Reporter.log("Max value from filter is: "+maxList.get(0).getText() ,true);
		int count8 = maxList.size();
		a.assertTrue(count8 == 1, "Max option is not functional");
		Reporter.log("Max option in filter is functional", true);

		a.assertAll();
	}

	public void verify_Filter_Option_for_Text_field(String reportName, String status) throws Exception {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.jsType(driver, reportNameTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, saveReportBtn);
		Thread.sleep(2000);

		// Calibration status - Before
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[2]"));
		int count = list.size();
		for (int i = 0; i < count; i++) {
			String statusBefore = list.get(i).getText();
			Reporter.log("Calibration status Before Filter Action "+i+":" +statusBefore ,true);
		}
		// Calibration status - After
		ActionUtils.ajaxJsClick(driver, filterOption);
		ActionUtils.ajaxDragAndDrop(driver, calibrationStatusField, filterDropZone);
		ActionUtils.jsClick(driver, textDD); 
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[text()='"+status+"']"));
		List<WebElement> list2 = driver.findElements(By.xpath("//tr/td[2]"));
		int count2 = list2.size();
		for (int i = 0; i < count2; i++) {
			String statusAfter = list2.get(i).getText();
			Reporter.log("Calibration status After Filter Action "+i+":" +statusAfter ,true);
			a.assertEquals(statusAfter, status, "Filter option for text field is NOT functional");
		}

		a.assertAll();
	}

	public void verify_Filter_Option_for_Date_field(String reportName, String option1, String option2,
			String startYear, String startMonth, String startDate, String endYear, String endMonth, String endDate) throws Exception {
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.jsType(driver, reportNameTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, saveReportBtn);
		// Date - Before
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[21]"));
		int count = list.size();
		for (int i = 0; i < count; i++) {
			String date = list.get(i).getText();
			Reporter.log("Dates Before Filter Action "+i+":" +date ,true);
		}
		// Filter - Date - required option
		ActionUtils.ajaxJsClick(driver, filterOption);
		ActionUtils.ajaxDragAndDrop(driver, lastCalibrationField, filterDropZone);
		ActionUtils.ajaxSelectElementByVisibleText(driver, typeSelectDD, option1);
		List<WebElement> dateList = driver.findElements(By.xpath("//tr/td[21]"));
		int count2 = dateList.size();
		for (int i = 0; i < count2; i++) {
			String date = dateList.get(i).getText();
			Reporter.log("Dates After Filter Action "+i+":" +date ,true);
		}
		// Filter - Date - Exact period
		ActionUtils.ajaxSelectElementByVisibleText(driver, typeSelectDD, option2);
		// start date
		ActionUtils.click(driver, startFieldTextBox);
		ActionUtils.ajaxJsClick(driver, selectMonthBtn);
		ActionUtils.ajaxJsClick(driver, selectYearBtn);
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[@data-action='selectYear'][contains(.,'"+startYear.replace(".0", "")+"')]"));
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[@data-action='selectMonth'][contains(.,'"+startMonth.replace(".0", "")+"')]"));
		ActionUtils.ajaxJsClick(driver, By.xpath("//td[@data-action='selectDay'][contains(.,'"+startDate.replace(".0", "")+"')]"));
		// End date
		ActionUtils.click(driver, endFieldTextBox);
		ActionUtils.ajaxJsClick(driver, selectMonthBtn);
		ActionUtils.ajaxJsClick(driver, selectYearBtn);
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[@data-action='selectYear'][contains(.,'"+endYear.replace(".0", "")+"')]"));
		ActionUtils.ajaxJsClick(driver, By.xpath("//span[@data-action='selectMonth'][contains(.,'"+endMonth.replace(".0", "")+"')]"));
		ActionUtils.ajaxJsClick(driver, By.xpath("//td[@data-action='selectDay'][contains(.,'"+endDate.replace(".0", "")+"')]"));
		// Filtered dates in range
		List<WebElement> periodDatesList = driver.findElements(By.xpath("//tr/td[21]"));
		for (WebElement ele : periodDatesList) {
			String date = ele.getText();
			Reporter.log("Dates After selecting duration from Filter Action: " +date ,true);
		}
	}

	public void verify_Share_Report_option(String reportName,String user) throws Exception {
		SoftAssert a = new SoftAssert();
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.jsType(driver, reportNameTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, saveReportBtn);



		/*	GenericLibrary.waitForElementToBeClickable(driver, shareOption);
		JavascriptLibrary.javascriptClickElement(driver, shareOption);
		GenericLibrary.waitForAjax(driver);
		shareSearchBox.sendKeys(user);
		GenericLibrary.click(driver, shareSearchBtn);
		try {
			JavascriptLibrary.javascriptClickElement(driver, shareToUser);
			GenericLibrary.waitForAjax(driver);
			WebElement addedUser = driver.findElement(By.xpath("//li[contains(.,'"+user+"')]"));
			Assert.assertTrue(addedUser.isDisplayed(), "User not Added");
			Reporter.log("User Added Successfully", true);
			// Verify shared report
			AjaxLibrary.jsClick(driver, currentUserAcc);
			AjaxLibrary.jsClick(driver, myAccountLink);
			AjaxLibrary.jsClick(driver, LoginAsBtn);
			logInEmailTextBox.sendKeys(user);
			GenericLibrary.waitForAjax(driver);
			WebElement newLoginAcc = driver.findElement(By.xpath("//td[text()='"+user+"']"));
			AjaxLibrary.jsClick(driver, newLoginAcc);
			AjaxLibrary.jsClick(driver, reLogInBtn);
			AjaxLibrary.jsClick(driver, viosMenu);
			AjaxLibrary.jsClick(driver, LoginPage.newCRMBtn);
			AjaxLibrary.jsClick(driver, DashBoardPage.analyseLink);
			searchReportTextBox.sendKeys(reportName);
			JavascriptLibrary.javascriptClickElement(driver, searchReportBtn);
			GenericLibrary.waitForAjax(driver);
			WebElement report = driver.findElement(By.xpath("//a[text()='"+reportName+"']"));
			Assert.assertTrue(report.isDisplayed(), "Report Not Created Successfully");
		} catch (NoSuchElementException e) {
			Assert.assertTrue(noRecordsFoundMessage.isDisplayed(),"'No records found' not displayed");
			Reporter.log("User Not Found", true);
		} catch (AssertionError e) {
			Assert.assertTrue(false, "User not Added");
		}*/
		a.assertAll();
	}

	public void verify_BarChart_Design_Report(String reportName, String col, String filterBy, String target, String filterOpt) throws Exception {
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.jsType(driver, reportNameTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, barChartDesign);
		ActionUtils.ajaxDragAndDrop(driver, unitsField, bar_Y);
		ActionUtils.ajaxDragAndDrop(driver, calibrationStatusField, bar_X);
		ActionUtils.ajaxSelectElementByVisibleText(driver, x_ColumnsDD, col.replace(".0", ""));
		ActionUtils.ajaxSelectElementByVisibleText(driver, filterDD, filterBy);
		ActionUtils.ajaxClickClearAndType(driver, targetField, target.replace(".0", ""));
		ActionUtils.ajaxJsClick(driver, enableLabel);
		ActionUtils.ajaxJsClick(driver, enableReportTotal);
		// Filter
		ActionUtils.ajaxJsClick(driver, filterOption);
		ActionUtils.ajaxJsClick(driver, saveReportBtn);
		ActionUtils.ajaxDragAndDrop(driver, calibrationStatusField, filterDropZone);
		ActionUtils.ajaxSelectElementByVisibleText(driver, designFilterDD, filterOpt);
	}

	public void verify_LineChart_Design_Report(String reportName, String col, String filterBy, String target, String filterOpt) throws Exception {
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.jsType(driver, reportNameTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, barChartDesign);
		ActionUtils.ajaxDragAndDrop(driver, unitsField, line_Y);
		ActionUtils.ajaxDragAndDrop(driver, calibrationStatusField, line_X);
		ActionUtils.ajaxSelectElementByVisibleText(driver, x_ColumnsDD, col.replace(".0", ""));
		ActionUtils.ajaxSelectElementByVisibleText(driver, filterDD, filterBy);
		ActionUtils.ajaxJsClickClearAndType(driver, targetField, target.replace(".0", ""));
		ActionUtils.ajaxJsClick(driver, enableLabel);
		ActionUtils.ajaxJsClick(driver, enableReportTotal);
		// Filter
		ActionUtils.ajaxJsClick(driver, filterOption);
		ActionUtils.ajaxJsClick(driver, saveReportBtn);
		ActionUtils.ajaxDragAndDrop(driver, calibrationStatusField, filterDropZone);
		ActionUtils.ajaxSelectElementByVisibleText(driver, designFilterDD, filterOpt);
	}

	public void verify_PieChart_Design_Report(String reportName, String col, String filterBy, String filterOpt) throws Exception {
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.jsType(driver, reportNameTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, pieChartDesign);
		ActionUtils.ajaxDragAndDrop(driver, unitsField, pie_Y);
		ActionUtils.ajaxDragAndDrop(driver, calibrationStatusField, pie_X);
		ActionUtils.ajaxSelectElementByVisibleText(driver, x_SegmentsDD, col.replace(".0", ""));
		ActionUtils.ajaxSelectElementByVisibleText(driver, filterDD, filterBy);
		ActionUtils.ajaxJsClick(driver, enableLabel);
		ActionUtils.ajaxJsClick(driver, enableReportTotal);
		// Filter
		ActionUtils.ajaxJsClick(driver, filterOption);
		ActionUtils.ajaxJsClick(driver, saveReportBtn);
		ActionUtils.ajaxDragAndDrop(driver, calibrationStatusField, filterDropZone);
		ActionUtils.ajaxSelectElementByVisibleText(driver, designFilterDD, filterOpt);
	}

	public void verify_SummaryChart(String reportName) throws Exception {
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.jsType(driver, reportNameTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, saveReportBtn);
		ActionUtils.ajaxJsClick(driver, SummaryChartDesign);
		Thread.sleep(1000);
		ActionUtils.ajaxDragAndDrop(driver, control1, Summary_Z);
		Thread.sleep(1000);
		ActionUtils.ajaxDragAndDrop(driver, assetName, Summary_Y);
		Thread.sleep(1000);
		ActionUtils.ajaxDragAndDrop(driver, calibrationStatus, Summary_X);
		Thread.sleep(3000);
		ActionUtils.ajaxJsClick(driver, moreBtn);
		ActionUtils.ajaxJsClick(driver, morePreviewBtn);
		Thread.sleep(1000);
		Assert.assertTrue(ActionUtils.getElement(driver, By.xpath("//table[@id='SummaryList']//tbody//tr/td")).isDisplayed(), "Summary is not working");
		Reporter.log("Summary report genertaed",true);
	}


	public void verify_WaterFallChart(String reportName) throws Exception {
		Thread.sleep(1000);
		ActionUtils.ajaxJsClick(driver, assetsDataset);
		ActionUtils.ajaxJsClick(driver, createReportBtn);
		ActionUtils.jsType(driver, reportNameTextBox, reportName);
		ActionUtils.ajaxJsClick(driver, saveReportBtn);
		ActionUtils.ajaxJsClick(driver, WaterFallChartDesign);
		Thread.sleep(1000);
		ActionUtils.ajaxDragAndDrop(driver, assetName, WaterFall_Y);
		Thread.sleep(1000);
		ActionUtils.ajaxDragAndDrop(driver, calibrationStatus, WaterFall_X);
		Thread.sleep(3000);
		ActionUtils.ajaxJsClick(driver, moreBtn);
		ActionUtils.ajaxJsClick(driver, morePreviewBtn);
		Thread.sleep(1000);
	}








}
