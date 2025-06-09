package com.nuevaeps.auth.infrastruture.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.nuevaeps.auth.domain.models.UserRegister;
import com.nuevaeps.auth.infrastruture.input.models.RegisterResponse;
import com.nuevaeps.auth.infrastruture.output.persistence.entities.UserEntity;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RegisterUserMapperInf {
    UserEntity dtoUserRegisterToUserEntity(UserRegister userRegister);
    RegisterResponse userEntityTRegisterResponse(UserEntity userEntity);
}
