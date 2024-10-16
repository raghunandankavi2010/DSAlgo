package programs.lists;

public class SinglyLinkedList {


    private Node head;
    private int list_size;

    public static void main(String[] args) {

        Node node_returned;
        SinglyLinkedList linkedList = new SinglyLinkedList();
        SinglyLinkedList linkedList2 = new SinglyLinkedList();

        /*linkedList2.add(12);
        linkedList2.add(5);
        linkedList2.add(10);
        linkedList2.add(15);
        linkedList2.add(20);
        linkedList2.add(25);*/

        linkedList.add2(6);
        linkedList.add2(4);
        linkedList.add2(15);
        linkedList.add2(27);
        linkedList.add2(30);
        linkedList.add(25);

        linkedList.reversePairs(linkedList.getHead());
        linkedList.print(linkedList.getHead());
        //linkedList.linkedListIntersection(linkedList.getHead(),linkedList2.getHead());


    }


    private void reversePairs(Node head) {
        if(head!=null) {
         int temp;
         Node current = head;
         while(current!=null && current.getNext()!=null){

            current = current.getNext();
            temp = current.getData();
            current.setData(head.getData());
            head.setData(temp);
            current = current.getNext();
            head = current;
         }

        }
    }

    private void print(Node head) {

        Node current = head;

        if(current==null)
        {
            System.out.println("List is Empty");

        } else {

            while (current.getNext() != null) {
                System.out.println(current.getData());
                current = current.getNext();
            }

            System.out.println(current.getData());
        }
    }

    private void add2(int data) {

        // Initialize Node only incase of 1st element
        if (head == null) {
            head = new Node(data);
            setHead(head);
            setList_size(getList_size()+1);
        } else {

            Node temp = new Node(data);
            Node current = head;
            if (current != null) {

                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(temp);
                setList_size(getList_size()+1);
            }
        }

    }

    private void setList_size(int list_size) {
        this.list_size = list_size;
    }

    private int getList_size() {
        return list_size;
    }

    private void setHead(Node head) {
        this.head = head;
    }

    private Node getHead() {
        return head;
    }




    private void add(int data) {

        // Initialize Node only incase of 1st element
        if (head == null) {
            head = new Node(data);
            setHead(head);
            setList_size(getList_size()+1);
        } else {

            Node temp = new Node(data);
            Node current = head;
            if (current != null) {

                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(temp);
                setList_size(getList_size()+1);
            }
        }

    }

    private void linkedListIntersection(Node s1,Node s2) {


        int l1=0,l2=0,diff=0;
        Node head1 = s1,head2= s2;

        while(head1!=null) {
            l1++;
            head1 = head1.getNext();
        }

        while(head2!=null) {
            l2++;
            head2 = head2.getNext();
        }
        if(l1<l2) {
            head1 = s2;
            head2 =s1;
            diff = l2-l1;
        } else {
            head1 = s1;
            head2 = s2;
            diff = l1-l2;
        }

        System.out.println("Diff "+diff);

        for(int i=0;i<diff;i++){
            head1= head1.getNext();
            while(head1!=null && head2!=null) {
                if(head1.getData()== head2.getData()) {
                    System.out.println(head1.getData());
                    break;
                }

                head1 = head1.getNext();
                head2 = head2.getNext();

            }
        }

    }
}
