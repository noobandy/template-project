/**
 * 
 */
package in.anandm.apps.template.domain.model.group;

import in.anandm.apps.template.domain.shared.entity.BaseEntity;

import javax.persistence.Entity;

/**
 * @author anandm
 *
 */
@Entity
public class GroupUser extends BaseEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long groupId;
	private Long userId;

	/**
	 * @param groupId
	 * @param userId
	 */
	public GroupUser(Long groupId, Long userId) {
		super();
		this.groupId = groupId;
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		GroupUser other = (GroupUser) obj;
		if (groupId == null) {
			if (other.groupId != null) {
				return false;
			}
		} else if (!groupId.equals(other.groupId)) {
			return false;
		}
		if (userId == null) {
			if (other.userId != null) {
				return false;
			}
		} else if (!userId.equals(other.userId)) {
			return false;
		}
		return true;
	}

	/**
	 * 
	 */
	GroupUser() {
		super();

	}

}
