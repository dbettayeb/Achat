package tn.esprit.rh.achat.services;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.*;

import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.repositories.ReglementRepository;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ReglementTest {
	@Mock
	ReglementRepository reglementRepository;
	@InjectMocks
	ReglementServiceImpl serviceImpl;
	
	Reglement reglement =  new Reglement((long) 1,(float) 1, (float) 1,true, null, null);
	
	@Test
	public Reglement testretrieveStock(Reglement s) {
		Mockito.when(reglementRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(reglement));
		Reglement reglement1 = serviceImpl.retrieveReglement(reglement.getIdReglement());
		Assertions.assertNotNull(reglement1); 
		return reglement1;
		
	}
 
}