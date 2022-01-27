package com.intech.comptabilite.service.entityservice;

import com.intech.comptabilite.model.CompteComptable;
import com.intech.comptabilite.repositories.CompteComptableRepository;
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
class CompteComptableServiceTest {

    @Autowired
    CompteComptableService service;

    @MockBean
    CompteComptableRepository repository;

    @Test
    void testGetByNumero() {
        List<CompteComptable> listCompteComptable = new ArrayList<>(Arrays.asList(new CompteComptable(401,
                "Fournisseurs"), new CompteComptable(411, "Clients")));
        CompteComptable byNumero = service.getByNumero(listCompteComptable, 401);

        Assertions.assertNotNull(byNumero);
        Assertions.assertEquals(byNumero.getNumero(), 401);
        Assertions.assertEquals(byNumero.getLibelle(), "Fournisseurs");
    }

    @Test
    void testGetListCompteComptable() {
        Mockito.when(repository.findAll())
               .thenReturn(new ArrayList<>(Arrays.asList(
                       new CompteComptable(401, "Fournisseurs"),
                       new CompteComptable(411, "Clients"))));

        List<CompteComptable> listCompteComptable = service.getListCompteComptable();

        Assertions.assertNotNull(listCompteComptable);
        Assertions.assertEquals(listCompteComptable.size(), 2);
    }
}