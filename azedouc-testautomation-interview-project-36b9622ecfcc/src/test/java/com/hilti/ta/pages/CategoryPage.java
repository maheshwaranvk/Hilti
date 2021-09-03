package com.hilti.ta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hilti.ta.utils.WebDriverFactory;

/**
 * Page Object Model representing Product Category Page.
 */
public class CategoryPage extends PageObject {
	private WebDriverFactory webDriverFactory = new WebDriverFactory();
	WebDriverWait wait=new WebDriverWait(webDriverFactory.getDriver(), 20);
	JavascriptExecutor js = (JavascriptExecutor)webDriverFactory.getDriver();
	
	
	public CategoryPage deseleteFSProducts(int count) {
		js.executeScript("arguments[0].scrollIntoView(true);", 
				WebDriverFactory.getDriver().findElement(By.xpath("(//div[@class='m-firestop-form-line a-spacing-pb--s']//div[@class='a-checkbox '])[1]")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='m-firestop-form-line a-spacing-pb--s']//div[@class='a-checkbox '])[1]")));
		for (int i = 1; i <= count; i++) {
			WebDriverFactory.getDriver().findElement(By.xpath("(//div[@class='m-firestop-form-line a-spacing-pb--s']//div[@class='a-checkbox '])["+i+"]")).click();
		}
		return this;
	}
	
	public CategoryPage selectCoverPageOption(String CPOption) {
		if(CPOption.contains("Hilti cover page")) {
			WebDriverFactory.getDriver().findElement(By.xpath("//label[@for='useHiltiCover']")).click();
		}
		else if (CPOption.contains("Hilti cover page")) {
			WebDriverFactory.getDriver().findElement(By.xpath("//label[@for='useCustomCover']")).click();
		}
		else if (CPOption.contains("No cover page")) {
			WebDriverFactory.getDriver().findElement(By.xpath("//label[@for='noCover']")).click();
		}
		
		return this;
	}
	
	public CategoryPage confirmPageNumberInclusion(String option) {
		
		if (option.contains("No")) {
			WebDriverFactory.getDriver().findElement(By.xpath("//label[@for='page-numbers-no']")).click();
		}
		
		else  {
			WebDriverFactory.getDriver().findElement(By.xpath("//label[@for='page-numbers-yes']")).click();
		}
		return this;
	}
	
	public CategoryPage clickGenerateSubmittal() {
		WebDriverFactory.getDriver().findElement(By.id("create-submittal")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("download-link")));
		return this;
	}
	
	public CategoryPage clickDownloadSubmittal() {
		String downloadUrl = WebDriverFactory.getDriver().findElement(By.id("download-link")).getAttribute("href");
		Assert.assertTrue(downloadUrl.contains(".pdf"));
		WebDriverFactory.getDriver().findElement(By.id("download-link")).click();
		return this;
	}

	}
	
	
