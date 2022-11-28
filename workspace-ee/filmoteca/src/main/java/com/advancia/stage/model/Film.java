package com.advancia.stage.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "film")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "Film")
public class Film implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "datadiuscita")
	private Date datadiuscita;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "film_attore", joinColumns = { @JoinColumn(name = "id_film") }, inverseJoinColumns = {
			@JoinColumn(name = "id_attore") })
	private List<Attore> listaAttori;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_regista")
	private Regista regista;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "film_utente", joinColumns = { @JoinColumn(name = "id_film") }, inverseJoinColumns = {
			@JoinColumn(name = "id_utente") })
	private List<Utente> listaUtenti;

	public List<Attore> getListaAttori() {
		return listaAttori;
	}

	public void setListaAttori(List<Attore> listaAttori) {
		this.listaAttori = listaAttori;
	}

	public Date getDatadiuscita() {
		return datadiuscita;
	}

	public void setDatadiuscita(Date datadiuscita) {
		this.datadiuscita = datadiuscita;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Utente> getListaUtenti() {
		return listaUtenti;
	}

	public void setListaUtenti(List<Utente> listaUtenti) {
		this.listaUtenti = listaUtenti;
	}

	public Regista getRegista() {
		return regista;
	}

	public void setRegista(Regista regista) {
		this.regista = regista;
	}

}