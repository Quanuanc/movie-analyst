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

    public static Properties loadAppProperties() {
        InputStream inputStream = Util.class.getClassLoader().getResourceAsStream("config/app.properties");
        Properties appProps = new Properties();

        assert inputStream != null;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        try {
            appProps.load(inputStreamReader);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return appProps;
    }

    public static List<String> getMovieOriginName(Path movieDirPath) {
        List<String> movieNames = new ArrayList<>();

        try {
            Files.list(movieDirPath)
                    .map((Function<Path, Object>) Path::getFileName)
                    .forEach(name -> movieNames.add(String.valueOf(name)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movieNames;
    }
}
