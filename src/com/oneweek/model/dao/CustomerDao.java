package com.oneweek.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oneweek.model.entity.Customer;
import com.oneweek.util.JSFUtils;
import com.oneweek.util.MessageProvider;


public class CustomerDao extends BaseDao {
	
	private static CustomerDao customerDao;

	private CustomerDao() {
	}

	public static CustomerDao getInstance() {
		if (customerDao == null) {
			customerDao = new CustomerDao();
		}
		return customerDao;
	}
	
	public String create(Customer customer) throws Exception {
		Connection conn = this.getConnection();
		String sql = "insert into customer(name, phone, address, email, observation)"
				+ "values(?,?,?,?,?);";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, customer.getName());
			pstm.setString(2, customer.getPhone());
			pstm.setString(3, customer.getAddress());
			pstm.setString(4, customer.getEmail());
			pstm.setString(5, customer.getObservation());
			pstm.execute();
			pstm.close();
			conn.close();
			JSFUtils.addMessageInfo(MessageProvider.getInstance().getValue("addRecord"));
		} catch (Exception e) {
			JSFUtils.addMessageError(MessageProvider.getInstance().getValue("recordFail" + " ")
					+ "( " + e.getMessage() + " )");
			conn.close();
		}
		return null;
	}
	
	public List<Customer> retrieveByFilter(String value, String column) throws Exception {
		Connection conn = this.getConnection();
		List<Customer> customerList = new ArrayList<Customer>();
		String sql = "select * from customer where " + column + " ilike ? order by name asc;";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, "%" + value + "%");
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setAddress(rs.getString("address"));
				customer.setCustomerId(rs.getInt("customer_id"));
				customer.setEmail(rs.getString("email"));
				customer.setName(rs.getString("name"));
				customer.setObservation(rs.getString("observation"));
				customer.setPhone(rs.getString("phone"));
				customerList.add(customer);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			JSFUtils.addMessageError(e.getMessage() + MessageProvider.getInstance().getValue("systemFail"));
			conn.close();
		}
		return customerList;
	}

}
