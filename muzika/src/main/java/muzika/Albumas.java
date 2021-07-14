package muzika;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Albumas {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private Integer id_grupes;
	private String pavadinimas;
	private Integer isleidimo_metai;
	private Integer kuriniu_kiekis;
	private String albumo_ilgis;
	
	@ManyToOne
	@JoinColumn(name="id_grupes", referencedColumnName="id", insertable=false, updatable=false)
	private Grupe grupe;
	
	public Albumas() {
		
	}
	
	public Albumas(Integer id_grupes, String pavadinimas, Integer isleidimo_metai, Integer kuriniu_kiekis, String albumo_ilgis) {
		super();
		this.id_grupes = id_grupes;
		this.pavadinimas = pavadinimas;
		this.isleidimo_metai = isleidimo_metai;
		this.kuriniu_kiekis = kuriniu_kiekis;
		this.albumo_ilgis = albumo_ilgis;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public Integer getId_grupes() {
		return id_grupes;
	}

	public void setId_grupes(Integer id_grupes) {
		this.id_grupes = id_grupes;
	}

	public String getPavadinimas() {
		return pavadinimas;
	}

	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}

	public Integer getIsleidimo_metai() {
		return isleidimo_metai;
	}

	public void setIsleidimo_metai(Integer isleidimo_metai) {
		this.isleidimo_metai = isleidimo_metai;
	}

	public Integer getKuriniu_kiekis() {
		return kuriniu_kiekis;
	}

	public void setKuriniu_kiekis(Integer kuriniu_kiekis) {
		this.kuriniu_kiekis = kuriniu_kiekis;
	}

	public String getAlbumo_ilgis() {
		return albumo_ilgis;
	}

	public void setAlbumo_ilgis(String albumo_ilgis) {
		this.albumo_ilgis = albumo_ilgis;
	}

	public Grupe getGrupe() {
		return grupe;
	}

	public void setGrupe(Grupe grupe) {
		this.grupe = grupe;
	}
}
