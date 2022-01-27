package com.intech.comptabilite.service.entityservice;

import com.intech.comptabilite.model.CompteComptable;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CompteComptableServiceIntegrationTest {

    @Autowired
    CompteComptableService service;

    @Test
    void testIntegrationGetListCompteComptable() {
        List<CompteComptable> listCompteComptable = service.getListCompteComptable();

        Assertions.assertNotNull(listCompteComptable);
        Assertions.assertEquals(listCompteComptable.size(),7);
    }
}