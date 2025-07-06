package adapter;

import model.CompactDisc;

public class AdapterCD implements Multimedia {

	private CompactDisc cd;

	public AdapterCD(CompactDisc cd) {
		this.cd = cd;
	}

	@Override
	public String getCampo1() {
		// TODO Auto-generated method stub
		return cd.getTitle();
	}

	@Override
	public String getCampo2() {
		// TODO Auto-generated method stub
		return cd.getArtist();
	}

}
