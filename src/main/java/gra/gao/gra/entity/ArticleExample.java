package gra.gao.gra.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArticleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ArticleExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGmt_createdIsNull() {
            addCriterion("gmt_created is null");
            return (Criteria) this;
        }

        public Criteria andGmt_createdIsNotNull() {
            addCriterion("gmt_created is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_createdEqualTo(Date value) {
            addCriterion("gmt_created =", value, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdNotEqualTo(Date value) {
            addCriterion("gmt_created <>", value, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdGreaterThan(Date value) {
            addCriterion("gmt_created >", value, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_created >=", value, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdLessThan(Date value) {
            addCriterion("gmt_created <", value, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdLessThanOrEqualTo(Date value) {
            addCriterion("gmt_created <=", value, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdIn(List<Date> values) {
            addCriterion("gmt_created in", values, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdNotIn(List<Date> values) {
            addCriterion("gmt_created not in", values, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdBetween(Date value1, Date value2) {
            addCriterion("gmt_created between", value1, value2, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_createdNotBetween(Date value1, Date value2) {
            addCriterion("gmt_created not between", value1, value2, "gmt_created");
            return (Criteria) this;
        }

        public Criteria andGmt_updatedIsNull() {
            addCriterion("gmt_updated is null");
            return (Criteria) this;
        }

        public Criteria andGmt_updatedIsNotNull() {
            addCriterion("gmt_updated is not null");
            return (Criteria) this;
        }

        public Criteria andGmt_updatedEqualTo(Date value) {
            addCriterion("gmt_updated =", value, "gmt_updated");
            return (Criteria) this;
        }

        public Criteria andGmt_updatedNotEqualTo(Date value) {
            addCriterion("gmt_updated <>", value, "gmt_updated");
            return (Criteria) this;
        }

        public Criteria andGmt_updatedGreaterThan(Date value) {
            addCriterion("gmt_updated >", value, "gmt_updated");
            return (Criteria) this;
        }

        public Criteria andGmt_updatedGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_updated >=", value, "gmt_updated");
            return (Criteria) this;
        }

        public Criteria andGmt_updatedLessThan(Date value) {
            addCriterion("gmt_updated <", value, "gmt_updated");
            return (Criteria) this;
        }

        public Criteria andGmt_updatedLessThanOrEqualTo(Date value) {
            addCriterion("gmt_updated <=", value, "gmt_updated");
            return (Criteria) this;
        }

        public Criteria andGmt_updatedIn(List<Date> values) {
            addCriterion("gmt_updated in", values, "gmt_updated");
            return (Criteria) this;
        }

        public Criteria andGmt_updatedNotIn(List<Date> values) {
            addCriterion("gmt_updated not in", values, "gmt_updated");
            return (Criteria) this;
        }

        public Criteria andGmt_updatedBetween(Date value1, Date value2) {
            addCriterion("gmt_updated between", value1, value2, "gmt_updated");
            return (Criteria) this;
        }

        public Criteria andGmt_updatedNotBetween(Date value1, Date value2) {
            addCriterion("gmt_updated not between", value1, value2, "gmt_updated");
            return (Criteria) this;
        }

        public Criteria andTittleIsNull() {
            addCriterion("tittle is null");
            return (Criteria) this;
        }

        public Criteria andTittleIsNotNull() {
            addCriterion("tittle is not null");
            return (Criteria) this;
        }

        public Criteria andTittleEqualTo(String value) {
            addCriterion("tittle =", value, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleNotEqualTo(String value) {
            addCriterion("tittle <>", value, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleGreaterThan(String value) {
            addCriterion("tittle >", value, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleGreaterThanOrEqualTo(String value) {
            addCriterion("tittle >=", value, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleLessThan(String value) {
            addCriterion("tittle <", value, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleLessThanOrEqualTo(String value) {
            addCriterion("tittle <=", value, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleLike(String value) {
            addCriterion("tittle like", value, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleNotLike(String value) {
            addCriterion("tittle not like", value, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleIn(List<String> values) {
            addCriterion("tittle in", values, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleNotIn(List<String> values) {
            addCriterion("tittle not in", values, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleBetween(String value1, String value2) {
            addCriterion("tittle between", value1, value2, "tittle");
            return (Criteria) this;
        }

        public Criteria andTittleNotBetween(String value1, String value2) {
            addCriterion("tittle not between", value1, value2, "tittle");
            return (Criteria) this;
        }

        public Criteria andG_typeIsNull() {
            addCriterion("g_type is null");
            return (Criteria) this;
        }

        public Criteria andG_typeIsNotNull() {
            addCriterion("g_type is not null");
            return (Criteria) this;
        }

        public Criteria andG_typeEqualTo(String value) {
            addCriterion("g_type =", value, "g_type");
            return (Criteria) this;
        }

        public Criteria andG_typeNotEqualTo(String value) {
            addCriterion("g_type <>", value, "g_type");
            return (Criteria) this;
        }

        public Criteria andG_typeGreaterThan(String value) {
            addCriterion("g_type >", value, "g_type");
            return (Criteria) this;
        }

        public Criteria andG_typeGreaterThanOrEqualTo(String value) {
            addCriterion("g_type >=", value, "g_type");
            return (Criteria) this;
        }

        public Criteria andG_typeLessThan(String value) {
            addCriterion("g_type <", value, "g_type");
            return (Criteria) this;
        }

        public Criteria andG_typeLessThanOrEqualTo(String value) {
            addCriterion("g_type <=", value, "g_type");
            return (Criteria) this;
        }

        public Criteria andG_typeLike(String value) {
            addCriterion("g_type like", value, "g_type");
            return (Criteria) this;
        }

        public Criteria andG_typeNotLike(String value) {
            addCriterion("g_type not like", value, "g_type");
            return (Criteria) this;
        }

        public Criteria andG_typeIn(List<String> values) {
            addCriterion("g_type in", values, "g_type");
            return (Criteria) this;
        }

        public Criteria andG_typeNotIn(List<String> values) {
            addCriterion("g_type not in", values, "g_type");
            return (Criteria) this;
        }

        public Criteria andG_typeBetween(String value1, String value2) {
            addCriterion("g_type between", value1, value2, "g_type");
            return (Criteria) this;
        }

        public Criteria andG_typeNotBetween(String value1, String value2) {
            addCriterion("g_type not between", value1, value2, "g_type");
            return (Criteria) this;
        }

        public Criteria andTagIsNull() {
            addCriterion("tag is null");
            return (Criteria) this;
        }

        public Criteria andTagIsNotNull() {
            addCriterion("tag is not null");
            return (Criteria) this;
        }

        public Criteria andTagEqualTo(String value) {
            addCriterion("tag =", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotEqualTo(String value) {
            addCriterion("tag <>", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThan(String value) {
            addCriterion("tag >", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagGreaterThanOrEqualTo(String value) {
            addCriterion("tag >=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThan(String value) {
            addCriterion("tag <", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLessThanOrEqualTo(String value) {
            addCriterion("tag <=", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagLike(String value) {
            addCriterion("tag like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotLike(String value) {
            addCriterion("tag not like", value, "tag");
            return (Criteria) this;
        }

        public Criteria andTagIn(List<String> values) {
            addCriterion("tag in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotIn(List<String> values) {
            addCriterion("tag not in", values, "tag");
            return (Criteria) this;
        }

        public Criteria andTagBetween(String value1, String value2) {
            addCriterion("tag between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andTagNotBetween(String value1, String value2) {
            addCriterion("tag not between", value1, value2, "tag");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Boolean value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Boolean value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Boolean value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Boolean value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Boolean> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Boolean> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
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