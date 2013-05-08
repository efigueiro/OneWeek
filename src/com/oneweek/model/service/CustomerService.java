package com.oneweek.model.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.oneweek.model.dao.CustomerDao;
import com.oneweek.model.entity.Customer;
import com.oneweek.util.Encoding;
import com.oneweek.util.JSFUtils;
import com.oneweek.util.MessageProvider;

public class CustomerService {

	private static CustomerService customerService;

	private CustomerService() {
	}

	public static CustomerService getInstance() {
		if (customerService == null) {
			customerService = new CustomerService();
		}
		return customerService;
	}

	public String create(Customer customer) throws Exception {
		if(validate(customer)){
			//String encoding = Encoding.getInstance().convertISOtoUTF8(customer.getName());
			//customer.setName(encoding);
			CustomerDao.getInstance().create(customer);
		} 
		return null;
	}
	
	public List<Customer> retrieve(Customer customer) throws Exception {
		return CustomerDao.getInstance().retrieveByFilter(customer.getName(), "name");
	}

	public boolean validate(Customer customer) {
		if (StringUtils.isNotEmpty(customer.getName())) {
			return true;
		} else {
			JSFUtils.addMessageError(MessageProvider.getInstance().getValue("emptyField"));
		}

		return false;
	}
}
