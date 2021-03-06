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
package cga.example.sinecurve;

import cga.Framework;
import cga.framework.scenegraph.transform.Translation;

public final class AnimatedSineCurveMain extends Framework {

    private Translation translation;

    public AnimatedSineCurveMain() {
        super(800, 800);
    }

    @Override
    public void initGraph() {
        translation = new Translation(-400, 0, 0);
        getScenegraph().addTransformation(translation);
        add(new AnimatedSineCurve(2000, 0, 0));
    }

    public static void main(String[] args) {
        AnimatedSineCurveMain example = new AnimatedSineCurveMain();
        example.start();
    }
}
