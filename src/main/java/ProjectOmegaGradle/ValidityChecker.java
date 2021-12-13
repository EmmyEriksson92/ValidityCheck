package ProjectOmegaGradle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Program for adding new Validity checks and saving test results.
 * 
 * @author Emmy
 */

public class ValidityChecker {
	private List<ValidityCheck> checks = new ArrayList<ValidityCheck>();

	public void addCheck(ValidityCheck check) {
		checks.add(check);
	}

	public ValidityResults isValid(Data data) {
		ValidityResults result = new ValidityResults(data);
		for (ValidityCheck check : checks) {
			String name = check.getClass().getSimpleName();
			boolean valid = check.isValid(data);
			result.setResult(name, valid);

		}

		return result;

	}

	public Collection<ValidityResults> isValid(List<Data> data) { //:: <--är en operatör som skiljer klassnamn från metodnamnet. Metodreferens.
		return data.stream().map(this::isValid).collect(Collectors.toList()); //map = ger en ström där alla elementen avbildats med hjälp av parameter i map
	} //collect = a en s.k. kollektor som anger hur data skall samlas ihop.

	public void saveResults(Collection<ValidityResults> data) {
		try {
			File file = new File("testResults.txt");
			FileWriter myWriter = new FileWriter(file);
			myWriter.write(data.toString());
			myWriter.close();
			System.out.println("Successfully wrote to the file: " + file + ":::" + LocalDate.now());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
