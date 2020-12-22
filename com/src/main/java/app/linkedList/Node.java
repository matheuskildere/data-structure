package app.linkedList;

import app.estudante.Estudante;

public class Node {
    private Integer key;
    private Estudante estudante;
	private Node prox;
	private Node ant;
	
	public Node(Integer key,Estudante estudante){
        this.estudante = estudante;
        this.key = key;
		ant = null;
		prox = null;
	}
	
	public void setProx(Node n){
        prox = n;
    }
	public void setAnt(Node n){
        ant = n;
    }
	public void setInfo(Estudante i) {
        estudante = i;
    }
	public Node getProx() {
        return prox;
    }
	public Node getAnt(){
        return ant;
    }
    public Estudante getInfo(){
        return estudante;
    }
    public Integer getKey(){
        return key;
    }
}
