package ProjectOmegaGradle;

/**
 *Program for testing if data is null.
 * @author Emmy
 */

public class NotNull implements ValidityCheck {
	@Override
	public boolean isValid(Data data) {
		return data != null && data.getData() != null;
	}
	
}
