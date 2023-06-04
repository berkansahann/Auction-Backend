package com.workshop.auction.repository;

import com.workshop.auction.entity.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BidRepository extends JpaRepository<Bid, Integer> {

    List<Bid> getBidsByItem_Id(int id);
}
