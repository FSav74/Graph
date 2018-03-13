package it.altran.graphexample;

import java.util.ArrayList;
import java.util.Iterator;

//Grafo unidirezionale 
// per quello bidirezionale bisogna rivedere l'algoritmo (che può andare in loop)
//  //bisogna tenere conto dei nodi visitati
public class Graph {

	private ArrayList<Nodo> listaNodi = new ArrayList<>();
	
	public Nodo addNodo(Nodo newNode){
		if (newNode==null) return null;
		
		Nodo nodoesistente = findNodo(newNode);
		if(nodoesistente==null) {
			listaNodi.add(newNode);
			System.out.println("Inserisco nodo: "+newNode.getValue());
			return newNode;
		}
		System.out.println("Nodo: "+newNode.getValue()+" gia' presente.");
		return nodoesistente;

	}
	
	public void addConnection(Nodo nodeA, Nodo nodeB){
		
		//1)se nodeA non esiste : lo creo e lo inserisco in listaNodi 
		//2)se nodeB non esiste : lo creo e lo inserisco in listaNodi
		
		Nodo rifNodeA = addNodo(nodeA);
		Nodo rifNodeB = addNodo(nodeB);
		
		Nodo nodoAppoA = rifNodeA.getNext();
		Nodo nodoAppoB = rifNodeB.getNext();
		
		Nodo newNodoAB = new Nodo(nodeB.getValue());
		newNodoAB.setNext(nodoAppoA);
		
		Nodo newNodoBA = new Nodo(nodeA.getValue());
		newNodoBA.setNext(nodoAppoB);
		
		rifNodeA.setNext(newNodoAB);
		//rifNodeB.setNext(newNodoBA);   //Commento perchè non BI-direzionale
		
	}
	
	//mi ritorna il riferimento al nodo esitente che ha valore uguale a quello di ref
	//altrimenti torna null;
	public Nodo findNodo(Nodo ref){
		Iterator<Nodo> iterator =listaNodi.iterator();
		boolean isContained = false;
		while(iterator.hasNext()){
			Nodo nodeNext = iterator.next();
			if (nodeNext.compareTo(ref)==1)
				return nodeNext;
		}
		return null;
	}
	
	public void listaAdiacence(Nodo nodo){
		Nodo nodoesistente = findNodo(nodo);
		if(nodoesistente==null) {
			System.out.println("Nodo non esistente.");
		}
		Nodo nextNode = nodoesistente.getNext();
		StringBuffer buffer = new StringBuffer();
		while(nextNode!=null){
			buffer.append(nextNode.getValue()+" ");
			nextNode = nextNode.getNext();	
		}
		System.out.println("Lista adiacenti Nodo "+nodoesistente.getValue()+":"+buffer.toString());
	}
	
	
	public boolean findPath(Nodo nodoA, Nodo nodoB){
		Nodo nodoesistente = findNodo(nodoA);
		if(nodoesistente==null) {
			System.out.println("Nodo non esistente.");
			return false;
		}
		Nodo nodoesistente2 = findNodo(nodoB);
		if(nodoesistente2==null) {
			System.out.println("Nodo non esistente.");
			return false;
		}
		
		Integer numeroPassi= new Integer(0);
		if (nodoA.compareTo(nodoB)==1){
			System.out.println("trovato con numero passi:"+numeroPassi);
		}
		
		
		boolean result =  findPath(nodoesistente, nodoesistente2, numeroPassi);
		if (result){
			System.out.println("Trovato !");
		}
		else System.out.println("Non trovato.");
		return result;
	}
	
	
	public boolean findPath(Nodo nodoA, Nodo nodoB, int passo){
		

		passo++;
		System.out.println("Cerco nella lista adicence di "+nodoA.getValue());
		Nodo appo = nodoA;
		while(appo!=null){
			
			if (appo.compareTo(nodoB)==1){
				System.out.println("trovato con numero passi:"+passo);
				return true;
			}
			appo = appo.getNext();	
		}
		
		
		appo = nodoA.getNext();
		
		boolean result = false;
		while(appo!=null){
			
			Nodo adiacente =findNodo(appo);
			
			result= findPath(adiacente, nodoB, passo);
			if (result) return true;
			appo = appo.getNext();	
		}
		
		return result;
	}
}
