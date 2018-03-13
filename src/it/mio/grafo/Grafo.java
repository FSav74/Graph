package it.mio.grafo;

import it.universita.grafo.Arco;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Classe grafo creata semplificando la it.universita.grafo.Grafo
 * 
 * Il grafo è implementato come Hashmap di HashSet 
 * Ogni nodo è solo una Stringa 
 * 
 * Non pesato, unidirezionale
 * 
 * @author Admin
 *
 */
public class Grafo {
	
	private HashMap<String, HashSet<String>> nodi = new HashMap<>();
	
	public void addNodo(String nodo){
		nodi.put(nodo, new HashSet<String>());
	}
	
	public void addArco(String nodo1, String nodo2){
		if (!nodi.containsKey(nodo1)){
			addNodo(nodo1);
		}
		HashSet<String> archi = nodi.get(nodo1);
	
		if (!archi.contains(nodo2)){
			archi.add(nodo2);
		}else
			System.out.println("E' già presente un arco da "+nodo1+ " a "+nodo2);
	}
	
	public boolean findPath(String nodoDA, String nodoA){
		
		
		HashSet<String> visitati = new HashSet<>();
		HashSet<String> percorso = new HashSet<>();
		boolean result = recursivePathFinding(nodoDA, nodoA, visitati, percorso);
		System.out.println("Percorso "+percorso);
		return result;
	}
	public boolean recursivePathFinding(String nodoDA, String nodoA, HashSet<String> visitati,  HashSet<String> percorso){
		
		System.out.println("Path finding from node "+nodoDA+ " to "+nodoA);
		percorso.add(nodoDA);
		HashSet<String> archi = nodi.get(nodoDA);
		if(archi!=null){
			if(archi.contains(nodoA)){
				percorso.add(nodoA);
				return true;
			}
		
			boolean result = false;
			Iterator<String> archiI = archi.iterator();
			while(archiI.hasNext()){
				String adiacente = archiI.next();
				if (visitati.contains(adiacente)) continue;
				result = recursivePathFinding(adiacente, nodoA,  visitati, percorso);
				visitati.add(adiacente);
				if (result) return true;
			}
		}
		percorso.remove(nodoA);
		return false;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grafo grafo = new Grafo();
		grafo.addNodo("A");
		grafo.addNodo("B");
		grafo.addNodo("C");
		grafo.addNodo("D");
		grafo.addNodo("E");
		grafo.addNodo("F");
		grafo.addNodo("G");
		grafo.addArco("A", "B");
		grafo.addArco("B", "C");
		grafo.addArco("B", "F");
		grafo.addArco("F", "G");
		grafo.addArco("C", "D");
		grafo.addArco("D", "E");
		
		System.out.println(grafo);
		boolean result = grafo.findPath("B", "E");
		System.out.println("RESULT:"+result);
	}

	
	public String toString() {
	    StringBuffer out = new StringBuffer();
	    
	    Iterator nodoI = nodi.keySet().iterator();
	    while (nodoI.hasNext()) {
	    	String nodo = (String) nodoI.next();//chiave
	    	out.append("Nodo " + nodo.toString() + ": ");
	    	Iterator arcoI = nodi.get(nodo).iterator();
	    	while (arcoI.hasNext()) {
	    		String  a = (String)arcoI.next();
	    		out.append(a.toString()+", ");
	    	}
	    	out.append("\n");
	    }
	    return out.toString();
	  }
}
