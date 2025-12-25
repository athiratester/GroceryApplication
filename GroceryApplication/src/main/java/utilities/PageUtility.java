package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class PageUtility {
	
	public void selectDropDownWithValue(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByValue(value);
	}
	
	public void selectDropDownDWithIndex(WebElement element, int index) {
		Select object=new Select(element);
		object.selectByIndex(index);
	}
	public void selectDropDownWithVisibleText(WebElement element, String value) {
		Select object=new Select(element);
		object.selectByVisibleText(value);
	}
	public void selectCheckBox(WebElement element) {
		
		element.click();	}
	
    public void selectRadioButton(WebElement element) {
		
    	element.click();
	}
    public void simpleAlert(WebElement simple,WebDriver driver) {
    	simple.click();
		Alert a= driver.switchTo().alert();
		a.accept();
    }
    
    public void acceptAlert(WebElement confirm,WebDriver driver) {
        confirm.click();
        Alert a= driver.switchTo().alert();
		a.dismiss();
    }
    
    public void Promptlert(WebElement prompt,WebDriver driver) {
    	prompt.click();
    	Alert a=driver.switchTo().alert();
    	a.sendKeys("haiii");
    	a.accept();
    }
    
    public void verifyScrollDown(WebElement element,WebDriver driver) {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0,350)", "");
    }
    public void verifyScrollUp(WebElement element,WebDriver driver) {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollBy(0,-350)", "");
    }
    public void verifyScrollTo(WebElement element,WebDriver driver) {
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("window.scrollTo(0,-350)", "");
    }
    
    public void verifyRightclick(WebElement element,WebDriver driver)
	{
		
		Actions ac= new Actions(driver);
        ac.contextClick(element).build().perform();
	}
    public void verifyMouseHover(WebElement element,WebDriver driver)
	 {
		
		 Actions ac= new Actions(driver);
		 ac.moveToElement(element).build().perform();
	 }
	 
	 public void verifyDragAndDrop(WebElement drag,WebElement drop,WebDriver driver)
	 {
		
		 Actions ac= new Actions(driver);
		 ac.dragAndDrop(drag, drop).build().perform();
	 }
	 
	 public void verifyKeyBoardActions() throws AWTException
	 {
		 Robot keybrd=new Robot();
		
		 keybrd.keyPress(KeyEvent.VK_CONTROL) ;
		 keybrd.keyPress(KeyEvent.VK_T);
		 keybrd.keyRelease(KeyEvent.VK_CONTROL);
		 keybrd.keyRelease(KeyEvent.VK_T);
     }
	 
	 public void verifyTables(WebElement table)
	 {
		 table.getText();
	 }
	 public void verifyTableHead(WebElement tablehead)
	 {
		 tablehead.getText();
	 }
	 public void verifyTableData(WebElement tabledata)
	 {
		 tabledata.getText();
	 } 
	 public void verifyFrame(WebElement frame, WebDriver driver)
	 {
			
		 driver.switchTo().frame(frame);
		
	 }
	 public void verifyFileUploadUsingSendKeys(WebElement chsfile,WebElement ck,WebElement submit)
		{
			
			chsfile.sendKeys("C:\\Users\\91884\\OneDrive\\Desktop\\java project\\Automationcourse\\src\\test\\resources\\testfilepf.pdf");
			ck.click();
			submit.click();
		}
		
		public void verifyFileUploadUsingRobotClass(WebElement slctpdf) throws AWTException
		{
			
			slctpdf.click();
			StringSelection ss = new StringSelection("C:\\Users\\91884\\OneDrive\\Desktop\\java project\\Automationcourse\\src\\test\\resources\\testfilepf.pdf");
		    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss,null );
		   
			Robot r=new Robot();
			r.delay(2500);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_V);
			r.keyRelease(KeyEvent.VK_CONTROL);
			r.keyRelease(KeyEvent.VK_V);
			r.keyPress(KeyEvent.VK_ENTER);
			r.keyRelease(KeyEvent.VK_ENTER);
		}

	}
