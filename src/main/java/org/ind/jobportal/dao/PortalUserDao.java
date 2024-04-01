package org.ind.jobportal.dao;

import org.ind.jobportal.repository.PortalUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class PortalUserDao {
	@Autowired 
	PortalUserRepository portalUserRepository;

	public boolean existsByEmail(String email) {
		
		return portalUserRepository.existsByEmail(email);
	}
	

}
