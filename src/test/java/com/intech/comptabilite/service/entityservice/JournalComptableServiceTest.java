package com.intech.comptabilite.service.entityservice;

import com.intech.comptabilite.model.JournalComptable;
import com.intech.comptabilite.repositories.JournalComptableRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class JournalComptableServiceTest {

    @Autowired
    JournalComptableService service;

    @MockBean
    JournalComptableRepository repository;

    @Test
    void getByCode() {
        List<JournalComptable> listJournalComptable = new ArrayList<>(Arrays.asList(
                new JournalComptable("AC", "Achat"),
                new JournalComptable("VE", "Vente")));

        JournalComptable byCode = service.getByCode(listJournalComptable, "AC");

        Assertions.assertNotNull(byCode);
        Assertions.assertEquals(byCode.getCode(), "AC");
        Assertions.assertEquals(byCode.getLibelle(), "Achat");
    }

    @Test
    void getListJournalComptable() {
        Mockito.when(repository.findAll())
               .thenReturn(new ArrayList<>(Arrays.asList(
                       new JournalComptable("AC", "Achat"),
                       new JournalComptable("VE", "Vente"))));

        List<JournalComptable> listJournalComptable = service.getListJournalComptable();

        Assertions.assertNotNull(listJournalComptable);
        Assertions.assertEquals(listJournalComptable.size(), 2);
    }
}