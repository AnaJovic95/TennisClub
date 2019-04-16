package beans;

import java.io.Serializable;
import java.util.List;

import managers.IgracManager;
import model.Igrac;

public class GetSviIgraciBean implements Serializable{

	public List<Igrac> sviIgraci;

	public GetSviIgraciBean() {
		sviIgraci = new IgracManager().vratiSveIgrace();
	}

	public List<Igrac> getSviIgraci() {
		return sviIgraci;
	}

	public void setSviIgraci(List<Igrac> sviIgraci) {
		this.sviIgraci = sviIgraci;
	}

}
