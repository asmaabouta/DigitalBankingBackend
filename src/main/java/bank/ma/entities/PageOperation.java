package bank.ma.entities;

import java.util.List;

import lombok.Data;
@Data
public class PageOperation {

	private List<Operation> operations;
	private int page;
	private int nombreOperations;
	private int totalOperations;
	private int totalPages;
}
