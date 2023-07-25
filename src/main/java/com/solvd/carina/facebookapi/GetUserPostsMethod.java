package com.solvd.carina.facebookapi;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/${version}/${id}?fields=posts&access_token=${token}", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "api/fbposts/_get/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetUserPostsMethod extends AbstractApiMethodV2 {
	public GetUserPostsMethod() {
		replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
		replaceUrlPlaceholder("version", Configuration.getRequired("api_version"));
		replaceUrlPlaceholder("id", Configuration.getRequired("api_user_id"));
		replaceUrlPlaceholder("token", Configuration.getRequired("api_user_token"));
	}
}
