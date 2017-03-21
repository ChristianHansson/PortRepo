public class FordonRegister {

	private Fordon[] fordon;
	
	private int size= 0;

	public FordonRegister(int amount) {
		this.fordon = new Fordon[amount];
	}	
	// add: l�gger till nytt fordon
	// pre: �gare till ett visst fordon skapad, registret inte
	//fullt
	// post: Fordonet tillagt i registret
	public void add(String regnr, String brand, String type, Person owner){
		fordon[size] = new Fordon(regnr, brand, type, owner);
		size++; 
	}

	public void add(Fordon fordon){
		this.fordon[size] = fordon;
		size++;
	}
	// remove: tar bort ett fordon
	// pre: position laglig (0 <=pos && pos < size())
	// post: fordon p� position pos borttagen
	// �gare p� h�gre positioner har skiftats ner f�r att undvika
	// �h�l� i lagringsutrymmet.
	public void remove(int pos) {
		this.fordon[pos] = null;
		
		for (int i = pos; i < this.size() - 1; i++){
			this.fordon[i] = this.fordon[i+1];
		}
		this.fordon[size - 1] = null;
		size--;
	}
	// getFordon: h�mtar fordonet p� position pos i registret
	// pre: position laglig (0 <=pos && pos < size())
	// post: �gare p� position pos returnerad
	public Fordon getFordon(int pos) {
		return this.fordon[pos];
	}
	// size: returnerar antalet �gare i registret
	// pre: true
	// post: antalet �gare i registret returnerat
	public int size() {
		return size;
	}
	// maxSize: returnerar maximal storlek p� registret
	// pre: true
	// post: maximal storlek f�r registret returnerad
	public int maxSize() {
		return this.fordon.length;
	}
	// skrivUt: skriver ut information om ett fordon
	// pre: position laglig (0 <=pos && pos < size())
	// post: fordonet p� position pos utskrivet
	public void skrivUt(int pos) {
		Fordon f = this.getFordon(pos);
		if (f!=null){
			System.out.printf("Fordon: %s, (%s, %d) %s, %s\n", f.brand, f.owner.name, f.owner.age, f.regnr, f.type);	
		}
		else {
			System.out.println("Inget fordon p� position: "+pos);
		}
		
	}
}