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
package com.zooplus.restclient.setup;

import static com.zooplus.restclient.constants.RestclientConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import com.zooplus.restclient.constants.RestclientConstants;
import com.zooplus.restclient.service.RestclientService;


@SystemSetup(extension = RestclientConstants.EXTENSIONNAME)
public class RestclientSystemSetup
{
	private final RestclientService restclientService;

	public RestclientSystemSetup(final RestclientService restclientService)
	{
		this.restclientService = restclientService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		restclientService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return RestclientSystemSetup.class.getResourceAsStream("/restclient/sap-hybris-platform.png");
	}
}
