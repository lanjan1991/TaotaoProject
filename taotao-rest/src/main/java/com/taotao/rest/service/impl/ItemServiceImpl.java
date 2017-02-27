package com.taotao.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.rest.service.ItemService;
import com.taotao.result.TaotaoResult;

/**
 * 商品信息管理Service
 * @author Administrator
 *
 */
@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private TbItemMapper itemMapper;

	@Override
	public TaotaoResult getItemBaseInfo(long itemId) {
		//根据商品id查询商品信息
		TbItem item = itemMapper.selectByPrimaryKey(itemId);
		//使用TaotaoResult包装一下
		return TaotaoResult.ok(item);
	}

}
