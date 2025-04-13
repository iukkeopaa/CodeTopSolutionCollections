package ReverseNodesInKGroup;

/**
 * @Description:
 * @Author: wjh
 * @Date: 2025/4/11 下午3:26
 */
public class Solution {

    public static ListNode reversewithK(ListNode head,int k) {


        if (head == null || head.next == null) {
            return head;
        }

        ListNode tail=head;

        for(int i =0 ;i<k;i++){

            if (tail==null){

                return head;

            }

            tail=tail.next;
        }
        ListNode newHead = reverser2(head, tail);
        //下一轮的开始的地方就是tail
        head.next = reversewithK(tail, k);

        return newHead;

    }




    public static ListNode reverse(ListNode head){


        ListNode pre =null;
        ListNode cur= head;

        while(cur!=null){

            ListNode temp = cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }

        return pre;
    }


    public static ListNode reverser2(ListNode head, ListNode tail){
        ListNode pre =null;
        ListNode next;

        while(head!=tail){

            next= head.next;
            head.next=pre;
            pre=head;
            head=next;
        }

        return pre;


    }

}
