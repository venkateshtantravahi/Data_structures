''' ctypes is a foriegn function library for Python.It provides C compatible data types,
and allows calling functions in DLLs or shared libraries. It can be used to wrap these
libraries in pure Python.
'''
import ctypes

class DynamicArray(object):
  '''
  Dynamic array class (similar to python list)
  '''
  
  def __init__(self):
    self.n = 0 #count actual elements (Default is 0)
    self.capacity = 1 # Default capacity
    self.A = self.make_array(self.capacity)
    
  def __len__(self):
    # returns number of elements sorted in array
    return self.n
  
  def __getItem__(self, k):
    # return element at index k
    if not 0<= k <self.n:
      # Check if k index is in bounds of array
      return IndexError('K is out of bounds!')
    return self.A[k] # Retrieve from array at index k
  
  def append(self, ele):
    # add element to end of the array
    if self.n == self.capacity:
      #Double the capacity if index is out of bounds
      self._resize(2* self.capacity)
    self.A[self.n] = ele # set self.n index to element
    self.n += 1
    
  def insertAt(self,item,index):
    # this function inserts item at specified index
    if index<0 or index>self.n:
      print("Please enter appropriate index..")
      return
    
    if self.n == self.capacity:
      self._resize(2*self.capacity)
      
    for i in range(self.n-1,index-1,-1):
      self.A[i+1]=self.A[i]
    self.A[index]=item
    self.n += 1
    
  def delete(self):
    #This function deletes item from the end of array 
    if self.n==0:
      print("Array is empty deletion is not possible")
      return 
    self.A[self.n-1]=0
    self.n -= 1
    
  def removeAt(self, index):
    # this function deletes item from index..
    if self.n==0:
      print("Array is empty deletion is not possible")
      return 
    
    if index<0 or index>=self.n:
      return IndexError("Index out of bounds!... deletion is not possible")
    
    if index==self.n-1:
      self.A[index]=0
      self.n -= 1
      return
    for i in range(index, self.n-1):
      self.A[i] = self.A[i+1]
    self.A[self.n-1]=0
    self.n -= 1
    
  def _resize(self, new_cap):
    # resize the internal array to new_cap
    B = self.make_array(new_cap)# new bigger array
    for k in range(self.n): # Reference all existing values
      B[k] = self.A[k]
    self.A = B # call A the new bigger array
    self.capacity = new_cap #Reset the capacity 
    
 def make_array(self, new_cap):
  #returns a new array with new capacity
  return (new_cap * ctypes.py_object)()


## Lets Instantiate our DynamicArray class and append items
a = DynamicArray()
a.append(1)
a.append(2)
a.append(3)
print(a,len(a)) # prints [1,2,3] 3
a.insertAt(2,2)
print(a, len(a)) # prints [1,2,2] 3
