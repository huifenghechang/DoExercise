package jdbcTemplateDemo;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDao {

    // 对数据库进行操作，需要得到JDBCTemplate对象
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public void add(){
        String sql = "insert into student values(?,?)";
        jdbcTemplate.update(sql,"Bob","530");
    }
}
