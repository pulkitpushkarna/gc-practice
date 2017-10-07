package com.springmvc.controller;

import com.springmvc.co.PageRequestCO;
import com.springmvc.entity.Newer;
import com.springmvc.enums.UserRole;
import com.springmvc.repositories.NewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author Jitendra Singh.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private NewerRepository newerRepository;

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
}
