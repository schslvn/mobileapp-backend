package umn.mobile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
    public ResponseEntity<RequestHeader> createRequestHeader(@RequestBody RequestHeader requestHeader){
        requestHeaderService.saveRequestHeader(requestHeader);
        return new ResponseEntity<>(requestHeader, HttpStatus.CREATED);
    }

    //UpdateExistingRequestHeader
    @PutMapping(value = "/{id}", produces = {"application/json"})
    public ResponseEntity<RequestHeader> updateRequestHeader(@Valid @RequestBody RequestHeader requestHeader,
                                                       @PathVariable("id") Long request_header_id){
        requestHeader.setRequest_header_id(request_header_id);
        requestHeaderService.saveRequestHeader(requestHeader);
        return new ResponseEntity<>(requestHeader, HttpStatus.CREATED);
    }

    //DeleteRequestHeaderById
    @DeleteMapping(value = "/{id}", produces = {"application/json"})
    public void deleteRequestHeaderById(@PathVariable("id") Long request_header_id){
        requestHeaderService.deleteRequestHeader(request_header_id);
    }
}
