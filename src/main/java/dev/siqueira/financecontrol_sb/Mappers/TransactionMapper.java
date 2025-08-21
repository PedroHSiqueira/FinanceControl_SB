package dev.siqueira.financecontrol_sb.Mappers;

import dev.siqueira.financecontrol_sb.Dto.TransactionDTO;
import dev.siqueira.financecontrol_sb.Entity.TransactionModel;
import dev.siqueira.financecontrol_sb.Entity.UserModel;
import dev.siqueira.financecontrol_sb.Repository.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class TransactionMapper {
    
    private final UserRepository userRepository;

    public TransactionMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public TransactionModel toModel(TransactionDTO transactionDTO) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        UserModel userModel = userRepository.findById(transactionDTO.user()).orElse(null);
        
        TransactionModel model = new TransactionModel();
        model.setDescription(transactionDTO.description());
        model.setAmount(transactionDTO.amount());
        model.setDate(LocalDateTime.parse(transactionDTO.date(), formatter));
        model.setType(transactionDTO.type());
        model.setUser(userModel);
        return model;
    }

    public TransactionDTO toDTO(TransactionModel model) {
        UserModel userModel = userRepository.findById(model.getUser().getId()).orElse(null);

        if (userModel == null) {
            throw new RuntimeException("User not found");
        }
        return new TransactionDTO(model.getDescription(), model.getAmount(), model.getDate().toString(), model.getType(), userModel.getId());
    }
};
