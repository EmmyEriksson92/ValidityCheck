package ProjectOmegaGradle;

/**
 * Program for validating coordination number.
 * @author Emmy
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class IsCoordinationNumber implements ValidityCheck {
	public boolean isValid(Data data) {
		String content = data.getData();
		return !ValidateUtils.isNull(content) && ValidateUtils.checkLength(content)
				&& ValidateUtils.containsOnlyNumbers(content) && isCoordinationNumber(data)
				&& validBirthday(data, ValidateUtils.parse(content))
				&& ValidateUtils.checkLuhn(ValidateUtils.parse(content))
				&& IsSocialSecurityNumber.isSocialSecurityNumberFormat(content, data);
	}
	
	/**
	 * Method checks if day is bigger than 60,
	 * therefore a coordination number.
	 */

	private boolean isCoordinationNumber(Data data) {
		if (Integer.parseInt(data.getDay()) < 60) {
			return false;
		}
		return true;
	}

	/**
	 * Validate birthday.
	 */
	private boolean validBirthday(Data data, String socialSecurityNumber) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		dateFormat.setLenient(false);

		try {
			int newDay = Integer.parseInt(data.getDay()) - 60;
			dateFormat.parse(data.getFullYear() + newDay);

		} catch (ParseException e) {
			return false;
		}

		return true;

	}
}
