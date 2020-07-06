package com.sim.app.entities;

import java.util.Random;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SimCard")
public class SimCard {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = true)
	private String number;

	@Enumerated(value = EnumType.ORDINAL)
	private Operator operator;

	@OneToOne(mappedBy = "address")
	private Users user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber() {
		this.number = randomPhoneNumber();
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public static String randomPhoneNumber() {
		Random random = new Random();
		StringBuilder randomNumber = new StringBuilder("9");
		for (int i = 0; i < 9; i++) {
			randomNumber.append(random.nextInt(9));
		}
		return randomNumber.toString();
	}

	@Override
	public String toString() {
		return "SimCard [id=" + id + ", number=" + number + ", operator=" + operator + ", user=" + user + "]";
	}

}
