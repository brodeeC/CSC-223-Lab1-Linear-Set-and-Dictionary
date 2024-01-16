/**
 * This class creates a Set with only unique elements. It implements the List and Set class. This classes utilizes
 * delegation for the majority of its methods, there are 5 methods and a constructor that don't. 
 * 
 * @author Brodee Clontz and Kyler Bailey
 * @date 01/14/24
 */
package utilities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.Spliterator;

public class ArraySet<E> implements List<E>, Set<E>
{
	protected ArrayList<E> _list;

	/**
	 * Basic Constructor with no parameters.
	 */
	public ArraySet()
	{
		_list = new ArrayList<E>();
	}

	/**
	 * This constructor takes a parameter Collection c and creates a list where all the elements are unique.
	 * 
	 * @param c
	 */
	public ArraySet(Collection <? extends E> c) {
		_list = new ArrayList<E>();
		this.addAll(c);
	}

	/**
	 * Returns the size of the list.
	 */
	@Override
	public int size() {return _list.size();}

	/**
	 * Returns true if the list is empty.
	 */
	@Override
	public boolean isEmpty() {return _list.isEmpty();}

	/**
	 * Returns true if o is in the list.
	 */
	@Override
	public boolean contains(Object o) {return _list.contains(o);}

	/**
	 * Returns an iterator over the elements of the list in proper sequence.
	 */
	@Override
	public Iterator<E> iterator() {return _list.iterator();}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence.
	 */
	@Override
	public Object[] toArray() {return _list.toArray();}

	/**
	 * Returns an array containing all of the elements in this list in proper sequence; the runtime
	 * type of the returned array is that of the specified array.
	 */
	@Override
	public <T> T[] toArray(T[] a) {return _list.toArray(a);}

	/**
	 * Adds the element to the end of the list if it's not already in the list.
	 */
	@Override
	public boolean add(E e) {
		if (_list.contains(e)){
			return false;
		}
		return _list.add(e);
	}

	/**
	 * Removes a specified element from the list.
	 */
	@Override
	public boolean remove(Object o) {return _list.remove(o);}

	/**
	 * Removes elements contained in a collection from the list.
	 */
	@Override
	public boolean containsAll(Collection<?> c) {return _list.containsAll(c);}

	/**
	 * Adds all the elements from the collection as long as they aren't in the list already.
	 */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		for (E colElement: c) {
			if (!(_list.contains(colElement))) {
				_list.add(colElement);
			}
		}
		return true;
	}

	/**
	 * Adds all the elements from the collection as long as they aren't in the list already 
	 * at a specified index.
	 */
	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		int count = 0;
		for (E colElement: c) {
			if (!(_list.contains(colElement))) {
				//Index increases based on how many elements have been added.
				_list.add(index + count, colElement);
				count ++;
			}
		}
		return true;
	}

	/**
	 * Removes a collection of elements from a list.
	 */
	@Override
	public boolean removeAll(Collection<?> c) {
		for (Object colElement: c) {
			if (_list.contains(colElement)) {
				_list.remove(colElement);
			}
		}
		return true;
	}

	/**
	 * Utilizes the parameterized constructor to add all unique elements from a collection 
	 * to a temporary list then adds those to this list.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean retainAll(Collection<?> c) {
		_list.clear();
		return this.addAll((Collection<? extends E>) c);
	}

	/**
	 * Clears all elements from the list.
	 */
	@Override
	public void clear() {_list.clear();}

	/**
	 * Retrieves the element at the specified index.
	 */
	@Override
	public E get(int index) {return _list.get(index);}

	/**
	 * Sets the element at an index to a new element and returns the previous element.
	 */
	@Override
	public E set(int index, E element) {
		return (_list.contains(element)) ? (_list.get(index)) : (_list.set(index, element));}


	/**
	 * Adds an element at a specified index.
	 */
	@Override
	public void add(int index, E element) {
		if (!(_list.contains(element))) 
			_list.add(index, element);
	}

	/**
	 * Removes and element at a specified index.
	 */
	@Override
	public E remove(int index) {return _list.remove(index);}

	/**
	 * Returns the index of a specified object.
	 */
	@Override
	public int indexOf(Object o) {return _list.indexOf(o);}

	/**
	 * Returns the last index of a specified object.
	 */
	@Override
	public int lastIndexOf(Object o) {return _list.lastIndexOf(o);}

	/**
	 * Returns a list iterator over the elements in this list.
	 */
	@Override
	public ListIterator<E> listIterator() {return _list.listIterator();}

	/**
	 * Returns a list iterator over the elements in this list, starting at the specified index.
	 */
	@Override
	public ListIterator<E> listIterator(int index) {return _list.listIterator(index);}

	/**
	 * Returns the elements of the list from a specified range.
	 */
	@Override
	public List<E> subList(int fromIndex, int toIndex) {return _list.subList(fromIndex, toIndex);}

	/**
	 * Creates a spliterator over the elements in the set.
	 */
	@Override
	public Spliterator<E> spliterator() {return _list.spliterator();}


}
