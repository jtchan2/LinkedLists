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
		if(head==null){
			head= new Node(item);
			++size;
		}else{
			Node <E>prev= head;
			for(int i=0; i<size;i++){
				prev=prev.next;
			}
			Node<E> node = new Node(item);
			prev.next= node;
			++size;
		}
	}
	public void add(E item, int pos){
		if(pos==0){
			Node<E>node= new Node(item);
			node.next= head;
			head=node;
			++size;
		}else{
			Node<E> prev= head;
			for(int i=0; i<pos-1; i++){
				prev = prev.next;
			}
			Node<E> node= new Node<E>(item);
			node.next=prev.next;
			prev.next=node;
			++size;
		}
	}
	public E get(int pos){
		if(pos<size||pos>=size){
			return null;
		}
		Node<E> curr= head;
		for(int i=0; i<pos;i++){
			curr=curr.next;
		}
		return curr.next;
	}
	public E remove(int pos){
		if(pos==0){
			Node<E> node=head;
			head= head.next;
			--size;
			return node.data;
		}else{
			Node<E> prev=head;
			for(int i=0; i<pos-1;i++){
				prev=prev.next;
			}
			Node<E>node=prev.next;
			prev.next=node.next;
			--size;
			return node.data;
		}
	}

	public Node<E> reverse(Node<E> head){
		Node<E> prev=null;
		Node<E> curr= head;
		Node<E> next= null;
		while(curr!=null){
			next= curr.next;
			curr.next=prev.next;
			prev=curr;
			curr=next;
		}
		head=prev;
		return head;
	}
	public void linkToString(){
		Node<E> node= head;
		while(node!=null){
			System.out.print(node.data+"==> ");
			node=node.next;
		}
		System.out.println();
	}
	public static void main(String [] args){
		LinkedList list1= new LinkedList();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		list1.linkToString();
		list1.add(6,1);
		list1.linkToString();
		list1.get(2);
		System.out.println(node.data);
		list1.remove(2);
		list1.linkToString();
		list1.head=list1.reverse(list1.head);
		list1.linkToString();
	}
}