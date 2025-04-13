package ReverseNodesInKGroup;

/**
 * @Description: 关键的一步理解
 * @Author: wjh
 * @Date: 2025/4/11 下午3:23
 */
public class findK {

    public ListNode findTheK(ListNode head,int k){

        ListNode tail = head;

        for(int i=1;i<k;i++){
            tail=tail.next;
        }

//        for(int i=1;i<=k;i++){
//            tail=tail.next;
//        }
//
        return tail;
    }
}
