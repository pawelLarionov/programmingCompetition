package pavel.programming.competition.back.remotecall.jdoodle.model;

/**
 * Request - JDoodle compiler API
 */
public class JDoodleRequest {
    /**
     * Client ID for your subscription
     */
    private final String clientId;

    /**
     * Client Secret for your subscription
     */
    private final String clientSecret;

    /**
     * program to compile and execute
     */
    private final String script;

    /**
     * StdIn parameters
     */
    private final String stdin;

    /**
     * language of the script
     */
    private final String language;

    /**
     * version of the language to be used
     */
    private final String versionIndex;

    public JDoodleRequest(String clientId, String clientSecret, String script, String stdin, String language, String versionIndex) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.script = script;
        this.stdin = stdin;
        this.language = language;
        this.versionIndex = versionIndex;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public String getScript() {
        return script;
    }

    public String getStdin() {
        return stdin;
    }

    public String getLanguage() {
        return language;
    }

    public String getVersionIndex() {
        return versionIndex;
    }

    @Override
    public String toString() {
        return "JDoodleRequest{" +
                "clientId='" + clientId + '\'' +
                ", clientSecret='" + "*****************" + '\'' +
                ", script='" + script + '\'' +
                ", stdin='" + stdin + '\'' +
                ", language='" + language + '\'' +
                ", versionIndex='" + versionIndex + '\'' +
                '}';
    }
}
