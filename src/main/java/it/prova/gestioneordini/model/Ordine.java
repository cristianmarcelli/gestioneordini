package it.prova.gestioneordini.model;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "ordine")
public class Ordine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "nomedestinatario")
	private String nomeDestinatario;
	@Column(name = "indirizzo")
	private String indirizzo;
	@Column(name = "dataspedizione")
	private Date dataSpedizione;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ordine")
	private Set<Articolo> articoli = new HashSet<>();

	@CreationTimestamp
	private LocalDateTime createDateTime;
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public Ordine() {
	}

	public Ordine(String nomeDestinatario, String indirizzo, Date dataSpedizione, Set<Articolo> articoli,
			LocalDateTime createDateTime, LocalDateTime updateDateTime) {
		super();
		this.nomeDestinatario = nomeDestinatario;
		this.indirizzo = indirizzo;
		this.dataSpedizione = dataSpedizione;
		this.articoli = articoli;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
	}

	public Ordine(String nomeDestinatario, String indirizzo, Date dataSpedizione, Set<Articolo> articoli) {
		super();
		this.nomeDestinatario = nomeDestinatario;
		this.indirizzo = indirizzo;
		this.dataSpedizione = dataSpedizione;
		this.articoli = articoli;
	}

	public Ordine(String nomeDestinatario, String indirizzo, Date dataSpedizione) {
		super();
		this.nomeDestinatario = nomeDestinatario;
		this.indirizzo = indirizzo;
		this.dataSpedizione = dataSpedizione;
	}

	public Ordine(Long id, String nomeDestinatario, String indirizzo, Date dataSpedizione, Set<Articolo> articoli,
			LocalDateTime createDateTime, LocalDateTime updateDateTime) {
		super();
		this.id = id;
		this.nomeDestinatario = nomeDestinatario;
		this.indirizzo = indirizzo;
		this.dataSpedizione = dataSpedizione;
		this.articoli = articoli;
		this.createDateTime = createDateTime;
		this.updateDateTime = updateDateTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Date getDataSpedizione() {
		return dataSpedizione;
	}

	public void setDataSpedizione(Date dataPubdataSpedizioneblicazione) {
		this.dataSpedizione = dataSpedizione;
	}

	public Set<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
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
		return "Ordine [id=" + id + ", nomeDestinatario=" + nomeDestinatario + ", indirizzo=" + indirizzo
				+ ", dataSpedizione=" + dataSpedizione + ", articoli=" + articoli + ", createDateTime="
				+ createDateTime + ", updateDateTime=" + updateDateTime + "]";
	}

}