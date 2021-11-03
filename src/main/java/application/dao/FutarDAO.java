package application.dao;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import application.model.Futar;

@Repository
public class FutarDAO extends JdbcDaoSupport  {
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public void insertFutar(Futar futar) {
		String sql = "INSERT INTO futar(name, age) VALUES (?, ?)";
		getJdbcTemplate().update(sql, new Object[]{
				futar.getName(), futar.getAge()
		});
	}
	
	public List<Futar> listFutarok(){
		String sql = "SELECT * FROM futar";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Futar> result = new ArrayList<Futar>();
		for(Map<String, Object> row:rows){
			Futar futar = new Futar();
			futar.setId((Integer)row.get("id"));
			futar.setName((String)row.get("name"));
			futar.setAge((Integer) row.get("age"));
			result.add(futar);
		}
		
		return result;
	}
	
	public Futar getFutarById(int id){
		String sql = "SELECT * FROM futar WHERE id="+id;
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Futar> result = new ArrayList<Futar>();
		for(Map<String, Object> row:rows){
			Futar futar = new Futar();
			futar.setId((Integer)row.get("id"));
			futar.setName((String)row.get("name"));
			futar.setAge((Integer) row.get("age"));
			result.add(futar);
		}
		
		return result.get(0);
	}
	
	public void deleteFutar(int id){
		String sql = "DELETE FROM futar WHERE id="+id;
		getJdbcTemplate().update(sql);	
	}
	
	public void updateFutar(int id,String name, int age){
		String sql = "UPDATE futar SET name='"+name+"', age='"+age+"' WHERE id="+id;
		getJdbcTemplate().update(sql);	
	}
	
}