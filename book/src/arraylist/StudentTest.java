package arraylist;

public class StudentTest {
	public static void main(String[] args) {
		Student studentCho = new Student(200862032, "조성진");
		studentCho.addSubject("국어", 100);
		studentCho.addSubject("수학", 70);
		
		Student studentKong = new Student(20095457, "공인선");
		studentKong.addSubject("국어", 100);
		studentKong.addSubject("수학", 100);
		studentKong.addSubject("과학", 100);
		
		studentCho.showStudentInfo();
		System.out.println("=======================");
		studentKong.showStudentInfo();
	}
}
