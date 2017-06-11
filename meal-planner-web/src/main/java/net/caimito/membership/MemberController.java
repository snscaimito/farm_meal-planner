package net.caimito.membership;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
	private final Logger logger = LoggerFactory.getLogger(MemberController.class) ;
	
	private Map<String, MembershipInformation> members = new HashMap<>() ;

	@RequestMapping(value="/member/{uuid}", method=RequestMethod.GET)
	public MembershipInformation isMember(@PathVariable String uuid) {
		logger.info(String.format("asking for %s", uuid));
		MembershipInformation membershipInformation = members.get(uuid) ;
		
		if (membershipInformation == null) {
			logger.info("Nothing found");
			return new MembershipInformation() ;
		}
		else
			logger.info(membershipInformation.toString());
		
		return membershipInformation ;
	}

	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public MembershipInformation login(@RequestBody MembershipInformation membershipInformation) {
		logger.info(String.format("Login attempt with %s", membershipInformation.toString()));
		
		for (MembershipInformation member : members.values()) {
			if (member.getEmail().equals(membershipInformation.getEmail()))
				return member ;
		}
		
		return membershipInformation ;
	}
	
	@RequestMapping(value="/member", method=RequestMethod.PUT)
	public MembershipInformation signup(@RequestBody MembershipInformation membershipInformation) {
		logger.info(membershipInformation.toString());
		membershipInformation.setActiveMember(true);
		membershipInformation.setUuid(UUID.randomUUID().toString());
		members.put(membershipInformation.getUuid(), membershipInformation) ;
		return membershipInformation ;
	}
	
	@RequestMapping(value="/member", method=RequestMethod.DELETE)
	public void deleteMembers() {
		logger.info("clearing membership database");
		members.clear();
	}
}
