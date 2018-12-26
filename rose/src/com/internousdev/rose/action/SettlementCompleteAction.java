package com.internousdev.rose.action;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.CartInfoDAO;
import com.internousdev.rose.dao.PurchaseHistoryInfoDAO;
import com.internousdev.rose.dto.DestinationInfoDTO;
import com.internousdev.rose.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementCompleteAction extends ActionSupport implements SessionAware{

	private int destinationId;
	private Map<String, Object>session;
	private String cartFlg;

	public String execute(){
		String result = ERROR;
//		セッションタイムアウトでエラー　
		if(!session.containsKey("mCategoryDTOList")){
			return ERROR;
		}

		@SuppressWarnings("unchecked")
		ArrayList<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = (ArrayList<PurchaseHistoryInfoDTO>)session.get("purchaseHistoryInfoDTOList");

		@SuppressWarnings("unchecked")
		ArrayList<DestinationInfoDTO> destinationInfoDTOList = (ArrayList<DestinationInfoDTO>)session.get("destinationInfoDTOList");
		for(int i=0; i<purchaseHistoryInfoDTOList.size(); i++){
			purchaseHistoryInfoDTOList.get(i).setDestinationId(destinationInfoDTOList.get(0).getId());
		}

		//purchase_histroy_infoにINSERT
		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
		int count = 0;
		for(int i=0; i<purchaseHistoryInfoDTOList.size(); i++){
			count += purchaseHistoryInfoDAO.regist(String.valueOf(session.get("loginId")),
					purchaseHistoryInfoDTOList.get(i).getProductId(),
					purchaseHistoryInfoDTOList.get(i).getProductCount(),
					destinationId,
					purchaseHistoryInfoDTOList.get(i).getPrice()
					);
		}

		if(count>0){
			CartInfoDAO cartInfoDAO = new CartInfoDAO();
//			if(count > 0){
//				List<CartInfoDTO> cartInfoDTOList = new ArrayList<CartInfoDTO>();
//				cartInfoDTOList = cartInfoDAO.getCartInfoDTOList(String.valueOf(session.get("loginId")));
//				Iterator<CartInfoDTO> iterator = cartInfoDTOList.iterator();
//				if(!(iterator.hasNext())){
//					cartInfoDTOList = null;
//				}
//				session.put("cartInfoDTOList",cartInfoDTOList);

//				int totalPrice = Integer.parseInt(String.valueOf(cartInfoDAO.getTotalPriceInCart(String.valueOf(session.get("loginId")))));
//				session.put("totalPrice", totalPrice);

//				カートフラグを削除
				cartFlg ="0";
				session.put("cartFlg", cartFlg);
				result = SUCCESS;
				count = cartInfoDAO.deleteAllInCart(String.valueOf(session.get("loginId")));

			}
//		}
		return result;
	}

	public int getDestinationId(){
		return destinationId;
	}

	public void setDestinationId(int destinationId){
		this.destinationId = destinationId;
	}

	public Map<String, Object>getSession(){
		return session;
	}

	public void setSession(Map<String, Object>session){
		this.session = session;
	}

	public String getCartFlg(){
		return cartFlg;
	}

	public void setCartFlg(String cartFlg){
		this.cartFlg=cartFlg;
	}

}
