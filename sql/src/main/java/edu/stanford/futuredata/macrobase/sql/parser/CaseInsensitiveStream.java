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

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.IntStream;
import org.antlr.v4.runtime.misc.Interval;

public class CaseInsensitiveStream implements CharStream {

    private final CharStream stream;

    CaseInsensitiveStream(CharStream stream) {
        this.stream = stream;
    }

    @Override
    public String getText(Interval interval) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void consume() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int LA(int i) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int mark() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void release(int marker) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int index() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public void seek(int index) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String getSourceName() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
