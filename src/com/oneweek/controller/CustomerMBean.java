package com.oneweek.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.html.HtmlDataTable;

import com.oneweek.model.entity.Customer;
import com.oneweek.model.service.CustomerService;

@ManagedBean(name = "customerMBean")
@RequestScoped
public class CustomerMBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Customer customer;
	private List<Customer> customerList;
	private HtmlDataTable dataTable;

	@PostConstruct
	public void init() {
		this.customer = new Customer();
		this.setCustomerList(new ArrayList<Customer>());
	}

	public String create() throws Exception {
		CustomerService.getInstance().create(customer);
		return "/modules/customer/create.xhtml";
	}

	public String retrieve() throws Exception {
		this.setCustomerList(CustomerService.getInstance().retrieve(customer));
		this.dataTable.setValue(customerList);
		return "";
	}
	
	public String delete() {
		return "";
	}
	
	public String clean() {
		this.customer = null;
		return "/modules/customer/create.xhtml";
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

}
