package adapter;

import model.Mobile;

public class AdapterMovil implements Multimedia {

	private Mobile m;

	public AdapterMovil(Mobile m) {
		this.m = m;
	}
	@Override
	public String getCampo1() {
		// TODO Auto-generated method stub
		return m.getBrand();
	}

	@Override
	public String getCampo2() {
		// TODO Auto-generated method stub
		return m.getModel();
	}

}
