package application.dao;
import org.springframework.jdbc.core.RowMapper;

import application.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User>{
	public User mapRow(ResultSet rs, int rowNum) throws SQLException{
		User user = new User();
		
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("jelszo"));
		user.setUName(rs.getString("felhasznalonev"));
		user.setJogosultsag(rs.getBoolean("jogosultsag"));
		
		return user;
	}
}
