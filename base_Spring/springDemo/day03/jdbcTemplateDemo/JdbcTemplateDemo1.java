package jdbcTemplateDemo;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateDemo1 {

    // 查询一个集合
    @Test
    public void findObjectList(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring_day03");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "select * from student";
        List<Student> student = jdbcTemplate.query(sql,new MyRowMapper());
        System.out.println(student);
    }


    // 查询一个对象
    @Test
    public void findObject(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring_day03");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "select * from student where stu_name = ?";
        Student student = jdbcTemplate.queryForObject(sql,new MyRowMapper(),"Nancy");
        System.out.println(student);
    }

    // 查询功能
    @Test
    public void findCount(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring_day03");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "select count(*) from student";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        System.out.println(count);
    }



    // 删除功能
    @Test
    public void delete(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver"); // com.mysql.jdbc.Driver
        dataSource.setUrl("jdbc:mysql:///spring_day03"); // jdbc:mysql:///spring_day03
        dataSource.setUsername("root");
        dataSource.setPassword("admin");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        String sql = "delete from student where stu_name = ?";
        int rows = jdbcTemplate.update(sql,"LeLe");
        System.out.println(rows);

    }

    @Test
    // 修改操作
    public void update(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring_day03");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "update student set password=? where stu_name = ?";
        int row = jdbcTemplate.update(sql,"5201314","Nancy");
        System.out.println(row);
    }


    @Test
    //添加操作
    public void add(){
        // 第一步，设置数据库信息
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql:///spring_day03");
        dataSource.setUsername("root");
        dataSource.setPassword("admin");

        // 第二步，创建JdbcTemplate对象，设置数据源
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        // 调用JdbcTemplate提供的方法，实现功能
        String sql = "insert into student values(?,?)";
        int rows =jdbcTemplate.update(sql,"LeLe2","520");
        System.out.println(rows);

    }
}



class MyRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int num) throws SQLException {
        // 1 从结果集里面把数据得到
        String Studentname = rs.getString("stu_name");
        String password = rs.getString("password");

        // 2 把得到数据封装到对象里面
        Student Student = new Student();
        Student.setStu_name(Studentname);
        Student.setPassword(password);

        return Student;
    }

}

