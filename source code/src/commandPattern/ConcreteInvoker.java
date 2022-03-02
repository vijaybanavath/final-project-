package commandPattern;

public class ConcreteInvoker {
	ConcreteCommand concreteCommand;
	
	public ConcreteInvoker(ConcreteCommand concreteCommand) {
		this.concreteCommand=concreteCommand;
	}
	
	public void startCommand() {
		this.concreteCommand.startCommand();
	}
}
