package com.pwi.services.ui.pageHandlers.base;

import java.util.LinkedHashMap;

import com.pwi.interfaces.IPageHandler;

public class Pagehandler {
	private static LinkedHashMap<String, IPageHandler> pageHandlerMap = new LinkedHashMap<String, IPageHandler>();

	private Pagehandler() {

	}

	public static IPageHandler getPageHandler(String name) {
		if (pageHandlerMap.containsKey(name))
			return pageHandlerMap.get(name);
		else
			return null;
	}

	public LinkedHashMap<String, IPageHandler> getPageHandlerMap() {
		return pageHandlerMap;
	}

	public void setPageHandlerMap(LinkedHashMap<String, IPageHandler> pageHandlerMap) {
		Pagehandler.pageHandlerMap = pageHandlerMap;
	}

}
