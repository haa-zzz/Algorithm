package bean;

    public class ListNode {
          public int val;
          public ListNode next;
          public ListNode prev;         //如果是双链表，这里做链表的前驱指向
          public ListNode(int x) {
              val = x;
              next = null;
              prev = null;
          }
    }

