package com.org.dto;

import java.util.List;
import javax.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn
	private User user;
}
