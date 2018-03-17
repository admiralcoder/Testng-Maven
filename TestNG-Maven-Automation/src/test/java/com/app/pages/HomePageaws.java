package com.app.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.app.utilities.Driver;

public class HomePageaws {

	private WebDriver driver;

	public HomePageaws() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//*[@class='gwt-PushButton small gwt-PushButton-up'])[1]/img")
	public WebElement addEC2;

	@FindBy(xpath = "//div[@class='billLabel']")
	public WebElement billLabel;

	@FindBy(xpath = "//tr[@class=\"EC2InstanceRow itemsTableDataRow table\"]//input[@class=\"gwt-TextBox input\"]")
	public WebElement description;

	@FindBy(xpath = "(//input[@class='gwt-TextBox numericTextBox input'])[1]")
	public WebElement intances;

	@FindBy(xpath = "//table[@class='SF_EC2_INSTANCE_FIELD_USAGE field usageField']//input")
	public WebElement usageCount;

	@FindBy(xpath = "//table[@class='SF_EC2_INSTANCE_FIELD_USAGE field usageField']//select")
	public WebElement usage;

	@FindBy(xpath = "//div[@class='gwt-HTML field SF_EC2_INSTANCE_FIELD_TYPE instanceTypeField rowDialogSelectorFieldView']")
	public WebElement ec2Type;

	@FindBy(xpath = "//div[@class='gwt-HTML field SF_COMMON_FIELD_BILLING instanceBillingField rowDialogSelectorFieldView']")
	public WebElement billingOption;

	@FindBy(xpath = "//div[@class='gwt-HTML DynamicPrice DynamicPricePricing']")
	public WebElement montlyCost;

	@FindBy(xpath = "//div[@class='buttons']")
	public WebElement popUp;
	
	@FindBy(xpath="//div[@class='gwt-DialogBox ConfirmDialog Dialog']")
	public WebElement confirmDialog;

	@FindBy(xpath="//button[.='OK']")
	public WebElement okButton;
	
	@FindBy(xpath="(//td[@class='itemPriceCell'][2]//td//input)[1]")
	public WebElement montlyBillCostBeforeDiscounts;
	
	@FindBy(xpath="//div[.='Services']")
	public WebElement services;
	
	public boolean isEC2InstancesTableClear() {//this will get the list of the elements as an array true false
		return driver.findElements(By.xpath("//tr[@class='EC2InstanceRow itemsTableDataRow table']")).isEmpty();
	}

	public double getMonthlyCost() {
		return Double.parseDouble(montlyCost.getText().replace("$ ", ""));
	}

	public boolean confirmDialog() { // this will catch the pop up and get the message inside that alert 
		return confirmDialog.isDisplayed();// verify if text in dialog box pop up is there
	}


	public String getUsageOption() {// every time we call this method we dont have to create a select test it will
									// read
		Select select = new Select(usage);// selected value from the Elements
		return select.getFirstSelectedOption().getText();
	}

	public int getinstancecount() {
		return Integer.parseInt(intances.getAttribute("value"));
	}

	public boolean isAt() {
		return driver.getTitle().equals("Amazon Web Services Simple Monthly Calculator");
	}

	//// String billText = billLabel.getText(); // 2 option
	//// String[] arrText = billText.split("$ ");
	//// String bill = arrText[1].replace(")", "");
	//// return Double.parseDouble(bill);
	// }
	public double getMonthlyBillAmount() {
		return Double.parseDouble(billLabel.getText().split("\\$ ")[1].replace(")", ""));
	}

}
