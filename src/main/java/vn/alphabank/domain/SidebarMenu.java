package vn.alphabank.domain;

import java.io.Serializable;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@org.springframework.data.mongodb.core.mapping.Document(collection = "sidebar_menu")
public class SidebarMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @Field("code")
    private String code;

    @Field("icon")
    private String icon;

    @Field("link")
    private String link;

    @Field("name")
    private String name;

    @Field("status")
    private Integer status;

    @Field("orderBy")
    private Integer orderBy;

    @Field("parentId")
    private Integer parentId;

    @Field("isTitle")
    private Boolean isTitle;

    @Field("description")
    private String description;

    private List<MenuFunction> listMenu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Boolean getIsTitle() {
        return isTitle;
    }

    public void setIsTitle(Boolean isTitle) {
        this.isTitle = isTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MenuFunction> getListMenu() {
        return listMenu;
    }

    public void setListMenu(List<MenuFunction> listMenu) {
        this.listMenu = listMenu;
    }
}
