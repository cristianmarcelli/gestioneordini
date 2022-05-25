package it.prova.gestioneordini.dao.ordine;

import java.util.List;

import it.prova.gestioneordini.dao.IBaseDAO;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public interface OrdineDAO extends IBaseDAO<Ordine> {
	
	public Ordine findByIdFetchingArticoli(Long id);
	
	public List<Ordine> findOrdiniByCategoria(Categoria categoriaInput);

}