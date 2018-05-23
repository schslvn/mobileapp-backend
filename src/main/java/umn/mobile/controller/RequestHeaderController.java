package umn.mobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import umn.mobile.model.Request;
import umn.mobile.model.RequestDetail;
import umn.mobile.model.RequestHeader;
import umn.mobile.service.RequestHeaderService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/api/requestheader")
public class RequestHeaderController {
    @Autowired
    private RequestHeaderService requestHeaderService;

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

    //CreateNewRequestHeader
    @RequestMapping(value = "",
            method = RequestMethod.POST,
            produces = {"application/json"})
    public ResponseEntity<Request> createRequestHeader(@RequestBody Request request){
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
