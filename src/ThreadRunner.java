import java.util.Random;

public class ThreadRunner implements Runnable {

	private String name;
	private int rest, speed;
	int meters;

	public String getRacerName() {
		return name;
	}

	public ThreadRunner(String name, int rest, int speed) {
		this.name = name;
		this.rest = rest;
		this.speed = speed;
		this.meters = 0;
	}

	@Override
	public void run() {

		Random rn = new Random();

		//Generate a new thread
		Thread ct = Thread.currentThread();
		ct.setName(name);

		//output the current distance
		while (!ct.isInterrupted()) {
			if (rn.nextInt(100) + 1 > rest) {
				meters += speed;
				System.out.println(this.name + ": " + meters);
			}

			try {
				Thread.sleep(100);
			} catch (InterruptedException ex) {
				return;
				// break;
			}
			//if the current distance is greater than the length of the track, stop the race
			if (meters >= 1000) {
				System.out.println(this.name + ": I finished!\n"
						+ "The race is over! The " + this.name + " is the Winner!");
				
				if(ct.getName().equalsIgnoreCase("hare")) {
					System.out.println("Tortoise: You beat me fair and square, this time!");
				} else if (ct.getName().equalsIgnoreCase("tortoise")) {
					System.out.println("Hare: You beat me fair and square, this time!");

				}
				
				RaceApp.finished(ct);
				
				return;
			}

		}
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

}