import entity.Movie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.MovieUtil;
import util.Util;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    private static final String movieDir = "movieDir";
    private static final String infoOutputDir = "infoOutputDir";

    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();

        Properties appProps = Util.loadAppProperties();
        assert appProps != null;

        String movieDirValue = appProps.getProperty(movieDir);
        String infoOutputDirValue = appProps.getProperty(infoOutputDir);

        log.debug("movieDir      = {}", movieDirValue);
        log.debug("infoOutputDir = {}", infoOutputDirValue);

        log.info("scanning movies in {}", movieDirValue);

        Path movieDirPath = Paths.get(movieDirValue);

        List<String> fileNames = Util.getFileName(movieDirPath);

        log.debug("movie file names: ");
        for (String fileName : fileNames) {
            Movie movie = new Movie();
            movie.setFileName(fileName);
            movie.setEnName(MovieUtil.getNameBeforeYear(fileName));
            movies.add(movie);
            log.debug(movie.getEnName());
        }

        log.info("movie count: {}", movies.size());


    }
}
