/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package com.zooplus.restclient.constants;

/**
 * Global class for all Restclient constants. You can add global constants for your extension into this class.
 */
public final class RestclientConstants extends GeneratedRestclientConstants
{
	public static final String EXTENSIONNAME = "restclient";

	private RestclientConstants()
	{
		//empty to avoid instantiating this constant class
	}

	// implement here constants used by this extension

	public static final String PLATFORM_LOGO_CODE = "restclientPlatformLogo";

	public static final String ACCESS_TOKEN_URI = "https://localhost:7002/authorizationserver/oauth/token?client_id=trusted_client&client_secret=nimda&grant_type=client_credentials";
	public static final String LOGIN_ACTIVITY_URI = "https://localhost:7002/zoopluswebservices/v2/electronics/activity/chekLogin?isLoggedin=";
	public static final String USET_ACTIVITY_URI = "https://localhost:7002/zoopluswebservices/v2/electronics/activity/update?customerUpdated=";
}
