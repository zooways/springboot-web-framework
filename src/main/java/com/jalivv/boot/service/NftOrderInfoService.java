package com.jalivv.boot.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jalivv.boot.entity.NftOrderInfo;

public interface NftOrderInfoService extends IService<NftOrderInfo> {


    int batchInsert(List<NftOrderInfo> list);

    int insertOrUpdate(NftOrderInfo record);

    int insertOrUpdateSelective(NftOrderInfo record);

}



