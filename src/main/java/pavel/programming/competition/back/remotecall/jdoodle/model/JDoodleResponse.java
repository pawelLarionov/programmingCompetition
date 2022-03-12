package pavel.programming.competition.back.remotecall.jdoodle.model;

/**
 * Response - JDoodle compiler API
 */
public class JDoodleResponse {
    /**
     * Status Code of the result
     */
    private int statusCode;

    /**
     * Output of the program
     */
    private String output;

    /**
     * error message
     */
    private String error;

    public JDoodleResponse() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "JDoodleResponse{" +
                "statusCode=" + statusCode +
                ", output='" + output + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
