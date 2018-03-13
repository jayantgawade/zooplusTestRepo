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


/**
 *
 */
public class DefaultRestClient extends DefaultAbstractRestClient
{

	private static final Logger LOG = Logger.getLogger(DefaultRestClient.class);

	@Override
	public void logIn(final String userName, final String password)
	{
		final String LOGIN_ACTIVITY_URI = "https://localhost:7002/zoopluswebservices/v2/electronics/users/" + userName + "/login?";
		restTemplate.put(LOGIN_ACTIVITY_URI + "newLogin=" + userName + "&password=" + password, getHeader());
		LOG.info("User logged in the system");

	}

	@Override
	public void logOut(final String userName)
	{
		final String LOGOUT_ACTIVITY_URI = "https://localhost:7002/zoopluswebservices/v2/electronics/users/" + userName
				+ "/logout?";
		restTemplate.postForEntity(LOGOUT_ACTIVITY_URI, getHeader(), String.class);

		LOG.info("User logged out from the system");
	}

	@Override
	public void logUserActivity(final String userName, final String activity)
	{
		final String USER_ACTIVITY_URI = "https://localhost:7002/zoopluswebservices/v2/electronics/users/" + userName + "?activity="
				+ activity;

		restTemplate.put(USER_ACTIVITY_URI + activity, getHeader());
	}





}
