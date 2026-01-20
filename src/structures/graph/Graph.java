package structures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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

    //Grafo no dirigido
    public void addEdge(Node<T> n1, Node<T> n2) {
       addNode(n1);
       addNode(n2);
        mapa.get(n1).add(n2); // != nodo == A el valor
       //List<Node<T>> listadoNodo1 = mapa.get(n2);
       //listadoNodo1.add(n2);
       //lo mismo pero en una sola linea
       mapa.get(n2).add(n1);

       
    }

    public void addConocido (Node<T> n1, Node<T> n2) {
       addNode(n1);
       addNode(n2);
        mapa.get(n1).add(n2);
        //Del mapa obtengo el lsitado
       //get(n1) -> listado de N1
       // add(n2); -> agregar N2 al listado N1
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
    
    public List<Node<T>> getNeigbors2 (Node<T> n){
        return mapa.getOrDefault(n, List.of());

    }

    public void bfs(Node<T> start){
        Set<Node<T>> visitados = new LinkedHashSet<>();
        Queue<Node<T>> queue = new LinkedList<>();
        
        visitados.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {  //para romper, vaciar cola
            Node<T> current = queue.poll();
            System.out.println(current.getValue() + " ");

            for (Node<T> conocido : getNeighbors(current)) {
                if (!visitados.contains(conocido)) {
                    visitados.add(conocido);
                    queue.add(conocido);
                }
            }
        }

    }
    

    public void dfs(Node<T> start){
        Set<Node<T>> visitados = new LinkedHashSet<>();
        dfsRecursive(start,visitados);
    }
    private void dfsRecursive(Node<T> current, Set<Node<T>> visitados) {
        visitados.add(current);
        System.out.println(current.getValue() + " ");

        for (Node<T> conocido : getNeighbors(current)) {
            if (!visitados.contains(conocido)) {
                dfsRecursive(conocido, visitados);
                    
            }
        }
    }

}


