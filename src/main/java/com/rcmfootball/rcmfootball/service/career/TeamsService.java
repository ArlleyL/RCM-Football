package com.rcmfootball.rcmfootball.service.career;

import com.rcmfootball.rcmfootball.request.career.TeamsRequest;
import com.rcmfootball.rcmfootball.request.career.UpdateTeamReq;
import com.rcmfootball.rcmfootball.response.career.TeamsResponse;

public interface TeamsService {

	TeamsResponse createTeamPlayerMode(TeamsRequest teamReq, String username);

	TeamsResponse updateTeamPlayerMode(UpdateTeamReq teamReq, String username, Long id);

	TeamsResponse createTeamManagerMode(TeamsRequest teamReq, String username);

	TeamsResponse updateTeamManagerMode(UpdateTeamReq teamReq, String username, Long id);

}
