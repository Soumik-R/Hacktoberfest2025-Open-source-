import java.io.*;

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class GFG {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        }

        ListNode result;

        
        if (l1.val <= l2.val) {
            result = l1;
            result.next = mergeTwoLists(l1.next, l2);
        } else {
            result = l2;
            result.next = mergeTwoLists(l1, l2.next);
        }

        return result;
    }

    static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(23);
        head1.next = new ListNode(35);
        head1.next.next = new ListNode(65);

        ListNode head2 = new ListNode(43);
        head2.next = new ListNode(59);
        head2.next.next = new ListNode(70);

        System.out.print("First Linked List: ");
        printList(head1);
        System.out.print("Second Linked List: ");
        printList(head2);

        ListNode mergedHead = mergeTwoLists(head1, head2);
        System.out.print("Merged Sorted Linked List: ");
        printList(mergedHead);
    }
}
