package com.taotao.sso.service;

import com.taotao.result.TaotaoResult;

public interface UserService {

	TaotaoResult checkData(String content, Integer type);
}
