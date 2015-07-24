package appelhorne.fogbugz;

public class FogBugzException extends Exception {
        public FogBugzException(String message, Exception ex) {
            super(message);
            this.initCause(ex);
        }
        public FogBugzException(String message) {
            this(message, null);
        }
}
