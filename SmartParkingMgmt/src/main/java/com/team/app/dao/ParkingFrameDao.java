package com.team.app.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.team.app.domain.TblParkingFrame;

public interface ParkingFrameDao extends JpaRepository<TblParkingFrame, Serializable> {

	@Query("select f From TblParkingFrame f order by f.id desc")
	List<TblParkingFrame> getParkingFrame();

	@Query("Select f from TblParkingFrame f group by f.devEUI")
	List<TblParkingFrame> getParkingFrames();

	@Query(value="Select f from TblParkingFrame f where f.devEUI=:devEUI order by f.id desc")
	List<TblParkingFrame> getParkingFrameByDevEUI(@Param("devEUI") String devEUI);

}
