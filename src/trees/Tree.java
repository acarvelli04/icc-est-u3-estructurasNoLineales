package trees;
import models.Person;
import nodes.Node;

public class Tree<T extends Comparable<T>> {
    
    private Node<T> root;
    private int size;

    public Tree() {
        this.root = null;
    }

    public void insert(T value) {
        root = insertRecursive(root, value);
    }

    private Node<T> insertRecursive(Node<T> current, T value) {
        if (current == null) {
            
            return new Node<>(value);
        }

        if (value.compareTo(current.getValue()) < 0) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value.compareTo(current.getValue()) > 0) {
            current.setRight(insertRecursive(current.getRight(), value));
        }
        return current;
    }

    public void inOrder() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node<T> node) {
        if (node != null) {
            inOrderRecursive(node.getLeft());
            System.out.print(node.getValue() + " ");
            inOrderRecursive(node.getRight());
        }
    }

    //size O(1)

    public int size() {
        return size;
    }
    public T search (T value){
        return searchByRecursive(root, value);
    }

    private T searchByRecursive(Node<T> root2, T value) {
        return null;
    }

    public T searchByAge(int i) {
        return searchByAgeRecursive(root ,i);
    }

    private T searchByAgeRecursive(Node<T> current, int age) {
        if (current == null) {
            return null;
        }

        Person persona = (Person) current.getValue();

        if (age == persona.getEdad()) {
            return current.getValue(); 
        }

        if (age < persona.getEdad()) {
            return searchByAgeRecursive(current.getLeft(), age);
        } else {
            return searchByAgeRecursive(current.getRight(), age); 
        }

    }
}
