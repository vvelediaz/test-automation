package com.solvd.carina.fbapi;

import com.fasterxml.jackson.core.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.solvd.carina.facebookapi.GetUserPostsMethod;
import com.solvd.carina.facebookapi.PostPagePostMethod;
import com.solvd.carina.facebookapi.DeleteUserPagePostMethod;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import io.restassured.response.Response;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.concurrent.atomic.AtomicInteger;

public class FacebookAPITest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testgetPosts() {
        GetUserPostsMethod getUserPostsMethod = new GetUserPostsMethod();

        getUserPostsMethod.callAPIExpectSuccess();
        getUserPostsMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());

        getUserPostsMethod.validateResponseAgainstSchema("api/fbposts/_get/rs.schema");
    }

    @Test
    public void testCreatePagePost() {
        PostPagePostMethod api = new PostPagePostMethod();
        api.setProperties("api/fbposts/post.properties");
        String message = api.getProperties().getProperty("message").replaceAll(" ", "%20");
        api.getProperties().setProperty("message", message);
        api.replaceUrlPlaceholder("message", api.getProperties().getProperty("message"));

        api.callAPI();
        api.validateResponse();
    }

    @Test
    public void testDeletePagePost() {
        DeleteUserPagePostMethod api = new DeleteUserPagePostMethod();
        PostPagePostMethod postAPi = new PostPagePostMethod();
        postAPi.setProperties("api/fbposts/post.properties");
        String message = postAPi.getProperties().getProperty("message").replaceAll(" ", "%20");
        postAPi.getProperties().setProperty("message", message);
        postAPi.replaceUrlPlaceholder("message", postAPi.getProperties().getProperty("message"));

        Response response = postAPi.callAPI().andReturn();
        String responseBody = response.getBody().asString();
        JsonElement jsonElement = com.google.gson.JsonParser.parseString(responseBody);
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String id = jsonObject.get("id").getAsString();

        api.replaceUrlPlaceholder("id", id);
        api.callAPI();
        api.validateResponse();
    }
}
