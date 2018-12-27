package com.app.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.app.utilities.Driver;

public class GitPage {
	private WebDriver driver;

	public GitPage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	//TODO 
	@FindBy()
	public WebElement ;
	
	
	
	
	
}
