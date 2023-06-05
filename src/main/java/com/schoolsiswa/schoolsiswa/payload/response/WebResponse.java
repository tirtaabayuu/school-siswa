package com.schoolsiswa.schoolsiswa.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class WebResponse <T>{

    private Integer code;

    private String status;

    private T data;

}
