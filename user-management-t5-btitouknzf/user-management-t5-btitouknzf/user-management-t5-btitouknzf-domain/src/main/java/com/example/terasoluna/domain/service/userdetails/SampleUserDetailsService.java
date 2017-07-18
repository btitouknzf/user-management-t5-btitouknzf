package com.example.terasoluna.domain.service.userdetails;

import java.util.Collection;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import com.example.terasoluna.domain.model.UserInfo;
import com.example.terasoluna.domain.model.UserRoleInfo;
import com.example.terasoluna.domain.service.shared.UserInfoSharedService;
import com.example.terasoluna.domain.service.shared.UserRoleInfoSharedService;

@Service
public class SampleUserDetailsService implements UserDetailsService {
	
	@Inject
	UserInfoSharedService userInfoSharedService;
	
	@Inject
	UserRoleInfoSharedService userRoleInfoSharedService;

	@Transactional(readOnly = true)
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		// TODO 自動生成されたメソッド・スタブ
		try{
			UserInfo userInfo = userInfoSharedService.findOne(userid);
			Collection<UserRoleInfo> userRole = userRoleInfoSharedService.findRole(userid);
			String[] userRoleString = new String[userRole.size()];
			int i = 0;
			for(UserRoleInfo s: userRole){
				System.out.println(i);
				if(s.getRole().equals("ADMN")){
					userRoleString[i] = "ROLE_ADMIN";
				}else{
					userRoleString[i] = "ROLE_" + s.getRole();
				}
				System.out.println(userRoleString[i]);
				i++;
			}
			
			/*
			userRole.forEach(
					userRoleString = 
					
					);
			
			for(int i=0; i<userRole.size();i++){
				userRoleString[i] = "ROLE_" + userRole.f;
			}
			*/
			return new SampleUserDetails(userInfo,userRoleString);
			
			/*
			return new SampleUserDetails(userInfo);
			*/
		} catch(ResourceNotFoundException e){
			throw new UsernameNotFoundException("user not found", e);
		}
	}

}
