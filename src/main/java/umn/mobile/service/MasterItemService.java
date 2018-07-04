package umn.mobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umn.mobile.model.MasterItem;
import umn.mobile.model.RequestHeader;
import umn.mobile.repository.MasterItemRepo;

import java.util.List;
import java.util.Set;

@Service
public class MasterItemService {
    @Autowired
    private MasterItemRepo masterItemRepo;

    public MasterItemService(){}

    public MasterItem saveMasterItem(MasterItem masterItem){
        return masterItemRepo.save(masterItem);
    }

    public MasterItem getMasterItemById(Long item_id){
        return masterItemRepo.findOne(item_id);
    }

    public List<MasterItem> getAllMasterItem(){
        List listOfMasterItem = masterItemRepo.findAll();
        return listOfMasterItem;
    }

    public List<MasterItem> searchMasterItem(String item_name){
        List<MasterItem> listOfMasterItem = masterItemRepo.searchMasterItem(item_name);
        return listOfMasterItem;
    }

    public void deleteMasterItem(Long item_id) {
        masterItemRepo.delete(item_id);
    }
}
