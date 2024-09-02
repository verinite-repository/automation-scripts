package pages.demosite;

import org.openqa.selenium.support.ui.ExpectedConditions;

import Utils.PropertyFileReader;
import net.serenitybdd.annotations.Step;

public class Screen {

	PropertyFileReader prop = new PropertyFileReader("src/test/resources/config.properties");

	Page page;

	@Step
	public void open(String user, String elementKey) {
//		String eleValue = elementKey + "_" + elementType;
		if (prop.getProperty(elementKey) != null) {
			page.openPage(prop.getProperty(elementKey));
		}
	}

	@Step
	public void update(String value, String elementType, String elementKey) throws Exception {
		String eleValue = elementKey + "_" + elementType;
		if (prop.getProperty(eleValue) != null) {
//			page.updateByXpath(value, elementType, prop.getProperty(eleValue));
		}
	}

	@Step
	public void select(String elementType, String elementKey) throws Exception {
		page.get(elementType, elementKey);
	}

	@Step
	public void click(String elementKey) throws Exception {
		if (prop.getProperty(elementKey) != null) {
			page.click(prop.getProperty(elementKey));
		}
		
	}

	@Step
	public void verify(String elementKey, String elementValue) throws Exception {
		page.get(null, null);
	}

	@Step
	public void updateByElementName(String data, String elementName) throws Exception {
		if (prop.getProperty(elementName) != null) {
			page.updateByElementName(data, prop.getProperty(elementName));
		}
	}

	@Step
	public void view(String data) {
		page.view(data);
	}

//	@Step
//	public void openApplication() {
//		loginScreenPage.open();
//		long maxWaitTime = 5000; // maximum wait 5Sec time
//		long startTime = System.currentTimeMillis();
//		while (System.currentTimeMillis() - startTime < maxWaitTime) {
//			if (loginScreenPage.getDriver().getCurrentUrl().equals(DemoLoginPage.getDefaultUrl())) {
//				break;
//			}
//			try {
//				Thread.sleep(2000); // 2 seconds
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//
//	@Step
//	public void login(String username, String password) {
//		loginScreenPage.setuser(username);
//		loginScreenPage.setpassword(password);
//		loginScreenPage.clickloginbtn();
//		loginScreenPage.verifyLogin();
//
//	}
//
//	@Step
//	public void selectProduct(String product) {
//		loginScreenPage.selectProduct(product);
//	}
//
//	@Step
//	public void verifyPriceofElement(String price) {
//		System.out.println(loginScreenPage.getProductPrice());
//		Assert.assertEquals("Actual Product price is not equal to :$" + price, "$" + price,
//				loginScreenPage.getProductPrice());
//
//	}

}
