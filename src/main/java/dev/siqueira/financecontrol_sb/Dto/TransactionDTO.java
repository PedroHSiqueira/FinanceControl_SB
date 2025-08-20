package dev.siqueira.financecontrol_sb.Dto;

import dev.siqueira.financecontrol_sb.Types.TransactionTypes;

import java.time.LocalDateTime;


public record TransactionDTO(String description, Double amount, LocalDateTime date, TransactionTypes type) {
}
