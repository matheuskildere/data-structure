package app.linkedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import app.estudante.Estudante;

public class DoubleLinkedList implements Map<Integer, Estudante> {
    private Node start;
    private Node end;
    private int size;
    private List<Integer> listKey;

    public DoubleLinkedList() {
        start = null;
        listKey = new ArrayList<>();
        end = null;
    }

    @Override
    public String toString() {
        Node aux = start;
        String toString = "";
        while (aux != null) {
            toString += aux.getInfo().toString() + "\n";
            aux = aux.getProx();
        }
        return toString;
    }

    @Override
    public void clear() {
        if(start != null){
            Node aux = start.getProx();
            while(aux != null){
                if(aux.getProx() == null){
                    aux.setAnt(null);
                    start = null;
                    end = null;
                    aux = null;
                }else{
                    aux.setAnt(null);
                }
            }
            size = 0;
        }
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        if(start == null){
            return false;
        }else{
            Node aux = start;
            while(aux != null){
                if(aux.getInfo().getMatricula() == ((Estudante) value).getMatricula()){
                    return true;
                }
                aux = aux.getProx();
            }
        }
        return false;
    }

    @Override
    public Set<Entry<Integer, Estudante>> entrySet() {
        return null;
    }
    
    @Override
    public Estudante get(Object key) {
        if(start == null){
            return null;
        }else{
            Node nodeAux = start;
            while(nodeAux != null){
                if(nodeAux.getKey() == key){
                    return nodeAux.getInfo();
                }
                nodeAux = nodeAux.getProx();
            }
        }
        return null;
    }

    
    @Override
    public Estudante put(Integer key, Estudante value) {
        Node newNode = new Node(key, value);
        if(start == null){
            start = newNode;
            end = newNode;
            listKey.add(newNode.getKey());
            size ++;
            return newNode.getInfo();
        }
        else{
            Estudante gEstudante = get(key);
            if(gEstudante != null){
                Node nodeSet = start;
                while (nodeSet != null) {
                    if(nodeSet.getKey() == gEstudante.getMatricula()){
                        nodeSet.getProx().setAnt(newNode);
                        nodeSet.getAnt().setProx(newNode);
                        return gEstudante;
                    }
                    nodeSet = nodeSet.getProx();
                }
            }
            return insertionSort(newNode);
        }
    }

    private Estudante insertionSort(Node newNode){
        Node aux = start;
        while(aux != null){
            if(aux.getKey() > newNode.getKey()){
                if(aux == start){
                    newNode.setProx(start);
                    start.setAnt(newNode);
                    start = newNode;
                    break;
                }else {
                    if(aux == end){
                        Node nodeAnt = end.getAnt();
                        end.setAnt(newNode);
                        nodeAnt.setProx(newNode);
                        newNode.setAnt(nodeAnt);
                        newNode.setProx(end);
                        break;
                    }else {
                        Node previous = aux.getAnt();
                        aux.setAnt(newNode);
                        newNode.setProx(aux);
                        newNode.setAnt(previous);
                        previous.setProx(newNode);
                        break;
                    }
                }
            }else{
                if(aux == end){
                    newNode.setAnt(aux);
                    aux.setProx(newNode);
                    end = newNode;
                    end.setProx(null);
                    break;
                }
            }
            aux = aux.getProx();
        }
        listKey.add(newNode.getKey());
        size ++;
        return newNode.getInfo();
    }
    
    @Override
    public Estudante remove(Object key) {
        if(start != null){
            Node aux = start;
            while(aux != null){
                if(aux.getKey() == key){
                    if(aux == start){
                        aux.getProx().setAnt(null);
                        start = aux.getProx();
                        size --;
                        return aux.getInfo();
                    }else{
                        if(aux == end){
                            aux.getAnt().setProx(null);
                            end = aux.getAnt();
                            size --;
                            return aux.getInfo();
                        }else{
                            aux.getProx().setAnt(aux.getAnt());
                            aux.getAnt().setProx(aux.getProx());
                            size --;
                            return aux.getInfo();

                        }
                    }
                }
                aux = aux.getProx();
            }

        }else{
            return null;
        }

        return null;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Estudante> m) {
    }
    
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public Collection<Estudante> values() {
        return null;
    }
    
    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Set<Integer> keySet() {
        return null;
    }
}
