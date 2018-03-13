package it.altran.graphexample.generic;




import it.altran.graphexample.generic.Nodo;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericGraph<E extends Comparable<E>> {

	private ArrayList<Nodo<E>> listaNodi = new ArrayList<>();
	
	public Nodo<E> addNode(Nodo<E> newNode){
		if (newNode==null) return null;
		
		Nodo<E> nodoesistente = findNodo(newNode);
		if(nodoesistente==null) {
			listaNodi.add(newNode);
			System.out.println("Inserisco nodo: "+newNode.getValue());
			return newNode;
		}
		System.out.println("Nodo: "+newNode.getValue()+" gia' presente.");
		return nodoesistente;

	}
	
	public Nodo<E> findNodo(Nodo<E> ref){
		Iterator<Nodo<E>> iterator =listaNodi.iterator();
		
		while(iterator.hasNext()){
			Nodo<E> nodeNext = iterator.next();
			if (nodeNext.compareTo(ref)==1)
				return nodeNext;
		}
		return null;
	}
	
	public void listaAdiacence(Nodo<E> nodo){
		Nodo<E> nodoesistente = findNodo(nodo);
		if(nodoesistente==null) {
			System.out.println("Nodo non esistente.");
		}
		Nodo<E> nextNode = nodoesistente.getNext();
		StringBuffer buffer = new StringBuffer();
		while(nextNode!=null){
			buffer.append(nextNode.getValue()+" ");
			nextNode = nextNode.getNext();	
		}
		System.out.println("Lista adiacenti Nodo "+nodoesistente.getValue()+":"+buffer.toString());
	}
	
	public void addConnection(Nodo<E> nodeA, Nodo<E> nodeB){
		
		//1)se nodeA non esiste : lo creo e lo inserisco in listaNodi 
		//2)se nodeB non esiste : lo creo e lo inserisco in listaNodi
		
		Nodo<E> rifNodeA = addNode(nodeA);
		Nodo<E> rifNodeB = addNode(nodeB);
		
		Nodo<E> nodoAppoA = rifNodeA.getNext();
		Nodo<E> nodoAppoB = rifNodeB.getNext();
		
		Nodo<E> newNodoAB = new Nodo(nodeB.getValue());
		newNodoAB.setNext(nodoAppoA);
		
		Nodo<E> newNodoBA = new Nodo(nodeA.getValue());
		newNodoBA.setNext(nodoAppoB);
		
		rifNodeA.setNext(newNodoAB);
		//rifNodeB.setNext(newNodoBA);
		
	}
}
