package com.rcmfootball.rcmfootball.request.career;

import java.math.BigDecimal;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateTransfer {
	@Digits(integer=9, fraction=2, message="número de caracteres atingido")
	@PositiveOrZero(message="o valor deve ser acima de 0")
	private BigDecimal totalValue;
	@Digits(integer=6, fraction=2, message="número de caracteres atingido")
	@PositiveOrZero(message="o valor deve ser acima de 0")
	private BigDecimal wage;
	@Min(value=0, message="o número deve ser igual ou maior que 0")
	@Max(value=5, message="o número deve ser menor que 5")
	private Integer year;
	@PositiveOrZero(message="O valor deve ser acima de 0")
	@Digits(integer=1, fraction=0, message="O mês deve haver no máximo 2 digitos")
	private Integer month;
	private Boolean isAccepted;
	private Boolean renovation;
	private Boolean offerActive;
}
