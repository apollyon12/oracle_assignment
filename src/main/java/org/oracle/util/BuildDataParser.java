package org.oracle.util;

import org.oracle.model.BuildData;

import java.util.ArrayList;
import java.util.List;

/**
 * Parses a multiline string into a list of BuildData objects.
 */
public class BuildDataParser {

    /**
     * Parses the input string to create a list of BuildData objects.
     *
     * @param input The multiline input string containing build data.
     * @return A list of BuildData objects.
     */
    public List<BuildData> parse(String input) {
        List<BuildData> buildDataList = new ArrayList<>();
        String[] lines = input.split("\n");
        for (String line : lines) {
            String[] fields = line.split(",");
            BuildData buildData = new BuildData.Builder()
                    .customerId(fields[0])
                    .contractId(fields[1])
                    .geozone(fields[2])
                    .teamcode(fields[3])
                    .projectcode(fields[4])
                    .buildDuration(Integer.parseInt(fields[5].replace("s", "")))
                    .build();
            buildDataList.add(buildData);
        }
        return buildDataList;
    }
}
