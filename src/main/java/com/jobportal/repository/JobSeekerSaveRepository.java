package com.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jobportal.entity.JobPostActivity;
import com.jobportal.entity.JobSeekerProfile;
import com.jobportal.entity.JobSeekerSave;

@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {

    public List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);

    List<JobSeekerSave> findByJob(JobPostActivity job);

    @Modifying
    @Query(value = "DELETE FROM job_seeker_save WHERE job = :jobId", nativeQuery = true)
    void deleteByJobId(@Param("jobId") int jobId);
}
