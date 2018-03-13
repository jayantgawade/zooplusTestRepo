/**
 *
 */
package com.zooplus.facades.customer;

import de.hybris.platform.commercefacades.customer.CustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;

import java.util.Date;


/**
 * @author Dell
 *
 */
public interface ZooplusCustomerFacade extends CustomerFacade
{

	/**
	 * @param customerData
	 * @param appactivity
	 * @param date
	 * @throws DuplicateUidException
	 */
	void recordActivity(CustomerData customerData, String appactivity, Date date) throws DuplicateUidException;

}
