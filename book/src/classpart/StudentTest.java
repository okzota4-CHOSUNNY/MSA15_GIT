package classpart;

	public class StudentTest {
		public static void main(String[] args) {
			Student s1 = new Student();
			s1.studentName = "안연수";
			System.out.println(s1.getStudentName());
			
			Student student2 = new Student();
			student2.studentName = "김성모";
			System.out.println(student2.getStudentName());
		}

		
}
	
