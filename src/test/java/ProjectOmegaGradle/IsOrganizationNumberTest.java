package ProjectOmegaGradle;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ProjectOmegaGradle.ValidityCheck;
import ProjectOmegaGradle.IsSocialSecurityNumber;
import ProjectOmegaGradle.Data;

/**
 *JUnit test for testing if organization number.
 * @author Emmy
 */

class IsOrganizationNumberTest {
	private static ValidityCheck check;

	@BeforeAll
	public static void setup() {
		check = new IsOrganizationNumber();
	}

	@Test
	void isOrganizationNumber() {
		assertTrue(check.isValid(new Data("556614-3185")));
		assertTrue(check.isValid(new Data("16556601-6399")));
		assertTrue(check.isValid(new Data("262000-1111")));
		assertTrue(check.isValid(new Data("857202-7566")));

	}

	@Test
	void isNotOrganizationNumber() {
		assertFalse(check.isValid(new Data("190910799824")));

	}
	
	@Test
	void invalidIsCompany() {
		assertFalse(check.isValid(new Data("851202-7566")));

	}
	
	@Test
	void testInvalidCharacterOrg() {
		assertFalse(check.isValid(new Data("kk22kk-dd22")));

	}
	
	@Test
	void testInvalidCheckSum() {
		assertFalse(check.isValid(new Data("16370127-2394")));

	}


}
