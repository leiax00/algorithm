package leetcode;

import java.util.HashMap;
import java.util.Map;

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

        Node<Integer> preNode = node.getPreNode();
        if (preNode != null) {
            preNode.setLastNode(node.getLastNode());
        } else {
            firstNode = node.getLastNode();
        }
        node.setPreNode(null);
        node.setLastNode(null);
        lastNode.setLastNode(node);
        lastNode = node;
        return node.getValue();
    }

    public void remove(Node<Integer> node) {
        if (firstNode.equals(node)) {
            firstNode = firstNode.getLastNode();
            firstNode.setPreNode(null);
        } else {
            Node<Integer> preNode = node.getPreNode();
            preNode.setLastNode(node.getLastNode());
        }
        node.setPreNode(null);
        node.setLastNode(null);
    }

    public void put(int key, int value) {
        Node<Integer> item = data.get(key);
        if (item != null) {
            this.remove(item);
            this.nodeSize--;
        }
        while (this.nodeSize >= this.capacity) {
            data.remove(firstNode.getKey());
            firstNode = firstNode.getLastNode();
            if (firstNode != null) {
                firstNode.setPreNode(null);
            }
            this.nodeSize--;
        }
        item = new Node<>(key, value);
        lastNode.setLastNode(item);
        item.setPreNode(lastNode);
        lastNode = item;
        data.put(key, item);
        this.nodeSize++;
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
