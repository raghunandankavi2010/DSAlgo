/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programs.lists;


/**
 * @author Raghunandan
 */
public class LinkedListReverse {

    private Node head;

    private static class Node {
        private int value;
        private Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private void addToTheLast(Node node) {

        if (head == null) {
            head = node;
        } else {
            Node temp = head;
            while (temp.next != null)
                temp = temp.next;

            temp.next = node;
        }
    }


    private void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.format("%d ", temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    // Reverse linkedlist using this function
    public static Node reverseLinkedList(Node currentNode) {
// For first node, previousNode will be null
        Node previousNode = null;
        Node nextNode;
        while (currentNode != null) {
            nextNode = currentNode.next;
            // reversing the link
            //if(previousNode!=null)
            //System.out.println("value"+previousNode.value);
            currentNode.next = previousNode;
            // moving currentNode and previousNode by 1 node
            previousNode = currentNode;
            if (currentNode != null)
                System.out.println("current node" + currentNode.value);
            if (previousNode != null)
                System.out.println("previous node after plus " + previousNode.value);
            currentNode = nextNode;
            if (currentNode != null)
                System.out.println("current node after plus " + currentNode.value);
        }
        return previousNode;
    }

    public static void main(String[] args) {
        LinkedListReverse list = new LinkedListReverse();
        // Creating a linked list
        Node head = new Node(1);
        list.addToTheLast(head);
        list.addToTheLast(new Node(0));
        list.addToTheLast(new Node(1));
       /* list.addToTheLast(new Node(1));*/
        /*    list.addToTheLast(new Node(2));*/

        list.printList(head);
        //Reversing LinkedList
      /*  Node reverseHead = reverseLinkedList(head);
        System.out.println("After reversing");
        list.printList(reverseHead);*/

    }
}



