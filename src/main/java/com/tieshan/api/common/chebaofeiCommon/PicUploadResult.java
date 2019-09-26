package com.tieshan.api.common.chebaofeiCommon;

import lombok.Data;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/25 9:41
 */
@Data
public class PicUploadResult {
    private int id;
    private Integer error;
    private String originalFilename;
    private String url;
    private String Message;
}
