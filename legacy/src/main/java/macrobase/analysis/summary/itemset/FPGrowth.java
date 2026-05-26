package macrobase.analysis.summary.itemset;

import com.codahale.metrics.Timer;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import macrobase.MacroBase;
import macrobase.analysis.summary.itemset.result.ItemsetWithCount;
import macrobase.datamodel.Datum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import java.util.stream.Collectors;
import static com.codahale.metrics.MetricRegistry.name;

public class FPGrowth {

    private static final Logger log = LoggerFactory.getLogger(FPGrowth.class);

    private final Timer singleItemCounts = MacroBase.metrics.timer(name(FPGrowth.class, "itemCounts"));

    private final Timer insertTransactions = MacroBase.metrics.timer(name(FPGrowth.class, "insertTransactions"));

    private final Timer fpMine = MacroBase.metrics.timer(name(FPGrowth.class, "fpMine"));

    class FPTree {

        private FPTreeNode root = new FPTreeNode(-1, null, 0);

        // used to calculate the order
        private Map<Integer, Double> frequentItemCounts = new HashMap<>();

        // item order -- need canonical to break ties; 0 is smallest, N is largest
        private Map<Integer, Integer> frequentItemOrder = new HashMap<>();

        protected Map<Integer, FPTreeNode> nodeHeaders = new HashMap<>();

        protected void printTreeDebug() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void walkTree(FPTreeNode start, int treeDepth) {
            log.debug(String.format("%s node: %d, count: %f", new String(new char[treeDepth]).replaceAll("\0", "\t"), start.getItem(), start.getCount()));
            if (start.getChildren() != null) {
                for (FPTreeNode child : start.getChildren()) {
                    walkTree(child, treeDepth + 1);
                }
            }
        }

        private class FPTreeNode {

            private int item;

            private double count;

            private FPTreeNode nextLink;

            private FPTreeNode parent;

            private List<FPTreeNode> children;

            public FPTreeNode(int item, FPTreeNode parent, int initialCount) {
                this.item = item;
                this.parent = parent;
                this.count = initialCount;
            }

            public int getItem() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public double getCount() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public void incrementCount(double by) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public void setNextLink(FPTreeNode nextLink) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public FPTreeNode getNextLink() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public FPTreeNode getParent() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public List<FPTreeNode> getChildren() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            // insert the transaction at this node starting with transaction[currentIndex]
            // then find the child that matches
            public void insertTransaction(List<Integer> fullTransaction, int currentIndex, final double transactionCount) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

        public void setFrequentCounts(Map<Integer, Double> counts) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void insertFrequentItems(List<Set<Integer>> transactions, int countRequiredForSupport) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void sortFrequentItems() {
            // we have to materialize a canonical order so that items with equal counts
            // are consistently ordered when they are sorted during transaction insertion
            List<Map.Entry<Integer, Double>> sortedItemCounts = Lists.newArrayList(frequentItemCounts.entrySet());
            sortedItemCounts.sort((i1, i2) -> frequentItemCounts.get(i1.getKey()).compareTo(frequentItemCounts.get(i2.getKey())));
            for (int i = 0; i < sortedItemCounts.size(); ++i) {
                frequentItemOrder.put(sortedItemCounts.get(i).getKey(), i);
            }
        }

        public void insertConditionalFrequentItems(List<ItemsetWithCount> patterns, int countRequiredForSupport) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void insertDatum(List<Datum> datums) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void insertConditionalFrequentPatterns(List<ItemsetWithCount> patterns) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void insertTransactions(List<Set<Integer>> transactions) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public int getSupport(Set<Integer> pattern) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        List<ItemsetWithCount> mineItemsets(Integer supportCountRequired) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }

    public List<ItemsetWithCount> getItemsetsWithSupportRatio(List<Set<Integer>> transactions, Double supportRatio) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<ItemsetWithCount> getItemsetsWithSupportRatio(List<Set<Integer>> transactions, Map<Integer, Double> initialCounts, Double supportRatio) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<ItemsetWithCount> getItemsetsWithSupportCount(List<Set<Integer>> transactions, Double supportCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<ItemsetWithCount> getItemsetsWithSupportCount(List<Set<Integer>> transactions, Map<Integer, Double> initialCounts, Double supportCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    protected FPTree constructTree(List<Set<Integer>> transactions, int supportCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<ItemsetWithCount> getItemsetsWithSupportCount(List<Set<Integer>> transactions, Map<Integer, Double> initialCounts, Double supportCount, boolean printTreeDebug) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    // ugh, this is a really ugly function sig, but it's efficient
    public List<ItemsetWithCount> getCounts(List<Datum> transactions, Map<Integer, Double> initialCounts, Set<Integer> targetItems, List<ItemsetWithCount> toCount) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
