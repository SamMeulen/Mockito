package be.vdab.services;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import be.vdab.repositories.KostRepository;
import be.vdab.repositories.OpbrengstRepository;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WinstRepositoryTest {
	WinstService winstservice;
	@Mock OpbrengstRepository opbrengstRepository;
	@Mock KostRepository kostRepository;
	

	@Before
	public void before() {
		when(opbrengstRepository.findTotaleOpbrengst()).thenReturn(BigDecimal.valueOf(1000));
		when(kostRepository.findTotaleKost()).thenReturn(BigDecimal.valueOf(500));
		winstservice = new WinstService(kostRepository, opbrengstRepository);
	}

	@Test
	public void getWinstKlopt() {
		assertEquals(0, BigDecimal.valueOf(500).compareTo(winstservice.getWinst()));
		verify(opbrengstRepository).findTotaleOpbrengst(); 
		verify(kostRepository).findTotaleKost();
	}
}
