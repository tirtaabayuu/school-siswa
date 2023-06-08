package com.schoolsiswa.schoolsiswa.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SiswaUpdateRequest {


    @NotBlank(message = "name can't be empty")
    private String name;


}
