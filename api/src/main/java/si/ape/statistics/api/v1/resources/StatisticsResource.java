package si.ape.statistics.api.v1.resources;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.ape.statistics.lib.responses.BranchStatisticsResponse;
import si.ape.statistics.lib.responses.OrganisationStatisticsResponse;
import si.ape.statistics.services.beans.StatisticsBean;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.logging.Logger;

@ApplicationScoped
@Path("/statistics")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@DeclareRoles({"Administrator", "Warehouse manager", "Warehouse agent", "Delivery driver", "International driver",
        "Logistics agent", "Order confirmation specialist", "Customer"})
public class StatisticsResource {

    private final Logger log = Logger.getLogger(StatisticsResource.class.getName());

    @Inject
    private StatisticsBean statisticsBean;


    @Context
    protected UriInfo uriInfo;

    @Operation(description = "Get statistics for the whole organisation.", summary = "Get overall statistics")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "Statistics for the entire organisation."
            ),
            @APIResponse(responseCode = "404", description = "Statistics could not be found.")
    })
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"Administrator", "Warehouse manager", "Logistics agent"})
    public Response getOrganisationStatistics() {
        OrganisationStatisticsResponse organisationStatisticsResponse = statisticsBean.getOrganisationStatistics();
        if (organisationStatisticsResponse == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(organisationStatisticsResponse).build();
    }

    @Operation(description = "Get statistics for a single branch.", summary = "Get branch statistics")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "Statistics for the given branch."
            ),
            @APIResponse(responseCode = "404", description = "Branch could not be found.")
    })
    @GET
    @Path("/{branchId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed({"Administrator", "Warehouse manager", "Logistics agent"})
    public Response getBranchStatistics(@Parameter(description = "Branch ID") @PathParam("branchId") Integer branchId) {
        BranchStatisticsResponse branchStatisticsResponse = statisticsBean.getBranchStatistics(branchId);
        if (branchStatisticsResponse == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(branchStatisticsResponse).build();
    }


}
