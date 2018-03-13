package it.altran.graphexample.generic;

public class Nodo<E> implements Comparable<Nodo<E>>{
	private E value;
    private Nodo<E> next;
    
    public Nodo(E newValue){
    	value= newValue;
    	next=null;
    }

    
	public E getValue() {
		return value;
	}
	public void setValue(E value) {
		this.value = value;
	}
	public Nodo<E> getNext() {
		return next;
	}
	public void setNext(Nodo<E> next) {
		this.next = next;
	}
	@Override
	public int compareTo(Nodo<E> o) {
		if (value==null) return 0;
		
		if(value.equals(o.getValue())) return 1;
		
		return 0;
	}
    
    
}
