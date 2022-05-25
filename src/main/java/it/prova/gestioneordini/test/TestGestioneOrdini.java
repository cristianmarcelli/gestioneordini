package it.prova.gestioneordini.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.management.RuntimeErrorException;

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

//			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi.");
//			System.out
//					.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi.");
//			System.out.println(
//					"In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi.");
//			System.out.println(
//					"**************************** inizio batteria di test ********************************************");
//			System.out.println(
//					"*************************************************************************************************");

//			testInserimentoNuovoOrdine(ordineServiceInstance);

//			testAggiornaOrdine(ordineServiceInstance);

//			testCollegaArticoloAdOrdine(ordineServiceInstance, articoloServiceInstance);

//			testRimozioneOrdine(ordineServiceInstance);

//			testRimuoviArticoloDaOrdine(ordineServiceInstance, articoloServiceInstance);

//			testAggiungiArticoloACategoria(articoloServiceInstance, categoriaServiceInstance, ordineServiceInstance);

//			testAggiungiCategoriaAdArticolo(categoriaServiceInstance, articoloServiceInstance, ordineServiceInstance);

//			testCercaOrdiniTramiteCategoria(categoriaServiceInstance, ordineServiceInstance);

//			testCercaTutteLeCategorieDegliArticoli(categoriaServiceInstance, ordineServiceInstance);

//			testSommaPrezziDiArticoliTramiteCategoria(articoloServiceInstance, categoriaServiceInstance);

//			testCercaOrdinePiuRecente(ordineServiceInstance, categoriaServiceInstance, articoloServiceInstance);

//			testCercaTuttiICodiciDiCategorieDiOrdiniEffettuatiAFebbraioDuemilaventidue(ordineServiceInstance,
//					categoriaServiceInstance, articoloServiceInstance);

//			testCercaTuttiIndirizziDiOrdiniConCheckNumeroSeriale(ordineServiceInstance, articoloServiceInstance,
//					categoriaServiceInstance);

//			testRimozioneOrdineConArticoliAssociati(ordineServiceInstance, articoloServiceInstance, categoriaServiceInstance);
			
			testSommaPrezziDegliArticoliConDestinatarioMarioRossi(ordineServiceInstance, articoloServiceInstance, categoriaServiceInstance);

//			System.out.println(
//					"****************************** fine batteria di test ********************************************");
//			System.out.println(
//					"*************************************************************************************************");
//			System.out.println("In tabella Ordine ci sono " + ordineServiceInstance.listAll().size() + " elementi.");
//			System.out
//					.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi.");
//			System.out.println(
//					"In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi.");

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
		System.out.println(".......testRimozioneOrdine inizio.............");

		Date dataPubblicazioneOrdine = new SimpleDateFormat("dd/MM/yyyy").parse("17/01/2015");

		Ordine ordineInstance = new Ordine("Annamaria Frasco", "Milano - Via dei baveri, 8", dataPubblicazioneOrdine);
		ordineServiceInstance.inserisciNuovo(ordineInstance);

		ordineServiceInstance.rimuovi(ordineInstance.getId());
		System.out.println(".......testRimozioneOrdine fine: PASSED.............");
	}

	private static void testRimozioneOrdineConArticoliAssociati(OrdineService ordineServiceInstance,
			ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println(".......testRimozioneOrdineConArticoliAssociati inizio.............");

		// Creo ordine
		Date dataPubblicazioneOrdine = new SimpleDateFormat("dd/MM/yyyy").parse("26/02/2021");

		Ordine ordineInstance = new Ordine("Michele Bruni", "Napoli - Via Gambero, 12", dataPubblicazioneOrdine);
		ordineServiceInstance.inserisciNuovo(ordineInstance);

		// Creo la categoria
		Categoria categoriaInstance = new Categoria("Svago", "JKFJASD99999999");

		// Creo il mio articolo
		Date dataInserimentoArticolo = new SimpleDateFormat("dd/MM/yyyy").parse("10/02/2019");
		Articolo articoloDaAggiungere = new Articolo("Pallone da calcio", "LLL909090", 12, dataInserimentoArticolo);

		categoriaServiceInstance.inserisciNuovo(categoriaInstance);
		articoloDaAggiungere.setOrdine(ordineInstance);
		articoloServiceInstance.inserisciNuovo(articoloDaAggiungere);

		// collego
		categoriaServiceInstance.aggiungiArticolo(categoriaInstance, articoloDaAggiungere);

		ordineServiceInstance.rimuovi(ordineInstance.getId());
		System.out.println(".......testRimozioneOrdineConArticoliAssociati fine: PASSED.............");
	}

	private static void testCollegaArticoloAdOrdine(OrdineService ordineServiceInstance,
			ArticoloService articoloServiceInstance) throws Exception {
		System.out.println(".......testAggiungiArticoloAdOrdine inizio.............");

		// Creo ordine
		Date dataPubblicazioneOrdine = new SimpleDateFormat("dd/MM/yyyy").parse("17/01/2019");

		Ordine ordineInstance = new Ordine("Annalisa Birotti", "Firenze - Via Libia, 52", dataPubblicazioneOrdine);

		// Creo articolo
		Date dataInserimentoArticolo = new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2017");
		Articolo articoloDaAggiungere = new Articolo("fumetto vintage", "GFK7238", 56, dataInserimentoArticolo);

		// Inserisco e collego tutto
		articoloDaAggiungere.setOrdine(ordineInstance);
		ordineServiceInstance.inserisciNuovo(ordineInstance);
		articoloServiceInstance.inserisciNuovo(articoloDaAggiungere);

		if (articoloDaAggiungere.getId() == 0 | ordineInstance.getId() == 0) {
			throw new RuntimeException("Impossibile inserire, articolo o ordine mancante");
		}

		System.out.println(".......testAggiungiArticoloAdOrdine fine.............");
	}

	private static void testRimuoviArticoloDaOrdine(OrdineService ordineServiceInstance,
			ArticoloService articoloServiceInstance) throws Exception {
		System.out.println(".......testRimuoviArticoloDaOrdine inizio.............");

		// Mi prendo l articolo creato prima
		Articolo daDissociare = articoloServiceInstance.caricaSingoloElemento(1L);

		// e l ordine creato prima e li dissocio
		Ordine ordineMaster = ordineServiceInstance.caricaSingoloElemento(1L);

		ordineServiceInstance.rimuoviArticoloDaOrdine(ordineMaster, daDissociare);

		System.out.println(".......testRimuoviArticoloDaOrdine fine: PASSED .............");
	}

	private static void testAggiungiArticoloACategoria(ArticoloService articoloServiceInstance,
			CategoriaService categoriaServiceInstance, OrdineService ordineServiceInstance) throws Exception {

		// Creo ordine
		Date dataPubblicazioneOrdine = new SimpleDateFormat("dd/MM/yyyy").parse("17/01/2019");

		Ordine ordineInstance = new Ordine("Alessio Franchetti", "Modena - Via Albero, 87", dataPubblicazioneOrdine);
		ordineServiceInstance.inserisciNuovo(ordineInstance);

		// Creo la categoria
		Categoria categoriaInstance = new Categoria("Intr", "intrattenimento");

		// Creo il mio articolo
		Date dataInserimentoArticolo = new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2014");
		Articolo articoloDaAggiungere = new Articolo("fumetto vintage", "GFK7238", 56, dataInserimentoArticolo);

		categoriaServiceInstance.inserisciNuovo(categoriaInstance);
		articoloDaAggiungere.setOrdine(ordineInstance);
		articoloServiceInstance.inserisciNuovo(articoloDaAggiungere);

		// collego
		categoriaServiceInstance.aggiungiArticolo(categoriaInstance, articoloDaAggiungere);
	}

	private static void testAggiungiCategoriaAdArticolo(CategoriaService categoriaServiceInstance,
			ArticoloService articoloServiceInstance, OrdineService ordineServiceInstance) throws Exception {
		// Creo ordine
		Date dataPubblicazioneOrdine = new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2018");

		Ordine ordineInstance = new Ordine("Brando Balenziani", "Potenza - Via Carlo Alberti, 90",
				dataPubblicazioneOrdine);
		ordineServiceInstance.inserisciNuovo(ordineInstance);

		// Creo la categoria
		Categoria categoriaInstance = new Categoria("Intr", "intrattenimento");

		// Creo il mio articolo
		Date dataInserimentoArticolo = new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2014");
		Articolo articoloDaAggiungere = new Articolo("tastiera rgb", "BNDKL729", 26, dataInserimentoArticolo);

		categoriaServiceInstance.inserisciNuovo(categoriaInstance);
		articoloDaAggiungere.setOrdine(ordineInstance);
		articoloServiceInstance.inserisciNuovo(articoloDaAggiungere);

		// collego
		articoloServiceInstance.aggiungiCategoria(articoloDaAggiungere, categoriaInstance);
	}

	public static void testCercaOrdiniTramiteCategoria(CategoriaService categoriaServiceInstance,
			OrdineService ordineServiceInstance) throws Exception {
		System.out.println(".......testCercaOrdiniTramiteCategoria inizio.............");

		// Creo la categoria
		Categoria categoriaDaRicercare = categoriaServiceInstance.listAll().get(4);

		if (categoriaDaRicercare.getId() == 0) {
			throw new RuntimeException("Categoria non trovata");
		}

		System.out.println(ordineServiceInstance.cercaOrdiniTramiteCategoria(categoriaDaRicercare));

		System.out.println(".......testCercaOrdiniTramiteCategoria fine: PASSED.............");
	}

	public static void testCercaTutteLeCategorieDegliArticoli(CategoriaService categoriaServiceInstance,
			OrdineService ordineServiceInstance) throws Exception {
		System.out.println(".......testCercaOrdiniTramiteCategoria inizio.............");

		// Creo l'ordine
		Ordine ordineDaRicercare = ordineServiceInstance.listAll().get(18);

		if (ordineDaRicercare.getId() == 0) {
			throw new RuntimeException("Ordine non trovato");
		}

		System.out.println(categoriaServiceInstance.cercaTutteLeCategorieDegliArticoli(ordineDaRicercare));

		System.out.println(".......testCercaOrdiniTramiteCategoria fine: PASSED.............");
	}

	public static void testSommaPrezziDiArticoliTramiteCategoria(ArticoloService articoloServiceInstance,
			CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println(".......testSommaPrezziDiArticoliTramiteCategoria inizio.............");

		// Creo la categoria
		Categoria categoriaDaRicercare = categoriaServiceInstance.listAll().get(4);

		if (categoriaDaRicercare.getId() == 0) {
			throw new RuntimeException("Categoria non trovata");
		}

		System.out.println(articoloServiceInstance.sommaDeiPrezziDiArticoliTramiteCategoria(categoriaDaRicercare));

		System.out.println(".......testSommaPrezziDiArticoliTramiteCategoria fine: PASSED.............");
	}

//	public static void testCercaOrdinePiuRecente(OrdineService ordineServiceInstance,
//			CategoriaService categoriaServiceInstance, ArticoloService articoloServiceInstance) throws Exception {
//		System.out.println(".......testCercaOrdinePiuRecente inizio.............");
//
//		// Creo ordine
//		Date dataPubblicazioneOrdine = new SimpleDateFormat("dd/MM/yyyy").parse("01/02/2018");
//
//		Ordine ordineInstance = new Ordine("Andrea Saleri", "Catanzaro - Via Roma, 76", dataPubblicazioneOrdine);
//		ordineServiceInstance.inserisciNuovo(ordineInstance);
//
//		// Creo la categoria
//		Categoria categoriaInstance = new Categoria("Intr", "intrattenimento");
//
//		// Creo il mio articolo
//		Date dataInserimentoArticolo = new SimpleDateFormat("dd/MM/yyyy").parse("09/06/2014");
//		Articolo articoloDaAggiungere = new Articolo("tastiera rgb", "BNDKL729", 26, dataInserimentoArticolo);
//
//		categoriaServiceInstance.inserisciNuovo(categoriaInstance);
//		articoloDaAggiungere.setOrdine(ordineInstance);
//		articoloServiceInstance.inserisciNuovo(articoloDaAggiungere);
//
//		// collego
//		articoloServiceInstance.aggiungiCategoria(articoloDaAggiungere, categoriaInstance);
//
//		System.out.println(ordineServiceInstance.cercaOrdinePiuRecente(categoriaDaRicercare));
//
//		System.out.println(".......testCercaOrdinePiuRecente fine: PASSED.............");
//	}

	public static void testCercaTuttiICodiciDiCategorieDiOrdiniEffettuatiAFebbraioDuemilaventidue(
			OrdineService ordineServiceInstance, CategoriaService categoriaServiceInstance,
			ArticoloService articoloServiceInstance) throws Exception {
		System.out.println(
				".......testCercaTuttiICodiciDiCategorieDiOrdiniEffettuatiAFebbraioDuemilaventidue inizio.............");

		// Creo ordine
		Date dataPubblicazioneOrdine = new SimpleDateFormat("dd/MM/yyyy").parse("26/02/2022");

		Ordine ordineInstance = new Ordine("Carlo Baronetti", "Perugia - Via Firenze, 22", dataPubblicazioneOrdine);
		ordineServiceInstance.inserisciNuovo(ordineInstance);

		// Creo la categoria
		Categoria categoriaInstance = new Categoria("PPPPPOOOO", "Intrattenimento videoludico");

		// Creo il mio articolo
		Date dataInserimentoArticolo = new SimpleDateFormat("dd/MM/yyyy").parse("10/02/2022");
		Articolo articoloDaAggiungere = new Articolo("Videogioco sparatutto", "NVKDM88", 80, dataInserimentoArticolo);

		categoriaServiceInstance.inserisciNuovo(categoriaInstance);
		articoloDaAggiungere.setOrdine(ordineInstance);
		articoloServiceInstance.inserisciNuovo(articoloDaAggiungere);

		// collego
		categoriaServiceInstance.aggiungiArticolo(categoriaInstance, articoloDaAggiungere);

		System.out.println(
				categoriaServiceInstance.cercaTuttiICodiciDiCategorieDiOrdiniEffettuatiAFebbraioDuemilaventidue());

		System.out.println(
				".......testCercaTuttiICodiciDiCategorieDiOrdiniEffettuatiAFebbraioDuemilaventidue fine: PASSED.............");
	}

	public static void testCercaTuttiIndirizziDiOrdiniConCheckNumeroSeriale(OrdineService ordineServiceInstance,
			ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println(".......testCercaTuttiIndirizziDiOrdiniConCheckNumeroSeriale inizio.............");

		// Creo ordine
		Date dataPubblicazioneOrdine = new SimpleDateFormat("dd/MM/yyyy").parse("26/02/2022");

		Ordine ordineInstance = new Ordine("Carlo Baronetti", "Perugia - Via Firenze, 22", dataPubblicazioneOrdine);
		ordineServiceInstance.inserisciNuovo(ordineInstance);

		// Creo la categoria
		Categoria categoriaInstance = new Categoria("PPPPPOOOO", "Intrattenimento videoludico");

		// Creo il mio articolo
		Date dataInserimentoArticolo = new SimpleDateFormat("dd/MM/yyyy").parse("10/02/2022");
		Articolo articoloDaAggiungere = new Articolo("Videogioco sparatutto", "NVKDM88", 80, dataInserimentoArticolo);

		categoriaServiceInstance.inserisciNuovo(categoriaInstance);
		articoloDaAggiungere.setOrdine(ordineInstance);
		articoloServiceInstance.inserisciNuovo(articoloDaAggiungere);

		// collego
		categoriaServiceInstance.aggiungiArticolo(categoriaInstance, articoloDaAggiungere);

		System.out.println(ordineServiceInstance.cercaTuttiIndirizziDiOrdiniConCheckNumeroSeriale("NVK"));

		System.out.println(".......testCercaTuttiIndirizziDiOrdiniConCheckNumeroSeriale fine: PASSED.............");
	}

	public static void testSommaPrezziDegliArticoliConDestinatarioMarioRossi(OrdineService ordineServiceInstance,
			ArticoloService articoloServiceInstance, CategoriaService categoriaServiceInstance) throws Exception {
		System.out.println(".......testSommaPrezziDegliArticoliConDestinatarioMarioRossi inizio:.............");
		// Creo ordine
		Date dataPubblicazioneOrdine = new SimpleDateFormat("dd/MM/yyyy").parse("26/02/2021");

		Ordine ordineInstance = new Ordine("Mario Rossi", "Otranto - Via Liguria, 54", dataPubblicazioneOrdine);
		ordineServiceInstance.inserisciNuovo(ordineInstance);

		// Creo la categoria
		Categoria categoriaInstance = new Categoria("Intrattenimento", "HHHH790");

		// Creo il mio articolo
		Date dataInserimentoArticolo = new SimpleDateFormat("dd/MM/yyyy").parse("10/02/2021");
		Articolo articoloDaAggiungere = new Articolo("Videogioco sparatutto", "NVKDM88", 80, dataInserimentoArticolo);
		
		Date dataInserimentoArticolo2 = new SimpleDateFormat("dd/MM/yyyy").parse("10/02/2022");
		Articolo articoloDaAggiungere2 = new Articolo("Modellino nave", "JDFL78", 50, dataInserimentoArticolo);

		categoriaServiceInstance.inserisciNuovo(categoriaInstance);
		articoloDaAggiungere.setOrdine(ordineInstance);
		articoloDaAggiungere2.setOrdine(ordineInstance);
		articoloServiceInstance.inserisciNuovo(articoloDaAggiungere);
		articoloServiceInstance.inserisciNuovo(articoloDaAggiungere2);

		// collego
		categoriaServiceInstance.aggiungiArticolo(categoriaInstance, articoloDaAggiungere);
		categoriaServiceInstance.aggiungiArticolo(categoriaInstance, articoloDaAggiungere2);
		
		System.out.println(articoloServiceInstance.sommaPrezziDegliArticoliConDestinatarioMarioRossi());
		
		System.out.println(".......testCercaTuttiIndirizziDiOrdiniConCheckNumeroSeriale fine: PASSED.............");
	}

}