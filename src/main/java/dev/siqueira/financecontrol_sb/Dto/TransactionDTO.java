package dev.siqueira.financecontrol_sb.Dto;

import dev.siqueira.financecontrol_sb.Types.TransactionTypes;

import java.time.LocalDateTime;
import java.util.UUID;


public record TransactionDTO(String description, Double amount, LocalDateTime date, TransactionTypes type, UUID user) {
}
