/**
 * 
 */
package in.anandm.apps.template.interfaces.web.helper;

import in.anandm.apps.template.interfaces.web.facade.dto.Browser;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anandm
 *
 */
public class DataTableHelper {

	private static final List<Browser> browsers = new ArrayList<Browser>();
	static{
		for(int i = 0; i < 100; i++){
			Browser browser = new Browser();
			browser.setBrowser("browser_"+ i);
			browser.setCssGrade("cssGrade_"+i);
			browser.setEngineVersion("engineVersion_"+i);
			browser.setPlateform("plateform_"+i);
			browser.setRenderingEngine("renderingEngine_"+i);
			browsers.add(browser);
		}
	}

	/**
	 * 
	 */
	public DataTableHelper() {
		super();

	}

	public static List<Browser> getRecords(Integer noOfRecords,Integer start){

		return browsers.subList(start, start+noOfRecords);
	}
}
