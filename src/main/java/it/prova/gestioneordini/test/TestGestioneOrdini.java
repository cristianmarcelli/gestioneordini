package it.prova.gestioneordini.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import it.prova.gestioneordini.dao.EntityManagerUtil;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;
import it.prova.gestioneordini.service.ArticoloService;
import it.prova.gestioneordini.service.CategoriaService;
import it.prova.gestioneordini.service.MyServiceFactory;
import it.prova.gestioneordini.service.OrdineService;

public class TestGestioneOrdini {
	public static void main(String[] args) {

		OrdineService ordineServiceInstance = MyServiceFactory.getOrdineServiceInstance();
		ArticoloService articoloServiceInstance = MyServiceFactory.getArticoloServiceInstance();
		CategoriaService categoriaServiceInstance = MyServiceFactory.getCategoriaServiceInstance();

		try {

			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi.");
			System.out
					.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi.");
			System.out.println(
					"In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi.");
			System.out.println(
					"**************************** inizio batteria di test ********************************************");
			System.out.println(
					"*************************************************************************************************");

//			testInserimentoNuovoOrdine(ordineServiceInstance);

//			testAggiornaOrdine(ordineServiceInstance);


			// *******************************************
			testRimozioneOrdine(ordineServiceInstance);
			// *******************************************


			System.out.println(
					"****************************** fine batteria di test ********************************************");
			System.out.println(
					"*************************************************************************************************");
			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi.");
			System.out
					.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi.");
			System.out.println(
					"In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi.");

		} catch (Throwable e) {
			e.printStackTrace();
		} finally {
			EntityManagerUtil.shutdown();
		}

	}

	private static void testInserimentoNuovoOrdine(OrdineService ordineServiceInstance) throws Exception {
		System.out.println(".......testInserimentoNuovoOrdine inizio.............");

		Date dataPubblicazioneOrdine = new SimpleDateFormat("dd/MM/yyyy").parse("24/09/2019");

		Ordine ordineInstance = new Ordine("Valerio Ma", "Roma - Via Italia, 43", dataPubblicazioneOrdine);
		ordineServiceInstance.inserisciNuovo(ordineInstance);
		if (ordineInstance.getId() == null)
			throw new RuntimeException("testInserimentoNuovoArticolo fallito ");

		System.out.println(".......testInserimentoNuovoOrdine fine: PASSED.............");
	}

	private static void testAggiornaOrdine(OrdineService ordineServiceInstance) throws Exception {
		System.out.println(".......testInserimentoNuovoOrdine inizio.............");

		Date dataPubblicazioneOrdine = new SimpleDateFormat("dd/MM/yyyy").parse("24/09/2019");

		Ordine ordineInstance = new Ordine("Valerio Ma", "Roma - Via Italia, 43", dataPubblicazioneOrdine);
		ordineServiceInstance.inserisciNuovo(ordineInstance);
		if (ordineInstance.getId() == null)
			throw new RuntimeException("testInserimentoNuovoArticolo fallito ");

		ordineInstance.setNomeDestinatario("Saverio Sa");
		ordineServiceInstance.aggiorna(ordineInstance);

		System.out.println(".......testInserimentoNuovoOrdine fine: PASSED.............");
	}



	private static void testRimozioneOrdine(OrdineService ordineServiceInstance) throws Exception {
		Date dataPubblicazioneOrdine = new SimpleDateFormat("dd/MM/yyyy").parse("17/01/2015");

		Ordine ordineInstance = new Ordine("Annamaria Frasco", "Milano - Via dei baveri, 8", dataPubblicazioneOrdine);
		ordineServiceInstance.inserisciNuovo(ordineInstance);
		
		ordineServiceInstance.rimuovi(ordineInstance.getId());
	}

}