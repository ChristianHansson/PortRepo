public class FordonRegister {

	private Fordon[] fordon;
	
	private int size= 0;

	public FordonRegister(int amount) {
		this.fordon = new Fordon[amount];
	}	
	// add: lägger till nytt fordon
	// pre: ägare till ett visst fordon skapad, registret inte
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
	// post: fordon på position pos borttagen
	// ägare på högre positioner har skiftats ner för att undvika
	// “hål” i lagringsutrymmet.
	public void remove(int pos) {
		this.fordon[pos] = null;
		
		for (int i = pos; i < this.size() - 1; i++){
			this.fordon[i] = this.fordon[i+1];
		}
		this.fordon[size - 1] = null;
		size--;
	}
	// getFordon: hämtar fordonet på position pos i registret
	// pre: position laglig (0 <=pos && pos < size())
	// post: ägare på position pos returnerad
	public Fordon getFordon(int pos) {
		return this.fordon[pos];
	}
	// size: returnerar antalet ägare i registret
	// pre: true
	// post: antalet ägare i registret returnerat
	public int size() {
		return size;
	}
	// maxSize: returnerar maximal storlek på registret
	// pre: true
	// post: maximal storlek för registret returnerad
	public int maxSize() {
		return this.fordon.length;
	}
	// skrivUt: skriver ut information om ett fordon
	// pre: position laglig (0 <=pos && pos < size())
	// post: fordonet på position pos utskrivet
	public void skrivUt(int pos) {
		Fordon f = this.getFordon(pos);
		if (f!=null){
			System.out.printf("Fordon: %s, (%s, %d) %s, %s\n", f.brand, f.owner.name, f.owner.age, f.regnr, f.type);	
		}
		else {
			System.out.println("Inget fordon på position: "+pos);
		}
		
	}
}