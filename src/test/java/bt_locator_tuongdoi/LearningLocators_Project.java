package bt_locator_tuongdoi;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LearningLocators_Project {
    public static void main(String[] args) throws InterruptedException {

        //Save xpath into variables String

        //Cách 1: Xác định bằng thuộc tính "@"
        String username = "//input[@id='iusername']";
        String password = "//input[@id='ipassword']";
        String loginButton = "//button[@type='submit']";

        //Cách 2: Xác định bằng chuỗi text() nhưng dùng normalize-space
        String projectMenu = "//span[normalize-space()='Projects']";
        //Cách 2: Xác định bằng chuỗi text()
        String priorityField = "//span[text()='Highest']";

        //Cách 3: Xác định với hàm chứa contains() và dùng thuộc tính
        String addProjectButton = "//a[contains(@class, 'btn waves-effect')]";
        String titleField = "//input[contains(@name,'title')]";
        //Cách 3: Xác định với hàm chứa contains() và dùng text()/normalize-space
        String clientField = "//span//span[contains(text(),'Client')]";
        String saveButton = "//span[contains(normalize-space(),'Save')]";

        //Cách 4: Xác định với phương thức Bắt đầu starts-with và dùng thuộc tính
        String estimatedHourField = "//input[starts-with(@name,'budget')]";
        //Cách 4: Xác định với phương thức Bắt đầu starts-with và dùng text()/normalize-space
        String clientOption = "//li[starts-with(normalize-space(),'Ced')]";
        String priorityOption = "//li[starts-with(text(),'Normal')]";

        //Cách 5: Xác định bằng cách sử dụng toán tử or và and
        String startdateField = "//*[@class='form-control date' and @name= 'start_date']";
        String enddateField = "//*[@class='form-control date' and @name= 'end_date']";
        String summaryField = "//*[@id='summary' or @name='summary']";

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


        //Open Project item in navigation menu
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement projectElement = driver.findElement(By.xpath(projectMenu));
        js.executeScript("arguments[0].scrollIntoView(true)", projectElement);
        Thread.sleep(1000);
        projectElement.click();
        Thread.sleep(1000);

        //Scroll down web to find Add new project button
        js.executeScript("window.scrollBy(0,250)", "");
        Thread.sleep(1000);

        //Open form Add new project
        driver.findElement(By.xpath(addProjectButton)).click();
        Thread.sleep(1000);

        //Fill form "Add New Project"
        //Enter Tittle field
        driver.findElement(By.xpath(titleField)).sendKeys("Selenium");
        Thread.sleep(1000);

        //Select Client = Cedric Kelly
        driver.findElement(By.xpath(clientField)).click();
        driver.findElement(By.xpath(clientOption)).click();
        Thread.sleep(1000);

        //Enter Estimated Hour
        driver.findElement(By.xpath(estimatedHourField)).sendKeys("8");
        Thread.sleep(1000);

        //Select Priority = High
        driver.findElement(By.xpath(priorityField)).click();
        driver.findElement(By.xpath(priorityOption)).click();
        Thread.sleep(1000);

        //Select Start Date
        driver.findElement(By.xpath(startdateField)).click();
        driver.findElement(By.xpath("//*[.='18']")).click();
        driver.findElement(By.xpath("//*[.='OK']")).click();
        Thread.sleep(1000);

        //Select End Date
        driver.findElement(By.xpath(enddateField)).click();
        driver.findElement(By.xpath("//div[10]//*[.='24']")).click();
        driver.findElement(By.xpath("//div[10]//*[.='OK']")).click();
        Thread.sleep(1000);

        //Enter Summary
        driver.findElement(By.xpath(summaryField)).sendKeys("Automation test");
        Thread.sleep(1000);

        //Click Save button
        driver.findElement(By.xpath(saveButton)).click();
        Thread.sleep(2000);

        //Close browser
        driver.quit();
    }
}
