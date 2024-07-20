package com.springboot.agenda.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contacts")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "El nombre es obligatorio")
	@Size(min=3,max=50)
	@Column(name = "name")
	private String name;
	
	@NotNull(message = "El email es obligatorio")
	@Email
	@Column(name = "email")
	private String email;
	
	@NotNull(message = "La fecha de creación es obligatoria")
	@PastOrPresent
	@Column(name = "created_date")
	private LocalDateTime createdDate;
	
}
