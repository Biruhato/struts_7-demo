package org.my.mybatis.service.dao.mybatis.model;

import java.util.ArrayList;
import java.util.List;

public class IdeaExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table idea
     *
     * @mbg.generated Mon Jun 21 17:14:14 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table idea
     *
     * @mbg.generated Mon Jun 21 17:14:14 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table idea
     *
     * @mbg.generated Mon Jun 21 17:14:14 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table idea
     *
     * @mbg.generated Mon Jun 21 17:14:14 CST 2021
     */
    public IdeaExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table idea
     *
     * @mbg.generated Mon Jun 21 17:14:14 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table idea
     *
     * @mbg.generated Mon Jun 21 17:14:14 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table idea
     *
     * @mbg.generated Mon Jun 21 17:14:14 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table idea
     *
     * @mbg.generated Mon Jun 21 17:14:14 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table idea
     *
     * @mbg.generated Mon Jun 21 17:14:14 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table idea
     *
     * @mbg.generated Mon Jun 21 17:14:14 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table idea
     *
     * @mbg.generated Mon Jun 21 17:14:14 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table idea
     *
     * @mbg.generated Mon Jun 21 17:14:14 CST 2021
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table idea
     *
     * @mbg.generated Mon Jun 21 17:14:14 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table idea
     *
     * @mbg.generated Mon Jun 21 17:14:14 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table idea
     *
     * @mbg.generated Mon Jun 21 17:14:14 CST 2021
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
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

        public Criteria andSyskeyIsNull() {
            addCriterion("syskey is null");
            return (Criteria) this;
        }

        public Criteria andSyskeyIsNotNull() {
            addCriterion("syskey is not null");
            return (Criteria) this;
        }

        public Criteria andSyskeyEqualTo(String value) {
            addCriterion("syskey =", value, "syskey");
            return (Criteria) this;
        }

        public Criteria andSyskeyNotEqualTo(String value) {
            addCriterion("syskey <>", value, "syskey");
            return (Criteria) this;
        }

        public Criteria andSyskeyGreaterThan(String value) {
            addCriterion("syskey >", value, "syskey");
            return (Criteria) this;
        }

        public Criteria andSyskeyGreaterThanOrEqualTo(String value) {
            addCriterion("syskey >=", value, "syskey");
            return (Criteria) this;
        }

        public Criteria andSyskeyLessThan(String value) {
            addCriterion("syskey <", value, "syskey");
            return (Criteria) this;
        }

        public Criteria andSyskeyLessThanOrEqualTo(String value) {
            addCriterion("syskey <=", value, "syskey");
            return (Criteria) this;
        }

        public Criteria andSyskeyLike(String value) {
            addCriterion("syskey like", value, "syskey");
            return (Criteria) this;
        }

        public Criteria andSyskeyNotLike(String value) {
            addCriterion("syskey not like", value, "syskey");
            return (Criteria) this;
        }

        public Criteria andSyskeyIn(List<String> values) {
            addCriterion("syskey in", values, "syskey");
            return (Criteria) this;
        }

        public Criteria andSyskeyNotIn(List<String> values) {
            addCriterion("syskey not in", values, "syskey");
            return (Criteria) this;
        }

        public Criteria andSyskeyBetween(String value1, String value2) {
            addCriterion("syskey between", value1, value2, "syskey");
            return (Criteria) this;
        }

        public Criteria andSyskeyNotBetween(String value1, String value2) {
            addCriterion("syskey not between", value1, value2, "syskey");
            return (Criteria) this;
        }

        public Criteria andIdeatypeIsNull() {
            addCriterion("ideaType is null");
            return (Criteria) this;
        }

        public Criteria andIdeatypeIsNotNull() {
            addCriterion("ideaType is not null");
            return (Criteria) this;
        }

        public Criteria andIdeatypeEqualTo(String value) {
            addCriterion("ideaType =", value, "ideatype");
            return (Criteria) this;
        }

        public Criteria andIdeatypeNotEqualTo(String value) {
            addCriterion("ideaType <>", value, "ideatype");
            return (Criteria) this;
        }

        public Criteria andIdeatypeGreaterThan(String value) {
            addCriterion("ideaType >", value, "ideatype");
            return (Criteria) this;
        }

        public Criteria andIdeatypeGreaterThanOrEqualTo(String value) {
            addCriterion("ideaType >=", value, "ideatype");
            return (Criteria) this;
        }

        public Criteria andIdeatypeLessThan(String value) {
            addCriterion("ideaType <", value, "ideatype");
            return (Criteria) this;
        }

        public Criteria andIdeatypeLessThanOrEqualTo(String value) {
            addCriterion("ideaType <=", value, "ideatype");
            return (Criteria) this;
        }

        public Criteria andIdeatypeLike(String value) {
            addCriterion("ideaType like", value, "ideatype");
            return (Criteria) this;
        }

        public Criteria andIdeatypeNotLike(String value) {
            addCriterion("ideaType not like", value, "ideatype");
            return (Criteria) this;
        }

        public Criteria andIdeatypeIn(List<String> values) {
            addCriterion("ideaType in", values, "ideatype");
            return (Criteria) this;
        }

        public Criteria andIdeatypeNotIn(List<String> values) {
            addCriterion("ideaType not in", values, "ideatype");
            return (Criteria) this;
        }

        public Criteria andIdeatypeBetween(String value1, String value2) {
            addCriterion("ideaType between", value1, value2, "ideatype");
            return (Criteria) this;
        }

        public Criteria andIdeatypeNotBetween(String value1, String value2) {
            addCriterion("ideaType not between", value1, value2, "ideatype");
            return (Criteria) this;
        }

        public Criteria andIdeacontentsIsNull() {
            addCriterion("ideaContents is null");
            return (Criteria) this;
        }

        public Criteria andIdeacontentsIsNotNull() {
            addCriterion("ideaContents is not null");
            return (Criteria) this;
        }

        public Criteria andIdeacontentsEqualTo(String value) {
            addCriterion("ideaContents =", value, "ideacontents");
            return (Criteria) this;
        }

        public Criteria andIdeacontentsNotEqualTo(String value) {
            addCriterion("ideaContents <>", value, "ideacontents");
            return (Criteria) this;
        }

        public Criteria andIdeacontentsGreaterThan(String value) {
            addCriterion("ideaContents >", value, "ideacontents");
            return (Criteria) this;
        }

        public Criteria andIdeacontentsGreaterThanOrEqualTo(String value) {
            addCriterion("ideaContents >=", value, "ideacontents");
            return (Criteria) this;
        }

        public Criteria andIdeacontentsLessThan(String value) {
            addCriterion("ideaContents <", value, "ideacontents");
            return (Criteria) this;
        }

        public Criteria andIdeacontentsLessThanOrEqualTo(String value) {
            addCriterion("ideaContents <=", value, "ideacontents");
            return (Criteria) this;
        }

        public Criteria andIdeacontentsLike(String value) {
            addCriterion("ideaContents like", value, "ideacontents");
            return (Criteria) this;
        }

        public Criteria andIdeacontentsNotLike(String value) {
            addCriterion("ideaContents not like", value, "ideacontents");
            return (Criteria) this;
        }

        public Criteria andIdeacontentsIn(List<String> values) {
            addCriterion("ideaContents in", values, "ideacontents");
            return (Criteria) this;
        }

        public Criteria andIdeacontentsNotIn(List<String> values) {
            addCriterion("ideaContents not in", values, "ideacontents");
            return (Criteria) this;
        }

        public Criteria andIdeacontentsBetween(String value1, String value2) {
            addCriterion("ideaContents between", value1, value2, "ideacontents");
            return (Criteria) this;
        }

        public Criteria andIdeacontentsNotBetween(String value1, String value2) {
            addCriterion("ideaContents not between", value1, value2, "ideacontents");
            return (Criteria) this;
        }

        public Criteria andIdeawhoIsNull() {
            addCriterion("ideaWho is null");
            return (Criteria) this;
        }

        public Criteria andIdeawhoIsNotNull() {
            addCriterion("ideaWho is not null");
            return (Criteria) this;
        }

        public Criteria andIdeawhoEqualTo(String value) {
            addCriterion("ideaWho =", value, "ideawho");
            return (Criteria) this;
        }

        public Criteria andIdeawhoNotEqualTo(String value) {
            addCriterion("ideaWho <>", value, "ideawho");
            return (Criteria) this;
        }

        public Criteria andIdeawhoGreaterThan(String value) {
            addCriterion("ideaWho >", value, "ideawho");
            return (Criteria) this;
        }

        public Criteria andIdeawhoGreaterThanOrEqualTo(String value) {
            addCriterion("ideaWho >=", value, "ideawho");
            return (Criteria) this;
        }

        public Criteria andIdeawhoLessThan(String value) {
            addCriterion("ideaWho <", value, "ideawho");
            return (Criteria) this;
        }

        public Criteria andIdeawhoLessThanOrEqualTo(String value) {
            addCriterion("ideaWho <=", value, "ideawho");
            return (Criteria) this;
        }

        public Criteria andIdeawhoLike(String value) {
            addCriterion("ideaWho like", value, "ideawho");
            return (Criteria) this;
        }

        public Criteria andIdeawhoNotLike(String value) {
            addCriterion("ideaWho not like", value, "ideawho");
            return (Criteria) this;
        }

        public Criteria andIdeawhoIn(List<String> values) {
            addCriterion("ideaWho in", values, "ideawho");
            return (Criteria) this;
        }

        public Criteria andIdeawhoNotIn(List<String> values) {
            addCriterion("ideaWho not in", values, "ideawho");
            return (Criteria) this;
        }

        public Criteria andIdeawhoBetween(String value1, String value2) {
            addCriterion("ideaWho between", value1, value2, "ideawho");
            return (Criteria) this;
        }

        public Criteria andIdeawhoNotBetween(String value1, String value2) {
            addCriterion("ideaWho not between", value1, value2, "ideawho");
            return (Criteria) this;
        }

        public Criteria andIdeawhereIsNull() {
            addCriterion("ideaWhere is null");
            return (Criteria) this;
        }

        public Criteria andIdeawhereIsNotNull() {
            addCriterion("ideaWhere is not null");
            return (Criteria) this;
        }

        public Criteria andIdeawhereEqualTo(String value) {
            addCriterion("ideaWhere =", value, "ideawhere");
            return (Criteria) this;
        }

        public Criteria andIdeawhereNotEqualTo(String value) {
            addCriterion("ideaWhere <>", value, "ideawhere");
            return (Criteria) this;
        }

        public Criteria andIdeawhereGreaterThan(String value) {
            addCriterion("ideaWhere >", value, "ideawhere");
            return (Criteria) this;
        }

        public Criteria andIdeawhereGreaterThanOrEqualTo(String value) {
            addCriterion("ideaWhere >=", value, "ideawhere");
            return (Criteria) this;
        }

        public Criteria andIdeawhereLessThan(String value) {
            addCriterion("ideaWhere <", value, "ideawhere");
            return (Criteria) this;
        }

        public Criteria andIdeawhereLessThanOrEqualTo(String value) {
            addCriterion("ideaWhere <=", value, "ideawhere");
            return (Criteria) this;
        }

        public Criteria andIdeawhereLike(String value) {
            addCriterion("ideaWhere like", value, "ideawhere");
            return (Criteria) this;
        }

        public Criteria andIdeawhereNotLike(String value) {
            addCriterion("ideaWhere not like", value, "ideawhere");
            return (Criteria) this;
        }

        public Criteria andIdeawhereIn(List<String> values) {
            addCriterion("ideaWhere in", values, "ideawhere");
            return (Criteria) this;
        }

        public Criteria andIdeawhereNotIn(List<String> values) {
            addCriterion("ideaWhere not in", values, "ideawhere");
            return (Criteria) this;
        }

        public Criteria andIdeawhereBetween(String value1, String value2) {
            addCriterion("ideaWhere between", value1, value2, "ideawhere");
            return (Criteria) this;
        }

        public Criteria andIdeawhereNotBetween(String value1, String value2) {
            addCriterion("ideaWhere not between", value1, value2, "ideawhere");
            return (Criteria) this;
        }

        public Criteria andIdeahappenedIsNull() {
            addCriterion("ideaHappened is null");
            return (Criteria) this;
        }

        public Criteria andIdeahappenedIsNotNull() {
            addCriterion("ideaHappened is not null");
            return (Criteria) this;
        }

        public Criteria andIdeahappenedEqualTo(String value) {
            addCriterion("ideaHappened =", value, "ideahappened");
            return (Criteria) this;
        }

        public Criteria andIdeahappenedNotEqualTo(String value) {
            addCriterion("ideaHappened <>", value, "ideahappened");
            return (Criteria) this;
        }

        public Criteria andIdeahappenedGreaterThan(String value) {
            addCriterion("ideaHappened >", value, "ideahappened");
            return (Criteria) this;
        }

        public Criteria andIdeahappenedGreaterThanOrEqualTo(String value) {
            addCriterion("ideaHappened >=", value, "ideahappened");
            return (Criteria) this;
        }

        public Criteria andIdeahappenedLessThan(String value) {
            addCriterion("ideaHappened <", value, "ideahappened");
            return (Criteria) this;
        }

        public Criteria andIdeahappenedLessThanOrEqualTo(String value) {
            addCriterion("ideaHappened <=", value, "ideahappened");
            return (Criteria) this;
        }

        public Criteria andIdeahappenedLike(String value) {
            addCriterion("ideaHappened like", value, "ideahappened");
            return (Criteria) this;
        }

        public Criteria andIdeahappenedNotLike(String value) {
            addCriterion("ideaHappened not like", value, "ideahappened");
            return (Criteria) this;
        }

        public Criteria andIdeahappenedIn(List<String> values) {
            addCriterion("ideaHappened in", values, "ideahappened");
            return (Criteria) this;
        }

        public Criteria andIdeahappenedNotIn(List<String> values) {
            addCriterion("ideaHappened not in", values, "ideahappened");
            return (Criteria) this;
        }

        public Criteria andIdeahappenedBetween(String value1, String value2) {
            addCriterion("ideaHappened between", value1, value2, "ideahappened");
            return (Criteria) this;
        }

        public Criteria andIdeahappenedNotBetween(String value1, String value2) {
            addCriterion("ideaHappened not between", value1, value2, "ideahappened");
            return (Criteria) this;
        }

        public Criteria andIdeatimeanddateIsNull() {
            addCriterion("ideaTimeAndDate is null");
            return (Criteria) this;
        }

        public Criteria andIdeatimeanddateIsNotNull() {
            addCriterion("ideaTimeAndDate is not null");
            return (Criteria) this;
        }

        public Criteria andIdeatimeanddateEqualTo(String value) {
            addCriterion("ideaTimeAndDate =", value, "ideatimeanddate");
            return (Criteria) this;
        }

        public Criteria andIdeatimeanddateNotEqualTo(String value) {
            addCriterion("ideaTimeAndDate <>", value, "ideatimeanddate");
            return (Criteria) this;
        }

        public Criteria andIdeatimeanddateGreaterThan(String value) {
            addCriterion("ideaTimeAndDate >", value, "ideatimeanddate");
            return (Criteria) this;
        }

        public Criteria andIdeatimeanddateGreaterThanOrEqualTo(String value) {
            addCriterion("ideaTimeAndDate >=", value, "ideatimeanddate");
            return (Criteria) this;
        }

        public Criteria andIdeatimeanddateLessThan(String value) {
            addCriterion("ideaTimeAndDate <", value, "ideatimeanddate");
            return (Criteria) this;
        }

        public Criteria andIdeatimeanddateLessThanOrEqualTo(String value) {
            addCriterion("ideaTimeAndDate <=", value, "ideatimeanddate");
            return (Criteria) this;
        }

        public Criteria andIdeatimeanddateLike(String value) {
            addCriterion("ideaTimeAndDate like", value, "ideatimeanddate");
            return (Criteria) this;
        }

        public Criteria andIdeatimeanddateNotLike(String value) {
            addCriterion("ideaTimeAndDate not like", value, "ideatimeanddate");
            return (Criteria) this;
        }

        public Criteria andIdeatimeanddateIn(List<String> values) {
            addCriterion("ideaTimeAndDate in", values, "ideatimeanddate");
            return (Criteria) this;
        }

        public Criteria andIdeatimeanddateNotIn(List<String> values) {
            addCriterion("ideaTimeAndDate not in", values, "ideatimeanddate");
            return (Criteria) this;
        }

        public Criteria andIdeatimeanddateBetween(String value1, String value2) {
            addCriterion("ideaTimeAndDate between", value1, value2, "ideatimeanddate");
            return (Criteria) this;
        }

        public Criteria andIdeatimeanddateNotBetween(String value1, String value2) {
            addCriterion("ideaTimeAndDate not between", value1, value2, "ideatimeanddate");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table idea
     *
     * @mbg.generated do_not_delete_during_merge Mon Jun 21 17:14:14 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table idea
     *
     * @mbg.generated Mon Jun 21 17:14:14 CST 2021
     */
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