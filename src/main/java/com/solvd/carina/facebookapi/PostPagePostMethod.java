package com.solvd.carina.facebookapi;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/me/feed?message=${message}&access_token=${token}", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/fbposts/_post/rq.json")
@ResponseTemplatePath(path = "api/fbposts/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostPagePostMethod extends AbstractApiMethodV2 {

    public PostPagePostMethod() {
        //super("api/users/_post/rq.json", "api/users/_post/rs.json", "api/users/user.properties");
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("token", Configuration.getRequired("api_page_token"));
    }
}
