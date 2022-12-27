package Queue;

 class PriorityQueueAscending
{
    private int[] arr;      // array to store queue elements
    private int front;      // front points to the front element in the queue
    private int rear;       // rear points to the last element in the queue
    private int capacity;   // maximum capacity of the queue
    int count;      // current size of the queue
 
    // Constructor to initialize a queue
    PriorityQueueAscending(int size)
    {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }
 
    // Utility function to dequeue the front element
    public int priorityDequeue()
    {
        // check for queue underflow
        if (priorityIsEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
 
        int x = arr[front];
 
        System.out.println("Removing " + x);
 
        front = (front + 1) % capacity;
        count--;
 
        return x;
    }
 
    // Utility function to add an item to the queue
    public void priorityEnqueue(int item)
    {
        // check for queue overflow
        if (priorityIsFull())
        {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(-1);
        }
 
        System.out.println("Inserting " + item);
        if(rear!=-1 && arr[rear]>item) {
        	int t=arr[rear];
        	arr[rear]=t;
        	item=t;
        }
 
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }
 
    // Utility function to return the front element of the queue
    public int priorityPeek()
    {
        if (priorityIsEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
        return arr[front];
    }
 
    // Utility function to return the size of the queue
    public int prioritySize() {
        return count;
    }
 
    // Utility function to check if the queue is empty or not
    public boolean priorityIsEmpty() {
        return (prioritySize() == 0);
    }
 
    // Utility function to check if the queue is full or not
    public boolean priorityIsFull() {
        return (prioritySize() == capacity);
    }
    public void printPriorityQueue() {
    	if (priorityIsEmpty())
        {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(-1);
        }
    	
    	int t=front;
    	System.out.println("Priority Queue: ");
    	while(rear!=front) {
    		System.out.print(arr[t]);
    		t=(t+1)%capacity;
    	}
    	System.out.print(arr[t]);
    	
    }
    
    
    
}
 
public class PriorityQueue
{
    public static void main (String[] args)
    {
        // create a queue of capacity 5
    	PriorityQueueAscending q = new PriorityQueueAscending(10);
 
        q.priorityEnqueue(56);
        q.priorityEnqueue(32);
        q.priorityEnqueue(2);
        q.priorityEnqueue(43);
        q.priorityEnqueue(88);
        q.priorityEnqueue(11);
        //q.printPriorityQueue();
        System.out.println("The front element is " + q.priorityPeek());
        q.priorityDequeue();
        System.out.println("The front element is " + q.priorityPeek());
 
        System.out.println("The queue size is " + q.priorityPeek());
 
        q.priorityDequeue();
        q.priorityDequeue();
        q.printPriorityQueue();
 
        if (q.priorityIsEmpty()) {
            System.out.println("The queue is empty");
        }
        else {
            System.out.println("The queue is not empty");
        }

}
    
}