/**
 * 
 */
package in.anandm.apps.template.interfaces.web.validator;

import java.util.HashSet;
import java.util.Set;

import org.springframework.validation.Validator;

/**
 * @author anandm
 *
 */
public abstract class AbstractValidator implements Validator {

	protected Set<String> skipProperties = new HashSet<String>();

	/**
	 * 
	 */
	public AbstractValidator() {
		super();

	}

	public Set<String> getSkipProperties() {
		return skipProperties;
	}

	public void setSkipProperties(Set<String> skipProperties) {
		this.skipProperties = skipProperties;
	}

	public void addSkipProperty(String property){
		this.skipProperties.add(property);
	}

	public void removeSkipProperty(String property){
		this.skipProperties.remove(property);
	}

	public boolean validationRequired(String property){
		return !(skipProperties.contains(property));
	}
}
