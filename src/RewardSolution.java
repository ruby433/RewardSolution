import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class RewardSolution {
	
	public int rewardCal(int cost) {
		int rewardPoint=0;
		if(cost>50 && cost < 100) {
			rewardPoint = (cost-50);
			
		}else if(cost > 100) {
			rewardPoint = 50+2*(cost-100);
			
		}
		return rewardPoint;
	}
	
	public int rewardCalPerMonth(int numberOfMonth) {
		LocalDate date = LocalDate.now();
		LocalDate OldDate = LocalDate.now().minusMonths(-numberOfMonth);
		int rewardPoint = 0;
		
		
		List<Transaction> customersRewardPointBetween3Month = TRANSACTION_DATA
				  .stream()
				  .filter(data -> data.getTransationDate().compareTo(OldDate) < 0)
				  .collect(Collectors.toList());
		rewardPoint = calculateTransaction(customersRewardPointBetween3Month);
		return rewardPoint;
		
	}
	
	private int calculateTransaction(List<Transaction> customersRewardPointBetween3Month) {
		int rewardSumFor3Month = 0;
		for (Transaction transaction : customersRewardPointBetween3Month) {
			rewardSumFor3Month = rewardSumFor3Month+rewardCal(transaction.getCost());
		}
		return rewardSumFor3Month;
	}

	public static List<Transaction> TRANSACTION_DATA = getTransactionData();
	private static List<Transaction> getTransactionData() {
		List<Transaction> data = new ArrayList<>();
		data.add(new Transaction(1, 185, LocalDate.now().minusDays(-1)));
		data.add(new Transaction(2, 685, LocalDate.now().minusDays(-10)));
		data.add(new Transaction(3, 785, LocalDate.now().minusDays(-12)));
		data.add(new Transaction(4, 285, LocalDate.now().minusDays(-13)));
		data.add(new Transaction(5, 18, LocalDate.now().minusDays(-15)));
		data.add(new Transaction(6, 183, LocalDate.now().minusDays(-16)));
		data.add(new Transaction(7, 145, LocalDate.now().minusDays(-18)));
		data.add(new Transaction(8, 200, LocalDate.now().minusDays(-20)));
		data.add(new Transaction(9, 500, LocalDate.now().minusDays(-21)));
		data.add(new Transaction(10, 600, LocalDate.now().minusDays(-50)));
		data.add(new Transaction(11, 700, LocalDate.now().minusDays(-60)));
		data.add(new Transaction(12, 120, LocalDate.now().minusDays(-61)));
		data.add(new Transaction(13, 120, LocalDate.now().minusDays(-180)));


		return data;
	}
	
	public static void main(String[] args) {
		int reward = 0;
		
		reward = new RewardSolution().rewardCalPerMonth(3);
		System.out.println(reward);
	}

}

class Transaction{
	private int transationId;
	private int cost;
	private LocalDate transationDate;
	
	public Transaction(int transaction, int cost, LocalDate trDate) {
		this.transationId=transaction;
		this.cost=cost;
		this.transationDate = trDate;			
	}
			
	
	public int getTransationId() {
		return transationId;
	}
	public void setTransationId(int transationId) {
		this.transationId = transationId;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public LocalDate getTransationDate() {
		return transationDate;
	}
	public void setTransationDate(LocalDate transationDate) {
		this.transationDate = transationDate;
	}				
}
