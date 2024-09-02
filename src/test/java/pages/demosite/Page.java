package pages.demosite;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.webdriver.ThucydidesWebDriverSupport;

//@DefaultUrl("https://www.saucedemo.com/v1/index.html")
public class Page extends PageObject {

	private WebDriver driver;
	private WebDriverWait wait;

	public String url = "https://www.saucedemo.com/v1/index.html";

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void openPage(String url) {
		driver = ThucydidesWebDriverSupport.getDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get(url);
		wait.until(ExpectedConditions.titleContains("Google"));
	}

	public void updateByElementName(String value, String elementName) throws Exception {
		WebElement updateOperation = findByElementName(elementName);
		updateOperation.clear();
		updateOperation.sendKeys(value);
//		$(updateOperation).type(value);
	}

	public void updateByElementId(String value, String elementId) throws Exception {
		WebElement updateOperation = findByElementId(elementId);
		$(updateOperation).type(value);
	}

	public void updateByXpath(String value, String xpath) throws Exception {
		WebElement updateOperation = findByXpath(xpath);
		$(updateOperation).type(value);
	}

	public void get(String elementType, String elementKey) throws Exception {
		WebElement getOperation = decideElementTypeForWebElement(elementType, elementKey);
		$(getOperation).getText();
	}

	public void click(String buttonName) throws Exception {
//		WebElement clickOperation = decideElementTypeForWebElement(elementType, elementKey);
		WebElement clickOperation = findByElementName(buttonName);
		clickOperation.click();
//		$(clickOperation).click();
	}

	public WebElement decideElementTypeForWebElement(String elementType, String elementKey) throws Exception {
		if (elementType.equalsIgnoreCase("xpath")) {
			return findByXpath(elementKey);
		} else if (elementType.equalsIgnoreCase("element_id")) {
			return findByElementId(elementKey);
		} else if (elementType.equalsIgnoreCase("element_name")) {
			return findByElementName(elementKey);
		} else {
			throw new Exception("Invalid Element Type");
		}
	}

	public WebElement findByXpath(String elementKey) {
		return getDriver().findElement(By.xpath(elementKey));
	}

	public WebElement findByElementId(String elementKey) {
		return getDriver().findElement(By.id(elementKey));
	}

	public WebElement findByElementName(String elementKey) {
//		return getDriver().findElement(By.name(elementKey));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(elementKey)));
	}

	public void view(String data) {
		wait.until(ExpectedConditions.titleContains(data));
	}

//	@FindBy(xpath = "//div[@class='col-md-9 ucase']")
//	private WebElement embossername;
//	@FindBy(id = "user-name")
//	private WebElement username;
//	// By username = By.id("user-name");
//	// By password= By.id("password");
//	@FindBy(id = "password")
//	private WebElement password;
//	@FindBy(id = "login-button")
//	private WebElement login;
//
//	@FindBy(xpath = "//div[@class=\"inventory_details_price\"]")
//	private WebElement priceElement;
//	private static String productName = "//div[@class=\"inventory_item_name\" and text()='%s']";
//	private static final Logger logger = LoggerFactory.getLogger(Page.class);
//
//	public void setuser(String Username) {
//		getDriver().manage().window().maximize();
//		$(username).type(Username);
//	}
//
//	public void setpassword(String Password) {
//		$(password).type(Password);
//	}
//
//	public void clickloginbtn() {
//		$(login).click();
//	}
//
//	public void verifyLogin() {
//		String actual = getDriver().getTitle();
//		String expected = "Swag Labs";
//		Assert.assertEquals(actual, expected);
//		logger.info("Expected title: " + expected + " is equal to the Actual title: " + actual
//				+ ". Successfully logged in to the Application");
//	}
//
//	public void cardSearch() {
//		String xpathExpression = "//a[text()='Card Search']";
//		String currentWindow = getDriver().getWindowHandle();
//		Set<String> allWindows = getDriver().getWindowHandles();
//		for (String window : allWindows) {
//			if (!window.contentEquals(currentWindow)) {
//				getDriver().switchTo().window(window);
//				break;
//			}
//		}
//		$(By.xpath(xpathExpression)).click();
//
//	}
//
//	public void selectProduct(String product) {
//		System.out.println($(String.format(productName, product)).getText());
//		$(String.format(productName, product)).click();
//	}
//
//	public String getProductPrice() {
//		return $(priceElement).getText();
//	}

}
