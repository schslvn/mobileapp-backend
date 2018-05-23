package umn.mobile.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


public class Request {
    public RequestHeader requestHeader;
    public List<RequestDetail> listRequestDetail;
}
