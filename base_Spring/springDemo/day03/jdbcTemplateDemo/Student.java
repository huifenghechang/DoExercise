package jdbcTemplateDemo;

public class Student {
    private String stu_name;
    private String password;


    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "jdbcTemplateDemo.Student [stu_name=" + stu_name + ", password=" + password + "]";
    }
}
