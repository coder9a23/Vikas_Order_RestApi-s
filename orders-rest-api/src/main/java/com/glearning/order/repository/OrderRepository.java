package com.glearning.order.repository;

import org.springframework.boot.autoconfigure.web.servlet.JerseyApplicationPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.glearning.order.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
	

}
