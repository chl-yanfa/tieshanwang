package com.tieshan.api.bo.chebaofeiBo.v1;

import com.tieshan.api.po.chebaofeiPo.v1.CarScrapOrderAudit;
import lombok.Data;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 11:53
 */
@Data
public class CarScrapOrderAuditBO extends CarScrapOrderAudit {
    private String auditorName;
}
