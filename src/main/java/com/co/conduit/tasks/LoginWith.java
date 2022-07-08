package com.co.conduit.tasks;

import com.co.conduit.interactions.Post;
import com.co.conduit.models.UserCredentials;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class LoginWith implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("/users/login")
                        .with(RequestSpecification ->
                                RequestSpecification
                                        .contentType(ContentType.JSON)
                                        .body("{\n" +
                                                "  \"user\": {\n" +
                                                "    \"email\": \"wilsonss@gmail.com\",\n" +
                                                "    \"password\": \"123456789\"\n" +
                                                "  }\n" +
                                                "}"))
        );
    }

    public static LoginWith credentials(){
        return Tasks.instrumented(LoginWith.class);
    }
}
