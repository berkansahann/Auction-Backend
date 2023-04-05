package com.workshop.kartaca.repository;

import com.workshop.kartaca.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Integer> {

    List<Bid> getBidsByItem_Id(int id);
}
