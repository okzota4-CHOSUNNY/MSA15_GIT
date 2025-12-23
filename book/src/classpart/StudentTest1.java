package classpart;

	public class StudentTest1 {
		int studentID;
		String studentName;
		int grade;
		String address;
		
		public String getStudentName() {
			return studentName;
		}

		
		public static void main(String[] args) {
			StudentTest1 studentAhn = new StudentTest1();
			studentAhn.studentName = "안연수";
			
			System.out.println(studentAhn.studentName);
			System.out.println(studentAhn.getStudentName());
		}
	}
	

