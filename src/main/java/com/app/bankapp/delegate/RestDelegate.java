package com.app.bankapp.delegate;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.app.bankapp.delegate.model.PersonRequest;

@Component
public class RestDelegate {
	private RestTemplate template;
	
	public RestDelegate(RestTemplate template) {
		this.template = template;
	}
	@Value("${service.base-url}")
	private String baseURL;
	public <T> T doPOST(PersonRequest req, Class<T> type) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("token", "2bndjqnuwje23h2nmnka954nk492n32m1i3n1dsr3n32");
		headers.add("x-request-id", UUID.randomUUID().toString());
		HttpEntity<PersonRequest> entity = new HttpEntity<PersonRequest>(req, headers);
		return template.exchange(baseURL + "financial-eligibility", HttpMethod.POST, entity, type).getBody();
	}
}
