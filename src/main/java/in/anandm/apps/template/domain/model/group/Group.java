/**
 * 
 */
package in.anandm.apps.template.domain.model.group;

import in.anandm.apps.template.domain.model.authority.Authority;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author anandm
 * 
 */
@Entity
@Table(name = "_group")
public class Group {

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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	/**
	 * 
	 */
	Group() {
		super();

	}
}
