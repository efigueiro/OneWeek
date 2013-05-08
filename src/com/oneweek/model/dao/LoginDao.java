package com.oneweek.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.oneweek.model.entity.User;
import com.oneweek.util.JSFUtils;

public class LoginDao extends BaseDao {

	private static LoginDao loginDao;

	private LoginDao() {
	}

	public static LoginDao getInstance() {
		if (loginDao == null) {
			loginDao = new LoginDao();
		}
		return loginDao;
	}
	
	public User validate(User user) throws Exception {
		Connection conn = this.getConnection();
		User authenticated = new User();
		String sql = "select * from users where email ~* ? and password = ?;";
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, user.getEmail());
			pstm.setString(2, user.getPassword());
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				authenticated.setUserId(rs.getInt("user_id"));
				authenticated.setEmail(rs.getString("email"));
				authenticated.setPassword(rs.getString("password"));
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (Exception e) {
			JSFUtils.addMessageError(e.getMessage() + " The system cannot perform this action!");
			conn.close();
		}
		return authenticated;
	}
	
}
