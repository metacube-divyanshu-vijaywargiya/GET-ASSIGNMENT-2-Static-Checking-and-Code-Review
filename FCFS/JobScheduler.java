package com.metacube;
public class JobScheduler {
	
	//calculating completion of each process
	public int[] calculateCompletionTime(int [][] processes) {
		int numberOfProcess = processes.length;
		int [] completionTime = new int[numberOfProcess];
		int currentTime =0;
		
		for( int i =0; i<numberOfProcess; i++ ) {
			int arrivalTime = processes[i][0];
			int burstTime = processes[i][1];

			if(currentTime < arrivalTime) {
				currentTime = arrivalTime;
			}
			
			currentTime += burstTime;
			completionTime[i] = currentTime;
		}
		
		return completionTime;
	}
	
	
	//calculating turn around time 
	public int[] calculateTurnAroundTime(int [][] processes, int completionTime[]) {
		int numberOfProcess = processes.length;

		int[] turnAroundTime = new int[numberOfProcess];
		
		for( int i=0; i<numberOfProcess; i++ ) {
			turnAroundTime[i] = completionTime[i] - processes[i][0];
		}
		
		return turnAroundTime;
	}

	//calculating waiting time 
	public int[] calculateWaitingTime(int[][] processes, int[] turnAroundTime) {
		int numberOfProcess = processes.length;
		int []waitingTime = new int[numberOfProcess];
		
		for(int i=0;i<numberOfProcess;i++) {
			waitingTime[i] = turnAroundTime[i] - processes[i][1];
		}
		
		return waitingTime;
	}
	
	//calculating average waiting time
	public double calculateAvgWaitingTime(int[] waitingTime) {
		int totalWaitingTime = 0;
		
		for(int i : waitingTime) {
			totalWaitingTime += i;
		}
		
		return (totalWaitingTime/waitingTime.length);
	}
	
	
	//calculating maximum waiting Time 
	public double maximumWaitingTime(int[] waitingTime) {
		int maxWaitingTime = waitingTime[0]; //initially 
		
		for(int i : waitingTime) {
			if(i > maxWaitingTime) {
				maxWaitingTime = i;
			}
		}
		
		return maxWaitingTime;
	}
	
	public void displayResults(int[] completionTime, int[] turnAroundTime, int[] waitingTime, int[][] processes) {
		System.out.println("Process\tArrival Time\tBurst Time\tCompletion Time\tTurn Around Time\tWaitingTime");
		
		for(int i =0;i<completionTime.length;i++) {
	    	   System.out.println((i+1)+ "\t\t" +processes[i][0]+ "\t\t" +processes[i][1] + "\t\t" + completionTime[i]+"\t\t" +turnAroundTime[i]+"\t\t"+waitingTime[i]);
	       }
	}
	
	
	public static void main(String[] args) {
       int[][] processes = {
    		   {0,10},
    		   {6,20},
    		   {60,10},
    		   {110,5}
       };
       
       
       //instance of job scheduler
       JobScheduler scheduler = new JobScheduler();
       
       //calculating all required things
       int[] completionTimeArray = scheduler.calculateCompletionTime(processes);
       int[] turnAroundTimeArray = scheduler.calculateTurnAroundTime(processes, completionTimeArray);
       int[] waitingTimeArray = scheduler.calculateWaitingTime(processes,turnAroundTimeArray);

       scheduler.displayResults(completionTimeArray, turnAroundTimeArray, waitingTimeArray, processes);
       
       
       
       System.out.println("Average Waiting Time : " + scheduler.calculateAvgWaitingTime(waitingTimeArray));
       System.out.println("Maximum Waiting Time : " + scheduler.maximumWaitingTime(waitingTimeArray));
	}
	

}
