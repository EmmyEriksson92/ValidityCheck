package ProjectOmegaGradle;

import java.util.HashMap;
import java.util.Map;

/**
 * Program for ValidityCheck results.
 * 
 * @author Emmy
 */

public class ValidityResults {
	private final Data data;
	private boolean result = true;

	private Map<String, Boolean> dataCheck = new HashMap<>();

	public ValidityResults(Data data) {
		this.data = data;
	}

	public void setResult(String checkName, boolean result) {
		this.result = result;
		dataCheck.put(checkName, result);
	}
	
	public boolean getResult() {
		return result;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\nData:  ").append(data.getData()).append("\n");
		builder.append("Result for each test:").append("\n");
		for (Map.Entry<String, Boolean> entry : dataCheck.entrySet()) {
			builder.append(entry.getKey());
			builder.append(": ");
			builder.append(entry.getValue() ? "Passed" : "Failed").append("\n");
		}
		return builder.toString();
	}

}
