package it.prova.gestioneordini.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "articolo")
public class Articolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizione")
	private String descrizione;
	@Column(name = "numeroseriale")
	private String numeroSeriale;
	@Column(name = "prezzosingolo")
	private int prezzoSingolo;
	@Column(name = "datainserimento")
	private Date dataInserimento;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, fetch = FetchType.LAZY)
	@JoinTable(name = "articolo_categoria", joinColumns = @JoinColumn(name = "articolo_id", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "categoria_id", referencedColumnName = "ID"))
	private Set<Categoria> categorie = new HashSet<Categoria>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ordine_id")
	private Ordine ordine;

	@CreationTimestamp
	private LocalDateTime createDateTime;
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public Articolo() {
	}

	public Articolo(Long id, String descrizione, String numeroSeriale, int prezzoSingolo, Date dataInserimento,
			Set<Categoria> categorie, Ordine ordine) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.numeroSeriale = numeroSeriale;
		this.prezzoSingolo = prezzoSingolo;
		this.dataInserimento = dataInserimento;
		this.categorie = categorie;
		this.ordine = ordine;
	}

	public Articolo(Long id, String descrizione, String numeroSeriale, int prezzoSingolo, Date dataInserimento,
			Set<Categoria> categorie, Ordine ordine, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.numeroSeriale = numeroSeriale;
		this.prezzoSingolo = prezzoSingolo;
		this.dataInserimento = dataInserimento;
		this.categorie = categorie;
		this.ordine = ordine;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getNumeroSeriale() {
		return numeroSeriale;
	}

	public void setNumeroSeriale(String numeroSeriale) {
		this.numeroSeriale = numeroSeriale;
	}

	public int getPrezzoSingolo() {
		return prezzoSingolo;
	}

	public void setPrezzoSingolo(int prezzoSingolo) {
		this.prezzoSingolo = prezzoSingolo;
	}

	public Date getDataInserimento() {
		return dataInserimento;
	}

	public void setDataInserimento(Date dataInserimento) {
		this.dataInserimento = dataInserimento;
	}

	public Set<Categoria> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categoria> categorie) {
		this.categorie = categorie;
	}

	public Ordine getOrdine() {
		return ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public LocalDateTime getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(LocalDateTime updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	@Override
	public String toString() {
		return "Articolo [id=" + id + ", descrizione=" + descrizione + ", numeroSeriale=" + numeroSeriale
				+ ", prezzoSingolo=" + prezzoSingolo + ", dataInserimento=" + dataInserimento + ", categorie="
				+ categorie + ", ordine=" + ordine + ", createDateTime=" + createDateTime + ", updateDateTime="
				+ updateDateTime + "]";
	}

}