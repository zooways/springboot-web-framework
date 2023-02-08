package com.jalivv.boot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jalivv.boot.entity.NftOrderInfo;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface NftOrderInfoMapper extends BaseMapper<NftOrderInfo> {
    int batchInsert(@Param("list") List<NftOrderInfo> list);

    int insertOrUpdate(NftOrderInfo record);

    int insertOrUpdateSelective(NftOrderInfo record);
}