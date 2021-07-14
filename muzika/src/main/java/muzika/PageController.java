package muzika;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	
	@Autowired
	private GrupeRepository grupe_repository;
	@Autowired
	private AlbumasRepository albumas_repository;
	
	@RequestMapping(path="/", method={ RequestMethod.GET, RequestMethod.POST })
	public String skaitymas(@RequestParam(name="pavadinimas", required=true, defaultValue="-") String pavadinimas,
							@RequestParam(name="ikurimas", required=true, defaultValue="-") String ikurimas,
							@RequestParam(name="nariai", required=true, defaultValue="-") String nariai,				
							@RequestParam(name="send", required=true, defaultValue="-") String send,
			Model model) throws IOException {
		
		if(send != null && send.equals("Siųsti")) {
			
			Grupe grupe = new Grupe(pavadinimas
									, Integer.parseInt(ikurimas)
									, Integer.parseInt(nariai)
									);
			
			grupe = grupe_repository.save(grupe);		
			
			return "redirect:albumas?id_grupes="+grupe.getId();		
		}
		
		Iterable<Grupe> grupes_visos = grupe_repository.findAll();
		
		model.addAttribute ( "grupes", grupes_visos );
		
		return "Grupe";
	}
	@RequestMapping(path="/albumas", method={ RequestMethod.GET, RequestMethod.POST })
	public String skaitymas(@RequestParam(name="id_grupes", required=true, defaultValue="-") String id_grupes,
							@RequestParam(name="pavadinimas", required=true, defaultValue="-") String pavadinimas,
							@RequestParam(name="isleidimo_metai", required=true, defaultValue="-") String isleidimo_metai,				
							@RequestParam(name="kuriniu_kiekis", required=true, defaultValue="-") String kuriniu_kiekis,
							@RequestParam(name="albumo_ilgis", required=true, defaultValue="-") String albumo_ilgis,
							@RequestParam(name="send", required=true, defaultValue="-") String send,
			Model model) throws IOException {
		
			ArrayList<String> klaidos = new ArrayList<String>();
			
		if(send != null && send.equals("Siųsti")) {
			
			boolean yra_klaidu = false;
			if(!arPavadinimas(pavadinimas)) {
				yra_klaidu = true;
				klaidos.add("pavadinimas turi buti sudarytas tik is Lotynisku abeceles simboliu");
			}
			if(!yra_klaidu) {
				Albumas albumas = new Albumas(Integer.parseInt(id_grupes)
											 ,pavadinimas
											 ,Integer.parseInt(isleidimo_metai)
											 ,Integer.parseInt(kuriniu_kiekis)										 
											 ,albumo_ilgis
											 );
				albumas = albumas_repository.save(albumas);
			}	
		}
		Iterable<Albumas> albumai_visi = albumas_repository.findAll();
		
		model.addAttribute ( "albumai", albumai_visi );
		model.addAttribute ("klaidos", klaidos);
		return "Albumas";
	}
	public static boolean arData(String ikurimas) {
		  return ikurimas.matches("^(19|20)\\d{2}$");  
		}
	public static boolean arPavadinimas(String pavadinimas) {
		  return pavadinimas.matches("^[a-zA-Z]+$");  
		}
	public static boolean arNariai(String nariai) {
		  return nariai.matches("^[1-9]$");  
		}
}
