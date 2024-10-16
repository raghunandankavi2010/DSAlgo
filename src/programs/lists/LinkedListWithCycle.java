package programs.lists;

import java.util.HashMap;

public class LinkedListWithCycle {

    private Node head;

    public static void main(String[] args) {


/*        String s ="73857 50716 44726 65404 49855 96144 93148 49848 93270 71218 36299"+
                " 97157 83435 26911 29490 206 79708 98668 64753 47635 41453 61181"+
                " 28349 26167 22746 48687 42445 84169 29192 47002 2876 95829 48414"+
                " 80463 95073 89364 67251 67887 15635 38582 11432 85 65670 36116"+
                " 96117 74051 70928 74566 79137 71447 77128 23003 26401 17863 71958"+
                " 82266 79197 23303 67192 50981 11520 22379 39168 24780 53526 41102"+
                " 99960 26070 28367 40997 45840 29425 66212 51510 12603 55827 76585"+
                " 80880 43984 33820 57963 49069 70005 69460 22280 82818 13090 79638"+
                " 95976 66158 77161 55477 97356 91235 39877 71136 47938 70890"+
                " 79617 33542 97613 75230 35463 77229 76531 70677 88076 75860"+
                " 89189 18879 21738 36804 11471 14431 74747 85596 14074 38705"+
                " 12665 51323 22786 17657 85400 18120 24375 40960 18577 31087"+
                " 73237 2365 14649 65029 31843 91221 46672 5463 1501 8684"+
                " 55945 91358 34186 20867 43094 59649 64480 81916 29876"+
                " 22873 6333 4933 503 57378 21038 34907 82789 78949 18278"+
                " 12337 52732 45261 16391 84061 84105 49318 83420 72031"+
                " 78822 58141 40761 29363 28512 50540 73939 39512 13427"+
                " 81699 65877 32041 36611 40814 65633 59798 49826 21761"+
                " 67825 83708 25005 25056 94929 65442 59833 87469 18717"+
                " 58831 56927 55179 53520 74402 84787 20213 1145 91851"+
                " 27315 32111 25101 87360 45092 44453 99242 40216 2523"+
                " 60333 38935 54898 32196 72624 85711 70633 72645 51559"+
                " 19258 74241 37718 73658 82180 20136 67834 14615 21336"+
                " 64676 85517 18704 95465 42289 51505 33652 81995 32971"+
                " 14194 34416 47174 73963 83022 98963 24311 95159 91461"+
                " 45421 35385 21088 9937 734 84713 74305 18908 34253 167 86249 73893 52462 59189"+
                " 86795 35467 22677 94161 28547 20831 52217 94201 28880 54729 14636 5796 87152"+
                " 87388 96645 80418 1418 72553 86714 16431 52004 59093 85173 52383 18351 5218"+
                " 25721 4667 45132 11064 42246 70577 99390 80768 22967 91133 77801 88565 32727"+
                " 55891 12126 94259 94099 60923 97304 70240 77570 95406 67575 39692 5069 43054"+
                " 11073 21000 3680 69793 22613 43175 96515 11484 46739 47735 86487 19069 51130"+
                " 86359 8881 1231 77791 58208 83841 69596 76350 60816 18845 28859 88950 91210"+
                " 86334 91631 55057 53888 23670 83331 82539 77634 1451 83167 49945 19404 52175"+
                " 7681 12114 45979 83933 25820 19578 82466 88990 4375 12741 42044 42515 54640"+
                " 27538 92688 73737 35169 6567 95605 72146 80934 65244 52191 43110 94458 27111"+
                " 14090 86873 65987 62734 35997 3373 111 924 60570 67227 82766 86257 11578"+
                " 57255 21075 84403 9026 83626 41601 35239 30430 33297 16541 7809 90562 10627"+
                " 51299 16574 64549 12426 30201 70866 5383 47916 31464 26075 41471 42947 97198"+
                " 35725 16636 58517 35481 46506 26462 62526 49678 12357 99737 59458 12146 65056"+
                " 52880 77353 56554 73240 23517 49396 42317 73065 20232 24084 35044 83562 51582"+
                " 86760 82637 89412 32009 62563 59302 67628 41974 52697 48614 63023 33704 99437"+
                " 88397 61435 55988 45530 53777 35347 79920 51472 52584 86963 12374 26756 26314"+
        " 8500 26056 83717 37139 51865 91661 55222 86809 7539 49836 78597 45192 45397"+
        " 57676 2164 4825 99295 20038 46542 1679 70734 4128 87117 33558 29543 35306"+
        " 34731 83276 93581 67521 55818 82759 16593 72005 20030 15296 83918 13883"+
        " 37374 81254 16689 25411 42386 84301 10580 88526 34376 98302 22212 37460"+
        " 71924 24675 63948 85779 23350 34037 64632 36376 40632 24070 22138 61174"+
        " 84633 37027 67495 31340 78427 24526 82208 43043 61319 32347 74419 31950"+
        " 50837 24291 53538 520 58626 50121 75612 48063 40360 65378 50736 21804"+
        " 36991 68262 568 24959 2186 60997 95211 6621 89085 36686 37120 64926 76991"+
        " 21895 50529 87292 6919 6954 31946 54263 20391 91867 47603 90778 22523"+
        " 87640 61617 65911 31401 53575 65788 36403 35217 6860 37148 87918 21655"+
        " 72793 47585 25515 63281 70984 95606 64441 43700 11623 30512 24210 37820"+
        " 57960 74986 70729 21906 43130 8795 28796 58339 74532 42025 30567 61165"+
        " 88579 29238 79848 79397 48526 987 52933 71699 16991 5220 65724 88138 24152"+
        " 61975 50242 73497 68548 46372 59418 23544 81594 13231 99273 15623 55768"+
        " 64639 56746 4695 20808 11728 21141 69176 39074 64392 76032 20739 53069"+
        " 37296 89644 8611 60582 33950 26104 21793 92879 94200 19320 21759 90698"+
        " 8083 95823 18495 7568 1773 4562 67104 86678 7003 65923 62516 35990 26647"+
        " 17624 72085 50388 63050 96276 10263 40544 58709 34029 3728 88822 85783"+
        " 5438 40084 65876 46239 3793 62422 99545 41308 61001 722 9581 90139 99788"+
        " 67194 22843 66862 99929 54593 59958 45208 63033 4222 17258 60818 89491"+
        " 50098 95132 15788 42601 92087 36857 48711 49323 69622 71266 70969 61151"+
        " 52588 92924 31060 92149 68026 92177 22473 3989 93064 26880 52902 95254"+
        " 12973 89681 19166 31853 26046 59753 2721 15849 70549 41429 57043 35003"+
        " 4528 8024 34260 76450 36";*/
        //int a[] =(Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray());
        LinkedListWithCycle linkedListWithCycle = new LinkedListWithCycle();
       /* for(int i=0;i< a.length;i++)
        {
            linkedListWithCycle.add(a[i]);
        }*/
        linkedListWithCycle.add(1);
        linkedListWithCycle.add(2);
        linkedListWithCycle.add(3);
        linkedListWithCycle.add(4);
        //linkedListWithCycle.print(linkedListWithCycle.getHead());
        linkedListWithCycle.createCycle();
        //linkedListWithCycle.print(linkedListWithCycle.getHead());
        linkedListWithCycle.hasLoop_method2(linkedListWithCycle.getHead());
        //linkedListWithCycle.hasLoop(linkedListWithCycle.getHead());
        //System.out.println(linkedListWithCycle.hasLoop(linkedListWithCycle.getHead()));
        //linkedListWithCycle.print(linkedListWithCycle.getHead());

    }

    private void setHead(Node head) {
        this.head = head;
    }

    private Node getHead() {
        return head;
    }
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     public int val;
     *     public ListNode next;
     *     ListNode(int x) { val = x; next = null; }
     * }
     */
/*    public class Solution {
        public ListNode detectCycle(ListNode a) {
            ListNode fast = a;
            ListNode slow = a;
            boolean hasCycle = false;
            while(fast != null && fast.next != null && slow != null){
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow){
                    hasCycle = true;
                    break;
                }
            }
            if(!hasCycle) return null;
            else{
                fast = a;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
    }*/

    // d = distance of list without loop. k = distance in loop where both slow and fast meet
    // slow pointer moves N = d+k+c(i) c cycles and i distance travelled.
    // fast pointer moves 2N = d+k+c(j)
    // to find where the loop starts solving above equations d = (j-2i)c-K
    boolean hasLoop(Node first) {

        if(first == null) // list does not exist..so no loop either
            return false;

        Node slow, fast; // create two references.

        slow = fast = first; // make both refer to the start of the list

        while(true) {

            slow = slow.getNext();          // 1 hop

            if (fast.getNext() != null)
                fast = fast.getNext().getNext(); // 2 hops
            else
                return false;          // next node null => no loop

            if (slow == null || fast == null) // if either hits null..no loop
                return false;

            if (slow == fast) {
                fast = first;
                while(fast != slow){
                    fast = fast.getNext();
                    slow = slow.getNext();
                }
                System.out.println(fast.getData());
                return true;
            }
        }
    }

 /*   public static boolean hasLoop2(Node root){
        if(root == null) return false;

        Node slow = root, fast = root;
        int taken = 0, limit = 2;

        while (fast.getNext() != null) {
            fast = fast.getNext();
            taken++;
            if(slow == fast) {
                System.out.println(fast.getData());
                return true;
            }

            if(taken == limit){
                taken = 0;
                limit <<= 1;    // equivalent to limit *= 2;
                slow = fast;    // teleporting the turtle (to the hare's position)
            }
        }
        return false;
    }*/

    private boolean hasLoop_method2(Node a) {

        boolean check =false;
        if(a!=null) {
            Node current = a;
            HashMap<Integer,Integer> map = new HashMap();
            if(!map.containsKey(current.getData())) {
                map.put(current.getData(),current.getData());
            }
            while(true) {
                current = current.getNext();
                if(!map.containsKey(current.getData())) {
                    map.put(current.getData(),current.getData());
                }else {
                    int data = map.get(current.getData());
                    System.out.println("Loop at node with Data "+data);
                    check = true;

                    break;
                }
            }
        }
      return check;

    }



    /**
               ______
               |    |
     1 -> 2 -> 3 -> 4
     */

    private void createCycle() {

        Node current = head;
        Node next = null;
        Node prev = null;
        while (current.getNext() != null) {
            next = current.getNext();
            // reversing the link

            // moving currentNode and previous Node by 1 node
            prev = current;
            current = next;
        }
        if(prev!=null){
            current.setNext(prev);
            //System.out.println(current.getData()+" : "+prev.getData());
        }

     /*   if(getHead().getNext()!=null){

            Node current = getHead();
            Node temp =null;
            Node prev = null;
            while(current.getNext()!=null) {
                prev = current;
                //System.out.println(current.getData());
               *//* if(current.getData() ==2) {
                    temp = current;
                }*//*
                current = current.getNext();

            }
            if(prev!=null)
               // System.out.println(current.getData());
            current.setNext(prev);
            //System.out.println(current.getNext().getData());
        }*/
    }

    public void add(int number) {

        if(head==null) {

            head = new Node(number);
            setHead(head);
        } else {
            Node temp = new Node(number);
            Node current = head;

            while(current.getNext()!=null)
            {
                current =  current.getNext();
            }
            current.setNext(temp);
            setHead(head);
        }

    }

    private void print(Node head) {

        Node current = head;

        if(current==null)
        {
            System.out.println("List is Empty");

        } else {

            while (current != null) {
                System.out.println(current.getData());
                current = current.getNext();
            }

            //System.out.println(current.getData());
        }
    }

}
