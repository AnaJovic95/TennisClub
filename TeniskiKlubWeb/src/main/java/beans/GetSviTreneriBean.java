package beans;

import java.io.Serializable;
import java.util.List;

import managers.TrenerManager;
import model.Trener;

public class GetSviTreneriBean implements Serializable{


	public List<Trener> sviTreneri;

	public GetSviTreneriBean() {
		sviTreneri = new TrenerManager().vratiSveTrenere();
	}

	public List<Trener> getSviTreneri() {
		return sviTreneri;
	}

	public void setSviTreneri(List<Trener> sviTreneri) {
		this.sviTreneri = sviTreneri;
	}


}
