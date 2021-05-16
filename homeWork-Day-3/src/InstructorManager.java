
public class InstructorManager extends UserManager {
	
	public void addCourse(Instructor instructor) {
	System.out.println(instructor.getFirstName()+"Kursa eðitmeni olarak eklendi.");	
	}
	
	
	public void removeCourse(Instructor instructor) {
		System.out.println(instructor.getFirstName()+"kurs eðitmeni görevinden alýndý.");	
		}
}
