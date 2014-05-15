/**
 * 
 */
package in.anandm.apps.template.domain.model.user;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * @author noobandy
 *
 */
@Embeddable
public class HostAddress implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String ip;

	public HostAddress(String ip) {
		super();
		this.ip = ip;
	}

	public String getIp() {
		return ip;
	}

	/**
	 * 
	 */
	HostAddress() {
		super();
		
	}
	
	
	
}
