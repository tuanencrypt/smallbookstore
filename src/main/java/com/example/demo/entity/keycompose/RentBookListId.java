package com.example.demo.entity.keycompose;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class RentBookListId {
	private Integer rentId;
	private Integer bookId;
}
