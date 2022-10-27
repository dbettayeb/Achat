package tn.esprit.rh.achat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.*;
import tn.esprit.rh.achat.repositories.*;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.services.IProduitService;
import tn.esprit.rh.achat.services.ISecteurActiviteService;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
	

	@Mock 
	ProduitRepository produitRepository ;
	@InjectMocks
	ProduitServiceImpl produitimpl ;
	Produit prod = new Produit ("ghada","yosra") ;
	
	@Test 
	public Produit testprod (Produit p) {
		Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(prod)) ;
		Produit pd = produitimpl.retrieveProduit(prod.getIdProduit());
		Assertions.assertNotNull(pd);
		return pd ;
	}
	
}
