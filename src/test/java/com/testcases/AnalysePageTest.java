package com.testcases;

import java.nio.file.Paths;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.base.BasePage;
import com.pages.AnalysePage;
import com.pages.AssetsPage;
import com.pages.LoginPage;
import com.util.ExcelUtility;

public class AnalysePageTest extends BasePage {

	LoginPage loginPage;
	AssetsPage assetsPage;
	AnalysePage analysePage;
	ExcelUtility reader;
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		assetsPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		analysePage = assetsPage.navigate_to_Analyse();
		reader = new ExcelUtility(prop.getProperty("excelFilePath"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void verify_AnalysePage_Test() {
		analysePage.verify_AnalysePage();
		Reporter.log("Analyse Page Verified Successfully",true);
	}

	@Test
	public void verify_Create_report_Test() throws Exception {
		analysePage.verify_Create_report(reader.getOrderedRandomData("Analyse", 0, 1));
	}
	
	@Test
	public void verify_Report_name_mandatory_msg_Test() throws Exception {
		analysePage.verify_Report_name_mandatory_msg();
	}
	
	@Test(dependsOnMethods="verify_Create_report_Test")
	public void verify_Copy_report_Test() throws Exception {
		analysePage.verify_Copy_report(reader.getCellData("Analyse", 0, 1));
	}
	
	@Test
	public void verify_Delete_report_Test() throws Exception {
		analysePage.verify_Delete_report(reader.getCellData("Analyse", 0, 2));
	}
	
	@Test
	public void verify_Swaping_columns_Test() throws Exception {
		analysePage.verify_Swaping_columns();
	}
	
	@Test
	public void verify_Delete_columns_Test() throws Exception {
		analysePage.verify_Delete_columns();
	}
	
	@Test
	public void verify_Add_all_columns_Remove_all_columns_Test() throws Exception {
		analysePage.verify_Add_all_columns_Remove_all_columns();
	}
	
	@Test
	public void verify_Adding_selected_fileds_to_report_Test() throws Exception {
		analysePage.verify_Adding_selected_fileds_to_report(reader.getCellData("Analyse", 0, 3), 
				reader.getCellData("Analyse", 1, 3), reader.getCellData("Analyse", 2, 3), 
				reader.getCellData("Analyse", 3, 3), reader.getCellData("Analyse", 4, 3));
	}
	
	@Test
	public void verify_Drop_sort_field_Ascending_and_Descending_Order_Test() throws Exception {
		analysePage.verify_Drop_sort_field_Ascending_and_Descending_Order(
				reader.getOrderedRandomData("Analyse", 0, 4), reader.getCellData("Analyse", 1, 4), 
				reader.getCellData("Analyse", 2, 4), reader.getCellData("Analyse", 3, 4), 
				reader.getCellData("Analyse", 4, 4));
	}
	
	@Test
	public void verify_Sort_by_Group_report_Test() throws Exception {
		analysePage.verify_Sort_by_Group_report(
				reader.getOrderedRandomData("Analyse", 0, 5), reader.getCellData("Analyse", 1, 5));
	}
	
	@Test
	public void verify_Total_of_the_selected_field_report_Test() throws Exception {
		analysePage.verify_Total_of_the_selected_field_report(reader.getOrderedRandomData("Analyse", 0, 6), 
				reader.getCellData("Analyse", 1, 6), reader.getCellData("Analyse", 2, 6));
	}
	
	@Test
	public void verify_Export_report_to_export() throws Exception {
		analysePage.verify_Export_report_to_export(reader.getCellData("Analyse", 0, 7), 
				Paths.get(System.getProperty("user.home"), "Downloads").toString());
	}
	
	@Test
	public void verify_Filter_Option_for_number_field_Test() throws Exception {
		analysePage.verify_Filter_Option_for_number_field(reader.getCellData("Analyse", 0, 8), 
				reader.getCellData("Analyse", 1, 8), reader.getCellData("Analyse", 2, 8), 
				reader.getCellData("Analyse", 3, 8), reader.getCellData("Analyse", 4, 8), 
				reader.getCellData("Analyse", 5, 8), reader.getCellData("Analyse", 6, 8), 
				reader.getCellData("Analyse", 7, 8));
		Reporter.log("Filter options for number field is functional",true);
	}
	
	@Test
	public void verify_Filter_Option_for_Text_field_Test() throws Exception {
		analysePage.verify_Filter_Option_for_Text_field(
				reader.getCellData("Analyse", 0, 9), reader.getCellData("Analyse", 1, 9));
		Reporter.log("Filter options for text field is functional",true);
	}
	
	@Test
	public void verify_Filter_Option_for_Date_field_Test() throws Exception {
		analysePage.verify_Filter_Option_for_Date_field(reader.getCellData("Analyse", 0, 10), 
				reader.getCellData("Analyse", 1, 10), reader.getCellData("Analyse", 2, 10), 
				reader.getCellData("Analyse", 3, 10), reader.getCellData("Analyse", 4, 10), 
				reader.getCellData("Analyse", 5, 10), reader.getCellData("Analyse", 6, 10), 
				reader.getCellData("Analyse", 7, 10), reader.getCellData("Analyse", 8, 10));
		Reporter.log("Filter options for date field is functional",true);
	}
	
	@Test(enabled=false)
	public void verify_Share_Report_option_Test() throws Exception {
		analysePage.verify_Share_Report_option(reader.getCellData("Analyse", 0, 11), 
				reader.getCellData("Analyse", 1, 11));
		Reporter.log("Share Report option is functional",true);
	}
	
	@Test
	public void verify_BarChart_Design_Report_Test() throws Exception {
		analysePage.verify_BarChart_Design_Report(reader.getOrderedRandomData("Analyse", 0, 12), 
				reader.getCellData("Analyse", 1, 12), reader.getCellData("Analyse", 2, 12), 
				reader.getCellData("Analyse", 3, 12), reader.getCellData("Analyse", 4, 12));
		Reporter.log("BarChart Report option is functional",true);
	}
	
	@Test
	public void verify_LineChart_Design_Report_Test() throws Exception {
		analysePage.verify_LineChart_Design_Report(reader.getOrderedRandomData("Analyse", 0, 13), 
				reader.getCellData("Analyse", 1, 13), reader.getCellData("Analyse", 2, 13), 
				reader.getCellData("Analyse", 3, 13), reader.getCellData("Analyse", 4, 13));
		Reporter.log("LineChart Report option is functional",true);
	}
	
	@Test
	public void verify_PieChart_Design_Report_Test() throws Exception {
		analysePage.verify_PieChart_Design_Report(reader.getOrderedRandomData("Analyse", 0, 14), 
				reader.getCellData("Analyse", 1, 14), reader.getCellData("Analyse", 2, 14), 
				reader.getCellData("Analyse", 3, 14));
		Reporter.log("PieChart Report option is functional",true);
	}
	
	@Test
	public void verify_SummaryChart_Test() throws Exception {
		analysePage.verify_SummaryChart(reader.getOrderedRandomData("Analyse", 0, 15));
	}
	
	@Test
	public void verify_WaterFallChart_Test() throws Exception {
		analysePage.verify_WaterFallChart(reader.getOrderedRandomData("Analyse", 0, 16));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
