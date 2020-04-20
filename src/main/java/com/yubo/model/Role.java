package com.yubo.model;

import java.io.Serializable;

/**
 * @author yubo
 * @version V1.0
 * @description 角色
 * @date 2020/3/30 11:43
 */
public class Role implements Serializable {
    private static final long serialVersionUID = 71638947764677480L;
    private Long id;

    private String roleName;

    private String note;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Role{");
        sb.append("id=").append(id);
        sb.append(", roleName='").append(roleName).append('\'');
        sb.append(", note='").append(note).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

