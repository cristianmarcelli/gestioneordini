package it.prova.gestioneordini.test;

import it.prova.gestioneordini.dao.EntityManagerUtil;
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
//			System.out
//					.println("In tabella Articolo ci sono " + articoloServiceInstance.listAll().size() + " elementi.");
//			System.out.println(
//					"In tabella Categoria ci sono " + categoriaServiceInstance.listAll().size() + " elementi.");
//			System.out.println(
//					"**************************** inizio batteria di test ********************************************");
//			System.out.println(
//					"*************************************************************************************************");
//
//			
//			
//			
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
}