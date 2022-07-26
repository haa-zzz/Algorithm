package 面试.常用数据结构;

import bean.ListNode;

public class 排序奇升偶降链表 {
    /*
    给定一个奇数位升序，偶数位降序的链表，将其重新排序。
    输入: 1->8->3->6->5->4->7->2->NULL
    输出: 1->2->3->4->5->6->7->8->NULL
     */
    class Solution {
        /*
        参考思路：
        按奇偶位置拆分链表，得1->3->5->7->NULL和8->6->4->2->NULL
        反转偶链表，得1->3->5->7->NULL和2->4->6->8->NULL
        合并两个有序链表，得1->2->3->4->5->6->7->8->NULL
        时间复杂度为O(N)，空间复杂度O(1)。
         */
        public ListNode sortOddEvenList(ListNode head) {
            if(head == null || head.next == null) return head;
            //拆分出奇节点链表和偶节点链表
            ListNode odd = head;    //使用两个指针，odd指向奇节点，even指向偶节点，不断向后检索
            ListNode evenHead = head.next;
            ListNode even = evenHead;
            while(even != null && even.next != null){
                odd.next = even.next;
                odd = odd.next;
                even.next = odd.next;
                even = even.next;
            }
            odd.next = null;//当链表长度为偶数时，odd.next还指向最后一个偶节点，需要断开
            //反转偶节点链表
            evenHead = reverse(evenHead);
            //合并为有序链表
            return mergeTwoLists(head, evenHead);
        }
        public ListNode reverse(ListNode head){
            ListNode pre = null;
            ListNode cur = head;
            ListNode temp = null;
            while(cur != null){
                temp = cur.next;
                cur.next = pre;
                pre = cur;
                cur = temp;
            }
            return pre;
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2){
            ListNode dummy = new ListNode(-1);
            ListNode p = dummy;
            while(l1 != null && l2 != null){
                if(l1.val < l2.val){
                    p.next = l1;
                    l1 = l1.next;
                }else{
                    p.next = l2;
                    l2 = l2.next;
                }
                p = p.next;
            }
            p.next = l1 != null? l1 : l2;
            return dummy.next;
        }
    }
}
