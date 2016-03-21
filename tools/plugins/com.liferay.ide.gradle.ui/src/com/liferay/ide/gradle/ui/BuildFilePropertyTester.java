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
package com.liferay.ide.gradle.ui;

import com.liferay.ide.gradle.core.GradleUtil;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;

/**
 * @author Lovett Li
 */
public class BuildFilePropertyTester extends PropertyTester
{

    public boolean test( Object receiver, String property, Object[] args, Object expectedValue )
    {
        if( receiver instanceof IFile )
        {
            return GradleUtil.isBuildFile( (IFile) receiver );
        }

        return false;
    }
}
