package kurs;

public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public Node find(int id) {
        if (root == null) return null;
        Node current = root;
        int currentId = current.getPerson().getId();
        while (currentId != id) {
            if (id < currentId) current = current.getLeftChild();
            else current = current.getRightChild();
            if (current == null) return current;
            currentId = current.getPerson().getId();
        }
        return current;
    }

    public void insert(Person person) {
        Node node = new Node(person);
        if (root == null) {
            root = node;
            return;
        }
        Node current = root;
        Node parent;
        while (true) {
            parent = current;
            int currentId = current.getPerson().getId();
            int id = person.getId();
            if (id < currentId) {
                current = current.getLeftChild();
                if (current == null) {
                    parent.setLeftChild(node);
                    return;
                }
            } else {
                current = current.getRightChild();
                if (current == null) {
                    parent.setRightChild(node);
                    return;
                }
            }
        }
    }

    public Node max() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.getRightChild();
        }
        return last;
    }

    public Node min() {
        Node current = root;
        Node last = null;
        while (current != null) {
            last = current;
            current = current.getLeftChild();
        }
        return last;
    }

    public boolean delete(int id) {
        if (root == null) return false;
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        int currentId = current.getPerson().getId();
        while (currentId != id) {
            parent = current;
            if (id < currentId) {
                isLeftChild = true;
                current = current.getLeftChild();
            } else {
                isLeftChild = false;
                current = current.getRightChild();
            }
            if (current == null) return false;
            currentId = current.getPerson().getId();
        }
        if (current.getLeftChild() == null && current.getRightChild() == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
        } else if (current.getRightChild() == null) {
            if (current == null) {
                root = current.getLeftChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getLeftChild());
            } else {
                parent.setRightChild(current.getLeftChild());
            }
        } else if (current.getLeftChild() == null) {
            if (current == null) {
                root = current.getRightChild();
            } else if (isLeftChild) {
                parent.setLeftChild(current.getRightChild());
            } else {
                parent.setRightChild(current.getRightChild());
            }
        } else {
            Node succesor = getSuccesor(current);
            if (current == root) {
                root = succesor;
            } else if (isLeftChild) {
                parent.setLeftChild(succesor);
            } else {
                parent.setRightChild(succesor);
            }
        }
        return true;
    }

    private Node getSuccesor(Node node) {
        Node succesorParent = node;
        Node succesor = node;
        Node current = node.getRightChild();
        while (current != null) {
            succesorParent = succesor;
            succesor = current;
            current = current.getLeftChild();
        }
        if (succesor != node.getRightChild()) {
            succesorParent.setLeftChild(succesor.getRightChild());
            succesor.setRightChild(node.getRightChild());
        }
        return succesor;
    }

    private void inOrderToStringBuilder(Node start, StringBuilder sb, Node max) {
        if (start != null) {
            inOrderToStringBuilder(start.getLeftChild(), sb, max);
            sb.append(start);
            if (start != max) sb.append(",\n  ");
            inOrderToStringBuilder(start.getRightChild(), sb, max);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Tree{");
        inOrderToStringBuilder(root, sb, max());
        sb.append("}");
        return sb.toString();
    }
}
