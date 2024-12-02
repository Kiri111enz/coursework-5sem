package com.pnimac.auth.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;


@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	public String rolename;

	@Override
	public String getAuthority() {
		return rolename;
	}

	public Long getId() {
		return this.id;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
}
