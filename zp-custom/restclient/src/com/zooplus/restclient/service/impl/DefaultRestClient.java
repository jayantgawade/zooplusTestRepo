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

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;

import com.zooplus.restclient.constants.RestclientConstants;


/**
 *
 */
public class DefaultRestClient extends DefaultAbstractRestClient
{

	private static final Logger LOG = Logger.getLogger(DefaultRestClient.class);

	@Override
	public void logIn()
	{
		final HttpEntity<?> request = new HttpEntity<>(getHeader());
		restTemplate.postForEntity(RestclientConstants.LOGIN_ACTIVITY_URI + true, request, String.class);

	}

	@Override
	public void logOut()
	{
		final HttpEntity<?> request = new HttpEntity<>(getHeader());
		restTemplate.postForEntity(RestclientConstants.LOGIN_ACTIVITY_URI + false, request, String.class);
	}

	@Override
	public void logUserActivity(final String activity)
	{

		final HttpEntity<?> request = new HttpEntity<>(getHeader());
		restTemplate.put(RestclientConstants.USET_ACTIVITY_URI + activity, request);
	}





}
