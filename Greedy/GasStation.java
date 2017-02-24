
public class GasStation {

	// 1. if starting from "start" and fail to start at some i (tank + gas[i] - cost[i] < 0), 
	// then starting from any j between (start, i] is also impossible. We should try from the next one, i.e. i+1
	//     because when we are at start, tank is 0, and tank must be positive(or zero) when arriving each j; 
	//     if we start from j with tank=0, it is at least as hard if not harder;
	//     e.g. gas: [8,   8,  4,  10]
	//         cost: [7,   7,  7,  7]
	//         tank: [1,   2, -1, 0->3]  at i = 2, we can't start because tank < 0, so we start from 3 with tank updated to 10-7
	// 2. use a total to calculate the total gas - cost. if total < 0, it is impossible to complete the loop (common knowledge)
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int tank = 0, start = 0, totalGas = 0, totalCost = 0;
		for (int i = 0; i < gas.length; i++) {
			tank += gas[i] - cost[i];
			totalGas += gas[i];
			totalCost += cost[i];
			if (tank < 0) {
				start = i + 1;
				tank = 0;
			}
		}
		return totalGas < totalCost ? -1 : start;
	}
}
