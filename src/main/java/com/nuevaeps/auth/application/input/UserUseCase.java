package com.nuevaeps.auth.application.input;

import java.util.Set;

import org.springframework.data.domain.Page;

import com.nuevaeps.auth.infrastruture.input.models.FilterUserRequest;
import com.nuevaeps.auth.infrastruture.input.models.ResponseUser;

public interface UserUseCase {
    Page<ResponseUser> getPagUser(FilterUserRequest filterUserRequest);
    Set<ResponseUser> getByIds(Set<Integer> userIds);
    Set<ResponseUser> getAlluser();
}
