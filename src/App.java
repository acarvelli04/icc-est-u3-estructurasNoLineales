import trees.IntTree;

public class App {
    public static void main(String[] args) throws Exception {
        runIntTree();
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
}
