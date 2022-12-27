package LinkedList;


class Node{
	int data;
	Node next;
}

public class LinkedList {
	
	Node head=null;
	
	public Node createNode(int data) {
		Node n = new Node();
		n.data=data;
		n.next=null;
		return n;
	}
	
	public void addNodeFirst(int data) {
		Node ptr = createNode(data);
		if(head==null) {
			head=ptr;
			return;
		}
		
		ptr.next=head;
		head=ptr;
	}
	
	public void addNodeLast(int data) {
		Node ptr = createNode(data);
		if(head==null) {
			head=ptr;
			return;
		}
		
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=ptr;
		
	}
	
	
	public void addNodeSpecificPostion(int data,int pos) {
		Node ptr = createNode(data);
		if(head==null) {
			head=ptr;
			return;
		}
		if(pos>0) {
		
		if(pos==1) {
			addNodeFirst(data);
			return;
		}
			
		int c=0;
		Node temp=head;
		while(c < pos-2) {
			temp=temp.next;
			c++;
		}
		ptr.next=temp.next;
		temp.next=ptr;
		}
		
	}
	
	public int removeNodeFirst() {
		if(head==null) {
			System.out.println("Linked list is empty");
			return -1;
		}
		int data=head.data;
		head=head.next;
		
		return data;
	}
	
	public int removeNodeLast() {
		if(head==null) {
			System.out.println("Linked list is empty");
			return -1;
		}
		
		Node temp = head;
		while(temp.next.next!=null)
			temp=temp.next;
		int data=temp.next.data;
		temp.next=null;
		
		return data;
	}
	
	void printLinkedList() {
		if(head==null) {
			System.out.println("Linked list is empty");
			return;
		}
		
		Node temp = head;
		System.out.println();
		System.out.print("List: ");
		while(temp.next!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.print(temp.data);
		System.out.println();
	}
	
	
	

	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addNodeFirst(23);
		ll.addNodeFirst(56);
		ll.addNodeFirst(76);
		ll.printLinkedList();
		ll.addNodeFirst(11);
		ll.printLinkedList();
		System.out.println(ll.removeNodeLast());
		ll.printLinkedList();
		ll.addNodeLast(45);
		ll.printLinkedList();
		System.out.println(ll.removeNodeFirst());
		ll.printLinkedList();
		System.out.println(ll.removeNodeFirst());
		ll.printLinkedList();
		ll.addNodeSpecificPostion(12, 2);
		ll.printLinkedList();
		ll.addNodeFirst(63);
		ll.printLinkedList();
		ll.addNodeFirst(86);
		ll.addNodeSpecificPostion(6, 4);
		ll.printLinkedList();
		ll.addNodeSpecificPostion(22, 2);
		System.out.println(ll.removeNodeLast());
		ll.printLinkedList();
		System.out.println(ll.removeNodeFirst());
		System.out.println(ll.removeNodeFirst());
		System.out.println(ll.removeNodeFirst());
		System.out.println(ll.removeNodeFirst());
		System.out.println(ll.removeNodeFirst());
	}

}
