package linkedListCode;

public class RotateDoublyLinkedList {

	static Node head;
	static class Node {
		String data;
		Node next,prev;
		Node(String inputdata){
			data=inputdata;
			next=prev=null;			
		}
	}	
	void insert(String data){
		Node newNode=new Node(data);
		
		newNode.prev=null;
		newNode.next=head;
		if(head!=null)
			head.prev=newNode;
		head=newNode;
		
	}	
	void printDoublyLinkedList(Node node){
		while(node!=null)
		{
			System.out.print(node.data+ "->");
			node=node.next;
		}
	}	
	void rotateCounterClock(int num){
		if(num==0)
			return ;
		Node first=head;
		int counter=1;
		while(counter < num && first !=null){
			counter++;
			first=first.next;
		}
		
		if(first== null)
			return;
		
		Node NNode=first;
		
		while(first.next!=null)
			first=first.next;
		
		first.next=head;		
		head.prev=first;
		head=NNode.next;
		head.prev=null;
		NNode.next=null;
		
	}
	public static void main(String[] args) {
		
		RotateDoublyLinkedList list=new RotateDoublyLinkedList();
		list.insert("a");
		list.insert("b");
		list.insert("c");
		list.insert("d");
		list.insert("e");
		
		list.printDoublyLinkedList(head);
		list.rotateCounterClock(2);
		System.out.println();
		list.printDoublyLinkedList(head);		
		
		

	}

}
