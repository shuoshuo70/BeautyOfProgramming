package Chapter3;

/**
 * Created by shuoshu on 2018/1/7.
 */
public class ReverseNode {
    public static void main(String[] args) {
        ReverseNode solution = new ReverseNode();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        solution.print(solution.reverse2(head));
    }

    private void print(Node head) {
        while (head != null) {
            System.out.print(head.val + "  ");
            head = head.next;
        }
    }

    public Node reverse1(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node pre = null, cur = head, next = null;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public Node reverse2(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node cur = head, next = cur.next;
        Node newHead = reverse2(next);
        next.next = cur;
        cur.next = null;

        return newHead;
    }
}

class Node {
    int val;
    Node next;

    Node (int val) {
        this.val = val;
    }
}
