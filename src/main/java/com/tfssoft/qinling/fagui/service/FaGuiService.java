package com.tfssoft.qinling.fagui.service;

import java.util.List;

import com.tfssoft.qinling.fagui.domain.Rule;

public interface FaGuiService {
	
	public List<Rule> getFaGuiList(Integer skip, Integer limit, String name);

	public long getFaGuiCount(String name);

	public void addFaGui(Rule instance);

	public void deleteFaGui(int id);

	public void updateFaGui(Rule instance);

}
