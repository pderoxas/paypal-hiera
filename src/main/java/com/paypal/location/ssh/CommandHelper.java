package com.paypal.location.ssh;

import com.paypal.location.config.app.CommandType;
import com.paypal.location.utils.PatternCompiler;
import org.apache.log4j.Logger;

import java.util.regex.Pattern;

/**
 * Helper class for SSH Commands
 * User: pderoxas
 * Date: 10/3/13
 * Time: 1:22 PM
 */
public class CommandHelper {
    private static Logger logger = Logger.getLogger(CommandHelper.class);

    /**
     * Helper method to check if a single command is successful based on the actual results and the expected results
     * @param commandType The command
     * @param commandResult The command result
     * @return boolean
     */
    public static boolean isCommandSuccessful(CommandType commandType, CommandResult commandResult){

        if(commandType.getExpectedResult() == null){
            //no expected result for the command so return true
            logger.info("Command was successful.  There were not expected results defined.");
            return true;
        }

        for(CommandType.ExpectedResult expectedResult : commandType.getExpectedResult()){
            if(isExpectedResultMet(expectedResult, commandResult)) {
                logger.info("Command was successful.  At least one of the expected results was met.");
                return true;
            }
        }

        logger.info("Command was unsuccessful.  None of the expected results were met.");
        return false;
    }

    /**
     * This will compare a single expectedResult object against the actual results
     * @param expectedResult
     * @param commandResult
     * @return
     */
    private static boolean isExpectedResultMet(CommandType.ExpectedResult expectedResult, CommandResult commandResult){

        if(expectedResult == null){
            //no expected result for the command so return true
            return true;
        }

        //check exit code which is required
        logger.debug("Actual exit code: " + commandResult.getExitCode());
        logger.debug("Expected exit code: " + expectedResult.getExitCode());
        if(commandResult.getExitCode() != expectedResult.getExitCode()){
            logger.debug("Actual exit code: " + commandResult.getExitCode() + " does not match the expected value: " + expectedResult.getExitCode());
            return false;
        }

        //check output if it exists
        if(expectedResult.getOutput() != null){
            String actualValue = commandResult.getOutput().toString().trim();
            String expectedValue = expectedResult.getOutput().getValue().trim();
            Pattern pattern;
            logger.debug(expectedResult.getOutput().getComparator() + " - actualValue: " + actualValue + " | expectedValue: " + expectedValue);
            switch(expectedResult.getOutput().getComparator()){
                case REGEX_FIND:
                    pattern = PatternCompiler.getCompiledPattern(expectedValue);
                    if(!pattern.matcher(actualValue).find()){
                        logger.debug("Expected pattern (" + expectedValue + ") was not found in the actual value (" + actualValue + ")");
                        return false;
                    }
                    break;
                case REGEX_MATCH:
                    pattern = PatternCompiler.getCompiledPattern(expectedValue);
                    if(!pattern.matcher(actualValue).matches()){
                        logger.debug("Expected pattern (" + expectedValue + ") does not match the actual value (" + actualValue + ")");
                        return false;
                    }
                    break;
                case LITERAL:
                default:
                    if(!actualValue.equals(expectedValue)){
                        logger.debug("Actual value (" + actualValue + ") and expected value (" + expectedValue + ") are not equal");
                        return false;
                    }
                    break;
            }
        }

        logger.info("Command was successful based on the expected results");
        return true;
    }
}
