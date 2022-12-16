package demo.spring.selenium.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class UploadPage {
    @FindBy(xpath = "//*[@id=\"content\"]/div[1]/h3")
    WebElement header;
    @FindBy(name = "file")
    WebElement buttonChooseFile;

    @FindBy(xpath = "//*[@id=\"file-submit\"]")
    WebElement buttonUpload;

    public UploadPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    public void verifyHeader(){
        Assertions.assertTrue(header.isDisplayed());
    }

    public void clickChooseFile() {
        buttonChooseFile.click();
    }

    public void clickUpload() {
        buttonUpload.click();
    }
}
