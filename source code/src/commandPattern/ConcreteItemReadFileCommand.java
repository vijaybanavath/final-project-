package commandPattern;

public class ConcreteItemReadFileCommand implements ConcreteCommand{
	private ConcreteReceiver concreteReceiver;

	public ConcreteItemReadFileCommand(ConcreteReceiver concreteReceiver) {
		this.concreteReceiver = concreteReceiver;
	}

	@Override
	public void startCommand() {
		this.concreteReceiver.readFile();
	}
}
