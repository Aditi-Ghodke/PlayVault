package org.playvault.dao;

import org.playvault.entity.IssuedRequest;
import org.playvault.entity.RequestStatus;
import org.playvault.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueRequestDao extends JpaRepository<IssuedRequest, Long> {
    //Get all requests by user
    List<IssuedRequest> findByUser(User user);

    //Get all requests by status
    List<IssuedRequest> findByStatus(RequestStatus status);

}