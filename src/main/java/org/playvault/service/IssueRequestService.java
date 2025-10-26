package org.playvault.service;

import org.playvault.entity.IssuedRequest;
import org.playvault.entity.RequestStatus;

import java.util.List;

public interface IssueRequestService {
    IssuedRequest createIssueRequestService(IssueRequestService issueRequestService);

    IssuedRequest approveIssueRequestService(Long issueRequestId);

    IssuedRequest rejectIssueRequestService(Long issueRequestId);

    IssuedRequest markReturned(Long issueRequestId);

    List<IssueRequestService> getIssueRequestByUserId(Long userId);

    List<IssueRequestService> getRequestByStatus(RequestStatus status);
}
