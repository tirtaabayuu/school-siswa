package com.schoolsiswa.schoolsiswa.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse <T> {

    private Integer code;

    private String status;

    private T error;

}
