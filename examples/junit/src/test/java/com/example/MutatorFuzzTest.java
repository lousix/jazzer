/*
 * Copyright 2023 Code Intelligence GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.code_intelligence.jazzer.driver.FuzzTargetRunner;
import com.code_intelligence.jazzer.junit.FuzzTest;
import com.code_intelligence.jazzer.mutation.annotation.NotNull;
import java.util.List;

class MutatorFuzzTest {
  @FuzzTest
  void mutatorFuzz(List<@NotNull String> list) {
    assertEquals(FuzzTargetRunner.mutatorDebugString(), "Arguments[Nullable<List<String>>]");
    if (list != null && list.size() > 3 && list.get(2).equals("mutator")) {
      throw new AssertionError("Found expected JUnit mutator test issue");
    }
  }
}
