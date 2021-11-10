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

import application.model.Rendeles;
import application.model.User;

@Repository
public class RendelesDAO extends JdbcDaoSupport {
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public void deleteRendeles(String id) {
		//String sql = "DELETE FROM etel WHERE id='"+id+"'";
		
		String sql = "DELETE FROM rendeles WHERE rendelesid ='"+id+"'";
		String sql2 = "DELETE FROM fuvar WHERE rendelesid ='"+id+"'";

		getJdbcTemplate().update(sql2);
		getJdbcTemplate().update(sql);

	}
	
	public List<Rendeles> getRendelesek(){
		List<Rendeles> rendelesek = new ArrayList<Rendeles>();
		
		String sql = "SELECT * FROM rendeles";
		
		rendelesek = getJdbcTemplate().query(sql, new RendelesRowMapper());
		
		return rendelesek;
	}
	
	public List<Rendeles> getRendelesForUser(User user){
		List<Rendeles> rendelesek = new ArrayList<Rendeles>();
		
		String sql = "SELECT * FROM rendeles WHERE felhasznalonev=?";
		
		rendelesek = getJdbcTemplate().query(sql, new Object[] {user.getUName()}, new RendelesRowMapper());
		
		return rendelesek;
	}
}
