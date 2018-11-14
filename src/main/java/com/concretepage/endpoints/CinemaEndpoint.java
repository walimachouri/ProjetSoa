package com.concretepage.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.concretepage.entity.Cinema;
import com.concretepage.gs_ws.AddCinemaRequest;
import com.concretepage.gs_ws.AddCinemaResponse;
import com.concretepage.gs_ws.CinemaInfo;
import com.concretepage.gs_ws.DeleteCinemaRequest;
import com.concretepage.gs_ws.DeleteCinemaResponse;
import com.concretepage.gs_ws.GetAllCinemasResponse;
import com.concretepage.gs_ws.GetCinemaByIdRequest;
import com.concretepage.gs_ws.GetCinemaByIdResponse;
import com.concretepage.gs_ws.ServiceStatus;
import com.concretepage.gs_ws.UpdateCinemaRequest;
import com.concretepage.gs_ws.UpdateCinemaResponse;
import com.concretepage.service.ICinemaService;

@Endpoint
public class CinemaEndpoint {
	private static final String NAMESPACE_URI = "http://www.concretepage.com/cinema-ws";
	@Autowired
	private ICinemaService cinemaService;

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCinemaByIdRequest")
	@ResponsePayload
	public GetCinemaByIdResponse getCinema(@RequestPayload GetCinemaByIdRequest request) {
		GetCinemaByIdResponse response = new GetCinemaByIdResponse();
		CinemaInfo cinemaInfo = new CinemaInfo();
		BeanUtils.copyProperties(cinemaService.getCinemaById(request.getCinemaId()), cinemaInfo);
		response.setCinemaInfo(cinemaInfo);
		return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCinemasRequest")
	@ResponsePayload
	public GetAllCinemasResponse getAllCinemas() {
		GetAllCinemasResponse response = new GetAllCinemasResponse();
		List<CinemaInfo> cinemaInfoList = new ArrayList<>();
		List<Cinema> cinemaList = cinemaService.getAllCinemas();
		for (int i = 0; i < cinemaList.size(); i++) {
			 CinemaInfo ob = new CinemaInfo();
		     BeanUtils.copyProperties(cinemaList.get(i), ob);
		     cinemaInfoList.add(ob);
		}
		response.getCinemaInfo().addAll(cinemaInfoList);
		return response;
	}	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCinemaRequest")
	@ResponsePayload
	public AddCinemaResponse addCinema(@RequestPayload AddCinemaRequest request) {
		AddCinemaResponse response = new AddCinemaResponse();
    	ServiceStatus serviceStatus = new ServiceStatus();		
		Cinema cinema = new Cinema();
		cinema.setTitle(request.getTitle());
		cinema.setAdresse(request.getAdresse());
        boolean flag = cinemaService.addCinema(cinema);
        if (flag == false) {
        	serviceStatus.setStatusCode("CONFLICT");
        	serviceStatus.setMessage("Content Already Available");
        	response.setServiceStatus(serviceStatus);
        } else {
			CinemaInfo cinemaInfo = new CinemaInfo();
	        BeanUtils.copyProperties(cinema, cinemaInfo);
			response.setCinemaInfo(cinemaInfo);
        	serviceStatus.setStatusCode("SUCCESS");
        	serviceStatus.setMessage("Content Added Successfully");
        	response.setServiceStatus(serviceStatus);
        }
        return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCinemaRequest")
	@ResponsePayload
	public UpdateCinemaResponse updateCinema(@RequestPayload UpdateCinemaRequest request) {
		Cinema cinema = new Cinema();
		BeanUtils.copyProperties(request.getCinemaInfo(), cinema);
		cinemaService.updateCinema(cinema);
    	ServiceStatus serviceStatus = new ServiceStatus();
    	serviceStatus.setStatusCode("SUCCESS");
    	serviceStatus.setMessage("Content Updated Successfully");
    	UpdateCinemaResponse response = new UpdateCinemaResponse();
    	response.setServiceStatus(serviceStatus);
    	return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCinemaRequest")
	@ResponsePayload
	public DeleteCinemaResponse deleteCinema(@RequestPayload DeleteCinemaRequest request) {
		Cinema cinema = cinemaService.getCinemaById(request.getCinemaId());
    	ServiceStatus serviceStatus = new ServiceStatus();
		if (cinema == null ) {
	    	serviceStatus.setStatusCode("FAIL");
	    	serviceStatus.setMessage("Content Not Available");
		} else {
			cinemaService.deleteCinema(cinema);
	    	serviceStatus.setStatusCode("SUCCESS");
	    	serviceStatus.setMessage("Content Deleted Successfully");
		}
    	DeleteCinemaResponse response = new DeleteCinemaResponse();
    	response.setServiceStatus(serviceStatus);
		return response;
	}	
}
