package com.nuevaeps.auth.infrastruture.input.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilterUserRequest {
    private Long numberDocument;
    private String names;
    private String lastNames;
    private String email;
    private Boolean active;
    private Integer pagCurrent;
    private Integer cantRecords;

}
