package umn.mobile.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umn.mobile.model.Request;
import umn.mobile.model.RequestDetail;
import umn.mobile.model.RequestHeader;
import umn.mobile.service.RequestHeaderService;

import javax.validation.Valid;
import java.sql.Date;
import java.util.List;
import java.util.Set;

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

    //ShowAllRequestHeaderAndRequestDetail

    //CreateNewRequestHeader
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            produces = {"application/json"})
    public ResponseEntity<Request> createRequestHeader(@Valid @RequestBody Request request){
        request.requestHeader.setRequest_date(Date.valueOf(requestHeaderService.createDate()));
        request.requestHeader.setCounter(requestHeaderService.getCounter());
        request.requestHeader.setNumber(requestHeaderService.createNomorDokumen());
        requestHeaderService.saveRequestHeader(request.requestHeader, request.listRequestDetail);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    //UpdateExistingRequestHeader
    @PutMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<Request> updateRequestHeader(@Valid @RequestBody Request request,
                                                       @PathVariable("id") Long request_header_id){
        request.requestHeader.setRequest_header_id(request_header_id);
        requestHeaderService.saveRequestHeader(request.requestHeader, request.listRequestDetail);
        return new ResponseEntity<>(request, HttpStatus.CREATED);
    }

    //DeleteRequestHeaderById
    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    public void deleteRequestHeaderById(@PathVariable("id") Long request_header_id){
        requestHeaderService.deleteRequestHeader(request_header_id);
    }
}
