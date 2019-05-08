package c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

// 数据访问，需要调用JdbcTemplate
public class StudentDao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void add(){
        String sql = "insert into student values(?,?)";
        jdbcTemplate.update(sql,"LeBao","520");
        System.out.println("dao Layer is doing ");
    }
}
