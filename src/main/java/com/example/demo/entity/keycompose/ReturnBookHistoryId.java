package com.example.demo.entity.keycompose;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ReturnBookHistoryId {
	private RentBookListId rentBookListId;
}
