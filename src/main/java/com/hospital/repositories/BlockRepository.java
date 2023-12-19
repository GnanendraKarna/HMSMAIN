package com.hospital.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital.entities.Block;
import com.hospital.entities.id.BlockId;

public interface BlockRepository extends JpaRepository<Block, BlockId> {

}
