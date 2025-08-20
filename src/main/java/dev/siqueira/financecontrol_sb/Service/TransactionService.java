package dev.siqueira.financecontrol_sb.Service;

import dev.siqueira.financecontrol_sb.Dto.TransactionDTO;
import dev.siqueira.financecontrol_sb.Entity.TransactionModel;
import dev.siqueira.financecontrol_sb.Mappers.TransactionMapper;
import dev.siqueira.financecontrol_sb.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;

    public TransactionService(TransactionRepository transactionRepository, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
    }

    public List<TransactionModel> findAll() {
        return transactionRepository.findAll();
    }

    public TransactionModel findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    public TransactionModel save(TransactionDTO transactionDTO) {
        TransactionModel transactionModel = transactionMapper.toModel(transactionDTO);
        return transactionRepository.save(transactionModel);
    }

    public TransactionModel update(TransactionDTO transactionDTO) {
        TransactionModel transactionModel = transactionMapper.toModel(transactionDTO);
        return transactionRepository.save(transactionModel);
    }

    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }

}
