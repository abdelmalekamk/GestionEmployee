package com.training.wcd.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Formula;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "\"EMPLOYEE\"")
@NamedQueries({
    @NamedQuery(name="Employee.findAll",
                query="SELECT emp FROM Employee emp"),
    @NamedQuery(name="Employee.findByName",
                query="SELECT emp FROM Employee emp WHERE emp.firstName = :firstName")})

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "\"EMPLOYEE_GENERATOR\"", sequenceName = "\"EMPLOYEE_SEQ\"")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "\"EMPLOYEE_GENERATOR\"")
	@Column(name = "\"ID\"")
	private Integer id;
	@Column(name = "\"FIRST_NAME\"")
	@Size(min=1, max=100)
	@NotNull
	@NotBlank
	@NotEmpty
	private String firstName;

	@Column(name = "\"LAST_NAME\"")
	@Size(min=1, max=100)
	private String lastName;
	
	@Formula("firstName" + "_" + "lastName")
	private transient String completeName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
