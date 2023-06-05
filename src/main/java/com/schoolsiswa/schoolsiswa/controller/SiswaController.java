package com.schoolsiswa.schoolsiswa.controller;


import com.schoolsiswa.schoolsiswa.payload.request.SiswaRequest;
import com.schoolsiswa.schoolsiswa.payload.request.SiswaUpdateRequest;
import com.schoolsiswa.schoolsiswa.payload.response.SiswaResponse;
import com.schoolsiswa.schoolsiswa.payload.response.WebResponse;
import com.schoolsiswa.schoolsiswa.service.SiswaService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/siswa")
public class SiswaController {

    private static final Logger LOG = LoggerFactory.getLogger(SiswaController.class);

    private final SiswaService siswaService;

    public SiswaController(SiswaService siswaService) {
        this.siswaService = siswaService;
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<WebResponse<SiswaResponse>> save(@Valid @RequestBody SiswaRequest siswaRequest) {
        LOG.info("Save data all siswa");
        SiswaResponse siswaResponse = siswaService.save(siswaRequest);
        WebResponse<SiswaResponse> webResponse = new WebResponse<>(
                HttpStatus.CREATED.value(),
                HttpStatus.CREATED.getReasonPhrase(),
                siswaResponse
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(webResponse);

    }

    @GetMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<WebResponse<List<SiswaResponse>>> findAll() {
        LOG.info("Get all data siswa");
        List<SiswaResponse> siswaResponses = siswaService.findAll();
        WebResponse<List<SiswaResponse> > webResponse = new WebResponse<>(
                HttpStatus.OK.value(),
                HttpStatus.OK.getReasonPhrase(),
                siswaResponses
        );

        return ResponseEntity.status(HttpStatus.OK).body(webResponse);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<WebResponse<SiswaResponse>> findById(@PathVariable("id") Long id) {
        LOG.info("Get data siswa by id");
        SiswaResponse siswaResponse = siswaService.findById(id);
        WebResponse<SiswaResponse> webResponse = new WebResponse<>(
                HttpStatus.OK.value(),
                HttpStatus.OK.getReasonPhrase(),
                siswaResponse
        );

        return ResponseEntity.status(HttpStatus.OK).body(webResponse);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<WebResponse<String>> deleteById(@PathVariable("id") Long id) {
        LOG.info("Delete data siswa by id");
        siswaService.deleteById(id);
        WebResponse<String> webResponse = new WebResponse<>(
                HttpStatus.OK.value(),
                HttpStatus.OK.getReasonPhrase(),
                String.format("successfully delete siswa data with id %s", id)
        );

        return ResponseEntity.status(HttpStatus.OK).body(webResponse);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<WebResponse<SiswaResponse>> updateById(@PathVariable("id") Long id, @RequestBody SiswaUpdateRequest siswaUpdateRequest) {
        LOG.info("Update data school news by id");
        SiswaResponse siswaResponse = siswaService.updateById(id, siswaUpdateRequest);
        WebResponse<SiswaResponse> webResponse = new WebResponse<>(
                HttpStatus.OK.value(),
                HttpStatus.OK.getReasonPhrase(),
                siswaResponse
        );

        return ResponseEntity.status(HttpStatus.OK).body(webResponse);

    }

    @DeleteMapping(value = "/all", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<WebResponse<String>> deleteAll() {
        LOG.info("Delete all data siswa ");
        siswaService.deleteAll();
        WebResponse<String> webResponse = new WebResponse<>(
                HttpStatus.OK.value(),
                HttpStatus.OK.getReasonPhrase(),
                String.format("Successfully delete all data siswa ")
        );

        return ResponseEntity.status(HttpStatus.OK).body(webResponse);
    }
}
