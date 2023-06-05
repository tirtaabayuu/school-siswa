package com.schoolsiswa.schoolsiswa.payload.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SiswaResponse {

    private Long id;

    private String nis;

    private String name;

    private String major;

    private String university;
}
