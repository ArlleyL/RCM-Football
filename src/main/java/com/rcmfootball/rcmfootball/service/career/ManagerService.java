package com.rcmfootball.rcmfootball.service.career;

import java.util.List;

import com.rcmfootball.rcmfootball.request.career.ManagersRequest;
import com.rcmfootball.rcmfootball.request.career.UpdateManagersReq;
import com.rcmfootball.rcmfootball.response.career.ManagersResponse;

public interface ManagerService {

	ManagersResponse managerCharacterProfile(String username);
	
	ManagersResponse createManagerCharacter(ManagersRequest managerReq, String username);

	ManagersResponse updateManagerCharacter(UpdateManagersReq managerReq, String username);

	ManagersResponse createManager(ManagersRequest managerReq, String username);

	ManagersResponse updateManager(UpdateManagersReq managerReq, Long id);

	ManagersResponse createManagerPlayerMode(ManagersRequest managerReq, String username);

	ManagersResponse updateManagerPlayerMode(UpdateManagersReq managerReq, Long id, String username);

	List<ManagersResponse> findAllManagersByUser(String username);

	List<ManagersResponse> allManagerOfPlayerMode(String username);

}
