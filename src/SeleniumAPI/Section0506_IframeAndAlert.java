package SeleniumAPI;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Section0506_IframeAndAlert {
	WebDriver driver;

	@BeforeClass
	public void BeforeClass() {
//		System.setProperty("webdriver.chrome.driver", ".\\driver\\chromedriver.exe");
//		driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", ".\\driver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	//@Test
	public void handleIframe01() {
		// Navigate to page
		driver.get("http://the-internet.herokuapp.com/iframe");
		// Input value"ngoc" at TinyMCE iframe
		WebElement iframeTinyMCE = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
		driver.switchTo().frame(iframeTinyMCE);
		WebElement editTable = driver.findElement(By.xpath("//body[@id='tinymce']"));
		String textIframe = "Minh Ngoc";
		editTable.clear();
		editTable.sendKeys(textIframe);
		// Verify text inputed
		String expectedText = editTable.getText();
		Assert.assertEquals(expectedText, textIframe);
		// Out of iframe
		driver.switchTo().defaultContent();
		String txtTitle = driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();
		String expectedMsg = "An iFrame containing the TinyMCE WYSIWYG Editor";
		Assert.assertEquals(txtTitle, expectedMsg);
	}

	//@Test
	public void handleIframe02() throws InterruptedException {
		// Navigate to the page
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_input_disabled");
		// Check text box last name is disable
		WebElement iframeResult = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(iframeResult);
		Thread.sleep(3000);
		WebElement txtLast = driver.findElement(By.xpath("//input[@name='lname']"));
		txtLast.isDisplayed();
		// Input "ngoc" at First name
		String firstName = "ngoc";
		WebElement txtFirstName = driver.findElement(By.xpath("//input[@name='fname']"));
		txtFirstName.sendKeys(firstName);
		// Click submit button
		WebElement btnSubmit = driver.findElement(By.xpath("//input[@type='submit']"));
		btnSubmit.click();
		// Verify "ngoc" displayed
		Assert.assertEquals("fname=ngoc", "fname=" + firstName);

	}

	//@Test
	public void handleWithWindowPopup() {
		// Navigate to the page
		driver.get("https://www.seleniumeasy.com/test/window-popup-modal-demo.html");
		// Click button "Follow On Twitter > Open new tab/window > Switch new window
		WebElement txtFollow = driver.findElement(By.xpath("//a[contains(text(),'Follow On Twitter')]"));
		txtFollow.click();
		// Switch Twitter window and verify current title
		String twitterTitle = "Selenium Easy (@seleniumeasy) on Twitter";
		switchToWindowByTitle(twitterTitle);
		// Close current title
		driver.close();
		// Switch to parent title and verify the title
		String parentTitle = "Selenium Easy - Window Popup Modal Demo";
		switchToWindowByTitle(parentTitle);
		// Click button "Like us On Face"
		WebElement btnLike = driver.findElement(By.xpath("//a[contains(text(),'Like us On Facebook')]"));
		btnLike.click();
		// Switch Face window
		String faceTitle = "Selenium Easy - Trang chủ | Facebook";
		switchToWindowByTitle(faceTitle);
		// Close Face window
		driver.close();
		// Switch to parent window
		switchToWindowByTitle(parentTitle);
		// Verify parent title
		String expectedTitle = "Selenium Easy - Window Popup Modal Demo";
		Assert.assertEquals(parentTitle, expectedTitle);
	}

	//@Test
	public void normalAlert() throws InterruptedException {
		// Navigate Hero page
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		// Click "JS Alert" button
		WebElement btnJSAlert = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		btnJSAlert.click();
		// Verify message into Alert
		Alert alert = driver.switchTo().alert();
		String txtJSAlert = alert.getText();
		String expectedJSAlert = "I am a JS Alert";
		Assert.assertEquals(txtJSAlert, expectedJSAlert);
		// Accept alert and verify result message
		Thread.sleep(4000);
		alert.accept();
		String expectedResult = "You successfuly clicked an alert";
		String txtResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals(txtResult, expectedResult);
	}

	 //@Test
	public void hanldleAlertConfirm() {
		// Navigate to Hero site
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		// Click JS confirm
		WebElement btnJSConfirm = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		btnJSConfirm.click();
		// Verify message display
		Alert alert = driver.switchTo().alert();
		String txtJSConfirm = alert.getText();
		String expectedJSConfirm = "I am a JS Confirm";
		Assert.assertEquals(txtJSConfirm, expectedJSConfirm);
		// Cancel alert and verify message
		alert.dismiss();
		String txtCancel = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String expectedCancel = "You clicked: Cancel";
		Assert.assertEquals(txtCancel, expectedCancel);
	}

	//@Test
	public void handleAlertPrompts() throws InterruptedException {
		// Navigate to Hero site
		driver.get("http://the-internet.herokuapp.com/javascript_alerts");
		// Click JS prompt
		WebElement btnJSPrompt = driver.findElement(By.xpath("//button[text()='Click for JS Prompt']"));
		btnJSPrompt.click();
		// Verify message display
		Alert alert = driver.switchTo().alert();
		String txtJSPrompt = alert.getText();
		String expectedJSPrompt = "I am a JS prompt";
		Assert.assertEquals(txtJSPrompt, expectedJSPrompt);
		//Input text and verify message display
		Thread.sleep(4000);
		String lblPrompt = "MinhNgoc";
		alert.sendKeys(lblPrompt);
		alert.accept();
		Thread.sleep(4000);
		String actualPromptMsg = "You entered: MinhNgoc";
		String expectedPromptResult = driver.findElement(By.xpath("//p[@id='result']")).getText();
		Assert.assertEquals(actualPromptMsg, expectedPromptResult);
	}
	
	@Test
	public void handleJavaScript() {
		//Navigate to Guru page
		driver.get("http://live.guru99.com/");
		// Click My acc link
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebElement btnMyAcc = driver.findElement(By.xpath("//div[@class='footer-container']//a[text()='My Account']"));
		js.executeScript("arguments[0].click();", btnMyAcc);
		WebElement btnCreateAcc = driver.findElement(By.xpath("//span[text()='Create an Account']"));
		js.executeScript("arguments[0].click();", btnCreateAcc);
		
		
		
	}
	
	
	

	@AfterClass
	public void AfterClass() {
		//driver.close();

	}

	public void switchToWindowByTitle(String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String chidlWindows : allWindows) {
			driver.switchTo().window(chidlWindows);
			String childTitle = driver.getTitle();
			if (childTitle.equals(title)) {
				break;
			}
		}
	}
	
	public String randomemail() {
		Random rand = new Random();
		int number = rand.nextInt(9000000);
		String numberString = Integer.toString(number);
		return numberString;

	}

}
