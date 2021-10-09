package ProjectOmegaGradle;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *JUnit test for testing if social security number.
 * @author Emmy
 */

class IsSocialSecurityNumberTest {

	private static ValidityCheck check;

	@BeforeAll
	public static void setup() {
		check = new IsSocialSecurityNumber();
	}

	@Test
	void isSocialSecurityNumber() {
		assertTrue(check.isValid(new Data("141206-2380")));
		assertTrue(check.isValid(new Data("201701102384")));
		assertTrue(check.isValid(new Data("900118+9811")));
		assertTrue(check.isValid(new Data("4607137454")));
		assertTrue(check.isValid(new Data("20080903-2386")));
		assertTrue(check.isValid(new Data("7101169295")));
		assertTrue(check.isValid(new Data("198107249289")));
		assertTrue(check.isValid(new Data("19021214-9819")));
		assertTrue(check.isValid(new Data("190910199827")));
		assertTrue(check.isValid(new Data("191006089807")));
		assertTrue(check.isValid(new Data("192109099180")));
		assertTrue(check.isValid(new Data("194510168885")));
		assertTrue(check.isValid(new Data("189102279800")));
		assertTrue(check.isValid(new Data("189912299816")));

	}

	@Test
	void isNotSocialSecurityNumber() {
		assertFalse(check.isValid(new Data("201701272394")));
		assertFalse(check.isValid(new Data("190302299813")));
		assertFalse(check.isValid(new Data("189912899816")));

	}

	@Test
	void testInvalidScnBirthday() {
		assertFalse(check.isValid(new Data("189930299816")));
		assertFalse(check.isValid(new Data("200023223899")));
	}
	
	@Test
	void testInvalidOlderThenHundred() {
		assertFalse(check.isValid(new Data("19920922+8920")));

	}
	
	@Test
	void testValidOlderThenHundred() {
		assertTrue(check.isValid(new Data("900118+9811")));

	}

	@Test
	void testInvalidCheckSum() {
		assertFalse(check.isValid(new Data("201701272394")));

	}

	@Test
	void testInvalidCharactersSsn() {
		assertFalse(check.isValid(new Data("kkk2222dd22o")));

	}

	@Test
	void testInvalidLengthSsn() {
		assertFalse(check.isValid(new Data("9289748327482748247")));
		assertFalse(check.isValid(new Data("92897483")));

	}

}
