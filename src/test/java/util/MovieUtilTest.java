package util;

import entity.Movie;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MovieUtilTest {
    @Test
    public void testGetNameBeforeYear() {

        List<String> fileNames = Arrays.asList(
                "Codename Jackal 2012 1080p BluRay REMUX AVC DTS-HD MA 5.1-LHD",
                "Dark Waters 2019 BluRay REMUX 1080p AVC DTS-HD MA 5.1-LHD",
                "Day Watch 2006 1080p BluRay DTS x264-LHD",
                "Flipped 2010 1080p Blu-ray AVC DTS-HD MA 5.1-DIY@miracle1934.iso",
                "Intouchables 2011 1080p FR Blu-ray AVC DTS-HD MA 5.1-DIY-HDChina",
                "Just Only Love 2018 BluRay REMUX 1080p AVC TrueHD 5.1-LHD",
                "Midsommar 2019 1080p BluRay DTS x264-LHD",
                "Official Secrets 2019 1080p BluRay DTS x264-LHD"
        );

        List<String> results = Arrays.asList(
                "Codename Jackal",
                "Dark Waters",
                "Day Watch",
                "Flipped",
                "Intouchables",
                "Just Only Love",
                "Midsommar",
                "Official Secrets"
        );

        for (int i = 0; i < fileNames.size(); i++) {
            String nameBeforYear = MovieUtil.getNameBeforeYear(fileNames.get(i));
            Assert.assertEquals(results.get(i), nameBeforYear);
        }
    }
}
