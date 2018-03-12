/*
 * [y] hybris Platform
 *
 * Copyright (c) 2000-2018 SAP SE
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * Hybris ("Confidential Information"). You shall not disclose such
 * Confidential Information and shall use it only in accordance with the
 * terms of the license agreement you entered into with SAP Hybris.
 */
package com.zooplus.restclient.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.zooplus.restclient.data.Token;
import com.zooplus.restclient.data.TokenResponse;
import com.zooplus.restclient.service.RestClient;


/**
 *
 */
public class DefaultRestClient implements RestClient
{

	private static final Logger LOG = Logger.getLogger(DefaultRestClient.class);

	RestTemplate restTemplate;

	//final String ACCESS_TOKEN_URI = "https://localhost:7002/authorizationserver/oauth/token";
	final String ACCESS_TOKEN_URI = "https://localhost:7002/authorizationserver/oauth/token?client_id=trusted_client&client_secret=nimda&grant_type=client_credentials";
	final String UPDATE_ACTIVITY_URI = "https://localhost:7002/zoopluswebservices/v2/electronics/activity/chekLogin?isLoggedin=true";
	final String LOGOUT_ACTIVITY_URI = "https://localhost:7002/zoopluswebservices/v2/electronics/activity/chekLogin?isLoggedin=false";

	@Override
	public void logIn()
	{
		final MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		final Map map = new HashMap<String, String>();
		map.put("Content-Type", "application/json");
		map.put("Authorization", "Bearer " + getToken());

		headers.setAll(map);

		final Map req_payload = new HashMap();
		req_payload.put("isLoggedin", "true");


		final HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
		restTemplate.postForEntity(UPDATE_ACTIVITY_URI, request, String.class);

	}

	@Override
	public void logOut()
	{

		final MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		final Map map = new HashMap<String, String>();
		map.put("Content-Type", "application/json");
		map.put("Authorization", "Bearer " + getToken());

		headers.setAll(map);

		final Map req_payload = new HashMap();
		req_payload.put("isLoggedin", "true");


		final HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
		restTemplate.postForEntity(LOGOUT_ACTIVITY_URI, request, String.class);

	}


	@Override
	public void logActivity(final String activity)
	{
		final String LOG_ACTIVITY_URI = "https://localhost:7002/zoopluswebservices/v2/electronics/activity/update?customerUpdated="
				+ activity;

		final MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		final Map map = new HashMap<String, String>();
		map.put("Content-Type", "application/json");
		map.put("Authorization", "Bearer " + getToken());

		headers.setAll(map);

		final Map req_payload = new HashMap();
		req_payload.put("customerUpdated", activity);


		final HttpEntity<?> request = new HttpEntity<>(req_payload, headers);
		//restTemplate.postForEntity(LOG_ACTIVITY_URI, request, String.class);
		restTemplate.put(LOG_ACTIVITY_URI, request);
	}

	private String getToken()
	{


		final Token tokenRequstObject = new Token();
		tokenRequstObject.setClient_id("trusted_client");
		tokenRequstObject.setClient_secret("nimda");
		tokenRequstObject.setGrant_type("client_credentials");
		tokenRequstObject.setUsername("admin");
		tokenRequstObject.setPassword("nimda");

		final ResponseEntity<TokenResponse> response = restTemplate.postForEntity(ACCESS_TOKEN_URI, tokenRequstObject,
				TokenResponse.class);
		final TokenResponse tokenresponse = response.getBody();
		LOG.info("token :" + tokenresponse.getAccess_token());
		//return response.getBody();
		return tokenresponse.getAccess_token();

	}

	protected HttpHeaders getHeader()
	{
		final HttpHeaders header = new HttpHeaders();
		//header.setContentType(getContentType(integration));

		return header;
	}

	/**
	 * @param restTemplate
	 *           the restTemplate to set
	 */
	@Required
	public void setRestTemplate(final RestTemplate restTemplate)
	{
		this.restTemplate = restTemplate;
	}





}
