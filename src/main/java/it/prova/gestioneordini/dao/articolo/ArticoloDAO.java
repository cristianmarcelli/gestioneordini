package it.prova.gestioneordini.dao.articolo;

import it.prova.gestioneordini.dao.IBaseDAO;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;

public interface ArticoloDAO extends IBaseDAO<Articolo> {

	public Articolo findByIdFetchingCategorie(Long id);

	// Voglio la somma totale di tutti i prezzi degli articoli legati ad una data
	// categoria in input
	public int countQuantiPrezziDegliArticoli(Categoria categoriaInput);

}