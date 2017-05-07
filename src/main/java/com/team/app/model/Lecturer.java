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

/**
 *
 * @author ThueLlay
 */
@Entity
@Table(name = "lecturer")
@XmlRootElement
/*
 * @NamedQueries({
 * 
 * @NamedQuery(name = "Lecturer.findAll", query = "SELECT l FROM Lecturer l")
 * , @NamedQuery(name = "Lecturer.findByLecturerid", query =
 * "SELECT l FROM Lecturer l WHERE l.lecturerid = :lecturerid")
 * , @NamedQuery(name = "Lecturer.findByFirstname", query =
 * "SELECT l FROM Lecturer l WHERE l.firstname = :firstname") , @NamedQuery(name
 * = "Lecturer.findByLastname", query =
 * "SELECT l FROM Lecturer l WHERE l.lastname = :lastname")})
 */
public class Lecturer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "lecturerid")
	private String lecturerid;
	@Size(max = 45)
	@Column(name = "firstname")
	private String firstname;
	
	@Size(max = 45)
	@Column(name = "lastname")
	private String lastname;
	
	@OneToMany(mappedBy = "lecturerid")
	private Collection<Course> courseCollection;

	public Lecturer() {
	}

	public Lecturer(String lecturerid) {
		this.lecturerid = lecturerid;
	}

	public String getLecturerid() {
		return lecturerid;
	}

	public void setLecturerid(String lecturerid) {
		this.lecturerid = lecturerid;
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

	@XmlTransient
	public Collection<Course> getCourseCollection() {
		return courseCollection;
	}

	public void setCourseCollection(Collection<Course> courseCollection) {
		this.courseCollection = courseCollection;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (lecturerid != null ? lecturerid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Lecturer)) {
			return false;
		}
		Lecturer other = (Lecturer) object;
		if ((this.lecturerid == null && other.lecturerid != null)
				|| (this.lecturerid != null && !this.lecturerid.equals(other.lecturerid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.team.app.model.Lecturer[ lecturerid=" + lecturerid + " ]";
	}

}
