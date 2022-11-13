package bt_WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
        public static WebDriver driver;
        //Khoi tao browser
        public static void createDriver(){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        //Login https://app.hrsale.com/
        public static void loginHRSale(){
            //Open eCommerce web
            driver.get("https://app.hrsale.com/");
            sleep(1);
            //Login with Super Admin
            driver.findElement(By.xpath("//button[text()='Super Admin']")).click();
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).submit();
            sleep(1);
        }

        //Dong browser
        public static void closeDriver(){
            sleep(2);
            driver.quit();
        }

        //Sleep web
        public static void sleep(double seconds){
            try {
                Thread.sleep((long) (1000 * seconds)); //chuyen ve so nguyen
            } catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }
    }
