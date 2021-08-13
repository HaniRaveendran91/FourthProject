package com.samp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AdactinHotel {
	@Test(dataProvider="AdactinSearch")
	public void booking(String location,String hotel,String roomNo,String checkIn,String checkOut,String adultsNO,String child,String frstName,String lastName,String address,String creditCrdNo,String cardType,String month,String year,String cvv) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		
		driver.findElement(By.id("username")).sendKeys("prahathees");
		driver.findElement(By.id("password")).sendKeys("12345abcd");
		driver.findElement(By.id("login")).click();
		
		driver.findElement(By.id("location")).sendKeys(location);
		driver.findElement(By.id("hotels")).sendKeys(hotel);
		driver.findElement(By.id("room_nos")).sendKeys(roomNo);
		driver.findElement(By.id("datepick_in")).sendKeys(checkIn);
		driver.findElement(By.id("datepick_out")).sendKeys(checkOut);
		driver.findElement(By.id("adult_room")).sendKeys(adultsNO);
		driver.findElement(By.id("child_room")).sendKeys(child);
		
		driver.findElement(By.id("Submit")).click();
		
		driver.findElement(By.id("radiobutton_1")).click();
		driver.findElement(By.id("continue")).click();
		
		driver.findElement(By.id("first_name")).sendKeys(frstName);
		driver.findElement(By.id("last_name")).sendKeys(lastName);
		driver.findElement(By.id("address")).sendKeys(address);
		driver.findElement(By.id("cc_num")).sendKeys(creditCrdNo);
		driver.findElement(By.id("cc_type")).sendKeys(cardType);
		driver.findElement(By.id("cc_exp_month")).sendKeys(month);
		driver.findElement(By.id("cc_exp_year")).sendKeys(year);
		driver.findElement(By.id("cc_cvv")).sendKeys(cvv);
		
		driver.findElement(By.id("book_now")).click();
		
		Thread.sleep(6000);
		WebElement element = driver.findElement(By.id("order_no"));
		String string = element.getAttribute("value");
		System.out.println(string);
		
		driver.quit();
		driver.findElement(By.id("username")).sendKeys("prahathees");
		driver.findElement(By.id("password")).sendKeys("12345abcd");
		driver.findElement(By.id("login")).click();
		
		

		
		
		 
		
		
		
		
		
		
		



	}
	
	
	
	
	
	
	@DataProvider(name="AdactinSearch")
	
	public Object[][] search() {
		return new Object[][] {
			{"Sydney","Hotel Creek","1 - One","20/08/2021","21/08/2021","1 - One","1 - One","Hani","Raveendran","Kerala","1234567890123456","Master Card","August","2022","322"},
			{"London","Hotel Sunshine","2 - Two","22/08/2021","24/08/2021","2 - Two","2 - Two","Vishnu","Raveendran","Chennai","1233567890123853","VISA","May","2021","122"},
			{"Paris","Hotel Harvey","3 - Three","25/08/2021","26/08/2021","3 - Three","3 - Three","Sobhana","Raveendran","London","1233566890123858","American Express","December","2019","152"},
			{"Now York","Hotel Cornice","4 - Four","27/08/2021","28/08/2021","4 - Four","4 - Four","Ravi","Raveendran","Eriyad","1233567830123952","VISA","June","2018","192"}
			
		};
		

	}

}
