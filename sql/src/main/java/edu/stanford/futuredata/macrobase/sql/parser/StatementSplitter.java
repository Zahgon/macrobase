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
package edu.stanford.futuredata.macrobase.sql.parser;

import static java.util.Objects.requireNonNull;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import edu.stanford.futuredata.macrobase.SqlBaseLexer;
import edu.stanford.futuredata.macrobase.SqlBaseParser;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenSource;

public class StatementSplitter {

    private final List<Statement> completeStatements;

    private final String partialStatement;

    public StatementSplitter(String sql) {
        this(sql, ImmutableSet.of(";"));
    }

    public StatementSplitter(String sql, Set<String> delimiters) {
        TokenSource tokens = getLexer(sql, delimiters);
        ImmutableList.Builder<Statement> list = ImmutableList.builder();
        StringBuilder sb = new StringBuilder();
        while (true) {
            Token token = tokens.nextToken();
            if (token.getType() == Token.EOF) {
                break;
            }
            if (token.getType() == SqlBaseParser.DELIMITER) {
                String statement = sb.toString().trim();
                if (!statement.isEmpty()) {
                    list.add(new Statement(statement, token.getText()));
                }
                sb = new StringBuilder();
            } else {
                sb.append(token.getText());
            }
        }
        this.completeStatements = list.build();
        this.partialStatement = sb.toString().trim();
    }

    public List<Statement> getCompleteStatements() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getPartialStatement() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static String squeezeStatement(String sql) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static boolean isEmptyStatement(String sql) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private static TokenSource getLexer(String sql, Set<String> terminators) {
        requireNonNull(sql, "sql is null");
        CharStream stream = new CaseInsensitiveStream(new ANTLRInputStream(sql));
        return new DelimiterLexer(stream, terminators);
    }

    public static class Statement {

        private final String statement;

        private final String terminator;

        public Statement(String statement, String terminator) {
            this.statement = requireNonNull(statement, "statement is null");
            this.terminator = requireNonNull(terminator, "terminator is null");
        }

        public String statement() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        public String terminator() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public boolean equals(Object obj) {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public int hashCode() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("STUB: not implemented");
        }
    }
}
