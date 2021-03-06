package com.team.app.config;
import java.util.Date;

import javax.transaction.Transactional;

import org.apache.commons.codec.binary.Base64;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.team.app.dao.ParkingFrameDao;
import com.team.app.domain.TblParkingFrame;
import com.team.app.logger.AtLogger;

@Service
public class MqttBroker implements MqttCallback,MqttIntrf {
	
	private static final AtLogger logger = AtLogger.getLogger(MqttBroker.class);
	
		
	
	@Autowired
	private ParkingFrameDao parkingFrameDao;
	
	MqttClient client;
	
	MqttMessage message;
	
	
	
	public void doDemo() {
	    
	    try {
	    	logger.debug("/ INside MQTT Broker 4786e6ed00490101 ");
	    	MqttConnectOptions connOpts = new MqttConnectOptions();
	        connOpts.setUserName("loragw");
	        connOpts.setPassword("loragw".toCharArray());
	        connOpts.setCleanSession(true);
	        client = new MqttClient("tcp://139.59.14.31:1883", MqttClient.generateClientId());
	        
	        client.connect(connOpts);
	        client.setCallback(this);
	        client.subscribe("application/9/node/4786e6ed00490101/rx");
	        MqttMessage message = new MqttMessage();
	        message.setPayload("sending......."
	                .getBytes());
	        client.publish("application/9/node/4786e6ed00490101/tx", message);
	        System.out.println("Message printing here "+message);
	        //System.exit(0);
	    } catch (MqttException e) {
	        e.printStackTrace();
	    }
	    
	    try {
	    	logger.debug("/ INside MQTT Broker 4786e6ed00490102 ");
	    	MqttConnectOptions connOpts = new MqttConnectOptions();
	        connOpts.setUserName("loragw");
	        connOpts.setPassword("loragw".toCharArray());
	        connOpts.setCleanSession(true);
	        client = new MqttClient("tcp://139.59.14.31:1883", MqttClient.generateClientId());
	        
	        client.connect(connOpts);
	        client.setCallback(this);
	        client.subscribe("application/9/node/4786e6ed00490102/rx");
	        MqttMessage message = new MqttMessage();
	        message.setPayload("sending......."
	                .getBytes());
	        client.publish("application/9/node/4786e6ed00490102/tx", message);
	        System.out.println("Message printing here "+message);
	        //System.exit(0);
	    } catch (MqttException e) {
	        e.printStackTrace();
	    }
	    
	    try {
	    	logger.debug("/ INside MQTT Broker 4786e6ed00490103 ");
	    	MqttConnectOptions connOpts = new MqttConnectOptions();
	        connOpts.setUserName("loragw");
	        connOpts.setPassword("loragw".toCharArray());
	        connOpts.setCleanSession(true);
	        client = new MqttClient("tcp://139.59.14.31:1883", MqttClient.generateClientId());
	        
	        client.connect(connOpts);
	        client.setCallback(this);
	        client.subscribe("application/9/node/4786e6ed00490103/rx");
	        MqttMessage message = new MqttMessage();
	        message.setPayload("sending......."
	                .getBytes());
	        client.publish("application/9/node/4786e6ed00490103/tx", message);
	        System.out.println("Message printing here "+message);
	        //System.exit(0);
	    } catch (MqttException e) {
	        e.printStackTrace();
	    }
	    
	    
	    
	   
	    
	   
	}

	
	public void connectionLost(Throwable cause) {
	    // TODO Auto-generated method stub

	}
	
	@Transactional
	public void messageArrived(String topic, MqttMessage message) throws Exception {
		logger.debug("Inside messageArrived");
		try{
			TblParkingFrame frame=null;
			if(!message.toString().isEmpty()){
				 
				  JSONObject json=null;
				  		json=new JSONObject();
				  		json=(JSONObject)new JSONParser().parse(message.toString());
				  		logger.debug("REsultant json",json);
				  		
				  		 frame=new TblParkingFrame();
				  		
				  		 frame.setApplicationID(json.get("applicationID").toString());
				  		 frame.setApplicationName(json.get("applicationName").toString());
				  		 frame.setNodeName(json.get("nodeName").toString());
				  		 frame.setDevEUI(json.get("devEUI").toString());
				  		logger.debug("applicationID",json.get("applicationID").toString());
							logger.debug("applicationName",json.get("applicationName").toString());
								logger.debug("nodeName",json.get("nodeName").toString());
									logger.debug("devEUI",json.get("devEUI").toString());
				  		 
				  		 JSONArray arr=(JSONArray) json.get("rxInfo");
				  		 
				  		 if(arr!=null && arr.size()>0){
	   						 for (int i = 0; i < arr.size(); i++) {
	   							 JSONObject jsonObj = (JSONObject) arr.get(i);
	   							 frame.setGatewayMac(jsonObj.get("mac").toString());
	   							 frame.setGatewayName(jsonObj.get("name").toString());
	   							 
		   							logger.debug("mac",jsonObj.get("mac").toString());
		   								logger.debug("name",jsonObj.get("name").toString());
	   						 }
				  		 }
				  		 
				  		
				  	  		logger.debug("Data",json.get("data").toString());
				   	  	frame.setCreatedAt(new Date(System.currentTimeMillis()));
				  	  	
				  	  	
				  	  	
				  	  	
				  	  	if(json.get("data")!=null){	
				  	  		 logger.debug("Data not empty");
				     		 byte[] decoded=Base64.decodeBase64(json.get("data").toString());
				     		 
				     		 	if(decoded!=null && decoded.length>0){
				     		 				     		 		 				  	  					
				  	  				int parkingstatus=decoded[0] & 0xFF;	
				  	  					logger.debug("parkingstatus hexa: ",parkingstatus);
				  	  				
				  	  				 String parkingstatusBinary = Integer.toBinaryString(parkingstatus);
				  	  				 	logger.debug("parkingstatusBinary Binary : ",parkingstatusBinary);
				  	  				 	
				  	  				 	if(parkingstatusBinary.length()==8){
				  	  				 		String status = parkingstatusBinary.substring(0, parkingstatusBinary.length()-7);	
				  	  				 		logger.debug("status If: ",status); 	
				  	  				 	
				  	  				 		String parkingNumber= parkingstatusBinary.substring(1);
				  	  				 		logger.debug("parkingNumber If: ",parkingNumber);
				  	  				 		
				  	  				 		frame.setStatus(status);
				  	  				 		frame.setParkingNumber(String.valueOf(Integer.parseInt(parkingNumber,2)));
				  	  				 	
				  	  				 	}else{
				  	  				 		logger.debug("IN else block parking ");					  	  				 	
				  	  				 		frame.setStatus("0");
				  	  				 		frame.setParkingNumber(String.valueOf(Integer.parseInt(parkingstatusBinary,2)));
				  	  				 		logger.debug("parking else : ",frame.getParkingNumber());
				  	  				 	}
				  	  				
				  	  			
				  	  					
				     		 		  	
				     		 		
				     		 	}
					
				  	  	}	
				  	  	
				  	  parkingFrameDao.save(frame);
				  		
				  		
				  		
				  		
		}
		
		}catch(Exception e){
			logger.error("Error",e);
			e.printStackTrace();
		}
	}

	
	/*public void messageArrived(String topic, MqttMessage message) throws Exception {
		logger.debug("Inside messageArrived");
		try{
			LoraFrame frame=null;
			if(!message.toString().isEmpty()){
				 
				  JSONObject json=null;
				  		json=new JSONObject();
				  		json=(JSONObject)new JSONParser().parse(message.toString());
				  		logger.debug("REsultant json",json);
				  		
				  		 frame=new LoraFrame();
				  		 frame.setApplicationID(json.get("applicationID").toString());
				  		 frame.setApplicationName(json.get("applicationName").toString());
				  		 frame.setNodeName(json.get("nodeName").toString());
				  		 frame.setDevEUI(json.get("devEUI").toString());
				  		logger.debug("applicationID",json.get("applicationID").toString());
							logger.debug("applicationName",json.get("applicationName").toString());
								logger.debug("nodeName",json.get("nodeName").toString());
									logger.debug("devEUI",json.get("devEUI").toString());
				  		 
				  		 JSONArray arr=(JSONArray) json.get("rxInfo");
				  		 
				  		 if(arr!=null && arr.size()>0){
	   						 for (int i = 0; i < arr.size(); i++) {
	   							 JSONObject jsonObj = (JSONObject) arr.get(i);
	   							 frame.setGatewayMac(jsonObj.get("mac").toString());
	   							 frame.setGatewayName(jsonObj.get("name").toString());
	   							 
		   							logger.debug("mac",jsonObj.get("mac").toString());
		   								logger.debug("name",jsonObj.get("name").toString());
	   						 }
				  		 }
				  		 
				  		
				  		logger.debug("fport",json.get("fPort").toString());
				  	  		logger.debug("Data",json.get("data").toString());
				  	  		
				  	  	frame.setfPort(json.get("fPort").toString().trim());
				  	  	frame.setCreatedAt(new Date(System.currentTimeMillis()));
				  	  	frame.setUpdatedAt(new Date(System.currentTimeMillis()));
				  	  	if(json.get("devEUI").toString().equalsIgnoreCase("4786e6ed00490044")){
				  	  		frame.setLoraId("1");
				  	  	}else if(json.get("devEUI").toString().equalsIgnoreCase("4786e6ed00490048")){
				  	  		frame.setLoraId("2");
				  	  	}
				  	  	
				  	  	
				  	  	if(json.get("data")!=null){	
				  	  		 logger.debug("Data not empty");
				     		 byte[] decoded=Base64.decodeBase64(json.get("data").toString());
				     		 
				     		 	if(decoded!=null && decoded.length>0){
				     		 		frame.setDeviceId(String.valueOf(decoded[0]));
				     		 		frame.setLength(String.valueOf(decoded[1]));
			  	  					frame.setLed1(String.valueOf(decoded[2]));
			  	  					frame.setLed2(String.valueOf(decoded[3]));
			  	  					frame.setLed3(String.valueOf(decoded[4]));
			  	  					frame.setLed4(String.valueOf(decoded[5]));
			  	  					frame.setTemperature(String.valueOf(decoded[6]));
			  	  					frame.setPressure(String.valueOf(decoded[7]));
			  	  					frame.setHumidity(String.valueOf(decoded[8]));
				     		 	}
					
				  	  	}	
				  	  	
				  		frameDao.save(frame);
				  		
				  		
				  		
				  		
		}
		
		}catch(Exception e){
			logger.error("Error",e);
			e.printStackTrace();
		}
	}*/

	
	


	public void deliveryComplete(IMqttDeliveryToken token) {
	    // TODO Auto-generated method stub

	}

}
