package org.oracle.model;

/**
 * Represents the build data for a project.
 */
public class BuildData {
    private final String customerId;
    private final String contractId;
    private final String geozone;
    private final String teamcode;
    private final String projectcode;
    private final int buildDuration;

    private BuildData(Builder builder) {
        this.customerId = builder.customerId;
        this.contractId = builder.contractId;
        this.geozone = builder.geozone;
        this.teamcode = builder.teamcode;
        this.projectcode = builder.projectcode;
        this.buildDuration = builder.buildDuration;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getContractId() {
        return contractId;
    }

    public String getGeozone() {
        return geozone;
    }

    public int getBuildDuration() {
        return buildDuration;
    }

    /**
     * Builder class for constructing BuildData instances.
     */
    public static class Builder {
        private String customerId;
        private String contractId;
        private String geozone;
        private String teamcode;
        private String projectcode;
        private int buildDuration;

        public Builder customerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder contractId(String contractId) {
            this.contractId = contractId;
            return this;
        }

        public Builder geozone(String geozone) {
            this.geozone = geozone;
            return this;
        }

        public Builder teamcode(String teamcode) {
            this.teamcode = teamcode;
            return this;
        }

        public Builder projectcode(String projectcode) {
            this.projectcode = projectcode;
            return this;
        }

        public Builder buildDuration(int buildDuration) {
            this.buildDuration = buildDuration;
            return this;
        }

        public BuildData build() {
            return new BuildData(this);
        }
    }
}
