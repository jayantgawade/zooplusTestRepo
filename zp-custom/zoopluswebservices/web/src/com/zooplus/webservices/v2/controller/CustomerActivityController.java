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
package com.zooplus.webservices.v2.controller;

import de.hybris.platform.webservicescommons.cache.CacheControl;
import de.hybris.platform.webservicescommons.cache.CacheControlDirective;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
@RequestMapping(value = "/{baseSiteId}/activity")
@CacheControl(directive = CacheControlDirective.NO_CACHE)
public class CustomerActivityController extends BaseCommerceController
{
	private static final Logger LOG = Logger.getLogger(CustomerActivityController.class);

	@Secured(
	{ "ROLE_CLIENT", "ROLE_TRUSTED_CLIENT" })

	@RequestMapping(value = "/chekLogin", method = RequestMethod.POST, consumes =
	{ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void checkIsCustomerLogin(@RequestParam(required = true) final boolean isLoggedin)
	{
		if (isLoggedin)
		{
			LOG.info("User is Logged in the app");
		}
		else
		{
			LOG.info("User is Logged off from app");
		}
	}

	@Secured(
	{ "ROLE_CLIENT", "ROLE_TRUSTED_CLIENT" })

	@RequestMapping(value = "/update", method = RequestMethod.PUT, consumes =
	{ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	@ResponseBody
	public void updateActivity(@RequestParam(required = true) final String customerUpdated)
	{

		LOG.info("customer updated : " + customerUpdated + new Date());

	}


}
