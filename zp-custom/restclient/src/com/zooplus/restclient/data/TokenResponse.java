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
package com.zooplus.restclient.data;

/**
 *
 */
public class TokenResponse
{
	String access_token;
	String token_type;
	String expires_in;
	String scope;

	/**
	 * @return the access_token
	 */
	public String getAccess_token()
	{
		return access_token;
	}

	/**
	 * @param access_token
	 *           the access_token to set
	 */
	public void setAccess_token(final String access_token)
	{
		this.access_token = access_token;
	}

	/**
	 * @return the token_type
	 */
	public String getToken_type()
	{
		return token_type;
	}

	/**
	 * @param token_type
	 *           the token_type to set
	 */
	public void setToken_type(final String token_type)
	{
		this.token_type = token_type;
	}

	/**
	 * @return the expires_in
	 */
	public String getExpires_in()
	{
		return expires_in;
	}

	/**
	 * @param expires_in
	 *           the expires_in to set
	 */
	public void setExpires_in(final String expires_in)
	{
		this.expires_in = expires_in;
	}

	/**
	 * @return the scope
	 */
	public String getScope()
	{
		return scope;
	}

	/**
	 * @param scope
	 *           the scope to set
	 */
	public void setScope(final String scope)
	{
		this.scope = scope;
	}
}
