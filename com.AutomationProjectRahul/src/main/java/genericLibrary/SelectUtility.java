package genericLibrary;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtility {
	public void selectByVisibleTextMethod(WebElement dropDown,String text) 
	{
		Select sl=new Select(dropDown);
		sl.selectByVisibleText(text);
		
	}

}
