// operations on linked list

package node;
  import java.util.Scanner;
public class Node {


    //data and link which are there in each node
    int data;
    Node link;

    public static void main(String args[]){


        Node start = new Node();
        start.create();
        System.out.println("create");
        start.print();

        start.insertMid(new Node(8),3);
        System.out.println("insert mid");
        start.print();

        //setting start to the first node of the linked list
        start = start.insertBegin(new Node(6));
        System.out.println("insert begin");
        start.print();

        start.insertEnd(new Node(7));
        System.out.println("insert end");
        start.print();

        start.delete(3);
        System.out.println("delete");
        start.print();

        System.out.println("found at index"+start.search(7));

        start = start.reversal();
        System.out.println("reversal");
        start.print();

        start = start.reverse();
        System.out.println("reverse");
        start.print();

    }
    //creating node with data
    Node(int d){
        data = d;
        link = null;
    }
    
    //creating empty node
    Node(){
        link = null;
    }

    //creating the linked list
    public void create(){
        //number of elements in the linked list
        Scanner in = new Scanner(System.in);
        System.out.println("number of elements in the linked list");
        int n = in.nextInt();

        //setting the values
        System.out.println("enter values");
        //current will be the node in which we will set the data and link
        Node current = this;
        //temp is the next node, so that we can put it in link
        Node temp;
        for(int i = 0;i<n;i++){
            //creating new node
            temp = new Node();
            //taking input value
            current.data = in.nextInt();

//setting the link of the last node equal to null
            if(i < n-1) {
                //for nodes which are not the last node
//setting link to the next element, temp in this case
                current.link = temp;
//setting current to the next element
                current = temp;
            }
            else{
                //for the last node
                current.link =null;
            }
        }

    }

    //method to insert node at the beginning of the linked list
    public Node insertBegin(Node n){
        //linking linked list to this node
        n.link = this;
        //returning the beginning of the linked list
        return n;
    }

    //to insert node at the end of the linked list
    public void insertEnd(Node n){
        Node linkedList = this;
        //while the link is not null, traverse to the next node
        while(linkedList.link!=null){
            linkedList= linkedList.link;
        }
        //adding n to linked list by setting it as the link 
        //of the last element in the linked list
        linkedList.link = n;

    }

    //to insert node in the middle
    public void insertMid(Node n,int index){
        Node linkedList = this;
        //traversing to the index in which we need to insert n
        for(int i = 0;i<index-1;i++){
            linkedList= linkedList.link;
        }
        //inserting n
        n.link = linkedList.link;
        linkedList.link = n;
    }

    //to delete an element in the linked list
    public void delete (int index){
        Node linkedList = this;
        for(int i =0;i<index-1;i++){
            linkedList = linkedList.link;
        }
     //setting the link of this node to the link of the next node,
     //so it will skip the next node whenever this linked list is traversed
     //because it is not linked to any node
        linkedList.link = linkedList.link.link;
    }

    //method to search for an element
    public int search (int n){
        int pos=-1;
        Node linkedList = this;
        int i=0;
    //traversing through the linked list 
    //to see if any element matches the number we are searching for
        while(linkedList.link!=null){
    //if number is found set pos to the index it was found at 
    //and break the loop
            if(linkedList.data == n){
                pos = i;
                break;
            }
            linkedList = linkedList.link;
            i++;
        }
        //checking if it is at the last node
        if(linkedList.data == n){pos = i;}
        //returning the position it was found at
        return pos;
    }

    
    //method to reverse linked list
    public Node reverse(){
        Node n = this;
        //if it is the last node return it
        if(n.link == null){
            return n;
        }
        //temp is the reversed linked list, not including node n
        Node temp = n.link.reverse();
        //adding n to the end of temp
        temp.lastNode().link = n;
        //setting link of n equal to null to prevent it 
        //from circling back to starting of the linkedlist
        n.link = null;
        return temp;
    }

    
    public Node lastNode(){
        Node n = this;
        while (true){
            if(n.link ==null){
                return n;
            }
            n = n.link;
        }
    }

    
    public Node reversal(){
        //creating previous, current and next node
        Node n = this;
        Node prevN = null;
        Node nextN = n.link;

        //while the current nodes link is not null
        while (n.link!=null) {
            //making current link point to previous node
            n.link = prevN;
            //moving all nodes forward one position
            prevN = n;
            n = nextN;
            nextN = nextN.link;
        }
        //for the last node, setting its link to the previous node
        n.link = prevN;
        return n;
    }

    
    //method to print the linked list
    public void print(){
        System.out.println("printing linked list");
        Node n = this;
        //iterating through the linked list and printing each nodes data
        while (n.link!=null){
            System.out.println(n.data);
            //setting n to the next node
            n = n.link;
        }
        //last node's link is null print it outside the for loop
        System.out.println(n.data);
    }
    
}
