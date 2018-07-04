package umn.mobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import umn.mobile.model.MasterItem;
import umn.mobile.model.RequestHeader;
import umn.mobile.service.MasterItemService;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/masteritem")
public class MasterItemController {
    @Autowired
    private MasterItemService masterItemService;

    //ShowAllMasterItem
    @GetMapping(value = "", produces = {"application/json"})
    public List<MasterItem> showAllMasterItem() {
        return masterItemService.getAllMasterItem();
    }

    //ShowMasterItemById
    @GetMapping(value = "/{id}", produces = {"application/json"})
    public MasterItem showMasterItemById(@PathVariable("id") Long item_id){
        MasterItem masterItemById = masterItemService.getMasterItemById(item_id);
        return masterItemById;
    }

    //SearchMasterItem
    @GetMapping(value = "/search/{item_name}",
            produces = {"application/json"})
    public List<MasterItem> searchMasterItem(@PathVariable("item_name") String item_name){
        List<MasterItem> listOfMasterItem = masterItemService.searchMasterItem(item_name);
        return listOfMasterItem;
    }

    //CreateNewMasterItem
    @PostMapping(value = "", produces = {"application/json"})
    public ResponseEntity<MasterItem> createMasterItem(@RequestBody MasterItem masterItem){
        masterItemService.saveMasterItem(masterItem);
        return new ResponseEntity<>(masterItem, HttpStatus.CREATED);
    }

    //UpdateExistingMasterItem
    @PutMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<MasterItem> updateMasterItem(@Valid @RequestBody MasterItem masterItem,
                                                       @PathVariable("id") Long item_id){
        masterItem.setItem_id(item_id);
        masterItemService.saveMasterItem(masterItem);
        return new ResponseEntity<>(masterItem, HttpStatus.CREATED);
    }

    //DeleteMasterItemById
    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    public void deleteMasterItemById(@PathVariable("id") Long item_id){
        masterItemService.deleteMasterItem(item_id);
    }
}
