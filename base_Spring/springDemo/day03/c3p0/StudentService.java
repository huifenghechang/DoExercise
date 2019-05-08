package c3p0;

public class StudentService {
    private StudentDao studentDao;
    public void addStudent(){
        studentDao.add();
        System.out.println("service Layer is doing");
    }

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
}
