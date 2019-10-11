package com.tieshan.api.po.tieshanpaiPo.v1.follow;

import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class FollowSelect {
    private Integer id;
    private String fullId;
    private String fullName;
    private String lotAreas;
    private String storagePath;
    private String auctionTypes;
    private String auctionStates;
    private String money;
}
