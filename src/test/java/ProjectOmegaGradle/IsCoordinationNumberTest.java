package ProjectOmegaGradle;

/**
 *JUnit test for testing if coordination number.
 * @author Emmy
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IsCoordinationNumberTest {

	private static ValidityCheck check;

	@BeforeAll
	public static void setup() {
		check = new IsCoordinationNumber();
	}

	@Test
	void isCoordinationNumber() {
		assertTrue(check.isValid(new Data("19091079+9824")));
	}

	@Test
	void isNotCoordinationNumber() {
		assertFalse(check.isValid(new Data("89912299816")));

	}
	@Test
	void testInvalidValidBirthday() {
		assertFalse(check.isValid(new Data("189930699816")));

	}

	@Test
	void testInvalidCheckSum() {
		assertFalse(check.isValid(new Data("201707772394")));

	}

	@Test
	void testInvalidCharactersCoor() {
		assertFalse(check.isValid(new Data("kkk2222dd22o")));

	}

	@Test
	void testInvalidLengthCoor() {
		assertFalse(check.isValid(new Data("9289748327482748247")));
		assertFalse(check.isValid(new Data("92897483")));

	}

}
