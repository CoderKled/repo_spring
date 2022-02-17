package com.service.impl;

import com.dao.PromotionAdMapper;
import com.domain.PromotionAd;
import com.domain.PromotionAdVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service
public class PromotionAdServiceImpl implements PromotionAdService {
    @Autowired
    private PromotionAdMapper promotionAdMapper;

    @Override
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO) {

        PageHelper.startPage(promotionAdVO.getCurrentPage(),promotionAdVO.getPageSize());
        //由于已经配置了PageHelper而上以上已经进行了设置，所以这里得到的List已经是分页后的结果
        List<PromotionAd> list = promotionAdMapper.findAllPromotionAdByPage();

        //将上面查询到的分页信息封装成一个专门存储分页信息的对象，然后返回
        PageInfo<PromotionAd> adPageInfo = new PageInfo<>(list);

        return adPageInfo;
    }

    @Override
    public void updatePromotionAdStatus(Integer id, Integer status) {
        PromotionAd promotionAd = new PromotionAd();
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        promotionAd.setUpdateTime(new Date());

        promotionAdMapper.updatePromotionAdStatus(promotionAd);
    }
}
