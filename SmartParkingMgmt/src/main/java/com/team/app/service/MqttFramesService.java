package com.team.app.service;

import java.util.List;

import com.team.app.domain.DownlinkQueue;
import com.team.app.domain.LoraFrame;
import com.team.app.domain.TblParkingFrame;

public interface MqttFramesService {

	void updateFrame(LoraFrame frame)throws Exception;

	List<LoraFrame> getFrames()throws Exception;

	List<LoraFrame> getFramesByLoraIdAndDevId(String loraId, String deviceId)throws Exception;

	List<LoraFrame> getFrameByDeviceId()throws Exception;

	List<LoraFrame> getFrameByDevId(String deviceId, String nodeName)throws Exception;

	void saveDownlink(DownlinkQueue q)throws Exception;

	List<DownlinkQueue> getDownlinkQueue()throws Exception;

	void deleteDownlinkQuere()throws Exception;

	List<TblParkingFrame> getParkingFrame()throws Exception;

	List<TblParkingFrame> getParkingFrames()throws Exception;

	List<TblParkingFrame> getParkingFrameByDevEUI(String devEUI)throws Exception;

}
