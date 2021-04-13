# Data_structures
A DS is a way of organising data so that it can be used effectively. (or) \
In computer science, a data structure is a data organization, management and storage format that enables efficient access and modification / It's a collection of data values , the relationships among them, and the functions (or) operations that can be mapped on them.
 
 ### Why Data Structures?
 - They are essential ingrediants in creating fast & powerful algorithms.
 - They help to organize and manage data.
 - They make code cleaner & easier to understand.

### Abstract Data Types Vs. Data Structure
An ADT is an abstraction of a data structure which provides only the interface to which the data structure must adhere to.The interface doesnot give any specific details about how something should be implemented or in what programming language.

##### Example:
![image](https://user-images.githubusercontent.com/64308188/114512711-07b01480-9c57-11eb-8110-27623a4d71a2.png)

# Computational Complexity Analysis
The two final questions that we end up writing an algorithm is:
- How much <ins> time </ins> does this algorithm need to finish?
- How much <ins> space </ins> does this algorithm need for its computation ?

### Big-O Notation
Big-O Notation gives an upper bound of the complexity in the <ins> worst </ins> case, helping to quantify performance as the input size becomes <ins>arbitrarily large.</ins>
- Big-O notation always cares about the worst case of input , it never looks into the case where input is small.

### Terminology
where n -- The size of the input \
*complexity ordered from smallest to largest*
* Constant Time : O(1)
* Logarithmic Time : O(log(n))
* Linear Time : O(n)
* Linearithmic time : O(nlog(n))
* Quadric Time : O(n<sup>2</sup>)
* Cubic Time : O(n<sup>3</sup>)
* Exponential Time : O(b<sup>n</sup>) , b>1
* Facorial Time : O(n!)

##### Let's dive into Big-O properties and some examples 
    O(n+c) = O(n)
    O(cn) = O(n) , c>0
    Where C is a constant and the value of c has some substantial impact of computation of algorithm

Let f be a function that describes the running time of a particular algorithm for an input of size n:
    
  f(n) = 7log(n)<sup>3</sup>+15n<sup>2</sup>+2n<sup>3</sup>+8 \
  O(f(n)) = O(n<sup>3</sup>)
  
#### Constant Time Complexity : O(1)
 Algorithm is said to be <ins>Constant time</ins> if the value of T(n) is bounded by a value that does not depend on the size of the input.
    
    For Example1 : | For Example2 :
     --------------|----------------
      a := 1     |  i=0
      b := 2     |  while i<11: DO
      c := a+5*b |      i = i+1
      
#### Linear Time Complexity : O(n)
 This means running time increases at most linearly with the size of the input.Linear time is the best possible time complexity in situations where 
 the algorithm has to sequentially reas its entire input.
 
    For Example 1: | For Example 2:
    ---------------|---------------
    i:=0           |  i:=0
    while i<n: Do  | while i<n: Do
      i = i+n      |    i = i+3
    f(n)=n==>O(f(n))=O(n) | f(n)=n/3==>O(f(n))=O(n)
    
#### Quadric Time Complexity : O(n<sup>2</sup>)
  This represents an algorithm whose performance is directly propotional to the squared size of the input data size. \
  
      For Example1:
         for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
         f(n) = n*n = n^2 ==> O(f(n)) = O(n^2)
      
      For Example2:
         for (int i=0;i<n;i++)
            for (int j=i;j<n;j++)
      ==> Both of the following run in quadric time.
          The first one is obvious since "n" workdone n-times is n*n = O(n^2), but what about the second one? look carefully and try to ans it
          
 <details>
  <summary>Click to view ans</summary>
  <p>
    For a moment just focus on the second loop. Since "i" goes from [0,n) the amount of looping done is directly determined by what is.. \
      Remark that i=0, we do 'n' work \
                  i=1, we do 'n-1' work \
                  i=2, we do 'n-2' work and so..on till end \
    So the Question becomes that what is .. \ 
    
      n + (n-1) + (n-2) + (n-3) + ..... + 3 + 2 + 1 ?
      Remarkably this turns out to be n(n+1)/2
   So , O(n(n+1)/2) = O(n<sup>2</sup>/2 + n/2) = O(n<sup>2</sup>) 
  </p>
  </details>
  
#### Logarithmic Time Complexity 
Logarithmic running time essentially means that the running time grows in propotion to the logarithm of the input size.

--> Suppose we have a sorted array and we want to find the index of a particular value in the array if it exists or not, then what is the time complexity of that 
    algorithm ?
    
<details>
  <summary>View your ans here..</summary>
  <p>
    Ans : O(log<sub>2</sub>(n)) = O(log(n))
    
    low := 0
    high := n-1
    while low<=high Do:
        mid := (low+high)/2
        If array[mid] == value : return mid;
        else If array[mid] < value : lo = mid+1
        else If array[mid]>value : hi = mid-1
        return -1 // If value not found
  </p>
</details>

#### How do you calculate time complexity of a psudeo code?

    Example 1:       | Example2:
    -----------------|------
    i := 0           |  i:=0
    while i<n Do     |  while i<3*n Do
      j=0            |    j := 10
      while j<3*n DO |    while j<=50 Do
        j=j+1        |      j = j+1
      j=0            |    j=0
      while j<2*n Do |    while j<n*n*n Do
        j=j+1        |      j = j+2
      i = i+1        |    i = i+1
    for the above fn |  for the above fn
    f(n) = n*(3n+2n) |  f(n) = 3n*(40+n^3/2)
       = 5n^2        |       = 3n/40 + 3n^4/40
    O(f(n)) = O(n^2) |  O(f(n)) = O(n^4)
    
##### Other random examples are 
- Finding all subsets of a set - O(2<sup>n</sup>)
- Finding all permutations of a string - O(n!)
- sorting using mergesort - O(nlog(n))
- Iterating over all the cells in a matrix of size nxm - O(nm)

So it's a lot of information regarding time complexity so without any further delay lets jump into different forms of data structures and thier use cases along with some psuedo code in the next readme
