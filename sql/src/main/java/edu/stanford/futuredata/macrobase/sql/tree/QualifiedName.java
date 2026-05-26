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

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.collect.Iterables.isEmpty;
import static com.google.common.collect.Iterables.transform;
import static java.util.Locale.ENGLISH;
import static java.util.Objects.requireNonNull;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Optional;

public class QualifiedName {

    private final List<String> parts;

    private final List<String> originalParts;

    public static QualifiedName of(String first, String... rest) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static QualifiedName of(String name) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public static QualifiedName of(Iterable<String> originalParts) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    private QualifiedName(List<String> originalParts, List<String> parts) {
        this.originalParts = originalParts;
        this.parts = parts;
    }

    public List<String> getParts() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public List<String> getOriginalParts() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    /**
     * For an identifier of the form "a.b.c.d", returns "a.b.c" For an identifier of the form "a",
     * returns absent
     */
    public Optional<QualifiedName> getPrefix() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public boolean hasSuffix(QualifiedName suffix) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    public String getSuffix() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public boolean equals(Object o) {
        throw new UnsupportedOperationException("STUB: not implemented");
    }

    @Override
    public int hashCode() {
        throw new UnsupportedOperationException("STUB: not implemented");
    }
}
