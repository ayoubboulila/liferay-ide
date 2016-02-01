/*******************************************************************************
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 *******************************************************************************/

package com.liferay.ide.gradle.core.modules;

import com.liferay.ide.server.util.ServerUtil;

import org.eclipse.sapphire.modeling.Status;
import org.eclipse.sapphire.services.ValidationService;
import org.eclipse.wst.server.core.IRuntime;

/**
 * @author Terry Jia
 */
public class NewLiferayBundleValidationService extends ValidationService
{

    @Override
    protected Status compute()
    {
        Status retval = Status.createOkStatus();

        final NewJSPHookModuleOp op = context( NewJSPHookModuleOp.class );

        final String runtimeName = op.getBundleName().content( true );

        IRuntime runtime = ServerUtil.getRuntime( runtimeName );

        if( runtime == null )
        {
            retval = Status.createErrorStatus( "Liferay runtime must be configured." );
        }

        return retval;
    }
}