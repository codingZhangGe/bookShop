package com.qunar.qauction.model.admin;

/**
 * @author yunfeng.yang created on 16-4-15
 * @version 1.0
 */
public class Administrator {
    /**
     * 主键id
     */
    private long id;
    /**
     * administrator qtalk
     */
    private String administratorQtalk;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAdministratorQtalk() {
        return administratorQtalk;
    }

    public void setAdministratorQtalk(String administratorQtalk) {
        this.administratorQtalk = administratorQtalk;
    }
}
