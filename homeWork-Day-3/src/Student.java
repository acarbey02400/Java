
public class Student extends User {
	private String coursesCompleteStatus;
	private double joinStatus;
	private double coursesPercentageFinish;
	
	public String getCoursesCompleteStatus() {
		if(coursesPercentageFinish==100) {
			coursesCompleteStatus="Kursu ba�ar�yla tamamlad�.";
			
		}
		else {
			coursesCompleteStatus="Kurs hen�z tamamlanmam��!";
			
		}
		
		return coursesCompleteStatus;
	}
	
	public double getJoinStatus() {
		return joinStatus;
	}
	public void setJoinStatus(double joinStatus) {
		this.joinStatus = joinStatus;
	}
	public double getCoursesPercentageFinish() {
		return coursesPercentageFinish;
	}
	public void setCoursesPercentageFinish(double coursesPercentageFinish) {
		this.coursesPercentageFinish = coursesPercentageFinish;
	}
	
}
