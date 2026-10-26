package rahulshettyacademy.test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import rahulshettyacademy.SeleniumFrameworkDesign.CartPage;
import rahulshettyacademy.SeleniumFrameworkDesign.CheckoutPage;
import rahulshettyacademy.SeleniumFrameworkDesign.ConfirmationPage;
import rahulshettyacademy.SeleniumFrameworkDesign.LandingPage;
import rahulshettyacademy.SeleniumFrameworkDesign.ProductCatalogue;
import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.TestComponent.Retry;

public class ErrorValidation extends BaseTest {

	@Test(groups= {"ErrorHandling"}, retryAnalyzer= Retry.class)
	public void LoginErrorValidation() throws InterruptedException, IOException {
		// TODO Auto-generated method stub

//		String productName = "ZARA COAT 3";

		landingPage.loginApplication("swetha25@gmail.com", "Setha@25");
		Assert.assertEquals("Incorrect email  password.", landingPage.getErrorMessage());

	}

	@Test
	public void ProductErrorValidation() throws InterruptedException, IOException {
		// TODO Auto-generated method stub

		String productName = "ZARA COAT 3";
		ProductCatalogue productCatalogue = landingPage.loginApplication("manoj08@gmail.com", "Manoj@08");
//		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyBooleanDisplay("ZARA COAT 33");
		Assert.assertFalse(match);
	}

}
