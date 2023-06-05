package com.schoolsiswa.schoolsiswa.service;

import com.schoolsiswa.schoolsiswa.payload.request.SiswaRequest;
import com.schoolsiswa.schoolsiswa.payload.request.SiswaUpdateRequest;
import com.schoolsiswa.schoolsiswa.payload.response.SiswaResponse;

import java.util.List;

public interface SiswaService {

    SiswaResponse save(SiswaRequest siswaRequest);
    List<SiswaResponse> findAll();
    SiswaResponse findById (Long id);

    void deleteById (Long id);
    void deleteAll();

    SiswaResponse updateById (Long id, SiswaUpdateRequest siswaUpdateRequest);
}
