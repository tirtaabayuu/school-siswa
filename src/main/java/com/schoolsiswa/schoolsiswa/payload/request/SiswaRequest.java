package com.schoolsiswa.schoolsiswa.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SiswaRequest {


    @NotBlank(message = "name can't be empty")
    private String name;



}