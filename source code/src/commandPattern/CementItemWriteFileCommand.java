package commandPattern;

public class CementItemWriteFileCommand implements ConcreteCommand{
	private ConcreteReceiver concreteReceiver;

	public CementItemWriteFileCommand(ConcreteReceiver concreteReceiver) {
		this.concreteReceiver = concreteReceiver;
	}

	@Override
	public void startCommand() {
		this.concreteReceiver.writeFile();
	}
}
