package it.altran.graphexample.bidirectional;

public class Percorso {

	private Nodo partenza;
	private int numeroNodi = 0;
	
	public Percorso(Nodo iniziale){
		
		partenza = new Nodo(iniziale.getValue());
		numeroNodi=1;
		
	}
	
	//inserimento all'inizio
	public void addConnection(Nodo nodeA){
		
				
		Nodo nodoAppoA = partenza;
		//partenza non può essere null
		
		Nodo succ = nodoAppoA.getNext();
		while(succ!=null){
			
			nodoAppoA = nodoAppoA.getNext();
			succ = succ.getNext();		
		}
		if(succ==null){
			Nodo newN = new Nodo(nodeA.getValue());
			nodoAppoA.setNext(newN);
		}
			

		
//		Nodo newNodo = new Nodo(nodeA.getValue());
//		newNodo.setNext(nodoAppoA);
//		
//
//		
//		partenza.setNext(newNodo);
		numeroNodi++;
	
	}
	public void removeConnectionOLD(){
		
		
		Nodo nodoAppoA = partenza.getNext();
		partenza.setNext(nodoAppoA.getNext());
		
		numeroNodi--;
	}
	
	public void removeConnection(){
		Nodo nodoAppoA = partenza;
		//partenza non può essere null
		
		Nodo succ = nodoAppoA.getNext();
		if (succ==null){
			return;
		}
		Nodo succNext = succ.getNext();
		while(succNext!=null){
			
			nodoAppoA = nodoAppoA.getNext();
			succNext = succNext.getNext();		
		}
		nodoAppoA.setNext(null);
		
	}

	public Nodo getPartenza() {
		return partenza;
	}

	public void setPartenza(Nodo partenza) {
		this.partenza = partenza;
	}

	public int getNumeroNodi() {
		return numeroNodi;
	}

	public void setNumeroNodi(int numeroNodi) {
		this.numeroNodi = numeroNodi;
	}
	
	
}
