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
	
	
	//pomocna metoda koja vraca vrednost atributa korisnik na prvom mestu u listi
	public String vratiKorisnika() {
			return poruke.get(0).getKorisnik();
		}
	//pomocna metoda koja poredi pomocnu listu sa listom twitter poruka
	public boolean uporediListe(LinkedList<TwitterPoruka> pomocnaLista) {
		for (int i = 0; i < pomocnaLista.size(); i++) {
				if (pomocnaLista.get(i).getKorisnik().equals(poruke.get(i).getKorisnik())
					&& pomocnaLista.get(i).getPoruka().equals(poruke.get(i).getPoruka())) 
					return true;
			}
			return false;
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
		//metoda je izmenjena jer je uvek postavljala vrednost atributa korisnik na 
		//"korisnik" bez obzira na uneti parametar
		tp.setKorisnik(korisnik);
		tp.setPoruka(poruka);
		//Poruka se unosi u listu na kraj
		poruke.addLast(tp);
	}
	
	// pomocna metoda koja uporedjuje dva niza poruka
	public boolean uporediNizove(TwitterPoruka[] t1, TwitterPoruka[] t2) {
		for (int i = 0; i < t1.length; i++) {
			if (t1[i].getKorisnik().equals(t2[i].getKorisnik())
					&& t1[i].getPoruka().equals(t2[i].getPoruka())
					&& t1[i].getVreme().equals(t2[i].getVreme())) 
				return true;
			}
			return false;
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
					// ispravljena greska sa [brojac + 1] na [brojac]
					rezultat[brojac]=poruke.get(i);
					brojac++;
				}
				else break;
		return rezultat;
		}
	
	
}



