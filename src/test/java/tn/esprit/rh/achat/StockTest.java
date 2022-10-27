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

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;
import tn.esprit.rh.achat.services.StockServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StockTest {
	@Mock
	StockRepository stockRepository;
	@InjectMocks
	StockServiceImpl serviceImpl;
	
	Stock stock =  new Stock((long) 1,"libel", 22, 12,null);
	
	@Test
	public Stock testretrieveStock(Stock s) {
		Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
		Stock stock1 = serviceImpl.retrieveStock(stock.getIdStock());
		Assertions.assertNotNull(stock1); 
		return stock1;
		
	}
 
}