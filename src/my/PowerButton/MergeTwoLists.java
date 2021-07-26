package my.PowerButton;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。
 * <p>
 * 新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * <p>
 * -100 <= Node.val <= 100
 * <p>
 * l1 和 l2 均按 非递减顺序 排列
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode listNode = null;
        ListNode listNode1 = new ListNode(0);
        ListNode a = mergeTwoListsT(listNode, listNode1);
    }

    /**
     * 我的解法，我感觉十分一般
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoListsT(ListNode l1, ListNode l2) {
        if (l1 == null && l2 != null) {
            return l2;
        }
        if (l1 != null && l2 == null) {
            return l1;
        }
        ListNode list = l1;
        ListNode list2 = l2;
        while (list != null) {
            if (list.next == null) {
                while (list2 != null) {
                    list.next = list2;
                    list = list.next;
                    list2 = list2.next;
                }
            }
            list = list.next;
        }
        return insertionSortList(l1);
    }

    //链表的插入排序
    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = head;//pre指向已经有序的节点
        ListNode cur = head.next;//cur指向待排序的节点

        ListNode aux = new ListNode(-1);//辅助节点
        aux.next = head;

        while (cur != null) {
            if (cur.val < pre.val) {
                //先把cur节点从当前链表中删除，然后再把cur节点插入到合适位置
                pre.next = cur.next;

                //从前往后找到l2.val>cur.val,然后把cur节点插入到l1和l2之间
                ListNode l1 = aux;
                ListNode l2 = aux.next;
                while (cur.val > l2.val) {
                    l1 = l2;
                    l2 = l2.next;
                }
                //把cur节点插入到l1和l2之间
                l1.next = cur;
                cur.next = l2;//插入合适位置

                cur = pre.next;//指向下一个待处理节点

            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return aux.next;
    }

    /**
     * 官方解法
     * 方法1：递归
     * 如果 l1 或者 l2 一开始就是空链表 ，那么没有任何操作需要合并，所以我们只需要返回非空链表。否则，我们要判断 l1 和 l2 哪一个链表的头节点的值更小，然后递归地决定下一个添加到结果里的节点。如果两个链表有一个为空，递归结束。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 官方解法
     * 方法2：迭代
     * 首先，我们设定一个哨兵节点 prehead ，这可以在最后让我们比较容易地返回合并后的链表。我们维护一个 prev 指针，我们需要做的是调整它的 next 指针。然后，我们重复以下过程，直到 l1 或者 l2 指向了 null ：如果 l1 当前节点的值小于等于 l2 ，我们就把 l1 当前的节点接在 prev 节点的后面同时将 l1 指针往后移一位。否则，我们对 l2 做同样的操作。不管我们将哪一个元素接在了后面，我们都需要把 prev 向后移一位。
     * <p>
     * 在循环终止的时候， l1 和 l2 至多有一个是非空的。由于输入的两个链表都是有序的，所以不管哪个链表是非空的，它包含的所有元素都比前面已经合并链表中的所有元素都要大。这意味着我们只需要简单地将非空链表接在合并链表的后面，并返回合并链表即可。
     */
    public ListNode mergeTwoListsF(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}