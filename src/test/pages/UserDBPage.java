package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utils.ConfigReader;


public class UserDBPage extends HomePage {
    protected WebDriver driver;

    public UserDBPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void userInfo(){
        String filePath = "src/test/data/config/configuration.properties";
        UserDBPage userDBPage = new UserDBPage(driver);
        userDBPage.sendKeys(firstName, ConfigReader.readProperty(filePath, "firstName"));
        userDBPage.sendKeys(lastName, ConfigReader.readProperty(filePath, "lastName"));
        userDBPage.sendKeys(phone, ConfigReader.readProperty(filePath, "phone"));
        userDBPage.sendKeys(phone, ConfigReader.readProperty(filePath, "email"));

        Select select = new Select(role);
        select.selectByVisibleText(ConfigReader.readProperty(filePath, "role"));

        userDBPage.click(submitBtn);
    }
    @FindBy(xpath = "//a[text()='User-Mgt']")
    public WebElement userMtgBtn;

    @FindBy (xpath = "//a[text()='Access DB']")
    public WebElement accessDB;

    @FindBy (name = "Firstname")
    public WebElement firstName;

    @FindBy (name = "Lastname")
    public WebElement lastName;

    @FindBy (name = "Phonenumber")
    public WebElement phone;

    @FindBy (name = "Email")
    public WebElement email;

    @FindBy (id = "Select-role")
    public WebElement role;

    @FindBy (xpath = "//button[text()='Submit']")
    public WebElement submitBtn;

}
