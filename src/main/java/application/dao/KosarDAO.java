package application.dao;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import application.model.Etel;
import application.model.Fuvar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import application.model.User;

@Repository
public class KosarDAO extends JdbcDaoSupport{
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }
	
	public void rendelesRogzit(User user, Etel etel) {
		String sql = "INSERT INTO rendeles(nev, ar, felhasznalonev) VALUES (?, ?, ?)";
		getJdbcTemplate().update(sql, new Object[]{
				etel.getNev(), etel.getAr(), user.getUName()
		});
	}
}
