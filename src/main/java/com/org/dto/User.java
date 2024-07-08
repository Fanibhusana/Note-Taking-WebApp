package com.org.dto;
import java.util.List;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private long mobile;
	private String email;
	private String password;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Notes> notes;
}
