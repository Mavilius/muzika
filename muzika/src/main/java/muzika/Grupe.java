package muzika;

import java.util.List;

import javax.persistence.*;

@Entity
public class Grupe {
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;
	private String pavadinimas;
	private Integer ikurimas;
	private Integer nariai;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_grupes",referencedColumnName="id",insertable=false, updatable=false)
	private List<Albumas> albumas;  
	
	private String albumu_pavadinimai;
	
	public Grupe() {
		}
	
	public Grupe(String pavadinimas, Integer ikurimas, Integer nariai) {
		super();
		this.pavadinimas = pavadinimas;
		this.ikurimas = ikurimas;
		this.nariai = nariai;
	}
	public String albumuPavadinimai() {
		albumu_pavadinimai = "";
		String comma = "";
		for(Albumas albumas1:albumas) {
			albumu_pavadinimai += comma+ albumas1.getPavadinimas();
			comma = "\n";
		}
		return albumu_pavadinimai;
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getPavadinimas() {
		return pavadinimas;
	}
	public void setPavadinimas(String pavadinimas) {
		this.pavadinimas = pavadinimas;
	}
	public Integer getIkurimas() {
		return ikurimas;
	}
	public void setIkurimas(Integer ikurimas) {
		this.ikurimas = ikurimas;
	}
	public Integer getNariai() {
		return nariai;
	}
	public void setNariai(Integer nariai) {
		this.nariai = nariai;
	}
	public List<Albumas> getAlbumas() {
		return albumas;
	}
	public void setAlbumas(List<Albumas> albumas) {
		this.albumas = albumas;
	}
}
