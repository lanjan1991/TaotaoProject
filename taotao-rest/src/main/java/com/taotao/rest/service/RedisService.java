package com.taotao.rest.service;

import com.taotao.result.TaotaoResult;

public interface RedisService {
	
	TaotaoResult syncContent(long contentCid);

}
