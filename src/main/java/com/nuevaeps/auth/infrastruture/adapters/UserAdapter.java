package com.nuevaeps.auth.infrastruture.adapters;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nuevaeps.auth.domain.ports.out.UserOut;
import com.nuevaeps.auth.infrastruture.input.models.FilterUserRequest;
import com.nuevaeps.auth.infrastruture.input.models.ResponseUser;
import com.nuevaeps.auth.infrastruture.mappers.UserMapperInf;
import com.nuevaeps.auth.infrastruture.output.persistence.entities.UserEntity;
import com.nuevaeps.auth.infrastruture.output.persistence.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserAdapter implements UserOut {
    
    private final UserRepository userRepository;
    private final UserMapperInf userMapperInf;
    
    @Override
    public Page<ResponseUser> getPagUser(FilterUserRequest filterUserRequest, Pageable pageable) {
        Page<UserEntity> pag =  userRepository.filterAndPaginateUsers(filterUserRequest, pageable);
        Set<ResponseUser> list = userMapperInf.userEntityToResponse(pag.getContent().stream().collect(Collectors.toSet()));
        return new PageImpl<>(list.stream().toList(), pageable, pag.getTotalElements());
    }

    @Override
    public Set<ResponseUser> getByIds(Set<Integer> userIds) {
        return userMapperInf.userEntityToResponse(userRepository.findByUserIdIn(userIds));
    }

    @Override
    public Set<ResponseUser> getAlluser() {
        return userMapperInf.userEntityToResponse(userRepository.findAll().stream().collect(Collectors.toSet()));
    }
    
}
