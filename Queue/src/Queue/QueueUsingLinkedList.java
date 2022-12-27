package Queue;


class Node {
	int data;
	Node next;
}

class QueueLinkedList{
	
	Node first;
	Node last;
	int size;
	
	public Node getNewNode (int val){
		Node n = new Node();
		n.data=val;
		n.next=null;
		return n;
	}
	
	public void enqueue(int val) {
		if(last==null) {
			last=getNewNode(val);
			first=last;
			size+=1;
			return;
		}
		
		Node t=getNewNode(val);
		last.next=t;
		last=t;
		size+=1;
	}
	
	public int dequeue() {
		if(first==null) {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		
		Node t=first;
		first=first.next;
		size-=1;
		return t.data;
	}

	public void printQueue() {
		if(first==null) {
			System.out.println("Stack is empty");
			return;
		}
		
		Node t=first;
		while(t!=last) {
			System.out.print(t.data+" ");
			t=t.next;
		}
		System.out.print(t.data+" ");
		
	}
	
	
	
}



public class QueueUsingLinkedList {
	public static void main(String[] args) {
		QueueLinkedList a = new QueueLinkedList();
		a.enqueue(24);
		a.enqueue(3);
		a.enqueue(6);
		a.enqueue(78);
		System.out.println(a.dequeue());
		a.enqueue(70);
		a.enqueue(7);
		System.out.println("QUEUE :");
		a.printQueue();
		System.out.println();
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println("QUEUE :");
		a.printQueue();
		System.out.println();
		System.out.println(a.dequeue());
	
	}

}

