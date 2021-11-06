package application.dao;
import org.springframework.jdbc.core.RowMapper;

import application.model.Etel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EtelRowMapper implements RowMapper<Etel>{
	public Etel mapRow(ResultSet rs, int rowNum) throws SQLException{
		Etel etel = new Etel();
		
		etel.setNev(rs.getString("nev"));
		etel.setAr(rs.getInt("ar"));
		
		return etel;
	}
}
