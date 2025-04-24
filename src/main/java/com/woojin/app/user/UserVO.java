package com.woojin.app.user;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO implements UserDetails {
	
	//UserDetails : getusername, getpassword, getAuthorites
	
	@NotBlank(groups = JoinGroup.class)
	private String username;
	@Size(min = 8, max = 16)
	@NotBlank(groups = JoinGroup.class)
	private String password;
	private String passwordCheck;
	@NotBlank(groups = {UpdateGroup.class, JoinGroup.class})
	private String name;
	@NotBlank(groups = {UpdateGroup.class, JoinGroup.class})
	private String phone;
	@Email(groups = {UpdateGroup.class, JoinGroup.class})
	private String email;
	@Past(groups = {UpdateGroup.class, JoinGroup.class})
	private Date birth;
	private String fileName;
	private String oriName;
	
	private boolean accountNonExpired;
	private boolean accountNonLocked;
	private boolean credentialsNonExpired;
	private boolean enabled;
	
	private List<RoleVO> list;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//ROLE_NAME을 리턴
		List<GrantedAuthority> ar = new ArrayList<>();
		
		for (RoleVO roleVO:this.list) {
			GrantedAuthority g = new SimpleGrantedAuthority(roleVO.getRoleName());
				ar.add(g);
		}
		return ar;
	}
	
	//pw가 틀렸을 경우 - BadCredentialException : 자격 증명에 실패하였습니다.
	//id가 틀렸을 경우 - InternalAuthenticationServiceException

	
	
	
	
}
