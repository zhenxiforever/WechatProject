package com.bilibala.manage.dao.model;

public class WxModule {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_module.MODULEID
     *
     * @mbggenerated
     */
    private String moduleid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_module.MODULENAME
     *
     * @mbggenerated
     */
    private String modulename;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_module.MODULEPATH
     *
     * @mbggenerated
     */
    private String modulepath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column wx_module.MODULEFLAG
     *
     * @mbggenerated
     */
    private Integer moduleflag;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_module.MODULEID
     *
     * @return the value of wx_module.MODULEID
     *
     * @mbggenerated
     */
    public String getModuleid() {
        return moduleid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_module.MODULEID
     *
     * @param moduleid the value for wx_module.MODULEID
     *
     * @mbggenerated
     */
    public void setModuleid(String moduleid) {
        this.moduleid = moduleid == null ? null : moduleid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_module.MODULENAME
     *
     * @return the value of wx_module.MODULENAME
     *
     * @mbggenerated
     */
    public String getModulename() {
        return modulename;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_module.MODULENAME
     *
     * @param modulename the value for wx_module.MODULENAME
     *
     * @mbggenerated
     */
    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_module.MODULEPATH
     *
     * @return the value of wx_module.MODULEPATH
     *
     * @mbggenerated
     */
    public String getModulepath() {
        return modulepath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_module.MODULEPATH
     *
     * @param modulepath the value for wx_module.MODULEPATH
     *
     * @mbggenerated
     */
    public void setModulepath(String modulepath) {
        this.modulepath = modulepath == null ? null : modulepath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column wx_module.MODULEFLAG
     *
     * @return the value of wx_module.MODULEFLAG
     *
     * @mbggenerated
     */
    public Integer getModuleflag() {
        return moduleflag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column wx_module.MODULEFLAG
     *
     * @param moduleflag the value for wx_module.MODULEFLAG
     *
     * @mbggenerated
     */
    public void setModuleflag(Integer moduleflag) {
        this.moduleflag = moduleflag;
    }
}