package it.prova.gestioneordini.dao.ordine;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public class OrdineDAOImpl implements OrdineDAO {

	private EntityManager entityManager;

	@Override
	public List<Ordine> list() throws Exception {
		return entityManager.createQuery("from Ordine", Ordine.class).getResultList();
	}

	@Override
	public Ordine get(Long id) throws Exception {
		return entityManager.find(Ordine.class, id);
	}

	@Override
	public void update(Ordine input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		input = entityManager.merge(input);
	}

	@Override
	public void insert(Ordine input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.persist(input);
	}

	@Override
	public void delete(Ordine input) throws Exception {
		if (input == null) {
			throw new Exception("Problema valore in input");
		}
		entityManager.remove(entityManager.merge(input));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public Ordine findByIdFetchingArticoli(Long id) {
		TypedQuery<Ordine> query = entityManager.createQuery(
				"select o FROM Ordine o left join fetch o.articoli a where o.id = :idOrdine", Ordine.class);
		query.setParameter("idOrdine", id);
		return query.getResultList().stream().findFirst().orElse(null);
	}

	@Override
	public List<Ordine> findOrdiniByCategoria(Categoria categoriaInput) {
		Query queryDaRitornare = entityManager.createNativeQuery(
				"select o.nomedestinatario\r\n" + "from Ordine o, Articolo a, Categoria c, articolo_categoria x\r\n"
						+ "where o.id = a.ordine_id and a.id = x.articolo_id and c.id = x.categoria_id and c.id = ?1");
		queryDaRitornare.setParameter(1, categoriaInput);

		return queryDaRitornare.getResultList();
	}

	@Override
	public Ordine findOrdinePiuRecente(Categoria categoriaInput) {
		TypedQuery<Ordine> query = entityManager.createQuery(
				"select o from Ordine o join o.articoli a join a.categorie c where c.id = ?1 order by o.dataSpedizione desc",
				Ordine.class);
		return query.setParameter(1, categoriaInput.getId()).getResultList().get(0);
	}

	@Override
	public List<String> findAllIndirizziDiOrdiniConCheckNumeroSeriale(String numeroSerialeInput) {
		TypedQuery<String> query = entityManager.createQuery(
				"select o.indirizzo FROM Ordine o join o.articoli a where a.numeroSeriale like ?1", String.class);
		query.setParameter(1, "%" + numeroSerialeInput + "%");
		return query.getResultList();
	}
}
