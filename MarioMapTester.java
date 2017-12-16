/**
 * This program was coded using separate classes, instead of uploading multiple java files
 * I put everything into 1 file 
 * Information about the code:
 *The algorithms that I will provide is a design Pattern in Java. It is the Proxy Design Pattern.
*Now what is a Proxy Pattern?
*
*Proxy Pattern provides a placeholder or surrogate for another object to control access to it
*Simply a middleman that facilitates between two sets of objects using the same interface
*
*
*What are the main uses of a Proxy Pattern?
*
*To form large object structures across many disparate objects
*For saving on the amount of memory used
*For object level access control by acting as a pass through entity or a placeholder object
*Now, there's difference styles of Proxy Patterns, here is 3 of the more important ones
*
*Remote Proxy - controls access to a remote object
*Virtual Proxy- handles the case where an object might be expensive to create
*Protection Proxy - control access rights to an object
*For simplicity, I will talk about a Virtual Proxy Pattern
*
*So, Virtual Proxy Pattern would be used whenever we want to reduce memory footprint.
*
*And by that, let me give you an example.
*
*Let's say I make a Mario Game Application. I'm in the middle of gameplay and I decided to press that start button which pauses the game and pops out with a few options on the screen. 
*
*One of the options is labeled "Map". Now, the instant that I click on "Map" it will create a Proxy Object. So we need to know that "Map" correlates which Proxy. Now, the "Map" option once clicked has a sub menu. In this sub menu, there is another option labeled "Display". The "Display" option will simply display the Map Image. Now, once I click on "Display", a real Map Image object is created in order to display the image of the map.
*
*Now, it will take a few seconds to load the map once we click on "Display" but the benefit of using a Virtual Proxy Pattern is that once we exit the "Display" function and click on the "Display" function again, instead of taking those few seconds to load like the first time it will instead load instantly because it has a connection with the Proxy Object.
*
*So Virtual Proxy Pattern in this case is used to save the user a few more seconds of their time hence making the game run more smoothly. 
 * 
 *@author Hector Cuellar
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
