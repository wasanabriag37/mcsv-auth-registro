package com.nuevaeps.auth.infrastruture.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.nuevaeps.auth.domain.models.User;
import com.nuevaeps.auth.infrastruture.input.models.LoginResponse;
import com.nuevaeps.auth.infrastruture.output.persistence.entities.UserEntity;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LoginUserMapperInf {
    User userEntityToUserDto(UserEntity entity);
    @Mapping(source = "message", target = "message")
    @Mapping(source = "token", target = "token")
    @Mapping(source = "success", target = "success")
    LoginResponse buildLoginResponse(String message, String token, boolean success);
}
