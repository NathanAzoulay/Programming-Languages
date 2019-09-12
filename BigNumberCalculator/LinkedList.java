//	Nathan Azoulay

package data_structures;

import java.util.Iterator;

import java.util.NoSuchElementException;


public class LinkedList<E> implements ListI<E> {
	private Node<E> head;
	private int currentSize;
	private Node<E> tail;
	private Iterator<E> iter;
	
	  class Node<E>{
		E data;
		Node<E> next;
		
		public Node(E obj) {
			data = obj;
			next = null;
		}
	} // end Iter
	public LinkedList() {
		head = null;
		currentSize = 0;
		iter = iterator();
	} // end LinkedList
	
	public E getNext() {
		return iter.next();
	} // end getNext
	public boolean hasNext() {
		return iter.hasNext();
	} // end hasNext
	public void resetIter() {
		iter = iterator();
	} // end resetIter
	@Override
	public void addFirst(E obj) {
		Node<E> node = new Node<E>(obj);
		node.next = head;
		head = node;
		if(currentSize == 0)
			tail = head;
		currentSize++;
		
	} // end addFirst

	@Override
	public void addLast(E obj) {
		if(head == null)
			addFirst(obj);
		else {
			Node<E> newNode = new Node<E>(obj);
			Node<E> tmp = head;
			while(tmp.next != null)
				tmp = tmp.next;
			tmp.next = newNode;
			tail = newNode;
			currentSize++;
		}
		
	} // end addLast

	@Override
	public E removeFirst() {
		if(head == null)
			return null;
		E tmp = head.data;
		if(head == tail)
				head = tail = null;
		else
			head = head.next;
		currentSize--;
		return tmp;
	} // end removeFirst

	@Override
	public E removeLast() {
		if(head == null)
			return null;
		if(head == tail)
			return removeFirst();
		Node<E> current = head;
		Node<E> previous = null;
		while(current.next != null) {
			previous = current;
			current = current.next;
		}
		previous.next = null;
		tail = previous;
		currentSize--;
		return current.data;
		
	} // end removeLast

	@Override
	public E peekFirst() {
		if(head == null)
			return null;
		return head.data;
	} // end peekFirst

	@Override
	public E peekLast() {
		if(tail == null)
			return null;
		return tail.data;
	} // end peekLast

	@Override
	public void makeEmpty() {
		head = tail = null;
		currentSize = 0;
		
	} // end makeEmpty

	@Override
	public boolean isEmpty() {
		return (currentSize == 0);
	} // end isEmpty

	@Override
	public boolean isFull() {
		return false;
	} // end isFull

	@Override
	public int size() {
		return currentSize;
	} // end size

	@Override
	public boolean contains(E obj) {
		Node<E> tmp = head;
		while(tmp != null) {
			if(((Comparable<E>)tmp.data).compareTo(obj)==0)
				return true;
			tmp = tmp.next;
		}
		return false;
	} // end contains

	@Override
	public Iterator<E> iterator() {
		
		return new IteratorHelper();
	} // end iterator
	
	class IteratorHelper implements Iterator<E>{
		
		
		Node<E> index;
		public IteratorHelper() {
			index = head;	
		}
		public boolean hasNext() {
			return index != null;
		}
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException();
			E tmp = index.data;
			index = index.next;
			return tmp;
}}} // end class LinkedList

