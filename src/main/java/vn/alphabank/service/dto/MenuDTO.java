package vn.alphabank.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

public class MenuDTO {

    private Integer id;
    private String code;
    private String icon;
    private String url;
    private String name;
    private Integer status;
    private Integer orderBy;
    private Integer parentId;
    private Boolean title;
    private String description;
    private IconComponentDTO iconComponent;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<SubMenuDTO> children;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LinkPropsDTO linkProps;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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

    public Boolean getTitle() {
        return title;
    }

    public void setTitle(Boolean title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SubMenuDTO> getChildren() {
        return children;
    }

    public void setChildren(List<SubMenuDTO> children) {
        this.children = children;
    }

    public IconComponentDTO getIconComponent() {
        return iconComponent;
    }

    public void setIconComponent(IconComponentDTO iconComponent) {
        this.iconComponent = iconComponent;
    }

    public LinkPropsDTO getLinkProps() {
        return linkProps;
    }

    public void setLinkProps(LinkPropsDTO linkProps) {
        this.linkProps = linkProps;
    }
}
