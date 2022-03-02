package commandPattern;

public class CementItemReadFileCommand implements ConcreteCommand{
	private ConcreteReceiver concreteReceiver;

	public CementItemReadFileCommand(ConcreteReceiver concreteReceiver) {
		this.concreteReceiver = concreteReceiver;
	}

	@Override
	public void startCommand() {
		this.concreteReceiver.writeFile();
	}
}
