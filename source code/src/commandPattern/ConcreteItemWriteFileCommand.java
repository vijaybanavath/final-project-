package commandPattern;

public class ConcreteItemWriteFileCommand implements ConcreteCommand{
	private ConcreteReceiver concreteReceiver;

	public ConcreteItemWriteFileCommand(ConcreteReceiver concreteReceiver) {
		this.concreteReceiver = concreteReceiver;
	}

	@Override
	public void startCommand() {
		this.concreteReceiver.writeFile();
	}
}
