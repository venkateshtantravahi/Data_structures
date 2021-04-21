#include <stdio.h>
#define SIZE 20
#include<stdlib.h>
int queue_array[20];
int rear = - 1;
int front = - 1;
void insertion()
{
      int add_item;
      if (rear == SIZE - 1)
            printf("Queue Overflow \n");
      else
      {
            if (front == - 1)
                  
                  front = 0;
            printf("\nEnter element : ");
            scanf("%d", &add_item);
            printf("\n%d is inserted in queue\n\n",add_item);
            
            rear = rear + 1;
            queue_array[rear] = add_item;
      }
}
void deletion()
{
      if (front == - 1 || front > rear)
      {
            printf("Queue Underflow \n");
            return ;
      }
      else
      {
            printf("\nElement deleted from queue is : %d\n\n", queue_array[front]);
            
            front = front + 1;
      }
}
void display()
{
      int i;
      if (front == - 1)
            printf("Queue is empty \n");
      else
      {
            printf("\nQueue is : ");
            for (i = front; i <= rear; i++)
                  printf("%d ", queue_array[i]);
            
            printf("\n");
      }
}
int main()
{
      printf(" your choice\n\n");
      
      
      
      printf("1. Insert element \n");
      printf("2. Delete element \n");
      printf("3. Display queue\n");
      printf("4. Exit\n\n");
     
      int ch;
      while (1)
      {
            printf("Choose operation : ");
            scanf("%d", &ch);
            switch(ch)
            {
                  case 1:
                        insertion();
                        break;
                  case 2:
                        deletion();
                        break;
                  case 3:
                        display();
                        break;
                  case 4:
                        exit(1);
                  default:
                        printf("Invalid operation \n");
            }
      }
      return 0;
  }
