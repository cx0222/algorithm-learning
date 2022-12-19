class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int item) {
        this.val = item;
    }
}

class Solution {
    public static void main(String[] args) {
        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        node1.val = 1;
        node2.val = 2;
        node3.val = 3;
        node4.val = 4;
        node5.val = 5;
        node1.next = node2;
        node2.next = node3;
        node4.next = node5;
        node2.prev = node1;
        node3.prev = node2;
        node5.prev = node4;
        node2.child = node4;
        Node node = flatten(node1);
        System.out.println(node.val);
    }

    public static Node flatten(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.child != null) {
                Node nextNode = currentNode.next; // 连接以后的下一个结点
                Node childHead = flatten(currentNode.child); // 记录子链表的首结点
                Node childNode = childHead; // 记录子链表的结点 用于循环迭代
                currentNode.next = childHead; // 桥接父链表与子链表
                childHead.prev = currentNode;
                while (childNode.next != null) {
                    childNode = childNode.next; // 找到子链表的尾结点
                }
                childNode.next = nextNode; // 获取子链表的尾结点
                if (nextNode != null) {
                    nextNode.prev = childNode; // 判断父链表中是否含有结点
                }
            }
            currentNode.child = null; // child 域置空
            currentNode = currentNode.next; // 更新循环迭代的变量
        }
        return head;
    }
}
