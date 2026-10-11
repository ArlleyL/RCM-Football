package com.rcmfootball.rcmfootball.service.career;

import com.rcmfootball.rcmfootball.request.career.ManagersRequest;
import com.rcmfootball.rcmfootball.request.career.UpdateManagersReq;
import com.rcmfootball.rcmfootball.response.career.ManagersResponse;

public interface ManagerModeService {

	ManagersResponse createManagerCharacter(ManagersRequest managerReq, String username);

	ManagersResponse updateManagerCharacter(UpdateManagersReq managerReq, String username);

	ManagersResponse createManager(ManagersRequest managerReq, String username);

	ManagersResponse updateManager(UpdateManagersReq managerReq, Long id);

	ManagersResponse createManagerPlayerMode(ManagersRequest managerReq, String username);

	ManagersResponse updateManagerPlayerMode(UpdateManagersReq managerReq, Long id);

}
