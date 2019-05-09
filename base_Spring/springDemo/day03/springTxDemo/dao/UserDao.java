package springTxDemo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class UserDao {
    JdbcTemplate jdbcTemplate;


    public void setJdbcTemplate() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring_day03");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void add(String name){

        String sql = "insert into user values (?,?)";
        setJdbcTemplate();
        jdbcTemplate.update(sql,name,15000);
        System.out.printf("userDao added %s ",name);
    }
}
