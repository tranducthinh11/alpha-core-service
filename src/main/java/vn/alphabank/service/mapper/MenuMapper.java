package vn.alphabank.service.mapper;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import vn.alphabank.domain.SidebarMenu;
import vn.alphabank.service.dto.GrantFunctionDTO;
import vn.alphabank.service.dto.IconComponentDTO;
import vn.alphabank.service.dto.LinkPropsDTO;
import vn.alphabank.service.dto.MenuDTO;
import vn.alphabank.service.dto.StateDTO;
import vn.alphabank.service.dto.SubMenuDTO;

@Service
public class MenuMapper {

    public List<MenuDTO> menuToMenuDTOs(List<SidebarMenu> menus) {
        List<MenuDTO> lstMenuDTOs = new ArrayList<MenuDTO>();
        // get list children menu
        menus
            .stream()
            .filter(menu -> menu.getParentId() == null)
            .forEach(menu -> {
                MenuDTO dto = new MenuDTO();

                dto.setCode(menu.getCode());
                dto.setDescription(menu.getDescription());
                dto.setIcon(menu.getIcon());
                dto.setId(menu.getId());
                dto.setTitle(menu.getIsTitle());
                dto.setUrl(menu.getLink());
                dto.setName(menu.getName());
                dto.setOrderBy(menu.getOrderBy());
                dto.setParentId(menu.getParentId());
                dto.setStatus(menu.getStatus());
                dto.setIconComponent(new IconComponentDTO(menu.getIcon()));

                //function

                dto.setLinkProps(mapLinkProps(menu));

                lstMenuDTOs.add(dto);
            });

        lstMenuDTOs.forEach(element -> {
            List<SubMenuDTO> lstSubMenu = new ArrayList<SubMenuDTO>();
            //List<SubMenuDTO> sortlstSubMenu = new ArrayList<SubMenuDTO>();
            menus
                .stream()
                .filter(subMenu -> (subMenu.getParentId() != null) && (subMenu.getParentId() == element.getId()))
                .findAny()
                .ifPresent(subMenu -> {
                    lstSubMenu.add(new SubMenuDTO(subMenu, mapLinkProps(subMenu)));
                });
            //sort list child menu
            List<SubMenuDTO> sortlstSubMenu = lstSubMenu
                .stream()
                .sorted(Comparator.comparingInt(SubMenuDTO::getOrderBy))
                .collect(Collectors.toList());
            element.setChildren(sortlstSubMenu);
        });
        //sort by Order by
        List<MenuDTO> lstMenuDTOFinal = lstMenuDTOs
            .stream()
            .sorted(Comparator.comparingInt(MenuDTO::getOrderBy))
            .collect(Collectors.toList());

        return lstMenuDTOFinal;
    }

    private LinkPropsDTO mapLinkProps(SidebarMenu menu) {
        LinkPropsDTO linkPropsDTO = new LinkPropsDTO();
        StateDTO stateDTO = new StateDTO();
        List<GrantFunctionDTO> lstGrantFunctionDTO = new ArrayList<GrantFunctionDTO>();
        menu
            .getListMenu()
            .forEach(f -> {
                GrantFunctionDTO grantFunctionDTO = new GrantFunctionDTO();
                grantFunctionDTO.setId(f.getId());
                grantFunctionDTO.setCode(f.getCode());
                grantFunctionDTO.setName(f.getName());
                lstGrantFunctionDTO.add(grantFunctionDTO);
            });
        stateDTO.setFunctions(lstGrantFunctionDTO);
        linkPropsDTO.setState(stateDTO);
        return linkPropsDTO;
    }
}
