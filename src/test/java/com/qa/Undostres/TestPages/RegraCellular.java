/*
 * Created By: Amit Kumar
 * Brief: This class contains test case related to the Regra Celular and validated that user is successfully landed to the payment page  
 *  
 */


package com.qa.Undostres.TestPages;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.Undostres.Base.UsdostresInitiation;

public class RegraCellular extends UsdostresInitiation {
	@Test(priority = 1)
	public static void RecargaCelular() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// validate that Recarga Celular field 'Numero de celular' is displayed & then
		// click at that field
		driver.findElement(By.xpath(prop.getProperty("Numero_de_celular1"))).isDisplayed();
		driver.findElement(By.xpath(prop.getProperty("Numero_de_celular1"))).isEnabled();
		driver.findElement(By.xpath(prop.getProperty("Numero_de_celular1"))).click();

		// Send test data from property file
		driver.findElement(By.xpath(prop.getProperty("Numero_de_celular1"))).sendKeys(prop.getProperty("CellNum"));
		driver.findElement(By.xpath(prop.getProperty("Operador"))).click();

		// Store the telecom company list and select 'Telcel'
		List<WebElement> Operador_list = driver.findElements(By.xpath(prop.getProperty("telcel_menulist")));
		int TotalCount_Operador_list = Operador_list.size();
		System.out.println(TotalCount_Operador_list);
		for (int i = 0; i < TotalCount_Operador_list; i++) {
			System.out.println(Operador_list.get(i).getText());
			if (Operador_list.get(i).getText().contains("Telcel")) {
				Operador_list.get(i).click();
				break;
			}
		}
		// Select 10 dollor recharges value
		driver.findElement(By.xpath(prop.getProperty("ten_dollor"))).click();
		// Click on the 'Siguiente' button
		driver.findElement(By.xpath(prop.getProperty("Siguiente"))).click();
		Thread.sleep(2000);

		// Fetch the current URL and validate the page
		String CurrentURL = driver.getCurrentUrl();
		System.out.println(CurrentURL);
		Assert.assertEquals(CurrentURL, prop.getProperty("PaymentPageURL"), "User is not landed on the payment Page");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.findElement(By.xpath(prop.getProperty("PaymentPageElements"))).isDisplayed();

	}
}
