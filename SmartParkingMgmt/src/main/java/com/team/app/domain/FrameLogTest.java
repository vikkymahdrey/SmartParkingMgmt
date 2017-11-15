package com.team.app.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the frame_log_test database table.
 * 
 */
@Entity
@Table(name="frame_log_test")
@NamedQuery(name="FrameLogTest.findAll", query="SELECT f FROM FrameLogTest f")
public class FrameLogTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDt;

	@Column(name="dev_eui")
	private String devEui;

	private String rx_info__rfChain;

	@Column(name="rx_info_channel")
	private String rxInfoChannel;

	private String rx_info_codeRate;

	private String rx_info_crcStatus;

	private String rx_info_dataRate;

	private String rx_info_dataRate_bandWidth;

	private String rx_info_dataRate_modulation;

	private String rx_info_dataRate_spreadFactor;

	private String rx_info_loRaSNR;

	@Column(name="rx_info_mac")
	private String rxInfoMac;

	@Column(name="rx_info_rssi")
	private String rxInfoRssi;

	@Column(name="rx_info_size")
	private String rxInfoSize;

	@Column(name="rx_info_time")
	private String rxInfoTime;

	public FrameLogTest() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatedDt() {
		return this.createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getDevEui() {
		return this.devEui;
	}

	public void setDevEui(String devEui) {
		this.devEui = devEui;
	}

	public String getRx_info__rfChain() {
		return this.rx_info__rfChain;
	}

	public void setRx_info__rfChain(String rx_info__rfChain) {
		this.rx_info__rfChain = rx_info__rfChain;
	}

	public String getRxInfoChannel() {
		return this.rxInfoChannel;
	}

	public void setRxInfoChannel(String rxInfoChannel) {
		this.rxInfoChannel = rxInfoChannel;
	}

	public String getRx_info_codeRate() {
		return this.rx_info_codeRate;
	}

	public void setRx_info_codeRate(String rx_info_codeRate) {
		this.rx_info_codeRate = rx_info_codeRate;
	}

	public String getRx_info_crcStatus() {
		return this.rx_info_crcStatus;
	}

	public void setRx_info_crcStatus(String rx_info_crcStatus) {
		this.rx_info_crcStatus = rx_info_crcStatus;
	}

	public String getRx_info_dataRate() {
		return this.rx_info_dataRate;
	}

	public void setRx_info_dataRate(String rx_info_dataRate) {
		this.rx_info_dataRate = rx_info_dataRate;
	}

	public String getRx_info_dataRate_bandWidth() {
		return this.rx_info_dataRate_bandWidth;
	}

	public void setRx_info_dataRate_bandWidth(String rx_info_dataRate_bandWidth) {
		this.rx_info_dataRate_bandWidth = rx_info_dataRate_bandWidth;
	}

	public String getRx_info_dataRate_modulation() {
		return this.rx_info_dataRate_modulation;
	}

	public void setRx_info_dataRate_modulation(String rx_info_dataRate_modulation) {
		this.rx_info_dataRate_modulation = rx_info_dataRate_modulation;
	}

	public String getRx_info_dataRate_spreadFactor() {
		return this.rx_info_dataRate_spreadFactor;
	}

	public void setRx_info_dataRate_spreadFactor(String rx_info_dataRate_spreadFactor) {
		this.rx_info_dataRate_spreadFactor = rx_info_dataRate_spreadFactor;
	}

	public String getRx_info_loRaSNR() {
		return this.rx_info_loRaSNR;
	}

	public void setRx_info_loRaSNR(String rx_info_loRaSNR) {
		this.rx_info_loRaSNR = rx_info_loRaSNR;
	}

	public String getRxInfoMac() {
		return this.rxInfoMac;
	}

	public void setRxInfoMac(String rxInfoMac) {
		this.rxInfoMac = rxInfoMac;
	}

	public String getRxInfoRssi() {
		return this.rxInfoRssi;
	}

	public void setRxInfoRssi(String rxInfoRssi) {
		this.rxInfoRssi = rxInfoRssi;
	}

	public String getRxInfoSize() {
		return this.rxInfoSize;
	}

	public void setRxInfoSize(String rxInfoSize) {
		this.rxInfoSize = rxInfoSize;
	}

	public String getRxInfoTime() {
		return this.rxInfoTime;
	}

	public void setRxInfoTime(String rxInfoTime) {
		this.rxInfoTime = rxInfoTime;
	}

}