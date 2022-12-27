package LinkedList;

public class LinkedListOperation extends LinkedList{
	
	public void RotateClockByK(int k) {
		int c=1,n=this.size();
		Node temp=head;
		k=k%n;
		if(k>=1) {
		while(c<n-k) {
			temp=temp.next;
			c++;
		}
		Node temp1=temp;
		temp=temp.next;
		temp1.next=null;
		temp1=temp;
		while(temp.next!=null)
			temp=temp.next;
		temp.next=head;
		head=temp1;
	}
		
}
	
	public void RotateAntiClockByK(int k) {
		int c=1,n=this.size();
		Node temp=head;
		k=k%n;
		if(k>=1) {
		while(c<k) {
			temp=temp.next;
			c++;
		}
		Node temp1=head;
		head=temp.next;
		temp.next=null;
		temp=head;
		while(temp.next!=null)
			temp=temp.next;
		temp.next=temp1;
	}
		
	}
	
	public int size() {
		if(head==null)
			return 0;
		Node temp=head;
		int c=0;
		while(temp!=null) {
			temp=temp.next;
			c++;
		}
		return c;
	}
	
	
	public void reverseLinkedList() {
			if(head==null) {
				System.out.println("Linked list is empty");
				return;
			}
			
			Node pre_p = null;
			Node curr_p = head;
			Node next_p;
			while(curr_p!=null) {
				next_p=curr_p.next;
				curr_p.next=pre_p;
				pre_p=curr_p;
				curr_p=next_p;
			}
			
			head=pre_p;
	}
	
	public int middleElement() {
		if(head==null) {
			System.out.println("Linked list is empty");
			return -1;
		}
		Node slow_p= head , fast_p=head;
		while(fast_p!=null  && fast_p.next!=null ) {
			slow_p=slow_p.next;
			fast_p=fast_p.next.next;
		}
		
		return slow_p.data;
		
	}
	
	
	
	public static void main(String[] args) {
		LinkedListOperation ll1 = new LinkedListOperation();
		ll1.addNodeFirst(23);
		ll1.addNodeFirst(56);
		ll1.addNodeFirst(76);
		ll1.addNodeFirst(53);
		ll1.addNodeFirst(120);
		ll1.addNodeFirst(7);
		ll1.printLinkedList();
		System.out.println("Size of Linked List:"+ll1.size());
		ll1.RotateAntiClockByK(6);
		ll1.printLinkedList();
		ll1.RotateClockByK(1);
		ll1.printLinkedList();
		ll1.reverseLinkedList();
		ll1.printLinkedList();
		System.out.println("Middle Element:"+ll1.middleElement());
		ll1.printLinkedList();

	}

}
