package com.tieshan.api.po.chebaofeiPo.v1;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 11:55
 */
@Table(name="car_push")
@Data
public class CarPush extends BasePojo{
    @Id
    private Integer id;

    @NotBlank
    private String pushType;

    @NotBlank
    private String notificationTitle;

    @NotBlank
    private String msgTitle;

    @NotBlank
    private String msgContent;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
}
