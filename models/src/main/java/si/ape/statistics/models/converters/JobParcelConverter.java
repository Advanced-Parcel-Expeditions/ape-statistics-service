package si.ape.statistics.models.converters;

import si.ape.statistics.lib.JobParcel;
import si.ape.statistics.models.entities.JobParcelEntity;

public class JobParcelConverter {

    public static JobParcel toDto(JobParcelEntity entity) {

        JobParcel dto = new JobParcel();
        dto.setJob(JobConverter.toDto(entity.getJob()));
        dto.setParcel(ParcelConverter.toDto(entity.getParcel()));
        return dto;

    }

    public static JobParcelEntity toEntity(JobParcel dto) {

        JobParcelEntity entity = new JobParcelEntity();
        entity.setJob(JobConverter.toEntity(dto.getJob()));
        entity.setParcel(ParcelConverter.toEntity(dto.getParcel()));
        return entity;

    }

}
