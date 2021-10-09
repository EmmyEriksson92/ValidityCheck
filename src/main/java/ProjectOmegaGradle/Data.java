package ProjectOmegaGradle;

import java.time.LocalDate;

/**
 * Program which contains the data class, which is used for validation.
 * 
 * @author Emmy
 */
public class Data {
	private String data;
	private String year, fullYear, month, day, numbers, controllNb, century, decade;

	public Data(String data) {
		this.data = data;
		if (data != null && data.trim() != "" && ValidateUtils.parse(data).length() == 10
				&& ValidateUtils.containsOnlyNumbers(data)) {
			if (data.length() >= 12) {
				decade = data.substring(2, 4);
				century = data.substring(0, 2);
			} else {
				decade = data.substring(0, 2);
				int born = LocalDate.now().getYear() - Integer.parseInt(decade);
				if (data.contains("+")) {
					born -= 100;
				}

				century = Integer.toString(born).substring(0, 2);
			}
			this.year = decade;
			this.fullYear = century + decade;
			this.month = ValidateUtils.parse(data).substring(2, 4);
			this.day = ValidateUtils.parse(data).substring(4, 6);
			this.numbers = ValidateUtils.parse(data).substring(6, 9);
			this.controllNb = ValidateUtils.parse(data).substring(9, 10);

		}

	}

	/**
	 * Getters and setters for SSN.
	 */

	public String getCentury() {
		return century;
	}

	public String getFullYear() {
		return fullYear;
	}

	public String getYear() {
		return year;
	}

	public String getDay() {
		return day;
	}

	public String getMonth() {
		return month;
	}

	public String getNumbers() {
		return numbers;
	}

	public String getControllNb() {
		return controllNb;
	}

	public int getAge() {
		return (LocalDate.of(Integer.parseInt(getFullYear()), Integer.parseInt(getMonth()),
				(Integer.parseInt(getDay()) > 60 ? Integer.parseInt(getDay()) - 60 : Integer.parseInt(getDay())))
				.until(LocalDate.now())).getYears();
	}

	/**
	 * Getter for getting all data.
	 */

	public String getData() {
		return data;
	}

}
