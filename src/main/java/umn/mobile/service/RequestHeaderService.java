package umn.mobile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import umn.mobile.model.RequestHeader;
import umn.mobile.repository.RequestHeaderRepo;

import java.util.List;

@Service
public class RequestHeaderService {
    @Autowired
    private RequestHeaderRepo requestHeaderRepo;

    public RequestHeaderService(){}

    public RequestHeader saveRequestHeader(RequestHeader requestHeader){
        return requestHeaderRepo.save(requestHeader);
    }

    public RequestHeader getRequestHeaderById(Long request_header_id){
        return requestHeaderRepo.findOne(request_header_id);
    }

    public List<RequestHeader> getAllRequestHeader(){
        List listOfRequestHeader = requestHeaderRepo.findAll();
        return listOfRequestHeader;
    }

    public void deleteRequestHeader(Long request_header_id) {
        requestHeaderRepo.delete(request_header_id);
    }
}
