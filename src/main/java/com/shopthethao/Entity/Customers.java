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
@Table(name = "customers")
public class Customers {
	@Id
	@Column(name = "id_customer")
	private String id_customer;
	@Column(name = "shipping_address")
	private String shipping_address;
	@Column(name = "phone")
	private String phone;
	@Column(name = "created_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date created_at;
	@ManyToOne
	@JoinColumn(name = "email")
	private Accounts accounts;
	public Customers() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customers(String id_customer, String shipping_address, String phone, Date created_at, Accounts accounts) {
		super();
		this.id_customer = id_customer;
		this.shipping_address = shipping_address;
		this.phone = phone;
		this.created_at = created_at;
		this.accounts = accounts;
	}
	public String getId_customer() {
		return id_customer;
	}
	public void setId_customer(String id_customer) {
		this.id_customer = id_customer;
	}
	public String getShipping_address() {
		return shipping_address;
	}
	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Accounts getAccounts() {
		return accounts;
	}
	public void setAccounts(Accounts accounts) {
		this.accounts = accounts;
	}
	@Override
	public int hashCode() {
		return Objects.hash(accounts, created_at, id_customer, phone, shipping_address);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customers other = (Customers) obj;
		return Objects.equals(accounts, other.accounts) && Objects.equals(created_at, other.created_at)
				&& Objects.equals(id_customer, other.id_customer) && Objects.equals(phone, other.phone)
				&& Objects.equals(shipping_address, other.shipping_address);
	}
	@Override
	public String toString() {
		return "Customers [id_customer=" + id_customer + ", shipping_address=" + shipping_address + ", phone=" + phone
				+ ", created_at=" + created_at + ", accounts=" + accounts + "]";
	}
	
	
	
}
