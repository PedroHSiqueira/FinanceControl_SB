package dev.siqueira.financecontrol_sb.Mappers;

import dev.siqueira.financecontrol_sb.Dto.TransactionDTO;
import dev.siqueira.financecontrol_sb.Entity.TransactionModel;
import dev.siqueira.financecontrol_sb.Entity.UserModel;
import dev.siqueira.financecontrol_sb.Repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class TransactionMapper {
    
    private UserRepository userRepository;

    public TransactionMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public TransactionModel toModel(TransactionDTO transactionDTO) {
        UserModel userModel = userRepository.findById(transactionDTO.user()).orElse(null);
        
        TransactionModel model = new TransactionModel();
        model.setDescription(transactionDTO.description());
        model.setAmount(transactionDTO.amount());
        model.setDate(transactionDTO.date());
        model.setType(transactionDTO.type());
        model.setUser(userModel);
        return model;
    }

    public TransactionDTO toDTO(TransactionModel model) {
        UserModel userModel = userRepository.findById(model.getUser().getId()).orElse(null);

        if (userModel == null) {
            throw new RuntimeException("User not found");
        }
        return new TransactionDTO(model.getDescription(), model.getAmount(), model.getDate(), model.getType(), userModel.getId());
    }
}
