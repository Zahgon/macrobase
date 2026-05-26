package macrobase.analysis.summary.itemset;

import com.google.common.collect.Lists;
import macrobase.analysis.summary.itemset.result.ItemsetWithCount;
import java.util.*;

public class Apriori {

    private Set<Set<Integer>> genCandidates(List<ItemsetWithCount> prevRound, int desiredSize) {
        Set<Set<Integer>> ret = new HashSet<>();
        for (int i = 0; i < prevRound.size(); ++i) {
            for (int j = i + 1; j < prevRound.size(); ++j) {
                Set<Integer> combined = new HashSet<>();
                combined.addAll(prevRound.get(i).getItems());
                combined.addAll(prevRound.get(j).getItems());
                if (combined.size() == desiredSize) {
                    ret.add(combined);
                }
            }
        }
        return ret;
    }

    private List<ItemsetWithCount> filterItems(List<Set<Integer>> transactions, Set<Set<Integer>> candidates, Set<Integer> infrequentIndex, int minSupportCount) {
        List<ItemsetWithCount> ret = new ArrayList<>();
        HashMap<Set<Integer>, Integer> candidateCounts = new HashMap<>();
        for (int i = 0; i < transactions.size(); ++i) {
            if (infrequentIndex.contains(i)) {
                continue;
            }
            Set<Integer> txn = transactions.get(i);
            boolean foundSupportInTxn = false;
            for (Set<Integer> candidate : candidates) {
                boolean allFound = true;
                for (Integer candidateItem : candidate) {
                    if (!txn.contains(candidateItem)) {
                        allFound = false;
                        break;
                    }
                }
                if (allFound) {
                    candidateCounts.compute(candidate, (k, v) -> v == null ? 1 : v + 1);
                    foundSupportInTxn = true;
                }
            }
            if (!foundSupportInTxn) {
                infrequentIndex.add(i);
            }
        }
        for (Map.Entry<Set<Integer>, Integer> e : candidateCounts.entrySet()) {
            if (e.getValue() >= minSupportCount) {
                ret.add(new ItemsetWithCount(e.getKey(), e.getValue()));
            }
        }
        return ret;
    }

    public Set<ItemsetWithCount> getItemsets(List<Set<Integer>> transactions, Double support) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
