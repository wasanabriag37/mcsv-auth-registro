package com.nuevaeps.auth.application.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.nuevaeps.auth.domain.models.UserRegister;
import com.nuevaeps.auth.infrastruture.input.models.RegisterRequest;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RegisterUserMapper {
    UserRegister dtoRegisterRequestToUserRegister(RegisterRequest registerRequest);
}
