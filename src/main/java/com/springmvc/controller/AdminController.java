package com.springmvc.controller;

import com.springmvc.co.PageRequestCO;
import com.springmvc.entity.CabRouteMapping;
import com.springmvc.entity.MonthlyExpenditure;
import com.springmvc.entity.Newer;
import com.springmvc.entity.ZonePrice;
import com.springmvc.enums.UserRole;
import com.springmvc.repositories.MonthlyExpenditureRepository;
import com.springmvc.repositories.NewerRepository;
import com.springmvc.repositories.ZonePriceRepository;
import com.springmvc.repositories.ZoneRepository;
import com.springmvc.service.CabRouteMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.Month;
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
    private ZonePriceRepository zonePriceRepository;

    @Autowired
    private MonthlyExpenditureRepository monthlyExpenditureRepository;


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

    @GetMapping("/getCostData/{year}/{month}")
    @ResponseBody
    public List<MonthlyExpenditure> getCostData(@PathVariable("year") int year, @PathVariable("month") int month, PageRequestCO pageRequestCO){
        Pageable pageable = new PageRequest(pageRequestCO.getPageNumber(), pageRequestCO.getPageSize());
        List<CabRouteMapping> list = cabRouteMappingService.getCabRouteMappingDataForMonth(year, month, pageable);


        return list.stream().map(obj->{
            MonthlyExpenditure me = new MonthlyExpenditure();
            me.setCabRouteMapping(obj);
            ZonePrice zonePrice = zonePriceRepository.findByZoneAndCabType(obj.getRoute().getZone(), obj.getCab().getCabType());
            me.setAmountSpend(zonePrice.getCost());
            me.setAmountRecieved(obj.getRoute().getNewerRouteMapping().size()*2200);
            me.setMonth(Month.of(obj.getModificationTime().getMonth()));
            monthlyExpenditureRepository.save(me);

            return me;

        }).collect(Collectors.toList());

    }

}
