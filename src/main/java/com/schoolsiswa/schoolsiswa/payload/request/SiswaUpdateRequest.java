package com.schoolsiswa.schoolsiswa.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SiswaUpdateRequest {

    @NotBlank(message = "nis can't be empty")
    private String nis;

    @NotBlank(message = "name can't be empty")
    private String name;

    @NotBlank(message = "major can't be empty")
    private String major;

    @NotBlank(message = "university can't be empty")
    private String university;
}
