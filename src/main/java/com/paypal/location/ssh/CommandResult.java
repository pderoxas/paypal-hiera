package com.paypal.location.ssh;

/**
 * User: pderoxas
 * Date: 8/26/13
 * Time: 4:28 PM
 * Object to generically encapsulate the results of an ssh command.
 */
public class CommandResult {
    private StringBuilder output;
    private int exitCode = -1;  //initialize as -1

    public CommandResult() {
        this.output = new StringBuilder();
    }

    public StringBuilder getOutput() {
        return output;
    }

    public void appendOutput(String output) {
        this.output.append(output);
    }

    public int getExitCode() {
        return exitCode;
    }

    public void setExitCode(int exitCode) {
        this.exitCode = exitCode;
    }
}
