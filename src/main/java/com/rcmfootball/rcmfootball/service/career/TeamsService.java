package com.rcmfootball.rcmfootball.service.career;

import java.util.List;

import com.rcmfootball.rcmfootball.request.career.TeamsRequest;
import com.rcmfootball.rcmfootball.request.career.UpdateTeamReq;
import com.rcmfootball.rcmfootball.response.career.TeamsResponse;

public interface TeamsService {

	List<TeamsResponse> findAllTeamPlayerMode(String username);
	TeamsResponse createTeamPlayerMode(TeamsRequest teamReq, String username);
	TeamsResponse updateTeamPlayerMode(UpdateTeamReq teamReq, String username, Long id);

	List<TeamsResponse> findAllTeamManagerMode(String username);
	TeamsResponse createTeamManagerMode(TeamsRequest teamReq, String username);
	TeamsResponse updateTeamManagerMode(UpdateTeamReq teamReq, String username, Long id);


}
