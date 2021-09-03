package com.hilti.ta.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hilti.ta.utils.Country;
import com.hilti.ta.utils.WebDriverFactory;

/**
 * Page Object Model representing Homepage.
 */

public class Homepage extends PageObject {

	private static final String HILTI_URL = "https://www.hilti";
	private WebDriverFactory webDriverFactory = new WebDriverFactory();
	WebDriverWait wait=new WebDriverWait(webDriverFactory.getDriver(), 20);
	JavascriptExecutor js = (JavascriptExecutor)webDriverFactory.getDriver();

	/**
	 * Opens homepage for given country.
	 * 
	 * @param country
	 *            {@link Country}
	 */
	public void navigateTo(final Country country) {
		String url = HILTI_URL + country.getDomain();
		WebDriverFactory.getDriver().get(url);
	}
	
	public Homepage searchItem(String searchItem) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search_input")));
		WebDriverFactory.getDriver().findElement(By.id("search_input")).sendKeys(searchItem);
		WebDriverFactory.getDriver().findElement(By.id("search_input")).sendKeys(Keys.ENTER);
		return this;
	}
	
	public Homepage selectTechnicalDocumentsTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-technical-documents")));
		WebDriverFactory.getDriver().findElement(By.id("tab-technical-documents")).click();
		return this;
	}
	
	public Homepage selectVideosTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-videos")));
		WebDriverFactory.getDriver().findElement(By.id("tab-videos")).click();
		return this;
	}
	
	public Homepage selectEditorialTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab-editorials")));
		WebDriverFactory.getDriver().findElement(By.id("tab-editorials")).click();
		return this;
	}
	
	public FirestopsPage selectFireStopSubmittal() {
		WebElement fireStop = WebDriverFactory.getDriver().findElement(By.xpath("//img[@alt='Firestop Submittal Generator']"));
		js.executeScript("arguments[0].scrollIntoView(true);", fireStop);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@alt='Firestop Submittal Generator']")));
		
		
		
		
		js.executeScript("arguments[0].click();", fireStop);
		return new FirestopsPage();
	}
	
	
}
