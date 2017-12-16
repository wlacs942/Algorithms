

public class ProxyMapImage implements MarioMapImage {

	private RealMapImage realMapImage;
	private String mapFileName;
	
	public ProxyMapImage(String mapFileName) {
		this.mapFileName = mapFileName;
	}
	/* creates a Mario Map */
	public void display() {
		if(realMapImage == null) {
			realMapImage = new RealMapImage(mapFileName);
		}
		realMapImage.display();
	}
	
	
	
	
}