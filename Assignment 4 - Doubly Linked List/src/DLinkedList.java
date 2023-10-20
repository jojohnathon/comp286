//johnathon zheng
import java.util.AbstractList;

public class DLinkedList<E> extends AbstractList<E>{

	private DNode<E> head;
	private DNode<E> tail;
	private int size;

	private boolean isValidIndex(int index) {
		return index >= 0 && index < size;
	}

	private DNode<E> getNode(int index) {
		if (!isValidIndex(index)) {
			throw new IndexOutOfBoundsException();
		}

		DNode<E> current = head;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	public DLinkedList(){
		head = new DNode<E>();
		tail = head;
		size = 0;
	}

	/* appends element to end of the list */
	public boolean add(E e){
		DNode<E> newNode = new DNode<>(e);
		if (size == 0) { //special case if the list is empty
			head = newNode;
			size++;
			return true;
		}

		DNode<E> current = head;
		while(current.next != null) { //loop through list until the end
			current = current.next;
		}
		current.next = newNode; //add new node
		newNode.prev = current; //point tail pointer to new node 
		size++;
		return true;
	}

	/* insert element at the given index 
	if the index is out of bounds throw an IndexOutOfBoundsException */
	public void add(int index, E e){
		if (!isValidIndex(index)) {
			throw new IndexOutOfBoundsException("index: " + index + " is greater than list size: " + size);
		}

		if (index == 0) {
			DNode<E> newNode = new DNode<E>(e, null, head);
			head.prev = newNode;
			head = newNode;
			size++;
		} else if (index == (size - 1)) {
			add(e);
		} else {
			//find previous and next node to insert between
			DNode<E> prevNode = getNode(index - 1);
			DNode<E> nextNode = getNode(index);
			//create new node to insert and set pointers
			DNode<E> newNode = new DNode<E>(e, nextNode.prev, prevNode.next);
			//update old pointers 
			prevNode.next = newNode;
			nextNode.prev = newNode;
			size++;
		}
	}

	public void clear(){
		head.next = null;
		tail = head;
		size = 0;
	}

	/* get the data from the node at the given index 
		if the index does not exist throw an IndexOutOfBoundsException */
	public E get(int index){
		return getNode(index).data;
	}

	/* remove the node at the given index from the list and return its data 
		if the index does not exist throw an IndexOutOfBoundsException */
	public E remove(int index){
		if (!isValidIndex(index)) throw new IndexOutOfBoundsException();
		E oldData; //store data about to be deleted
		if (index == 0) { //removing the head node
			oldData = head.data;
			head = head.next;
			size--;
			return oldData;
		} else if (index == (size - 1)) {
			DNode<E> prev = getNode(index - 1);
			oldData = prev.data;
			prev.next = null;
			tail = prev;
			size--;
			return oldData;

		} else {
			tail = getNode(index - 1);
			oldData = tail.next.data; 
			tail.next =	tail.next.next; //skip over selected node
			size--;
			return oldData;
		}

	}
	

	/* replace the contents at the given index with the data given
		return the data that was previously at that index 
		if the index does not exist throw an IndexOutOfBoundsException */
	public E set(int index, E element){
		E oldData = getNode(index).data;
		getNode(index).data = element;
		return oldData;
	}

	public int size(){
		return size;
	}

	public String toString(){
		//TODO test functionality
		String list = "{";
		DNode<E> current = head;
		int i;
		for (i = 0; i < size - 1; i++) {
			list += (current.data.toString()) + ", ";
			current = current.next;
		}
		
		if (i < size) {
			list += current.data.toString();
		}
		return list + "}";
	}

	// internal class for single linking nodes
	class DNode<E> {
		E data;
		DNode<E> next;
		DNode<E> prev;

		public DNode(){
			this(null);
		}

		public DNode(E data){
			this.data = data;
			next = null;
			prev = null;
		}

		public DNode(E data, DNode<E> prev, DNode<E> next){
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
	
}