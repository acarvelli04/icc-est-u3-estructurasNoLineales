package structures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import structures.nodes.Node;

public class Graph<T> {
    //1ra forma
    //Trabajar con lsitados de Abyaciencia
    //private List<Node<T>> nodes;

    //2da forma
    private Map<Node<T>, List<Node<T>>> mapa;

    public Graph() {
        //this.nodes = new ArrayList<>();
        this.mapa = new HashMap<Node<T>, List<Node<T>>>();
    }
/**
    public void insertNode(T value) {
        Node<T> newNode = new Node<>(value);
        this.nodes.add(newNode);
    }
/* */

    public void addNode(Node<T> node) {
       mapa.putIfAbsent(node, new ArrayList<>());
    }

    public void addEdge(Node<T> n1, Node<T> n2) {
       addNode(n1);
       addNode(n2);
        mapa.get(n1).add(n2); // != nodo == A el valor
       //List<Node<T>> listadoNodo1 = mapa.get(n2);
       //listadoNodo1.add(n2);
       //lo mismo pero en una sola linea
       mapa.get(n2).add(n1);
    }

    public void printGraph(){
        for(Map.Entry<Node<T> , List<Node<T>>> entry : mapa.entrySet()){
            System.out.print(entry.getKey() + " -> ");
            for(Node<T> neighbor : entry.getValue()){
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

   
    @SuppressWarnings("unchecked")
    public Node<T>[] getNeighbors(Node<T> node) {
        List<Node<T>> neighbors = mapa.get(node);

        if (neighbors == null) {
            return (Node<T>[]) new Node[0];
        }

        return neighbors.toArray((Node<T>[]) new Node[neighbors.size()]);
    }
    

}


