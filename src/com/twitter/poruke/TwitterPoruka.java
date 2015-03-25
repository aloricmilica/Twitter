package com.twitter.poruke;

/**
 * Predstavlja poruku na Twitter-u
 * 
 * @author Milica
 *
 */

public class TwitterPoruka {
	
	/**
	 * Nickname korisnika koji objavljuje poruku
	 */
	private String korisnik;
	
	/**
	 * Tekst poruke koja se objavljuje
	 */
	private String poruka;
	
	/**
	 * Metoda vraca nickname korisnika, tj. vrednost atributa korisnik
	 * @return nickname korisnika kao String
	 */
	public String getKorisnik() {
		return korisnik;
	}
	

	/**
	 * Metoda postavlja nickname korisnika na unetu vrednost
	 * @param korisnik novi nickname korisnika
	 * @throws java.lang.RuntimeException ako je uneti nickname korisnika  null ili prazan String
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik.equals(""))
			throw new RuntimeException("Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * Metoda vraca poruku korisnika, tj. vrednost atributa poruka
	 * @return poruku korisnika kao String
	 */
	public String getPoruka() {
		return poruka;
	}
	

	/**
	 * Metoda postavlja poruku korisnika na unetu vrednost
	 * @param poruka nova poruka korisnika
	 * @throws java.lang.RuntimeException ako je uneta poruka korisnika  null 
	 * ili je duzina poruke veca od 140 karaktera
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || poruka.length()>140)
			throw new RuntimeException("Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	public String toString(){
		return "KORISNIK:"+korisnik+" VREME:"+vreme.getTime()+" PORUKA:"+poruka;
	}
	
	
}



