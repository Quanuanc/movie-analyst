import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Properties;

public class Main {

    private static final Logger log = LogManager.getLogger("Main");

    private static final String movieDir = "movieDir";
    private static final String infoOutputDir = "infoOutputDir";

    public static void main(String[] args) throws IOException {
        Properties appProps = Util.loadAppProperties();
        assert appProps != null;

        String movieDirValue = appProps.getProperty(movieDir);
        String infoOutputDirValue = appProps.getProperty(infoOutputDir);

        log.debug("movieDir      = {}", movieDirValue);
        log.debug("infoOutputDir = {}", infoOutputDirValue);

        log.info("scanning movies in {}", movieDirValue);

        Path movieDirPath = Paths.get(movieDirValue);

        List<String> movieNames = Util.getMovieOriginName(movieDirPath);

        log.debug("movie origin names: ");
        for (String originName : movieNames) {
            log.debug("{}", originName);
        }
    }
}
