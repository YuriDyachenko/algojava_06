package kurs;

public class Node {
    private Person person;
    private Node leftChild;
    private Node rightChild;

    public Node(Person person) {
        this.person = person;
        leftChild = null;
        rightChild = null;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" + person +"}";
    }
}
