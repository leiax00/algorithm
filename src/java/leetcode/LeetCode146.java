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
        if (lastNode.getKey().equals(node.getKey())) {
            return node.getValue();
        }
        this.removeFromLink(node);
        lastNode.setLastNode(node);
        node.setPreNode(lastNode);
        node.setLastNode(null);
        lastNode = node;
        return node.getValue();
    }

    private void remove(int key) {
        Node<Integer> node = this.data.remove(key);
        removeFromLink(node);
    }

    private void removeFromLink(Node<Integer> node) {
        if (firstNode.equals(node)) {
            firstNode = firstNode.getLastNode();
            if (firstNode != null) {
                firstNode.setPreNode(null);
            }
        } else {
            Node<Integer> preNode = node.getPreNode();
            preNode.setLastNode(node.getLastNode());
        }
        node.setPreNode(null);
        node.setLastNode(null);
    }

    public void put(int key, int value) {
        while (this.nodeSize >= this.capacity) {
            this.remove(firstNode.getKey());
            this.nodeSize--;
        }
        if (data.containsKey(key)) {
            this.remove(key);
        }

        Node<Integer> item = new Node<>(key, value);
        this.nodeSize++;
        data.put(key, item);
        if (firstNode == null || lastNode == null) {
            firstNode = item;
            lastNode = item;
            return;
        }

        lastNode.setLastNode(item);
        item.setPreNode(lastNode);
        lastNode = item;
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
