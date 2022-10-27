package it.somnia.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "film")
public class Film {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Integer durata;
	private Integer anno;
	private String img;
	private String descrizione;
	private String regia;
	private String cast;
	private String genere;
	
	@Column(name = "eta_minima")
	private Integer etaMinima;
	@Column(name = "url_trailer")
	private String urlTrailer;
	private String condizione;
	
	@Column (name = "img_banner_1")
	private String imgBannerUno;
	@Column (name = "img_banner_2")
	private String imgBannerDue;
	@Column (name = "img_banner_3")
	private String imgBannerTre;
	
	@OneToMany(mappedBy = "film", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonManagedReference /* consente di vedere i film con tutte le proiezioni */
	private Set<Proiezione> proiezioni = new HashSet<Proiezione>();

	
	
	public Film() {
	}



	public Film(String nome, Integer durata, Integer anno, String img, String descrizione, String regia, String cast,
			String genere, Integer etaMinima, String urlTrailer, String condizione, String imgBannerUno,
			String imgBannerDue, String imgBannerTre, Set<Proiezione> proiezioni) {
		this.nome = nome;
		this.durata = durata;
		this.anno = anno;
		this.img = img;
		this.descrizione = descrizione;
		this.regia = regia;
		this.cast = cast;
		this.genere = genere;
		this.etaMinima = etaMinima;
		this.urlTrailer = urlTrailer;
		this.condizione = condizione;
		this.imgBannerUno = imgBannerUno;
		this.imgBannerDue = imgBannerDue;
		this.imgBannerTre = imgBannerTre;
		this.proiezioni = proiezioni;
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



	public Integer getDurata() {
		return durata;
	}



	public void setDurata(Integer durata) {
		this.durata = durata;
	}



	public Integer getAnno() {
		return anno;
	}



	public void setAnno(Integer anno) {
		this.anno = anno;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}



	public String getDescrizione() {
		return descrizione;
	}



	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}



	public String getRegia() {
		return regia;
	}



	public void setRegia(String regia) {
		this.regia = regia;
	}



	public String getCast() {
		return cast;
	}



	public void setCast(String cast) {
		this.cast = cast;
	}



	public String getGenere() {
		return genere;
	}



	public void setGenere(String genere) {
		this.genere = genere;
	}



	public Integer getEtaMinima() {
		return etaMinima;
	}



	public void setEtaMinima(Integer etaMinima) {
		this.etaMinima = etaMinima;
	}



	public String getUrlTrailer() {
		return urlTrailer;
	}



	public void setUrlTrailer(String urlTrailer) {
		this.urlTrailer = urlTrailer;
	}



	public String getCondizione() {
		return condizione;
	}



	public void setCondizione(String condizione) {
		this.condizione = condizione;
	}



	public String getImgBannerUno() {
		return imgBannerUno;
	}



	public void setImgBannerUno(String imgBannerUno) {
		this.imgBannerUno = imgBannerUno;
	}



	public String getImgBannerDue() {
		return imgBannerDue;
	}



	public void setImgBannerDue(String imgBannerDue) {
		this.imgBannerDue = imgBannerDue;
	}



	public String getImgBannerTre() {
		return imgBannerTre;
	}



	public void setImgBannerTre(String imgBannerTre) {
		this.imgBannerTre = imgBannerTre;
	}



	public Set<Proiezione> getProiezioni() {
		return proiezioni;
	}



	public void setProiezioni(Set<Proiezione> proiezioni) {
		this.proiezioni = proiezioni;
	}


	

	@Override
	public String toString() {
		return "Film [id=" + id + ", nome=" + nome + ", durata=" + durata + ", anno=" + anno + ", img=" + img
				+ ", descrizione=" + descrizione + ", regia=" + regia + ", cast=" + cast + ", genere=" + genere
				+ ", etaMinima=" + etaMinima + ", urlTrailer=" + urlTrailer + ", condizione=" + condizione
				+ ", imgBannerUno=" + imgBannerUno + ", imgBannerDue=" + imgBannerDue + ", imgBannerTre=" + imgBannerTre
				+ ", proiezioni=" + proiezioni + "]";
	}



	public void addProiezione(Proiezione proiezione) {
		proiezioni.add(proiezione);
	}
	
}
