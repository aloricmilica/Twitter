/**
 * 
 */
package com.twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Milica
 *
 */
public class TwitterTest {
	
	Twitter twitter;
	TwitterPoruka poruka;
    LinkedList<TwitterPoruka> pomocnaLista;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		twitter = new Twitter();
		poruka = new TwitterPoruka();
		pomocnaLista = new LinkedList<TwitterPoruka>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		twitter = null;
		poruka = null;
		pomocnaLista = null;
		
	}
	
	// uocen bug kod metode unesi - 
	// uvek postavlja atribut korisnik na
	// "korisnik", bez obzira na date parametre;
	// ispravljena metoda nakon sto je test pao
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
		public void testUnesi_Korisnik() { 
			twitter.unesi("NekiKorisnik", "Neka poruka");
			assertEquals("NekiKorisnik", twitter.vratiKorisnika());
	
		}
	

	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi() {
		poruka.setKorisnik("Nick");
		poruka.setPoruka("Neki novi twit");
		twitter.unesi(poruka.getKorisnik(), poruka.getPoruka());
		pomocnaLista.add(poruka);
		
		assertEquals(1, twitter.vratiSvePoruke().size());
		assertEquals(true, twitter.uporediListe(pomocnaLista));
		
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#unesi(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testUnesi2() {
		poruka.setKorisnik("Nick");
		poruka.setPoruka("Neki novi twit");
		twitter.unesi(poruka.getKorisnik(), poruka.getPoruka());
		pomocnaLista.add(poruka);
		TwitterPoruka poruka2 = new TwitterPoruka();
		poruka2.setKorisnik("Nick2");
		poruka2.setPoruka("Twit 2");
		twitter.unesi(poruka2.getKorisnik(), poruka2.getPoruka());
		pomocnaLista.add(poruka2);
		
		assertEquals(2, twitter.vratiSvePoruke().size());
		assertEquals(true, twitter.uporediListe(pomocnaLista));
		
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke_Prazna() {
		assertEquals(pomocnaLista, twitter.vratiSvePoruke());
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiSvePoruke()}.
	 */
	@Test
	public void testVratiSvePoruke_ImaPoruka() {
		poruka.setKorisnik("NekiNick");
		poruka.setPoruka("NekiTwit");
		pomocnaLista.add(poruka);
		twitter.unesi("NekiNick", "NekiTwit");
		
		assertEquals(true, twitter.uporediListe(pomocnaLista));
	}

	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke() {
		TwitterPoruka p1 = new TwitterPoruka();
		TwitterPoruka p2 = new TwitterPoruka();
		TwitterPoruka[] pomocniNiz = new TwitterPoruka[1];
		p1.setKorisnik("Nick1");
		p2.setKorisnik("Nick2");
		p1.setPoruka("Twit 1");
		p2.setPoruka("Twit 2");
		twitter.unesi(p1.getKorisnik(), p1.getPoruka());
		twitter.unesi(p2.getKorisnik(), p2.getPoruka());
		pomocniNiz[0] = p1;
		
		assertEquals(true, twitter.uporediNizove(pomocniNiz, twitter.vratiPoruke(1, "1")));
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPoruke_NullTag() {
		twitter.vratiPoruke(20, null);
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testVratiPoruke_PrazanStringTag() {
		twitter.vratiPoruke(20, "");
	}
	
	/**
	 * Test method for {@link com.twitter.Twitter#vratiPoruke(int, java.lang.String)}.
	 */
	@Test
	public void testVratiPoruke_MaxBrManjiOd0() {
		TwitterPoruka [] porukeSaTagom = twitter.vratiPoruke(-5, "neki tag");
		
		assertEquals(100,porukeSaTagom.length);
	}

}
