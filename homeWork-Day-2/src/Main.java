
public class Main {

	public static void main(String[] args) {
		
		Kurs kurs1 = new Kurs("C# + ANGULAR",100,"ENGÝN DEMÝROÐ");
		Kurs kurs2 = new Kurs("JAVA + REACT",20,"ENGÝN DEMÝROÐ");
		Kurs kurs3 = new Kurs("PROGRAMLAMAYA GÝRÝÞ ÝÇÝN TEMEL KURS",100,"ENGÝN DEMÝROÐ");
		
		Kurs[] kurslar= {kurs1,kurs2,kurs3};
		
		for(var kurs:kurslar) {
			System.out.println(kurs.name+"\t"+"%"+kurs.percent+"\t"+kurs.educator);
			System.out.println("------------------------");
		}
		kursManager kursmanager = new kursManager();
		kursmanager.joinKurs(kurs1);
	}

}
