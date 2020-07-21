package util;

import entity.Movie;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MovieUtil {
    public static String getNameBeforeYear(String fileName) {

        Pattern pattern = Pattern.compile("(19|20)\\d{2}");
        Matcher matcher = pattern.matcher(fileName);

        if (matcher.find()) {
            int index = matcher.start();
            if (index != 0) {
                String subStr = fileName.substring(0, index);
                if (subStr.charAt(subStr.length() - 1) == ' ') {
                    return subStr.substring(0, subStr.length() - 1);
                } else
                    return subStr;
            }
        }

        return "";
    }

    private static boolean isENName(String name) {
        String nameTemp = name.trim();
        return nameTemp.matches("[a-zA-Z0-9]+");
    }

    public static void setMovieName(Movie movie, String name) {
        if(MovieUtil.isENName(name)){
            movie.setEnName(name);
        }else{
            //TODO
        }
    }
}
