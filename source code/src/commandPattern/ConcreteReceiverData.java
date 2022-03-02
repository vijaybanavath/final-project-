package commandPattern;

public class ConcreteReceiverData {
	public static ConcreteReceiver getConcreteReceiver(String command) {
		if (command.equals("concrete")) {
			return new ConcreteItemReceiver();
		} else if (command.equals("cement")) {
			return new CementItemReceiver();
		} else {
			return null;
		}
	}
}
