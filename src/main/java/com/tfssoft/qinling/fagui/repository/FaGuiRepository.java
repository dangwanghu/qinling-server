package com.tfssoft.qinling.fagui.repository;

import java.util.List;

import com.tfssoft.qinling.fagui.domain.Rule;

public interface FaGuiRepository {

	public List<Rule> getFaGuiList(String name);

	public List<Rule> getFaGuiPageList(String name, int skip, int limit);

	public long getCunZhuangCount(String name);

	public void addFaGui(Rule instance);

	public void deleteFaGui(int id);

	public void updateFaGui(Rule instance);
}
