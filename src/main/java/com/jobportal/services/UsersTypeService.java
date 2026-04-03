package com.jobportal.services;

import com.jobportal.entity.UsersType;
import com.jobportal.repository.UsersTypeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersTypeService {

    private static final String RECRUITER = "Recruiter";
    private static final String JOB_SEEKER = "Job Seeker";

    private final UsersTypeRepository usersTypeRepository;

    public UsersTypeService(UsersTypeRepository usersTypeRepository) {
        this.usersTypeRepository = usersTypeRepository;
    }

    public List<UsersType> getAll() {
        ensureDefaultTypes();
        return usersTypeRepository.findAll();
    }

    public Optional<UsersType> getById(Integer id) {
        if (id == null) {
            return Optional.empty();
        }
        return usersTypeRepository.findById(id);
    }

    private void ensureDefaultTypes() {
        List<UsersType> missingTypes = new ArrayList<>();

        if (usersTypeRepository.findByUserTypeNameIgnoreCase(RECRUITER).isEmpty()) {
            UsersType recruiter = new UsersType();
            recruiter.setUserTypeName(RECRUITER);
            missingTypes.add(recruiter);
        }

        if (usersTypeRepository.findByUserTypeNameIgnoreCase(JOB_SEEKER).isEmpty()) {
            UsersType jobSeeker = new UsersType();
            jobSeeker.setUserTypeName(JOB_SEEKER);
            missingTypes.add(jobSeeker);
        }

        if (!missingTypes.isEmpty()) {
            usersTypeRepository.saveAll(missingTypes);
        }
    }
}
