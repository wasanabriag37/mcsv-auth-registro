package com.nuevaeps.auth.domain.ports.out;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.nuevaeps.auth.infrastruture.input.models.FilterUserRequest;
import com.nuevaeps.auth.infrastruture.input.models.ResponseUser;

public interface UserOut {
    Page<ResponseUser> getPagUser(FilterUserRequest filterUserRequest, Pageable pageable);
    Set<ResponseUser> getByIds(Set<Integer> userIds);
    Set<ResponseUser> getAlluser();
}
