package it.altran.graphexample.bidirectional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

//Grafo bidirezionale 
public class Graph {

	private ArrayList<Nodo> listaNodi = new ArrayList<>();
	
	private HashSet<Nodo> listaNodiVisitati = new HashSet<>();//HashSet piu' veloce nel metodo contains
	
	private Percorso percorso = null;//HashSet piu' veloce nel metodo contains
	
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
//		rifNodeB.setNext(newNodoBA);   //Commento perchè non BI-direzionale
		
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
	public void stampaPercorso(){
	
		Nodo appo = percorso.getPartenza();
		String freccia="";
		while(appo!=null){
			System.out.print(""+freccia+""+appo.getValue());
			freccia="->";
			appo = appo.getNext();
		}
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
		System.out.println("----------------------------------------------");
		System.out.println("Cerco percorso da "+nodoesistente.getValue()+" a "+nodoesistente2.getValue());
		System.out.println("----------------------------------------------");
		Integer numeroPassi= new Integer(1);
		if (nodoA.compareTo(nodoB)==1){
			System.out.println("trovato con numero passi:"+numeroPassi);
		}
		
		percorso = new Percorso(nodoA);
		
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
		Nodo appo = nodoA.getNext();//
		while(appo!=null){
			
			//System.out.println("nodo:"+appo.getValue());
			if (appo.compareTo(nodoB)==1){
				percorso.addConnection(appo);
				System.out.println("trovato con numero passi:"+passo);
				return true;
			}
			appo = appo.getNext();	
		}
		
		
		appo = nodoA.getNext();
		
		
		
		boolean result = false;

		while(appo!=null){
			System.out.println("nodo:"+appo.getValue());
			Nodo adiacente =findNodo(appo);
			
			//System.out.println("nodo:"+adiacente.getValue());
			
			if(contiene(adiacente)){
				//System.out.println("nodo gia' visitato:"+adiacente.getValue());
				appo = appo.getNext();	
				continue;
			}
			listaNodiVisitati.add(adiacente);
			percorso.addConnection(adiacente);
			result= findPath(adiacente, nodoB, passo);
			if (result) {
				return true;
			}
			percorso.removeConnection();
			appo = appo.getNext();	
		}
		
		return result;
	}
	
	private boolean contiene(Nodo nodeA){
		
		Iterator<Nodo> nodo = listaNodiVisitati.iterator();
		while(nodo.hasNext()){
			Nodo nn = nodo.next();
			if (nn.compareTo(nodeA)==1)		
				return true;
		}
		return false;
		
	}
}
