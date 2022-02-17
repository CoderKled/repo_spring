package com.service;

import com.domain.PromotionAd;
import com.domain.PromotionAdVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface PromotionAdService {
    /*\
        分页查询广告信息
     */
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO);

    /*
      广告动态上下线
   */
    public void updatePromotionAdStatus(Integer id, Integer status);
}
