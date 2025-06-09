package com.nuevaeps.auth.infrastruture.mappers;

import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.nuevaeps.auth.infrastruture.input.models.ResponseUser;
import com.nuevaeps.auth.infrastruture.output.persistence.entities.UserEntity;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapperInf {
    Set<ResponseUser> userEntityToResponse(Set<UserEntity> userEntities);
}
