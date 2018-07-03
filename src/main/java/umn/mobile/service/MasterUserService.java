package umn.mobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umn.mobile.model.MasterUser;
import umn.mobile.repository.MasterUserRepo;

import java.util.List;

@Service
public class MasterUserService {
    @Autowired
    private MasterUserRepo masterUserRepo;

    public MasterUserService() {
    }

    public MasterUser getMasterUserById(Long user_id) {
        return masterUserRepo.findOne(user_id);
    }

    public List<MasterUser> getAllMasterUser() {
        List listOfMasterUser = masterUserRepo.findAll();
        return listOfMasterUser;
    }

    public Boolean userVerification(String username, String password) {
        if (masterUserRepo.numberOfMasterUsers(username, password) > 0)
            return true;
        else return false;
    }
}
