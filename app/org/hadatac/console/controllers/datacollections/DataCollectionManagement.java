package org.hadatac.console.controllers.datacollections;

import org.hadatac.console.controllers.AuthApplication;
import org.hadatac.console.http.GetSparqlQuery;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hadatac.console.models.SparqlQuery;
import org.hadatac.console.models.SparqlQueryResults;

import play.mvc.Controller;
import play.mvc.Result;

import org.hadatac.console.views.html.hierarchy_browser;
import org.hadatac.console.views.html.error_page;
import org.hadatac.console.views.html.datacollections.*;
import org.hadatac.entity.pojo.DataCollection;
import org.hadatac.utils.State;


public class DataCollectionManagement extends Controller {

	// for /metadata HTTP GET requests
    public static Result index(int stateId) {

    	State state = new State(stateId);
    	
    	List<DataCollection> theResults = DataCollection.find(AuthApplication.getLocalUser(session()).uri, state);    		
    	
        return ok(dataCollectionManagement.render(state, theResults));
        
    }// /index()


    // for /metadata HTTP POST requests
    public static Result postIndex(int stateId) {

    	State state = new State(stateId);
    	
    	List<DataCollection> theResults = DataCollection.find(AuthApplication.getLocalUser(session()).uri, state);    		
    	
        return ok(dataCollectionManagement.render(state, theResults));
        
    }// /postIndex()

}