
public class Main {

	public static void main(String[] args) {
		
		Kurs kurs1 = new Kurs("C# + ANGULAR",100,"ENG�N DEM�RO�");
		Kurs kurs2 = new Kurs("JAVA + REACT",20,"ENG�N DEM�RO�");
		Kurs kurs3 = new Kurs("PROGRAMLAMAYA G�R�� ���N TEMEL KURS",100,"ENG�N DEM�RO�");
		
		Kurs[] kurslar= {kurs1,kurs2,kurs3};
		
		for(var kurs:kurslar) {
			System.out.println(kurs.name+"\t"+"%"+kurs.percent+"\t"+kurs.educator);
			System.out.println("------------------------");
		}
		kursManager kursmanager = new kursManager();
		kursmanager.joinKurs(kurs1);
	}

}
