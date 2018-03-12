/**
 *
 */
package com.zooplus.facades.customer.impl;

import de.hybris.platform.commercefacades.customer.impl.DefaultCustomerFacade;

import org.springframework.beans.factory.annotation.Required;

import com.zooplus.restclient.service.RestClient;


/**
 * @author Dell
 *
 */
public class DefualtZooplusCustomerFacade extends DefaultCustomerFacade
{

	private RestClient restclient;

	@Override
	public void loginSuccess()
	{
		super.loginSuccess();
		restclient.logIn();
	}

	/**
	 * @param restclient
	 *           the restclient to set
	 */
	@Required
	public void setRestclient(final RestClient restclient)
	{
		this.restclient = restclient;
	}


}
