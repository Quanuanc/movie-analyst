package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

public class Util {

    private static final Logger log = LogManager.getLogger(Util.class);

    public static Properties loadAppProperties() {
        InputStream inputStream = Util.class.getClassLoader().getResourceAsStream("config/app.properties");
        Properties appProps = new Properties();

        assert inputStream != null;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        try {
            appProps.load(inputStreamReader);
        } catch (IOException e) {
            log.warn("exception: {}", e.toString());
            return null;
        }

        return appProps;
    }

    public static List<String> getFileName(Path movieDirPath) {
        List<String> movieNames = new ArrayList<>();

        try {
            Files.list(movieDirPath)
                    .map((Function<Path, Object>) Path::getFileName)
                    .filter(name -> !((Path) name).endsWith(".DS_Store"))
                    .forEach(name -> movieNames.add(String.valueOf(name)));
        } catch (IOException e) {
            log.warn("exception: {}", e.toString());
        }

        return movieNames;
    }


}
