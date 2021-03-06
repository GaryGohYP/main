package seedu.address.logic.commands;

import seedu.address.logic.CommandHistory;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

/**
 * Signals that the user has entered an input or argument for a specified field during the execution of
 * an intuitive command.
 */
public class IntuitiveEntryCommand extends Command {
    private static final String GO_BACK_COMMAND = "/bk";
    private static final String GO_BACK_INSTRUCTION = "\n(Type %1$s to go back)";
    private static final String INPUT_ECHO = "You entered: %1$s \n";
    private static final String INTUITIVE_MODE_MESSAGE = "You are currently in the intuitive %1$s command. ";

    private String input;

    public IntuitiveEntryCommand(String userInput) {
        this.input = userInput;
    }

    @Override
    public CommandResult execute(Model model, CommandHistory commandHistory) throws CommandException {
        boolean isFirstInput = !model.areIntuitiveArgsAvailable();
        String nextInstruction = null;
        if (input.equals(GO_BACK_COMMAND)) {
            nextInstruction = model.removeIntuitiveEntry();
        } else {
            //model -> save input as argument in list (IntuitivePromptManager)
            //get correct command type and argument index from IntuitivePromptManager (in model)
            nextInstruction = model.addIntuitiveEntry(input);
        }

        if (input.equals("")) {
            return new CommandResult(nextInstruction);
        }

        //return correct instruction to display in CommandResult
        if (isFirstInput) {
            return new CommandResult(String.format(INTUITIVE_MODE_MESSAGE, model.getCurrentIntuitiveCommandType())
                    + String.format(INPUT_ECHO, this.input) + nextInstruction);
        }

        return new CommandResult(String.format(INTUITIVE_MODE_MESSAGE, model.getCurrentIntuitiveCommandType())
                + String.format(INPUT_ECHO, this.input) + nextInstruction
                + String.format(GO_BACK_INSTRUCTION, GO_BACK_COMMAND));
    }
}
