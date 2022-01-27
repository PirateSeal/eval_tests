package com.intech.comptabilite.service.entityservice;

import com.intech.comptabilite.model.JournalComptable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JournalComptableServiceIntegrationTest {

    @Autowired
    JournalComptableService service;

    @Test
    void getListJournalComptable() {
        List<JournalComptable> listJournalComptable = service.getListJournalComptable();

        Assertions.assertNotNull(listJournalComptable);
        Assertions.assertEquals(listJournalComptable.size(),4);
    }
}