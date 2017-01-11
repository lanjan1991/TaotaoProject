package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.pojo.TbItem;
import com.taotao.result.TaotaoResult;

public interface ItemService {

	TbItem getItemById(long itemId);
	EUDataGridResult getItemList(int page, int rows);
	TaotaoResult create(TbItem item, String desc, String itemParam) throws Exception;
}
