/**
 * @Description: 反转链表
 * @Author: wjh
 * @Date: 2025/4/10 下午5:04
 */

class ListNode{

    int val;
    ListNode next;

    public ListNode(int val){
        this.val=val;
    }
}


public class ReverseList {


    public static ListNode Solution(ListNode head){


        ListNode pre = null;
        ListNode cur = head;

        while(cur != null){

            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }


}
