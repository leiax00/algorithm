package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LeetCode146 {

    private Node<Integer> firstNode;
    private Node<Integer> lastNode;
    private int nodeSize;
    private Map<Integer, Node<Integer>> data;
    private int capacity;

    public LeetCode146(int capacity) {
        this.capacity = capacity;
        data = new HashMap<>(capacity);
    }

    public int get(int key) {
        Node<Integer> node = data.get(key);
        if (node == null) {
            return -1;
        }
        if (lastNode.equals(node)) {
            return node.getValue();
        }
        this.removeFromLink(node);
        this.addLast(node);
        return node.getValue();
    }

    public void put(int key, int value) {
        if (data.containsKey(key)) {
            this.remove(key);
        }
        while (this.nodeSize >= this.capacity) {
            this.remove(firstNode.getKey());
        }
        Node<Integer> item = new Node<>(key, value);
        this.nodeSize++;
        data.put(key, item);
        if (firstNode == null || lastNode == null) {
            firstNode = item;
            lastNode = item;
            return;
        }
        this.addLast(item);
    }

    private void addLast(Node<Integer> node) {
        lastNode.setLastNode(node);
        node.setPreNode(lastNode);
        node.setLastNode(null);
        lastNode = node;
    }

    private void remove(int key) {
        Node<Integer> node = this.data.remove(key);
        removeFromLink(node);
        this.nodeSize--;
    }

    private void removeFromLink(Node<Integer> node) {
        if (firstNode.equals(node)) {
            firstNode = firstNode.getLastNode();
            if (firstNode != null) {
                firstNode.setPreNode(null);
            }
        } else if (lastNode.equals(node)) {
            Node<Integer> preNode = node.getPreNode();
            preNode.setLastNode(null);
            lastNode = preNode;
        }else {
            Node<Integer> preNode = node.getPreNode();
            Node<Integer> lastNode = node.getLastNode();
            preNode.setLastNode(lastNode);
            lastNode.setPreNode(preNode);
        }
        node.setPreNode(null);
        node.setLastNode(null);
    }


    class Node<T> {
        private Node<T> preNode;
        private T key;
        private T value;
        private Node<T> lastNode;

        public Node(T key, T value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node<?> node = (Node<?>) o;
            return key.equals(node.key);
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        public Node<T> getPreNode() {
            return preNode;
        }

        public void setPreNode(Node<T> node) {
            this.preNode = node;
        }

        public Node<T> getLastNode() {
            return lastNode;
        }

        public void setLastNode(Node<T> node) {
            this.lastNode = node;
        }

        public T getKey() {
            return key;
        }

        public void setKey(T key) {
            this.key = key;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }
    }
}
