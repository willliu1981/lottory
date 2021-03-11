package com.controller.viewcontrol;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class ShowNumberControl {
	private ComponentMapping<?> mapping;

	public static class ComponentMapping<T extends Component> {
		private Map<String, T> compMap;

		public ComponentMapping() {
			compMap = new HashMap<>();
		}

		public void add(String name, T comp) {
			this.compMap.put(name, comp);
		}

		public T get(String name) {
			return this.compMap.get(name);
		}
	}

	public <T extends Component> ShowNumberControl() {
		mapping = new ComponentMapping<T>();
	}

	public void showNumber(Consumer<ComponentMapping> csm) {
		csm.accept(mapping);
	}
}
