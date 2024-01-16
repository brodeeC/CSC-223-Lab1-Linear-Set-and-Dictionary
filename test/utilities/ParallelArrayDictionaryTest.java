/**
 * Test class for ParallelArrayDictionary.java. This class tests the dictionary's function.
 * 
 * @author Brodee Clontz and Kyler Bailey
 * @date 01/14/24
 */

package utilities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
//Testing Github
class ParallelArrayDictionaryTest
{
	/**
	 * Tests the constructor and a few other methods to make sure it creates the dictionary how it should.
	 */
	@Test
	void testParallelArrayDictionary()
	{
		ParallelArrayDictionary<Integer, String> _dict = new ParallelArrayDictionary<Integer, String>();
		assertEquals(_dict.size(), 0);
		assertTrue(_dict.isEmpty());
		
		_dict.put(1, "hello");
		_dict.put(2, "world");
		_dict.put(3, "tsunami");
		_dict.put(4, "last");
		
		assertEquals(_dict.size(), 4);
		assertTrue(_dict.containsKey(1));
		assertTrue(_dict.containsValue("tsunami"));
	}

	/**
	 * Tests the get method by putting 4 items into the dictionary and then getting each of them.
	 */
	@Test
	void testGet()
	{
		ParallelArrayDictionary<Integer, String> _dict = new ParallelArrayDictionary<Integer, String>();
		_dict.put(1, "hello");
		_dict.put(2, "world");
		_dict.put(3, "tsunami");
		_dict.put(4, "last");
		
		assertEquals(_dict.get(1), "hello");
		assertEquals(_dict.get(2), "world");
		assertEquals(_dict.get(3), "tsunami");
		assertEquals(_dict.get(4), "last");
	}

	/**
	 * Tests put by putting a new value in an existing key and ensuring it returns the new value and isn't 
	 * holding the new value somewhere else.
	 */
	@Test
	void testPut()
	{
		ParallelArrayDictionary<Integer, String> _dict = new ParallelArrayDictionary<Integer, String>();
		_dict.put(1, "hello");
		_dict.put(2, "world");
		_dict.put(3, "tsunami");
		_dict.put(4, "last");
		assertEquals(_dict.put(4, "first"), "first");
		assertEquals(_dict.get(4), "first");
		assertEquals(_dict.size(), 4);
	}

	/**
	 * Tests remove by adding 4 things and removing them both and then confirming that the dictionary
	 * no longer contains those keys or values.
	 */
	@Test
	void testRemove()
	{
		
		ParallelArrayDictionary<Integer, String> _dict = new ParallelArrayDictionary<Integer, String>();
		_dict.put(1, "hello");
		_dict.put(2, "world");
		_dict.put(3, "tsunami");
		_dict.put(4, "last");
		assertEquals(_dict.remove(4), "last");
		assertEquals(_dict.size(), 3);
		
		assertEquals(_dict.remove(2), "world");
		assertEquals(_dict.size(), 2);
		
		assertFalse(_dict.containsKey(4)&&_dict.containsKey(2));
		assertFalse(_dict.containsValue("last")&&_dict.containsValue("world"));
	}

	/**
	 * Tests putAll by putting 4 elements into one dictionary and then put all of those items into
	 * a different dictionary then checking that their entry sets are the same. Then tests that it won't
	 * replace a key and it's value.
	 */
	@Test
	void testPutAll()
	{
		ParallelArrayDictionary<Integer, String> _dict = new ParallelArrayDictionary<Integer, String>();
		_dict.put(1, "hello");
		_dict.put(2, "world");
		_dict.put(3, "tsunami");
		_dict.put(4, "last");
		
		
		ParallelArrayDictionary<Integer, String> _newDict = new ParallelArrayDictionary<Integer, String>();
		_newDict.putAll(_dict);
		assertEquals(_newDict.values(), Arrays.asList("hello", "world", "tsunami", "last"));
		
		
		_newDict = new ParallelArrayDictionary<Integer, String>();
		_newDict.put(1, "goodbye");
		_newDict.putAll(_dict);
		assertEquals(_newDict.get(1), _dict.get(1));
		assertEquals(_newDict.size(), 4);
		
	}

	/**
	 * Tests clear by putting 4 things into the dictionary, clearing them, and then making sure size is 0.
	 */
	@Test
	void testClear()
	{
		
		ParallelArrayDictionary<Integer, String> _dict = new ParallelArrayDictionary<Integer, String>();
		_dict.put(1, "hello");
		_dict.put(2, "world");
		_dict.put(3, "tsunami");
		_dict.put(4, "last");
		_dict.clear();
		assertEquals(_dict.size(), 0);
	}
}
