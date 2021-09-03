package com.hilti.ta.steps;

import com.hilti.ta.pages.CategoryPage;
import com.hilti.ta.pages.FirestopsPage;
import com.hilti.ta.pages.Homepage;
import com.hilti.ta.pages.components.ConsentsComponent;
import com.hilti.ta.services.BannersService;
import com.hilti.ta.services.BrowserService;
import com.hilti.ta.services.CookieService;
import com.hilti.ta.utils.Country;
import com.hilti.ta.utils.WebDriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Cucumber steps definition class for general purpose steps.
 */
public class GeneralSteps {

	private final Homepage homepage = new Homepage();
	private final ConsentsComponent consentsComponent = new ConsentsComponent();
	private final BannersService bannersService = new BannersService();
	private final CookieService cookieService = new CookieService();
	private final BrowserService browserService = new BrowserService();
	private WebDriverFactory webDriverFactory = new WebDriverFactory();
	WebDriverWait wait=new WebDriverWait(webDriverFactory.getDriver(), 30);
	private FirestopsPage firestopsPage = new FirestopsPage();
	private CategoryPage categoryPage = new CategoryPage();
	
	

	@Given("User opens Hilti website for country {}")
	public void userOpensHiltiWebsite(final Country country) {
		
		homepage.navigateTo(country);

		consentsComponent.closeConsents();
		String bannerIds = String.join("*",bannersService.getBannerIdsForCountry(country));

		if (bannerIds.length() > 4096) {
			bannerIds = bannerIds.substring(0, 4096);
		}
		cookieService.createCookie("bannedBannersPermanently", bannerIds);

		browserService.refreshPage();
	}
	
	@When("User navigates to search page for search term {string}")
	public void user_navigates_to_search_page_for_search_term_Cordless(String cordless) {
		homepage.searchItem(cordless);
	}
	
	@Then("User can see product results in the search page")
	public void user_can_see_product_results_in_the_search_page() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='m-grid-tile--content'])[1]")));
		List<WebElement> findElements = WebDriverFactory.getDriver().findElements(By.xpath("//div[@class='m-grid-tile--content']"));
		Assert.assertTrue(findElements.size()>0);
	}
	
	@When("User selects technical documents tab")
	public void user_selects_technical_documents_tab() {
		homepage.selectTechnicalDocumentsTab();
	}
	
	@Then("User can see technical document results in the search page")
	public void user_can_see_technical_document_results_in_the_search_page() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='a-heading-h3 a-spacing-pb--none']//span")));
		//boolean displayed = webDriverFactory.getDriver().findElement(By.xpath("//h3[@class=\"a-heading-h3 a-spacing-pb--none\" and text()='                 Technical Documents              ']")).isDisplayed();
		String text = WebDriverFactory.getDriver().findElement(By.xpath("//h3[@class='a-heading-h3 a-spacing-pb--none']//span")).getText();
		int parseInt = Integer.parseInt(text);
		Assert.assertTrue(parseInt>0);
	}
	
	@When("User selects videos tab")
	public void user_selects_videos_tab() {
		homepage.selectVideosTab();
	}
	
	@Then("User can see video results in the search page")
	public void user_can_see_video_results_in_the_search_page() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='m-grid-item--content'])[1]")));
		List<WebElement> findElements = WebDriverFactory.getDriver().findElements(By.xpath("//div[@class='m-grid-item--content']"));
		Assert.assertTrue(findElements.size()>0);
	}
	
	@When("User selects editorials tab")
	public void user_selects_editorials_tab() {
	    homepage.selectEditorialTab();
	}
	
	@Then("User can see editorial results in the search page")
	public void user_can_see_editorial_results_in_the_search_page() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='a-heading-h3 a-spacing-pb--none']//span")));
		//boolean displayed = webDriverFactory.getDriver().findElement(By.xpath("//h3[@class=\"a-heading-h3 a-spacing-pb--none\" and text()='                 Technical Documents              ']")).isDisplayed();
		String text = WebDriverFactory.getDriver().findElement(By.xpath("//h3[@class='a-heading-h3 a-spacing-pb--none']//span")).getText();
		int parseInt = Integer.parseInt(text);
		Assert.assertTrue(parseInt>0);
	}
	
	@When("User starts submittal generation process")
	public void user_starts_submittal_generation_process() {
		firestopsPage.waitForFSLoad();
	}
	
	@When("User selects Firestop systems {string}")
	public void user_selects_Firestop_systems(String fireStopCount) {
		int parseInt = Integer.parseInt(fireStopCount);
		firestopsPage.selectFirestopSystem(parseInt);
	}
	
	@When("User creates submittal")
	public void user_creates_submittal() {
		firestopsPage.clickCreateSubmittal();
	}
	
	@When("User deselects Firestop products {string}")
	public void user_deselects_Firestop_products(String deselectCount) {
		int parseInt = Integer.parseInt(deselectCount);
		categoryPage.deseleteFSProducts(parseInt);
	}
	
	@When("User selects submittals options {string} {string}")
	public void user_selects_submittals_options(String coverPage, String pageNo) {
		categoryPage.selectCoverPageOption(coverPage);
		categoryPage.confirmPageNumberInclusion(pageNo);
	}
	
	@When("User finalizes submittal generation process")
	public void user_finalizes_submittal_generation_process() {
		categoryPage.clickGenerateSubmittal();
	}
	
	@Then("User can download the generated document")
	public void user_can_download_the_generated_document() {
		categoryPage.clickDownloadSubmittal();
	}
}
