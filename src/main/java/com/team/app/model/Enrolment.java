package com.team.app.model;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ThueLlay
 */
@Entity
@Table(name = "enrolment")
@XmlRootElement
/*
 * @NamedQueries({
 * 
 * @NamedQuery(name = "Enrolment.findAll", query = "SELECT e FROM Enrolment e")
 * , @NamedQuery(name = "Enrolment.findByEnrolmentid", query =
 * "SELECT e FROM Enrolment e WHERE e.enrolmentid = :enrolmentid")
 * , @NamedQuery(name = "Enrolment.findByEnrolmentdate", query =
 * "SELECT e FROM Enrolment e WHERE e.enrolmentdate = :enrolmentdate")
 * , @NamedQuery(name = "Enrolment.findByGrade", query =
 * "SELECT e FROM Enrolment e WHERE e.grade = :grade")})
 */
public class Enrolment implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "enrolmentid")
	private Integer enrolmentid;
	@Column(name = "enrolmentdate")
	@Temporal(TemporalType.DATE)
	private Date enrolmentdate;
	@Column(name = "grade")
	private Long grade;
	
	@JoinColumn(name = "courseid", referencedColumnName = "courseid")
	@ManyToOne
	private Course courseid;
	
	@JoinColumn(name = "studentid", referencedColumnName = "studentid")
	@ManyToOne
	private Student studentid;

	public Course getCourseid() {
		return courseid;
	}

	public void setCourseid(Course courseid) {
		this.courseid = courseid;
	}

	public Student getStudentid() {
		return studentid;
	}

	public void setStudentid(Student studentid) {
		this.studentid = studentid;
	}

	public Enrolment() {
	}

	public Enrolment(Integer enrolmentid) {
		this.enrolmentid = enrolmentid;
	}

	public Integer getEnrolmentid() {
		return enrolmentid;
	}

	public void setEnrolmentid(Integer enrolmentid) {
		this.enrolmentid = enrolmentid;
	}

	public Date getEnrolmentdate() {
		return enrolmentdate;
	}

	public void setEnrolmentdate(Date enrolmentdate) {
		this.enrolmentdate = enrolmentdate;
	}

	public Long getGrade() {
		return grade;
	}

	public void setGrade(Long grade) {
		this.grade = grade;
	}

	

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (enrolmentid != null ? enrolmentid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Enrolment)) {
			return false;
		}
		Enrolment other = (Enrolment) object;
		if ((this.enrolmentid == null && other.enrolmentid != null)
				|| (this.enrolmentid != null && !this.enrolmentid.equals(other.enrolmentid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.team.app.model.Enrolment[ enrolmentid=" + enrolmentid + " ]";
	}

}

