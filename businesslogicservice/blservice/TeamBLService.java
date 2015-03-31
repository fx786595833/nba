package blservice;

import java.util.ArrayList;

import vo.teamVO;

public interface TeamBLService {
	public ArrayList<teamVO> getAllTeamData();
	public ArrayList<teamVO> getSingleTeamData(String team);
}
