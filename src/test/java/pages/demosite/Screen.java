package pages.demosite;

import net.serenitybdd.annotations.Step;
import org.junit.Assert;

import Utils.PropertyFileReader;

public class Screen {

	PropertyFileReader prop = new PropertyFileReader("src/test/resources/config.properties");

	Page page;

	@Step
	public void open(String elementType, String elementKey) {
		page.open();
	}

	@Step
	public void update(String value, String elementType, String elementKey) throws Exception {
		page.update(value, elementType, elementKey);
	}

	@Step
	public void select(String elementType, String elementKey) throws Exception {
		page.get(elementType, elementKey);
	}

	@Step
	public void click(String elementKey, String elementValue) throws Exception {
		page.click(elementValue, elementKey);
	}

	@Step
	public void verify(String elementKey, String elementValue) throws Exception {
		page.get(null, null);
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
