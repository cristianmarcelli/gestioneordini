package it.prova.gestioneordini.service;

import java.util.Date;
import java.util.List;

import it.prova.gestioneordini.dao.ordine.OrdineDAO;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public interface OrdineService {

	public List<Ordine> listAll() throws Exception;

	public Ordine caricaSingoloElemento(Long id) throws Exception;

	public Ordine caricaSingoloElementoEagerArticoli(Long id) throws Exception;

	public void aggiorna(Ordine ordineInstance) throws Exception;

	public void inserisciNuovo(Ordine ordineInstance) throws Exception;

	public void rimuovi(Long idOrdine) throws Exception;
	
	public void rimuoviArticoloDaOrdine(Ordine ordineInstance, Articolo articoloInstance) throws Exception;

	public List<Ordine> cercaOrdiniTramiteCategoria(Categoria categoriaInput) throws Exception;

	public Ordine cercaOrdinePiuRecente(Categoria categoriaInput) throws Exception;
	
	public List<String> cercaTuttiIndirizziDiOrdiniConCheckNumeroSeriale(String numeroSerialeInput) throws Exception;

	// per injection
	public void setOrdineDAO(OrdineDAO ordineDAO);

}