package dev.siqueira.financecontrol_sb.Repository;

import dev.siqueira.financecontrol_sb.Entity.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {
}
