package bt_locator_tuongdoi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LearningLocators_Employees {
    public static void main(String[] args) throws InterruptedException {

        //Save xpath into variables String

        String username = "//input[@id='iusername']";
        String password = "//input[@id='ipassword']";
        String loginButton = "//button[@type='submit']";

        //Cách 6: Xác định với Tổ tiên Ancestor
        String employeesMenu = "//*[normalize-space()='Employees']/ancestor::a";
        String addNewButton = "//*[@class='feather feather-plus']/ancestor::a";


        //Cách 7: Xác định với Con cháu Descendant
        String info = "//*[@class='row']";
        String firstnameField = info + "/descendant::input[@name='first_name']";
        String lastnameField = info + "/descendant::input[@name='last_name']";


        //Cách 8: Xác định thông qua following
        String employeeidField = lastnameField + "/following::input[@name='employee_id']";
        String contactnoField = lastnameField + "/following::input[@name='contact_number']";
        String genderField = lastnameField + "/following::span[contains(@id,'gender')]";

        //Cách 9: Xác định Anh chị em bên dưới với following-sibling và preceding-sibling
        String femaleOption = "//*[@role='option']/following-sibling::li";
        String maleOption = "//*[@role='option']/preceding-sibling::li";

        String resetButton = "//*[contains(.,'Reset')]";
        String saveButton = resetButton + "/following-sibling::button";

        //Cách 10: Xác định thông qua parent và child
        String shift = "//*[contains(@id,'shift')]";
        String officeShiftField = shift + "/parent::*";
        String morningOption = shift + "/child::li[contains(.,'Morning')]";
        String eveningOption = shift + "/child::li[contains(.,'Evening')]";

        String role = "//*[contains(@id,'role')]";
        String roleField = role + "/parent::span";
        String generalOption = role + "/child::li[contains(.,'General')]";
        String headOption = role + "/child::li[contains(.,'Head')]";
        String HROption = role + "/child::li[contains(.,'HR')]";

        String department = "//*[contains(@id,'department')]";
        String departmentField = department + "/parent::span";
        String salesOption = department + "/child::li[contains(.,'Sales')]";

        String designation = "//*[contains(@id,'design')]";
        String designationField = designation + "/parent::span";
        String GMOption = designation + "/child::li";

        String salay = "//*[contains(@id,'salay')]";
        String paysliptypeField = salay + "/parent::span";
        String salayOption = salay + "/child::li";

        //Cách 8: Xác định thông qua preceding
        String emailField = shift + "/preceding::input[@name='email']";
        String usernameField = shift + "/preceding::input[@name='username']";
        String passwordField = shift + "/preceding::input[@name='password']";

        String salaryField = salay + "/preceding::input[@name='basic_salary']";
        String rateField = salay + "/preceding::input[@name='hourly_rate']";


        //Create browser by Chrome
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Open eCommerce web
        driver.get("https://app.hrsale.com/");
        Thread.sleep(1000);

        //Login with correct username and password
        driver.findElement(By.xpath(username)).sendKeys("frances.burns");
        Thread.sleep(1000);

        driver.findElement(By.xpath(password)).sendKeys("frances.burns");
        Thread.sleep(1000);

        driver.findElement(By.xpath(loginButton)).click();
        Thread.sleep(5000);


        //Open Employees item in navigation menu
        driver.findElement(By.xpath(employeesMenu)).click();
        Thread.sleep(1000);

        //Scroll down web to find Add new button
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(1000);

        //Open form Add new
        driver.findElement(By.xpath(addNewButton)).click();
        Thread.sleep(1000);

        //Fill form "Add New Employee"
        //Enter First Name Last Name field
        driver.findElement(By.xpath(firstnameField)).sendKeys("Alan");
        driver.findElement(By.xpath(lastnameField)).sendKeys("Walker");
        Thread.sleep(1000);

        //Enter Employee ID
        driver.findElement(By.xpath(employeeidField)).clear();
        driver.findElement(By.xpath(employeeidField)).sendKeys("123");
        Thread.sleep(1000);

        //Enter Contact Number
        driver.findElement(By.xpath(contactnoField)).sendKeys("04567");
        Thread.sleep(1000);

        //Select Gender = Female
        driver.findElement(By.xpath(genderField)).click();
        driver.findElement(By.xpath(femaleOption)).click();
        Thread.sleep(1000);

        //Enter Email
        driver.findElement(By.xpath(emailField)).sendKeys("k@v.com");
        Thread.sleep(1000);

        //Enter Username
        driver.findElement(By.xpath(usernameField)).sendKeys("tester");
        Thread.sleep(1000);

        //Enter Password
        driver.findElement(By.xpath(passwordField)).sendKeys("123456");
        Thread.sleep(1000);

        //Select Office Shift
        driver.findElement(By.xpath(officeShiftField)).click();
        driver.findElement(By.xpath(eveningOption)).click();
        Thread.sleep(1000);

        //Select Role
        driver.findElement(By.xpath(roleField)).click();
        driver.findElement(By.xpath(HROption)).click();
        Thread.sleep(1000);

        //Select Department
        driver.findElement(By.xpath(departmentField)).click();
        driver.findElement(By.xpath(salesOption)).click();
        Thread.sleep(1000);

        //Select Designation
        driver.findElement(By.xpath(designationField)).click();
        driver.findElement(By.xpath(GMOption)).click();
        Thread.sleep(1000);

        //Enter Basic Salary
        driver.findElement(By.xpath(salaryField)).clear();
        driver.findElement(By.xpath(salaryField)).sendKeys("100");
        Thread.sleep(1000);

        //Enter Hourly Rate
        driver.findElement(By.xpath(rateField)).clear();
        driver.findElement(By.xpath(rateField)).sendKeys("5");
        Thread.sleep(1000);

        //Select Payslip Type
        driver.findElement(By.xpath(paysliptypeField)).click();
        driver.findElement(By.xpath(salayOption)).click();
        Thread.sleep(1000);

        //Click Save button
        driver.findElement(By.xpath(saveButton)).click();
        Thread.sleep(2000);

        //Close browser
        driver.quit();
    }
}
