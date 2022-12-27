package LinkedList;

public class LinkedListLoop extends LinkedListOperation{
	
	public boolean detectLoop() {
		if(head==null) {
			return false;
		}
		Node slow_p = head;
		Node fast_p = head;
		
		while(fast_p!=null && fast_p.next!=null) {
			slow_p=slow_p.next;
			fast_p=fast_p.next.next;
			if(fast_p==slow_p)
				return true;
		}
		return false;
		
	}
	
	public int lengthOfLoop() {
		if(head==null) {
			return -1;
		}
		Node slow_p = head;
		Node fast_p = head;
		int c=0;
		
		while(fast_p!=null && fast_p.next!=null) {
			slow_p=slow_p.next;
			fast_p=fast_p.next.next;
			if(fast_p==slow_p)
				break;
		}
		
		if(fast_p==slow_p) {
			slow_p=slow_p.next;
			while(slow_p!=fast_p) {
				c++;
				slow_p=slow_p.next;
			}
			return c+1;
		}
	return -1;
	}
	
	
	
	public Node intersectionPoint() {
		if(head==null) {
			return null;
		}
		Node slow_p = head;
		Node fast_p = head;
		Node start=head;
		
		while(fast_p!=null && fast_p.next!=null) {
			slow_p=slow_p.next;
			fast_p=fast_p.next.next;
			if(fast_p==slow_p)
				break;
		}
		
		if(fast_p==slow_p) {
			while(slow_p!=start) {
				slow_p=slow_p.next;
				start=start.next;
			}
			return start;
		}
		return null;
	}
	
	public void removeLoop() {
		if(head==null) {
			return;
		}
		Node slow_p = head;
		Node fast_p = head;
		Node start=head;
		
		while(fast_p!=null && fast_p.next!=null) {
			slow_p=slow_p.next;
			fast_p=fast_p.next.next;
			if(fast_p==slow_p)
				break;
		}
		
		if(fast_p==slow_p) {
			if(fast_p==head) {
				while(slow_p.next!=head)
					slow_p=slow_p.next;
				slow_p.next=null;
				return;
			}
			
			while(slow_p.next!=start.next) {
				slow_p=slow_p.next;
				start=start.next;
			}
			slow_p.next=null;
		}
		
	}
	
	

	public static void main(String[] args) {
		LinkedListLoop ll2 = new LinkedListLoop();
		ll2.addNodeFirst(23);
		ll2.addNodeFirst(56);
		ll2.addNodeFirst(76);
		ll2.addNodeFirst(53);
		ll2.addNodeFirst(120);
		ll2.addNodeFirst(7);
		ll2.printLinkedList();
		System.out.println("Size of Linked List:"+ll2.size());
		System.out.println("Middle Element:"+ ll2.middleElement());
		
		// Create loop in LinkedList
		System.out.println(ll2.head.next.next.next.next.next.data);
		ll2.head.next.next.next.next.next.next=ll2.head.next.next;
		System.out.println(ll2.detectLoop());
		System.out.println(ll2.lengthOfLoop());
		System.out.println(ll2.intersectionPoint().data);
		//ll2.printLinkedList();
		ll2.removeLoop();
		System.out.println(ll2.detectLoop());
		ll2.printLinkedList();

	}

}
