import java.util.*;

public class Gr�nssnitt {

	private FordonRegister register = new FordonRegister(10);
	private String regnr;
	private String brand;
	private String type;
	private String ownerName;
	private int ownerAge;
	private Scanner s;

	public void run () {
		int input = 0;
		int pos = 0;
		do{
			input=this.menu();
			switch (input) {
			case 1:
				s.reset();
				System.out.println("## L�gg till ett fordon ##");
				System.out.println("Mata in fordonets regnummer");
				regnr = s.nextLine();
				System.out.println("Mata in fordonets m�rke");
				brand = s.nextLine();
				System.out.println("Mata in fordonets typ");
				type = s.nextLine();
				System.out.println("Mata in �garens namn");
				ownerName = s.nextLine();
				System.out.println("Mata in �garens �lder");
				ownerAge = s.nextInt();                
				register.add(regnr, brand, type, new Person(ownerName, ownerAge));
				break;
			case 2:
				pos = s.nextInt();
				register.remove(pos);
				break;
			case 3:
				pos = s.nextInt();
				register.skrivUt(pos);
				break;
			case 4:
				int amountFordon = register.size();
				System.out.println(amountFordon+" Fordon i Fordonsregisteret");
				System.out.println();

				for (int i = 0; i < register.size(); i++){
					register.skrivUt(i);
					System.out.println();
				}

				break;
			}

		}while(input!=0);
		s.close();
	}      

	private int menu (){

		int val = 0;
		System.out.println("1. L�gg till ett fordon:");
		System.out.println("2. Ta bort ett fordon:");
		System.out.println("3. Skriv ut information om ett fordon:");
		System.out.println("4. Skriv ut hela fordonsregistret:");
		val = s.nextInt();
		s.nextLine(); 

		return val;
	}

	public Gr�nssnitt() {
		s = new Scanner(System.in);
	}

	public static void main (String args []){
		Gr�nssnitt program = new Gr�nssnitt();
		program.run();
	}
}


