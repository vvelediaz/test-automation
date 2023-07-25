package com.solvd.carina.facebookapi;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/${version}/${id}?access_token=${token}", methodType = HttpMethodType.DELETE)
@ResponseTemplatePath(path = "api/fbposts/_delete/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class DeleteUserPagePostMethod extends AbstractApiMethodV2 {

    public DeleteUserPagePostMethod() {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("version", Configuration.getRequired("api_version"));
        replaceUrlPlaceholder("token", Configuration.getRequired("api_page_token"));
    }
}
