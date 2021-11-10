package application.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.jdbc.core.RowMapper;

import application.model.Rendeles;

public class RendelesRowMapper implements RowMapper<Rendeles> {
    public Rendeles mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Rendeles rendeles = new Rendeles();
    	int PERCEK_ERKEZESIG = 45;
    	
    	rendeles.setNev(rs.getString("nev"));
    	rendeles.setAr(rs.getInt("ar"));
    	LocalDateTime varhatoErkezes = rs.getTimestamp("ido").toLocalDateTime();
    	rendeles.setFelhnev(rs.getString("felhasznalonev"));
    	rendeles.setId(rs.getInt("rendelesid"));
    	varhatoErkezes = varhatoErkezes.plusMinutes(PERCEK_ERKEZESIG);
    	LocalDateTime most = LocalDateTime.now();
    	
    	String minutes = "Hamarosan";
    	if(varhatoErkezes.isAfter(most)) {
    		minutes = String.valueOf(ChronoUnit.MINUTES.between(most, varhatoErkezes)) + " perc múlva";
    	}
    	
    	rendeles.setErkezesiIdo(minutes);
    	
    	return rendeles;
    }	
}
