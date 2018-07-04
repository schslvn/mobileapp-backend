package umn.mobile.controller;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import umn.mobile.model.MasterUser;
import umn.mobile.service.MasterUserService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/masteruser")
public class MasterUserController {
    @Autowired
    private MasterUserService masterUserService;

    //ShowAllMasterUser
    @GetMapping(value = "", produces = {"application/json"})
    public List<MasterUser> showAllMasterUser() {
        return masterUserService.getAllMasterUser();
    }

    //ShowMasterUserById
    @GetMapping(value = "/{id}", produces = {"application/json"})
    public MasterUser showMasterUserById(@PathVariable("id") Long user_id){
        MasterUser masterUserById = masterUserService.getMasterUserById(user_id);
        return masterUserById;
    }

    //Login Check
    @RequestMapping(value = "/{username}/{password}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    public Set<MasterUser> loginVerification(@PathVariable("username") String username,
                                             @PathVariable("password") String password){
        Set<MasterUser> verified = masterUserService.userVerification(username,password);
        return verified;
    }
}
