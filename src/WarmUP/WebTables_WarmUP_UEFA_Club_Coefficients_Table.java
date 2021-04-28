package WarmUP;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class WebTables_WarmUP_UEFA_Club_Coefficients_Table {


    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DERDASH\\Desktop\\DUO TECH\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

// 1. Go to https://www.uefa.com/
        driver.get("https://www.uefa.com/");
        Thread.sleep(1000);

// 2. click on "Full standings" button for Club coefficients (not Association club coefficients )
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[@class='btn btn-secondary ranking-button ']")).click();
        Thread.sleep(1000);

// 3. Please select Country

        String country = "ESP";

// 4. Get list of teams from Selected Country
        List<WebElement> row = driver.findElements(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr"));

        int teamsCount  = 0, countryTeam = 0;
        List<String> teams = new ArrayList<>();

        for (WebElement webElement : row) {
            teamsCount++;
            if ( webElement.getText().contains(country) ){
                countryTeam++;
                System.out.println("Team name:         " + webElement.findElement(By.className("table_member-name")).getText());
                System.out.println("Team total points: " + webElement.findElement(By.className("table_member-points")).getText());
                System.out.println("Position:          " + webElement.findElement(By.className("position")).getText());
                 System.out.println("************");System.out.println();
            }        }

        System.out.println(country + " teams are " + countryTeam);
        System.out.println("Total teams "+ teamsCount   );
    }}
