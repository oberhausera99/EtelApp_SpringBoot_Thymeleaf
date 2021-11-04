package application.dao;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import application.model.Fuvar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;


@Repository
public class FuvarDAO extends JdbcDaoSupport  {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize(){
        setDataSource(dataSource);
    }

    public void insertFuvar(Fuvar fuvar) {
        String sql = "INSERT INTO fuvar(rendelesid, futarid) VALUES (?, ?)";
        getJdbcTemplate().update(sql, new Object[]{
                fuvar.getRendelesid(), fuvar.getFutarid()
        });
    }

    public List<Fuvar> listFuvars(){
        String sql = "SELECT * FROM fuvar";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Fuvar> result = new ArrayList<Fuvar>();
        for(Map<String, Object> row:rows){
            Fuvar fuvar = new Fuvar();
            fuvar.setRendelesid((Integer)row.get("rendelesid"));
            fuvar.setFutarid((Integer) row.get("futarid"));
            fuvar.setid((Integer) row.get("id"));
            result.add(fuvar);
        }

        return result;
    }

    public Fuvar getFuvarById(int id){
        String sql = "SELECT * FROM fuvar WHERE id="+id;
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Fuvar> result = new ArrayList<Fuvar>();
        for(Map<String, Object> row:rows){
            Fuvar fuvar = new Fuvar();
            fuvar.setRendelesid((Integer)row.get("rendelesid"));
            fuvar.setFutarid((Integer) row.get("futarid"));
            fuvar.setid((Integer) row.get("id"));
            result.add(fuvar);
        }

        return result.get(0);
    }

    public void deleteFuvar(int id){
        String sql = "DELETE FROM fuvar WHERE id="+id;
        getJdbcTemplate().update(sql);
    }

    public void updateFuvar(int id, int rendelesid, int futarid){
        String sql = "UPDATE fuvar SET rendelesid='"+rendelesid+"', futarid='"+futarid+"' WHERE id="+id;
        getJdbcTemplate().update(sql);
    }

}
