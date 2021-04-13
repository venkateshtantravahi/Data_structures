# Create Array Class 
'''So now let's define a constructor using init method python which accepts 
size and the default value of array'''
Class Array(object):
  def __init__(self, size, defaultValue=None):
    self.size = size
    if(defaultValue == None): # If no value is specified then append None to the created items list
      self.items = list()
      for i in range(size):
        self.items.append(defaultValue)
    else:
      self.items = list()
      
      if (len(defaultValue) == size or len(defaultValue)<size):
        for j in range(len(defaultValue)):
          if(defaultValue[j]): # if some value exists at index then append to created list
            self.items.append(defaultValue[j])
        for i in range(len(defaultValue),size): # fill the remaining size with None values
          self.items.append(None)
      else:
        print('Elements are more than the size required')
        
  # Defining length of array function
  # This function is used to return length of array that means the elem we intialized excluding zero
  
  def myLen(self):
    length = 0
    for i in self.items:
      if i == None:
        continue
      else:
        length += 1
    return length
  # Define Array left append function
  # this function is used to insert or add the elements to the beginning of the array
  
  def insertleft(self, element):
    if (self.myLen() < self.size):
      for i in range(self.myLen(), 0, -1):
        self.items[i] = self.items[i-1]
      self.items[0] = element
   else:
    print('Element index out of range!')
    
  #Define InsertAt index function 
  # This function is used to insert or add an element at a particular index or position which the user passed along with the elements to insert.
  def insertAtIndex(self, index, element):
    if (self.myLen() < self.size):
      for i in range(self.myLen(), index, -1):
        self.items[i] = self.items[i-1]
      self.items[index] = element
    else:
      print('Element index out of range')
      
  # Define insert After index function
  # this function is used to insert or add an element after a particular index or position which the user passed along with the element to insert.
  def insertAfterIndex(self, index, element):
    if (self.myLen() < self.size):
      for i in range(self.myLen(), index + 1, -1):
        self.items[i] = self.items[i - 1]
      self.items[index + 1] = element
      else:
        print('Element index out of range')
  
  # Define insert before index function
  #This function is used to insert or add an element before a particular index or position which user passed along with the element to insert.
  def insertBeforeIndex(self, index, element):
    if (self.myLen() < self.size):
      for i in range(self.myLen(), index - 1, -1):
        self.items[i] = self.items[i - 1]
      self.items[index - 1] = element
      else:
        print('Element index out of range')
  
  # Defining Delete funcion
  def delete(self, element):
    if element in self.items:
      Index = self.items.index(element)
      self.items[Index] = None
    else:
      print('This element is not in the Array!')
  
  # Define Search function 
  def search(self, element):
    if element in self.items:
      position = 0
      for i in range(self.myLen()):
        if(self.items[i] == element):
          break
        else:
          position += 1
      print('Element {} found at position {}'.format(element,position))
    else:
      print('This element is not in the Array!')
      
 
# Define the main function to call the Array class
if __name__ == "__main__":
  myArray = Array(5,[1])
  print(myArray.items, myArray.myLen())
  myArray.insertLeft(3)
  print(myArray.items, myArray.myLen())
  myArray.insertAfterIndex(1,4)
  print(myArray.items, myArray.myLen())
  myArray.insertBeforeIndex(3,5)
  print(myArray.items, myArray.myLen())
  myArray.delete(5)
  print(myArray.items, myArray.myLen())
  myArray.search(4)
  
  
  
