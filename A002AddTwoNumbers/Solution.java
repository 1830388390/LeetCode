package A002AddTwoNumbers;
/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807
 */

class Solution {

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
      }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
          ListNode dummyHead = new ListNode(0);
          ListNode cur = dummyHead , n1 = l1 , n2 = l2;
          int carry = 0;
          while (n1.next !=null || n2.next != null){
              int x = (n1 == null) ? 0 : n1.val;
              int y = (n2 == null) ? 0 : n2.val;
              carry = (x+y+carry)/10;
              cur.next = new ListNode((x+y+carry)%10);
              cur = cur.next;
              if(n1.next != null){n1 = n1.next;}
              if(n2.next != null){n2 = n2.next;}
          }
          if (carry > 0){
              cur.next = new ListNode(carry);
          }
          return dummyHead.next;

    }
}