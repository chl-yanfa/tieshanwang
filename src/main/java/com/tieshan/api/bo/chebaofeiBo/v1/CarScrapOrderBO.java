package com.tieshan.api.bo.chebaofeiBo.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrder;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/19 17:07
 */
@Data
public class CarScrapOrderBO extends CarScrapOrder {
    //车辆型号名称
    private String carModelNumberName;

    private String orderAreas;

    //委托公司
    private String custormName;

    //业务员姓名
    private String saleName;

    //业务员电话
    private String salePhone;

    //派单人电话
    private String adminPhone;

    private String orderStatusCN;

    private String factoryName;

    private String factoryPhone;

    //快递公司名称
    private String CourierName;

    @ApiModelProperty(value = "派单备注")
    private String piesNote;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    //@ApiModelProperty(value = "下单日期")
    private Date createOrderDate;

    //@ApiModelProperty(value = "接收日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date receiveCarDate;

    //@ApiModelProperty(value = "入场日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date inStorageDate;

    //@ApiModelProperty(value = "手续完成日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date formalitiesDate;

    //@ApiModelProperty(value = "残值发放日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date settlementDate;

    //派单人Id
    private String operatorId;

    //车辆照片集合
    @ApiModelProperty(value = "车辆照片")
    private List<OrderAttachmentBO> vehiclePictures = new ArrayList<OrderAttachmentBO>();
    //手续照片集合
    @ApiModelProperty(value = "车辆手续照片")
    private List<OrderAttachmentBO> formalitiesPictures= new ArrayList<OrderAttachmentBO>();
    //车辆毁型照片
    @ApiModelProperty(value = "车辆毁型照片")
    private List<OrderAttachmentBO> destroyPictures= new ArrayList<OrderAttachmentBO>();
    //报废证明照片
    @ApiModelProperty(value = "车辆报废证明照片")
    private List<OrderAttachmentBO> certificatePictures= new ArrayList<OrderAttachmentBO>();
    //二次报价证明照片
    @ApiModelProperty(value = "车辆二次报价证明照片")
    private List<OrderAttachmentBO> sincepricePictures= new ArrayList<OrderAttachmentBO>();

    List<CarScrapOrderAutopartsBO> carScrapOrderAutopartsList = new ArrayList<CarScrapOrderAutopartsBO>();

    List<CarScrapOrderSettlementBO>  settlementList = new ArrayList<CarScrapOrderSettlementBO>();
}
