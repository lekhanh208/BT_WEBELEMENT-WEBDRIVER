package bt_WebElement;

import bt_locator_tuyetdoi.LearningLocators;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AddNewProject extends LearningLocators {
    public static void main(String[] args) {
        //Create browser by Chrome
        createDriver();
        //Login
        loginHRSale();
        //Open Project item in navigation menu
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement projectElement = driver.findElement(By.xpath(projectMenu));
        js.executeScript("arguments[0].scrollIntoView(true)", projectElement);
        sleep(1);
        projectElement.click();
        sleep(1);

        //Scroll down web to find Add new project button
        js.executeScript("window.scrollBy(0,250)", "");
        sleep(1);

        //Open form Add new project
        driver.findElement(By.xpath(addProjectButton)).click();
        sleep(1);

        //Fill form "Add New Project"
        //Enter Tittle field
        driver.findElement(By.xpath(titleField)).sendKeys("Selenium");
        sleep(1);

        //Select Client = Cedric Kelly
        driver.findElement(By.xpath(clientField)).click();
        driver.findElement(By.xpath(clientOption)).click();
        sleep(1);

        //Enter Estimated Hour
        driver.findElement(By.xpath(estimatedHourField)).sendKeys("8");
        sleep(1);

        //Select Priority = High
        driver.findElement(By.xpath(priorityField)).click();
        driver.findElement(By.xpath(priorityOption)).click();
        sleep(1);

        //Select Start Date
        driver.findElement(By.xpath(startdateField)).click();
        driver.findElement(By.xpath("/html/body/div[9]/div/div[1]/div[3]/div[1]/table/tbody/tr[5]/td[3]/a")).click();
        driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/button[4]")).click();
        sleep(1);

        //Select End Date
        driver.findElement(By.xpath(enddateField)).click();
        driver.findElement(By.xpath("/html/body/div[10]/div/div[1]/div[3]/div[1]/table/tbody/tr[5]/td[7]/a")).click();
        driver.findElement(By.xpath("/html/body/div[10]/div/div[2]/button[4]")).click();
        sleep(1);

        //Enter Summary
        driver.findElement(By.xpath(summaryField)).sendKeys("Automation test");
        sleep(1);

        //Click Save button
        driver.findElement(By.xpath(saveButton)).click();

        //Close browser
        closeDriver();
    }
    }
