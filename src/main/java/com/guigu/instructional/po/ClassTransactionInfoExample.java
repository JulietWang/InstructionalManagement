package com.guigu.instructional.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClassTransactionInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassTransactionInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
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

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andClassTransactionIdIsNull() {
            addCriterion("class_transaction_id is null");
            return (Criteria) this;
        }

        public Criteria andClassTransactionIdIsNotNull() {
            addCriterion("class_transaction_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassTransactionIdEqualTo(Integer value) {
            addCriterion("class_transaction_id =", value, "classTransactionId");
            return (Criteria) this;
        }

        public Criteria andClassTransactionIdNotEqualTo(Integer value) {
            addCriterion("class_transaction_id <>", value, "classTransactionId");
            return (Criteria) this;
        }

        public Criteria andClassTransactionIdGreaterThan(Integer value) {
            addCriterion("class_transaction_id >", value, "classTransactionId");
            return (Criteria) this;
        }

        public Criteria andClassTransactionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_transaction_id >=", value, "classTransactionId");
            return (Criteria) this;
        }

        public Criteria andClassTransactionIdLessThan(Integer value) {
            addCriterion("class_transaction_id <", value, "classTransactionId");
            return (Criteria) this;
        }

        public Criteria andClassTransactionIdLessThanOrEqualTo(Integer value) {
            addCriterion("class_transaction_id <=", value, "classTransactionId");
            return (Criteria) this;
        }

        public Criteria andClassTransactionIdIn(List<Integer> values) {
            addCriterion("class_transaction_id in", values, "classTransactionId");
            return (Criteria) this;
        }

        public Criteria andClassTransactionIdNotIn(List<Integer> values) {
            addCriterion("class_transaction_id not in", values, "classTransactionId");
            return (Criteria) this;
        }

        public Criteria andClassTransactionIdBetween(Integer value1, Integer value2) {
            addCriterion("class_transaction_id between", value1, value2, "classTransactionId");
            return (Criteria) this;
        }

        public Criteria andClassTransactionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("class_transaction_id not between", value1, value2, "classTransactionId");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(Integer value) {
            addCriterion("class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(Integer value) {
            addCriterion("class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(Integer value) {
            addCriterion("class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(Integer value) {
            addCriterion("class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<Integer> values) {
            addCriterion("class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<Integer> values) {
            addCriterion("class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(Integer value1, Integer value2) {
            addCriterion("class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTileIsNull() {
            addCriterion("class_transaction_tile is null");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTileIsNotNull() {
            addCriterion("class_transaction_tile is not null");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTileEqualTo(String value) {
            addCriterion("class_transaction_tile =", value, "classTransactionTile");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTileNotEqualTo(String value) {
            addCriterion("class_transaction_tile <>", value, "classTransactionTile");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTileGreaterThan(String value) {
            addCriterion("class_transaction_tile >", value, "classTransactionTile");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTileGreaterThanOrEqualTo(String value) {
            addCriterion("class_transaction_tile >=", value, "classTransactionTile");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTileLessThan(String value) {
            addCriterion("class_transaction_tile <", value, "classTransactionTile");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTileLessThanOrEqualTo(String value) {
            addCriterion("class_transaction_tile <=", value, "classTransactionTile");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTileLike(String value) {
            addCriterion("class_transaction_tile like", value, "classTransactionTile");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTileNotLike(String value) {
            addCriterion("class_transaction_tile not like", value, "classTransactionTile");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTileIn(List<String> values) {
            addCriterion("class_transaction_tile in", values, "classTransactionTile");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTileNotIn(List<String> values) {
            addCriterion("class_transaction_tile not in", values, "classTransactionTile");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTileBetween(String value1, String value2) {
            addCriterion("class_transaction_tile between", value1, value2, "classTransactionTile");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTileNotBetween(String value1, String value2) {
            addCriterion("class_transaction_tile not between", value1, value2, "classTransactionTile");
            return (Criteria) this;
        }

        public Criteria andClassTransactionContentIsNull() {
            addCriterion("class_transaction_content is null");
            return (Criteria) this;
        }

        public Criteria andClassTransactionContentIsNotNull() {
            addCriterion("class_transaction_content is not null");
            return (Criteria) this;
        }

        public Criteria andClassTransactionContentEqualTo(String value) {
            addCriterion("class_transaction_content =", value, "classTransactionContent");
            return (Criteria) this;
        }

        public Criteria andClassTransactionContentNotEqualTo(String value) {
            addCriterion("class_transaction_content <>", value, "classTransactionContent");
            return (Criteria) this;
        }

        public Criteria andClassTransactionContentGreaterThan(String value) {
            addCriterion("class_transaction_content >", value, "classTransactionContent");
            return (Criteria) this;
        }

        public Criteria andClassTransactionContentGreaterThanOrEqualTo(String value) {
            addCriterion("class_transaction_content >=", value, "classTransactionContent");
            return (Criteria) this;
        }

        public Criteria andClassTransactionContentLessThan(String value) {
            addCriterion("class_transaction_content <", value, "classTransactionContent");
            return (Criteria) this;
        }

        public Criteria andClassTransactionContentLessThanOrEqualTo(String value) {
            addCriterion("class_transaction_content <=", value, "classTransactionContent");
            return (Criteria) this;
        }

        public Criteria andClassTransactionContentLike(String value) {
            addCriterion("class_transaction_content like", value, "classTransactionContent");
            return (Criteria) this;
        }

        public Criteria andClassTransactionContentNotLike(String value) {
            addCriterion("class_transaction_content not like", value, "classTransactionContent");
            return (Criteria) this;
        }

        public Criteria andClassTransactionContentIn(List<String> values) {
            addCriterion("class_transaction_content in", values, "classTransactionContent");
            return (Criteria) this;
        }

        public Criteria andClassTransactionContentNotIn(List<String> values) {
            addCriterion("class_transaction_content not in", values, "classTransactionContent");
            return (Criteria) this;
        }

        public Criteria andClassTransactionContentBetween(String value1, String value2) {
            addCriterion("class_transaction_content between", value1, value2, "classTransactionContent");
            return (Criteria) this;
        }

        public Criteria andClassTransactionContentNotBetween(String value1, String value2) {
            addCriterion("class_transaction_content not between", value1, value2, "classTransactionContent");
            return (Criteria) this;
        }

        public Criteria andClassTransactionPersonIsNull() {
            addCriterion("class_transaction_person is null");
            return (Criteria) this;
        }

        public Criteria andClassTransactionPersonIsNotNull() {
            addCriterion("class_transaction_person is not null");
            return (Criteria) this;
        }

        public Criteria andClassTransactionPersonEqualTo(String value) {
            addCriterion("class_transaction_person =", value, "classTransactionPerson");
            return (Criteria) this;
        }

        public Criteria andClassTransactionPersonNotEqualTo(String value) {
            addCriterion("class_transaction_person <>", value, "classTransactionPerson");
            return (Criteria) this;
        }

        public Criteria andClassTransactionPersonGreaterThan(String value) {
            addCriterion("class_transaction_person >", value, "classTransactionPerson");
            return (Criteria) this;
        }

        public Criteria andClassTransactionPersonGreaterThanOrEqualTo(String value) {
            addCriterion("class_transaction_person >=", value, "classTransactionPerson");
            return (Criteria) this;
        }

        public Criteria andClassTransactionPersonLessThan(String value) {
            addCriterion("class_transaction_person <", value, "classTransactionPerson");
            return (Criteria) this;
        }

        public Criteria andClassTransactionPersonLessThanOrEqualTo(String value) {
            addCriterion("class_transaction_person <=", value, "classTransactionPerson");
            return (Criteria) this;
        }

        public Criteria andClassTransactionPersonLike(String value) {
            addCriterion("class_transaction_person like", value, "classTransactionPerson");
            return (Criteria) this;
        }

        public Criteria andClassTransactionPersonNotLike(String value) {
            addCriterion("class_transaction_person not like", value, "classTransactionPerson");
            return (Criteria) this;
        }

        public Criteria andClassTransactionPersonIn(List<String> values) {
            addCriterion("class_transaction_person in", values, "classTransactionPerson");
            return (Criteria) this;
        }

        public Criteria andClassTransactionPersonNotIn(List<String> values) {
            addCriterion("class_transaction_person not in", values, "classTransactionPerson");
            return (Criteria) this;
        }

        public Criteria andClassTransactionPersonBetween(String value1, String value2) {
            addCriterion("class_transaction_person between", value1, value2, "classTransactionPerson");
            return (Criteria) this;
        }

        public Criteria andClassTransactionPersonNotBetween(String value1, String value2) {
            addCriterion("class_transaction_person not between", value1, value2, "classTransactionPerson");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTimeIsNull() {
            addCriterion("class_transaction_time is null");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTimeIsNotNull() {
            addCriterion("class_transaction_time is not null");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTimeEqualTo(Date value) {
            addCriterion("class_transaction_time =", value, "classTransactionTime");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTimeNotEqualTo(Date value) {
            addCriterion("class_transaction_time <>", value, "classTransactionTime");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTimeGreaterThan(Date value) {
            addCriterion("class_transaction_time >", value, "classTransactionTime");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("class_transaction_time >=", value, "classTransactionTime");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTimeLessThan(Date value) {
            addCriterion("class_transaction_time <", value, "classTransactionTime");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTimeLessThanOrEqualTo(Date value) {
            addCriterion("class_transaction_time <=", value, "classTransactionTime");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTimeIn(List<Date> values) {
            addCriterion("class_transaction_time in", values, "classTransactionTime");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTimeNotIn(List<Date> values) {
            addCriterion("class_transaction_time not in", values, "classTransactionTime");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTimeBetween(Date value1, Date value2) {
            addCriterion("class_transaction_time between", value1, value2, "classTransactionTime");
            return (Criteria) this;
        }

        public Criteria andClassTransactionTimeNotBetween(Date value1, Date value2) {
            addCriterion("class_transaction_time not between", value1, value2, "classTransactionTime");
            return (Criteria) this;
        }

        public Criteria andClassTransactionRemarIsNull() {
            addCriterion("class_transaction_remar is null");
            return (Criteria) this;
        }

        public Criteria andClassTransactionRemarIsNotNull() {
            addCriterion("class_transaction_remar is not null");
            return (Criteria) this;
        }

        public Criteria andClassTransactionRemarEqualTo(String value) {
            addCriterion("class_transaction_remar =", value, "classTransactionRemar");
            return (Criteria) this;
        }

        public Criteria andClassTransactionRemarNotEqualTo(String value) {
            addCriterion("class_transaction_remar <>", value, "classTransactionRemar");
            return (Criteria) this;
        }

        public Criteria andClassTransactionRemarGreaterThan(String value) {
            addCriterion("class_transaction_remar >", value, "classTransactionRemar");
            return (Criteria) this;
        }

        public Criteria andClassTransactionRemarGreaterThanOrEqualTo(String value) {
            addCriterion("class_transaction_remar >=", value, "classTransactionRemar");
            return (Criteria) this;
        }

        public Criteria andClassTransactionRemarLessThan(String value) {
            addCriterion("class_transaction_remar <", value, "classTransactionRemar");
            return (Criteria) this;
        }

        public Criteria andClassTransactionRemarLessThanOrEqualTo(String value) {
            addCriterion("class_transaction_remar <=", value, "classTransactionRemar");
            return (Criteria) this;
        }

        public Criteria andClassTransactionRemarLike(String value) {
            addCriterion("class_transaction_remar like", value, "classTransactionRemar");
            return (Criteria) this;
        }

        public Criteria andClassTransactionRemarNotLike(String value) {
            addCriterion("class_transaction_remar not like", value, "classTransactionRemar");
            return (Criteria) this;
        }

        public Criteria andClassTransactionRemarIn(List<String> values) {
            addCriterion("class_transaction_remar in", values, "classTransactionRemar");
            return (Criteria) this;
        }

        public Criteria andClassTransactionRemarNotIn(List<String> values) {
            addCriterion("class_transaction_remar not in", values, "classTransactionRemar");
            return (Criteria) this;
        }

        public Criteria andClassTransactionRemarBetween(String value1, String value2) {
            addCriterion("class_transaction_remar between", value1, value2, "classTransactionRemar");
            return (Criteria) this;
        }

        public Criteria andClassTransactionRemarNotBetween(String value1, String value2) {
            addCriterion("class_transaction_remar not between", value1, value2, "classTransactionRemar");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
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

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}