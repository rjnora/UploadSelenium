package demo.spring.selenium.stepdefinitions;

import demo.spring.selenium.pages.UploadPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

public class UploadPageSteps {
    @Autowired
    private UploadPage uploadPage;

    String fileName;

    @Given("^I open website Upload Heroku$")
    public void iOpenUploadPage(){
        uploadPage.verifyHeader();
    }

    @When("I click choose file")
    public void iChooseFile() {
        uploadPage.clickChooseFile();
    }

    @Then("I upload files")
    public void iUploadFiles() {
        chooseFile.sendKeys(""+fileName);
    }

    @Then("I click upload file")
    public void iClickUploadFile() {
        uploadPage.clickUpload();
    }
}
