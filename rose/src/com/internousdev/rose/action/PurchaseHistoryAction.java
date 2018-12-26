package com.internousdev.rose.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.PurchaseHistoryInfoDAO;
import com.internousdev.rose.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class PurchaseHistoryAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	public String execute() {

		//セッションタイムアウト
				if(!session.containsKey("mCategoryDTOList")){
					return ERROR;
				}

		PurchaseHistoryInfoDAO dao = new PurchaseHistoryInfoDAO();
		List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();
		purchaseHistoryInfoDTOList = dao.getPurchaseHistoryList(session.get("loginId").toString());
		Iterator<PurchaseHistoryInfoDTO> iterator = purchaseHistoryInfoDTOList.iterator();
		if(!(iterator.hasNext())) {
			purchaseHistoryInfoDTOList = null;
		}
		session.put("purchaseHistoryInfoDTOList", purchaseHistoryInfoDTOList);
		return SUCCESS;
	}

	public Map<String, Object> getSession(){
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
