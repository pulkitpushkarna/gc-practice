package com.springmvc.controller;

import com.springmvc.co.PageRequestCO;
import com.springmvc.entity.CabRouteMapping;
import com.springmvc.entity.MonthlyExpenditure;
import com.springmvc.entity.ZonePrice;
import com.springmvc.repositories.ZonePriceRepository;
import com.springmvc.service.CabRouteMappingService;
import com.springmvc.service.CostManagementService;
import com.springmvc.vo.MonthlyExpenditureVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CostManagementController {

    @Autowired
    private CostManagementService costManagementService;


    @RequestMapping("/costManagement")
    ModelAndView costManagement(){
        Pageable pageable = new PageRequest(0,10);

        Calendar calendar = Calendar.getInstance();
        List<MonthlyExpenditure> monthlyExpenditureList = costManagementService.getMonthlyExpenditures(calendar.get(Calendar.YEAR), 9 /*calendar.get(Calendar.MONTH)*/,pageable);
        MonthlyExpenditureVO monthlyExpenditureVO = new MonthlyExpenditureVO();
        monthlyExpenditureVO.setMonthlyExpenditureList(monthlyExpenditureList);
        monthlyExpenditureVO.setMonth(Month.of(9));
        monthlyExpenditureVO.setYear(Year.of(calendar.get(Calendar.YEAR)));
        //System.out.println("MonthlyExpenditure List " +  monthlyExpenditureList.size() + "   " + monthlyExpenditureList);
        ModelAndView modelAndView = new ModelAndView("costManagement","monthlyExpenditure", monthlyExpenditureVO);
        return modelAndView;
    }

    @RequestMapping("/costManagement/{year}/{month}")
    ModelAndView costManagement(@PathVariable("year") int year,@PathVariable("month") int month, PageRequestCO pageRequest){
        Pageable pageable = new PageRequest(pageRequest.getPageNumber(), pageRequest.getPageSize());

        Calendar calendar = Calendar.getInstance();
        List<MonthlyExpenditure> monthlyExpenditureList = costManagementService.getMonthlyExpenditures(year,month,pageable);
        MonthlyExpenditureVO monthlyExpenditureVO = new MonthlyExpenditureVO();
        monthlyExpenditureVO.setMonthlyExpenditureList(monthlyExpenditureList);
        monthlyExpenditureVO.setMonth(Month.of(month));
        monthlyExpenditureVO.setYear(Year.of(year));
        //System.out.println("MonthlyExpenditure List New One " +  monthlyExpenditureList.size() + "   " + monthlyExpenditureList);
        ModelAndView modelAndView = new ModelAndView("costManagement","monthlyExpenditure", monthlyExpenditureVO);
        return modelAndView;
    }
}
