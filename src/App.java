import models.Person;
import structures.graph.BFSPathFinder;
import structures.graph.Graph;
import structures.graph.PathFinder;
import structures.graph.PathResult;
import structures.nodes.Node;
import structures.trees.IntTree;
import structures.trees.Tree;

public class App {
    public static void main(String[] args) throws Exception {
        runGrapgRecorridos();
    }

    private  static  void runGrapgRecorridos() {
        
        Graph<Person> grafo = new Graph<>();

        /** 
        Person pC23 = new Person("Carlos", 23);
        Person pL18 = new Person("Luis", 18);
        Person pA23 = new Person("Carlos", 23);
        Person pA30 = new Person("Carlos", 23);
        Person pJ25 = new Person("Carlos", 23);
        Person pAn20 = new Person("Ana", 23);

        //conecciones carlos 23
        grafo.addEdge(new Node<>(pC23), new Node<Person>(pA30));
        grafo.addConocido(new Node<>(pC23), new Node<Person>(pA30));

        grafo.addEdge(new Node<>(pC23), new Node<Person>(pA23));
        grafo.addConocido(new Node<>(pC23), new Node<Person>(pA23));

        grafo.addEdge(new Node<>(pC23), new Node<Person>(pL18));
        grafo.addConocido(new Node<>(pC23), new Node<Person>(pL18));

        //conecciones Luis 18

        grafo.addEdge(new Node<>(pL18), new Node<Person>(pA23));
        grafo.addConocido(new Node<>(pL18), new Node<Person>(pA23));

        grafo.addEdge(new Node<>(pL18), new Node<Person>(pJ25));
        grafo.addConocido(new Node<>(pL18), new Node<Person>(pJ25));

        //conocidos Andres 23

        grafo.addEdge(new Node<>(pA23), new Node<Person>(pL18));
        grafo.addConocido(new Node<>(pA23), new Node<Person>(pL18));

        //conecciones ana 30

        grafo.addEdge(new Node<>(pA30), new Node<Person>(pC23));
        grafo.addConocido(new Node<>(pA30), new Node<Person>(pC23));

        grafo.addEdge(new Node<>(pA30), new Node<Person>(pAn20));
        grafo.addConocido(new Node<>(pA30), new Node<Person>(pAn20));

        System.out.println("--------BFS--------");
        grafo.bfs(new Node<>(pC23));
        
        System.out.println("--------DFS--------");
        grafo.dfs(new Node<>(pC23));
        */

        Person pC23 = new Person("Carlos", 23);
        Person pL18 = new Person("Luis", 18);
        Person pA23 = new Person("Andres", 23);
        Person pA30 = new Person("Ana", 30);
        Person pJ25 = new Person("Juan", 25);
        Person pAn20 = new Person("Ana", 20);
        Person pM10 = new Person("Mateo", 10);
        Person pJ10 = new Person("Julio", 10);

        grafo.addEdge(new Node<>(pC23), new Node<>(pA30));
        grafo.addConocido(new Node<>(pC23), new Node<>(pL18));
        grafo.addConocido(new Node<>(pC23), new Node<>(pA23));
        grafo.addConocido(new Node<>(pL18), new Node<>(pJ25));
        grafo.addEdge(new Node<>(pL18), new Node<>(pA23));
        grafo.addConocido(new Node<>(pAn20), new Node<>(pA30));
        grafo.addEdge(new Node<>(pA30), new Node<>(pM10));
        grafo.addEdge(new Node<>(pM10), new Node<>(pJ10));

        PathFinder<Person> finder = new BFSPathFinder<>();
        PathResult<Person> resultado = finder.find(grafo,
            new Node<Person>(pC23), 
            new Node<Person>(pJ10));

        System.err.println("Orden BFS");
        resultado.getVisitados()
            .forEach((node) -> {
                System.err.println(node.getValue() + " ");

            });

        System.err.println("Ruta encontrada por BFS");
        resultado.getPath()
            .forEach((node) -> {
                System.err.println(node.getValue() + " ");

            });
    }

    private static void runTree(){
        Tree<Person> tree = new Tree<Person>();
        tree.insert(new Person("Pablo", 21));
        tree.insert(new Person("Maria", 23));
        tree.insert(new Person("Pedro", 25));
        tree.insert(new Person("Ana", 23));
        tree.insert(new Person("Luis", 19));
        tree.inOrder();

        Person findPerson = tree.searchByAge(23);
        if (findPerson != null) {
            System.out.println(findPerson);
        }else{
            System.out.println("no se encontro");
        }
    }

    private static void runIntTree() {

        IntTree tree = new IntTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(3);
        tree.insert(15);
        System.out.println("\nPre Order");
        tree.preOrder();
        System.out.println("\nPost Order");
        tree.postOrder();
        System.out.println("\nIn Order");
        tree.inOrder();
        System.out.println("\nSize: " + tree.size());

    }

    private  static  void runGrapg() {
        Graph<String> graph = new Graph<>();

        Node<String> nA = new Node<String>("A");
        Node<String> nB = new Node<String>("B");
        Node<String> nC = new Node<String>("C");
        Node<String> nD = new Node<String>("D");

        graph.addNode(nA);
        graph.addEdge(nA, nB);
        graph.addEdge(nA, nC);
        graph.addEdge(nB, nD);
        graph.addEdge(nC, nD);

        graph.printGraph();

        // Conectados con A
        
        Node<String>[] neighbors = graph.getNeighbors(nA);
        System.out.print("Vecinos de A: ");
        for(Node<String> neighbor : neighbors){
            System.out.print(neighbor + " ");
        }
        

    }
    
}
