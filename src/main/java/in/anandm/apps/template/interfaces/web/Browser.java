/**
 * 
 */
package in.anandm.apps.template.interfaces.web;

import java.io.Serializable;

/**
 * @author anandm
 *
 */
public class Browser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String renderingEngine;
	private String browser;
	private String plateform;
	private String engineVersion;
	private String cssGrade;
	/**
	 * 
	 */
	public Browser() {
		super();
		
	}
	public String getRenderingEngine() {
		return renderingEngine;
	}
	public void setRenderingEngine(String renderingEngine) {
		this.renderingEngine = renderingEngine;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getPlateform() {
		return plateform;
	}
	public void setPlateform(String plateform) {
		this.plateform = plateform;
	}
	public String getEngineVersion() {
		return engineVersion;
	}
	public void setEngineVersion(String engineVersion) {
		this.engineVersion = engineVersion;
	}
	public String getCssGrade() {
		return cssGrade;
	}
	public void setCssGrade(String cssGrade) {
		this.cssGrade = cssGrade;
	}
	
}
