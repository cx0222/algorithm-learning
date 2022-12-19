# No. 430 flatten-a-multilevel-doubly-linked-list

## 问题分析
1. 题目难度：Leetcode 430 中等<br>
2. 基本思路：深度优先搜索，运用递归的思想解决问题，递归的三个作用（见北京大学郭炜老师慕课）<br>
3. 注意事项：注意将子链表插入父链表后，需要改变的指针不仅仅有 next 还要有 prev；注意链表遍历终止的条件<br>
4. 类似题目：Leetcode 114 二叉树展开为链表，本质上思路是一样的，还是运用递归来解决问题，链接如下：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list/

## 算法实现
1. Java
```java
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
```
2. C++
```cpp
public:
    static auto flatten(Node *head) -> Node * {
        auto current_node = head;
        while (current_node != nullptr) {
            if (current_node->child != nullptr) {
                auto next_node = current_node->next; // 记录连接以后的下一个结点
                auto child_head = flatten(current_node->child); // 记录子链表的首结点
                auto child_node = child_head; // 记录子链表的结点 用于循环迭代
                current_node->next = child_head; // 桥接父链表与子链表
                child_head->prev = current_node;
                while (child_node->next != nullptr) {
                    child_node = child_node->next; // 找到子链表的尾结点
                }
                child_node->next = next_node; // 获取子链表的尾结点
                if (next_node != nullptr) {
                    next_node->prev = child_node; // 判断父链表中是否含有结点
                }
            }
            current_node->child = nullptr; // child 域置空
            current_node = current_node->next; // 更新循环迭代的变量
        }
        return head;
    }
};
```
