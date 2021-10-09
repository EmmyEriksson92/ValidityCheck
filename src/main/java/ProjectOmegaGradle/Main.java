package ProjectOmegaGradle;

import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ProjectOmegaGradle.IsSocialSecurityNumber;
import ProjectOmegaGradle.Data;
import ProjectOmegaGradle.ValidityChecker;

/**
 * Main program that creates instances of type Data and tests these property
 * values with ValidityCheck. Test result is saved to text-file and logged.
 * 
 * @author Emmy
 */

public class Main {
	private final static Logger LOGGER = Logger.getLogger(Main.class.getName());

	public static void main(String[] args) {
		ValidityChecker checker = new ValidityChecker();
		checker.addCheck(new IsSocialSecurityNumber());
		checker.addCheck(new IsOrganizationNumber());
		checker.addCheck(new IsCoordinationNumber());
		checker.addCheck(new NotNull());

		List<Data> data = new ArrayList<Data>();

		// Valid social security number
		data.add((new Data("189912299816")));
		data.add((new Data("189102279800")));
		data.add((new Data("194510168885")));
		data.add((new Data("900118+9811")));

		// Valid organization number
		data.add((new Data("556614-3185")));
		data.add((new Data("16556601-6399")));
		data.add((new Data("262000-1111")));

		// Valid coordination number
		data.add((new Data("190910799824")));

		// Invalid organization number
		data.add((new Data("190910799824")));

		// Invalid SSN, organization number & coordination number.
		data.add((new Data("201701272394")));

		// Invalid coordination number, organization number & SSN.
		data.add((new Data("190910199824")));

		// Fails all tests as it is null.
		data.add((new Data(null)));

		Collection<ValidityResults> result = checker.isValid(data);

		// Saves all test results in a text-file.
		checker.saveResults(result);

		// Logs all test results that has failed.
		List<ValidityResults> failedTests = result.stream().filter(r -> r.getResult() == false)
				.collect(Collectors.toList());

		LOGGER.info("Failed on test/tests: " + failedTests.toString());

	}
}
