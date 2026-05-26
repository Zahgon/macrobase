package edu.stanford.futuredata.macrobase.analysis.classify.stats;

import edu.stanford.futuredata.macrobase.util.MacroBaseException;
import java.util.function.DoublePredicate;
import java.util.function.Predicate;

public class MBPredicate {

    public enum PredicateType {

        EQUALS("=="),
        NOT_EQUALS("!="),
        LESS_THAN("<"),
        GREATER_THAN(">"),
        LEQ("<="),
        GEQ(">=");

        private static PredicateType getEnum(final String str) throws MacroBaseException {
            switch(str) {
                case "==":
                    return EQUALS;
                case "!=":
                    return NOT_EQUALS;
                case "<":
                    return LESS_THAN;
                case ">":
                    return GREATER_THAN;
                case "<=":
                    return LEQ;
                case ">=":
                    return GEQ;
                default:
                    throw new MacroBaseException("PredicateClassifier: Predicate string " + str + " not suppported.");
            }
        }

        final String str;

        PredicateType(String str) {
            this.str = str;
        }
    }

    /**
     * @return Lambda function corresponding to the ``predicateStr''. The Lambda function takes in a single
     * argument, which will correspond to the value in the metric column. (A closure is created around the ``sentinel''
     * parameter.)
     * @throws MacroBaseException
     */
    public static DoublePredicate getDoublePredicate(final String predicateStr, final double sentinel) throws MacroBaseException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * @return Lambda function corresponding to the ``predicateStr''. The Lambda function takes in a single
     * argument, which will correspond to the value in the metric column. (A closure is created around the ``sentinel''
     * parameter.)
     * @throws MacroBaseException
     */
    public static Predicate<String> getStrPredicate(final String predicateStr, final String sentinel) throws MacroBaseException {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
