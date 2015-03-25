/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Milica
 *
 */
public class TwitterPorukaTest {
	
	private TwitterPoruka twitterPoruka;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		twitterPoruka = new TwitterPoruka();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		twitterPoruka = null;
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test
	public void testSetKorisnik() {
		twitterPoruka.setKorisnik("mia943");
		
		assertEquals("mia943", twitterPoruka.getKorisnik());
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull() {
		twitterPoruka.setKorisnik(null);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikEmptyString() {
		twitterPoruka.setKorisnik("");
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setPoruka(java.lang.String)}.
	 */
	@Test
	public void testSetPoruka() {
		twitterPoruka.setPoruka("Zene vole jednostavne stvari tipa da im citas misli");
		
		assertEquals("Zene vole jednostavne stvari tipa da im citas misli", twitterPoruka.getPoruka());
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull() {
		twitterPoruka.setPoruka(null);
	}
	
	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#setKorisnik(java.lang.String)}.
	 */
	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaVelicina() {
		twitterPoruka.setPoruka("Paul Van Haver (born 12 March 1985), better known by his stage name Stromae, "
				+ "is a Belgian singer and songwriter. He has established himself in both the hip hop and electronic music genres. "
				+ "Stromae came to wide public attention with his song Alors on danse,"
		    	+ " which became a number one in several European countries. In 2013, his sophomore album Racine Carrée was a commercial success."
				+ " Stromae is known for his distinctive physique and clothing style. "
				+ "He has used this image in launching a limited fashion line, called Mosaert (an anagram of his stage name)."
				+ " The collection features bright colors and geometric patterns, and has been described as hipster and retro kitsch. "
				+ "Stromae has said that he wanted to create a bridge between British style and African aesthetic. "
				+ "The first collection was a success, with stocks almost sold out after three days. "
				+ "The newest collection, Capsule No. 2, was released at Colette in Paris on December 3rd 2014,"
				+ " and features the square root design on each item in different colors.");
	}

	/**
	 * Test method for {@link com.twitter.poruke.TwitterPoruka#toString()}.
	 */
	@Test
	public void testToString() {
		twitterPoruka.setKorisnik("mia943");
		twitterPoruka.setPoruka("Zene vole jednostavne stvari tipa da im citas misli");
		
		assertEquals("KORISNIK: mia943" + "VREME: " + new GregorianCalendar().getTime() +
				"PORUKA: Zene vole jednostavne stvari tipa da im citas misli",
				"KORISNIK: " + twitterPoruka.getKorisnik() +"VREME: " + twitterPoruka.getVreme().getTime() 
				+ "PORUKA: " + twitterPoruka.getPoruka());
	}

}
