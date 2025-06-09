package com.nuevaeps.auth.domain.service;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.nuevaeps.auth.domain.ports.in.UserIn;
import com.nuevaeps.auth.domain.ports.out.UserOut;
import com.nuevaeps.auth.domain.rules.PaginatorRule;
import com.nuevaeps.auth.infrastruture.input.models.FilterUserRequest;
import com.nuevaeps.auth.infrastruture.input.models.ResponseUser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceDom implements UserIn{
    
    private final UserOut userOut;
    private final PaginatorRule paginatorRule;
    
    @Override
    public Page<ResponseUser> getPagUser(FilterUserRequest filterUserRequest) {
        return userOut.getPagUser(filterUserRequest, paginatorRule.getPageable(filterUserRequest.getCantRecords(), filterUserRequest.getPagCurrent()));
    }

    @Override
    public Set<ResponseUser> getByIds(Set<Integer> userIds) {
        return userOut.getByIds(userIds);
    }

    @Override
    public Set<ResponseUser> getAlluser() {
        return userOut.getAlluser();
    }

}
