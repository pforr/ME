package com.mcvn.project.service;

import com.mcvn.project.model.DataItem;

public interface DataItemService {
	public String getTenTinh(String node1);

	public String getTenHuyen(String node1, String node2);
	public DataItem getItem(String node1, String node2);
}
