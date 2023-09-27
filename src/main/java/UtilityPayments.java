
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class UtilityPayments {
    String MOBILE_SERVICE_URL = "https://next.privat24.ua/payments/dashboard";
    String IBAN = "UA333510050000026005325079000";
    String USER_CARD_NUMBER = "4552331448138217";
    String NAME = "Test";
    By iban = By.xpath("//input[@data-qa-node='query']");
    By stageProperties = By.xpath("//*[@id=\"app\"]/div[2]/section/div/div/div[2]/div[2]/div/div[2]/a");
    By sender = By.xpath("//*[@id=\"app\"]/div[2]/section/div/div/div[3]/div/form/div[1]/div[1]/div/div/div[2]/div/textarea[1]");
    By receiver = By.xpath("//*[@id=\"app\"]/div[2]/section/div/div/div[3]/div/form/div[2]/div/div/div/div[2]/div/textarea[1]");
    By taxCode = By.xpath("//*[@id=\"app\"]/div[2]/section/div/div/div[3]/div/form/div[3]/div/div/div/div[2]/div/textarea[1]");
    By amount = By.xpath("//input[@data-qa-node = 'SUM']");
    By cardNumber = By.xpath("//input[@data-qa-node = 'numberdebitSource']");
    By cardExpireDate = By.xpath("//input[@data-qa-node = 'expiredebitSource']");
    By cvv = By.xpath("//input[@data-qa-node = 'cvvdebitSource']");
    By submit = By.xpath("//*[@id=\"app\"]/div[2]/section/div/div/div[3]/div/form/div[9]/div[2]/button");
    By senderName = By.xpath("//input[@data-qa-node = 'firstNamedebitSource']");
    By senderSurname = By.xpath("//input[@data-qa-node = 'lastNamedebitSource']");
    By addToBasket = By.xpath("//*[@id=\"app\"]/div[2]/section/div/div/div[2]/div/div[8]/div[2]/button");
    By expectedPurpose = By.xpath("//div[@data-qa-node='category']");
    By expectedAmount = By.xpath("//div[@data-qa-node='amount']");


    @Test
    public void checkUtilityPayments(){
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(MOBILE_SERVICE_URL);
        driver.findElement(iban).sendKeys(IBAN);
        driver.findElement(stageProperties).click();
        driver.findElement(sender).sendKeys(NAME);
        driver.findElement(receiver).sendKeys(NAME);
        driver.findElement(taxCode).sendKeys("12345678");
        driver.findElement(amount).sendKeys("100");
        driver.findElement(cardNumber).sendKeys(USER_CARD_NUMBER);
        driver.findElement(cardExpireDate).sendKeys("12/25");
        driver.findElement(cvv).sendKeys("123");
        driver.findElement(senderName).sendKeys(NAME);
        driver.findElement(senderSurname).sendKeys(NAME);
        driver.findElement(submit).submit();
        driver.findElement(addToBasket).click();

        Assert.assertEquals("Комунальні та інші платежі", driver.findElement(expectedPurpose).getText());
        Assert.assertEquals("100 UAH", driver.findElement(expectedAmount).getText());
    }


}
