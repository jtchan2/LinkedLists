import java.util.*;

public class LinkedList<E>{
	private class Node<E>{
		E data;
		Node<E> next;

		public Node (E value){
			data=value;
			next=null;
		}
	}
	Node<E> head;
	int size;
	public LinkedList(){
		head=null;
		size=0;
	}
	public void add(E item){
		//checks if list is empty and add it to first index else add item to the end and at the end it increases the size
		if(head==null){
			head= new Node<E>(item);
			++size;
		}else{
			Node <E>prev= head;
			while(prev.next!= null){
				prev=prev.next;
			}
			Node<E> node = new Node<E>(item);
			prev.next= node;
			++size;
		}
	}
	public void add(E item, int pos){
		//Checks if index is 0  and makes it head of link list and if not adds to the given point with both increasing the size
		if(pos==0){
			Node<E>node= new Node<E>(item);
			node.next= head;
			head=node;
			++size;
		}else{
			Node<E> prev= head;
			//moves every index to the right from where new item put in
			for(int i=0; i<pos-1; i++){
				prev = prev.next;
			}

			Node<E> node= new Node<E>(item);
			node.next=prev.next;
			prev.next=node;
			++size;
			//increases size due to new item added 
		}
	}
	public E get(int pos){
		//Checks if position is valid point if not returns null else retrives item from given index
		if(pos<0||pos>=size){
			return null;
		}
		Node<E> curr= head;
		for(int i=0; i<pos;i++){
			curr=curr.next;
		}
		return curr.data;
	}
	public E remove(int pos){
		//First Checks if position is at only 1 index of list then goes to remove it a
		if(pos==0){
			Node<E> node=head;
			head= head.next;
			--size;
			return node.data;
		}else{
			Node<E> prev=head;
			//loops through list to find position of item
			for(int i=0; i<pos-1;i++){
				prev=prev.next;
			}
			//once found it removes item and shift elements right of the item to the left 
			Node<E>node=prev.next;
			prev.next=node.next;
			--size;
			return node.data;
			//after removing node it decrements size
		}
	}

	public Node<E> reverse(Node<E> head){
		// create pointers to keep track of lsit and items when changing
		Node<E> prev=null;
		Node<E> curr= head;
		Node<E> next= null;
		while(curr!=null){
			//Swaps pointers until it has reversed the list
			next= curr.next;
			curr.next=prev;
			prev=curr;
			curr=next;
		}
		head=prev;
		return head;
	}
	public void linkToString(){
		//A variation of toString method so list can be printed
		Node<E> node= head;
		while(node!=null){
			System.out.print(node.data+"==> ");
			node=node.next;
		}
		System.out.println();
	}
	public static void main(String [] args){
		LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(4);
        list.add(5,1);
        list.add(7);
        list.add(2,3);
        list.linkToString();
        System.out.println(list.remove(3));
        System.out.println(list.get(2));
        list.linkToString();
        list.head = list.reverse(list.head);
        System.out.println();
        list.linkToString();
	}
}