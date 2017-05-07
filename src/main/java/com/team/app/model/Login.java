package com.team.app.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ThueLlay
 */
@Entity
@Table(name = "login")
@XmlRootElement
/*
 * @NamedQueries({
 * 
 * @NamedQuery(name = "Login.findAll", query = "SELECT l FROM Login l")
 * , @NamedQuery(name = "Login.findByLoginid", query =
 * "SELECT l FROM Login l WHERE l.loginid = :loginid") , @NamedQuery(name =
 * "Login.findByPassword", query =
 * "SELECT l FROM Login l WHERE l.password = :password") , @NamedQuery(name =
 * "Login.findByRole", query = "SELECT l FROM Login l WHERE l.role = :role")})
 */
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "loginid")
	private String loginid;
	
	@NotNull
	@Size(max = 45)
	@Column(name = "password")
	private String password;
	@Size(max = 45)
	@Column(name = "role")
	private String role;

	public Login() {
	}

	public Login(String loginid) {
		this.loginid = loginid;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (loginid != null ? loginid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Login)) {
			return false;
		}
		Login other = (Login) object;
		if ((this.loginid == null && other.loginid != null)
				|| (this.loginid != null && !this.loginid.equals(other.loginid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.team.app.model.Login[ loginid=" + loginid + " ]";
	}

}
