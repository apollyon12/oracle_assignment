package org.oracle;

import org.oracle.model.BuildData;
import org.oracle.service.BuildDataReport;
import org.oracle.util.BuildDataParser;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Main application to parse build data and generate reports.
 */
public class Main {
    public static void main(String[] args) {
        String inputData = "2343225,2345,us_east,RedTeam,ProjectApple,3445s\n" +
                "1223456,2345,us_west,BlueTeam,ProjectBanana,2211s\n" +
                "3244332,2346,eu_west,YellowTeam3,ProjectCarrot,4322s\n" +
                "1233456,2345,us_west,BlueTeam,ProjectDate,2221s\n" +
                "3244132,2346,eu_west,YellowTeam3,ProjectEgg,4122s";
        // Parse input data
        BuildDataParser parser = new BuildDataParser();
        List<BuildData> buildDataList = parser.parse(inputData);
        // Generate reports
        BuildDataReport report = new BuildDataReport();

        Map<String, Long> uniqueCustomerIdsPerContractId = report.uniqueCustomerIdsPerContractId(buildDataList);
        Map<String, Long> uniqueCustomerIdsPerGeozone = report.uniqueCustomerIdsPerGeozone(buildDataList);
        Map<String, Double> averageBuildDurationPerGeozone = report.averageBuildDurationPerGeozone(buildDataList);
        Map<String, Set<String>> uniqueCustomerIdsListPerGeozone = report.uniqueCustomerIdsListPerGeozone(buildDataList);

        // Print reports
        System.out.println("Unique Customer IDs per Contract ID: " + uniqueCustomerIdsPerContractId);
        System.out.println("Unique Customer IDs per Geozone: " + uniqueCustomerIdsPerGeozone);
        System.out.println("Average Build Duration per Geozone: " + averageBuildDurationPerGeozone);
        System.out.println("Unique Customer IDs List per Geozone: " + uniqueCustomerIdsListPerGeozone);
    }
}
