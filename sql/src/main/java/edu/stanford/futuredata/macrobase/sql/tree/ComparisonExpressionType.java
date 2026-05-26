/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package edu.stanford.futuredata.macrobase.sql.tree;

public enum ComparisonExpressionType {

    EQUAL("="),
    NOT_EQUAL("<>"),
    LESS_THAN("<"),
    LESS_THAN_OR_EQUAL("<="),
    GREATER_THAN(">"),
    GREATER_THAN_OR_EQUAL(">="),
    IS_DISTINCT_FROM("IS DISTINCT FROM");

    private final String value;

    ComparisonExpressionType(String value) {
        this.value = value;
    }

    public String getValue() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ComparisonExpressionType flip() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public ComparisonExpressionType negate() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
