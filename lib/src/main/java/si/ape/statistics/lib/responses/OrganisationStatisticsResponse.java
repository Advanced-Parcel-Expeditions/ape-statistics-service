package si.ape.statistics.lib.responses;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.json.bind.annotation.JsonbProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrganisationStatisticsResponse implements Serializable {

    @Schema(description = "Number of service points in the organization.")
    @JsonbProperty("numberOfServicePoints")
    private Long numberOfServicePoints;

    @Schema(description = "Number of parcel centers in the organization.")
    @JsonbProperty("numberOfParcelCenters")
    private Long numberOfParcelCenters;

    @Schema(description = "Number of branch offices in the organization.")
    @JsonbProperty("numberOfBranchOffices")
    private Long numberOfBranchOffices;

    @Schema(description = "Number of employees in the organization.")
    @JsonbProperty("numberOfEmployees")
    private Long numberOfEmployees;

    @Schema(description = "Number of parcels in the organization.")
    @JsonbProperty("numberOfParcels")
    private Long numberOfParcels;

    public Long getNumberOfServicePoints() {
        return numberOfServicePoints;
    }

    public void setNumberOfServicePoints(Long numberOfServicePoints) {
        this.numberOfServicePoints = numberOfServicePoints;
    }

    public Long getNumberOfParcelCenters() {
        return numberOfParcelCenters;
    }

    public void setNumberOfParcelCenters(Long numberOfParcelCenters) {
        this.numberOfParcelCenters = numberOfParcelCenters;
    }

    public Long getNumberOfBranchOffices() {
        return numberOfBranchOffices;
    }

    public void setNumberOfBranchOffices(Long numberOfBranchOffices) {
        this.numberOfBranchOffices = numberOfBranchOffices;
    }

    public Long getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(Long numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public Long getNumberOfParcels() {
        return numberOfParcels;
    }

    public void setNumberOfParcels(Long numberOfParcels) {
        this.numberOfParcels = numberOfParcels;
    }

}
