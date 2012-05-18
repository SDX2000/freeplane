/*
 *  Freeplane - mind map editor
 *  Copyright (C) 2008 Dimitry Polivaev
 *
 *  This file author is Dimitry Polivaev
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.freeplane.features.filter.condition;

import java.util.HashSet;

import org.freeplane.core.util.TextUtils;
import org.freeplane.features.map.NodeModel;
import org.freeplane.features.mode.Controller;
import org.freeplane.n3.nanoxml.XMLElement;

public class SelectedViewSnapshotCondition extends ASelectableCondition {
	private static final String NAME = "selected_view_snapshot";
	private static String description;

	public static ASelectableCondition CreateCondition() {
		return new SelectedViewSnapshotCondition();
	}

	HashSet<NodeModel> selectedNodes;

	public SelectedViewSnapshotCondition() {
		super();
		selectedNodes = new HashSet<NodeModel>();
		selectedNodes.addAll(Controller.getCurrentController().getSelection().getSelection());
	}

	public boolean checkNode(final NodeModel node) {
		return selectedNodes.contains(node);
	}

	@Override
    protected String createDescription() {
		if (SelectedViewSnapshotCondition.description == null) {
			SelectedViewSnapshotCondition.description = TextUtils.getText("filter_selected_node_view_snapshot");
		}
		return SelectedViewSnapshotCondition.description;
    }

	@Override
    protected String getName() {
	    return NAME;
   }
	public void toXml(final XMLElement element) {}
}
