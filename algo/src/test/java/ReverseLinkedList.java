import org.junit.jupiter.api.Test;

public class ReverseLinkedList {
    public static class MyLinkedList {
        public Node head;

        public static class Node {
            Node next;
            Object data;

            Node(Object data) {

                this.data = data;
                next = null;
            }
        }
    }

    public static MyLinkedList.Node recursiveReverse(MyLinkedList.Node head) {
        MyLinkedList.Node first;

        if (head == null || head.next == null)
            return head;

        MyLinkedList.Node next = head.next;
        first = recursiveReverse(next);
        next.next = head;
        head.next = null;
        return first;
    }

    public static void printLinkedList(MyLinkedList linkedList) {
        MyLinkedList.Node h = linkedList.head;
        while (linkedList.head != null) {
            System.out.print(linkedList.head.data + " ");
            linkedList.head = linkedList.head.next;
        }
        System.out.println();
        linkedList.head = h;
    }

    public static void reverseLinkedList(MyLinkedList linkedList) {
        MyLinkedList.Node previous = null;
        MyLinkedList.Node current = linkedList.head;
        MyLinkedList.Node next;
        System.out.println("INIT:" + GsonUtils.toString(current));
        System.out.println("***************");
        /*
        while
        init
        {1{2{3{4}}}}
        current = {1}
        1-->
        next=current.next
        ==> next ={2{3{4}}}
        current.next = previous
        ==> current.next = null;
        previous = current;
        ==> previous={1}
        current = next;
        ==> current={2{3{4}}}
        2-->
        {2{3{4}}}
        next=current.next
        ==> next={3{4}}
        current.next = previous
        ==> current.next={1}
        previous = current;
        ==> previous ={2{1}}
        current = next
        ==> current={3{4}}
        3-->
        {3{4}}
         next=current.next
         ==> next = {4}
         current.next = previous
         ==> current.next={2{1}}
         previous = current;
         ==> previous ={3{2{1}}}
         current = next
         ==> current={4}
         4-->
         {4}
         next=current.next
         ==> next = null
         current.next = previous
         ==> current.next={3{2{1}}}
         previous = current;
         ==> previous ={4{3{2{1}}}}
         current = next
         ==> current=null
        */
        while (current != null) {
            System.out.println("INIT-loop:" + GsonUtils.toString(current));
            next = current.next;
            System.out.println("NEXT:" + GsonUtils.toString(next));
            current.next = previous;
            System.out.println("Current.next:" + GsonUtils.toString(current.next));
            previous = current;
            System.out.println("PREVIOUS:" + GsonUtils.toString(previous));
            current = next;
            System.out.println("Current:" + GsonUtils.toString(current));
            System.out.println("==============");
        }
    }

    @Test
    void test() {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.head = new MyLinkedList.Node(1);
        myLinkedList.head.next = new MyLinkedList.Node(2);
        myLinkedList.head.next.next = new MyLinkedList.Node(3);
        myLinkedList.head.next.next.next = new MyLinkedList.Node(4);
//        printLinkedList(myLinkedList);
//        reverseLinkedList(myLinkedList);
        myLinkedList.head = recursiveReverse(myLinkedList.head);
        printLinkedList(myLinkedList);
    }
}
