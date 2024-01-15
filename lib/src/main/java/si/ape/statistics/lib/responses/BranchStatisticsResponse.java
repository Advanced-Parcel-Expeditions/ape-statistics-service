package si.ape.statistics.lib.responses;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;

public class BranchStatisticsResponse {

    @Schema(description = "Number of parcels in the branch.")
    @JsonbProperty("numberOfParcels")
    private Long numberOfParcels;

    @Schema(description = "Number of pending jobs in the branch.")
    @JsonbProperty("numberOfPendingJobs")
    private Long numberOfPendingJobs;

    @Schema(description = "Number of completed jobs in the branch.")
    @JsonbProperty("numberOfCompletedJobs")
    private Long numberOfCompletedJobs;

    @Schema(description = "Number of cancelled jobs in the branch.")
    @JsonbProperty("numberOfCancelledJobs")
    private Long numberOfCancelledJobs;

    @Schema(description = "Number of administrators in the branch.")
    @JsonbProperty("numberOfAdministrators")
    private Long numberOfAdministrators;

    @Schema(description = "Number of warehouse agents in the branch.")
    @JsonbProperty("numberOfWarehouseAgents")
    private Long numberOfWarehouseAgents;

    @Schema(description = "Number of warehouse managers in the branch.")
    @JsonbProperty("numberOfWarehouseManager")
    private Long numberOfWarehouseManager;

    @Schema(description = "Number of delivery drivers in the branch.")
    @JsonbProperty("numberOfDeliveryDrivers")
    private Long numberOfDeliveryDrivers;

    @Schema(description = "Number of international drivers in the branch.")
    @JsonbProperty("numberOfInternationalDrivers")
    private Long numberOfInternationalDrivers;

    @Schema(description = "Number of logistics agents in the branch.")
    @JsonbProperty("numberOfLogisticsAgents")
    private Long numberOfLogisticsAgents;

    @Schema(description = "Number of specialists in the branch.")
    @JsonbProperty("numberOfSpecialists")
    private Long numberOfSpecialists;

    @Schema(description = "Number of employees in the branch.")
    @JsonbProperty("numberOfEmployees")
    private Long numberOfEmployees;

    public Long getNumberOfParcels() {
        return numberOfParcels;
    }

    public void setNumberOfParcels(Long numberOfParcels) {
        this.numberOfParcels = numberOfParcels;
    }

    public Long getNumberOfPendingJobs() {
        return numberOfPendingJobs;
    }

    public void setNumberOfPendingJobs(Long numberOfPendingJobs) {
        this.numberOfPendingJobs = numberOfPendingJobs;
    }

    public Long getNumberOfCompletedJobs() {
        return numberOfCompletedJobs;
    }

    public void setNumberOfCompletedJobs(Long numberOfCompletedJobs) {
        this.numberOfCompletedJobs = numberOfCompletedJobs;
    }

    public Long getNumberOfCancelledJobs() {
        return numberOfCancelledJobs;
    }

    public void setNumberOfCancelledJobs(Long numberOfCancelledJobs) {
        this.numberOfCancelledJobs = numberOfCancelledJobs;
    }

    public Long getNumberOfAdministrators() {
        return numberOfAdministrators;
    }

    public void setNumberOfAdministrators(Long numberOfAdministrators) {
        this.numberOfAdministrators = numberOfAdministrators;
    }

    public Long getNumberOfWarehouseAgents() {
        return numberOfWarehouseAgents;
    }

    public void setNumberOfWarehouseAgents(Long numberOfWarehouseAgents) {
        this.numberOfWarehouseAgents = numberOfWarehouseAgents;
    }

    public Long getNumberOfWarehouseManager() {
        return numberOfWarehouseManager;
    }

    public void setNumberOfWarehouseManager(Long numberOfWarehouseManager) {
        this.numberOfWarehouseManager = numberOfWarehouseManager;
    }

    public Long getNumberOfDeliveryDrivers() {
        return numberOfDeliveryDrivers;
    }

    public void setNumberOfDeliveryDrivers(Long numberOfDeliveryDrivers) {
        this.numberOfDeliveryDrivers = numberOfDeliveryDrivers;
    }

    public Long getNumberOfInternationalDrivers() {
        return numberOfInternationalDrivers;
    }

    public void setNumberOfInternationalDrivers(Long numberOfInternationalDrivers) {
        this.numberOfInternationalDrivers = numberOfInternationalDrivers;
    }

    public Long getNumberOfLogisticsAgents() {
        return numberOfLogisticsAgents;
    }

    public void setNumberOfLogisticsAgents(Long numberOfLogisticsAgents) {
        this.numberOfLogisticsAgents = numberOfLogisticsAgents;
    }

    public Long getNumberOfSpecialists() {
        return numberOfSpecialists;
    }

    public void setNumberOfSpecialists(Long numberOfSpecialists) {
        this.numberOfSpecialists = numberOfSpecialists;
    }

    public Long getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Long numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

}
