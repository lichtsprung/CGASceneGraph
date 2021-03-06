/* 
 * Copyright 2011 Cologne University of Applied Sciences Licensed under the
 * Educational Community License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may
 * obtain a copy of the License at
 *
 * http://www.osedu.org/licenses/ECL-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS"
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package cga.framework.scenegraph.transform;

import cga.framework.animation.interpolation.Interpolation;
import cga.framework.math.Matrix;

/**
 * Eine Translation entlang der x-, y- und z-Achse.
 */
public class Translation implements Transformation {

    private double translateX;
    private double translateY;
    private double translateZ;
    private Interpolation interpolationX;
    private Interpolation interpolationY;
    private Interpolation interpolationZ;
    private Matrix transformMatrix;

    /**
     * Erstellt eine neue Translation.
     *
     * @param translateX Translation entlang der x-Achse
     * @param translateY Translation entlang der y-Achse
     * @param translateZ Translation entlang der z-Achse
     */
    public Translation(double translateX, double translateY, double translateZ) {
        this.translateX = translateX;
        this.translateY = translateY;
        this.translateZ = translateZ;
        updateMatrix();
    }

    public void changeX(double diffX) {
        translateX += diffX;
        updateMatrix();
    }

    public void changeY(double diffY) {
        translateY += diffY;
        updateMatrix();
    }

    public void changeZ(double diffZ) {
        translateZ += diffZ;
        updateMatrix();
    }

    private void updateMatrix() {
        double[][] values = {
            {1, 0, 0, translateX},
            {0, 1, 0, translateY},
            {0, 0, 1, translateZ},
            {0, 0, 0, 1}
        };
        transformMatrix = Matrix.constructWithCopy(values);
    }

    @Override
    public Matrix getTransformMatrix() {
        return transformMatrix;
    }

    public Interpolation getInterpolationX() {
        return interpolationX;
    }

    public void setInterpolationX(Interpolation interpolationX) {
        this.interpolationX = interpolationX;
    }

    public Interpolation getInterpolationY() {
        return interpolationY;
    }

    public void setInterpolationY(Interpolation interpolationY) {
        this.interpolationY = interpolationY;
    }

    public Interpolation getInterpolationZ() {
        return interpolationZ;
    }

    public void setInterpolationZ(Interpolation interpolationZ) {
        this.interpolationZ = interpolationZ;
    }

    @Override
    public void update() {
        if (interpolationX != null) {
            translateX = interpolationX.nextValue();
        }
        if (interpolationY != null) {
            translateY = interpolationY.nextValue();
        }
        if (interpolationZ != null) {
            translateZ = interpolationZ.nextValue();
        }
        updateMatrix();
    }
}
