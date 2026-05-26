package macrobase.analysis.summary.itemset;

import static com.codahale.metrics.MetricRegistry.name;
import com.codahale.metrics.Timer;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import macrobase.MacroBase;
import macrobase.analysis.summary.itemset.result.ItemsetWithCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.*;
import java.util.stream.Collectors;

public class StreamingFPGrowth {

    private static final Logger log = LoggerFactory.getLogger(StreamingFPGrowth.class);

    private final Timer fpMine = MacroBase.metrics.timer(name(StreamingFPGrowth.class, "fpMine"));

    private final Timer restructureTree = MacroBase.metrics.timer(name(StreamingFPGrowth.class, "restructureTree"));

    private final Timer updateFrequentItemOrder = MacroBase.metrics.timer(name(StreamingFPGrowth.class, "updateFrequentItemOrder"));

    private final Timer insertFrequentItems = MacroBase.metrics.timer(name(StreamingFPGrowth.class, "insertFrequentItems"));

    StreamingFPTree fp = new StreamingFPTree();

    boolean needsRestructure = false;

    boolean startedStreaming = false;

    private final double support;

    public StreamingFPGrowth(double support) {
        this.support = support;
    }

    class StreamingFPTree {

        private FPTreeNode root = new FPTreeNode(-1, null, 0);

        // used to calculate the order
        private Map<Integer, Double> frequentItemCounts = new HashMap<>();

        // item order -- need canonical to break ties; 0 is smallest, N is largest
        private Map<Integer, Integer> frequentItemOrder = new HashMap<>();

        protected Map<Integer, FPTreeNode> nodeHeaders = new HashMap<>();

        protected Set<FPTreeNode> leafNodes = new HashSet<>();

        Set<FPTreeNode> sortedNodes = new HashSet<>();

        private void printTreeDebug() {
            log.debug("Frequent Item Counts:");
            frequentItemCounts.entrySet().forEach(e -> log.debug("{} {}", e.getKey(), e.getValue()));
            log.debug("Frequent Item Order:");
            frequentItemOrder.entrySet().forEach(e -> log.debug("{} {}", e.getKey(), e.getValue()));
            walkTree(root, 1);
        }

        // todo: make more efficient
        private void decayWeights(FPTreeNode start, double decayWeight) {
            if (start == root) {
                for (Integer item : frequentItemCounts.keySet()) {
                    frequentItemCounts.put(item, frequentItemCounts.get(item) * decayWeight);
                }
            }
            start.count *= decayWeight;
            if (start.getChildren() != null) {
                for (FPTreeNode child : start.getChildren()) {
                    decayWeights(child, decayWeight);
                }
            }
        }

        private void walkTree(FPTreeNode start, int treeDepth) {
            log.debug("{} node: {}, count: {}, sorted: {}", new String(new char[treeDepth]).replaceAll("\0", "\t"), start.getItem(), start.getCount(), sortedNodes.contains(start));
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

            private FPTreeNode prevLink;

            private FPTreeNode parent;

            private List<FPTreeNode> children;

            public FPTreeNode(int item, FPTreeNode parent, double initialCount) {
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

            public void decrementCount(double by) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public boolean hasChildren() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public void removeChild(FPTreeNode child) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public void setNextLink(FPTreeNode nextLink) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public FPTreeNode getNextLink() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public void setPrevLink(FPTreeNode prevLink) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public FPTreeNode getPrevLink() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public FPTreeNode getParent() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public List<FPTreeNode> getChildren() {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            public void mergeChildren(List<FPTreeNode> otherChildren) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }

            // insert the transaction at this node starting with transaction[currentIndex]
            // then find the child that matches
            public void insertTransaction(List<Integer> fullTransaction, int currentIndex, final double itemCount, boolean streaming) {
                throw new UnsupportedOperationException("STUB: not implemented");
            }
        }

        public int getSupport(Collection<Integer> pattern) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void insertFrequentItems(List<Set<Integer>> transactions, int countRequiredForSupport) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void deleteItems(Set<Integer> itemsToDelete) {
            if (itemsToDelete == null) {
                return;
            }
            for (int item : itemsToDelete) {
                frequentItemCounts.remove(item);
                frequentItemOrder.remove(item);
                FPTreeNode nodeToDelete = nodeHeaders.get(item);
                while (nodeToDelete != null) {
                    nodeToDelete.parent.removeChild(nodeToDelete);
                    if (nodeToDelete.hasChildren()) {
                        nodeToDelete.parent.mergeChildren(nodeToDelete.children);
                    }
                    leafNodes.remove(nodeToDelete);
                    nodeToDelete = nodeToDelete.getNextLink();
                }
                nodeHeaders.remove(item);
            }
        }

        private void updateFrequentItemOrder() {
            Timer.Context context = updateFrequentItemOrder.time();
            sortedNodes.clear();
            frequentItemOrder.clear();
            // we have to materialize a canonical order so that items with equal counts
            // are consistently ordered when they are sorted during transaction insertion
            List<Map.Entry<Integer, Double>> sortedItemCounts = Lists.newArrayList(frequentItemCounts.entrySet());
            sortedItemCounts.sort((i1, i2) -> frequentItemCounts.get(i1.getKey()).compareTo(frequentItemCounts.get(i2.getKey())));
            for (int i = 0; i < sortedItemCounts.size(); ++i) {
                frequentItemOrder.put(sortedItemCounts.get(i).getKey(), i);
            }
            context.stop();
        }

        public void insertConditionalFrequentItems(List<ItemsetWithCount> patterns, int countRequiredForSupport) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void sortTransaction(List<Integer> txn, boolean isStreaming) {
            if (!isStreaming) {
                txn.sort((i1, i2) -> frequentItemOrder.get(i2).compareTo(frequentItemOrder.get(i1)));
            } else {
                txn.sort((i1, i2) -> frequentItemOrder.compute(i2, (k, v) -> v == null ? -i2 : v).compareTo(frequentItemOrder.compute(i1, (k, v) -> v == null ? -i1 : v)));
            }
        }

        public void insertConditionalFrequentPatterns(List<ItemsetWithCount> patterns) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void reinsertBranch(Set<Integer> pattern, double count, FPTreeNode rootOfBranch) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void insertTransactions(List<Set<Integer>> transactions, boolean streaming, boolean filterExistingFrequentItemsOnly) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public void insertTransaction(Collection<Integer> transaction, boolean streaming, boolean filterExistingFrequentItemsOnly) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        List<ItemsetWithCount> mineItemsets(Integer supportCountRequired) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        private void removeNodeFromHeaders(FPTreeNode node) {
            leafNodes.remove(node);
            if (node.getPrevLink() == null) {
                assert (nodeHeaders.get(node.getItem()) == node);
                nodeHeaders.put(node.getItem(), node.getNextLink());
            } else {
                node.getPrevLink().setNextLink(node.getNextLink());
            }
            if (node.getNextLink() != null) {
                node.getNextLink().setPrevLink(node.getPrevLink());
            }
        }

        private void sortByNewOrder() {
            // we need to walk the tree from each leaf to each root
            List<FPTreeNode> leavesToInspect = Lists.newArrayList(leafNodes);
            Set<FPTreeNode> removedNodes = new HashSet<>();
            for (int i = 0; i < leavesToInspect.size(); ++i) {
                FPTreeNode leaf = leavesToInspect.get(i);
                if (leaf == root) {
                    continue;
                }
                if (removedNodes.contains(leaf) || sortedNodes.contains(leaf)) {
                    continue;
                }
                double leafCount = leaf.getCount();
                Set<Integer> toInsert = new HashSet<>();
                toInsert.add(leaf.getItem());
                assert (!leaf.hasChildren());
                removeNodeFromHeaders(leaf);
                removedNodes.add(leaf);
                int curLowestNodeOrder = frequentItemOrder.get(leaf.getItem());
                FPTreeNode node = leaf.getParent();
                node.removeChild(leaf);
                while (true) {
                    if (node == root) {
                        break;
                    }
                    int nodeOrder = frequentItemOrder.get(node.getItem());
                    if (sortedNodes.contains(node) && nodeOrder < curLowestNodeOrder) {
                        break;
                    } else if (nodeOrder < curLowestNodeOrder) {
                        curLowestNodeOrder = nodeOrder;
                    }
                    assert (!removedNodes.contains(node));
                    toInsert.add(node.getItem());
                    node.decrementCount(leafCount);
                    // this node no longer has support, so remove it...
                    if (node.getCount() == 0 && !node.hasChildren()) {
                        removedNodes.add(node);
                        removeNodeFromHeaders(node);
                        node.getParent().removeChild(node);
                        // still has support but is unsorted, so we'd better check it out
                    } else if (!node.hasChildren() && !sortedNodes.contains(node)) {
                        leavesToInspect.add(node);
                    }
                    node = node.getParent();
                }
                node.decrementCount(leafCount);
                reinsertBranch(toInsert, leafCount, node);
            }
        }
    }

    public void insertTransactionsStreamingExact(List<Set<Integer>> transactions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void insertTransactionStreamingExact(Collection<Integer> transaction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void insertTransactionsStreamingFalseNegative(List<Set<Integer>> transactions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void insertTransactionStreamingFalseNegative(Collection<Integer> transaction) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void restructureTree(Set<Integer> itemsToDelete) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void buildTree(List<Set<Integer>> transactions) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void decayAndResetFrequentItems(Map<Integer, Double> newFrequentItems, double decayRate) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<ItemsetWithCount> getCounts(List<ItemsetWithCount> targets) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<ItemsetWithCount> getItemsets() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public void printTreeDebug() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
