package com.bilibala.manage.dao.model;

public class SysUrl {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_url.ID
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_url.URL
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_url.NAME
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_url.LOG_FLAG
     *
     * @mbggenerated
     */
    private Integer logFlag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_url.ID
     *
     * @return the value of sys_url.ID
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_url.ID
     *
     * @param id the value for sys_url.ID
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_url.URL
     *
     * @return the value of sys_url.URL
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_url.URL
     *
     * @param url the value for sys_url.URL
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_url.NAME
     *
     * @return the value of sys_url.NAME
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_url.NAME
     *
     * @param name the value for sys_url.NAME
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_url.LOG_FLAG
     *
     * @return the value of sys_url.LOG_FLAG
     *
     * @mbggenerated
     */
    public Integer getLogFlag() {
        return logFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_url.LOG_FLAG
     *
     * @param logFlag the value for sys_url.LOG_FLAG
     *
     * @mbggenerated
     */
    public void setLogFlag(Integer logFlag) {
        this.logFlag = logFlag;
    }
}