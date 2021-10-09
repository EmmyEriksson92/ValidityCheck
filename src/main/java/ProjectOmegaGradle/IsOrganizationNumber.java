package ProjectOmegaGradle;

/**
 * Program for validating organization number.
 * 
 * @author Emmy
 */

public class IsOrganizationNumber implements ValidityCheck {
	public boolean isValid(Data data) {
		String content = data.getData();
		return !ValidateUtils.isNull(content) && ValidateUtils.containsOnlyNumbers(content)
				&& ValidateUtils.checkLength(content) && isCompany(content)
				&& ValidateUtils.checkLuhn(ValidateUtils.parse(content)) && checkLegalForm(content);

	}

	/**
	 * Method to check if first number of data is bigger smaller or equal to 9,
	 * therefore represents a legal form.
	 */
	private boolean checkLegalForm(String data) {
		int form = Integer.parseInt(ValidateUtils.parse(data.substring(0, 1)));

		if (form <= 9) {
			return true;
		}

		return false;
	}

	/**
	 * Method to check if second pair numbers is bigger than or equal to two, therefore a
	 * company.
	 */
	private boolean isCompany(String data) {
		if (Integer.parseInt(ValidateUtils.parse(data).substring(2, 4), 10) >= 20) {
			return true;
		}
		return false;
	}

}
