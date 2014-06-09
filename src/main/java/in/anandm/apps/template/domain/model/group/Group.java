/**
 * 
 */
package in.anandm.apps.template.domain.model.group;

import in.anandm.apps.template.domain.model.authority.Authority;
import in.anandm.apps.template.domain.shared.entity.BaseEntity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author anandm
 * 
 */
@Entity
@Table(name = "_group")
@JsonIgnoreProperties({"authorities"})
public class Group extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String groupName;
	private Boolean denyGroup;
	private Boolean enabled;

	@ManyToMany
	private List<Authority> authorities = new ArrayList<Authority>();

	public void denyGroup() {
		denyGroup = true;
	}

	public void allowGroup() {
		denyGroup = false;
	}

	public void disbale() {
		enabled = false;
	}

	public void enable() {
		enabled = true;
	}


	public void addAuthority(Authority role){
		if(!authorities.contains(role)){
			authorities.add(role);
		}
	}

	public void removeAuthority(Authority role){
		if(authorities.contains(role)){
			authorities.remove(role);
		}
	}

	public String getGroupName() {
		return groupName;
	}

	public Boolean getDenyGroup() {
		return denyGroup;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public List<Authority> getAuthorities() {
		return authorities;
	}

	/**
	 * 
	 */
	Group() {
		super();

	}


}
