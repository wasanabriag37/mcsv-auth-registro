package com.nuevaeps.auth.application.services;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nuevaeps.auth.application.input.UserUseCase;
import com.nuevaeps.auth.domain.ports.in.UserIn;
import com.nuevaeps.auth.infrastruture.input.models.FilterUserRequest;
import com.nuevaeps.auth.infrastruture.input.models.ResponseUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService implements UserUseCase {

    private final UserIn userIn;
    
    @Override
    public Page<ResponseUser> getPagUser(FilterUserRequest filterUserRequest) {
        return userIn.getPagUser(filterUserRequest);
    }

    @Override
    public Set<ResponseUser> getByIds(Set<Integer> userIds) {
        return userIn.getByIds(userIds);
    }

    @Override
    public Set<ResponseUser> getAlluser() {
        return userIn.getAlluser();
    }

}
