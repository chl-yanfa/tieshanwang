package com.tieshan.api.util.toolUtil;

import com.tieshan.api.po.tieshanpaiPo.v1.auction.Paimai;
import lombok.Data;

import java.util.*;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/26 14:41
 */
@Data
public class OrderByUtils {

    //类型--顶部悬浮的标题
    public static final int SECTION = 1;

    public static final int END = 2;

    public static final int CENTRE = 3;

    public static final int ITEM = 4;

    public final int type; //所属于的类型

    public final Paimai detail; //listview显示的item的数据实体类,可根据自己的项目来设置


    public Paimai getDetail() {
        return detail;
    }


    public OrderByUtils(int type, Paimai detail) {
        super();
        this.type = type;
        this.detail = detail;
    }

    public OrderByUtils(int type, int total, Paimai detail, int sectionPosition,
                             int listPosition) {
        super();
        this.type = type;
        this.detail = detail;
    }


    /**
     * 通过HashMap键值对的特性，将ArrayList的数据进行分组，返回带有分组Header的ArrayList。
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
    public static ArrayList<OrderByUtils> getData(List<Paimai> details) {
        //最后我们要返回带有分组的list,初始化
        ArrayList<OrderByUtils> list = new ArrayList<OrderByUtils>();
        //时间转换的util类
        Map<String, List<Paimai>> map = new HashMap<String, List<Paimai>>();
        //按照warndetail里面的时间进行分类

        for (Paimai skuVo : details) {
            List<Paimai> tempList = map.get(skuVo.getWeekDay());
            /*如果取不到数据,那么直接new一个空的ArrayList**/
            if (tempList == null) {
                tempList = new ArrayList<>();
                tempList.add(skuVo);
                map.put(skuVo.getWeekDay(), tempList);
            } else {
                /*某个sku之前已经存放过了,则直接追加数据到原来的List里**/
                tempList.add(skuVo);
            }
        }

        //用迭代器遍历map添加到list里面
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            String key = (String) entry.getKey();
            /*   list.add(new PinnedSectionBean(SECTION, (AuctionListInfo) entry.getValue()));*/
            List<Paimai> li = (List<Paimai>) entry.getValue();

            for (int i = 0; i < li.size(); i++) {
                if (i == 0) {
                    if(li.size() == 1){
                        list.add(new OrderByUtils(CENTRE, li.get(i)));
                    }else{
                        list.add(new OrderByUtils(SECTION, li.get(i)));
                    }
                } else if(i == li.size() - 1){
                    list.add(new OrderByUtils(END, li.get(i)));
                }else
                    list.add(new OrderByUtils(ITEM, li.get(i)));
            }

        }
        //把分好类的hashmap添加到list里面便于显示
        return list;
    }
}
