package com.team.app.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author ThueLlay
 */
@Entity
@Table(name = "course")
@XmlRootElement
/*
 * @NamedQueries({
 * 
 * @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")
 * , @NamedQuery(name = "Course.findByCourseid", query =
 * "SELECT c FROM Course c WHERE c.courseid = :courseid") , @NamedQuery(name =
 * "Course.findByCoursename", query =
 * "SELECT c FROM Course c WHERE c.coursename = :coursename") , @NamedQuery(name
 * = "Course.findBySize", query = "SELECT c FROM Course c WHERE c.size = :size")
 * , @NamedQuery(name = "Course.findByCredit", query =
 * "SELECT c FROM Course c WHERE c.credit = :credit") , @NamedQuery(name =
 * "Course.findByStartdate", query =
 * "SELECT c FROM Course c WHERE c.startdate = :startdate")})
 */
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 45)
	@Column(name = "courseid")
	private String courseid;
	@Size(max = 45)
	@Column(name = "coursename")
	private String coursename;
	@Column(name = "size")
	private Integer size;
	@Column(name = "credit")
	private Long credit;
	@Column(name = "startdate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date startdate;

	@OneToMany(mappedBy = "courseid")
	private Collection<Enrolment> enrolmentCollection;

	@JoinColumn(name = "lecturerid", referencedColumnName = "lecturerid")
	@ManyToOne
	private Lecturer lecturerid;

	public Course() {
	}

	public Course(String courseid) {
		this.courseid = courseid;
	}

	public String getCourseid() {
		return courseid;
	}

	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Long getCredit() {
		return credit;
	}

	public void setCredit(Long credit) {
		this.credit = credit;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	@XmlTransient
	public Collection<Enrolment> getEnrolmentCollection() {
		return enrolmentCollection;
	}

	public void setEnrolmentCollection(Collection<Enrolment> enrolmentCollection) {
		this.enrolmentCollection = enrolmentCollection;
	}

	public Lecturer getLecturerid() {
		return lecturerid;
	}

	public void setLecturerid(Lecturer lecturerid) {
		this.lecturerid = lecturerid;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (courseid != null ? courseid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Course)) {
			return false;
		}
		Course other = (Course) object;
		if ((this.courseid == null && other.courseid != null)
				|| (this.courseid != null && !this.courseid.equals(other.courseid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.team.app.model.Course[ courseid=" + courseid + " ]";
	}

}
