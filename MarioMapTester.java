/**
 * This program was coded using separate classes, instead of uploading multiple java files
 * I put everything into 1 file 
 * @author Hector Cuellar
 *
 */
public class MarioMapTester {

public interface MarioMapImage {
	public void display();
}

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
	public static void main(String[] args) {

		MarioMapImage marioMapImage = new ProxyMapImage("5mbMapImage.jpeg");

		marioMapImage.display();
		System.out.println("");

		marioMapImage.display();
		
	}
}
