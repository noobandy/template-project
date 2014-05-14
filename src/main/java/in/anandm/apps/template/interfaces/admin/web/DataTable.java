/**
 * 
 */
package in.anandm.apps.template.interfaces.admin.web;

import java.io.Serializable;
import java.util.List;

/**
 * @author anandm
 *
 */
public class DataTable<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer sEcho;
	private Integer iTotalRecords;
	private Integer iTotalDisplayRecords;
	private List<T>	aaData;
	/**
	 * @param sEcho
	 * @param iTotalRecords
	 * @param iTotalDisplayRecords
	 * @param aaData
	 */
	public DataTable(Integer sEcho, Integer iTotalRecords,
			Integer iTotalDisplayRecords, List<T> aaData) {
		super();
		this.sEcho = sEcho;
		this.iTotalRecords = iTotalRecords;
		this.iTotalDisplayRecords = iTotalDisplayRecords;
		this.aaData = aaData;
	}
	public Integer getsEcho() {
		return sEcho;
	}
	public Integer getiTotalRecords() {
		return iTotalRecords;
	}
	public Integer getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	public List<T> getAaData() {
		return aaData;
	}
}
