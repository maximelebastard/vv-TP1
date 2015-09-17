/**
 * 
 */
package system;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author maxime
 *
 */
public class TestPhonyListStudent {
	/*
	 * Helper method to create lists.
	 */
	private PhonyList<Integer> list(Integer... content) {
		PhonyList<Integer> list = new PhonyList<>();
		for (Integer i : content)
			list.add(i);
		return list;
	}

	/*
	 * Helper method to create a big list [1,2,3,...,10000]
	 */
	private PhonyList<Integer> thousandElementsList() {
		PhonyList<Integer> thousandElementsList = new PhonyList<>();
		for (int i = 1; i <= 10000; i++) {
			thousandElementsList.add(i);
		}
		return thousandElementsList;
	}
	
	/**
	 * Tests the "addAll" method with an regular list
	 * 
	 * @see PhonyList#addAll(int,Collection)
	 * @type Functional
	 * @input index=10 collection=[1,2,3]
	 * @oracle It must return 3 new elements
	 * @passed Yes
	 */
	@Test
	public void addAll_regularList()
	{
		PhonyList<Integer> list = thousandElementsList();
		List<Integer> toAdd = new ArrayList<>();
		toAdd.add(1);
		toAdd.add(2);
		toAdd.add(3);

		
		list.addAll(10, toAdd);
		
		assertEquals(10002, list.indexOf(10000));
	}
	
	/**
	 * Tests the "addAll" method with a negative index
	 * 
	 * @see PhonyList#addAll(int,Collection)
	 * @type Functional
	 * @input index=1 collection=[1,2,3]
	 * @oracle It must return the same list
	 * @passed Yes
	 */
	@Test(expected=IndexOutOfBoundsException.class)
	public void addAll_negIndex()
	{
		PhonyList<Integer> list = thousandElementsList();
		List<Integer> toAdd = new ArrayList<>();
		toAdd.add(1);
		toAdd.add(2);
		toAdd.add(3);
		
		list.addAll(-10, toAdd);
	}
	
	/**
	 * Tests the "addAll" method with a big index
	 * 
	 * @see PhonyList#addAll(int,Collection)
	 * @type Functional
	 * @input index=1 collection=[1,2,3]
	 * @oracle It must return the same list
	 * @passed Yes
	 */
	@Test
	public void addAll_bigIndex()
	{
		PhonyList<Integer> list = thousandElementsList();
		List<Integer> toAdd = new ArrayList<>();
		toAdd.add(98765);
		toAdd.add(98764);
		toAdd.add(98763);
		
		list.addAll(10000, toAdd);
		
		int result = list.indexOf(98765);
		assertEquals(10000, result);
	}
	
	
	/**
	 * Tests the "addAll" method with an empty list insertion
	 * 
	 * @see PhonyList#addAll(int index ,Collection collection)
	 * @type Functional
	 * @input index=1 collection=[]
	 * @oracle It must return the same list
	 * @passed Yes
	 */
	@Test
	public void addAll_emptyList()
	{
		PhonyList<Integer> list = thousandElementsList();
		List<Integer> toAdd = new ArrayList<>();
		
		list.addAll(1, toAdd);
		
		int result = list.indexOf(10000);
		assertEquals(9999, result);
	}
	
	/**
	 * Tests the "contains" method with an existing element
	 * 
	 * @see PhonyList#contains(Object o)
	 * @type Functional
	 * @input o=100
	 * @oracle It must return true
	 * @passed Yes
	 */
	@Test
	public void contains_existing()
	{
		PhonyList<Integer> list = thousandElementsList();
		
		boolean result = list.contains(new Integer(100));
		assertEquals(true, result);
	}
	
	/**
	 * Tests the "contains" method with the first element
	 * 
	 * @see PhonyList#contains(Object o)
	 * @type Functional
	 * @input o=1
	 * @oracle It must return true
	 * @passed Yes
	 */
	@Test
	public void contains_existingFirst()
	{
		PhonyList<Integer> list = thousandElementsList();
		
		boolean result = list.contains(new Integer(1));
		assertEquals(true, result);
	}
	
	/**
	 * Tests the "contains" method with the last element
	 * 
	 * @see PhonyList#contains(Object o)
	 * @type Functional
	 * @input o=10000
	 * @oracle It must return true
	 * @passed Yes
	 */
	@Test
	public void contains_existingLast()
	{
		PhonyList<Integer> list = thousandElementsList();
		
		boolean result = list.contains(new Integer(10000));
		assertEquals(true, result);
	}
	
	/**
	 * Tests the "contains" method with an not existing element
	 * 
	 * @see PhonyList#contains(Object o)
	 * @type Functional
	 * @input o=99999
	 * @oracle It must return false
	 * @passed Yes
	 */
	@Test
	public void contains_notExisting()
	{
		PhonyList<Integer> list = thousandElementsList();
		
		boolean result = list.contains(new Integer(99999));
		assertEquals(false, result);
	}
	
	/**
	 * Tests the "equals" method with the same instance
	 * 
	 * @see PhonyList#equals(Object o)
	 * @type Functional
	 * @oracle It must return true
	 * @passed Yes
	 */
	@Test
	public void equals_sameInstance()
	{
		PhonyList<Integer> list = thousandElementsList();
		PhonyList<Integer> otherList = list;
		
		boolean result = list.equals(otherList);
		assertEquals(true, result);
	}

}
