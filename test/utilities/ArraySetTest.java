/**
 * Test class for ArraySet.java. This class tests methods that didn't use delegation. 
 * 
 * @author Brodee Clontz and Kyler Bailey
 * @date 01/14/24
 */

package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class ArraySetTest
{


	@Test
	void testArraySetCollectionOfE()
	{
		//Creating a collection to test the parameterized constructor
		ArrayList<String> colOfStrings = new ArrayList<String>(Arrays.asList("hello", "world", "tsunami"));

		//Testing the constructor with unique elements
		ArraySet<String> _list = new ArraySet<String>(colOfStrings);
		assertTrue("Doesn't contain hello", _list.contains("hello"));
		assertTrue("Doesn't contain world",_list.contains("world"));
		assertTrue("Doesn't contain tsunami",_list.contains("tsunami"));

		//Clearing the collection and putting new non-unique values in
		colOfStrings = new ArrayList<String>(Arrays.asList("hello", "hello", "hello"));

		//Making a new list with the collection and testing that it only adds one unique element
		ArraySet<String> _newList = new ArraySet<String>(colOfStrings);
		assertEquals("Size is not 1", _newList.size(), 1);
	}

	@Test
	void testAddE()
	{
		//Creating a loop to add 100 of the same element
		ArraySet<String> _list = new ArraySet<String>();
		for (int i = 0; i < 100; i ++) {
			_list.add("hello");
		}
		//Only one element should ever be added since all are the same
		assertEquals("Size is not 1", _list.size(), 1);
	}

	@Test
	void testAddAllCollectionOfQextendsE()
	{
		//Creating and collection to addAll to the list
		ArrayList<String> colOfStrings = new ArrayList<String>(Arrays.asList("hello", "world", "tsunami"));

		//Creating a list with one element from the collection and one not
		ArraySet<String> _list = new ArraySet<String>(Arrays.asList("first", "tsunami"));
		_list.addAll(colOfStrings);

		//Shouldn't add an additional "tsunami" so size should be 4
		assertEquals("Size is not 4", _list.size(), 4);
		assertEquals("Was not 'first'", _list.get(0), "first");
	}

	@Test
	void testRetainAll()
	{
		ArrayList<String> colOfStrings = new ArrayList<String>(Arrays.asList("hello", "world", "tsunami"));

		//Creating a list with one element from the collection and one not
		ArraySet<String> _list = new ArraySet<String>(Arrays.asList("first", "tsunami"));
		_list.retainAll(colOfStrings);

		//Should only retain the 3 elements in colOfStrings
		assertEquals("Size is not 3", _list.size(), 3);
		assertEquals("_list values are wrong", _list.subList(0,3), Arrays.asList("hello", "world", "tsunami"));
		
		//Adding the same element 3 times to the collection
		colOfStrings = new ArrayList<String>(Arrays.asList("hello", "hello", "hello"));
		
		//It should only retain one unique element so size should be 1
		_list.retainAll(colOfStrings);
		assertEquals("Size is not 1", _list.size(), 1);
	}

	@Test
	void testRemoveAll()
	{
		//Creating a collection
		ArrayList<String> colOfStrings = new ArrayList<String>(Arrays.asList("hello", "world"));

		//Creating a list with 3 elements, 2 are in the collection
		ArraySet<String> _list = new ArraySet<String>(Arrays.asList("hello", "world", "tsunami"));

		//Testing to see that the 2 elements from the collection were removed
		_list.removeAll(colOfStrings);
		assertEquals("Removed the wrong thing(s)", _list.get(0), "tsunami");
		assertEquals("Size is not 1", _list.size(), 1);
	}

	@Test
	void testAddAllIntCollectionOfQextendsE()
	{
		//Creating and collection to addAll to the list
		ArrayList<String> colOfStrings = new ArrayList<String>(Arrays.asList("hello", "world", "tsunami"));

		//Creating a list with one element from the collection and one not
		ArraySet<String> _list = new ArraySet<String>(Arrays.asList("first", "tsunami"));
		_list.addAll(1, colOfStrings);

		//Shouldn't add an additional "tsunami" so size should be 4
		assertEquals("Size is not 4", _list.size(), 4);

		//Testing to make sure the elements were inserted in the right place
		assertEquals("Lists are not the same", _list.subList(0, 4), Arrays.asList("first", "hello", 
				"world", "tsunami"));
	}
}
