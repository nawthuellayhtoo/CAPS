package com.team.app.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "student")
@XmlRootElement

public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "studentid")
	private String studentid;

	@Size(max = 45)
	@Column(name = "firstname")
	private String firstname;

	@Size(max = 45)
	@Column(name = "lastname")
	private String lastname;

	@Column(name = "gpa")
	private double gpa;

	@Size(max = 45)
	@Column(name = "email")
	private String email;

	@OneToMany(mappedBy = "studentid")
	private Collection<Enrolment> enrolmentCollection;

	public Student() {
	}

	public Student(String studentid) {
		this.studentid = studentid;
	}

	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlTransient
	public Collection<Enrolment> getEnrolmentCollection() {
		return enrolmentCollection;
	}

	public void setEnrolmentCollection(Collection<Enrolment> enrolmentCollection) {
		this.enrolmentCollection = enrolmentCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (studentid != null ? studentid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Student)) {
			return false;
		}
		Student other = (Student) object;
		if ((this.studentid == null && other.studentid != null)
				|| (this.studentid != null && !this.studentid.equals(other.studentid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.team.app.model.Student[ studentid=" + studentid + " ]";
	}

}
