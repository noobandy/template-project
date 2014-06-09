/**
 * 
 */
package in.anandm.apps.template.interfaces.web.controller;

import in.anandm.apps.template.domain.model.authority.IAuthorityRepository;
import in.anandm.apps.template.domain.model.group.IGroupRepository;
import in.anandm.apps.template.domain.model.user.IUserRepository;
import in.anandm.apps.template.interfaces.web.facade.dto.GroupDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author anandm
 *
 */
@Controller
@RequestMapping(value="/group")
public class GroupController {

	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IGroupRepository groupRepository;
	
	@Autowired
	private IAuthorityRepository authorityRepository;

	@RequestMapping(value="/grid")
	public String getGroups(){
		return "group/grid";
	}

	@RequestMapping(value="/newGroup",method=RequestMethod.GET)
	public String newGroup(Model model){
		model.addAttribute("group",new GroupDTO());
		return "group/group";
	}

	@RequestMapping(value="/newGroup",method=RequestMethod.POST)
	public String newGroupPost(){
		return "group/grid";
	}

	public String group(){
		return "group/group";
	}


}
