package it.altran.graphexample.generic;



public class MainGeneric {

	public static void main(String[] args) {
		
		//Integer

		
		Nodo<Integer> nodoA = new Nodo<Integer>(new Integer(1));
		Nodo<Integer> nodoB = new Nodo<Integer>(new Integer(2));
		Nodo<Integer> nodoC = new Nodo<Integer>(new Integer(3));
		Nodo<Integer> nodoD = new Nodo<Integer>(new Integer(4));
		Nodo<Integer> nodoE = new Nodo<Integer>(new Integer(5));
		
		GenericGraph<Integer> graph = new GenericGraph<>();
		graph.addNode(nodoA); 
		graph.addNode(nodoB);
		graph.addNode(nodoC);
		graph.addNode(nodoD);
		
		graph.addConnection(nodoA, nodoB);
		graph.addConnection(nodoA, nodoC);
		graph.addConnection(nodoB, nodoC);
		
		graph.listaAdiacence(nodoA);
		graph.listaAdiacence(nodoB);
		
		System.out.println("--------------");
		
		
		Nodo<String> nodo1 = new Nodo<String>("A");
		Nodo<String> nodo2 = new Nodo<String>("B");
		Nodo<String> nodo3 = new Nodo<String>("C");
		GenericGraph<String> graph2 = new GenericGraph<>();
		graph2.addNode(nodo1); 
		graph2.addNode(nodo2);
		graph2.addNode(nodo3);
		
		graph2.addConnection(nodo1, nodo2);
		graph2.addConnection(nodo1, nodo3);
		graph2.addConnection(nodo2, nodo2);
		
		graph2.listaAdiacence(nodo1);
		graph2.listaAdiacence(nodo2);
		
//		it.altran.graphexample.Nodo nodo = new it.altran.graphexample.Nodo("S");
//		graph2.addNode(nodo);
		
	}

}
