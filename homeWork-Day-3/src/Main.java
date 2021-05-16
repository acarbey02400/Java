
public class Main {

	public static void main(String[] args) {
		
		Instructor instructor = new Instructor();
		instructor.setFirstName("Engin ");
		instructor.setLastName( "Demiroð ");
		instructor.setId(0);
		instructor.setInstructorNo(1);
		instructor.setEmailAddress("engindemirog@gmail.com");
		instructor.setInfo(" ODTÜ mezunu yazýlým geliþtirme uzmaný ve eðitmeni");
		
		Student student = new Student();
		student.setFirstName("Ýbrahim Halil ");
		student.setLastName("Acar ");
		student.setId(1);
		student.setEmailAddress("acarwoody01@gmail.com");
		student.setCoursesPercentageFinish(0);
		
		StudentManager studentManager= new StudentManager();
		studentManager.add(student);
		InstructorManager instructorManager = new InstructorManager();
		instructorManager.add(instructor);
		
		studentManager.coursesCompleted(student);
		System.out.println(student.getFirstName()+ student.getCoursesCompleteStatus());
		instructorManager.addCourse(instructor);
		
		
	}

}
