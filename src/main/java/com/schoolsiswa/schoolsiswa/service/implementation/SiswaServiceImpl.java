package com.schoolsiswa.schoolsiswa.service.implementation;

import com.schoolsiswa.schoolsiswa.entity.SiswaEntity;
import com.schoolsiswa.schoolsiswa.exception.DataNotFoundException;
import com.schoolsiswa.schoolsiswa.payload.request.SiswaRequest;
import com.schoolsiswa.schoolsiswa.payload.request.SiswaUpdateRequest;
import com.schoolsiswa.schoolsiswa.payload.response.SiswaResponse;
import com.schoolsiswa.schoolsiswa.repository.SiswaRepository;
import com.schoolsiswa.schoolsiswa.service.SiswaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SiswaServiceImpl implements SiswaService {

    private static final Logger LOG = LoggerFactory.getLogger(SiswaServiceImpl.class);

    private SiswaRepository siswaRepository;

//    @Autowired
    public SiswaServiceImpl (SiswaRepository siswaRepository) {
        this.siswaRepository = siswaRepository;
    }

    @Override
    public SiswaResponse save(SiswaRequest siswaRequest){
        LOG.info("Save new siswa to database");

        SiswaEntity siswaEntity = new SiswaEntity();
        siswaEntity.setNis(siswaRequest.getNis());
        siswaEntity.setName(siswaRequest.getName());

        SiswaEntity response = siswaRepository.save(siswaEntity);
        SiswaResponse siswaResponse = new SiswaResponse();
        siswaResponse.setId(response.getId());
        siswaResponse.setNis(response.getNis());
        siswaResponse.setName(response.getName());


        LOG.info("Successfully save new siswa to the database");
        return siswaResponse;
    }

    @Override
    public SiswaResponse findById (Long id) {
        LOG.info("Get data siswa by id");
        SiswaResponse siswaResponse = new SiswaResponse();
        SiswaEntity siswaEntity = siswaRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Data Not Found"));

        siswaResponse.setId(siswaEntity.getId());
        siswaResponse.setNis(siswaEntity.getNis());
        siswaResponse.setName(siswaEntity.getName());


        LOG.info("Successfully get siswa by Id");
        return siswaResponse;
    }

    @Override
    public List<SiswaResponse> findAll(){
        LOG.info("Get all data siswa");
        List<SiswaEntity> siswaEntity = siswaRepository.findAll();
        List<SiswaResponse> siswaResponses = new ArrayList<>();
        siswaEntity.stream().forEach(siswa -> {
            SiswaResponse siswaResponse = new SiswaResponse();

            siswaResponse.setId(siswa.getId());
            siswaResponse.setNis(siswa.getNis());
            siswaResponse.setName(siswa.getName());


            siswaResponses.add(siswaResponse);

        });

        LOG.info("Successfully get all data siswa");
        return siswaResponses;
    }

    @Override
    public void deleteById(Long id) {
        LOG.info("Delete data siswa by id");
        SiswaEntity siswaEntity = siswaRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Data Not Found"));

        siswaRepository.deleteById(siswaEntity.getId());
        LOG.info("Successfully delete data siswa by id");

    }

    @Override
    public void deleteAll() {
        LOG.info("Delete all data siswa");
        List<SiswaEntity> allSiswaEntity = siswaRepository.findAll();
        allSiswaEntity.forEach(siswa -> {

            siswaRepository.deleteById(siswa.getId());
        });
        LOG.info("Successfully delete all data siswa");
    }

    @Override
    public SiswaResponse updateById(Long id, SiswaUpdateRequest siswaUpdateRequest){
        LOG.info("Update news data siswa from database");
        SiswaEntity siswaEntity = siswaRepository.findById(id)
                .orElseThrow(()-> new DataNotFoundException("Data Not Found"));

        siswaEntity.setName(siswaUpdateRequest.getName());


        siswaRepository.save(siswaEntity);

        SiswaResponse siswaResponse = new SiswaResponse();
        siswaResponse.setId(siswaEntity.getId());
        siswaResponse.setNis(siswaEntity.getNis());
        siswaResponse.setName(siswaEntity.getName());


        LOG.info("Successfully update data siswa to the database");

        return siswaResponse;

    }


}
