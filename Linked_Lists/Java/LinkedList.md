# What is Linked List?
A linked list is a sequential list of nodes that hold data which points to other nodes also containing data.

#### Universally defined as 
In computer science, a linked list is a linear collection of data elements whose order is not given by their physical placement in memory. 
Instead, each element points to the next. It is a data structure consisting of a collection of nodes which together represent a sequence. 

![Linked List](https://user-images.githubusercontent.com/64308188/115104333-57535080-9f75-11eb-9cfc-e74d74954edd.png)

- Every node acts as a pointer to the next node.
- First Node is called as head , where last node as tail.
- Last node always point to null reference which indicates the end of data.

## Where Linked List Used?
- Used in many abstract data types such as Lists, Queues, and stack implementation.
- Great for creating circular lists.
- Can easily model real world objects such as trains, people standing in line etc.
- Used in seperate chaining, which is present in certain hash table implementations to deal with handling collisions.
- often used in the implementation of adjacency lists for graphs.
- In a 32-bit machine each reference takes 4bytes and if 64-bit then taes 8bytes.

### Terminology:
**Head**: The first node in a linked list.
**Tail**: The last node in a linked list.
**Pointer**: Referance to another node.
**Node**: An object containing data and pointer(s).

![Linked_List](https://user-images.githubusercontent.com/64308188/115104616-4e637e80-9f77-11eb-83ac-28b951ac25d3.png)

Linked List are mainly two types: 
1. Single Linked List
2. Double Linked List

### Sinlge Linked List
Sinlge liked list only holds a reference to the next node. In the implementation you always maintain a reference to the <ins>head</ins> and <ins>tail</ins> 
of the linked list for quick additions/ removals. \
![singly_linked_list](https://user-images.githubusercontent.com/64308188/115104833-acdd2c80-9f78-11eb-9de6-08b30a52e97f.png)

### Doubly Linked List
With a doubly linked list each node holds a reference to the next node as well as to the previous node. In implementation you always hold other two pointers to 
the head and the tail of the linked list for ease of operational access.
![image](https://user-images.githubusercontent.com/64308188/115105468-c4b6af80-9f7c-11eb-836c-07910107ddae.png)

## Pros and Cons
    Name | Pros                               | Cons
    SLL  | less memory, simpler implemetation | Cannot access previous ele
    DLL  | Can be traversed bacwards          | Takes 2x memory
    
 
## Inserting into Linked List 
Baically below gif demonstrate how we are inserting a new node into linked list.
![562e49](https://user-images.githubusercontent.com/64308188/115116811-488e8d00-9fb9-11eb-901f-de13235b1e6c.gif)

## Inserting into doubly linked list
The gif below demonstrate how we insert element into doubly linked list
![Webp net-gifmaker](https://user-images.githubusercontent.com/64308188/115117473-5560b000-9fbc-11eb-8259-99d6284bef42.gif)

## Removing elements from singly linked list
- Initialize two variables trav1, trav2 such that trav1 points the head, trav2 points heads next node.
- start traversing by incrementing a position of both trav1, trav2 until trav2 points the node that we should remove.
- Create a temp to allocate the memory of removing node such that can be used for reference.

### We are removing 9 from the linked list will be demonstrated by following gif
![Webp net-gifmaker](https://user-images.githubusercontent.com/64308188/115117904-76c29b80-9fbe-11eb-97bc-822819496f83.gif)

## Removing elements from doubly linked list
- The main advantage here is we don't need an explicitly an other pointer to have reference to previous node, as DLL already has a reference to previous node.
- It is easier to remove an element from DLL compared to SLL

### Removing 9 from DLL
![Webp net-gifmaker](https://user-images.githubusercontent.com/64308188/115119020-f56e0780-9fc3-11eb-9e7a-da3cf55e4547.gif)

## Complexity Analysis
      
      Operation       | Sinlgy-linked-list | Doubly-linked-list
      ----------------|--------------------|-------------------
      Search          |       O(n)         |      O(n)
      InsertAt Head   |       O(1)         |      O(1)
      InsertAt Tail   |       O(1)         |      O(1)
      RemoveAt Head   |       O(1)         |      O(1)
      RemoveAt Tail   |       O(n)         |      O(1)
      RemoveIn Middle |       O(n)         |      O(n)
