package tn.esprit.rh.achat.services;

import static org.mockito.Mockito.lenient;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OperateurServiceImplTest {

	
	@Mock
	
	OperateurRepository operateurRepository;
	
	@InjectMocks
	OperateurServiceImpl OperateurService;

	
	Operateur op = new Operateur( 1L,"op" , "lastop" , "f465465df", null );
	


	@Test
	public void testRetrieveOp() {
	Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(op));
	Operateur op1 = OperateurService.retrieveOperateur(op.getIdOperateur());
	Assertions.assertNotNull(op1);
	}

	

}
