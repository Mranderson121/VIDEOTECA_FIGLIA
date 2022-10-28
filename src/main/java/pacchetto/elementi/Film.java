package pacchetto.elementi;

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

@Entity
@Table(name = "Film")
public class Film implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_film")
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_utente", nullable = false)
	private Utente utente;

	public List<Attore> getListaAttori() {
		return listaAttori;
	}

	public void setListaAttori(List<Attore> listaAttori) {
		this.listaAttori = listaAttori;
	}

	public Date getDatadiuscita() {
		return datadiuscita;
	}

	public void setDatadiuscita(Date  datadiuscita) {
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

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}