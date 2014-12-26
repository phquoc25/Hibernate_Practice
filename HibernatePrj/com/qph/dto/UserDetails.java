package com.qph.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@org.hibernate.annotations.Entity(selectBeforeUpdate=true)
@Table(name="USER_DETAILS")
public class UserDetails {
	@Id	
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private  int userId;
	private String userName;
	@Temporal(TemporalType.DATE)
	private Date joinedDate;
	@OneToMany(cascade=CascadeType.ALL)
	private Collection<Vehicle> vehicles = new ArrayList<Vehicle>();
	
	@Lob
	private String description;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int usetId) {
		this.userId = usetId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}
	
	 
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Collection<Vehicle> getVehicles() {
		return vehicles;
	}
	public void setVehicles(Collection<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}
	
}
