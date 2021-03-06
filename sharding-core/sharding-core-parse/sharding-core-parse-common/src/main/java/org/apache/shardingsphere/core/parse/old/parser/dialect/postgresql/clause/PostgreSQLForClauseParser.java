/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.core.parse.old.parser.dialect.postgresql.clause;

import lombok.RequiredArgsConstructor;
import org.apache.shardingsphere.core.parse.old.lexer.LexerEngine;
import org.apache.shardingsphere.core.parse.old.lexer.dialect.postgresql.PostgreSQLKeyword;
import org.apache.shardingsphere.core.parse.old.lexer.token.DefaultKeyword;
import org.apache.shardingsphere.core.parse.old.parser.clause.SQLClauseParser;

/**
 * Select for clause parser for PostgreSQL.
 *
 * @author zhangliang
 */
@RequiredArgsConstructor
public final class PostgreSQLForClauseParser implements SQLClauseParser {
    
    private final LexerEngine lexerEngine;
    
    /**
     * Parse for.
     */
    public void parse() {
        if (!lexerEngine.skipIfEqual(DefaultKeyword.FOR)) {
            return;
        }
        lexerEngine.skipIfEqual(DefaultKeyword.UPDATE, PostgreSQLKeyword.SHARE);
        lexerEngine.unsupportedIfEqual(DefaultKeyword.OF);
        lexerEngine.skipIfEqual(PostgreSQLKeyword.NOWAIT);
    }
}
