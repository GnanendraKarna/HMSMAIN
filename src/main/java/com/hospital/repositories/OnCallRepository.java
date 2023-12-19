package com.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entities.OnCall;
import com.hospital.entities.id.OnCallId;

public interface OnCallRepository extends JpaRepository<OnCall, OnCallId> {

}
