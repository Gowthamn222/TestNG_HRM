package page.objects.hrm;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.driver.test.BaseDriver;
import utilities.Constants;

public class DashboardPage extends Driver {

	public DashboardPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[text()='Apply Leave']")
	WebElement applyLeaveLink;
	
	@FindBy(id = "applyleave_txtLeaveType")
	WebElement leaveType;
	
	@FindBy(id = "applyleave_txtFromDate")
	WebElement fromDate;
	
	@FindBy(id = "applyleave_txtToDate")
	WebElement toDate;
	
	@FindBy(id = "applyleave_txtComment")
	WebElement comment;
	
	@FindBy(id = "applyBtn")
	WebElement applyButton;
	
	@FindBy(id = "menu_leave_viewMyLeaveList")
	WebElement myLeaveLink;
	
	@FindBy(id = "calFromDate")
	WebElement calFromDate;
	
	@FindBy(id = "calToDate")
	WebElement calToDate;

	@FindBy(id = "btnSearch")
	WebElement searchButton;
	
	@FindBy(id = "menu_dashboard_index")
	WebElement dashboardLink;
	
	@FindBy(xpath = "//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']")
	WebElement todayDate;
	
	@FindBy(xpath = "//input[@id='applyleave_txtFromDate']/following-sibling::img")
	WebElement fromDateCalendar;
	
	public void clickOnApplyLeaveLink() {
		
		dashboardLink.click();
		applyLeaveLink.click();
	}
	
	public void applyLeave() throws InterruptedException {
		
		Select leave = new Select(leaveType);
		leave.selectByValue("1");
			
		fromDateCalendar.click();
		todayDate.click();
		
		
		comment.sendKeys(Constants.Leave_Comment);
		
		Thread.sleep(3000);
		
		applyButton.click();
	}
	
	public void myLeave() {
		
		myLeaveLink.click();
		
		calFromDate.clear();
		calFromDate.sendKeys("2020-10-03");
		calFromDate.sendKeys(Keys.ENTER);
		
		calToDate.clear();
		calToDate.sendKeys("2020-10-03");
		calToDate.sendKeys(Keys.ENTER);
		
		searchButton.click();
	}
}
