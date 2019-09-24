package com.tieshan.api.po.chebaofeiPo.v1.Example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 9:27
 */
public class CarScrapOrderExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<OrderCriteria> oredCriteria;

    public CarScrapOrderExample() {
        oredCriteria = new ArrayList<OrderCriteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<OrderCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(OrderCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public OrderCriteria or() {
        OrderCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public OrderCriteria createCriteria() {
        OrderCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected OrderCriteria createCriteriaInternal() {
        OrderCriteria criteria = new OrderCriteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedOrderCriteria {
        protected List<OrderCriterion> OrderCriteria;

        protected GeneratedOrderCriteria() {
            super();
            OrderCriteria = new ArrayList<OrderCriterion>();
        }

        public boolean isValid() {
            return OrderCriteria.size() > 0;
        }

        public List<OrderCriterion> getAllOrderCriteria() {
            return OrderCriteria;
        }

        public List<OrderCriterion> getOrderCriteria() {
            return OrderCriteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            OrderCriteria.add(new OrderCriterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            OrderCriteria.add(new OrderCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            OrderCriteria.add(new OrderCriterion(condition, value1, value2));
        }

        public OrderCriteria andIdIsNull() {
            addCriterion("id is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderNoIsNull() {
            addCriterion("order_no is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderNoIsNotNull() {
            addCriterion("order_no is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderNoEqualTo(String value) {
            addCriterion("order_no =", value, "orderNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderNoNotEqualTo(String value) {
            addCriterion("order_no <>", value, "orderNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderNoGreaterThan(String value) {
            addCriterion("order_no >", value, "orderNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("order_no >=", value, "orderNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderNoLessThan(String value) {
            addCriterion("order_no <", value, "orderNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderNoLessThanOrEqualTo(String value) {
            addCriterion("order_no <=", value, "orderNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderNoLike(String value) {
            addCriterion("order_no like", value, "orderNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderNoNotLike(String value) {
            addCriterion("order_no not like", value, "orderNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderNoIn(List<String> values) {
            addCriterion("order_no in", values, "orderNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderNoNotIn(List<String> values) {
            addCriterion("order_no not in", values, "orderNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderNoBetween(String value1, String value2) {
            addCriterion("order_no between", value1, value2, "orderNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderNoNotBetween(String value1, String value2) {
            addCriterion("order_no not between", value1, value2, "orderNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTimeIsNull() {
            addCriterion("order_time is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTimeIsNotNull() {
            addCriterion("order_time is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTimeEqualTo(Date value) {
            addCriterion("order_time =", value, "orderTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTimeNotEqualTo(Date value) {
            addCriterion("order_time <>", value, "orderTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTimeGreaterThan(Date value) {
            addCriterion("order_time >", value, "orderTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_time >=", value, "orderTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTimeLessThan(Date value) {
            addCriterion("order_time <", value, "orderTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_time <=", value, "orderTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTimeIn(List<Date> values) {
            addCriterion("order_time in", values, "orderTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTimeNotIn(List<Date> values) {
            addCriterion("order_time not in", values, "orderTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTimeBetween(Date value1, Date value2) {
            addCriterion("order_time between", value1, value2, "orderTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_time not between", value1, value2, "orderTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportNoIsNull() {
            addCriterion("report_no is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportNoIsNotNull() {
            addCriterion("report_no is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportNoEqualTo(String value) {
            addCriterion("report_no =", value, "reportNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportNoNotEqualTo(String value) {
            addCriterion("report_no <>", value, "reportNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportNoGreaterThan(String value) {
            addCriterion("report_no >", value, "reportNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportNoGreaterThanOrEqualTo(String value) {
            addCriterion("report_no >=", value, "reportNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportNoLessThan(String value) {
            addCriterion("report_no <", value, "reportNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportNoLessThanOrEqualTo(String value) {
            addCriterion("report_no <=", value, "reportNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportNoLike(String value) {
            addCriterion("report_no like", value, "reportNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportNoNotLike(String value) {
            addCriterion("report_no not like", value, "reportNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportNoIn(List<String> values) {
            addCriterion("report_no in", values, "reportNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportNoNotIn(List<String> values) {
            addCriterion("report_no not in", values, "reportNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportNoBetween(String value1, String value2) {
            addCriterion("report_no between", value1, value2, "reportNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportNoNotBetween(String value1, String value2) {
            addCriterion("report_no not between", value1, value2, "reportNo");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportTimeIsNull() {
            addCriterion("report_time is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportTimeIsNotNull() {
            addCriterion("report_time is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportTimeEqualTo(Date value) {
            addCriterion("report_time =", value, "reportTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportTimeNotEqualTo(Date value) {
            addCriterion("report_time <>", value, "reportTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportTimeGreaterThan(Date value) {
            addCriterion("report_time >", value, "reportTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("report_time >=", value, "reportTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportTimeLessThan(Date value) {
            addCriterion("report_time <", value, "reportTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportTimeLessThanOrEqualTo(Date value) {
            addCriterion("report_time <=", value, "reportTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportTimeIn(List<Date> values) {
            addCriterion("report_time in", values, "reportTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportTimeNotIn(List<Date> values) {
            addCriterion("report_time not in", values, "reportTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportTimeBetween(Date value1, Date value2) {
            addCriterion("report_time between", value1, value2, "reportTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andReportTimeNotBetween(Date value1, Date value2) {
            addCriterion("report_time not between", value1, value2, "reportTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarNumberIsNull() {
            addCriterion("car_number is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarNumberIsNotNull() {
            addCriterion("car_number is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarNumberEqualTo(String value) {
            addCriterion("car_number =", value, "carNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarNumberNotEqualTo(String value) {
            addCriterion("car_number <>", value, "carNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarNumberGreaterThan(String value) {
            addCriterion("car_number >", value, "carNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarNumberGreaterThanOrEqualTo(String value) {
            addCriterion("car_number >=", value, "carNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarNumberLessThan(String value) {
            addCriterion("car_number <", value, "carNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarNumberLessThanOrEqualTo(String value) {
            addCriterion("car_number <=", value, "carNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarNumberLike(String value) {
            addCriterion("car_number like", value, "carNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarNumberNotLike(String value) {
            addCriterion("car_number not like", value, "carNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarNumberIn(List<String> values) {
            addCriterion("car_number in", values, "carNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarNumberNotIn(List<String> values) {
            addCriterion("car_number not in", values, "carNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarNumberBetween(String value1, String value2) {
            addCriterion("car_number between", value1, value2, "carNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarNumberNotBetween(String value1, String value2) {
            addCriterion("car_number not between", value1, value2, "carNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarFrameNumberIsNull() {
            addCriterion("car_frame_number is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarFrameNumberIsNotNull() {
            addCriterion("car_frame_number is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarFrameNumberEqualTo(String value) {
            addCriterion("car_frame_number =", value, "carFrameNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarFrameNumberNotEqualTo(String value) {
            addCriterion("car_frame_number <>", value, "carFrameNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarFrameNumberGreaterThan(String value) {
            addCriterion("car_frame_number >", value, "carFrameNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarFrameNumberGreaterThanOrEqualTo(String value) {
            addCriterion("car_frame_number >=", value, "carFrameNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarFrameNumberLessThan(String value) {
            addCriterion("car_frame_number <", value, "carFrameNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarFrameNumberLessThanOrEqualTo(String value) {
            addCriterion("car_frame_number <=", value, "carFrameNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarFrameNumberLike(String value) {
            addCriterion("car_frame_number like", value, "carFrameNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarFrameNumberNotLike(String value) {
            addCriterion("car_frame_number not like", value, "carFrameNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarFrameNumberIn(List<String> values) {
            addCriterion("car_frame_number in", values, "carFrameNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarFrameNumberNotIn(List<String> values) {
            addCriterion("car_frame_number not in", values, "carFrameNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarFrameNumberBetween(String value1, String value2) {
            addCriterion("car_frame_number between", value1, value2, "carFrameNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarFrameNumberNotBetween(String value1, String value2) {
            addCriterion("car_frame_number not between", value1, value2, "carFrameNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarModelNumberIsNull() {
            addCriterion("car_model_number is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarModelNumberIsNotNull() {
            addCriterion("car_model_number is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarModelNumberEqualTo(Integer value) {
            addCriterion("car_model_number =", value, "carModelNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarModelNumberNotEqualTo(Integer value) {
            addCriterion("car_model_number <>", value, "carModelNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarModelNumberGreaterThan(Integer value) {
            addCriterion("car_model_number >", value, "carModelNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarModelNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_model_number >=", value, "carModelNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarModelNumberLessThan(Integer value) {
            addCriterion("car_model_number <", value, "carModelNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarModelNumberLessThanOrEqualTo(Integer value) {
            addCriterion("car_model_number <=", value, "carModelNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarModelNumberIn(List<Integer> values) {
            addCriterion("car_model_number in", values, "carModelNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarModelNumberNotIn(List<Integer> values) {
            addCriterion("car_model_number not in", values, "carModelNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarModelNumberBetween(Integer value1, Integer value2) {
            addCriterion("car_model_number between", value1, value2, "carModelNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarModelNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("car_model_number not between", value1, value2, "carModelNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarAscriptionIsNull() {
            addCriterion("car_ascription is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarAscriptionIsNotNull() {
            addCriterion("car_ascription is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarAscriptionEqualTo(String value) {
            addCriterion("car_ascription =", value, "carAscription");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarAscriptionNotEqualTo(String value) {
            addCriterion("car_ascription <>", value, "carAscription");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarAscriptionGreaterThan(String value) {
            addCriterion("car_ascription >", value, "carAscription");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarAscriptionGreaterThanOrEqualTo(String value) {
            addCriterion("car_ascription >=", value, "carAscription");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarAscriptionLessThan(String value) {
            addCriterion("car_ascription <", value, "carAscription");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarAscriptionLessThanOrEqualTo(String value) {
            addCriterion("car_ascription <=", value, "carAscription");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarAscriptionLike(String value) {
            addCriterion("car_ascription like", value, "carAscription");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarAscriptionNotLike(String value) {
            addCriterion("car_ascription not like", value, "carAscription");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarAscriptionIn(List<String> values) {
            addCriterion("car_ascription in", values, "carAscription");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarAscriptionNotIn(List<String> values) {
            addCriterion("car_ascription not in", values, "carAscription");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarAscriptionBetween(String value1, String value2) {
            addCriterion("car_ascription between", value1, value2, "carAscription");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarAscriptionNotBetween(String value1, String value2) {
            addCriterion("car_ascription not between", value1, value2, "carAscription");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarOwnerIsNull() {
            addCriterion("car_owner is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarOwnerIsNotNull() {
            addCriterion("car_owner is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarOwnerEqualTo(String value) {
            addCriterion("car_owner =", value, "carOwner");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarOwnerNotEqualTo(String value) {
            addCriterion("car_owner <>", value, "carOwner");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarOwnerGreaterThan(String value) {
            addCriterion("car_owner >", value, "carOwner");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("car_owner >=", value, "carOwner");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarOwnerLessThan(String value) {
            addCriterion("car_owner <", value, "carOwner");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarOwnerLessThanOrEqualTo(String value) {
            addCriterion("car_owner <=", value, "carOwner");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarOwnerLike(String value) {
            addCriterion("car_owner like", value, "carOwner");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarOwnerNotLike(String value) {
            addCriterion("car_owner not like", value, "carOwner");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarOwnerIn(List<String> values) {
            addCriterion("car_owner in", values, "carOwner");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarOwnerNotIn(List<String> values) {
            addCriterion("car_owner not in", values, "carOwner");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarOwnerBetween(String value1, String value2) {
            addCriterion("car_owner between", value1, value2, "carOwner");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCarOwnerNotBetween(String value1, String value2) {
            addCriterion("car_owner not between", value1, value2, "carOwner");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsdriveIsNull() {
            addCriterion("isdrive is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsdriveIsNotNull() {
            addCriterion("isdrive is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsdriveEqualTo(Boolean value) {
            addCriterion("isdrive =", value, "isdrive");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsdriveNotEqualTo(Boolean value) {
            addCriterion("isdrive <>", value, "isdrive");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsdriveGreaterThan(Boolean value) {
            addCriterion("isdrive >", value, "isdrive");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsdriveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isdrive >=", value, "isdrive");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsdriveLessThan(Boolean value) {
            addCriterion("isdrive <", value, "isdrive");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsdriveLessThanOrEqualTo(Boolean value) {
            addCriterion("isdrive <=", value, "isdrive");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsdriveIn(List<Boolean> values) {
            addCriterion("isdrive in", values, "isdrive");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsdriveNotIn(List<Boolean> values) {
            addCriterion("isdrive not in", values, "isdrive");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsdriveBetween(Boolean value1, Boolean value2) {
            addCriterion("isdrive between", value1, value2, "isdrive");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsdriveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isdrive not between", value1, value2, "isdrive");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderStatusEqualTo(String value) {
            addCriterion("order_status =", value, "orderStatus");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderStatusNotEqualTo(String value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderStatusGreaterThan(String value) {
            addCriterion("order_status >", value, "orderStatus");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderStatusGreaterThanOrEqualTo(String value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderStatusLessThan(String value) {
            addCriterion("order_status <", value, "orderStatus");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderStatusLessThanOrEqualTo(String value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderStatusLike(String value) {
            addCriterion("order_status like", value, "orderStatus");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderStatusNotLike(String value) {
            addCriterion("order_status not like", value, "orderStatus");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderStatusIn(List<String> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderStatusNotIn(List<String> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderStatusBetween(String value1, String value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderStatusNotBetween(String value1, String value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (OrderCriteria) this;
        }

        public OrderCriteria andAgentUseridIsNull() {
            addCriterion("agent_userid is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andAgentUseridIsNotNull() {
            addCriterion("agent_userid is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andAgentUseridEqualTo(String value) {
            addCriterion("agent_userid =", value, "agentUserid");
            return (OrderCriteria) this;
        }

        public OrderCriteria andAgentUseridNotEqualTo(String value) {
            addCriterion("agent_userid <>", value, "agentUserid");
            return (OrderCriteria) this;
        }

        public OrderCriteria andAgentUseridGreaterThan(String value) {
            addCriterion("agent_userid >", value, "agentUserid");
            return (OrderCriteria) this;
        }

        public OrderCriteria andAgentUseridGreaterThanOrEqualTo(String value) {
            addCriterion("agent_userid >=", value, "agentUserid");
            return (OrderCriteria) this;
        }

        public OrderCriteria andAgentUseridLessThan(String value) {
            addCriterion("agent_userid <", value, "agentUserid");
            return (OrderCriteria) this;
        }

        public OrderCriteria andAgentUseridLessThanOrEqualTo(String value) {
            addCriterion("agent_userid <=", value, "agentUserid");
            return (OrderCriteria) this;
        }

        public OrderCriteria andAgentUseridLike(String value) {
            addCriterion("agent_userid like", value, "agentUserid");
            return (OrderCriteria) this;
        }

        public OrderCriteria andAgentUseridNotLike(String value) {
            addCriterion("agent_userid not like", value, "agentUserid");
            return (OrderCriteria) this;
        }

        public OrderCriteria andAgentUseridIn(List<String> values) {
            addCriterion("agent_userid in", values, "agentUserid");
            return (OrderCriteria) this;
        }

        public OrderCriteria andAgentUseridNotIn(List<String> values) {
            addCriterion("agent_userid not in", values, "agentUserid");
            return (OrderCriteria) this;
        }

        public OrderCriteria andAgentUseridBetween(String value1, String value2) {
            addCriterion("agent_userid between", value1, value2, "agentUserid");
            return (OrderCriteria) this;
        }

        public OrderCriteria andAgentUseridNotBetween(String value1, String value2) {
            addCriterion("agent_userid not between", value1, value2, "agentUserid");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTypeIsNull() {
            addCriterion("order_type is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTypeIsNotNull() {
            addCriterion("order_type is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTypeEqualTo(String value) {
            addCriterion("order_type =", value, "orderType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTypeNotEqualTo(String value) {
            addCriterion("order_type <>", value, "orderType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTypeGreaterThan(String value) {
            addCriterion("order_type >", value, "orderType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTypeGreaterThanOrEqualTo(String value) {
            addCriterion("order_type >=", value, "orderType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTypeLessThan(String value) {
            addCriterion("order_type <", value, "orderType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTypeLessThanOrEqualTo(String value) {
            addCriterion("order_type <=", value, "orderType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTypeLike(String value) {
            addCriterion("order_type like", value, "orderType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTypeNotLike(String value) {
            addCriterion("order_type not like", value, "orderType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTypeIn(List<String> values) {
            addCriterion("order_type in", values, "orderType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTypeNotIn(List<String> values) {
            addCriterion("order_type not in", values, "orderType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTypeBetween(String value1, String value2) {
            addCriterion("order_type between", value1, value2, "orderType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderTypeNotBetween(String value1, String value2) {
            addCriterion("order_type not between", value1, value2, "orderType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactsIsNull() {
            addCriterion("take_car_contacts is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactsIsNotNull() {
            addCriterion("take_car_contacts is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactsEqualTo(String value) {
            addCriterion("take_car_contacts =", value, "takeCarContacts");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactsNotEqualTo(String value) {
            addCriterion("take_car_contacts <>", value, "takeCarContacts");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactsGreaterThan(String value) {
            addCriterion("take_car_contacts >", value, "takeCarContacts");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactsGreaterThanOrEqualTo(String value) {
            addCriterion("take_car_contacts >=", value, "takeCarContacts");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactsLessThan(String value) {
            addCriterion("take_car_contacts <", value, "takeCarContacts");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactsLessThanOrEqualTo(String value) {
            addCriterion("take_car_contacts <=", value, "takeCarContacts");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactsLike(String value) {
            addCriterion("take_car_contacts like", value, "takeCarContacts");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactsNotLike(String value) {
            addCriterion("take_car_contacts not like", value, "takeCarContacts");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactsIn(List<String> values) {
            addCriterion("take_car_contacts in", values, "takeCarContacts");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactsNotIn(List<String> values) {
            addCriterion("take_car_contacts not in", values, "takeCarContacts");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactsBetween(String value1, String value2) {
            addCriterion("take_car_contacts between", value1, value2, "takeCarContacts");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactsNotBetween(String value1, String value2) {
            addCriterion("take_car_contacts not between", value1, value2, "takeCarContacts");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactNumberIsNull() {
            addCriterion("take_car_contact_number is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactNumberIsNotNull() {
            addCriterion("take_car_contact_number is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactNumberEqualTo(String value) {
            addCriterion("take_car_contact_number =", value, "takeCarContactNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactNumberNotEqualTo(String value) {
            addCriterion("take_car_contact_number <>", value, "takeCarContactNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactNumberGreaterThan(String value) {
            addCriterion("take_car_contact_number >", value, "takeCarContactNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactNumberGreaterThanOrEqualTo(String value) {
            addCriterion("take_car_contact_number >=", value, "takeCarContactNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactNumberLessThan(String value) {
            addCriterion("take_car_contact_number <", value, "takeCarContactNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactNumberLessThanOrEqualTo(String value) {
            addCriterion("take_car_contact_number <=", value, "takeCarContactNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactNumberLike(String value) {
            addCriterion("take_car_contact_number like", value, "takeCarContactNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactNumberNotLike(String value) {
            addCriterion("take_car_contact_number not like", value, "takeCarContactNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactNumberIn(List<String> values) {
            addCriterion("take_car_contact_number in", values, "takeCarContactNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactNumberNotIn(List<String> values) {
            addCriterion("take_car_contact_number not in", values, "takeCarContactNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactNumberBetween(String value1, String value2) {
            addCriterion("take_car_contact_number between", value1, value2, "takeCarContactNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarContactNumberNotBetween(String value1, String value2) {
            addCriterion("take_car_contact_number not between", value1, value2, "takeCarContactNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarTimeIsNull() {
            addCriterion("take_car_time is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarTimeIsNotNull() {
            addCriterion("take_car_time is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarTimeEqualTo(Date value) {
            addCriterion("take_car_time =", value, "takeCarTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarTimeNotEqualTo(Date value) {
            addCriterion("take_car_time <>", value, "takeCarTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarTimeGreaterThan(Date value) {
            addCriterion("take_car_time >", value, "takeCarTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("take_car_time >=", value, "takeCarTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarTimeLessThan(Date value) {
            addCriterion("take_car_time <", value, "takeCarTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarTimeLessThanOrEqualTo(Date value) {
            addCriterion("take_car_time <=", value, "takeCarTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarTimeIn(List<Date> values) {
            addCriterion("take_car_time in", values, "takeCarTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarTimeNotIn(List<Date> values) {
            addCriterion("take_car_time not in", values, "takeCarTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarTimeBetween(Date value1, Date value2) {
            addCriterion("take_car_time between", value1, value2, "takeCarTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarTimeNotBetween(Date value1, Date value2) {
            addCriterion("take_car_time not between", value1, value2, "takeCarTime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarAddressIsNull() {
            addCriterion("take_car_address is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarAddressIsNotNull() {
            addCriterion("take_car_address is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarAddressEqualTo(String value) {
            addCriterion("take_car_address =", value, "takeCarAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarAddressNotEqualTo(String value) {
            addCriterion("take_car_address <>", value, "takeCarAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarAddressGreaterThan(String value) {
            addCriterion("take_car_address >", value, "takeCarAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarAddressGreaterThanOrEqualTo(String value) {
            addCriterion("take_car_address >=", value, "takeCarAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarAddressLessThan(String value) {
            addCriterion("take_car_address <", value, "takeCarAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarAddressLessThanOrEqualTo(String value) {
            addCriterion("take_car_address <=", value, "takeCarAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarAddressLike(String value) {
            addCriterion("take_car_address like", value, "takeCarAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarAddressNotLike(String value) {
            addCriterion("take_car_address not like", value, "takeCarAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarAddressIn(List<String> values) {
            addCriterion("take_car_address in", values, "takeCarAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarAddressNotIn(List<String> values) {
            addCriterion("take_car_address not in", values, "takeCarAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarAddressBetween(String value1, String value2) {
            addCriterion("take_car_address between", value1, value2, "takeCarAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andTakeCarAddressNotBetween(String value1, String value2) {
            addCriterion("take_car_address not between", value1, value2, "takeCarAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressCompanyIsNull() {
            addCriterion("express_company is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressCompanyIsNotNull() {
            addCriterion("express_company is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressCompanyEqualTo(String value) {
            addCriterion("express_company =", value, "expressCompany");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressCompanyNotEqualTo(String value) {
            addCriterion("express_company <>", value, "expressCompany");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressCompanyGreaterThan(String value) {
            addCriterion("express_company >", value, "expressCompany");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressCompanyGreaterThanOrEqualTo(String value) {
            addCriterion("express_company >=", value, "expressCompany");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressCompanyLessThan(String value) {
            addCriterion("express_company <", value, "expressCompany");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressCompanyLessThanOrEqualTo(String value) {
            addCriterion("express_company <=", value, "expressCompany");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressCompanyLike(String value) {
            addCriterion("express_company like", value, "expressCompany");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressCompanyNotLike(String value) {
            addCriterion("express_company not like", value, "expressCompany");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressCompanyIn(List<String> values) {
            addCriterion("express_company in", values, "expressCompany");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressCompanyNotIn(List<String> values) {
            addCriterion("express_company not in", values, "expressCompany");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressCompanyBetween(String value1, String value2) {
            addCriterion("express_company between", value1, value2, "expressCompany");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressCompanyNotBetween(String value1, String value2) {
            addCriterion("express_company not between", value1, value2, "expressCompany");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressNumberIsNull() {
            addCriterion("express_number is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressNumberIsNotNull() {
            addCriterion("express_number is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressNumberEqualTo(String value) {
            addCriterion("express_number =", value, "expressNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressNumberNotEqualTo(String value) {
            addCriterion("express_number <>", value, "expressNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressNumberGreaterThan(String value) {
            addCriterion("express_number >", value, "expressNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressNumberGreaterThanOrEqualTo(String value) {
            addCriterion("express_number >=", value, "expressNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressNumberLessThan(String value) {
            addCriterion("express_number <", value, "expressNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressNumberLessThanOrEqualTo(String value) {
            addCriterion("express_number <=", value, "expressNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressNumberLike(String value) {
            addCriterion("express_number like", value, "expressNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressNumberNotLike(String value) {
            addCriterion("express_number not like", value, "expressNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressNumberIn(List<String> values) {
            addCriterion("express_number in", values, "expressNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressNumberNotIn(List<String> values) {
            addCriterion("express_number not in", values, "expressNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressNumberBetween(String value1, String value2) {
            addCriterion("express_number between", value1, value2, "expressNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andExpressNumberNotBetween(String value1, String value2) {
            addCriterion("express_number not between", value1, value2, "expressNumber");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressNameIsNull() {
            addCriterion("mailing_address_name is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressNameIsNotNull() {
            addCriterion("mailing_address_name is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressNameEqualTo(String value) {
            addCriterion("mailing_address_name =", value, "mailingAddressName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressNameNotEqualTo(String value) {
            addCriterion("mailing_address_name <>", value, "mailingAddressName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressNameGreaterThan(String value) {
            addCriterion("mailing_address_name >", value, "mailingAddressName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressNameGreaterThanOrEqualTo(String value) {
            addCriterion("mailing_address_name >=", value, "mailingAddressName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressNameLessThan(String value) {
            addCriterion("mailing_address_name <", value, "mailingAddressName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressNameLessThanOrEqualTo(String value) {
            addCriterion("mailing_address_name <=", value, "mailingAddressName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressNameLike(String value) {
            addCriterion("mailing_address_name like", value, "mailingAddressName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressNameNotLike(String value) {
            addCriterion("mailing_address_name not like", value, "mailingAddressName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressNameIn(List<String> values) {
            addCriterion("mailing_address_name in", values, "mailingAddressName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressNameNotIn(List<String> values) {
            addCriterion("mailing_address_name not in", values, "mailingAddressName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressNameBetween(String value1, String value2) {
            addCriterion("mailing_address_name between", value1, value2, "mailingAddressName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressNameNotBetween(String value1, String value2) {
            addCriterion("mailing_address_name not between", value1, value2, "mailingAddressName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressTelephoneIsNull() {
            addCriterion("mailing_address_telephone is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressTelephoneIsNotNull() {
            addCriterion("mailing_address_telephone is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressTelephoneEqualTo(String value) {
            addCriterion("mailing_address_telephone =", value, "mailingAddressTelephone");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressTelephoneNotEqualTo(String value) {
            addCriterion("mailing_address_telephone <>", value, "mailingAddressTelephone");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressTelephoneGreaterThan(String value) {
            addCriterion("mailing_address_telephone >", value, "mailingAddressTelephone");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("mailing_address_telephone >=", value, "mailingAddressTelephone");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressTelephoneLessThan(String value) {
            addCriterion("mailing_address_telephone <", value, "mailingAddressTelephone");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressTelephoneLessThanOrEqualTo(String value) {
            addCriterion("mailing_address_telephone <=", value, "mailingAddressTelephone");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressTelephoneLike(String value) {
            addCriterion("mailing_address_telephone like", value, "mailingAddressTelephone");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressTelephoneNotLike(String value) {
            addCriterion("mailing_address_telephone not like", value, "mailingAddressTelephone");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressTelephoneIn(List<String> values) {
            addCriterion("mailing_address_telephone in", values, "mailingAddressTelephone");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressTelephoneNotIn(List<String> values) {
            addCriterion("mailing_address_telephone not in", values, "mailingAddressTelephone");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressTelephoneBetween(String value1, String value2) {
            addCriterion("mailing_address_telephone between", value1, value2, "mailingAddressTelephone");
            return (OrderCriteria) this;
        }

        public OrderCriteria andMailingAddressTelephoneNotBetween(String value1, String value2) {
            addCriterion("mailing_address_telephone not between", value1, value2, "mailingAddressTelephone");
            return (OrderCriteria) this;
        }

        public OrderCriteria andProvinceIsNull() {
            addCriterion("province is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andProvinceEqualTo(Integer value) {
            addCriterion("province =", value, "province");
            return (OrderCriteria) this;
        }

        public OrderCriteria andProvinceNotEqualTo(Integer value) {
            addCriterion("province <>", value, "province");
            return (OrderCriteria) this;
        }

        public OrderCriteria andProvinceGreaterThan(Integer value) {
            addCriterion("province >", value, "province");
            return (OrderCriteria) this;
        }

        public OrderCriteria andProvinceGreaterThanOrEqualTo(Integer value) {
            addCriterion("province >=", value, "province");
            return (OrderCriteria) this;
        }

        public OrderCriteria andProvinceLessThan(Integer value) {
            addCriterion("province <", value, "province");
            return (OrderCriteria) this;
        }

        public OrderCriteria andProvinceLessThanOrEqualTo(Integer value) {
            addCriterion("province <=", value, "province");
            return (OrderCriteria) this;
        }

        public OrderCriteria andProvinceIn(List<Integer> values) {
            addCriterion("province in", values, "province");
            return (OrderCriteria) this;
        }

        public OrderCriteria andProvinceNotIn(List<Integer> values) {
            addCriterion("province not in", values, "province");
            return (OrderCriteria) this;
        }

        public OrderCriteria andProvinceBetween(Integer value1, Integer value2) {
            addCriterion("province between", value1, value2, "province");
            return (OrderCriteria) this;
        }

        public OrderCriteria andProvinceNotBetween(Integer value1, Integer value2) {
            addCriterion("province not between", value1, value2, "province");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCityIsNull() {
            addCriterion("city is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCityEqualTo(Integer value) {
            addCriterion("city =", value, "city");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCityNotEqualTo(Integer value) {
            addCriterion("city <>", value, "city");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCityGreaterThan(Integer value) {
            addCriterion("city >", value, "city");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCityGreaterThanOrEqualTo(Integer value) {
            addCriterion("city >=", value, "city");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCityLessThan(Integer value) {
            addCriterion("city <", value, "city");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCityLessThanOrEqualTo(Integer value) {
            addCriterion("city <=", value, "city");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCityIn(List<Integer> values) {
            addCriterion("city in", values, "city");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCityNotIn(List<Integer> values) {
            addCriterion("city not in", values, "city");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCityBetween(Integer value1, Integer value2) {
            addCriterion("city between", value1, value2, "city");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCityNotBetween(Integer value1, Integer value2) {
            addCriterion("city not between", value1, value2, "city");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCountyIsNull() {
            addCriterion("county is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCountyIsNotNull() {
            addCriterion("county is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCountyEqualTo(Integer value) {
            addCriterion("county =", value, "county");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCountyNotEqualTo(Integer value) {
            addCriterion("county <>", value, "county");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCountyGreaterThan(Integer value) {
            addCriterion("county >", value, "county");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCountyGreaterThanOrEqualTo(Integer value) {
            addCriterion("county >=", value, "county");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCountyLessThan(Integer value) {
            addCriterion("county <", value, "county");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCountyLessThanOrEqualTo(Integer value) {
            addCriterion("county <=", value, "county");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCountyIn(List<Integer> values) {
            addCriterion("county in", values, "county");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCountyNotIn(List<Integer> values) {
            addCriterion("county not in", values, "county");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCountyBetween(Integer value1, Integer value2) {
            addCriterion("county between", value1, value2, "county");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCountyNotBetween(Integer value1, Integer value2) {
            addCriterion("county not between", value1, value2, "county");
            return (OrderCriteria) this;
        }

        public OrderCriteria andDetailedAddressIsNull() {
            addCriterion("detailed_address is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andDetailedAddressIsNotNull() {
            addCriterion("detailed_address is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andDetailedAddressEqualTo(String value) {
            addCriterion("detailed_address =", value, "detailedAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andDetailedAddressNotEqualTo(String value) {
            addCriterion("detailed_address <>", value, "detailedAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andDetailedAddressGreaterThan(String value) {
            addCriterion("detailed_address >", value, "detailedAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andDetailedAddressGreaterThanOrEqualTo(String value) {
            addCriterion("detailed_address >=", value, "detailedAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andDetailedAddressLessThan(String value) {
            addCriterion("detailed_address <", value, "detailedAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andDetailedAddressLessThanOrEqualTo(String value) {
            addCriterion("detailed_address <=", value, "detailedAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andDetailedAddressLike(String value) {
            addCriterion("detailed_address like", value, "detailedAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andDetailedAddressNotLike(String value) {
            addCriterion("detailed_address not like", value, "detailedAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andDetailedAddressIn(List<String> values) {
            addCriterion("detailed_address in", values, "detailedAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andDetailedAddressNotIn(List<String> values) {
            addCriterion("detailed_address not in", values, "detailedAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andDetailedAddressBetween(String value1, String value2) {
            addCriterion("detailed_address between", value1, value2, "detailedAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andDetailedAddressNotBetween(String value1, String value2) {
            addCriterion("detailed_address not between", value1, value2, "detailedAddress");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientTypeIsNull() {
            addCriterion("client_type is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientTypeIsNotNull() {
            addCriterion("client_type is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientTypeEqualTo(String value) {
            addCriterion("client_type =", value, "clientType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientTypeNotEqualTo(String value) {
            addCriterion("client_type <>", value, "clientType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientTypeGreaterThan(String value) {
            addCriterion("client_type >", value, "clientType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientTypeGreaterThanOrEqualTo(String value) {
            addCriterion("client_type >=", value, "clientType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientTypeLessThan(String value) {
            addCriterion("client_type <", value, "clientType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientTypeLessThanOrEqualTo(String value) {
            addCriterion("client_type <=", value, "clientType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientTypeLike(String value) {
            addCriterion("client_type like", value, "clientType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientTypeNotLike(String value) {
            addCriterion("client_type not like", value, "clientType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientTypeIn(List<String> values) {
            addCriterion("client_type in", values, "clientType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientTypeNotIn(List<String> values) {
            addCriterion("client_type not in", values, "clientType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientTypeBetween(String value1, String value2) {
            addCriterion("client_type between", value1, value2, "clientType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientTypeNotBetween(String value1, String value2) {
            addCriterion("client_type not between", value1, value2, "clientType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientIdEqualTo(String value) {
            addCriterion("client_id =", value, "clientId");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientIdNotEqualTo(String value) {
            addCriterion("client_id <>", value, "clientId");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientIdGreaterThan(String value) {
            addCriterion("client_id >", value, "clientId");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientIdGreaterThanOrEqualTo(String value) {
            addCriterion("client_id >=", value, "clientId");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientIdLessThan(String value) {
            addCriterion("client_id <", value, "clientId");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientIdLessThanOrEqualTo(String value) {
            addCriterion("client_id <=", value, "clientId");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientIdLike(String value) {
            addCriterion("client_id like", value, "clientId");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientIdNotLike(String value) {
            addCriterion("client_id not like", value, "clientId");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientIdIn(List<String> values) {
            addCriterion("client_id in", values, "clientId");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientIdNotIn(List<String> values) {
            addCriterion("client_id not in", values, "clientId");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientIdBetween(String value1, String value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (OrderCriteria) this;
        }

        public OrderCriteria andClientIdNotBetween(String value1, String value2) {
            addCriterion("client_id not between", value1, value2, "clientId");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderAmountEqualTo(BigDecimal value) {
            addCriterion("order_amount =", value, "orderAmount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderAmountGreaterThan(BigDecimal value) {
            addCriterion("order_amount >", value, "orderAmount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderAmountLessThan(BigDecimal value) {
            addCriterion("order_amount <", value, "orderAmount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderAmountIn(List<BigDecimal> values) {
            addCriterion("order_amount in", values, "orderAmount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andPayeeNameIsNull() {
            addCriterion("payee_name is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andPayeeNameIsNotNull() {
            addCriterion("payee_name is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andPayeeNameEqualTo(String value) {
            addCriterion("payee_name =", value, "payeeName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andPayeeNameNotEqualTo(String value) {
            addCriterion("payee_name <>", value, "payeeName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andPayeeNameGreaterThan(String value) {
            addCriterion("payee_name >", value, "payeeName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andPayeeNameGreaterThanOrEqualTo(String value) {
            addCriterion("payee_name >=", value, "payeeName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andPayeeNameLessThan(String value) {
            addCriterion("payee_name <", value, "payeeName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andPayeeNameLessThanOrEqualTo(String value) {
            addCriterion("payee_name <=", value, "payeeName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andPayeeNameLike(String value) {
            addCriterion("payee_name like", value, "payeeName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andPayeeNameNotLike(String value) {
            addCriterion("payee_name not like", value, "payeeName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andPayeeNameIn(List<String> values) {
            addCriterion("payee_name in", values, "payeeName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andPayeeNameNotIn(List<String> values) {
            addCriterion("payee_name not in", values, "payeeName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andPayeeNameBetween(String value1, String value2) {
            addCriterion("payee_name between", value1, value2, "payeeName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andPayeeNameNotBetween(String value1, String value2) {
            addCriterion("payee_name not between", value1, value2, "payeeName");
            return (OrderCriteria) this;
        }

        public OrderCriteria andBankAccountIsNull() {
            addCriterion("bank_account is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andBankAccountIsNotNull() {
            addCriterion("bank_account is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andBankAccountEqualTo(String value) {
            addCriterion("bank_account =", value, "bankAccount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andBankAccountNotEqualTo(String value) {
            addCriterion("bank_account <>", value, "bankAccount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andBankAccountGreaterThan(String value) {
            addCriterion("bank_account >", value, "bankAccount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andBankAccountGreaterThanOrEqualTo(String value) {
            addCriterion("bank_account >=", value, "bankAccount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andBankAccountLessThan(String value) {
            addCriterion("bank_account <", value, "bankAccount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andBankAccountLessThanOrEqualTo(String value) {
            addCriterion("bank_account <=", value, "bankAccount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andBankAccountLike(String value) {
            addCriterion("bank_account like", value, "bankAccount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andBankAccountNotLike(String value) {
            addCriterion("bank_account not like", value, "bankAccount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andBankAccountIn(List<String> values) {
            addCriterion("bank_account in", values, "bankAccount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andBankAccountNotIn(List<String> values) {
            addCriterion("bank_account not in", values, "bankAccount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andBankAccountBetween(String value1, String value2) {
            addCriterion("bank_account between", value1, value2, "bankAccount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andBankAccountNotBetween(String value1, String value2) {
            addCriterion("bank_account not between", value1, value2, "bankAccount");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOpeningBankIsNull() {
            addCriterion("opening_bank is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOpeningBankIsNotNull() {
            addCriterion("opening_bank is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOpeningBankEqualTo(String value) {
            addCriterion("opening_bank =", value, "openingBank");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOpeningBankNotEqualTo(String value) {
            addCriterion("opening_bank <>", value, "openingBank");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOpeningBankGreaterThan(String value) {
            addCriterion("opening_bank >", value, "openingBank");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOpeningBankGreaterThanOrEqualTo(String value) {
            addCriterion("opening_bank >=", value, "openingBank");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOpeningBankLessThan(String value) {
            addCriterion("opening_bank <", value, "openingBank");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOpeningBankLessThanOrEqualTo(String value) {
            addCriterion("opening_bank <=", value, "openingBank");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOpeningBankLike(String value) {
            addCriterion("opening_bank like", value, "openingBank");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOpeningBankNotLike(String value) {
            addCriterion("opening_bank not like", value, "openingBank");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOpeningBankIn(List<String> values) {
            addCriterion("opening_bank in", values, "openingBank");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOpeningBankNotIn(List<String> values) {
            addCriterion("opening_bank not in", values, "openingBank");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOpeningBankBetween(String value1, String value2) {
            addCriterion("opening_bank between", value1, value2, "openingBank");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOpeningBankNotBetween(String value1, String value2) {
            addCriterion("opening_bank not between", value1, value2, "openingBank");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsremoveIsNull() {
            addCriterion("isremove is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsremoveIsNotNull() {
            addCriterion("isremove is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsremoveEqualTo(Boolean value) {
            addCriterion("isremove =", value, "isremove");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsremoveNotEqualTo(Boolean value) {
            addCriterion("isremove <>", value, "isremove");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsremoveGreaterThan(Boolean value) {
            addCriterion("isremove >", value, "isremove");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsremoveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("isremove >=", value, "isremove");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsremoveLessThan(Boolean value) {
            addCriterion("isremove <", value, "isremove");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsremoveLessThanOrEqualTo(Boolean value) {
            addCriterion("isremove <=", value, "isremove");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsremoveIn(List<Boolean> values) {
            addCriterion("isremove in", values, "isremove");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsremoveNotIn(List<Boolean> values) {
            addCriterion("isremove not in", values, "isremove");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsremoveBetween(Boolean value1, Boolean value2) {
            addCriterion("isremove between", value1, value2, "isremove");
            return (OrderCriteria) this;
        }

        public OrderCriteria andIsremoveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("isremove not between", value1, value2, "isremove");
            return (OrderCriteria) this;
        }

        public OrderCriteria andSourceTypeIsNull() {
            addCriterion("source_type is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andSourceTypeIsNotNull() {
            addCriterion("source_type is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andSourceTypeEqualTo(String value) {
            addCriterion("source_type =", value, "sourceType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andSourceTypeNotEqualTo(String value) {
            addCriterion("source_type <>", value, "sourceType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andSourceTypeGreaterThan(String value) {
            addCriterion("source_type >", value, "sourceType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andSourceTypeGreaterThanOrEqualTo(String value) {
            addCriterion("source_type >=", value, "sourceType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andSourceTypeLessThan(String value) {
            addCriterion("source_type <", value, "sourceType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andSourceTypeLessThanOrEqualTo(String value) {
            addCriterion("source_type <=", value, "sourceType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andSourceTypeLike(String value) {
            addCriterion("source_type like", value, "sourceType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andSourceTypeNotLike(String value) {
            addCriterion("source_type not like", value, "sourceType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andSourceTypeIn(List<String> values) {
            addCriterion("source_type in", values, "sourceType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andSourceTypeNotIn(List<String> values) {
            addCriterion("source_type not in", values, "sourceType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andSourceTypeBetween(String value1, String value2) {
            addCriterion("source_type between", value1, value2, "sourceType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andSourceTypeNotBetween(String value1, String value2) {
            addCriterion("source_type not between", value1, value2, "sourceType");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreaterIsNull() {
            addCriterion("creater is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreaterIsNotNull() {
            addCriterion("creater is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreaterEqualTo(String value) {
            addCriterion("creater =", value, "creater");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreaterNotEqualTo(String value) {
            addCriterion("creater <>", value, "creater");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreaterGreaterThan(String value) {
            addCriterion("creater >", value, "creater");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreaterGreaterThanOrEqualTo(String value) {
            addCriterion("creater >=", value, "creater");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreaterLessThan(String value) {
            addCriterion("creater <", value, "creater");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreaterLessThanOrEqualTo(String value) {
            addCriterion("creater <=", value, "creater");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreaterLike(String value) {
            addCriterion("creater like", value, "creater");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreaterNotLike(String value) {
            addCriterion("creater not like", value, "creater");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreaterIn(List<String> values) {
            addCriterion("creater in", values, "creater");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreaterNotIn(List<String> values) {
            addCriterion("creater not in", values, "creater");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreaterBetween(String value1, String value2) {
            addCriterion("creater between", value1, value2, "creater");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreaterNotBetween(String value1, String value2) {
            addCriterion("creater not between", value1, value2, "creater");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatorIsNull() {
            addCriterion("operator is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatorIsNotNull() {
            addCriterion("operator is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatorEqualTo(String value) {
            addCriterion("operator =", value, "operator");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatorNotEqualTo(String value) {
            addCriterion("operator <>", value, "operator");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatorGreaterThan(String value) {
            addCriterion("operator >", value, "operator");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatorGreaterThanOrEqualTo(String value) {
            addCriterion("operator >=", value, "operator");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatorLessThan(String value) {
            addCriterion("operator <", value, "operator");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatorLessThanOrEqualTo(String value) {
            addCriterion("operator <=", value, "operator");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatorLike(String value) {
            addCriterion("operator like", value, "operator");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatorNotLike(String value) {
            addCriterion("operator not like", value, "operator");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatorIn(List<String> values) {
            addCriterion("operator in", values, "operator");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatorNotIn(List<String> values) {
            addCriterion("operator not in", values, "operator");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatorBetween(String value1, String value2) {
            addCriterion("operator between", value1, value2, "operator");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatorNotBetween(String value1, String value2) {
            addCriterion("operator not between", value1, value2, "operator");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatortimeIsNull() {
            addCriterion("operatortime is null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatortimeIsNotNull() {
            addCriterion("operatortime is not null");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatortimeEqualTo(Date value) {
            addCriterion("operatortime =", value, "operatortime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatortimeNotEqualTo(Date value) {
            addCriterion("operatortime <>", value, "operatortime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatortimeGreaterThan(Date value) {
            addCriterion("operatortime >", value, "operatortime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatortimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operatortime >=", value, "operatortime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatortimeLessThan(Date value) {
            addCriterion("operatortime <", value, "operatortime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatortimeLessThanOrEqualTo(Date value) {
            addCriterion("operatortime <=", value, "operatortime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatortimeIn(List<Date> values) {
            addCriterion("operatortime in", values, "operatortime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatortimeNotIn(List<Date> values) {
            addCriterion("operatortime not in", values, "operatortime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatortimeBetween(Date value1, Date value2) {
            addCriterion("operatortime between", value1, value2, "operatortime");
            return (OrderCriteria) this;
        }

        public OrderCriteria andOperatortimeNotBetween(Date value1, Date value2) {
            addCriterion("operatortime not between", value1, value2, "operatortime");
            return (OrderCriteria) this;
        }
    }

    public static class OrderCriteria extends GeneratedOrderCriteria {

        protected OrderCriteria() {
            super();
        }
    }

    public static class OrderCriterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected OrderCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected OrderCriterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected OrderCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected OrderCriterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected OrderCriterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
