package com.api.FinancialControl.controller;

import com.api.FinancialControl.dtos.TransactionDTO;
import com.api.FinancialControl.models.TransactionModel;
import com.api.FinancialControl.services.TransactionService;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
@RequestMapping("/transaction")
public class TransactionController {
    final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Object> saveTransaction(@RequestBody TransactionDTO transactionDTO) {
       try {
            var transactionModel = new TransactionModel();
            BeanUtils.copyProperties(transactionDTO, transactionModel);
            transactionModel.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
            transactionModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

            return ResponseEntity.status(HttpStatus.CREATED).body(transactionService.save(transactionModel));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }

    }

    @GetMapping
    public ResponseEntity<List<TransactionModel>> getAllTransaction() {
        return ResponseEntity.status(HttpStatus.OK).body(transactionService.findAll());
    };

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneTransaction(@PathVariable(value = "id") UUID id){
        Optional<TransactionModel> transactionModelOptional = transactionService.findById(id);

        if(!transactionModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lançamento não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(transactionModelOptional.get());
    };

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateTransaction(@PathVariable(value = "id") UUID id,
                                                    @RequestBody @Valid TransactionDTO transactionDTO){
        Optional<TransactionModel> transactionModelOptional = transactionService.findById(id);
        if(!transactionModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lançamento não encontrado!");
        }

        var transactionModel = new TransactionModel();
        BeanUtils.copyProperties(transactionDTO, transactionModel);
        transactionModel.setId(transactionModelOptional.get().getId());
        transactionModel.setCreatedAt(transactionModelOptional.get().getCreatedAt());
        transactionModel.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));

        return ResponseEntity.status(HttpStatus.OK).body(transactionService.save(transactionModel));
    };

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTransaction(@PathVariable(value = "id") UUID id){
        Optional<TransactionModel> transactionModelOptional = transactionService.findById(id);
        if(!transactionModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lançamento não encontrado!");
        }

        transactionService.delete(transactionModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Lançamento deletado!");
    };
}
