package com.app.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.app.pages.HomePageaws;
import com.app.utilities.TestBase;

public class AWShomepageCalculator extends TestBase {

	HomePageaws calculator = new HomePageaws();

	@Test(priority = 0, description = "Checking default montly bill test expected $0.00 as default")
	public void defaultMontlyBillTest() {
		assertTrue(calculator.isAt());
		// System.out.println(calculator.getMontlyBillAmount());
		assertEquals(0.0, calculator.getMonthlyBillAmount());
	}

	@Test(priority = 1)
	public void clickadd() {
		calculator.addEC2.click();
		// calculator.description.sendKeys("hihi");
		assertTrue(calculator.description.getAttribute("value").isEmpty());
		// System.out.println(calculator.intances.getText());
		assertEquals(calculator.getinstancecount(), 1);
		assertEquals(100, Integer.parseInt(calculator.usageCount.getAttribute("value")));

		// actual result expected result
		assertEquals(calculator.getUsageOption(), "% Utilized/Month");// this will verify if we selected the % value
		System.out.println(calculator.getUsageOption());// just printing result

		assertEquals(calculator.ec2Type.getText(), "Linux on t1.micro");
		System.out.println(calculator.ec2Type.getText());// just printing result

		assertEquals(calculator.billingOption.getText(), "On-Demand (No Contract)");
		System.out.println(calculator.billingOption.getText());

		// assert the price is
		assertEquals(calculator.montlyCost.getText(), "$ 14.64");
		System.out.println(calculator.montlyCost.getText());

		System.out.println(calculator.getMonthlyCost());// converting to double from $ 14.64 to 14.64
		assertEquals(calculator.getMonthlyCost(), 14.64);
		
		double servicesTabMontlyCost = calculator.getMonthlyCost();
		System.out.println("service tab "+servicesTabMontlyCost);
		
		calculator.billLabel.click();
		Double billTabMontlyCost = Double.parseDouble(calculator.montlyBillCostBeforeDiscounts.getAttribute("value"));
		System.out.println("Bill tab "+billTabMontlyCost);
		assertEquals(servicesTabMontlyCost, billTabMontlyCost);
		
		calculator.services.click();
	}

	@Test(priority = 2)
	public void clearFormTest() throws InterruptedException {
		calculator.popUp.click();
		// assertTrue(calculator.confirmDialog());// verify if text in dialog box pop up
		// is there
		String popUpText = calculator.confirmDialog.getText();
		String popupText = calculator.confirmDialog.getText();
		assertTrue(popupText.contains("Please Confirm")
				&& popupText.contains("Are you sure you want to clear all entries in this service form?"));
		// click OK
		calculator.okButton.click();
		// System.out.println("There are no elements:
		// "+calculator.isEC2InstancesTableClear()); //option 1 to verify if its empty
		assertEquals(calculator.isEC2InstancesTableClear(), true);// option 2
	}

	

}
