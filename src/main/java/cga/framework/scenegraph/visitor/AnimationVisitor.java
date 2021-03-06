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
package cga.framework.scenegraph.visitor;

import cga.framework.scenegraph.Node;
import cga.framework.shape.Shape;
import java.util.logging.Logger;

public class AnimationVisitor implements Visitor {

    private static final Logger logger = Logger.getLogger(AnimationVisitor.class.getName());

    @Override
    public void visit(Node node) {
        synchronized (node.getGeometry()) {
            for (Shape shape : node.getGeometry()) {
                if (shape.getAnimation() != null) {
                    shape.getAnimation().animate();
                }
            }
        }
    }
}
