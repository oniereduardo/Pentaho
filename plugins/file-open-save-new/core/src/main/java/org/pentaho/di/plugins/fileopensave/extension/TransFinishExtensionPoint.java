/*! ******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2019 by Hitachi Vantara : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.di.plugins.fileopensave.extension;

import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.extension.ExtensionPoint;
import org.pentaho.di.core.extension.ExtensionPointInterface;
import org.pentaho.di.core.logging.LogChannelInterface;
import org.pentaho.di.plugins.fileopensave.cache.FileCache;
import org.pentaho.di.plugins.fileopensave.service.FileCacheService;

@ExtensionPoint(
  id = "TransFinishExtensionPoint",
  extensionPointId = "TransformationFinish",
  description = "Clear file browser cache when Job finishes"
)
public class TransFinishExtensionPoint implements ExtensionPointInterface {

  private final FileCache fileCache;

  public TransFinishExtensionPoint() {
    this( FileCacheService.INSTANCE.get() );
  }
  
  public TransFinishExtensionPoint( FileCache fileCache ) {
    this.fileCache = fileCache;
  }

  @Override public void callExtensionPoint( LogChannelInterface log, Object object ) throws KettleException {
    fileCache.clearAll();
  }
}
