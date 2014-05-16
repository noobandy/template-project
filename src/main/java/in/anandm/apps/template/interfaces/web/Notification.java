/**
 * 
 */
package in.anandm.apps.template.interfaces.web;

import java.io.Serializable;

/**
 * @author anandm
 *
 */
public class Notification implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String type;
	private String style;
	private String position;
	private String message;
	
	
	/**
	 * @param type
	 * @param style
	 * @param position
	 * @param message
	 */
	public Notification(String type, String style, String position, String message) {
		super();
		this.type = type;
		this.style = style;
		this.position = position;
		this.message = message;
	}
	/**
	 * 
	 */
	public Notification() {
		super();

	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}



}
