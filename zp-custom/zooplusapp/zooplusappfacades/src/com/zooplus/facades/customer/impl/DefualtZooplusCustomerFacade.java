/**
 *
 */
package com.zooplus.facades.customer.impl;

import static de.hybris.platform.servicelayer.util.ServicesUtil.validateParameterNotNullStandardMessage;

import de.hybris.platform.commercefacades.customer.impl.DefaultCustomerFacade;
import de.hybris.platform.commercefacades.user.data.CustomerData;
import de.hybris.platform.commerceservices.customer.DuplicateUidException;
import de.hybris.platform.core.model.user.CustomerModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.util.Assert;

import com.zooplus.facades.customer.ZooplusCustomerFacade;
import com.zooplus.restclient.service.RestClient;
import com.zooplus.webservices.model.CustomerActivityModel;


/**
 * @author Dell
 *
 */
public class DefualtZooplusCustomerFacade extends DefaultCustomerFacade implements ZooplusCustomerFacade
{

	private RestClient restclient;

	@Override
	public void loginSuccess()
	{
		super.loginSuccess();

		restclient.logIn("jayantg@pragiti.com", "Jay@jay1");
	}



	@Override
	public void updateProfile(final CustomerData customerData) throws DuplicateUidException
	{
		super.updateProfile(customerData);
		restclient.logUserActivity(customerData.getUid(), " updated profile ");

	}



	@Override
	public void recordActivity(final CustomerData customerData, final String appactivity, final Date date)
			throws DuplicateUidException
	{
		validateParameterNotNullStandardMessage("customerData", customerData);
		Assert.hasText(customerData.getUid(), "The field [Uid] cannot be empty");

		final CustomerModel customer = getCurrentSessionCustomer();
		getCustomerReversePopulator().populate(customerData, customer);



		final List<CustomerActivityModel> userActivities = new ArrayList<>();
		userActivities.addAll(customer.getActivities());
		final CustomerActivityModel activity = getModelService().create(CustomerActivityModel.class);

		activity.setActiityDate(date);
		activity.setCustomer(customer);
		activity.setDescription(appactivity);

		userActivities.add(activity);
		customer.setActivities(userActivities);
		getModelService().saveAll(customer, activity);
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
