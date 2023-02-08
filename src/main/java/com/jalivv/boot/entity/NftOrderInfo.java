package com.jalivv.boot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
    * NFT订单 存储表
    */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "t_nft_order_info")
public class NftOrderInfo {
    /**
     * 使用tx(hash)和order(hash)组合的Hash值
     */
    @TableField(value = "id")
    private String id;

    @TableField(value = "tx_hash")
    private String txHash;

    @TableField(value = "order_hash")
    private String orderHash;

    /**
     * 卖方
     */
    @TableField(value = "seller")
    private String seller;

    /**
     * 买方
     */
    @TableField(value = "buyer")
    private String buyer;

    /**
     * 支付的代币合约地址
     */
    @TableField(value = "payment_token_address")
    private String paymentTokenAddress;

    /**
     * 支付的金额
     */
    @TableField(value = "payment_amount")
    private String paymentAmount;

    /**
     * 订单时间
     */
    @TableField(value = "order_time")
    private Date orderTime;
}