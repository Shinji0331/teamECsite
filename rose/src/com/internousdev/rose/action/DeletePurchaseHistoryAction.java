package com.internousdev.rose.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.PurchaseHistoryInfoDAO;
import com.internousdev.rose.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeletePurchaseHistoryAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
	public String execute() {
		String result = ERROR;

		//セッションタイムアウト
				if(!session.containsKey("mCategoryDTOList")){
					return ERROR;
				}
		PurchaseHistoryInfoDAO  dao = new PurchaseHistoryInfoDAO();
		int count = dao.deleteAll(String.valueOf(session.get("loginId")));
		if(count > 0) {
			List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList  = dao.getPurchaseHistoryList(String.valueOf(session.get("loginId")));
			Iterator<PurchaseHistoryInfoDTO> iterator = purchaseHistoryInfoDTOList.iterator();
			if(!(iterator.hasNext())) {
				purchaseHistoryInfoDTOList = null;
			}
			session.put("purchaseHistoryInfoDTOList", purchaseHistoryInfoDTOList);

			result = SUCCESS;
		}
		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
