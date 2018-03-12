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

import java.io.Serializable;


/**
 *
 */
public class Token implements Serializable
{
	String client_id;
	String client_secret;
	String grant_type;
	String username;
	String password;

	/**
	 * @return the client_id
	 */
	public String getClient_id()
	{
		return client_id;
	}

	/**
	 * @param client_id
	 *           the client_id to set
	 */
	public void setClient_id(final String client_id)
	{
		this.client_id = client_id;
	}

	/**
	 * @return the client_secret
	 */
	public String getClient_secret()
	{
		return client_secret;
	}

	/**
	 * @param client_secret
	 *           the client_secret to set
	 */
	public void setClient_secret(final String client_secret)
	{
		this.client_secret = client_secret;
	}

	/**
	 * @return the grant_type
	 */
	public String getGrant_type()
	{
		return grant_type;
	}

	/**
	 * @param grant_type
	 *           the grant_type to set
	 */
	public void setGrant_type(final String grant_type)
	{
		this.grant_type = grant_type;
	}

	/**
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}

	/**
	 * @param username
	 *           the username to set
	 */
	public void setUsername(final String username)
	{
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}

	/**
	 * @param password
	 *           the password to set
	 */
	public void setPassword(final String password)
	{
		this.password = password;
	}


}
