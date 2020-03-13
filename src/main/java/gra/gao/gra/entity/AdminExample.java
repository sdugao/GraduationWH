package gra.gao.gra.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andUsernameIsNull() {
            addCriterion("username is null");
            return (Criteria) this;
        }

        public Criteria andUsernameIsNotNull() {
            addCriterion("username is not null");
            return (Criteria) this;
        }

        public Criteria andUsernameEqualTo(String value) {
            addCriterion("username =", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotEqualTo(String value) {
            addCriterion("username <>", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThan(String value) {
            addCriterion("username >", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("username >=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThan(String value) {
            addCriterion("username <", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLessThanOrEqualTo(String value) {
            addCriterion("username <=", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameLike(String value) {
            addCriterion("username like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotLike(String value) {
            addCriterion("username not like", value, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameIn(List<String> values) {
            addCriterion("username in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotIn(List<String> values) {
            addCriterion("username not in", values, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameBetween(String value1, String value2) {
            addCriterion("username between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andUsernameNotBetween(String value1, String value2) {
            addCriterion("username not between", value1, value2, "username");
            return (Criteria) this;
        }

        public Criteria andG_passwordIsNull() {
            addCriterion("g_password is null");
            return (Criteria) this;
        }

        public Criteria andG_passwordIsNotNull() {
            addCriterion("g_password is not null");
            return (Criteria) this;
        }

        public Criteria andG_passwordEqualTo(String value) {
            addCriterion("g_password =", value, "g_password");
            return (Criteria) this;
        }

        public Criteria andG_passwordNotEqualTo(String value) {
            addCriterion("g_password <>", value, "g_password");
            return (Criteria) this;
        }

        public Criteria andG_passwordGreaterThan(String value) {
            addCriterion("g_password >", value, "g_password");
            return (Criteria) this;
        }

        public Criteria andG_passwordGreaterThanOrEqualTo(String value) {
            addCriterion("g_password >=", value, "g_password");
            return (Criteria) this;
        }

        public Criteria andG_passwordLessThan(String value) {
            addCriterion("g_password <", value, "g_password");
            return (Criteria) this;
        }

        public Criteria andG_passwordLessThanOrEqualTo(String value) {
            addCriterion("g_password <=", value, "g_password");
            return (Criteria) this;
        }

        public Criteria andG_passwordLike(String value) {
            addCriterion("g_password like", value, "g_password");
            return (Criteria) this;
        }

        public Criteria andG_passwordNotLike(String value) {
            addCriterion("g_password not like", value, "g_password");
            return (Criteria) this;
        }

        public Criteria andG_passwordIn(List<String> values) {
            addCriterion("g_password in", values, "g_password");
            return (Criteria) this;
        }

        public Criteria andG_passwordNotIn(List<String> values) {
            addCriterion("g_password not in", values, "g_password");
            return (Criteria) this;
        }

        public Criteria andG_passwordBetween(String value1, String value2) {
            addCriterion("g_password between", value1, value2, "g_password");
            return (Criteria) this;
        }

        public Criteria andG_passwordNotBetween(String value1, String value2) {
            addCriterion("g_password not between", value1, value2, "g_password");
            return (Criteria) this;
        }

        public Criteria andG_uuidIsNull() {
            addCriterion("g_uuid is null");
            return (Criteria) this;
        }

        public Criteria andG_uuidIsNotNull() {
            addCriterion("g_uuid is not null");
            return (Criteria) this;
        }

        public Criteria andG_uuidEqualTo(String value) {
            addCriterion("g_uuid =", value, "g_uuid");
            return (Criteria) this;
        }

        public Criteria andG_uuidNotEqualTo(String value) {
            addCriterion("g_uuid <>", value, "g_uuid");
            return (Criteria) this;
        }

        public Criteria andG_uuidGreaterThan(String value) {
            addCriterion("g_uuid >", value, "g_uuid");
            return (Criteria) this;
        }

        public Criteria andG_uuidGreaterThanOrEqualTo(String value) {
            addCriterion("g_uuid >=", value, "g_uuid");
            return (Criteria) this;
        }

        public Criteria andG_uuidLessThan(String value) {
            addCriterion("g_uuid <", value, "g_uuid");
            return (Criteria) this;
        }

        public Criteria andG_uuidLessThanOrEqualTo(String value) {
            addCriterion("g_uuid <=", value, "g_uuid");
            return (Criteria) this;
        }

        public Criteria andG_uuidLike(String value) {
            addCriterion("g_uuid like", value, "g_uuid");
            return (Criteria) this;
        }

        public Criteria andG_uuidNotLike(String value) {
            addCriterion("g_uuid not like", value, "g_uuid");
            return (Criteria) this;
        }

        public Criteria andG_uuidIn(List<String> values) {
            addCriterion("g_uuid in", values, "g_uuid");
            return (Criteria) this;
        }

        public Criteria andG_uuidNotIn(List<String> values) {
            addCriterion("g_uuid not in", values, "g_uuid");
            return (Criteria) this;
        }

        public Criteria andG_uuidBetween(String value1, String value2) {
            addCriterion("g_uuid between", value1, value2, "g_uuid");
            return (Criteria) this;
        }

        public Criteria andG_uuidNotBetween(String value1, String value2) {
            addCriterion("g_uuid not between", value1, value2, "g_uuid");
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