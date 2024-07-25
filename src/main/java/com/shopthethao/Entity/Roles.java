package com.shopthethao.Entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Roles {
	
	@Id
	@Column(name = "id_role")
	private String id_role;
	@Column(name = "role")
	private String role;
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Roles(String id_role, String role) {
		super();
		this.id_role = id_role;
		this.role = role;
	}
	public String getId_role() {
		return id_role;
	}
	public void setId_role(String id_role) {
		this.id_role = id_role;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Roles [id_role=" + id_role + ", role=" + role + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id_role, role);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Roles other = (Roles) obj;
		return Objects.equals(id_role, other.id_role) && Objects.equals(role, other.role);
	}
	
	
}
