package thisex;


class Student{
		private int id;
		private String name;
		private int grade;
		
		public int getId() {
			return id;
		}
		
		public String getName() {
			return name;
		}
		
		public Student setId(int id) {
			this.id = id;
			return this;
		}
		public Student setName(String name) {
		this.name = name;
		return this;
		}
		
		public Student setGrade(int g`rade) {
			this.grade = grade;
			return this;
		}
	
		public void showStudentInfo() {
			System.out.println(name+ " 님의 학번은 " + id + "이고, " + grade + "학년입니다.");
		}
	}

public class ReturnltSelf {
	public static void main(String[] args) {
		Student StudentLee = new Student();
		StudentLee.setId(12345).setName("김원상").setGrade(3).showStudentInfo();
	}
	
	
}
