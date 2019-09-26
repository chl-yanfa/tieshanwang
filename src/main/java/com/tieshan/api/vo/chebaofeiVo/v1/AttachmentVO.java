package com.tieshan.api.vo.chebaofeiVo.v1;

import lombok.Data;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/25 9:26
 */
@Data
public class AttachmentVO {

    private String buniessid;

    /**
     * 业务id  1:订单附件 2：配件附件
     */
    private String businessType;
    /**
     * 图片类型   整车：照片类型（1:车辆照片、2：手续照片、3：车辆毁型照片、4：报废证明）
     *          配件：1:配件照片、2:配件接收照片、3:配件入库照片、
     */
    private String pictureType;

    /**
     * 整车订单车辆基图片小类:1,左前 2,正前3.右前 4.左后 5,正后6,右后 7,车架号 8,发动机 9,仪表 10.行驶证 11，登记台12，车主身份正正前方 13，车主身份正正后
     */
    private Integer picturePecialType;


    private String originalName;


    private String storagePath;
}
