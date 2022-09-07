package stepdef;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginDef {
	
	WebDriver d;
	@Given("If user on homepage")
	public void if_user_on_homepage() {
		d=new FirefoxDriver();
		//d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
		d.manage().timeouts().pageLoadTimeout(5, TimeUnit.MINUTES);
		d.manage().window().maximize();
		d.get("https://demo.cyclos.org/ui/home");
	}

	@When("Click on login link")
	public void click_on_login_link() {
		d.findElement(By.xpath("//a[@id='login-link']")).click();
	}

	@When("Enter login details")
	public void enter_login_details() throws Exception {
		d.findElement(By.xpath("//input[@type='text']")).clear();
		d.findElement(By.xpath("//input[@type='text']")).sendKeys("demo5");
		d.findElement(By.xpath("//input[@type='password']")).clear();
		d.findElement(By.xpath("//input[@type='password']")).sendKeys("1235");
		d.findElement(By.xpath("//button[contains(.,'Submit')]")).click();
		Thread.sleep(2000);
	}
	@Then("Click on QR Code")
	public void click_on_qr_code() throws Exception {
	    d.findElement(By.linkText("Receive QR-code payment")).click();
	    Thread.sleep(2000);
	}

	@Then("Enter the amount")
	public void enter_the_amount() {
	    d.findElement(By.xpath("//input")).sendKeys("50");	    
	}

	@When("Click on next")
	public void click_on_next() throws Exception {
	    d.findElement(By.xpath("//button[contains(.,'Next')]")).click();
	    Thread.sleep(2000);
	}

	@Then("Verify the payment")
	public void verify_the_payment() {
	    assertTrue(d.findElement(By.xpath("//receive-qr-payment-step-pending/div/img")).isDisplayed());
	}

	@Then("Verify logout button")
	public void verify_logout_button() {
		assertTrue(d.findElement(By.id("logout-trigger")).isDisplayed());
		d.quit();
	}


}
