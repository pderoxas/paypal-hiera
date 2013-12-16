package com.paypal.location.ssh;

/**
 * Created with IntelliJ IDEA.
 * User: dev
 * Date: 8/26/13
 * Time: 10:18 AM
 * Class to manage a single remote session
 */

import com.paypal.location.config.app.SshConfigType;
import com.paypal.location.exceptions.ExceptionCode;
import com.paypal.location.exceptions.SSHException;
import com.jcraft.jsch.*;
import org.apache.log4j.Logger;
import org.perf4j.StopWatch;
import org.perf4j.log4j.Log4JStopWatch;

import java.io.InputStream;

/**
 * Manage a single remote ssh session
 */
public class SessionManager {
    private Logger logger = Logger.getLogger(this.getClass());
    private StopWatch stopWatch = new Log4JStopWatch();
    private static final long SLEEP_TIME = 10;

    private JSch jsch = new JSch();
    private Session sshSession;

    public static final String DEFAULT_PRIVATE_KEY_PATH = "~/.ssh/id_rsa";
    public static final String DEFAULT_KNOWN_HOSTS_PATH = "~/.ssh/known_hosts";
    public static final boolean DEFAULT_ADD_TO_KNOWN_HOSTS = true;
    public static final int DEFAULT_PORT = 22;
    public static final int DEFAULT_SESSION_TIMEOUT = 30000;
    public static final long DEFAULT_MAX_OUTPUT_READ_TIME = 2000;

    public boolean isConnected() {
        return sshSession != null && sshSession.isConnected();
    }

    /**
     * Connect using default/overrid SshConfig info
     *
     * @param host           - host to connect to
     * @param defaultConfig  - the default SshConfig info
     * @param overrideConfig - the SshConfig to override any default values
     * @throws SSHException <code>
     *                      session.connect("myusername", "192.168.0.200");
     *                      </code>
     */
    public void connect(String host, int port, SshConfigType defaultConfig, SshConfigType overrideConfig) throws SSHException {
        String sshUsername;
        int sshTimeout;
        String sshKnownHosts;
        String sshPrivateKey;
        boolean addToKnownHosts;

        //if ssh details are defined, extract as values defined
        //keep in mind that every element may be optional so use default if necessary
        if (overrideConfig != null) {
            sshUsername = overrideConfig.getRemoteUsername() != null
                ? overrideConfig.getRemoteUsername()
                : defaultConfig.getRemoteUsername();
            sshTimeout = overrideConfig.getSessionTimeout() != null
                ? overrideConfig.getSessionTimeout()
                : defaultConfig.getSessionTimeout();
            sshKnownHosts = overrideConfig.getKnownHostsFilePath() != null
                ? overrideConfig.getKnownHostsFilePath()
                : defaultConfig.getKnownHostsFilePath();
            sshPrivateKey = overrideConfig.getPrivateKeyFilePath() != null
                ? overrideConfig.getPrivateKeyFilePath()
                : defaultConfig.getPrivateKeyFilePath();

            addToKnownHosts = overrideConfig.isAddHostToKnownHostsFile() != null
                ? overrideConfig.isAddHostToKnownHostsFile().booleanValue()
                : defaultConfig.isAddHostToKnownHostsFile().booleanValue();
        }
        else {
            sshUsername = defaultConfig.getRemoteUsername();
            sshTimeout = defaultConfig.getSessionTimeout();
            sshKnownHosts = defaultConfig.getKnownHostsFilePath();
            sshPrivateKey = defaultConfig.getPrivateKeyFilePath();
            addToKnownHosts = defaultConfig.isAddHostToKnownHostsFile().booleanValue();
        }
        connect(sshUsername, host, port, sshKnownHosts, addToKnownHosts, sshPrivateKey, sshTimeout);
    }

    /**
     * Simple connection using default values.
     *
     * @param username - use to connect as
     * @param host - host to connect to
     * @throws SSHException <code>
     *     session.connect("myusername", "192.168.0.200");
     * </code>
     */
    public void connect(String username, String host) throws SSHException {
        connect(username, host, DEFAULT_PORT, DEFAULT_KNOWN_HOSTS_PATH, DEFAULT_ADD_TO_KNOWN_HOSTS, DEFAULT_PRIVATE_KEY_PATH, DEFAULT_SESSION_TIMEOUT);
    }

    /**
     * Open a session (connect) to the remote host using key authentication
     *
     * @param username - user to connect as
     * @param host - host to connect to
     * @param port - port to connect to
     * @param knownHostsFilePath - path to known hosts file
     * @param privateKeyFilePath - path to private key filt
     * @param sessionTimeout - max session length before timing out
     * @throws SSHException <code>
     *     session.connect("myusername", "192.168.0.200", 22, "~/.ssh/known_hosts", "~/.ssh/id_rsa", 10000);
     * </code>
     */
    public void connect(String username, String host, int port, String knownHostsFilePath, boolean addHostToKnownHostsFile, String privateKeyFilePath, int sessionTimeout) throws SSHException {
        StringBuilder paramValues = new StringBuilder("connect() parameter values:");
        paramValues.append("\nusername: ").append(username);
        paramValues.append("\nhost: ").append(host);
        paramValues.append("\nport: ").append(port);
        paramValues.append("\nknownHostsFilePath: ").append(knownHostsFilePath);
        paramValues.append("\nprivateKeyFilePath: ").append(privateKeyFilePath);
        paramValues.append("\nsessionTimeout: ").append(sessionTimeout);
        paramValues.append("\naddHostToKnownHostsFile: ").append(addHostToKnownHostsFile);

        try{
            stopWatch.start(this.getClass().getSimpleName() + ".connect()");
            logger.info("Trying to connect to remote host..." + paramValues);
            if(this.isConnected()){
                logger.info("Session is currently connected to " + sshSession.getHost() + " and will be disconnected. ");
                if(sshSession.getHost().equals(host) && sshSession.getUserName().equals(username)){
                    logger.info("Session is already connected to the requested host and requested username.  Keeping this session open.");
                    return;
                }
                sshSession.disconnect();
            }

            jsch.setKnownHosts(knownHostsFilePath);
            jsch.addIdentity(privateKeyFilePath);

            sshSession = jsch.getSession(username, host, port);
            if (addHostToKnownHostsFile) {
                sshSession.setConfig("StrictHostKeyChecking", "yes");
            }
            else {
                sshSession.setConfig("StrictHostKeyChecking", "no");
            }
            sshSession.setTimeout(sessionTimeout);
            sshSession.connect();
        }
        catch (JSchException e) {
            logger.error(e.getMessage(), e);
            throw new SSHException("Unable to connect to remote host: " + paramValues, ExceptionCode.SSH_EXCEPTION, e);
        }
        finally {
            stopWatch.stop(this.getClass().getSimpleName() + ".connect()");
        }
    }

    /**
     * Disconnect the session
     *
     * @throws SSHException
     */
    public void disconnect() throws SSHException {
        try{
            if(sshSession != null && sshSession.isConnected()){
                logger.info("Attempting to disconnect from host: " + sshSession.getHost());
                sshSession.disconnect();
                logger.info("Disconnected from host: " + sshSession.getHost());
            }
            else {
                logger.info("Session is not connected");
            }
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SSHException("Unexpected Exception caught while attempting to disconnect from remote host.", ExceptionCode.SSH_EXCEPTION, e);
        }
    }

    /**
     * Method to execute a command and read output
     *
     * @param command - the command to execute
     * @return CommandResult instance
     * @throws SSHException
     */
    public CommandResult executeCommand(String command) throws SSHException {
        return executeCommand(command, DEFAULT_MAX_OUTPUT_READ_TIME);
    }

    /**
     * Method to execute a command
     *
     * @param command - the command to execute
     * @param maxReadTime - the maximum amount of time to read output
     * @return CommandResult instance
     * @throws SSHException
     */
    public CommandResult executeCommand(String command, long maxReadTime) throws SSHException {
        stopWatch.start(this.getClass().getSimpleName() + ".executeCommand()");
        if(!this.isConnected()){
            SSHException e = new SSHException("Trying to execute a command but the session is not connected.", ExceptionCode.SSH_EXCEPTION);
            logger.error(e.getMessage());
            throw e;
        }

        logger.info("--------------------------------");
        logger.info("Command to execute: " + command);
        CommandResult commandResult = new CommandResult();
        ChannelExec channel = null;
        try{
            channel = (ChannelExec) sshSession.openChannel("exec");
            channel.setCommand(command);
            channel.setInputStream(null);
            channel.setErrStream(System.err);
            channel.connect();

            long start = System.currentTimeMillis();
            long elapsed = 0;
            InputStream inputStream = channel.getInputStream();
            InputStream errStream = channel.getErrStream();
            byte[] tmp=new byte[1024];
            while(elapsed < (maxReadTime + SLEEP_TIME)){
                while(inputStream.available()>0){
                    int i=inputStream.read(tmp, 0, 1024);
                    if(i<0)break;
                    commandResult.appendOutput(new String(tmp, 0, i));
                }
                while(errStream.available()>0){
                    int i=errStream.read(tmp, 0, 1024);
                    if(i<0)break;
                    commandResult.appendOutput(new String(tmp, 0, i));
                }
                if(channel.isClosed()){
                    break;
                }
                //pause to allow inputStream to repopulate with new data
                Thread.sleep(SLEEP_TIME);
                elapsed = System.currentTimeMillis() - start;
            }

            commandResult.setExitCode(channel.getExitStatus());

            logger.info("Elapsed time (ms): " + elapsed);
            logger.info("Output: " + commandResult.getOutput().toString().trim());
            logger.info("Exit Code: " + commandResult.getExitCode());
            logger.info("--------------------------------");
        }
        catch (JSchException e) {
            logger.error(e.getMessage(), e);
            throw new SSHException("SSH Library Exception caught while executing command: " + command, ExceptionCode.SSH_EXCEPTION, e);
        }
        catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SSHException("Unexpected Exception caught while executing command: " + command, ExceptionCode.SSH_EXCEPTION, e);
        }
        finally {
            stopWatch.stop(this.getClass().getSimpleName() + ".executeCommand()");
        }
        return commandResult;
    }
}