package com.tieshan.api.service.chegujiaService.v1;

import com.tieshan.api.po.chegujiaPo.v1.Exceljyid;

public interface ExceljyidService {
    //根据精友id查看铁码
    Exceljyid selectByJyid(String jyid);
}
