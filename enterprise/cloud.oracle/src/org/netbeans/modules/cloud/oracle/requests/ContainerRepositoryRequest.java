/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.netbeans.modules.cloud.oracle.requests;

import com.oracle.bmc.artifacts.model.CreateContainerRepositoryDetails;
import com.oracle.bmc.artifacts.requests.CreateContainerRepositoryRequest;

/**
 *
 * @author Dusan Petrovic
 */
public class ContainerRepositoryRequest extends OCIItemCreationDetails<CreateContainerRepositoryRequest> {

    private static final Boolean IS_REPOSITORY_PUBLIC = Boolean.FALSE;

    public ContainerRepositoryRequest(String compartmentId, String name) {
        super(compartmentId, name);
    }

    @Override
    public CreateContainerRepositoryRequest getRequest() {
        CreateContainerRepositoryDetails createContainerRepositoryDetails = CreateContainerRepositoryDetails.builder()
                .compartmentId(this.getCompartmentId())
                .displayName(this.getName())
                .isPublic(IS_REPOSITORY_PUBLIC)
                .build(); 
        return CreateContainerRepositoryRequest.builder()
                .createContainerRepositoryDetails(createContainerRepositoryDetails)
                .build();

    }
}
