
public class StudentManager extends UserManager {
	
	public void joinCourses(Student student) {
		System.out.println(student.getId()+" id numaral� ��renci kursa kat�ld�."); 
	}
	public void removeCourses(Student student) {
		System.out.println(student.getId()+" id numaral� ��renci kurstan ayr�ld�.");
	}
	public void coursesCompleted(Student student) {
		student.setCoursesPercentageFinish(100);
	}
}
