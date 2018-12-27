package com.app.tests;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.app.utilities.BrowserUtils;
import com.app.utilities.TestBase;

public class GitHub extends TestBase {
	@Test
	public void getAllLinks() {
		driver.get("https://github.com/");
		BrowserUtils.getElementsText(By.tagName("a"));
		System.out.println(BrowserUtils.getElementsText(By.tagName("a")));
		
		
	}
}

// List<WebElement> links = driver.findElements(By.tagName("a"));
// // saving it to array list
// List<String> linkTexts = new ArrayList<>();
//
// for (WebElement link : links) {
// if (!link.getText().isEmpty()) {
// linkTexts.add(link.getText());
// }
// }
// System.out.println(linkTexts);
// }
// }