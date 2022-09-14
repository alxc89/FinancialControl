package com.api.FinancialControl.services;

import com.api.FinancialControl.models.TransactionModel;
import com.api.FinancialControl.repositories.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionService {
    final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }
    @Transactional
    public TransactionModel save(TransactionModel transactionModel) {
        return transactionRepository.save(transactionModel);
    }

    public List<TransactionModel> findAll() {
        return transactionRepository.findAll();
    }

    public Optional<TransactionModel> findById(UUID id) {
        return transactionRepository.findById(id);
    }

    public void delete(TransactionModel transactionModel) {
        transactionRepository.delete(transactionModel);
    }
}
