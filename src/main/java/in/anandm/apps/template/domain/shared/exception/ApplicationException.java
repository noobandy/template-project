/**
 * 
 */
package in.anandm.apps.template.domain.shared.exception;

/**
 * @author anandm
 *
 */
public class ApplicationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public ApplicationException() {
		super();

	}

	/**
	 * @param message
	 * @param cause
	 */
	public ApplicationException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * @param message
	 */
	public ApplicationException(String message) {
		super(message);

	}

	/**
	 * @param cause
	 */
	public ApplicationException(Throwable cause) {
		super(cause);

	}



}
