package in.anandm.apps.template.interfaces.web.facade.dto;

public class ColumnMetaData {

	private String columnName;
	private Boolean bRegx;
	private Boolean bSortable;
	private Boolean bSearchable;
	private String sSearch;
	private String mDataProp;
	private String aSortDir;
	
	public ColumnMetaData() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}
	/**
	 * @return the bRegx
	 */
	public Boolean getbRegx() {
		return bRegx;
	}
	/**
	 * @return the bSortable
	 */
	public Boolean getbSortable() {
		return bSortable;
	}
	/**
	 * @return the bSearchable
	 */
	public Boolean getbSearchable() {
		return bSearchable;
	}
	/**
	 * @return the sSearch
	 */
	public String getsSearch() {
		return sSearch;
	}
	/**
	 * @return the mDataProp
	 */
	public String getmDataProp() {
		return mDataProp;
	}
	/**
	 * @return the aSortDir
	 */
	public String getaSortDir() {
		return aSortDir;
	}
	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	/**
	 * @param bRegx the bRegx to set
	 */
	public void setbRegx(Boolean bRegx) {
		this.bRegx = bRegx;
	}
	/**
	 * @param bSortable the bSortable to set
	 */
	public void setbSortable(Boolean bSortable) {
		this.bSortable = bSortable;
	}
	/**
	 * @param bSearchable the bSearchable to set
	 */
	public void setbSearchable(Boolean bSearchable) {
		this.bSearchable = bSearchable;
	}
	/**
	 * @param sSearch the sSearch to set
	 */
	public void setsSearch(String sSearch) {
		this.sSearch = sSearch;
	}
	/**
	 * @param mDataProp the mDataProp to set
	 */
	public void setmDataProp(String mDataProp) {
		this.mDataProp = mDataProp;
	}
	/**
	 * @param aSortDir the aSortDir to set
	 */
	public void setaSortDir(String aSortDir) {
		this.aSortDir = aSortDir;
	}
	
	
}
