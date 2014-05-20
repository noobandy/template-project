/**
 * 
 */
package in.anandm.apps.template.domain.shared.exception;

/**
 * @author anandm
 *
 */
public interface IValueObject<T> {

	boolean sameValueAs(T otherValueObject);
}
