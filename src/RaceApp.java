
/**
 * 
 * @author Manu
 *HareVsTortise Simulator
 */
public class RaceApp {
	
	
	static Thread hare = new Thread(new ThreadRunner("Hare", 90, 100));
	static Thread tortoise = new Thread(new ThreadRunner("Tortoise", 0, 10));
	

	public static void main(String[] args) {
		RaceApp race = new RaceApp();
		
		System.out.println("Get set...go!");
		hare.start();
		tortoise.start();
	}

	public RaceApp() {
	}

	//Upon finishing a thread declare it a winner and stop the other thread
	public static void finished(Thread winner) {
		if (winner.getName().equals("Hare"))
			tortoise.interrupt();
		else if (winner.getName().equals("Tortoise"))
			hare.interrupt();
	}
}
