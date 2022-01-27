package com.intech.comptabilite.service.entityservice;

import com.intech.comptabilite.model.SequenceEcritureComptable;
import com.intech.comptabilite.service.exceptions.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class SequenceEcritureComptableServiceIntegrationTest {

    @Autowired
    SequenceEcritureComptableService service;

    @Test
    void getDernierValeurByCodeAndAnnee() throws NotFoundException {
        int dernierValeurByCodeAndAnnee = service.getDernierValeurByCodeAndAnnee("AC", 2016);

        Assertions.assertEquals(dernierValeurByCodeAndAnnee,40);
    }

    @Test
    void upsert() throws NotFoundException {
        Random r = new Random();
        int value = r.nextInt();
        SequenceEcritureComptable sequenceEcritureComptable = new SequenceEcritureComptable("AC",2022,value);

        service.upsert(sequenceEcritureComptable);
        int result = service.getDernierValeurByCodeAndAnnee("AC", 2022);

        Assertions.assertEquals(result,value);
    }
}