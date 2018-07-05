package umn.mobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umn.mobile.model.Request;
import umn.mobile.model.RequestHeader;
import umn.mobile.service.RequestHeaderService;

import javax.validation.Valid;
import java.sql.Date;
import java.util.*;

@RestController
@RequestMapping(path = "/api/requestheader")
public class RequestHeaderController {
    @Autowired
    private RequestHeaderService requestHeaderService;

    //Show Date in String
    @GetMapping(value = "/date",
            produces = {"application/json"})
    public ResponseEntity<String> getDate(){
        String date = requestHeaderService.createDate();
        return new ResponseEntity<>(date,HttpStatus.CREATED);
    }

    //ShowAllRequestHeader
    @GetMapping(value = "", produces = {"application/json"})
    public List<RequestHeader> showAllRequestHeader() {
        return requestHeaderService.getAllRequestHeader();
    }

//    //ShowAllRequestHeaderAndDetail
//    @GetMapping(value = "", produces = {"application/json"})
//    public ResponseEntity<Request> get(Request request){
//
//    }

    //ShowRequestHeaderById
    @GetMapping(value = "/{id}", produces = {"application/json"})
    public RequestHeader showRequestHeaderById(@PathVariable("id") Long request_header_id){
        RequestHeader requestHeaderById = requestHeaderService.getRequestHeaderById(request_header_id);
        return requestHeaderById;
    }

    //ShowAllRequestHeaderByPendingStatus
    @GetMapping(value = "/status/all",
            produces = {"application/json"})
    public Set<RequestHeader> getAllRequestHeaderByPendingStatus(){
        Set<RequestHeader> listOfRequestHeader = requestHeaderService.getAllRequestHeaderByPendingStatus();
        return listOfRequestHeader;
    }

    //ShowAllRequestHeaderForGeneralManager
    @GetMapping(value = "/status/gm",
            produces = {"application/json"})
    public Set<RequestHeader> getAllRequestHeaderForGeneralManager(){
        Set<RequestHeader> listOfRequestHeader = requestHeaderService.getAllRequestHeaderForGeneralManager();
        return listOfRequestHeader;
    }

    //ShowAllRequestHeaderForFinancialController
    @GetMapping(value = "/status/fc",
            produces = {"application/json"})
    public Set<RequestHeader> getAllRequestHeaderForFinancialController(){
        Set<RequestHeader> listOfRequestHeader = requestHeaderService.getAllRequestHeaderForFinancialController();
        return listOfRequestHeader;
    }

    //ShowAllRequestHeaderForPurchasingManager
    @GetMapping(value = "/status/pm",
            produces = {"application/json"})
    public Set<RequestHeader> getAllRequestHeaderForPurchasingManager(){
        Set<RequestHeader> listOfRequestHeader = requestHeaderService.getAllRequestHeaderForPurchasingManager();
        return listOfRequestHeader;
    }

    //ShowAllRequestHeaderForDepartmentHead
    @GetMapping(value = "/status/dh",
            produces = {"application/json"})
    public Set<RequestHeader> getAllRequestHeaderForDepartmentHead(){
        Set<RequestHeader> listOfRequestHeader = requestHeaderService.getAllRequestHeaderForDepartmentHead();
        return listOfRequestHeader;
    }

    //CreateNewRequestHeader
    @PostMapping(value = "",
            produces = {"application/json"})
    public ResponseEntity<Request> createRequestHeader(@Valid @RequestBody Request request){
        request.requestHeader.setRequest_date(requestHeaderService.createDate());
        request.requestHeader.setCounter(requestHeaderService.getCounter());
        request.requestHeader.setNumber(requestHeaderService.createNomorDokumen());
        request.requestHeader.setApp_status1("PENDING");
        request.requestHeader.setApp_status2("PENDING");
        request.requestHeader.setApp_status3("PENDING");
        request.requestHeader.setApp_status4("PENDING");
        requestHeaderService.saveRequestHeader(request.requestHeader, request.listRequestDetail);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    //UpdateForDeptHead
    @PutMapping(value = "/{id}/dh/{status}", produces = {"application/json"})
    public void updateRequestHeaderDH(@PathVariable("id") Long request_header_id,
                                      @PathVariable("status") String app_status1){
        requestHeaderService.updateDepartmentHead(app_status1, request_header_id);
    }

    //UpdateForPurchMgr
    @PutMapping(value = "/{id}/pm/{status}", produces = {"application/json"})
    public void updateRequestHeaderPM(@PathVariable("id") Long request_header_id,
                                      @PathVariable("status") String app_status2){
        requestHeaderService.updatePurchasingManager(app_status2, request_header_id);
    }

    //UpdateForFinCont
    @PutMapping(value = "/{id}/fc/{status}", produces = {"application/json"})
    public void updateRequestHeaderFC(@PathVariable("id") Long request_header_id,
                                      @PathVariable("status") String app_status3){
        requestHeaderService.updateFinancialController(app_status3, request_header_id);
    }

    //UpdateForGenMgr
    @PutMapping(value = "/{id}/gm/{status}", produces = {"application/json"})
    public void updateRequestHeader(@PathVariable("id") Long request_header_id,
                                    @PathVariable("status") String app_status4){
        requestHeaderService.updateGeneralManager(app_status4, request_header_id);
    }

    //DeleteRequestHeaderById
    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    public void deleteRequestHeaderById(@PathVariable("id") Long request_header_id){
        requestHeaderService.deleteRequestHeader(request_header_id);
    }
}
