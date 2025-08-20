package dev.siqueira.financecontrol_sb.Mappers;

import dev.siqueira.financecontrol_sb.Dto.TransactionDTO;
import dev.siqueira.financecontrol_sb.Entity.TransactionModel;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {

    public TransactionModel toModel(TransactionDTO transactionDTO) {
        TransactionModel model = new TransactionModel();
        model.setDescription(transactionDTO.description());
        model.setAmount(transactionDTO.amount());
        model.setDate(transactionDTO.date());
        model.setType(transactionDTO.type());
        return model;
    }

    public TransactionDTO toDTO(TransactionModel model) {
        return new TransactionDTO(model.getDescription(), model.getAmount(), model.getDate(), model.getType());
    }
}
