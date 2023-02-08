package com.jalivv.boot.service.impl;

import com.jalivv.boot.entity.NftOrderInfo;
import com.jalivv.boot.mapper.NftOrderInfoMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.jalivv.boot.service.NftOrderInfoService;

@Service
public class NftOrderInfoServiceImpl extends ServiceImpl<NftOrderInfoMapper, NftOrderInfo> implements NftOrderInfoService {

    @Override
    public int batchInsert(List<NftOrderInfo> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(NftOrderInfo record) {
        return baseMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(NftOrderInfo record) {
        return baseMapper.insertOrUpdateSelective(record);
    }
}



