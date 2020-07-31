# coding=utf-8

# not complete


class LRUCache:
    def __init__(self, capacity):
        self.capacity = capacity
        self.cache = {}
        self.head = Node()
        self.end = Node()
        self.head.last, self.end.prev = self.end, self.head

    def get(self, key):
        node = self.cache.get(key)  # type: Node
        if node is None:
            return -1
        self.remove_node(node)
        self.add_node_in_last(node)
        return node.value

    def put(self, key, value):
        if self.cache.get(key) is not None:
            self.delete(key)
        while len(self.cache) >= self.capacity:
            self.delete(self.head.key)
        tmp_node = Node(key, value)
        self.cache[key] = tmp_node
        self.add_node_in_last(tmp_node)

    def delete(self, key):
        del_node = self.cache.pop(key)
        self.remove_node(del_node)

    def remove_node(self, node):
        node.prev.last, node.last.prev = node.last, node.prev

    def add_node_in_last(self, node):
        self.end.last, node.prev = node, self.end
        self.end = node


class Node:
    def __init__(self, key=None, value=None):
        self.prev = None
        self.key = key
        self.value = value
        self.last = None


if __name__ == '__main__':
    # cmds = ["LRUCache", "put", "put", "put", "put", "get", "get"]
    # ps = [[2], [2, 1], [1, 1], [2, 3], [4, 1], [1], [2]]
    cmds = ["LRUCache", "put", "get", "put", "get", "get"]
    ps = [[1], [2, 1], [2], [3, 2], [2], [3]]
    obj = LRUCache(1)
    for i in range(len(cmds)):
        if cmds[i] == 'LRUCache':
            obj = LRUCache(ps[i][0])
            print('null')
        elif cmds[i] == 'put':
            obj.put(ps[i][0], ps[i][1])
            print('null')
        else:
            print(obj.get(ps[i][0]))
