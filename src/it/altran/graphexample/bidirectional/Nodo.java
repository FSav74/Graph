package it.altran.graphexample.bidirectional;



public class Nodo implements Comparable<Nodo>{
	private String value;
    private Nodo next;
    
    public Nodo(String newValue){
    	value= newValue;
    	next=null;
    }

    
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Nodo getNext() {
		return next;
	}
	public void setNext(Nodo next) {
		this.next = next;
	}
	@Override
	public int compareTo(Nodo o) {
		if (value==null) return 0;
		
		if(value.equals(o.getValue())) return 1;
		
		return 0;
	}
	@Override
	public boolean equals(Object o){
		if (value==null) return false;
		
		Nodo oo = (Nodo) o;
		
		if(value.equals(oo.getValue())) return true;
		
		return false;
	}
    
    
}
