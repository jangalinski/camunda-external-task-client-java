/* Licensed under the Apache License, Version 2.0 (the "License");
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
package org.camunda.bpm.client.variable.value;

import org.camunda.bpm.client.exception.ExternalTaskClientException;
import org.camunda.bpm.engine.variable.value.FileValue;

/**
 * File value is not available unless it is loaded actively
 *
 * Initially {@link #getValue()} returns {@code null}. Once {@link #load()} has been called
 * {@link #getValue()} holds the respective file value.
 *
 * @author Tassilo Weidner
 */
public interface DeferredFileValue extends FileValue {

  /**
   * File value has been loaded on invocation
   *
   * @throws ExternalTaskClientException if variable could not be retrieved from the engine
   */
  void load();

  /**
   * Indicates whether the file value has been loaded
   *
   * @return
   * <ul>
   *   <li> {@code true} if file value has been loaded
   *   <li> {@code false} if file value has not been loaded
   * </ul>
   */
  boolean isLoaded();

}
