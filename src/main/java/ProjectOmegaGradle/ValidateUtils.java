package ProjectOmegaGradle;

public class ValidateUtils {

	public static boolean containsOnlyNumbers(String data) {
		try {
			Long.parseLong(parse(data));
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean isNull(String data) {
		if (data == null) {
			return true;
		}
		return false;
	}

	public static String parse(String data) {
		if (data != null && data.trim() != "") {
			if (data.length() >= 12) {
				data = data.substring(2);
			}

			if (data.contains("-")) {
				data = data.replace("-", "");
			}

			if (data.contains("+")) {
				data = data.replace("+", "");
			}
		}
		return data;
	}
	
	
	
	
	public static boolean checkLength(String data) {
		if (parse(data).length() != 10) { // Check length
			return false;
		}
		return true;
	}

	public static boolean checkLuhn(String data) {
		String parsed = parse(data);
		int res = 0;
		for (int i = 0; i < parsed.length() - 1; i++) {
			int num = Character.getNumericValue(parsed.charAt(i));
			int product = num * (2 - i % 2); 
			res += product / 10 + product % 10;
		}
		res = (10 - (res % 10)) % 10;

		return res == Character.getNumericValue(parsed.charAt(parsed.length() - 1)); // Test checksum against the
																						// control number.

	}
}
