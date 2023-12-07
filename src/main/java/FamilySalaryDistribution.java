import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FamilySalaryDistribution {
    public static List<Integer> salaryDistribution(int N, int K, int[] parents, int[] salaryOrder) {
        boolean[] receivedSalary = new boolean[N];
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> parentMap = new HashMap<>();
        for (int i = 0; i < parents.length; i++) {
            parentMap.put(i, parents[i]);
        }

        for (int earningMember : salaryOrder) {
            if (parentMap.get(earningMember) == -1) {
                receivedSalary[earningMember] = true;
                continue;
            }
            if (receivedSalary[parentMap.get(earningMember)]) {
                result.add(earningMember);
            }
            receivedSalary[earningMember] = true;
        }

        return result;
    }

    private static void distributeSalary(int member, int[] parents, boolean[] receivedSalary) {
        if (member == -1 || receivedSalary[member]) {
            return;
        }
        receivedSalary[member] = true;
        distributeSalary(parents[member], parents, receivedSalary);
    }

    public static void main(String[] args) {
        int N = 8;
        int K = 4;
        int[] parents = {-1, 7, 7, 1, 1, 1, 2, 0};
        int[] salaryOrder = {0, 3, 4, 5};

        List<Integer> result = salaryDistribution(N, K, parents, salaryOrder);
        System.out.println(result);  // Output should be [0, 7, 1, 5]
    }
}
