/**
 * 
 */
package in.anandm.apps.template.domain.shared.exception;

/**
 * @author anandm
 *
 */
public interface IEntity<T> {

	boolean sameIdentityAs(T otherEntity);
}
