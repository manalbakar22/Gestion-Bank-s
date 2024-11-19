package com.example.demo.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@MappedSuperclass

public class AbstractEntity {

	
	@Id
	@GeneratedValue
	private Integer id;
	
	@CreatedDate
	@Column(
			name = "createDate",
			updatable= false,
			nullable= false)
	
	private LocalDateTime creationDate;
	
	@LastModifiedDate
	@Column(
			name="LastModifiedDate"
			)
	private LocalDateTime LastUpdate;
}
