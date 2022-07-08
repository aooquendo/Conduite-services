package com.co.conduit.stepdefinition;

import com.co.conduit.models.UserCredentials;
import com.co.conduit.questions.LoginStatusCode;
import com.co.conduit.tasks.LoginWith;
import com.co.conduit.utils.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import java.util.List;

public class LoginStepDefinition {

    private static final String apiRestUrl = "https://api.realworld.io/api";
    Actor wilson = Actor.named("Wilson");

    @Given("i on the login page")
    public void iOnTheLoginPage() {
        wilson.whoCan(CallAnApi.at(apiRestUrl));
    }

    @When("I type my credentials")
    public void iTypeMyCredentials() {
     wilson.attemptsTo(LoginWith.credentials());
    }

    @Then("i should get on the website")
    public void iShouldGetOnTheWebsite() {
        wilson.should(
                GivenWhenThen.seeThat(
                        LoginStatusCode.was(), Matchers.equalTo(Constants.LOGINSTATUSCODE))
        );
    }


}
