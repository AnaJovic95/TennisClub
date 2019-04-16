package beans;

import java.io.Serializable;
import java.util.List;

import managers.TurnirManager;
import model.Turnir;

public class GetSviTurniriBean implements Serializable{


	public List<Turnir> sviTurniri;

	public GetSviTurniriBean() {
		sviTurniri = new TurnirManager().vratiSveTurnire();
		System.out.println(sviTurniri.size());
	}

	public List<Turnir> getSviTurniri() {
		return sviTurniri;
	}

	public void setSviTurniri(List<Turnir> sviTurniri) {
		this.sviTurniri = sviTurniri;
	}


}
