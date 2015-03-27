package com.twitter;

import java.util.LinkedList;
import com.twitter.poruke.TwitterPoruka;

/**
 * Predstavlja drustvenu mrezu Twitter
 * @author Milica
 *
 */
public class Twitter {
	
	/**
	 * Lista svih poruka na Twitter-u 
	 */
	private LinkedList<TwitterPoruka> poruke =
			new LinkedList<TwitterPoruka>();
	
	/**
	 * Metoda vraca sve poruke na Twitter-u
	 * @return poruke na Twitter-u kao listu
	 */
	public LinkedList<TwitterPoruka> vratiSvePoruke(){
		return poruke;
	}
	
	/**
	 * Metoda kreira novu poruku na osnovu unetih podataka 
	 * i unosi je na kraj liste
	 * @param korisnik nickname korisnika
	 * @param poruka nova poruka koja se objavljuje od strane korisnika
	 */
	public void unesi(String korisnik, String poruka) {
		//Pravi se nova poruka i puni podacima.
		TwitterPoruka tp = new TwitterPoruka();
		tp.setKorisnik("korisnik");
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	/**
	 * Metoda koja vraca niz poruka na osnovu ulaznih parametara,
	 * vracaju se one poruke koje odgovaraju unetom tag-u
	 * pri cemu se pretraga prekida ako je prekoracen max br upisanih poruka
	 * @param maxBroj maksimalan broj upisanih poruka u niz
	 * @param tag kljucna rec po kojoj se vrsi pretraga poruka
	 * @return poruke koje sadrze dati tag u vidu niza
	 * @throws java.lang.RuntimeException ako je uneti tag
	 * <ul>
	 * <li> null </li>
	 * <li> prazan String </li>
	 * </ul>
	 */
	public TwitterPoruka[] vratiPoruke(int maxBroj, String tag) {
		if (tag==null || tag.isEmpty())
			throw new RuntimeException("Morate uneti tag");
		//Ako je maxBroj <=0, maxBroj se postavlja na 100 poruka
		if (maxBroj<=0)
			maxBroj = 100;
		//Pomocna promenljiva koja predstavlja brojac upisanih poruka
		int brojac = 0;
		//Pomocni niz koja predstavlja rezultat pretrage tj. sadrzace
		//sve poruke koje u sebi imaju zadati tag
		TwitterPoruka[] rezultat = new TwitterPoruka[maxBroj];
		//Pretrazuju se poruke i traze se one koje sadrze tag.
		//Ako se nadje neka takva, i ako nije prekoracen maxBroj
		//ona se upisuje u niz. Ako je prekoracen maxBroj,pretraga
		//se prekida.
		for (int i = 0; i < poruke.size(); i++)
			if (poruke.get(i).getPoruka().indexOf(tag)!=-1)
				if (brojac < maxBroj){
					rezultat[brojac+1]=poruke.get(i);
					brojac++;
				}
				else break;
		return rezultat;
		}
	
}



