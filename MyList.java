package Home;

import java.util.Iterator;

public class MyList implements MyListInterface, Iterable {

    Node first;
    int length;
   // private Node pos;

    public MyList(){
        first = null;
        length= 0;
    }

    public String toString(){
        String s = "";
        Node temp = first;
        int index = 0;
        while (temp != null){   //loop until end of list
            s += "\n"+index+": "+temp.data;
            temp = temp.next;  // go to next item in list
            index++;  // increment the index
        }
        return s;
    }

    public boolean add(Object newEntry){ // add at beginning of list
        Node temp = new Node(newEntry, first);
        first = temp;
        length++;  // increment the length of the List
        return true;
    }
    public void add(int index,Object newEntry){


    }
    public Object remove(int index){
        return ""; // temp fix
    }

    public void clear(){
        first = null;
        length= 0;
    }
    public Object set(int index, Object anEntry) // like replace
    {
        return ""; // temp fix
    }
    public Object get(int index) // like getEntry
    {
        if(index<0 || index >= length) // invalid index
            return "";
        Node temp = first;
        int position = 0;
        while(position != index){
            temp = temp.next;
            position++;
        }
        return temp.data;
    }

    public boolean contains(Object anEntry){
        return false;
    }
    public int size() // like getLength
    {
        return length;
    }

    public boolean isEmpty(){
        if(length == 0)
            return true;
        return false;
    }

    public MyListIterator iterator() {
        return new MyListIterator(first);
    }

    public class Node{
        Object data;
        Node next;

        public Node(Object data, Node n){
            this.data = data;
            next = n;
        }

    } // end of inner Node class

    class MyListIterator implements Iterator {
        private Node pos; //Current position

        public MyListIterator(Node fnode) {
            pos = fnode;
        }

        @Override
        public boolean hasNext() {
            return pos != null;
        }

        @Override
        public Object next() {
            Node temp = pos;
            pos = pos.next;
            return temp.data;
        }
    }

} // end of class





