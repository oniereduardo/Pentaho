/*
 * *****************************************************************************
 *
 *  Pentaho Data Integration
 *
 *  Copyright (C) 2002-2022 by Hitachi Vantara : http://www.pentaho.com
 *
 *  *******************************************************************************
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use
 *  this file except in compliance with the License. You may obtain a copy of the
 *  License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 * *****************************************************************************
 *
 */

package org.pentaho.di.engine.configuration.impl.extension;

import org.pentaho.di.core.exception.KettleException;
import org.pentaho.di.core.extension.ExtensionPoint;
import org.pentaho.di.core.extension.ExtensionPointInterface;
import org.pentaho.di.core.logging.LogChannelInterface;
import org.pentaho.di.engine.configuration.impl.RunConfigurationManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bmorrise on 3/16/17.
 */
@ExtensionPoint( id = "RunConfigurationExtensionPoint", extensionPointId = "SpoonRunConfiguration",
  description = "" )
public class RunConfigurationExtensionPoint implements ExtensionPointInterface {

  private RunConfigurationManager runConfigurationManager = RunConfigurationManager.getInstance();

  @SuppressWarnings( "unchecked" )
  @Override public void callExtensionPoint( LogChannelInterface logChannelInterface, Object o ) throws KettleException {
    List<String> runConfigurations = (ArrayList) ( (Object[]) o )[ 0 ];
    String type = (String) ( (Object[]) o )[ 1 ];

    runConfigurations.addAll( runConfigurationManager.getNames( type ) );
  }
}
