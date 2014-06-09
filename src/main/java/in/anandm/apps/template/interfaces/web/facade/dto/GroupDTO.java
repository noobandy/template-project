/**
 * 
 */
package in.anandm.apps.template.interfaces.web.facade.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author anandm
 *
 */
public class GroupDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String groupName;
	private boolean denyGroup;
	private boolean enabled;
	private List<Long> authorityIds= new ArrayList<Long>();
	private List<Long> userIds = new ArrayList<Long>();

	/**
	 * 
	 */
	public GroupDTO() {
		super();

	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public boolean isDenyGroup() {
		return denyGroup;
	}

	public void setDenyGroup(boolean denyGroup) {
		this.denyGroup = denyGroup;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Long> getAuthorityIds() {
		return authorityIds;
	}

	public void setAuthorityIds(List<Long> authorityIds) {
		this.authorityIds = authorityIds;
	}

	public List<Long> getUserIds() {
		return userIds;
	}

	public void setUserIds(List<Long> userIds) {
		this.userIds = userIds;
	}

}
