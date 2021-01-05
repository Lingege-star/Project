package com.example.day15.map.model.bean;

import java.util.List;

public class XuanBean {

    /**
     * code : 200
     * message : 成功
     * data : [[{"sort_id":4,"parent_id":0,"sort_name":"基金从业资格考试","school_id":1,"short_name":"基金从业","school_name":"金融学院"},{"sort_id":3,"parent_id":0,"sort_name":"银行从业资格考试","school_id":1,"short_name":"银行从业","school_name":"金融学院"},{"sort_id":2,"parent_id":0,"sort_name":"期货从业资格考试","school_id":1,"short_name":"期货从业","school_name":"金融学院"},{"sort_id":1,"parent_id":0,"sort_name":"证券从业资格考试","school_id":1,"short_name":"证券从业","school_name":"金融学院"}],[{"sort_id":53,"parent_id":0,"sort_name":"注册会计师","school_id":2,"short_name":"注册会计师","school_name":"财会学院"},{"sort_id":36,"parent_id":0,"sort_name":"会计职称","school_id":2,"short_name":"会计职称","school_name":"财会学院"},{"sort_id":33,"parent_id":0,"sort_name":"经济师考试","school_id":2,"short_name":"经济师考试","school_name":"财会学院"}],[{"sort_id":48,"parent_id":0,"sort_name":"CMA","school_id":3,"short_name":"CMA","school_name":"国际证书"}],[{"sort_id":63,"parent_id":0,"sort_name":"教师资格考试","school_id":4,"short_name":"教师资格","school_name":"职业资格"}],[{"sort_id":79,"parent_id":0,"sort_name":"建造师","school_id":5,"short_name":"建造师","school_name":"建筑工程"}]]
     */

    private String code;
    private String message;
    private List<List<DataBean>> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<List<DataBean>> getData() {
        return data;
    }

    public void setData(List<List<DataBean>> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * sort_id : 4
         * parent_id : 0
         * sort_name : 基金从业资格考试
         * school_id : 1
         * short_name : 基金从业
         * school_name : 金融学院
         */

        private int sort_id;
        private int parent_id;
        private String sort_name;
        private int school_id;
        private String short_name;
        private String school_name;

        public int getSort_id() {
            return sort_id;
        }

        public void setSort_id(int sort_id) {
            this.sort_id = sort_id;
        }

        public int getParent_id() {
            return parent_id;
        }

        public void setParent_id(int parent_id) {
            this.parent_id = parent_id;
        }

        public String getSort_name() {
            return sort_name;
        }

        public void setSort_name(String sort_name) {
            this.sort_name = sort_name;
        }

        public int getSchool_id() {
            return school_id;
        }

        public void setSchool_id(int school_id) {
            this.school_id = school_id;
        }

        public String getShort_name() {
            return short_name;
        }

        public void setShort_name(String short_name) {
            this.short_name = short_name;
        }

        public String getSchool_name() {
            return school_name;
        }

        public void setSchool_name(String school_name) {
            this.school_name = school_name;
        }
    }
}
