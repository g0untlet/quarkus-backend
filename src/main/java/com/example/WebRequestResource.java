package com.example;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/requests")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
public class WebRequestResource {

    /**
     * Retrieves all WebRequest records from the database, sorted by the most recent.
     * @return A list of all WebRequest entities.
     */
    @GET
    public List<WebRequest> getAllRequests() {
        return WebRequest.listAll();
    }

    /**
     * Creates a new WebRequest record.
     * The User-Agent is automatically extracted from the request headers.
     * @param userAgent The "User-Agent" header from the HTTP request.
     * @return The newly created WebRequest entity with a 201 (Created) status.
     */
    @POST
    @Transactional
    public Response createRequest(@HeaderParam("User-Agent") String userAgent) {
        WebRequest newRequest = new WebRequest(userAgent);
        newRequest.persist();
        return Response.status(Response.Status.CREATED).entity(newRequest).build();
    }
}
