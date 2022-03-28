package no.hvl.dat107;

import no.hvl.dat107.dao.AnsattDAO;
import no.hvl.dat107.dao.ProsjektDAO;
import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Avdeling;
import no.hvl.dat107.entity.Prosjekt;
import java.math.BigDecimal;
import java.time.Month;
import java.util.List;
import java.time.LocalDate;

import no.hvl.dat107.dao.AnsattDAO;
import no.hvl.dat107.dao.AvdelingDAO;
import no.hvl.dat107.dao.ProsjektDAO;
import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Prosjekt;

public class Main {


			private static AnsattDAO ansattdao = new AnsattDAO();
			private static ProsjektDAO prosjektdao = new ProsjektDAO();
			private static AvdelingDAO avdelingdao = new AvdelingDAO();
			

			public static void main(String[] args) {
				
				//Ting som må gjøres i main.
				//Hente ut og skrive ut ein ansatt på skjermen.
				
				//Søke etter ansatt på id.
				Ansatt b1=ansattdao.finnAnsattMedId(2);
				b1.skrivUt();
				//Søke etter ansatt med brukernavn
				Ansatt b2=ansattdao.finnAnsattMedBrukernavn("arn");
				b2.skrivUt();
				//Utliste alle ansatte
				List<Ansatt> b3 = ansattdao.finnAlleAnsatte();
				skrivUte("Alle ansatte");
				//Oppdatere ansatt sin stilling/lønn og skrive dei ut på nytt 
				System.out.println();
				System.out.println("Forandre stilling til Britt");
				b1.setStilling("Administrator");
				b1.skrivUt();
				
				//Oprette ein ny ansatt å skrive han ut på skjermen
				System.out.println();
				System.out.println("Oprette bruker å skrive han ut");
				ansattdao.leggTilNyAnsatt(new Ansatt("pet", "Petter", "Janus", LocalDate.of(2022, Month.MARCH, 1),
						"IT konsulent", new BigDecimal("23020"), 1));
				Ansatt b4 = ansattdao.finnAnsattMedId(6);
				b4.skrivUt();
				//Finn avdeling med id, og skriv han ut på skjrmen
				System.out.println();
				System.out.println("Finne ein avdeling å skrive han ut på skjermen");
				Avdeling a1 =avdelingdao.finnAvdelingMedId(2);
				a1.skrivUt();
				
				
				System.out.println();
				System.out.println("Oppgavene heretter er ikkje obligatorisk å fullføre");
				System.out.println();
				
				ansattdao.leggTilNyAnsatt(new Ansatt("per", "Perkor", "Janus", LocalDate.of(2022, Month.MARCH, 1),
						"IT konsulent", new BigDecimal("23020"), 1));
				System.out.println("Oppretta bruker Perkor");
				
				Ansatt z1 = ansattdao.finnAnsattMedId(7);
				z1.skrivUt();
				System.out.println("Sjekker at Perkor ikkje har nokre prosjekter");
				
				z1.skrivUtMedProsjekter();
				Prosjekt p1 = prosjektdao.finnProsjektMedId(2);
				System.out.println("Legger Perkor til i eit prosjekt:");
				
				ansattdao.registrerProsjektdeltagelse(z1, p1);
				z1.skrivUtMedProsjekter();
				System.out.println(":  Ser at han ikkje har noko timar i prosjektet så han kan fjernest fra prosjektet");
				
				ansattdao.slettProsjektdeltagelse(z1, p1);
				//Ansatt z3 = ansattdao.finnAnsattMedBrukernavn("per");
				z1.skrivUtMedProsjekter();
				//ansattdao.sletteAnsatt(z3.getId());

				AnsattDAO ansattDAO = new AnsattDAO();
				ProsjektDAO prosjektDAO = new ProsjektDAO();

				Ansatt a2 = ansattDAO.finnAnsattMedId(2);
				a2.skrivUtMedProsjekter();
				a2.skrivUt();

				Prosjekt p2 = prosjektDAO.finnProsjektMedId(2);
				p2.skrivUtMedAnsatte();

				Prosjekt p3 = prosjektDAO.finnProsjektMedId(1);
				p3.skrivUtMedAnsatte();

				ansattDAO.registrerProsjektdeltagelse(a2, p3);
				a2 = ansattDAO.finnAnsattMedId(2);
				p3 = prosjektDAO.finnProsjektMedId(3);
				a2.skrivUtMedProsjekter();
				p3.skrivUtMedAnsatte();

				ansattDAO.slettProsjektdeltagelse(a2, p3);
				a2 = ansattDAO.finnAnsattMedId(2);
				p3 = prosjektDAO.finnProsjektMedId(3);
				a2.skrivUtMedProsjekter();
				p3.skrivUtMedAnsatte();

				a2.skrivUt();

			}

//		    private static void skrivUt(String tekst) {
//				List<Ansatt> personer = AnsattDAO.finnAlleAnsatte();
//				System.out.println("\n--- "+ tekst +" ---");
//				personer.forEach(System.out::println);		
//			}

			private static void skrivUte(String tekst) {
				List<Ansatt> personer = ansattdao.finnAlleAnsatte();
				System.out.println("\n--- " + tekst + " ---");
				personer.forEach(System.out::println);
			}

		

        
        

	}
