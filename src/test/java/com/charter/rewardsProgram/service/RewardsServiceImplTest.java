package com.charter.rewardsProgram.service;

import com.charter.rewardsProgram.entity.Transaction;
import com.charter.rewardsProgram.repository.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RewardsServiceImplTest {

    @Mock
    TransactionRepository transactionRepository;

    @InjectMocks
    RewardsServiceImpl rewardsService;

    @BeforeEach
    void setMockOutput() {
        Transaction transaction = new Transaction();
        transaction.setTransactionAmount(211.0);
        transaction.setCustomerId(1001l);
        transaction.setTransactionId(20l);
        List<Transaction> transactionList = new ArrayList<>();
        transactionList.add(transaction);
        when(transactionRepository.findAllByCustomerIdAndTransactionDateBetween(anyLong(), any(), any())).thenReturn(transactionList);
    }

    @Test
    public void getRewardsByCustomerIdTest() {
        Assertions.assertNotNull(rewardsService.getRewardsByCustomerId(1001l));
    }
}
