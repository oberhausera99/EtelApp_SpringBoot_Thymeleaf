package application.dao;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import application.model.Kapcsolat;

@Repository
public class KapcsolatDAO extends JdbcDaoSupport  {
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	
	public void insertKapcsolat(Kapcsolat kapcsolat) {
		String sql = "INSERT INTO kapcsolat(velemeny, ertekeles, felhasznalo) VALUES (?, ?, ?)";
		getJdbcTemplate().update(sql, new Object[]{
				kapcsolat.getVelemeny(), kapcsolat.getErtekeles(), kapcsolat.getFelhasznalo()
		});
	}
	
	public List<Kapcsolat> listKapcsolatok(){
		String sql = "SELECT * FROM kapcsolat";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		List<Kapcsolat> result = new ArrayList<Kapcsolat>();
		for(Map<String, Object> row:rows){
			Kapcsolat kapcsolat = new Kapcsolat();
			kapcsolat.setId((Integer)row.get("id"));
			kapcsolat.setVelemeny((String)row.get("velemeny"));
			kapcsolat.setErtekeles((Integer) row.get("ertekeles"));
			kapcsolat.setFelhasznalo((String) row.get("felhasznalo"));
			result.add(kapcsolat);
		}
		
		return result;
	}
	
}
