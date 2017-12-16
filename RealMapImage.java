
public class RealMapImage implements MarioMapImage {

	private String mapFileName;
	
	/* takes in a Mario Map file name and calls the load method with the Mario map file*/
	public RealMapImage(String mapFileName) {
		this.mapFileName = mapFileName;
		loadFromDrive(mapFileName);
	}
	/* displays Mario map */
	public void display() {
		System.out.println("Displaying " + mapFileName);
	}
	/* loads Mario map */
	public void loadFromDrive(String mapFileName) {
		System.out.println("Loading " + mapFileName);
	}

}
