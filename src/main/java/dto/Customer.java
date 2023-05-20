package dto;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(generator="idg")
	@SequenceGenerator(initialValue=89519864,allocationSize=1,name="idg",sequenceName="idg")
	int custid;
	String name;
	//@column(unique==true)
	String email;
	long mobile;
	String password;
	String gender;
	Date dob;
	String address;
	int age;
}
