public class lab5{
	private class Node<T>{
		T data;
		Node<T> next;
		public Node(T value){
			data = value;
			next=null;
		}
	}
	public E(E node){
		head=null;
		size=0;

	}
	public void add(ListNode node){
		if(head ==null){
			head = new Node(node);
			size++;
		}
		Node prev= head;
		for(int i=0; i<size; i++){
			prev=prev.next;
		}
		Node item= new Node(node);
		prev.next= item;
		size++;

	}
	public void add(ListNode node, int position){
		if(pos ==0){
			Node item= new Node(node);
			item.next=head;
			head=item;
			++size;
		}else{
			Node prev= head;
			for(int i=0; i< pos-1; i++){
				prev=prev.next;
			}
			Node item= new Node(node);
			item.next=prev.next;
			prev.next=item;
			size++;

		}

	}
	public ListNode	get(int position){
		if(position>size||position<0){
			//throw exception
		}
		Node curr= head;
		for(int i=0; i<position; i++){
			curr=curr.next;
		}
		return curr.data;
	}
	public ListNode	remove(int position){
		if(position<0||position>0){
			//throw and exception
		}
		if(position==0){
			Node node= head;
			head=head.next;
			size--;
			return node.data;
		}else{
			Node prev=head;
			for(int i=0; i<pos-1; i++){
				prev= prev.next;
			}
			Node node= prev.next;
			prev.next=node.next;
			size--;
			return node.data;

		}

	}
	public ListNode	 reverse(ListNode head){

	}
}