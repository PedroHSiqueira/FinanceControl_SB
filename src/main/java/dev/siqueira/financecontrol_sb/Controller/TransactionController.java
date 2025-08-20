package dev.siqueira.financecontrol_sb.Controller;

import dev.siqueira.financecontrol_sb.Dto.TransactionDTO;
import dev.siqueira.financecontrol_sb.Entity.TransactionModel;
import dev.siqueira.financecontrol_sb.Service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<?> getAllTransactions() {
        List<TransactionModel> transactionModels = transactionService.findAll();
        if (transactionModels.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nada encontrado!");
        }

        return ResponseEntity.ok(transactionModels);
    }

    @PostMapping
    public ResponseEntity<?> createTransaction(@RequestBody TransactionDTO transactionDTO) {
        TransactionModel model = transactionService.save(transactionDTO);
        if (model == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Houve um Problema com o envio!");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body("Transaction salvo com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTransaction(@PathVariable Long id, @RequestBody TransactionDTO transactionDTO) {
        TransactionModel model = transactionService.save(transactionDTO);
        if (model == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro Interno da API!");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Transaction Atualizado com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long id) {
        TransactionModel model = transactionService.findById(id);
        if (model == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Nada encontrado ou elemento Inexistente!");
        }

        transactionService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Transaction deletado com sucesso!");
    }
}
