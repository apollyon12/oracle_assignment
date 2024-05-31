package org.oracle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.oracle.model.BuildData;
import org.oracle.service.BuildDataReport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.*;

/**
 * Unit tests for BuildDataReport class.
 */
public class BuildDataReportTest {
    private List<BuildData> buildDataList;
    private BuildDataReport report;

    @BeforeEach
    public void setUp() {
        buildDataList = Arrays.asList(
                new BuildData.Builder().customerId("2343225").contractId("2345").geozone("us_east").teamcode("RedTeam").projectcode("ProjectApple").buildDuration(3445).build(),
                new BuildData.Builder().customerId("1223456").contractId("2345").geozone("us_west").teamcode("BlueTeam").projectcode("ProjectBanana").buildDuration(2211).build(),
                new BuildData.Builder().customerId("3244332").contractId("2346").geozone("eu_west").teamcode("YellowTeam3").projectcode("ProjectCarrot").buildDuration(4322).build(),
                new BuildData.Builder().customerId("1233456").contractId("2345").geozone("us_west").teamcode("BlueTeam").projectcode("ProjectDate").buildDuration(2221).build(),
                new BuildData.Builder().customerId("3244132").contractId("2346").geozone("eu_west").teamcode("YellowTeam3").projectcode("ProjectEgg").buildDuration(4122).build()
        );
        report = new BuildDataReport();
    }

    @Test
    public void testUniqueCustomerIdsPerContractId() {
        Map<String, Long> result = report.uniqueCustomerIdsPerContractId(buildDataList);
        Map<String, Long> expected = new HashMap<>();
        expected.put("2345", 3L);
        expected.put("2346", 2L);
        assertEquals(expected, result);
    }

    @Test
    public void testUniqueCustomerIdsPerGeozone() {
        Map<String, Long> result = report.uniqueCustomerIdsPerGeozone(buildDataList);
        Map<String, Long> expected = new HashMap<>();
        expected.put("us_east", 1L);
        expected.put("us_west", 2L);
        expected.put("eu_west", 2L);
        assertEquals(expected, result);
    }

    @Test
    public void testAverageBuildDurationPerGeozone() {
        Map<String, Double> result = report.averageBuildDurationPerGeozone(buildDataList);
        Map<String, Double> expected = new HashMap<>();
        expected.put("us_east", 3445.0);
        expected.put("us_west", 2216.0);
        expected.put("eu_west", 4222.0);
        assertEquals(expected, result);
    }

    @Test
    public void testUniqueCustomerIdsListPerGeozone() {
        Map<String, Set<String>> result = report.uniqueCustomerIdsListPerGeozone(buildDataList);
        Map<String, Set<String>> expected = new HashMap<>();
        expected.put("us_east", new HashSet<>(Collections.singletonList("2343225")));
        expected.put("us_west", new HashSet<>(Arrays.asList("1223456", "1233456")));
        expected.put("eu_west", new HashSet<>(Arrays.asList("3244332", "3244132")));
        assertEquals(expected, result);
    }
}
