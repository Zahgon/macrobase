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

import com.google.common.collect.ImmutableSet;
import edu.stanford.futuredata.macrobase.SqlBaseLexer;
import edu.stanford.futuredata.macrobase.SqlBaseParser;
import java.util.Set;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.IntStream;
import org.antlr.v4.runtime.LexerNoViableAltException;
import org.antlr.v4.runtime.Token;

/**
 * This is a special-purpose lexer that can identify custom delimiters in addition to every other
 * token in the SQL grammar. <p> The code in nextToken() is a copy of the implementation in
 * org.antlr.v4.runtime.Lexer, with a bit added to match the token before the default behavior is
 * invoked.
 */
class DelimiterLexer extends SqlBaseLexer {

    private final Set<String> delimiters;

    public DelimiterLexer(CharStream input, Set<String> delimiters) {
        super(input);
        this.delimiters = ImmutableSet.copyOf(delimiters);
    }

    @Override
    public Token nextToken() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private boolean match(String delimiter) {
        for (int i = 0; i < delimiter.length(); i++) {
            if (_input.LA(i + 1) != delimiter.charAt(i)) {
                return false;
            }
        }
        _input.seek(_input.index() + delimiter.length());
        return true;
    }
}
