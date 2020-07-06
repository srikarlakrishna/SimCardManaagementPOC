package com.sim.app.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String userName;

	@Column(nullable = false, length = 10)
	private Long adharNumber;

	@Column(name = "subscription_date")
	private Date subscriptionDate;

	@OneToOne(cascade = CascadeType.PERSIST)
	private UserAddress address;

	@OneToOne(cascade = CascadeType.PERSIST)
	private SimCard simCardNumber;

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getAdharNumber() {
		return adharNumber;
	}

	public void setAdharNumber(Long adharNumber) {
		this.adharNumber = adharNumber;
	}

	public UserAddress getAddress() {
		return address;
	}

	public void setAddress(UserAddress address) {
		this.address = address;
	}

	public SimCard getSimCardNumber() {
		return simCardNumber;
	}

	public void setSimCardNumber(SimCard simCardNumber) {
		this.simCardNumber = simCardNumber;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", adharNumber=" + adharNumber + ", subscriptionDate="
				+ subscriptionDate + ", address=" + address + ", simCardNumber=" + simCardNumber + "]";
	}

}
