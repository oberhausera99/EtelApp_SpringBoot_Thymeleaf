package application.dao;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


import application.model.Etel;
import application.model.User;


	@Repository
	public class EtelDAO extends JdbcDaoSupport  {
		
		@Autowired 
		DataSource dataSource;
		
		@PostConstruct
		private void initialize(){
			setDataSource(dataSource);
		}
		
		 public void insertEtel(Etel etel) {
			String sql = "INSERT INTO etel(nev, ar) VALUES (?, ?)";
			getJdbcTemplate().update(sql, new Object[]{
					etel.getNev(), etel.getAr()
			});
		} 
		
		public List<Etel> listEtelek(){
			String sql = "SELECT * FROM etel";
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
			
			List<Etel> result = new ArrayList<Etel>();
			for(Map<String, Object> row:rows){
				Etel etel = new Etel();
				etel.setNev((String)row.get("nev"));
				etel.setAr((Integer)row.get("ar"));
				result.add(etel);
			}
			
			return result;
		}
		
		public Etel getEtelByNev(String nev){
			String sql = "SELECT * FROM etel WHERE nev=?";
			
			Etel etel = getJdbcTemplate().queryForObject(sql, new Object[] {nev}, new EtelRowMapper());

			return etel;
		}
		
		public void deleteEtel(String nev){
			String sql = "DELETE FROM etel WHERE nev="+nev;
			getJdbcTemplate().update(sql);	
		}
		
		public void updateEtel(String nev, int ar){
			String sql = "UPDATE Etel SET nev='"+nev+"', ar='"+ar+"' WHERE nev="+nev;
			getJdbcTemplate().update(sql);	
		}
			
	
}
