package com.tieshan.api.po.chebaofeiPo.v1;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 11:06
 */
@Data
public class CarScrapOrderAttachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ApiModelProperty(value = "附件存储表id")
    private Integer attachmentId;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "订单附件类型（1:整车 2:配件）")
    private String orderType;

    @ApiModelProperty(value = "附件类型：照片类型（1:车辆照片、2：手续照片、3：车辆毁型照片、4：报废证明）配件：1:配件照片、2:配件接收照片、3:配件入库照片）")
    private String attachmentType;


    @ApiModelProperty(value = "整车订单车辆基图片小类:1,左前 2,正前3.右前 4.左后 5,正后6,右后 7,车架号 8,发动机 9,仪表 10.行驶证 11，登记台12，车主身份正正前方 13，车主身份正正后")
    private Integer carPictureType;

    private Boolean isvalid=true;
}
