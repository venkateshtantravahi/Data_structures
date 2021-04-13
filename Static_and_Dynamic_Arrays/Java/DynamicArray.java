// Java Program to Implement dynamic array class
/*
  The @SuppressWarning annotation allows java program to disable compilation warnings for a certain part of code(type, field, method, parameter, constructor
  and local variables). However warnings are good to indicate where we can change the code part of the program but for some cases where we want to implement
  custom classes we can ignore such warnings.
*/
@SuppressWarnings("unchecked")
/* Lets implement a custom iterable data structure
1. Implement iterable interface along with its methods in the said DataStructure.
2. Create an iterator class which implements iterator interface and corresponding metods.
Syntax: class CustomDataStructure implements Iterable<> {
}
*/
public class DynamicArray<T> implements Iterable<T> {
   private T[] arr; // arr which is internal stack array
   private int len = 0; //length user think array is
   private int capacity = 0; // original length of array
  
  // Initialize array constructor with size16
  public DynamicArray() {
    this(16);
  }
  
  // Add capacity to the initialized array and cast it to type T which is []
  /*
  An IllegalArgumentException is thrown in order to indicate that a method has been passed illegal argument. It is an unchecked exception and thus it does not 
  need to be declared in a method's or constructors throws clause.
  */
  public DynamicArray(int capacity) {
    if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
    this.capacity = capacity;
    arr = (T[]) new Object[capacity];
  }
  // method that returns arr size
  public int size() {
    return len;
  }
  // method that checks whether the array is empty or not 
  public boolean isEmpty() {
    return size() == 0;
  }
  // get the array index and set its elements 
  public T get(int index) {
    return arr[index];
  }
  //  We are using void becuase the method doesn't have any return value
  public void set(int index, T elem) {
    arr[index] = elem;
  }
  // method for clearing elements in array
  public void clear() {
    for (int i = 0; i < len; i++) arr[i] = null;
    len = 0;
  }
  // Let's now resize the array and add items into it 
  public void add(T elem) {

    // Time to resize!
    if (len + 1 >= capacity) {
      if (capacity == 0) capacity = 1;
      else capacity *= 2; // double the size
      T[] new_arr = (T[]) new Object[capacity];
      for (int i = 0; i < len; i++) new_arr[i] = arr[i];
      arr = new_arr; // arr has extra nulls padded
    }

    arr[len++] = elem;
  }
  // method to remove elements from a specified index
  public T removeAt(int rm_index) {
    if (rm_index >= len || rm_index < 0) throw new IndexOutOfBoundsException();
    T data = arr[rm_index];
    T[] new_arr = (T[]) new Object[len - 1];
    for (int i = 0, j = 0; i < len; i++, j++)
      if (i == rm_index) j--; // Skip over rm_index by fixing j temporarily
      else new_arr[j] = arr[i];
    arr = new_arr;
    capacity = --len;
    return data;
  }
  
  // methods for removing objects from index and removing index of that object
  public boolean remove(Object obj) {
    int index = indexOf(obj);
    if (index == -1) return false;
    removeAt(index);
    return true;
  }
  
  public int indexOf(Object obj) {
    for (int i = 0; i < len; i++) {
      if (obj == null) {
        if (arr[i] == null) return i;
      } else {
        if (obj.equals(arr[i])) return i;
      }
    }
    return -1;
  }
  //just sanity check that index not equals -1 
  public boolean contains(Object obj) {
    return indexOf(obj) != -1;
  }
  
  @Override
  public java.util.Iterator<T> iterator() {
    return new java.util.Iterator<T>() {
      int index = 0;

      @Override
      public boolean hasNext() {
        return index < len;
      }

      @Override
      public T next() {
        return arr[index++];
      }

      @Override
      public void remove() {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  @Override
  public String toString() {
    if (len == 0) return "[]";
    else {
      StringBuilder sb = new StringBuilder(len).append("[");
      for (int i = 0; i < len - 1; i++) sb.append(arr[i] + ", ");
      return sb.append(arr[len - 1] + "]").toString();
    }
  }
}
