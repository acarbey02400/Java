
public class StudentManager extends UserManager {
	
	public void joinCourses(Student student) {
		System.out.println(student.getId()+" id numaralı öğrenci kursa katıldı."); 
	}
	public void removeCourses(Student student) {
		System.out.println(student.getId()+" id numaralı öğrenci kurstan ayrıldı.");
	}
	public void coursesCompleted(Student student) {
		student.setCoursesPercentageFinish(100);
	}
}
