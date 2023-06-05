package com.schoolsiswa.schoolsiswa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "siswa")
public class SiswaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nis;

    @NotBlank
//    @Column (name ="name", nullable = false)
    private String name;

    @NotBlank
//    @Column (name = "major", nullable = false)
    private String major;

    @NotBlank
    @Column (columnDefinition = "TEXT")
    private String university;

}
