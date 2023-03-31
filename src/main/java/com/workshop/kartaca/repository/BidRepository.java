package com.workshop.kartaca.repository;

import com.workshop.kartaca.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Integer> {

}
