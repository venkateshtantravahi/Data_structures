// Creating a custom Iterator class 

public class DoublyLinkedList<T> implements Iterable<T> {
  // Creating variable instances of head, tail for further reference
  // here the head and tail null means the linked list is empty 
  private int size=0;
  private Node<T> head=null;
  private Node<T> tail=null;
  
  // A class to represent a node
  private static class Node<T> {
    private T data;
    private Node<T> prev, next;
    
    public Node(T data, Node<T> prev, Node<T> next){
      this.data = data;
      this.prev = prev;
      this.next = next;
    }
    
    @Override
    public String toString() {
      return data.toString();
    }
  }
  
  // Clear the linked list
  public void clear() {
    Node<T> trav = head;
    while (trav!=null) {
      Node<T> next = trav.next;
      trav.prev = trav.next = null;
      trav.data = null;
      trav = next;
    }
    head = tail = trav = null;
    size=0;
  }
  
  // returns the size of linked list
  public int size() {
    return size;
  }
  
  // Sanity check for empty linked list
  public boolean isEmpty() {
    return size() == 0;
  }
  
  // Add an element at tail
  public void add(T elem) {
    addLast(elem);
  }
  
  // Add a node to the tail of linked list
  public void addLast(T elem) {
    if (isEmpty()) {
      head = tail = new Node<T>(elem,null,null);
    } else {
      tail.next = new Node<T>(elem, tail, null);
      tail = tail.next;
    }
    size++;
  }
  
  // Add an element to the head of linked list
  public void addFirst(T elem) {
    if (isEmpty()) {
      head = tail = new Node<T>(elem, null, null);
    } else {
      head.prev = new Node<T>(elem, null ,head);
      head = head.prev;
    }
    size++;
  }
  
  // Check for the value of head 
  public T peekFirst() {
    if (isEmpty()) throw new RuntimeException("Empty list");
    return head.data;
  }
  
  // chack for the value of tail
  public T peekLast() {
    if (isEmpty()) throw new RuntimeException("Empty list");
    return tail.data;
  }
  
  // Remove the first value at the head of the linked list 
  public T removeFirst() {
    //Sanity check for empty list
    if (isEmpty()) throw new RuntimeException("Empty list");
    
    // Get the data from the head and traverse the head node forward
    T data = head.data;
    head = head.next;
    --size;
    
    //If list becomes empty then set tail to null
    if (isEmpty()) tail = null;
    
    // Do a memory cleanup by removing the prev node
    else head.prev = null;
    
    // return the extracted data 
    return data;
  }
  
  //Remove the tail value 
  public T removeLast() {
    if (isEmpty()) throw new RuntimeException("Empty list");
    
    // Extract the data at tail and traverse backwards till head
    T data = tail.data;
    tail = tail.prev;
    --size;
    
    if (isEmpty()) head = null;
    
    else tail.next = null;
    
    return data;
  }
  
  // Remove an arbitrary/random node
  public T remove(Node<T> node) {
    // CHeck if the node is present in head or tail of the linked list
    if (node.prev==null) return removeFirst();
    if (node.next==null) return removeLast();
    
    // Make the pointers of adjacent nodes skip over 'node'
    node.next.prev = node.prev;
    node.prev.next = node.next;
    
    //Create a temp for storing the data that we want to remove
    T data = node.data;
    // remove the node
    node.data = null;
    node = node.prev = node.next = null;
    --size;
    return data;
  }
  
  //Remove the node at particular index
  public T removeAt(int index) {
    //Sanity check for index
    if (index < 0 || index >= size) {
      throw new IllegalArgumentException();
    }
    int i;
    Node<T> trav;
    // Search from head
    if (index < size / 2) {
      for (i=0, trav = head; i!= index;i++){
        trav = trav.prev;
      }
      //Search from back 
    } else 
      for (i = size-1, trav=tail;i!=index;i--) {
        trav = trav.prev;
      }
    return remove(trav);
  }
  
  // Remove a particular value 
  public boolean remove(Object obj) {
    Node<T> trav = head;
    
    // searching for null
    if (obj == null) {
      for (trav=head;trav!=null;trav=trav.next) {
        if(trav.data==null) {
          remove(trav);
          return true;
        }
      }
      // Search for some value
    } else {
      for (trav = head; trav!=null;trav=trav.next) {
        if (obj.equals(trav.data)) {
          remove(trav);
          return true;
        }
      }
    }
    return false;
  }
  
  // Index of particular value 
  public int indexOf(Object obj) {
    int index=0;
    Node<T> trav = head;
    
    //Support searching for null
    if (obj == null) {
      for (; trav!=null;trav=trav.next,index++) {
        if (trav.data = null) {
          return index;
        }
      }
      // Search for not null obj
    } else
      for (; trav != null; trav = trav.next, index++) {
        if (obj.equals(trav.data)) {
          return index;
        }
      }
    return -1;
  }
  
  // Check the presence of value inlinked list
  public boolean contains(Object obj) {
    return indexOf(obj) != -1;
  }
  
  @Override
  public java.util.Iterator<T> iterator() {
    return new java.util.Iterator<T>() {
      private Node<T> trav = head;
      
      @Override
      public boolean hasNext() {
        return trav != null;
      }
      
      @Override
      public T next() {
        T data = trav.data;
        trav = trav.next;
        return data;
      }
      
      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    Node<T> trav = head;
    while (trav != null) {
      sb.append(trav.data+", ");
      trav = trav.next;
    }
    sb.append("]");
    return sb.toString();
  }
}
