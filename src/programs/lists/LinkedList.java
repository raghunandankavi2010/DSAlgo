package programs.lists;

/**
 * Created by raghu on 5/7/17.
 */
public class LinkedList {

    private Node head;
    private int list_size;
    private static Node first;
    private static boolean x = true;
    private static int count = 0;
    private static long number = 0;

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        //linkedList.add(6);

        Node root = reverseInGroups2(linkedList.getHead(),3 );
        linkedList.print(root);
        /*Node root = reverseBetween(linkedList.getHead(),1,2);
        linkedList.print(root);


        LinkedList linkedList1 = new LinkedList();

        linkedList1.add(5);
        linkedList1.add(6);
        linkedList1.add(4);
        linkedList1.add(2);
        linkedList1.add(3);
        linkedList1.head = linkedList1.mergeSort(linkedList1.getHead());

        linkedList1.printList(linkedList1.head);


 /*       Node end = linkedList1.getHead();
        while(end.getNext()!=null){
            end = end.getNext();
        }
        sort(linkedList1.getHead(),end);
        linkedList1.print(linkedList1.getHead());
*/

        //Node head =addTwoNumbers2(linkedList.getHead(),linkedList1.getHead());
       // linkedList.print(linkedList.getHead());

        //linkedList.print(swapPairs(linkedList.getHead()));
        // linkedList.print(removeAllNodesWithKValue(linkedList.getHead(), 2));
        //linkedList.print(partitionList(linkedList.getHead(),3));

        //Node root = reverseKNodesIteratively(linkedList.head,3);
        //linkedList.print(root);
        // printLastK(linkedList.head,3);

        //Node root =reverseKConsecutiveElements(linkedList.getHead(),2);
        // Node root = reverseKConsecutiveKAlternateElements(linkedList.getHead(), 2);
        //Node root = removeNthItemFromEnd(linkedList.getHead(),1);
        //linkedList.print(root);

       /* LinkedList linkedList2 = new LinkedList();

        linkedList2.add(10);
        linkedList2.add(15);
        linkedList2.add(30);

        int data = findLinkedListIntersection (linkedList.getHead(),linkedList2.getHead());
        System.out.println(String.format("The two lists intersect at data point %d",data));*/

        //linkedList.add(15);
        //linkedList.add(20);
        //linkedList.add(25);
        // linkedList.printSize(linkedList.getHead());
        // System.out.println("...................");
        // linkedList.printMiddleElementWithOnePass(linkedList.getHead());
        /*first = linkedList.getHead();
        if (isPalindrome(linkedList.getHead())) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }*/
/*

        first = linkedList.getHead();
        if (isPalindrome(linkedList.getHead())) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
*/

        //linkedList.print(linkedList.getHead());
        // System.out.println("/******Last but one*********/");
        //linkedList.getLastButOneData(linkedList.getHead());
        //linkedList.getNItemFromEnd(linkedList.getHead(),4);

//        System.out.println("/******Swap Adjacent Item*********/");
//        node_returned = linkedList.swapAdjacentItems(linkedList.getHead());
//        linkedList.setHead(node_returned);
//        linkedList.print(node_returned);
//
//        System.out.println("/******Insert & Printing*********/");
//        node_returned = linkedList.insertAtPosition(linkedList.getHead(),new Node(90),0);
//        linkedList.setHead(node_returned);
//
//
//        node_returned = linkedList.insertAtPosition(linkedList.getHead(),new Node(100),0);
//        linkedList.setHead(node_returned);
//
//        node_returned = linkedList.insertAtPosition(linkedList.getHead(),new Node(44),2);
//        linkedList.setHead(node_returned);
//
//        node_returned = linkedList.insertAtPosition(linkedList.getHead(),new Node(22),3);
//        linkedList.setHead(node_returned);
//
//        node_returned = linkedList.insertAtPosition(linkedList.getHead(),new Node(16),1);
//        linkedList.setHead(node_returned);
//
//        System.out.println("/******Insert at Invalid Position & Printing*********/");
//        node_returned = linkedList.insertAtPosition(linkedList.getHead(),new Node(16),30);
//        linkedList.setHead(node_returned);
//        linkedList.print(node_returned);
//
//        System.out.println("List Size After Insert "+linkedList.getList_size());
//
//        System.out.println("/******Deleting 10 & Printing*********/");
//        node_returned = linkedList.delete(linkedList.getHead(), 10);
//        linkedList.setHead(node_returned);
//        linkedList.print(linkedList.getHead());
//
//        Node reversed = linkedList.reverse(linkedList.getHead());
//        System.out.println("/*********Reversed & Printing************/");
//        linkedList.print(reversed);

    }
    void printList(Node headref)
    {
        while (headref != null) {
            System.out.print(headref.getData() + " ");
            headref = headref.getNext();
        }
    }

    /**
     * simple reverse list in k groups recursive
     * @param head root node
     * @param k a number for reversing the group of noded
     * @return reversed head node ie
     */
    public static Node  reverseInGroups2(Node head, int k){
        Node prev = null;
        Node next = null;
        Node curr = head;
        int count = 0;
        while(count<k & curr!=null){
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
            count++;
        }

        // restore the reversed group if the group count is less than k
        // if count is 2 and k is 3 there is no need to reverse. keep original order
        if (count < k) {
            curr = prev;
            prev = null;
            next = null;

            while (count != 0) {
                count--;
                next = curr.getNext();
                curr.setNext(prev);
                prev = curr;
                curr = next;
            }
        }
        if(next!=null) {
            Node reverseHead = reverseInGroups2(next,k);
            head.setNext(reverseHead);
        }
        return prev;
    }

    Node mergeSort(Node h) {
        // Base case : if head is null
        if (h == null || h.getNext() == null) {
            return h;
        }

        // get the middle of the list
        Node middle = getMiddle(h);
        Node nextofmiddle = middle.getNext();

        // set the next of middle Node to null
        middle.setNext(null);

        // Apply mergeSort on left list
        Node left = mergeSort(h);

        // Apply mergeSort on right list
        Node right = mergeSort(nextofmiddle);

        // Merge the left and right lists
        Node sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    // Utility function to get the middle of the linked list
    public static Node getMiddle(Node head) {
        if (head == null)
            return head;

        Node slow = head, fast = head;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    Node sortedMerge(Node a, Node b) {
        Node result = null;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (a.getData() <= b.getData()) {
            result = a;
            result.setNext(sortedMerge(a.getNext(), b));
        } else {
            result = b;
            result.setNext(sortedMerge(a, b.getNext()));
        }
        return result;
    }


    // 1.find length of 1st list
    // 2. find length 0f 2nd list
    // 3. find the diff
    // 4. move the list with largest length by diff
    // 5. now check if both list node data are same
    // 5. if same return that data
    // 6. else increment both the list nodes until they meet
    private static int findLinkedListIntersection(Node head, Node head1) {

        Node current = head;
        Node current1 = head;
        int count = 0, count1 = 0;
        int data = 0;
        int diff;
        int len = findLength(current);
        int len1 = findLength(current1);

        if (len > len1) {
            diff = len - len1;
            while (count != diff) {
                current = current.getNext();
                count++;
            }
        } else {
            diff = len1 - len;
            while (count1 != diff) {
                current1 = current.getNext();
                count1++;
            }
        }
        while (current.getNext() != null && current1.getNext() != null) {
            if (current.getData() == current1.getData()) {
                data = current.getData();
                break;
            }
            current = current.getNext();
            current1 = current1.getNext();
        }
        return data;
    }

    private static int findLength(Node current) {
        int count = 0;
        while (current != null) {
            current = current.getNext();
            count++;
        }
        return count;
    }

    public void setList_size(int list_size) {
        this.list_size = list_size;
    }

    public int getList_size() {
        return list_size;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getHead() {
        return head;
    }

    private Node reverse(Node head) {
        if (head == null) {

            return null;
        } else if (head.getNext() == null) {
            System.out.println("Ony one item is List ");
            return head;
        } else {
            Node current = head;
            Node next;
            Node prev = null;
            while (current.getNext() != null) {
                next = current.getNext();
                // reversing the link
                current.setNext(prev);
                // moving currentNode and previous Node by 1 node
                prev = current;
                current = next;
            }

            current.setNext(prev);
            prev = current;


            return prev;
        }

    }

    private void print(Node head) {

        Node current = head;

        if (current == null) {
            System.out.println("List is Empty");

        } else {

            while (current.getNext() != null) {
                System.out.println(current.getData());
                current = current.getNext();
            }

            System.out.println(current.getData());
        }
    }

    private Node delete(Node head, int data) {

        if (head != null) {
            Node prev = null;
            Node next;
            Node current = head;

            while (current.getNext() != null && current.getData() != data) {
                next = current.getNext();
                // moving currentNode and previous Node by 1 node
                prev = current;
                current = next;
            }


            if (prev != null && current.getData() == data) {
                prev.setNext(current.getNext());
            } else if (current.getData() == data) {
                // case where data to be deleted is at the start for the node
                current = current.getNext();
                head = current;

            } else {
                System.out.println("Data item not in List ");
            }

            return head;
        } else {
            return null;
        }

    }

    private void add(int data) {

        // Initialize Node only incase of 1st element
        if (head == null) {
            head = new Node(data);
            head.setNext(null);
            setHead(head);
            setList_size(getList_size() + 1);
        } else {

            Node temp = new Node(data);
            Node current = head;

            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(temp);
            temp.setNext(null);
            setList_size(getList_size() + 1);
        }

    }

    private Node insertAtPosition(Node head, Node node, int pos) {

        if (head != null && head.getNext() != null && pos != getList_size() && pos != 0) {
            int count = 0;
            Node current = head;
            Node prev = null;
            Node next;

            while (current.getNext() != null && count != pos) {
                next = current.getNext();
                prev = current;
                current = next;
                count++;
            }

            if (prev != null && count == pos) {
                prev.setNext(node);
                node.setNext(current);
                setList_size(getList_size() + 1);
                System.out.println("Insert " + node.getData() + " at " + pos);
            } else {
                System.out.println("Position " + pos + " is Invalid!");
            }
        } else if (head != null && pos == 0) {

            node.setNext(head);
            head = node;
            setList_size(getList_size() + 1);
            System.out.println(" Inserting " + node.getData() + " at the beginning " + pos);
        } else if (head != null && pos == getList_size()) {

            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(node);
            System.out.println(" Inserting " + node.getData() + " at the end " + pos);
            setList_size(getList_size() + 1);

        } else if (head == null && pos == 0) {
            head = node;
            setList_size(getList_size() + 1);
            System.out.println(" List Empty. Inserting at beginning " + node.getData());
        } else {
            System.out.println("List is Empty. Cannot insert at position" + pos);
        }
        return head;

    }

    private void getLastButOneData(Node head) {
        if (head != null) {
            Node current = head;
            Node prev = null;
            Node next = null;
            while (current.getNext() != null) {
                next = current.getNext();
                prev = current;
                current = next;
            }
            if (prev != null) {
                System.out.println("Last But one item " + prev.getData());
            } else {
                System.out.println("Only one item. Last But one item " + head.getData());
            }
        } else {
            System.out.println("List is empty");
        }
    }

    private Node swapAdjacentItems(Node head) {
        if (head != null) {

            Node current = head;
            Node prev;
            Node next;
            while (current.getNext() != null) {
                next = current.getNext();
                prev = current;
                int datanext = next.getData();
                int dataprev = prev.getData();

                //12 5 10 15 20 25
                prev.setData(datanext);
                next.setData(dataprev);
                current = next;
                if (current.getNext() != null) {
                    current = current.getNext();
                }
            }
            return head;
        } else {
            return null;
        }
    }

    /**
     * 12,5,10,15,20,25
     */


    private void getNItemFromEnd(Node head, int pos) {
        if (head != null) {
            System.out.println(head.getData());
            Node current = head;
            Node prev = null;
            Node next = null;
            int count = 0;
            while (current.getNext() != null) {
                System.out.println(current.getData());
                current = current.getNext();
                count++;

                if (count == pos) {
                    prev = head;
                }
                if (prev != null) {
                    prev = prev.getNext();
                }
            }
            if (prev != null) {
                System.out.println("Last But " + pos + " item is " + prev.getData());
            } else {
                System.out.println("Only one item. Last But one item " + head.getData());
            }
        } else {
            System.out.println("List is empty");
        }
    }

    private void printMiddleElementWithOnePass(Node head) {
        Node slow_ptr = head;
        Node fast_ptr = head;
        if (head != null) {
            while (fast_ptr != null && fast_ptr.getNext() != null) {
                fast_ptr = fast_ptr.getNext().getNext();
                slow_ptr = slow_ptr.getNext();
            }
            System.out.println("The middle element is [" +
                    slow_ptr.getData() + "] \n");
        }
    }

    private void printSize(Node head) {

        Node current = head;

        if (current == null) {
            System.out.println("List is Empty");

        } else {
            int length = 0;
            while (current != null) {
                length++;
                current = current.getNext();
            }

            System.out.println("Length :" + length);
        }
    }

    private static boolean palindrome(Node head) {
        if (head == null)
            return false;
        Node middle = null;
        Node fastPtr = head;
        Node slowPtr = head;
        Node prevSlowPtr = null;
        while (fastPtr != null && fastPtr.getNext() != null) {

            fastPtr = fastPtr.getNext().getNext();
            prevSlowPtr = slowPtr;
            slowPtr = slowPtr.getNext();

        }
        // if length is odd
        // move slow ptr by 1
        if (fastPtr != null) {
            slowPtr = slowPtr.getNext();
        }
        prevSlowPtr.setNext(null);
        // if even middle is slowptr
        Node secondHalfHead = slowPtr;
        Node secondHalf = reverseLinkedList(secondHalfHead);
        return compareLists(head, secondHalf);
    }

    private static boolean compareLists(Node head, Node secondHalf) {
        boolean check = false;
        while (head != null && secondHalf != null) {
            if (head.getData() == secondHalf.getData()) {
                head = head.getNext();
                secondHalf = secondHalf.getNext();
                check = true;
            } else {
                return false;
            }

        }
        return check;
    }

    private static Node reverseLinkedList(Node currentNode) {
        Node previousNode = null;
        Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;

        }
        return previousNode;
    }

    /* If linkedlist has 1 0 0 1
        isPalindrome(0);
        isPalindrome(0);
        isPalindrome(1);
        recursive call returns
        recursive call returns last compare first and last
        1 and 1 is compared
        increment first - points to 0
        recursive call returns second last ie 0
        compare first (points to second ie 0) and second last
        similarly do for all elements
    */
    //first = head, last = head, initially
    private static boolean isPalindrome(Node last) {
        //whenever last will reach at the end of the linkedlist, we will return true.
        if (last == null)
            return true;
        // in each recursive call, we won't modify first, but modify last.
        x = isPalindrome(last.getNext());
        //remember, when an element of stack return false, we will return false to each bottom most element.
        if (!x) return false;

        //if x is true, we will check the next entry.
        boolean y = false;
        if (first.getData() == last.getData()) {
            y = true;
        }

        //advancing first before returning from the current element of the stack.
        first = first.getNext();
        return y;
    }

    // the trick is to see if you are deleting form end or start
    // if you are deleting from any where else you need to have 3 pointers and 3 nodes
    // prev next and current and then just change prev.setNext(current)
    // https://leetcode.com/submissions/detail/278942358/
    private static Node removeNthItemFromEnd(Node head, int n) {
        if (head.getNext() == null) {
            return null;
        }
        Node current = head;
        Node prev = null;
        Node next = null;

        int listCount = 1;
        while (current.getNext() != null) {
            if (n == 1) {
                next = current.getNext();
                prev = current;
                current = next;
            } else {
                current = current.getNext();
                if (next != null) {
                    prev = next;
                    next = next.getNext();
                }
                listCount++;
                if (listCount - n == 0) {
                    next = head;
                    prev = next;

                }
            }
        }
        if ((n != 1) && listCount == n) { // if you are deleting from start
            prev = next;
            prev = prev.getNext();
            head = prev;
            return head;
        }
        if (n == 1) { // deleting from end
            prev.setNext(null);
            return head;
        } else if (listCount == 2 && n == 2) { // if there are just 2 elements
            head = current;
            return head;
        } else if (prev != null) { // atleast 3 elements and deleting the middle node
            next = next.getNext();
            prev.setNext(next);
            return head;
        }
        return head;
    }

    // reverse k consecutive elements in list
    private static Node reverseKConsecutiveElements(Node head, int k) {
        Node current = head;
        Node next = null;
        Node prev = null;
        int count = 0;
        while (count < k && current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            count++;
        }
        if (next != null)
            // make head point to next node
            head.setNext(reverseKConsecutiveElements(next, k));
        return prev;
    }

    // reverse k consecutive alternate elements in list
    private static Node reverseKConsecutiveKAlternateElements(Node head, int k) {
        Node current = head;
        Node next;
        Node prev = null;
        int count = 0;
        while (count < k && current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            count++;
        }

        // point head to element next of k elements reversed
        if (head != null) {
            head.setNext(current);
        }
        // skip next k elements
        count = 0;
        while (count < k - 1 && current != null) {
            current = current.getNext();
            count++;
        }
        // recursively reverse next k elements and so on till end.
        if (current != null) {
            current.setNext(reverseKConsecutiveKAlternateElements(current.getNext(), k));
        }
        return prev;
    }

    // Reverse k nodes iteratively
    private static Node reverseKNodesIteratively(Node head, int k) {

        Node prev;
        Node current = head;
        Node temp;
        Node tail = null;
        Node newHead = null;
        Node join;
        int t;
        while (current != null) {
            t = k;
            join = current;// initially pointed to head
            prev = null;
            // reverse first k elements
            while (current != null && t-- != 0) {
                temp = current.getNext();
                current.setNext(prev);
                prev = current;
                current = temp;
            }
            // we have the new head now
            if (newHead == null) {
                newHead = prev;
            }

            if (tail != null)
                tail.setNext(prev); // join the tail to current head
            // on first iteration tail is pointing to head
            tail = join;

        }
        return newHead;
    }

    // print last k elements
    // recursively traverse the list
    // as each recursion returns increment a count
    // print data until count is less than or equal to k
    private static void printLastK(Node head, int k) {
        if (head == null)
            return;

        printLastK(head.getNext(), k);
        count++;
        if (count <= k) {
            System.out.println(head.getData());
        }
    }

    // partition list such that all values less than k appear before
    // and the rest of the elements later.
    private static Node partitionList(Node head, int k) {
        Node current = head;
        Node before = new Node(0);
        Node after = new Node(0);
        Node beforeHead = before;
        Node afterHead = after;
        while (current != null) {
            if (current.getData() < k) {
                before.setNext(current);
                before = before.getNext();
            } else {
                after.setNext(current);
                after = after.getNext();
            }
            current = current.getNext();
        }
        after.setNext(null);
        before.setNext(afterHead.getNext());
        return beforeHead.getNext();
    }

    // https://leetcode.com/problems/remove-linked-list-elements/submissions/
    private static Node removeAllNodesWithKValue(Node head, int value) {
        if (head == null) {
            return head;
        }
        if (head.getNext() == null && head.getData() == value) {
            head = null;
            return head;
        }
        Node current = head;
        Node prev = null;
        Node next = null;
        while (current.getNext() != null) {
            if (current.getData() == value && prev == null) {
                head = head.getNext();
                current = head;
            } else if (current.getNext() != null && current.getData() == value && prev != null) {
                next = current.getNext();
                prev.setNext(next);
                current = next;
            } else if (current.getNext() != null) {
                next = current.getNext();
                prev = current;
                current = next;
            }
        }

        if (current.getNext() == null && current.getData() == value && prev != null) {
            prev.setNext(null);
        } else if (current.getNext() == null && current.getData() == value && prev == null) {
            current = null;
            head = current;
        }

        return head;
    }

    // this is the same idea as to reverse elements in groups of k
    // here k = 2;
    private static Node swapPairs(Node head) {
        Node current = head;
        Node next;
        Node prev = null;
        Node tail = null;
        Node newHead = null;
        Node join;
        int t;
        while (current != null) {
            t = 2;
            join = current;
            prev = null;
            while (current != null && t-- != 0) {
                next = current.getNext();
                current.setNext(prev);
                prev = current;
                current = next;
            }
            if (newHead == null) {
                newHead = prev;
            }
            if (tail != null)
                tail.setNext(prev);
            tail = join;
        }
        return newHead;
    }

    // this works for numbers within or equal to range of long
    // for numbers greater than range there is a solution at https://www.programcreek.com/2012/12/add-two-numbers/
    private static Node addTwoNumbers(Node l1, Node l2) {
        if (l1.getData() == 0 && l1.getNext() == null && l2.getData() == 0 && l2.getNext() == null) {
            return new Node(0);
        }
        long num1 = getNumber(l1);
        number = 0;
        long num2 = getNumber(l2);
        long sum = num1 + num2;
        Node head = null;
        long num;
        while (sum != 0) {
            num = sum % 10;
            sum = sum / 10;
            if (head == null) {
                head = new Node((int) num);

            } else {
                Node temp = new Node((int) num);
                Node current = head;
                while (current.getNext() != null) {
                    current = current.getNext();
                }
                current.setNext(temp);
                temp.setNext(null);

            }
        }
        return head;
    }

    private static long getNumber(Node node) {
        if (node == null) {
            return -1;
        }
        getNumber(node.getNext());
        number = number * 10 + node.getData();
        return number;
    }

    // Another variation
    // x and y get data first and second list if the lists are nto null
    // add x+y+carry which is sum carry is sum/10 for example if sum is 7 carry is 0
    // if sum is 12 then carry is 1 add sum%10 which is 2 as a node
    // now check if lists are null or not and increment pointers
    // finally if carry is >0 create a new node and add it to the end of list
    private static Node addTwoNumbers2(Node l1, Node l2) {
        Node dummyHead = new Node(0);
        Node p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.getData() : 0;
            int y = (q != null) ? q.getData() : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            System.out.print(sum % 10 + " ");
            curr.setNext(new Node(sum % 10));
            curr = curr.getNext();
            if (p != null) p = p.getNext();
            if (q != null) q = q.getNext();
        }
        if (carry > 0) {
            curr.setNext(new Node(carry));
        }
        System.out.println();
        return dummyHead.getNext();
    }

    // reverse list between given m and n nodes
    // where m>1 and n>=m
    // Have 4 pointers
    // start which points to previous element where the reversing starts
    // end points to current element when reversing starts
    // reverse the elements now prev  is the head of reversed list
    // if start is not null start should point to head of reversed list ie prev
    // if start is null that means we are reversing at the beginning itself so head should point to prev
    // in case current is not null then pointer end points to current
    // My leetcode https://leetcode.com/submissions/detail/280093982/ solution
    private static Node reverseBetween(Node head, int m, int n) {

        Node current = head;
        Node prev = null;
        Node next = null;
        Node start = null;
        Node end = null;
        int count = 0;
        while (current != null) {

            if (m >= 1 && n >= m && count == (m - 1)) {
                end = current;
                while (count <= n - 1) {
                    next = current.getNext();
                    current.setNext(prev);
                    prev = current;
                    current = next;
                    count++;

                }
                if (start != null) {
                    start.setNext(prev);
                } else {
                    head = prev;
                }
                if (end != null && current != null) {
                    end.setNext(current);
                }

            } else {
                start = current;
                count++;
                current = current.getNext();
            }

        }
        return head;
    }

    // My leetcode submission https://leetcode.com/problems/reverse-nodes-in-k-group/submissions/
    private static Node reverseInGroups(Node head, int k) {
        if(head==null||k==1)
                return head;

            Node fake = new Node(0);
            fake.setNext(head);
            Node prev = fake;
            int i=0;

            Node p = head;
            while(p!=null){
                i++;
                if(i%k==0){
                    prev = reverse(prev, p.getNext());
                    // 1->4 p points to 4
                    p = prev.getNext();
                }else{
                    p = p.getNext();
                }
            }

            return fake.getNext();

    }

    // 0->1->2->3->4 say reversing from 0 to 4
    // first iteration prev =0; last = 1 (prev.next),next = 4, curr = 2
    // last.setNext(curr.getNext()) 1->3
    // curr.setNext(prev.getNext()) 2->1
    // prev.setNext(curr) 0->2
    // curr = last.getNext() curr =3
    // prev =0, last =1, curr =3 0->2->1->3
    // second iteration
    // last.setNext(curr.getNext()) 1->4
    // curr.setNext(prev.getNext()) 3->2
    // prev.setNext(curr) 0->3
    // curr = last.getNext() curr = 4
    // 0->3->2->1->4
    // last it pointing to 1
    private static Node reverse(Node prev, Node next){
        Node last = prev.getNext();
        Node curr = last.getNext();

        while(curr != next){
            last.setNext(curr.getNext());
            curr.setNext(prev.getNext());
            prev.setNext(curr);
            curr = last.getNext();
        }

        return last;
    }

    private static void sort(Node start,Node end){

        if(start == end){
            return;
        }

        Node pivot_prev = partition(start,end);

        // if start and pivot are same sort next part of the array
        if(pivot_prev!=null && pivot_prev==start){
            sort(pivot_prev.getNext(),end);
        }else if(pivot_prev != null &&
                pivot_prev.getNext() != null)
            sort(pivot_prev.getNext().getNext(), end); // any where between the list sort from pivots next next
    }

    private static Node partition(Node start,Node end){

        if(start == end ||
                start == null || end == null)
            return start;
        Node pivot_prev = start;
        Node curr = start;
        int pivot = end.getData();

        // if data at current position is less than pivot swap
        while(start!=end) {
            if (start.getData() < pivot) {
                pivot_prev = curr;
                int temp = curr.getData();
                curr.setData(start.getData());
                start.setData(temp);
                curr = curr.getNext();
            }
            start = start.getNext();
        }

        // put pivot at the right place by setting it to curr to pivot
        // set end to curr data.
        int temp = curr.getData();
        curr.setData(pivot);
        end.setData(temp);


        // return prev element as current element point to end
        return pivot_prev;
    }

}


