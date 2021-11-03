package application.dao;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import application.model.User;

@Repository
public class RegDAO extends JdbcDaoSupport  {
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public boolean insertUser(User user) {		
		String sql = "SELECT COUNT(*) FROM felhasznalo WHERE felhasznalonev=?";
		
		int count = getJdbcTemplate().queryForObject(sql, new Object[]{
				user.getUName()
		}, Integer.class);
		
		if(count > 0) {
			return false;
		}
		else {
			sql = "INSERT INTO felhasznalo VALUES (?, ?, ?, ?)";
			getJdbcTemplate().update(sql, user.getUName(), user.getPassword(), user.getEmail(), user.getJogosultsag());
			return true;
		}
	}
}
