package tn.esprit.rh.achat;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.*;

import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FournisseurTestImpl {
	@Mock
	FournisseurRepository fournisseurRepository;
	@InjectMocks
	FournisseurServiceImpl fournisseurservice;
	
	Fournisseur fournisseur =  new Fournisseur((long)5,"dd","dd",CategorieFournisseur.CONVENTIONNE, null, null, null);
	
	@Test
	public Fournisseur testretrieveStock(Fournisseur s) {
		Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));
		Fournisseur fournisseur1 = fournisseurservice.retrieveFournisseur((long)5);
		Assertions.assertNotNull(fournisseur1); 
		return fournisseur1;
		
	}
 
}