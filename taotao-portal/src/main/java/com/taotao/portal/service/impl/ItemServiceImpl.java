package com.taotao.portal.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.taotao.common.utils.HttpClientUtil;
import com.taotao.portal.pojo.ItemInfo;
import com.taotao.portal.service.ItemService;
import com.taotao.result.TaotaoResult;

/**
 * 商品信息管理Service
 * @author Administrator
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${ITME_INFO_URL}")
	private String ITME_INFO_URL;

	@Override
	public ItemInfo getItemById(Long itemId) {

		try {
			//调用rest的服务查询商品基本信息
			String json = HttpClientUtil.doGet(REST_BASE_URL + ITME_INFO_URL + itemId);
			if (!StringUtils.isBlank(json)) {
				TaotaoResult taotaoResult = TaotaoResult.formatToPojo(json, ItemInfo.class);
				if (taotaoResult.getStatus() == 200) {
					ItemInfo item = (ItemInfo) taotaoResult.getData();
					return item;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
