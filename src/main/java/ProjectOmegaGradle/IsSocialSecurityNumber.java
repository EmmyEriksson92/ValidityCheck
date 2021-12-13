package ProjectOmegaGradle;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Program for validating social security number.
 * 
 * @author Emmy
 */

public class IsSocialSecurityNumber implements ValidityCheck {

	@Override
	public boolean isValid(Data data) {
		String content = data.getData();
		return !ValidateUtils.isNull(content) && ValidateUtils.checkLength(content)
				&& ValidateUtils.containsOnlyNumbers(content) && validBirthday(data, ValidateUtils.parse(content))
				&& ValidateUtils.checkLuhn(ValidateUtils.parse(content)) && isSocialSecurityNumberFormat(content, data);
	}

	/**
	 * Method for validating if age is older than hundred and has the correct format
	 * for SSN. Correct format contains century of (18, 19, 20) or a + sign.
	 */

	public static boolean isSocialSecurityNumberFormat(String socialSecurityNumber, Data data) {
		if (data.getAge() > 100) { // If older then hundred, check if contains + separator or century.
			if (socialSecurityNumber.contains("+") || socialSecurityNumber.substring(0, 2).equals(data.getCentury())) {
				return true;
			}

			return false;

		}

		return true;
	}

	/**
	 * Validate birthday. If age is older then 60 return false
	 */
	private static boolean validBirthday(Data data, String socialSecurityNumber) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyMMdd");
		dateFormat.setLenient(false); // Will fix a faulty date automatically if you have it to true.

		try {
			if (Integer.parseInt(data.getDay()) > 60) {
				return false;
			} else {
				dateFormat.parse(socialSecurityNumber.substring(0, socialSecurityNumber.length() - 4));
			}

		} catch (ParseException e) {
			return false;
		}
		return true;

	}

}
