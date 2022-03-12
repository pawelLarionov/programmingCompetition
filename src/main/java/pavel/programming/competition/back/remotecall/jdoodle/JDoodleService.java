package pavel.programming.competition.back.remotecall.jdoodle;

/**
 * Service remote call JDoodle compiler API
 */
public interface JDoodleService {
    /**
     * @param solutionCode   java program to compile and execute
     * @param inputParameter input parameter for program
     * @return output of the program
     */
    String executeJava(String solutionCode, String inputParameter);
}
