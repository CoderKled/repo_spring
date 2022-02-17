package com.service;

import com.domain.PromotionSpace;

import java.util.List;

public interface PromotionSpaceService {
    /*
      获取所有广告位
   */
    public List<PromotionSpace> findAllPromotionSpace();
    /*
     添加广告位
  */
    public void savePromotionSpace(PromotionSpace promotionSpace);

    /*
       根据ID找广告位信息
    */
    public PromotionSpace findPromotionSpaceById(Integer id);

    /*
        更新广告位名称
     */
    public void updatePromotionSpace(PromotionSpace promotionSpace);
}
