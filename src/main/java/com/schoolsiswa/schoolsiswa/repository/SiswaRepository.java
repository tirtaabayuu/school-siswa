package com.schoolsiswa.schoolsiswa.repository;

import com.schoolsiswa.schoolsiswa.entity.SiswaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiswaRepository extends JpaRepository <SiswaEntity, Long> {

}