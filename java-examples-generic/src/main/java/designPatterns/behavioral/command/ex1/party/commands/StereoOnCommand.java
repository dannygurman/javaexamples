package designPatterns.behavioral.command.ex1.party.commands;

import designPatterns.behavioral.command.ex1.party.appliance.Stereo;

public class StereoOnCommand implements Command {
	Stereo stereo;

	public StereoOnCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	public void execute() {
		stereo.on();
	}

	public void undo() {
		stereo.off();
	}
}
