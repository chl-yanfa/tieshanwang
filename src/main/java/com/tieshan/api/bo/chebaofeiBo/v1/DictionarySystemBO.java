package com.tieshan.api.bo.chebaofeiBo.v1;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/23 16:35
 */
@Data
public class DictionarySystemBO {

    private String type;

    private List<DictionaryBO> children = new ArrayList<>();
}
