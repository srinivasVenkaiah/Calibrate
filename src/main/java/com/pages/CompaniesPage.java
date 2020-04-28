package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.base.BasePage;
import com.util.ActionUtils;

public class CompaniesPage extends BasePage {
	// Initializing the Page Objects:................................................................
	public CompaniesPage() {
		PageFactory.initElements(driver, this);
	}

	// Objects Repository(OR):........................................................................
	// Create company
	
	
	@FindBy(xpath=".//*[@id='btnCreateCompany']")
	WebElement addCompanyBtn;

	@FindBy(xpath=".//*[@id='CompanyName']")
	WebElement companyName;

	@FindBy(xpath=".//*[@id='DA_AddressLine1']")
	WebElement addressLine1;

	@FindBy(xpath=".//*[@id='DA_AddressLine2']")
	WebElement addressLine2;

	@FindBy(xpath=".//*[@id='DA_AddressLine3']")
	WebElement addressLine3;

	@FindBy(xpath="//input[contains(@mytitle,'County')]")
	WebElement county;

	@FindBy(xpath=".//*[@id='DA_Postcode']")
	WebElement postCode;

	@FindBy(xpath=".//*[@id='WebSite']")
	WebElement website;

	@FindBy(xpath=".//*[@id='CompanyEmail']")
	WebElement companyEmail;

	@FindBy(xpath=".//*[@id='Tel']")
	WebElement telephone;

	@FindBy(xpath=".//*[@id='CompanyDesc']")
	WebElement description;

	@FindBy(xpath=".//*[@id='companyImgDropzone']")
	WebElement dropCompanyImage;
	
	@FindBy(xpath="//div[@title='mySupplier']")
	WebElement mySupplierBtn;

	@FindBy(xpath="//a[contains(@id,'btnCreateNewCompany')]")
	WebElement saveBtn;

	@FindBy(xpath="//input[contains(@id,'txtSearch')]")
	WebElement companySearchBox;

	@FindBy(xpath="//a[contains(@onclick,'CompanyList.Search()')]")
	WebElement companySearchBtn;
	
	@FindBy(xpath=".//*[@id='divError-CompanyName']")
	WebElement companyNameErrorMsg;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	





	// Actions:......................................................................................
	public void verify_CompaniesPage() {
		Assert.assertTrue(addCompanyBtn.isDisplayed(), "Unable to Navigate Companies Page");
	}

	public void verify_Create_new_company(String company, String address1, String address2, String address3,
			String district, String pcode, String web, String email, String phoneNo, String desc, String filePath) throws Exception {
		ActionUtils.ajaxClick(driver, addCompanyBtn);
		ActionUtils.jsType(driver, companyName, company);
		addressLine1.sendKeys(address1);
		addressLine2.sendKeys(address2);
		addressLine3.sendKeys(address3);
		county.sendKeys(district);
		postCode.sendKeys(pcode.replace(".0", ""));
		website.sendKeys(web);
		companyEmail.sendKeys(email);
		telephone.sendKeys(phoneNo.replaceAll(".", ""));
		description.sendKeys(desc);
		ActionUtils.ajaxUploadFile(driver, dropCompanyImage, filePath);
		ActionUtils.ajaxJsClick(driver, mySupplierBtn);
		ActionUtils.ajaxJsClick(driver, saveBtn);
		driver.navigate().back();
		ActionUtils.jsType(driver, companySearchBox, company);
		ActionUtils.ajaxClick(driver, companySearchBtn);
		WebElement ele = driver.findElement(By.xpath("//h3[@title='"+company+"']"));	
		Assert.assertTrue(ele.getText().contains(company), "Created company not found in search results");
		Reporter.log("Created company found in companies search results", true);
	}
	
	public void verify_mandatory_fields_error_messages() throws Exception {
		ActionUtils.ajaxClick(driver, addCompanyBtn);
		ActionUtils.ajaxJsClick(driver, saveBtn);
		Assert.assertTrue(companyNameErrorMsg.isDisplayed(), "Company name field error message NOT displayed");
	}
	
	
	


}
