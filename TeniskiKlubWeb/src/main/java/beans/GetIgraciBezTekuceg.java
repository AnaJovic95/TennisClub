package beans;

import java.io.Serializable;
import java.util.List;

import managers.IgracManager;
import model.Igrac;

public class GetIgraciBezTekuceg implements Serializable {

	public List<Igrac> sviIgraci;

	public GetIgraciBezTekuceg() {

	}

	public GetIgraciBezTekuceg(Igrac i) {
		sviIgraci = new IgracManager().vratiIgraceBezTekuceg(i);
	}

	public List<Igrac> getSviIgraci() {
		return sviIgraci;
	}

	public void setSviIgraci(List<Igrac> sviIgraci) {
		this.sviIgraci = sviIgraci;
	}

}
