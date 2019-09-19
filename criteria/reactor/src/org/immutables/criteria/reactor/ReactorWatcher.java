/*
 * Copyright 2019 Immutables Authors and Contributors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.immutables.criteria.reactor;

import org.immutables.criteria.Criterion;
import org.immutables.criteria.backend.Backend;
import org.immutables.criteria.backend.WatchEvent;
import org.immutables.criteria.repository.Watcher;
import org.immutables.criteria.repository.reactive.ReactiveWatcher;
import reactor.core.publisher.Flux;

public class ReactorWatcher<T> implements Watcher<T, Flux<WatchEvent<T>>> {

  private final ReactiveWatcher<T> reactive;

  public ReactorWatcher(Criterion<T> criterion, Backend.Session session) {
    this.reactive = new ReactiveWatcher<>(criterion, session);
  }

  @Override
  public Flux<WatchEvent<T>> watch() {
    return Flux.from(reactive.watch());
  }
}
