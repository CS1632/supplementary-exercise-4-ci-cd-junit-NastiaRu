package edu.pitt.cs;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.mockito.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RentACatTest {

	/**
	 * The test fixture for this JUnit test. Test fixture: a fixed state of a set of
	 * objects used as a baseline for running tests. The test fixture is initialized
	 * using the @Before setUp method which runs before every test case. The test
	 * fixture is removed using the @After tearDown method which runs after each
	 * test case.
	 */

	RentACat r; // Object to test
	Cat c1; // First cat object
	Cat c2; // Second cat object
	Cat c3; // Third cat object

	@Before
	public void setUp() throws Exception {
		// Turn on automatic bug injection in the Cat class, to emulate a buggy Cat.
		// Your unit tests should work regardless of these bugs.
		Cat.bugInjectionOn = true;

		// INITIALIZE THE TEST FIXTURE
		// 1. Create a new RentACat object and assign to r
		r = RentACat.createInstance();

		// 2. Create an unrented Cat with ID 1 and name "Jennyanydots", assign to c1
		// todo: Fill in
		c1 = Mockito.mock(Cat.class);
		Mockito.when(c1.getId()).thenReturn(1);
		Mockito.when(c1.getName()).thenReturn("Jennyanydots");
		Mockito.when(c1.toString()).thenReturn("ID 1. Jennyanydots");

		// 3. Create an unrented Cat with ID 2 and name "Old Deuteronomy", assign to c2
		// todo: Fill in
		c2 = Mockito.mock(Cat.class);
		Mockito.when(c2.getId()).thenReturn(2);
		Mockito.when(c2.getName()).thenReturn("Old Deuteronomy");
		Mockito.when(c2.toString()).thenReturn("ID 2. Old Deuteronomy");

		// 4. Create an unrented Cat with ID 3 and name "Mistoffelees", assign to c3
		// todo: Fill in
		c3 = Mockito.mock(Cat.class);
		Mockito.when(c3.getId()).thenReturn(3);
		Mockito.when(c3.getName()).thenReturn("Mistoffelees");
		Mockito.when(c3.toString()).thenReturn("ID 3. Mistoffelees");
	}

	@After
	public void tearDown() throws Exception {
		// Not necessary strictly speaking since the references will be overwritten in
		// the next setUp call anyway and Java has automatic garbage collection.
		r = null;
		c1 = null;
		c2 = null;
		c3 = null;
	}

	/**
	 * Test case for Cat getCat(int id).
	 * 
	 * <pre>
	 * Preconditions: r has no cats.
	 * Execution steps: Call getCat(2).
	 * Postconditions: Return value is null.
	 * </pre>
	 */

	@Test
	public void testGetCatNullNumCats0() {
		// todo
		Cat cat = r.getCat(2);
		assertNull("Returned cat with id 2 is not null", cat);
	}

	/**
	 * Test case for Cat getCat(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 * Execution steps: Call getCat(2).
	 * Postconditions: Return value is not null.
	 *                 Returned cat has an ID of 2.
	 * </pre>
	 */

	@Test
	public void testGetCatNumCats3() {
		// todo
		r.addCat(c1);
		r.addCat(c2);
		r.addCat(c3);
		Cat cat = r.getCat(2);
		assertNotNull("Returned cat is null", cat);
		assertEquals("Returned cat does not have id 2", 2, cat.getId());
	}

	/**
	 * Test case for boolean catAvailable(int id).
	 * 
	 * <pre>
	 * Preconditions: r has no cats.
	 * Execution steps: Call catAvailable(2).
	 * Postconditions: Return value is false.
	 * </pre>
	 */

	@Test
	public void testCatAvailableFalseNumCats0() {
		// todo
		boolean available = r.catAvailable(2);
		assertFalse("No cats but catAvailable(2) returns true", available);
	}

	/**
	 * Test case for boolean catAvailable(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 *                c3 is rented.
	 *                c1 and c2 are not rented.
	 * Execution steps: Call catAvailable(2).
	 * Postconditions: Return value is true.
	 * </pre>
	 */

	@Test
	public void testCatAvailableTrueNumCats3() {
		// todo
		r.addCat(c1);
		r.addCat(c2);
		r.addCat(c3);
		// r.rentCat(3);
		Mockito.when(c3.getRented()).thenReturn(true);
		boolean available = r.catAvailable(2);
		assertTrue("Cat 2 is not rented but catAvailable(2) returns false", available);
	}

	/**
	 * Test case for boolean catAvailable(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 *                c2 is rented.
	 *                c1 and c3 are not rented.
	 * Execution steps: Call catAvailable(2).
	 * Postconditions: Return value is false.
	 * </pre>
	 */

	@Test
	public void testCatAvailableFalseNumCats3() {
		// todo
		r.addCat(c1);
		r.addCat(c2);
		r.addCat(c3);
		// r.rentCat(2);
		Mockito.when(c2.getRented()).thenReturn(true);
		boolean available = r.catAvailable(2);
		assertFalse("Cat 2 is rented, but catAvailable(2) returns true", available);
	}

	/**
	 * Test case for boolean catExists(int id).
	 * 
	 * <pre>
	 * Preconditions: r has no cats.
	 * Execution steps: Call catExists(2).
	 * Postconditions: Return value is false.
	 * </pre>
	 */

	@Test
	public void testCatExistsFalseNumCats0() {
		// todo
		boolean exists = r.catExists(2);
		assertFalse("No cats, but catExists(2) returns true", exists);
	}

	/**
	 * Test case for boolean catExists(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 * Execution steps: Call catExists(2).
	 * Postconditions: Return value is true.
	 * </pre>
	 */

	@Test
	public void testCatExistsTrueNumCats3() {
		// todo
		r.addCat(c1);
		r.addCat(c2);
		r.addCat(c3);
		boolean exists = r.catExists(2);
		assertTrue("Cat 2 is in RentACat, but catExists(2) returns false", exists);
	}

	/**
	 * Test case for String listCats().
	 * 
	 * <pre>
	 * Preconditions: r has no cats.
	 * Execution steps: Call listCats().
	 * Postconditions: Return value is "".
	 * </pre>
	 */

	@Test
	public void testListCatsNumCats0() {
		// todo
		assertEquals("No cats, but listCats() returns non-empty string", "", r.listCats());
	}

	/**
	 * Test case for String listCats().
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 * Execution steps: Call listCats().
	 * Postconditions: Return value is "ID 1. Jennyanydots\nID 2. Old
	 *                 Deuteronomy\nID 3. Mistoffelees\n".
	 * </pre>
	 */

	@Test
	public void testListCatsNumCats3() {
		// todo
		r.addCat(c1);
		r.addCat(c2);
		r.addCat(c3);
		String list = r.listCats();
		String exp = "ID 1. Jennyanydots\nID 2. Old Deuteronomy\nID 3. Mistoffelees\n";
		System.out.println("thislist: " + list);
		assertEquals("The three cats in the RentACat are not listed correctly", exp, list);
	}

	/**
	 * Test case for boolean rentCat(int id).
	 * 
	 * <pre>
	 * Preconditions: r has no cats.
	 * Execution steps: Call rentCat(2).
	 * Postconditions: Return value is false.
	 * </pre>
	 */

	@Test
	public void testRentCatFailureNumCats0() {
		// todo
		boolean rent2 = r.rentCat(2);
		assertFalse("No cats, but rentCat(2) returns true", rent2);
	}

	/**
	 * Test case for boolean rentCat(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 *                c2 is rented.
	 * Execution steps: Call rentCat(2).
	 * Postconditions: Return value is false.
	 *                 c1.rentCat(), c2.rentCat(), c3.rentCat() are never called.
	 * </pre>
	 * 
	 * Hint: See sample_code/mockito_example/NoogieTest.java in the course
	 * repository for an example of behavior verification. Refer to the
	 * testBadgerPlayCalled method.
	 */

	@Test
	public void testRentCatFailureNumCats3() {
		// todo
		r.addCat(c1);
		r.addCat(c2);
		r.addCat(c3);
		// r.rentCat(2);
		Mockito.when(c2.getRented()).thenReturn(true);
		boolean rent2 = r.rentCat(2);
		assertFalse("Cat 2 is rented already, but rentCat(2) returns true", rent2);
		Mockito.verify(c1, Mockito.times(0)).returnCat();
		Mockito.verify(c2, Mockito.times(0)).returnCat();
		Mockito.verify(c3, Mockito.times(0)).returnCat();
	}

	/**
	 * Test case for boolean returnCat(int id).
	 * 
	 * <pre>
	 * Preconditions: r has no cats.
	 * Execution steps: Call returnCat(2).
	 * Postconditions: Return value is false.
	 * </pre>
	 */

	@Test
	public void testReturnCatFailureNumCats0() {
		// todo
		boolean returned = r.returnCat(2);
		assertFalse("No cats, but returnCat(2) returns true", returned);
	}

	/**
	 * Test case for boolean returnCat(int id).
	 * 
	 * <pre>
	 * Preconditions: c1, c2, and c3 are added to r using addCat(Cat c).
	 *                c2 is rented.
	 * Execution steps: Call returnCat(2).
	 * Postconditions: Return value is true.
	 *                 c2.returnCat() is called exactly once.
	 *                 c1.returnCat() and c3.returnCat are never called.
	 * </pre>
	 * 
	 * Hint: See sample_code/mockito_example/NoogieTest.java in the course
	 * repository for an example of behavior verification. Refer to the
	 * testBadgerPlayCalled method.
	 */

	@Test
	public void testReturnCatNumCats3() {
		// todo
		r.addCat(c1);
		r.addCat(c2);
		r.addCat(c3);
		// r.rentCat(2);
		Mockito.when(c2.getRented()).thenReturn(true);
		boolean returned = r.returnCat(2);
		assertTrue("Cat 2 is rented already, but returnCat(2) returns false", returned);
		Mockito.verify(c2, Mockito.times(1)).returnCat();
		Mockito.verify(c1, Mockito.times(0)).returnCat();
		Mockito.verify(c3, Mockito.times(0)).returnCat();
	}
}
