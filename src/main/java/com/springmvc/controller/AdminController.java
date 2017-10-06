package com.springmvc.controller;

import com.springmvc.co.PageRequestCO;
import com.springmvc.entity.CabRouteMapping;
import com.springmvc.entity.Newer;
import com.springmvc.enums.UserRole;
import com.springmvc.repositories.NewerRepository;
import com.springmvc.service.CabRouteMappingService;
import com.springmvc.service.RouteService;
import com.springmvc.vo.CostDataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Jitendra Singh.
 */
@Controller
@RequestMapping("/admin")
@Secured("ROLE_GOD")
public class AdminController {

    @Autowired
    private NewerRepository newerRepository;

    @Autowired
    private CabRouteMappingService cabRouteMappingService;

    @Autowired
    private RouteService routeService;

    @GetMapping("/list")
    public ModelAndView list(PageRequestCO pageRequest) {
        Pageable pageable = new PageRequest(pageRequest.getPageNumber(), pageRequest.getPageSize());
        List<Newer> list = newerRepository.findAllByUserRoleNot(UserRole.ROLE_GOD, pageable);
        return new ModelAndView("listNewer", "newers", list);
    }

    @PutMapping("/updateRole/{newerId}")
    public Boolean assign(@PathVariable("newerId") Integer newerId, UserRole role) {
        if (role != null && newerId != null) {
            Newer newer = newerRepository.findByNewerId(newerId);
            if(newer != null) {
                newer.setUserRole(role);
                newerRepository.save(newer);
                return true;
            }
        }
        return false;
    }

    @GetMapping("/getCostData/{monthId}")
    @ResponseBody
    public List<CostDataVO> getCostData(PageRequestCO pageRequest, @PathVariable("monthId") Integer monthId){
        Pageable pageable = new PageRequest(pageRequest.getPageNumber(), pageRequest.getPageSize());
        List<CabRouteMapping> list = cabRouteMappingService.retrieveCabRouteMappingsForMonth(monthId, pageable);
        List<CostDataVO> data = list.stream().map(obj->{
            CostDataVO vo = new CostDataVO();
            vo.setCabRouteMapping(obj);
            vo.setNumberOfCabbies(obj.getRoute().getCabbies().size());
            return vo;
        }).collect(Collectors.toList());
       // return new ModelAndView("costManagement", "results", data);
        return data;

    }
}
