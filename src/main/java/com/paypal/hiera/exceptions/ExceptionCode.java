package com.paypal.hiera.exceptions;

/**
 * User: pderoxas
 * Date: 9/18/13
 * Time: 8:20 PM
 * Enum of exception codes and base messages.
 */
public enum ExceptionCode {

    BAD_REQUEST {
        @Override
        public String toString() {
            return "Invalid request has been received. ";
        }
    },
    DEPLOYMENT_ALREADY_IN_PROGRESS {
        @Override
        public String toString() {
            return "A deployment is already in progress for the environment. It must finish before another deployment is invoked. ";
        }
    },
    UNSUPPORTED_CONTENT_TYPE {
        @Override
        public String toString() {
            return "Content Type is unsupported.  Please ensure that the Content-Type in the request header is set correctly. ";
        }
    },
    INVALID_PARAMETER_VALUE {
        @Override
        public String toString() {
            return "Invalid parameter values have been detected. ";
        }
    },
    NO_AVAILABLE_SLOTS {
        @Override
        public String toString() {
            return "There are no available slots remaining on the server. ";
        }
    },
    RESOURCE_NOT_FOUND {
        @Override
        public String toString() {
            return "The requested resource does not exist. Check that the url is correct. ";
        }
    },
    METHOD_NOT_ALLOWED {
        @Override
        public String toString() {
            return "The requested method is not allowed. ";
        }
    },
    SSH_EXCEPTION {
        @Override
        public String toString() {
            return "An error occurred during an ssh session to the server. ";
        }
    },
    APPLICATION_CONFIG_EXCEPTION {
        @Override
        public String toString() {
            return "An exception has been found related to the application configuration (application.xml). ";
        }
    },
    UNKNOWN_EXCEPTION {
        @Override
        public String toString() {
            return "An unknown exception has occurred.  Please examine the logs for further detail. ";
        }
    },

}
