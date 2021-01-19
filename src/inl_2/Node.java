package inl_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {

    private String name;
    private Node parent;
    private List<Node> children;

    public Node(String name) {
        this.children = new ArrayList<>();
        this.name = name;
    }

    public void addSubordinates(Node... newChildren) {
        Arrays.stream(newChildren).forEach(c -> {
            c.setParent(this);
            this.children.add(c);
        });
    }

    private void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getSubordinates() {
        return getChild(new ArrayList<>(), this);
    }

    private List<Node> getChild(List<Node> acc, Node child) {
        if (child.children.isEmpty()) return acc;
        else {
            this.children.forEach(c -> {
                c.getChild(acc, c);
                acc.add(c);
            });
        }
        return acc;
    }

    public List<Node> getSuperiors() {
        return getParent(new ArrayList<>(), this.parent);
    }

    private List<Node> getParent(List<Node> acc, Node parent) {
        if (parent == null) return acc;
        else {
            getParent(acc, parent.parent);
            acc.add(parent);
        }
        return acc;
    }

    public String getName() {
        return name;
    }
}
