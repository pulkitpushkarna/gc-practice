package com.springmvc.controller;

import com.springmvc.co.CabCommand;
import com.springmvc.exceptions.BindingException;
import com.springmvc.service.CabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Created by diwakar on 05/10/17.
 */
@Controller
public class CabController {

    @Autowired
    private CabService cabService;

    @RequestMapping("/cab")
    public String listCabs(@RequestParam int offset, @RequestParam int limit, Model model) {
        cabService.listCabs(new PageRequest(offset, limit));
        return "";
    }

    @RequestMapping(value = "/cab/add", method = RequestMethod.GET)
    public String addCab() {
        return "addCab";
    }

    @RequestMapping(value = "/cab/add", method = RequestMethod.POST)
    @ResponseBody
    public boolean insertCab(@RequestBody CabCommand cabCommand, BindingResult bindingResult) throws BindingException{
        System.out.println();
        if(bindingResult.hasErrors()){
            throw new BindingException(bindingResult.getAllErrors());
        } else {
            cabService.insertCab(cabCommand);
            return true;
        }
    }

}
