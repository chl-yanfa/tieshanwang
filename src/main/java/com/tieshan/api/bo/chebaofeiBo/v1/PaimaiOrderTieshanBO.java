package com.tieshan.api.bo.chebaofeiBo.v1;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.Paimai;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/26 10:39
 */
@Data
public class PaimaiOrderTieshanBO {

    private String weekDay;

    private List<Paimai> paimais = new ArrayList<>();

}
