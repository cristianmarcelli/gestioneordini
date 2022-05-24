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
	@Column(name = "datapubblicazione")
	private Date dataPubblicazione;
	@Column(name = "articoli")
	private Set<Articolo> articoli = new HashSet<Articolo>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "ordine")
	private Set<Articolo> abitanti = new HashSet<Articolo>();

	@CreationTimestamp
	private LocalDateTime createDateTime;
	@UpdateTimestamp
	private LocalDateTime updateDateTime;

	public Ordine() {
	}

	public Ordine(Long id, String nomeDestinatario, String indirizzo, Date dataPubblicazione, Set<Articolo> articoli,
			Set<Articolo> abitanti) {
		super();
		this.id = id;
		this.nomeDestinatario = nomeDestinatario;
		this.indirizzo = indirizzo;
		this.dataPubblicazione = dataPubblicazione;
		this.articoli = articoli;
		this.abitanti = abitanti;
	}

	public Ordine(Long id, String nomeDestinatario, String indirizzo, Date dataPubblicazione, Set<Articolo> articoli,
			Set<Articolo> abitanti, LocalDateTime createDateTime, LocalDateTime updateDateTime) {
		super();
		this.id = id;
		this.nomeDestinatario = nomeDestinatario;
		this.indirizzo = indirizzo;
		this.dataPubblicazione = dataPubblicazione;
		this.articoli = articoli;
		this.abitanti = abitanti;
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

	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}

	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}

	public Set<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(Set<Articolo> articoli) {
		this.articoli = articoli;
	}

	public Set<Articolo> getAbitanti() {
		return abitanti;
	}

	public void setAbitanti(Set<Articolo> abitanti) {
		this.abitanti = abitanti;
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
				+ ", dataPubblicazione=" + dataPubblicazione + ", articoli=" + articoli + ", abitanti=" + abitanti
				+ ", createDateTime=" + createDateTime + ", updateDateTime=" + updateDateTime + "]";
	}

}