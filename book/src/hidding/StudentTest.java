package hidding;

public class StudentTest {
	public static void main(String[] args) {
		Student studentLee = new Student();
		//studentLee.studentName = "이상원";
	    studentLee.setStudentName("이상원");                                  	//Student.studentName = "이상원"; 
		
		System.out.println(studentLee.getStudentName());
	}
}
