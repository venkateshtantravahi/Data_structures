## Arrays
  Arrays are the collection of various objects.They can be of static(fixed length) and dynamic(which can be of varying length)
  
### What is static Array?
- A static array is a fixed length container containing 'n' elements <ins>indexable</ins> from the range [0,n-1] 
- Static arrays are referred as contigous chunks of memory

### What is meant by being indexable ?
- This means that each slot\index in the array can be referred with a number.

#### When and where we use Static array ?
1. Sorting and accessing sequential data.
2. Temporarily storing Objects.
3. Used by I/O routines as buffers.
4. Lookup tables and inverse lookup tables.
5. Can be used to return multiple values from a function.
6. Used in dynamic programming to cache ans to sub-problems.

### Complexity of Arrays
      
            Static |  Dynamic
    --------------------------
    Access | O(1)  | O(1)
    Search | O(n)  | O(n)
    Insert | N/A   | O(n)
    Append | N/A   | O(1)
    Delete | N/A   | O(n)
    
#### Declaring and Accessing Static Arrays 

      A = [44,12,-5,17,6,0,3,9,100]
        = [0, 1, 2, 3, 4,5,6,7,8]
 We can access the elements of the array by referring either by thier index or by looping element into array \
 Array indexing is zero-based means the first element is found in position zero. \
 
     example: A[0] = 44, A[1]=12,...... ,A[9] = index out of bounds
As from the above example you can see that referring index which is not present will always give an exception. \

- We can directly re-assign the values in the array by referring thier indexes.

      example: A[0] := -1 , A[5] := 18, A[6] := 25
![Static Array Implementation](Static_Array.java)  

## Dynamic Array:
  In computer science, a dynamic array, growable array, resizable array, dynamic table, mutable array, or array list is a random access, \
  variable-size list data structure that allows elements to be added or removed. It is supplied with standard libraries in many modern \
  mainstream programming languages.
### Operations on dynamic Arrays:

- The dynamic array can grow and shrink in size.

                   A = [34,4] // intial array declaration
      A.add(-7)    A = [34,4,-7]
      A.add(34)    A = [34,4,-7,34]
      A.remove(4)  A = [34,-7,34]
     
# How can we create Dynamic Array ?
1. Create a static array with an initial capacity.
2. Add elements to the underlying static array, keep track of number of elements.
3. If adding another element exceeding the capacity, then create a new static array with twice the capacity and copy the original elements into it.

        example: Suppose We created a dynamic array with an initial capacity of two and then begin adding elements into it.
        A = [@,@] ==> [7,@] ==> [7,-9]
            [7,-9,3,@] ==> [7,-9,3,12]
            [7,-9,3,12,5,@,@,@] ==> [7,-9,3,12,5,6,@,@]

refer code here 
![dynamic_Array_implementation](DynamicArray.java)
