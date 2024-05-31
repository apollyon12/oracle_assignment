package org.oracle.service;

import org.oracle.model.BuildData;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Generates reports from a list of BuildData objects.
 */
public class BuildDataReport {
    /**
     * Computes the number of unique customer IDs for each contract ID.
     *
     * @param buildDataList The list of BuildData objects.
     * @return A map of contract IDs to the number of unique customer IDs.
     */
    public Map<String, Long> uniqueCustomerIdsPerContractId(List<BuildData> buildDataList) {
        return buildDataList.stream()
                .collect(Collectors.groupingBy(BuildData::getContractId, Collectors.mapping(BuildData::getCustomerId, Collectors.toSet())))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (long) e.getValue().size()));
    }

    /**
     * Computes the number of unique customer IDs for each geozone.
     *
     * @param buildDataList The list of BuildData objects.
     * @return A map of geozones to the number of unique customer IDs.
     */
    public Map<String, Long> uniqueCustomerIdsPerGeozone(List<BuildData> buildDataList) {
        return buildDataList.stream()
                .collect(Collectors.groupingBy(BuildData::getGeozone, Collectors.mapping(BuildData::getCustomerId, Collectors.toSet())))
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (long) e.getValue().size()));
    }

    /**
     * Computes the average build duration for each geozone.
     *
     * @param buildDataList The list of BuildData objects.
     * @return A map of geozones to the average build duration.
     */
    public Map<String, Double> averageBuildDurationPerGeozone(List<BuildData> buildDataList) {
        return buildDataList.stream()
                .collect(Collectors.groupingBy(BuildData::getGeozone, Collectors.averagingInt(BuildData::getBuildDuration)));
    }

    /**
     * Computes the list of unique customer IDs for each geozone.
     *
     * @param buildDataList The list of BuildData objects.
     * @return A map of geozones to the set of unique customer IDs.
     */
    public Map<String, Set<String>> uniqueCustomerIdsListPerGeozone(List<BuildData> buildDataList) {
        return buildDataList.stream()
                .collect(Collectors.groupingBy(BuildData::getGeozone, Collectors.mapping(BuildData::getCustomerId, Collectors.toSet())));
    }
}
