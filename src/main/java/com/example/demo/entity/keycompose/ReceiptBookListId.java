package com.example.demo.entity.keycompose;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ReceiptBookListId implements Serializable {
	private Integer receiptId;
	private Integer bookId;

}
