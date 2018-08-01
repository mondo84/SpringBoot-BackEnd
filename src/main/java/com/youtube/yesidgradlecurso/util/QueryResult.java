package com.youtube.yesidgradlecurso.util;

import java.util.List;

public class QueryResult {
	
	private int totalRecords;
	private List<Object> list;
	
	public int getTotalRegistros() {
		return totalRecords;
	}
	public void setTotalRegistros(int totalRecords) {
		this.totalRecords = totalRecords;
	}
	public List<Object> getListaRegistros() {
		return list;
	}
	public void setListaRegistros(List<Object> list) {
		this.list = list;
	}
	
}
