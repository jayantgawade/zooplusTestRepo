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
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.zooplus.restclient.constants.RestclientConstants;
import com.zooplus.restclient.data.TokenResponse;
import com.zooplus.restclient.service.RestClient;


/**
 *
 */
public abstract class DefaultAbstractRestClient implements RestClient
{
	private static final Logger LOG = Logger.getLogger(DefaultAbstractRestClient.class);

	RestTemplate restTemplate;


	protected String getToken()
	{

		final MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		final HttpEntity<?> request = new HttpEntity<>(headers);
		final ResponseEntity<TokenResponse> response = restTemplate.postForEntity(RestclientConstants.ACCESS_TOKEN_URI, request,
				TokenResponse.class);
		final TokenResponse tokenresponse = response.getBody();
		LOG.info("token :" + tokenresponse.getAccess_token());
		return tokenresponse.getAccess_token();

	}

	protected HttpEntity<?> getHeader()
	{
		final MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		final Map map = new HashMap<String, String>();
		map.put("Content-Type", "application/json");
		map.put("Authorization", "Bearer " + getToken());
		headers.setAll(map);
		return new HttpEntity<>(headers);
	}

	@Required
	public void setRestTemplate(final RestTemplate restTemplate)
	{
		this.restTemplate = restTemplate;
	}


}
