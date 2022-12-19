#include <cstdio>

class Node {
public:
    int val;
    Node *prev;
    Node *next;
    Node *child;
};

class Solution {
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

int main() {
    auto node1 = new Node();
    auto node2 = new Node();
    auto node3 = new Node();
    auto node4 = new Node();
    auto node5 = new Node();
    node1->val = 1;
    node2->val = 2;
    node3->val = 3;
    node4->val = 4;
    node5->val = 5;
    node1->next = node2;
    node2->next = node3;
    node4->next = node5;
    node2->prev = node1;
    node3->prev = node2;
    node5->prev = node4;
    node2->child = node4;
    auto node = Solution::flatten(node1);
    printf("%d\n", node->val);
    return 0;
}
