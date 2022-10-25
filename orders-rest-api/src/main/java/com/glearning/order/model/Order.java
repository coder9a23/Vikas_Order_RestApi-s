package com.glearning.order.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
//@Setter
//@Getter
//@AllArgsConstructor
//@ToString
//@EqualsAndHashCode
@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private double price;
	private String name;
	private LocalDate oderDate;
	private String email;

	// This all properties are going to done by lombok
	// constructor
	// setter
	// getter
	// to string method
	// equals
	// hashcode metod

}
