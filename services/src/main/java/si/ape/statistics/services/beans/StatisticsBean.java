package si.ape.statistics.services.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.logging.Logger;

import si.ape.statistics.lib.responses.BranchStatisticsResponse;
import si.ape.statistics.lib.responses.OrganisationStatisticsResponse;
import si.ape.statistics.models.entities.BranchEntity;

@RequestScoped
public class StatisticsBean {

    private Logger log = Logger.getLogger(StatisticsBean.class.getName());

    @Inject
    private EntityManager em;

    public OrganisationStatisticsResponse getOrganisationStatistics() {
        OrganisationStatisticsResponse organisationStatisticsResponse = new OrganisationStatisticsResponse();

        // Branch types.
        TypedQuery<Long> servicePointsQuery = em.createNamedQuery("BranchEntity.getNumberOfBranchesWithType", Long.class);
        servicePointsQuery.setParameter("branchTypeId", 1);
        Long numberOfServicePoints = servicePointsQuery.getSingleResult();
        organisationStatisticsResponse.setNumberOfServicePoints(numberOfServicePoints);

        TypedQuery<Long> parcelCentersQuery = em.createNamedQuery("BranchEntity.getNumberOfBranchesWithType", Long.class);
        parcelCentersQuery.setParameter("branchTypeId", 2);
        Long numberOfParcelCenters = parcelCentersQuery.getSingleResult();
        organisationStatisticsResponse.setNumberOfParcelCenters(numberOfParcelCenters);

        TypedQuery<Long> branchOfficesQuery = em.createNamedQuery("BranchEntity.getNumberOfBranchesWithType", Long.class);
        branchOfficesQuery.setParameter("branchTypeId", 3);
        Long numberOfBranchOffices = branchOfficesQuery.getSingleResult();
        organisationStatisticsResponse.setNumberOfBranchOffices(numberOfBranchOffices);

        // Total number of employees and parcels.
        TypedQuery<Long> employeesQuery = em.createNamedQuery("EmployeeEntity.getNumberOfEmployees", Long.class);
        Long totalNumberOfEmployees = employeesQuery.getSingleResult();

        TypedQuery<Long> parcelsQuery = em.createNamedQuery("ParcelEntity.getNumberOfParcels", Long.class);
        Long totalNumberOfParcels = parcelsQuery.getSingleResult();

        //Long totalNumberOfEmployees = 0L;
        //Long totalNumberOfParcels = 0L;

        /*List<BranchEntity> branchEntities = em.createNamedQuery("BranchEntity.getAll", BranchEntity.class).getResultList();

        for (BranchEntity branchEntity : branchEntities) {
            BranchStatisticsResponse branchStatisticsResponse = getBranchStatistics(branchEntity.getId());
            organisationStatisticsResponse.getBranchStatisticsResponses().add(branchStatisticsResponse);
            totalNumberOfEmployees += branchStatisticsResponse.getNumberOfEmployees();
            totalNumberOfParcels += branchStatisticsResponse.getNumberOfParcels();
        }*/

        organisationStatisticsResponse.setNumberOfEmployees(totalNumberOfEmployees);
        organisationStatisticsResponse.setNumberOfParcels(totalNumberOfParcels);

        return organisationStatisticsResponse;
    }

    public BranchStatisticsResponse getBranchStatistics(Integer branchId) {
        BranchStatisticsResponse branchStatisticsResponse = new BranchStatisticsResponse();

        // Parcels.
        TypedQuery<Long> parcelsQuery = em.createNamedQuery("ParcelEntity.getNumberOfParcelsAtBranch", Long.class);
        parcelsQuery.setParameter("branchId", branchId);
        Long numberOfParcels = parcelsQuery.getSingleResult();
        branchStatisticsResponse.setNumberOfParcels(numberOfParcels);

        // Jobs.
        TypedQuery<Long> pendingJobsQuery = em.createNamedQuery("JobEntity.getNumberOfJobsWithStatusAndBranch", Long.class);
        pendingJobsQuery.setParameter("branchId", branchId);
        pendingJobsQuery.setParameter("status", 1);
        Long numberOfPendingJobs = pendingJobsQuery.getSingleResult();
        branchStatisticsResponse.setNumberOfPendingJobs(numberOfPendingJobs);

        TypedQuery<Long> completedJobsQuery = em.createNamedQuery("JobEntity.getNumberOfJobsWithStatusAndBranch", Long.class);
        completedJobsQuery.setParameter("branchId", branchId);
        completedJobsQuery.setParameter("status", 2);
        Long numberOfCompletedJobs = completedJobsQuery.getSingleResult();
        branchStatisticsResponse.setNumberOfCompletedJobs(numberOfCompletedJobs);

        TypedQuery<Long> cancelledJobsQuery = em.createNamedQuery("JobEntity.getNumberOfJobsWithStatusAndBranch", Long.class);
        cancelledJobsQuery.setParameter("branchId", branchId);
        cancelledJobsQuery.setParameter("status", 3);
        Long numberOfCancelledJobs = cancelledJobsQuery.getSingleResult();
        branchStatisticsResponse.setNumberOfCancelledJobs(numberOfCancelledJobs);

        // Staff.
        TypedQuery<Long> administratorsQuery = em.createNamedQuery("EmployeeEntity.getNumberOfEmployeesAtBranchWithRole", Long.class);
        administratorsQuery.setParameter("branchId", branchId);
        administratorsQuery.setParameter("roleId", 1);
        Long numberOfAdministrators = administratorsQuery.getSingleResult();
        branchStatisticsResponse.setNumberOfAdministrators(numberOfAdministrators);

        TypedQuery<Long> warehouseAgentsQuery = em.createNamedQuery("EmployeeEntity.getNumberOfEmployeesAtBranchWithRole", Long.class);
        warehouseAgentsQuery.setParameter("branchId", branchId);
        warehouseAgentsQuery.setParameter("roleId", 2);
        Long numberOfWarehouseAgents = warehouseAgentsQuery.getSingleResult();
        branchStatisticsResponse.setNumberOfWarehouseAgents(numberOfWarehouseAgents);

        TypedQuery<Long> warehouseManagersQuery = em.createNamedQuery("EmployeeEntity.getNumberOfEmployeesAtBranchWithRole", Long.class);
        warehouseManagersQuery.setParameter("branchId", branchId);
        warehouseManagersQuery.setParameter("roleId", 3);
        Long numberOfWarehouseManagers = warehouseManagersQuery.getSingleResult();
        branchStatisticsResponse.setNumberOfWarehouseManager(numberOfWarehouseManagers);

        TypedQuery<Long> deliveryDriversQuery = em.createNamedQuery("EmployeeEntity.getNumberOfEmployeesAtBranchWithRole", Long.class);
        deliveryDriversQuery.setParameter("branchId", branchId);
        deliveryDriversQuery.setParameter("roleId", 4);
        Long numberOfDeliveryDrivers = deliveryDriversQuery.getSingleResult();
        branchStatisticsResponse.setNumberOfDeliveryDrivers(numberOfDeliveryDrivers);

        TypedQuery<Long> internationalDriversQuery = em.createNamedQuery("EmployeeEntity.getNumberOfEmployeesAtBranchWithRole", Long.class);
        internationalDriversQuery.setParameter("branchId", branchId);
        internationalDriversQuery.setParameter("roleId", 5);
        Long numberOfInternationalDrivers = internationalDriversQuery.getSingleResult();
        branchStatisticsResponse.setNumberOfInternationalDrivers(numberOfInternationalDrivers);

        TypedQuery<Long> logisticsAgentsQuery = em.createNamedQuery("EmployeeEntity.getNumberOfEmployeesAtBranchWithRole", Long.class);
        logisticsAgentsQuery.setParameter("branchId", branchId);
        logisticsAgentsQuery.setParameter("roleId", 6);
        Long numberOfLogisticsAgents = logisticsAgentsQuery.getSingleResult();
        branchStatisticsResponse.setNumberOfLogisticsAgents(numberOfLogisticsAgents);

        TypedQuery<Long> specialistsQuery = em.createNamedQuery("EmployeeEntity.getNumberOfEmployeesAtBranchWithRole", Long.class);
        specialistsQuery.setParameter("branchId", branchId);
        specialistsQuery.setParameter("roleId", 7);
        Long numberOfSpecialists = specialistsQuery.getSingleResult();
        branchStatisticsResponse.setNumberOfSpecialists(numberOfSpecialists);

        Long numberOfEmployees = numberOfAdministrators +
                                numberOfWarehouseAgents +
                                numberOfWarehouseManagers +
                                numberOfDeliveryDrivers +
                                numberOfInternationalDrivers +
                                numberOfLogisticsAgents +
                                numberOfSpecialists;

        branchStatisticsResponse.setNumberOfEmployees(numberOfEmployees);

        return branchStatisticsResponse;
    }

    private void beginTx() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }

    private void commitTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    private void rollbackTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }

}
