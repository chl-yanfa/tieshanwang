package com.tieshan.api.po.chebaofeiPo.v1.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningrz
 * @version 1.0
 * @date 2019/9/20 9:34
 */
public class CarScrapMailingAddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<MailCriteria> oredCriteria;

    public CarScrapMailingAddressExample() {
        oredCriteria = new ArrayList<MailCriteria>();
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

    public List<MailCriteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(MailCriteria criteria) {
        oredCriteria.add(criteria);
    }

    public MailCriteria or() {
        MailCriteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public MailCriteria createCriteria() {
        MailCriteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected MailCriteria createCriteriaInternal() {
        MailCriteria criteria = new MailCriteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class MailGeneratedCriteria {
        protected List<MailCriterion> criteria;

        protected MailGeneratedCriteria() {
            super();
            criteria = new ArrayList<MailCriterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<MailCriterion> getAllCriteria() {
            return criteria;
        }

        public List<MailCriterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new MailCriterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new MailCriterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new MailCriterion(condition, value1, value2));
        }

        public MailCriteria andIdIsNull() {
            addCriterion("id is null");
            return (MailCriteria) this;
        }

        public MailCriteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (MailCriteria) this;
        }

        public MailCriteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (MailCriteria) this;
        }

        public MailCriteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (MailCriteria) this;
        }

        public MailCriteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (MailCriteria) this;
        }

        public MailCriteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (MailCriteria) this;
        }

        public MailCriteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (MailCriteria) this;
        }

        public MailCriteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (MailCriteria) this;
        }

        public MailCriteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (MailCriteria) this;
        }

        public MailCriteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (MailCriteria) this;
        }

        public MailCriteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (MailCriteria) this;
        }

        public MailCriteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeNameIsNull() {
            addCriterion("addressee_name is null");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeNameIsNotNull() {
            addCriterion("addressee_name is not null");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeNameEqualTo(String value) {
            addCriterion("addressee_name =", value, "addresseeName");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeNameNotEqualTo(String value) {
            addCriterion("addressee_name <>", value, "addresseeName");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeNameGreaterThan(String value) {
            addCriterion("addressee_name >", value, "addresseeName");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeNameGreaterThanOrEqualTo(String value) {
            addCriterion("addressee_name >=", value, "addresseeName");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeNameLessThan(String value) {
            addCriterion("addressee_name <", value, "addresseeName");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeNameLessThanOrEqualTo(String value) {
            addCriterion("addressee_name <=", value, "addresseeName");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeNameLike(String value) {
            addCriterion("addressee_name like", value, "addresseeName");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeNameNotLike(String value) {
            addCriterion("addressee_name not like", value, "addresseeName");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeNameIn(List<String> values) {
            addCriterion("addressee_name in", values, "addresseeName");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeNameNotIn(List<String> values) {
            addCriterion("addressee_name not in", values, "addresseeName");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeNameBetween(String value1, String value2) {
            addCriterion("addressee_name between", value1, value2, "addresseeName");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeNameNotBetween(String value1, String value2) {
            addCriterion("addressee_name not between", value1, value2, "addresseeName");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeTelephoneIsNull() {
            addCriterion("addressee_telephone is null");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeTelephoneIsNotNull() {
            addCriterion("addressee_telephone is not null");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeTelephoneEqualTo(String value) {
            addCriterion("addressee_telephone =", value, "addresseeTelephone");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeTelephoneNotEqualTo(String value) {
            addCriterion("addressee_telephone <>", value, "addresseeTelephone");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeTelephoneGreaterThan(String value) {
            addCriterion("addressee_telephone >", value, "addresseeTelephone");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("addressee_telephone >=", value, "addresseeTelephone");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeTelephoneLessThan(String value) {
            addCriterion("addressee_telephone <", value, "addresseeTelephone");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeTelephoneLessThanOrEqualTo(String value) {
            addCriterion("addressee_telephone <=", value, "addresseeTelephone");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeTelephoneLike(String value) {
            addCriterion("addressee_telephone like", value, "addresseeTelephone");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeTelephoneNotLike(String value) {
            addCriterion("addressee_telephone not like", value, "addresseeTelephone");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeTelephoneIn(List<String> values) {
            addCriterion("addressee_telephone in", values, "addresseeTelephone");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeTelephoneNotIn(List<String> values) {
            addCriterion("addressee_telephone not in", values, "addresseeTelephone");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeTelephoneBetween(String value1, String value2) {
            addCriterion("addressee_telephone between", value1, value2, "addresseeTelephone");
            return (MailCriteria) this;
        }

        public MailCriteria andAddresseeTelephoneNotBetween(String value1, String value2) {
            addCriterion("addressee_telephone not between", value1, value2, "addresseeTelephone");
            return (MailCriteria) this;
        }

        public MailCriteria andProvinceIsNull() {
            addCriterion("province is null");
            return (MailCriteria) this;
        }

        public MailCriteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (MailCriteria) this;
        }

        public MailCriteria andProvinceEqualTo(Integer value) {
            addCriterion("province =", value, "province");
            return (MailCriteria) this;
        }

        public MailCriteria andProvinceNotEqualTo(Integer value) {
            addCriterion("province <>", value, "province");
            return (MailCriteria) this;
        }

        public MailCriteria andProvinceGreaterThan(Integer value) {
            addCriterion("province >", value, "province");
            return (MailCriteria) this;
        }

        public MailCriteria andProvinceGreaterThanOrEqualTo(Integer value) {
            addCriterion("province >=", value, "province");
            return (MailCriteria) this;
        }

        public MailCriteria andProvinceLessThan(Integer value) {
            addCriterion("province <", value, "province");
            return (MailCriteria) this;
        }

        public MailCriteria andProvinceLessThanOrEqualTo(Integer value) {
            addCriterion("province <=", value, "province");
            return (MailCriteria) this;
        }

        public MailCriteria andProvinceIn(List<Integer> values) {
            addCriterion("province in", values, "province");
            return (MailCriteria) this;
        }

        public MailCriteria andProvinceNotIn(List<Integer> values) {
            addCriterion("province not in", values, "province");
            return (MailCriteria) this;
        }

        public MailCriteria andProvinceBetween(Integer value1, Integer value2) {
            addCriterion("province between", value1, value2, "province");
            return (MailCriteria) this;
        }

        public MailCriteria andProvinceNotBetween(Integer value1, Integer value2) {
            addCriterion("province not between", value1, value2, "province");
            return (MailCriteria) this;
        }

        public MailCriteria andCityIsNull() {
            addCriterion("city is null");
            return (MailCriteria) this;
        }

        public MailCriteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (MailCriteria) this;
        }

        public MailCriteria andCityEqualTo(Integer value) {
            addCriterion("city =", value, "city");
            return (MailCriteria) this;
        }

        public MailCriteria andCityNotEqualTo(Integer value) {
            addCriterion("city <>", value, "city");
            return (MailCriteria) this;
        }

        public MailCriteria andCityGreaterThan(Integer value) {
            addCriterion("city >", value, "city");
            return (MailCriteria) this;
        }

        public MailCriteria andCityGreaterThanOrEqualTo(Integer value) {
            addCriterion("city >=", value, "city");
            return (MailCriteria) this;
        }

        public MailCriteria andCityLessThan(Integer value) {
            addCriterion("city <", value, "city");
            return (MailCriteria) this;
        }

        public MailCriteria andCityLessThanOrEqualTo(Integer value) {
            addCriterion("city <=", value, "city");
            return (MailCriteria) this;
        }

        public MailCriteria andCityIn(List<Integer> values) {
            addCriterion("city in", values, "city");
            return (MailCriteria) this;
        }

        public MailCriteria andCityNotIn(List<Integer> values) {
            addCriterion("city not in", values, "city");
            return (MailCriteria) this;
        }

        public MailCriteria andCityBetween(Integer value1, Integer value2) {
            addCriterion("city between", value1, value2, "city");
            return (MailCriteria) this;
        }

        public MailCriteria andCityNotBetween(Integer value1, Integer value2) {
            addCriterion("city not between", value1, value2, "city");
            return (MailCriteria) this;
        }

        public MailCriteria andCountyIsNull() {
            addCriterion("county is null");
            return (MailCriteria) this;
        }

        public MailCriteria andCountyIsNotNull() {
            addCriterion("county is not null");
            return (MailCriteria) this;
        }

        public MailCriteria andCountyEqualTo(Integer value) {
            addCriterion("county =", value, "county");
            return (MailCriteria) this;
        }

        public MailCriteria andCountyNotEqualTo(Integer value) {
            addCriterion("county <>", value, "county");
            return (MailCriteria) this;
        }

        public MailCriteria andCountyGreaterThan(Integer value) {
            addCriterion("county >", value, "county");
            return (MailCriteria) this;
        }

        public MailCriteria andCountyGreaterThanOrEqualTo(Integer value) {
            addCriterion("county >=", value, "county");
            return (MailCriteria) this;
        }

        public MailCriteria andCountyLessThan(Integer value) {
            addCriterion("county <", value, "county");
            return (MailCriteria) this;
        }

        public MailCriteria andCountyLessThanOrEqualTo(Integer value) {
            addCriterion("county <=", value, "county");
            return (MailCriteria) this;
        }

        public MailCriteria andCountyIn(List<Integer> values) {
            addCriterion("county in", values, "county");
            return (MailCriteria) this;
        }

        public MailCriteria andCountyNotIn(List<Integer> values) {
            addCriterion("county not in", values, "county");
            return (MailCriteria) this;
        }

        public MailCriteria andCountyBetween(Integer value1, Integer value2) {
            addCriterion("county between", value1, value2, "county");
            return (MailCriteria) this;
        }

        public MailCriteria andCountyNotBetween(Integer value1, Integer value2) {
            addCriterion("county not between", value1, value2, "county");
            return (MailCriteria) this;
        }

        public MailCriteria andDetailedAddressIsNull() {
            addCriterion("detailed_address is null");
            return (MailCriteria) this;
        }

        public MailCriteria andDetailedAddressIsNotNull() {
            addCriterion("detailed_address is not null");
            return (MailCriteria) this;
        }

        public MailCriteria andDetailedAddressEqualTo(String value) {
            addCriterion("detailed_address =", value, "detailedAddress");
            return (MailCriteria) this;
        }

        public MailCriteria andDetailedAddressNotEqualTo(String value) {
            addCriterion("detailed_address <>", value, "detailedAddress");
            return (MailCriteria) this;
        }

        public MailCriteria andDetailedAddressGreaterThan(String value) {
            addCriterion("detailed_address >", value, "detailedAddress");
            return (MailCriteria) this;
        }

        public MailCriteria andDetailedAddressGreaterThanOrEqualTo(String value) {
            addCriterion("detailed_address >=", value, "detailedAddress");
            return (MailCriteria) this;
        }

        public MailCriteria andDetailedAddressLessThan(String value) {
            addCriterion("detailed_address <", value, "detailedAddress");
            return (MailCriteria) this;
        }

        public MailCriteria andDetailedAddressLessThanOrEqualTo(String value) {
            addCriterion("detailed_address <=", value, "detailedAddress");
            return (MailCriteria) this;
        }

        public MailCriteria andDetailedAddressLike(String value) {
            addCriterion("detailed_address like", value, "detailedAddress");
            return (MailCriteria) this;
        }

        public MailCriteria andDetailedAddressNotLike(String value) {
            addCriterion("detailed_address not like", value, "detailedAddress");
            return (MailCriteria) this;
        }

        public MailCriteria andDetailedAddressIn(List<String> values) {
            addCriterion("detailed_address in", values, "detailedAddress");
            return (MailCriteria) this;
        }

        public MailCriteria andDetailedAddressNotIn(List<String> values) {
            addCriterion("detailed_address not in", values, "detailedAddress");
            return (MailCriteria) this;
        }

        public MailCriteria andDetailedAddressBetween(String value1, String value2) {
            addCriterion("detailed_address between", value1, value2, "detailedAddress");
            return (MailCriteria) this;
        }

        public MailCriteria andDetailedAddressNotBetween(String value1, String value2) {
            addCriterion("detailed_address not between", value1, value2, "detailedAddress");
            return (MailCriteria) this;
        }
    }

    public static class MailCriteria extends MailGeneratedCriteria {

        protected MailCriteria() {
            super();
        }
    }

    public static class MailCriterion {
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

        protected MailCriterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected MailCriterion(String condition, Object value, String typeHandler) {
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

        protected MailCriterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected MailCriterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected MailCriterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
