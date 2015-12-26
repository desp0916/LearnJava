package learn.java.pattern.command.remote;

public class GarageDoor {
	public void up() {
		System.out.println("GarageDoor is Open");
	}

	public void down() {
		System.out.println("GarageDoor is Closed");
	}

	public void stop() {
		System.out.println("GarageDoor is Stop");
	}

	public void lightOn() {
		System.out.println("GarageDoor is LightOn");
	}

	public void lightOff() {
		System.out.println("GarageDoor is LightOff");
	}
}
