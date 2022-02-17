package com.dao;

import com.domain.PromotionAd;
import com.domain.PromotionAdVO;

import java.util.List;

public interface PromotionAdMapper {
    /*
        分页查询广告信息
     */
    public List<PromotionAd> findAllPromotionAdByPage();

    /*
        广告动态上下线
     */
    public void updatePromotionAdStatus(PromotionAd promotionAd);
}
