package com.hilti.ta.pages;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hilti.ta.utils.WebDriverFactory;

/**
 * Page Object Model representing Firestops page.
 */
public class FirestopsPage extends PageObject {
	private WebDriverFactory webDriverFactory = new WebDriverFactory();
	WebDriverWait wait=new WebDriverWait(webDriverFactory.getDriver(), 30);
	
	public FirestopsPage selectFirestopSystem(int count) {
		
		for (int i = 1; i <= count; i++) {
			WebDriverFactory.getDriver().findElement(By.xpath("(//span[@class='sr-only']/following::div[@class='a-checkbox '])["+i+"]")).click();
		}
		return this;
	}
	
	public CategoryPage clickCreateSubmittal() {
		WebDriverFactory.getDriver().findElement(By.xpath("//a[@title='Create submittal']")).click();
		return new CategoryPage();

	}
	
	public FirestopsPage waitForFSLoad() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a-heading-h2 a-spacing-pb--s']")));
		return this;

	}
}
