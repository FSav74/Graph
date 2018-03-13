package it.altran.graphexample.bidirectional;

public class BidirectionalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Nodo nodoA = new Nodo("A");
		Nodo nodoB = new Nodo("B");
		Nodo nodoC = new Nodo("C");
		Nodo nodoD= new Nodo("D");
		Nodo nodoE= new Nodo("E");
		Nodo nodoF= new Nodo("F");
//		Nodo nodoG= new Nodo("G");
//		Nodo nodoH= new Nodo("H");
		
		Graph graph = new Graph();
		graph.addNodo(nodoA);
		graph.addNodo(nodoB);
		graph.addNodo(nodoC);
		graph.addNodo(nodoD);
		graph.addNodo(nodoE);
		graph.addNodo(nodoF);
		
		
		//                A <-> B->E
		//                 \>
		//                  C ->D ->E ->F
		//                   \
		//                    H
		graph.addConnection(nodoA, nodoB);
//		graph.addConnection(nodoA, nodoC);
		graph.addConnection(nodoC, nodoB);
		graph.addConnection(nodoB, nodoA);
//		graph.addConnection(nodoC, nodoD);
		graph.addConnection(nodoB, nodoE);
		graph.addConnection(nodoD, nodoC);
		
		graph.addConnection(nodoA, nodoF);
		graph.addConnection(nodoE, nodoD);
		
		
//		graph.addConnection(nodoC, nodoD);
//		graph.addConnection(nodoD, nodoE);
//		graph.addConnection(nodoE, nodoF);
//		graph.addConnection(nodoB, nodoG);
//		graph.addConnection(nodoC, nodoH);
		
		graph.listaAdiacence(nodoA);
		graph.listaAdiacence(nodoB);
		graph.listaAdiacence(nodoC);
		graph.listaAdiacence(nodoD);
//		graph.listaAdiacence(nodoE);
		graph.listaAdiacence(nodoF);
		
		
//		graph.findPath(nodoA, nodoC);
		graph.findPath(nodoB, nodoF);
		
		graph.stampaPercorso();
	}

}
