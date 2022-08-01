/*
 * Created By: Amit Kumar 
 * this class contains test class related to payment Page
 * 
 */
package com.qa.Undostres.TestPages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.qa.Undostres.Base.UsdostresInitiation;

public class Payments extends UsdostresInitiation {

	@Test(priority = 3)
	public static void PaymentPage() throws InterruptedException {

		// implicit wait for loading of web elements
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Check whether Tarhet element is visible or not
		driver.findElement(By.xpath(prop.getProperty("Tarhet_DD"))).isDisplayed();
		driver.findElement(By.xpath(prop.getProperty("Tarhet_DD"))).click();
		Thread.sleep(1000);

		// Wait for element 'User Nueva Tarjeta' to be adapt click able nature then
		// click on it
		new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(By.xpath(prop.getProperty("UserNuevaTarjeta"))));
		driver.findElement(By.xpath(prop.getProperty("UserNuevaTarjeta"))).click();
		Thread.sleep(1000);

		// Wait for element 'Card Number' to be adapt click able nature then send card
		// related card in the respective fields
		WebElement ele = driver.findElement(By.xpath(prop.getProperty("Card_Num")));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf((WebElement) ele));
		driver.findElement(By.xpath(prop.getProperty("Card_Num"))).sendKeys(prop.getProperty("Card_number"));
		driver.findElement(By.xpath(prop.getProperty("Month"))).sendKeys(prop.getProperty("month"));
		driver.findElement(By.xpath(prop.getProperty("Year"))).sendKeys(prop.getProperty("date"));
		driver.findElement(By.xpath(prop.getProperty("CVV"))).sendKeys(prop.getProperty("cvv"));
		driver.findElement(By.xpath(prop.getProperty("emailID"))).sendKeys(prop.getProperty("correo_electronico"));

		// Click on the payment button
		driver.findElement(By.xpath(prop.getProperty("PaymentBtn"))).click();

		// Handle the visbility of the window generated pop up having title 'Para pagar
		// por favor Regístrate o Ingresa a tu cuenta'
		/*
		 * Note: The function HandleWinowPopUP() doesnot supports to handle the
		 * 'Captcha' checkbox due the following reason: As per the selenium webdriver
		 * official site it is not advised to automate captcha if some one wants to do
		 * it then some prerequisites or suggestion are provided in the documentation
		 * {documentation URL:
		 * https://www.selenium.dev/documentation/test_practices/discouraged/captchas/ }
		 */
		try {
			HandleWinowPopUP();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			CheckPaymentDone();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
