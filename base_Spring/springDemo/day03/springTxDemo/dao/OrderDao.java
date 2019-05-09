package springTxDemo.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class OrderDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void lessMoney(){
        String sql = "update user set salary=salary-? where username=?";
        jdbcTemplate.update(sql,1000,"Nancy");
    }

    public void moreMoney(){
        String sql = "update user set salary=salary+? where username=?";
        jdbcTemplate.update(sql,1000,"LeBao");
    }
}
