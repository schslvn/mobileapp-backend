package umn.mobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umn.mobile.model.RequestDetail;
import umn.mobile.service.RequestDetailService;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api/requestdetail")
public class RequestDetailController {
    @Autowired
    private RequestDetailService requestDetailService;

    //ShowAllRequestDetail
    @GetMapping(value = "", produces = {"application/json"})
    public List<RequestDetail> showAllRequestDetail() {
        return requestDetailService.getAllRequestDetail();
    }

    //ShowRequestDetailById
    @GetMapping(value = "/{id}", produces = {"application/json"})
    public RequestDetail showRequestDetailById(@PathVariable("id") Long request_detail_id){
        RequestDetail requestDetailById = requestDetailService.getRequestDetailById(request_detail_id);
        return requestDetailById;
    }

    //ShowRequestDetailByRequestHeader
    @GetMapping(value = "rh/{id}", produces = {"application/json"})
    public Set<RequestDetail> showRequestDetailByRequestHeader(@PathVariable("id") Long request_header_id){
        Set<RequestDetail> requestDetailByRequestHeader = requestDetailService.getRequestDetailByRequestHeader(request_header_id);
        return requestDetailByRequestHeader;
    }

    //CreateNewRequestDetail
    @RequestMapping(value = "/detail",
            method = RequestMethod.POST,
            produces = {"application/json"})
    public ResponseEntity<RequestDetail> createRequestDetail(@RequestBody RequestDetail requestDetail){
        requestDetailService.saveRequestDetail(requestDetail);
        return new ResponseEntity<>(requestDetail, HttpStatus.CREATED);
    }

    //UpdateExistingRequestDetail
    @PutMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<RequestDetail> updateRequestDetail(@Valid @RequestBody RequestDetail requestDetail,
                                                             @PathVariable("id") Long request_detail_id){
        requestDetail.setRequest_detail_id(request_detail_id);
        requestDetailService.saveRequestDetail(requestDetail);
        return new ResponseEntity<>(requestDetail, HttpStatus.CREATED);
    }

    //DeleteRequestDetailById
    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    public void deleteRequestDetailById(@PathVariable("id") Long request_detail_id){
        requestDetailService.deleteRequestDetail(request_detail_id);
    }
}
