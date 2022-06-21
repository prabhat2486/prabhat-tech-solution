package com.prabhattechtest.springboot;

import com.prabhattechtest.springboot.bto.TransactionProcessor;
import com.prabhattechtest.springboot.model.DailySummary;
import com.prabhattechtest.springboot.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
public class OutputController {

	@GetMapping("/dailySummary")
	public ResponseEntity output() {
		TransactionProcessor txnProcessor = new TransactionProcessor();
		try {
			ArrayList<DailySummary> dailySummary = txnProcessor.getDailySummary();
			return ResponseEntity.ok(dailySummary);
		} catch (IOException e) {
			return handleError(e);
		} catch (URISyntaxException e) {
			return handleError(e);
		}
	}

	private ResponseEntity handleError(Exception e){
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage(), e);
		return new ResponseEntity(errorResponse, errorResponse.getStatus());
	}


}
