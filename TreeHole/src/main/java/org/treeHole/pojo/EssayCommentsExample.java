package org.treeHole.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EssayCommentsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EssayCommentsExample() {
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

        public Criteria andEssayidIsNull() {
            addCriterion("essayid is null");
            return (Criteria) this;
        }

        public Criteria andEssayidIsNotNull() {
            addCriterion("essayid is not null");
            return (Criteria) this;
        }

        public Criteria andEssayidEqualTo(Integer value) {
            addCriterion("essayid =", value, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidNotEqualTo(Integer value) {
            addCriterion("essayid <>", value, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidGreaterThan(Integer value) {
            addCriterion("essayid >", value, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidGreaterThanOrEqualTo(Integer value) {
            addCriterion("essayid >=", value, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidLessThan(Integer value) {
            addCriterion("essayid <", value, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidLessThanOrEqualTo(Integer value) {
            addCriterion("essayid <=", value, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidIn(List<Integer> values) {
            addCriterion("essayid in", values, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidNotIn(List<Integer> values) {
            addCriterion("essayid not in", values, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidBetween(Integer value1, Integer value2) {
            addCriterion("essayid between", value1, value2, "essayid");
            return (Criteria) this;
        }

        public Criteria andEssayidNotBetween(Integer value1, Integer value2) {
            addCriterion("essayid not between", value1, value2, "essayid");
            return (Criteria) this;
        }

        public Criteria andCommentsuseridIsNull() {
            addCriterion("commentsUserId is null");
            return (Criteria) this;
        }

        public Criteria andCommentsuseridIsNotNull() {
            addCriterion("commentsUserId is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsuseridEqualTo(Integer value) {
            addCriterion("commentsUserId =", value, "commentsuserid");
            return (Criteria) this;
        }

        public Criteria andCommentsuseridNotEqualTo(Integer value) {
            addCriterion("commentsUserId <>", value, "commentsuserid");
            return (Criteria) this;
        }

        public Criteria andCommentsuseridGreaterThan(Integer value) {
            addCriterion("commentsUserId >", value, "commentsuserid");
            return (Criteria) this;
        }

        public Criteria andCommentsuseridGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentsUserId >=", value, "commentsuserid");
            return (Criteria) this;
        }

        public Criteria andCommentsuseridLessThan(Integer value) {
            addCriterion("commentsUserId <", value, "commentsuserid");
            return (Criteria) this;
        }

        public Criteria andCommentsuseridLessThanOrEqualTo(Integer value) {
            addCriterion("commentsUserId <=", value, "commentsuserid");
            return (Criteria) this;
        }

        public Criteria andCommentsuseridIn(List<Integer> values) {
            addCriterion("commentsUserId in", values, "commentsuserid");
            return (Criteria) this;
        }

        public Criteria andCommentsuseridNotIn(List<Integer> values) {
            addCriterion("commentsUserId not in", values, "commentsuserid");
            return (Criteria) this;
        }

        public Criteria andCommentsuseridBetween(Integer value1, Integer value2) {
            addCriterion("commentsUserId between", value1, value2, "commentsuserid");
            return (Criteria) this;
        }

        public Criteria andCommentsuseridNotBetween(Integer value1, Integer value2) {
            addCriterion("commentsUserId not between", value1, value2, "commentsuserid");
            return (Criteria) this;
        }

        public Criteria andCommentstimeIsNull() {
            addCriterion("commentstime is null");
            return (Criteria) this;
        }

        public Criteria andCommentstimeIsNotNull() {
            addCriterion("commentstime is not null");
            return (Criteria) this;
        }

        public Criteria andCommentstimeEqualTo(Date value) {
            addCriterion("commentstime =", value, "commentstime");
            return (Criteria) this;
        }

        public Criteria andCommentstimeNotEqualTo(Date value) {
            addCriterion("commentstime <>", value, "commentstime");
            return (Criteria) this;
        }

        public Criteria andCommentstimeGreaterThan(Date value) {
            addCriterion("commentstime >", value, "commentstime");
            return (Criteria) this;
        }

        public Criteria andCommentstimeGreaterThanOrEqualTo(Date value) {
            addCriterion("commentstime >=", value, "commentstime");
            return (Criteria) this;
        }

        public Criteria andCommentstimeLessThan(Date value) {
            addCriterion("commentstime <", value, "commentstime");
            return (Criteria) this;
        }

        public Criteria andCommentstimeLessThanOrEqualTo(Date value) {
            addCriterion("commentstime <=", value, "commentstime");
            return (Criteria) this;
        }

        public Criteria andCommentstimeIn(List<Date> values) {
            addCriterion("commentstime in", values, "commentstime");
            return (Criteria) this;
        }

        public Criteria andCommentstimeNotIn(List<Date> values) {
            addCriterion("commentstime not in", values, "commentstime");
            return (Criteria) this;
        }

        public Criteria andCommentstimeBetween(Date value1, Date value2) {
            addCriterion("commentstime between", value1, value2, "commentstime");
            return (Criteria) this;
        }

        public Criteria andCommentstimeNotBetween(Date value1, Date value2) {
            addCriterion("commentstime not between", value1, value2, "commentstime");
            return (Criteria) this;
        }

        public Criteria andCommentsinfoIsNull() {
            addCriterion("commentsInfo is null");
            return (Criteria) this;
        }

        public Criteria andCommentsinfoIsNotNull() {
            addCriterion("commentsInfo is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsinfoEqualTo(String value) {
            addCriterion("commentsInfo =", value, "commentsinfo");
            return (Criteria) this;
        }

        public Criteria andCommentsinfoNotEqualTo(String value) {
            addCriterion("commentsInfo <>", value, "commentsinfo");
            return (Criteria) this;
        }

        public Criteria andCommentsinfoGreaterThan(String value) {
            addCriterion("commentsInfo >", value, "commentsinfo");
            return (Criteria) this;
        }

        public Criteria andCommentsinfoGreaterThanOrEqualTo(String value) {
            addCriterion("commentsInfo >=", value, "commentsinfo");
            return (Criteria) this;
        }

        public Criteria andCommentsinfoLessThan(String value) {
            addCriterion("commentsInfo <", value, "commentsinfo");
            return (Criteria) this;
        }

        public Criteria andCommentsinfoLessThanOrEqualTo(String value) {
            addCriterion("commentsInfo <=", value, "commentsinfo");
            return (Criteria) this;
        }

        public Criteria andCommentsinfoLike(String value) {
            addCriterion("commentsInfo like", value, "commentsinfo");
            return (Criteria) this;
        }

        public Criteria andCommentsinfoNotLike(String value) {
            addCriterion("commentsInfo not like", value, "commentsinfo");
            return (Criteria) this;
        }

        public Criteria andCommentsinfoIn(List<String> values) {
            addCriterion("commentsInfo in", values, "commentsinfo");
            return (Criteria) this;
        }

        public Criteria andCommentsinfoNotIn(List<String> values) {
            addCriterion("commentsInfo not in", values, "commentsinfo");
            return (Criteria) this;
        }

        public Criteria andCommentsinfoBetween(String value1, String value2) {
            addCriterion("commentsInfo between", value1, value2, "commentsinfo");
            return (Criteria) this;
        }

        public Criteria andCommentsinfoNotBetween(String value1, String value2) {
            addCriterion("commentsInfo not between", value1, value2, "commentsinfo");
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