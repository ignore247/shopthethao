package com.shopthethao.Entity;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "accounts")
public class Accounts {
	@Id
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "created_at")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private Date created_at;
	@ManyToOne
	@JoinColumn(name = "id_role")
	private Roles roles;
	public Accounts() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Accounts(String email, String password, Date created_at, Roles roles) {
		super();
		this.email = email;
		this.password = password;
		this.created_at = created_at;
		this.roles = roles;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Roles getRoles() {
		return roles;
	}
	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	@Override
	public int hashCode() {
		return Objects.hash(created_at, email, password, roles);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Accounts other = (Accounts) obj;
		return Objects.equals(created_at, other.created_at) && Objects.equals(email, other.email)
				&& Objects.equals(password, other.password) && Objects.equals(roles, other.roles);
	}
	@Override
	public String toString() {
		return "Accounts [email=" + email + ", password=" + password + ", created_at=" + created_at + ", roles=" + roles
				+ "]";
	}
	
	
}
