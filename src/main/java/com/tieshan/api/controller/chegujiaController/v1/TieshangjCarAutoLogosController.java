package com.tieshan.api.controller.chegujiaController.v1;
import com.tieshan.api.po.chegujiaPo.v1.TieshangjCarAutoLogos;
import com.tieshan.api.po.chegujiaPo.v1.bo.EncapsulationBO;
import com.tieshan.api.po.chegujiaPo.v1.bo.EncapsulationsBO;
import com.tieshan.api.service.chegujiaService.v1.TieshangjCarAutoLogosService;
import com.tieshan.api.util.resultUtil.ApiResult;
import com.tieshan.api.util.resultUtil.ResultUtil;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.apache.commons.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(value = "v1/autologos/")
public class TieshangjCarAutoLogosController {
    @Autowired
    private TieshangjCarAutoLogosService tieshangjCarAutoLogosService;
    @RequestMapping(value = "selectAutoLogos",method = RequestMethod.GET)
    @ResponseBody
    public ApiResult selectAutoLogos()throws Exception{
        List<EncapsulationBO> encapsulationBOS = new ArrayList<EncapsulationBO>();
        List<TieshangjCarAutoLogos>list=tieshangjCarAutoLogosService.selectAll();
        if(list!=null){
            for (TieshangjCarAutoLogos tieshangjCarAutoLogos : list) {
                EncapsulationsBO encapsulationsBO=new EncapsulationsBO();
                encapsulationsBO.setId(tieshangjCarAutoLogos.getId().toString());
                encapsulationsBO.setName(tieshangjCarAutoLogos.getaName());
                String szm = ToFirstChar(tieshangjCarAutoLogos.getaName());
                Boolean flag = true;
                if(encapsulationBOS != null && encapsulationBOS.size() >0) {
                    for (int i = 0; i < encapsulationBOS.size(); i++) {
                        EncapsulationBO dictionarySystemBO = encapsulationBOS.get(i);
                        if(StringUtils.equals(dictionarySystemBO.getType(), szm)) {
                            dictionarySystemBO.getChildren().add(encapsulationsBO);
                            flag = false;
                        }
                    }
                }
                if(flag) {
                    List<EncapsulationsBO> dictionaryBOs = new ArrayList<EncapsulationsBO>();
                    dictionaryBOs.add(encapsulationsBO);
                    EncapsulationBO dsbo = new EncapsulationBO();
                    dsbo.setType(szm);
                    dsbo.setChildren(dictionaryBOs);
                    encapsulationBOS.add(dsbo);
                }
            }
            Collections.sort(encapsulationBOS,new Comparator<EncapsulationBO>() {
                @Override
                public int compare(EncapsulationBO o1, EncapsulationBO o2) {
                    return o1.getType().compareTo(o2.getType());
                }

            });
        }
        return ResultUtil.success(encapsulationBOS);
    }
    private static String ToFirstChar(String chinese) {
        String pinyinStr = "";
        char newChar = chinese.toCharArray()[0];
        HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
        defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        if (newChar > 128) {
            try {
                pinyinStr = PinyinHelper.toHanyuPinyinStringArray(newChar, defaultFormat)[0].charAt(0)+"";
            } catch (BadHanyuPinyinOutputFormatCombination e) {
                e.printStackTrace();
            }
        } else {
            pinyinStr = newChar+"";
        }
        return pinyinStr.toUpperCase();
    }
}
