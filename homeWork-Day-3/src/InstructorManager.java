
public class InstructorManager extends UserManager {
	
	public void addCourse(Instructor instructor) {
	System.out.println(instructor.getFirstName()+"Kursa e�itmeni olarak eklendi.");	
	}
	
	
	public void removeCourse(Instructor instructor) {
		System.out.println(instructor.getFirstName()+"kurs e�itmeni g�revinden al�nd�.");	
		}
}
