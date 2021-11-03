package application.dao;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import application.model.Dog;

@Repository
public class DogDAO extends JdbcDaoSupport  {
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public void insertDog(Dog dog) {
		String sql = "INSERT INTO dog(name, age) VALUES (?, ?)";
		getJdbcTemplate().update(sql, new Object[]{
				dog.getName(), dog.getAge()
		});
	}
	
	public List<Dog> listDogs(){
		String sql = "SELECT * FROM dog";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Dog> result = new ArrayList<Dog>();
		for(Map<String, Object> row:rows){
			Dog dog = new Dog();
			dog.setId((Integer)row.get("id"));
			dog.setName((String)row.get("name"));
			dog.setAge((Integer) row.get("age"));
			result.add(dog);
		}
		
		return result;
	}
	
	public Dog getDogById(int id){
		String sql = "SELECT * FROM dog WHERE id="+id;
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Dog> result = new ArrayList<Dog>();
		for(Map<String, Object> row:rows){
			Dog dog = new Dog();
			dog.setId((Integer)row.get("id"));
			dog.setName((String)row.get("name"));
			dog.setAge((Integer) row.get("age"));
			result.add(dog);
		}
		
		return result.get(0);
	}
	
	public void deleteDog(int id){
		String sql = "DELETE FROM dog WHERE id="+id;
		getJdbcTemplate().update(sql);	
	}
	
	public void updateDog(int id,String name, int age){
		String sql = "UPDATE dog SET name='"+name+"', age='"+age+"' WHERE id="+id;
		getJdbcTemplate().update(sql);	
	}
	
}
