package com.qa.Undostres.TestPages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.qa.Undostres.Base.UsdostresInitiation;

public class UndostresVarification extends UsdostresInitiation {
	@Test(priority = 0)
	public static void VerifyHomePage() {
		try {
			// Launch browser and navigate to the Undestros applicaion
			setUp();

			// Validate that use is successfully navigated to the home page
			driver.findElement(By.xpath("//img[@id='undostres_logo']")).isDisplayed();
			System.out.println("User successfully Entered into the Home Page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
