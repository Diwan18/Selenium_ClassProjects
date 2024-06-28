package week5Assignments.LeafTaps;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import week5.day2.ReadExcelSheet;

public class CreateLead extends BaseClass{
	
	@DataProvider(name="GetValue")
	public String[][] data() throws IOException{
		

		
		return ExcelAssignment.ReadExcel();
		
		
		
	}
	
	
	
	
	

	
		@Test(dataProvider="GetValue")
		public  void ToGetLeads(String cname , String  fname , String lName , String phNo) {
		
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys(cname);
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys(fname);
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lName);
			driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phNo);
			driver.findElement(By.name("submitButton")).click();
			String text = driver.findElement(By.id("viewLead_companyName_sp")).getText();
			if (text.contains("Testleaf")) {
				System.out.println("Lead created successfully");
			}
			else {
				System.out.println("Lead is not created");
			}
			


		}

	}


	


