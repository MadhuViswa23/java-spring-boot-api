package com.demo.hellospring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.hellospring.repository.PatientRepository;

@Service
public class MergedDataService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Object[]> getMergedData() {
        return patientRepository.mergePatientAndDoctorData();
    }
}

