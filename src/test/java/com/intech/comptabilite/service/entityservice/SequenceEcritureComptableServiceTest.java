package com.intech.comptabilite.service.entityservice;

import com.intech.comptabilite.model.SequenceEcritureComptable;
import com.intech.comptabilite.repositories.SequenceEcritureComptableRepository;
import com.intech.comptabilite.service.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SequenceEcritureComptableServiceTest {

    @Autowired
    SequenceEcritureComptableService service;

    @MockBean
    SequenceEcritureComptableRepository repository;

    @Test
    void getDernierValeurByCodeAndAnnee() throws NotFoundException {
        Random r = new Random();
        int value = r.nextInt();
        Mockito.when(repository.findById(Mockito.any()))
               .thenReturn(Optional.of(
                       new SequenceEcritureComptable("AC", 2022, value)));

        int dernierValeurByCodeAndAnnee = service.getDernierValeurByCodeAndAnnee("AC", 2022);

        Assertions.assertEquals(dernierValeurByCodeAndAnnee, value);
    }
}