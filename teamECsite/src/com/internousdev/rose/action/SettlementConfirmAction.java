package com.internousdev.rose.action;

import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.rose.dao.CartInfoDAO;
import com.internousdev.rose.dao.DestinationInfoDAO;
import com.internousdev.rose.dto.CartInfoDTO;
import com.internousdev.rose.dto.DestinationInfoDTO;
import com.internousdev.rose.dto.PurchaseHistoryInfoDTO;
import com.internousdev.rose.util.CommonUtility;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementConfirmAction extends ActionSupport implements SessionAware{

	private Collection<String> checkList;
	private String productId;
	private String productName;
	private String productNameKana;
	private String imageFilePath;
	private String imageFileName;
	private String price;
	private String productCount;
	private Map<String,Object>session;

	public String execute() throws SQLException{
		try {
			String result="back";
//			ログインIDを保持していたら
			if(!session.containsKey("mCategoryDTOList")){
				return ERROR;
			}
//			セッションタイムアウトでエラーページ
			if(session.containsKey("loginId")){
//				宛先情報を格納
				DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
				List<DestinationInfoDTO> destinationInfoDTOList = new ArrayList<>();
				destinationInfoDTOList = destinationInfoDAO.getDestinationInfo(String.valueOf(session.get("loginId")));
				Iterator<DestinationInfoDTO> iterator = destinationInfoDTOList.iterator();
//				宛先情報が無い場合はnullを代入
				if(!(iterator.hasNext())){
					destinationInfoDTOList = null;
				}
				session.put("destinationInfoDTOList", destinationInfoDTOList);
			}

			List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTOList = new ArrayList<PurchaseHistoryInfoDTO>();

			CommonUtility commonUtility = new CommonUtility();
//			カートの商品情報の各項目のリスト化
			String[] productIdList = commonUtility.parseArrayList(productId);

			CartInfoDAO cdao = new CartInfoDAO();
//			各項目リストから購入履歴リストに格納
			for(int i=0; i<productIdList.length; i++){

				CartInfoDTO cdto = new CartInfoDTO();
				if(session.containsKey("loginId")) {
					cdto = cdao.getCartInfoDTOList(String.valueOf(session.get("loginId")),(String.valueOf(productIdList[i])));
				}else {
					cdto = cdao.getCartInfoDTOList(String.valueOf(session.get("tempUserId")),(String.valueOf(productIdList[i])));
				}
				PurchaseHistoryInfoDTO purchaseHistoryInfoDTO = new PurchaseHistoryInfoDTO();
				purchaseHistoryInfoDTO.setUserId(String.valueOf(session.get("loginId")));
				purchaseHistoryInfoDTO.setProductId(Integer.parseInt(String.valueOf(cdto.getProductId())));
				purchaseHistoryInfoDTO.setPrice(Integer.parseInt(String.valueOf(cdto.getPrice())));
				purchaseHistoryInfoDTO.setProductCount(Integer.parseInt(String.valueOf(cdto.getProductCount())));
				purchaseHistoryInfoDTOList.add(purchaseHistoryInfoDTO);
			}
			session.put("purchaseHistoryInfoDTOList", purchaseHistoryInfoDTOList);

//			ログインIDを保持していたらSUCCESS、保持していなければログインページへ
			if(!session.containsKey("loginId")){
//				カートフラグを追加
				String cartFlg = "1";
				session.put("cartFlg", cartFlg);
				result="back";
			}else{
				result=SUCCESS;
			}
			return result;
		} catch (NullPointerException e) {
			return ERROR;
		}



		}

//  ===============================================================================
	public Collection<String> getCheckList(){
		return checkList;
	}

	public void setCheckList(Collection<String>checkList){
		this.checkList=checkList;
	}

	public String getProductId(){
		return productId;
	}

	public void setProductId(String productId){
		this.productId=productId;
	}

	public Map<String, Object> getSession(){
		return session;
	}

	public void setSession(Map<String,Object>session){
		this.session=session;
	}

	public String getProductName(){
		return productName;
	}

	public void setProductName(String productName){
		this.productName=productName;
	}

	public String getProductNameKana(){
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana){
		this.productNameKana=productNameKana;
	}

	public String getImageFilePath(){
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath){
		this.imageFilePath=imageFilePath;
	}

	public String getImageFileName(){
		return imageFileName;
	}

	public void setImageFileName(String imageFileName){
		this.imageFileName=imageFileName;
	}

	public String getPrice(){
		return price;
	}

	public void setPrice(String price){
		this.price=price;
	}

	public String getProductCount(){
		return productCount;
	}

	public void setProductCount(String productCount){
		this.productCount=productCount;
	}

}
