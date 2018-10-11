/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

import org.json.JSONObject;

import javax.ws.rs.core.Response;

/**
 * @author rafae
 */
public class ExceptionUtil {
    public static Response errorToResponse(Exception e) {
        JSONObject response = new JSONObject();
        response.put("error", e.getLocalizedMessage());
        return Response.status(Response.Status.BAD_REQUEST).entity(response.toString()).build();
    }
}
