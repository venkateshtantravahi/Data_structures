import java.util.Scanner;

class Node {
  protected int data;
  protected Node link;
  
  public Node() {
    link=null;
    data = 0;
  }
  public Node(int d, Node n) {
    data = d;
    link = n;
  }
  
  public void setLink(link n) {
    link = n;
  }
  public void setData(int d) {
    data = d;
  }
  public Node getLink() {
    return link;
  }
  public int getData() {
    return data;
  }
}

class linkedList {
  protected Node head;
  protected Node tail;
  public int size;
  
  public linkedList() {
    head = null;
    tail = null;
    size = 0;
  }
  public boolean isEmpty() {
    return head == null;
  }
  public int getSize() {
    return size;
  }
  public void insertAtStart(int val) {
    Node nptr = new Node(val, null);
    size++;
    if(head == null) {
      head = nptr;
      tail = head;
    } else {
      nptr.setLink(head);
      head= nptr;
    }
  }
  
  public void insertAtEnd(int val) {
    Node nptr = new Node(val, null);
    size++;
    if(head==null) {
      head = nptr;
      tail = head;
    } else {
      tail.setLink(nptr);
      tail = nptr;
    }
  }
 
  public void inserAtPos(int val, int pos) {
    Node nptr = new Node(val, null);
    Node ptr = head;
    pos = pos-1;
    for (int i=1;i<size;i++) {
      if (i == pos) {
        Node tmp = ptr.getLink() ;
        ptr.setLink(nptr);
        nptr.setLink(tmp);
        break;
      }
      ptr = ptr.getLink();
    }
    size++;
  }
  
  public void deleteAtPos(int pos) {
    if (pos == 1) {
      head = head.getLink();
      size--;
      return ;
    }
    if (pos == size) {
      Node h = head;
      Node t = head;
      while (h != tail) {
        t = h;
        h = h.getLink();
      }
      tail = t;
      tail.setLink(null);
      size--;
      return;
    }
    Node ptr = head;
    pos = pos -1 ;
    for (int i =1; i<size-1; i++) {
      if (i == pos) {
        Node tmp = ptr.getLink();
        tmp = tmp.getLink();
        ptr.setLink(tmp);
        break;
      }
      ptr = ptr.getLink();
    }
    size--;
  }
  public void display() {
    System.out.print("\nSingly Linked List = ");
    if (size == 0){
      System.out.print("empty\n");
      return;
    }
    if (start.getLink() == null) {
      System.out.println(start.getData() );
      return ;
    }
    Node ptr = start;
    System.out.print(start.getData()+ "-->");
    ptr = start.getLink();
    while (ptr.getLink() != null) {
      System.out.print(ptr.getData() + "-->");
      ptr = ptr.getLink();
    }
    System.out.print(ptr.getData() + "\n");
  }  
}
