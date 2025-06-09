package com.nuevaeps.auth.infrastruture.input.controller;

import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nuevaeps.auth.application.input.UserUseCase;
import com.nuevaeps.auth.infrastruture.input.models.FilterUserRequest;
import com.nuevaeps.auth.infrastruture.input.models.ResponseUser;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user/v1")
@RequiredArgsConstructor
public class ControllerUser {

        private final UserUseCase userUseCase;

        @Operation(
                summary = "Obtener todos usuarios",
                description = "Obtener todos usuarios"
        )
        @GetMapping(
                value = "/getAll"
        )
        public Set<ResponseUser> getAlluser() {
                return userUseCase.getAlluser();
        }

        @Operation(
                summary = "Obtener usuarios paginacion",
                description = "Obtener usuarios paginacion"
        )
        @GetMapping(
                value = "/getPag"
        )
        public Page<ResponseUser> getPagUser(@ModelAttribute FilterUserRequest filterUserRequest) {
                return userUseCase.getPagUser(filterUserRequest);
        }

        @Operation(
                summary = "Obtener usuarios por ids",
                description = "Obtener usuarios por ids"
        )
        @GetMapping(
                value = "/getByIds"
        )
        public Set<ResponseUser> getByIds(@RequestParam(value="userIds") Set<Integer> userIds) {
                return userUseCase.getByIds(userIds);
        }
}
