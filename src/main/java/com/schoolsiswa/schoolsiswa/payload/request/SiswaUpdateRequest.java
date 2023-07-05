package com.schoolsiswa.schoolsiswa.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SiswaUpdateRequest {


    @NotNull(message = "nis can't be empty")
    private Integer nis;

    @NotBlank(message = "name can't be empty")
    private String name;


}
