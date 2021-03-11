package com.controller.viewcontrol;

import java.awt.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class ShowNumberControl {
	private ComponentMapping compMapping;
	private InfoMapping infoMapping;

	public static class ComponentMapping {
		private Map<String, Component> compMap;

		public ComponentMapping() {
			compMap = new HashMap<>();
		}

		public void add(String name, Component comp) {
			this.compMap.put(name, comp);
		}

		public Component get(String name) {
			return this.compMap.get(name);
		}
	}

	public static class InfoMapping {
		private Map<String, Object> infoMap;

		public InfoMapping() {
			infoMap = new HashMap<>();
		}

		public void add(String name, Object info) {
			this.infoMap.put(name, info);
		}

		public Object get(String name) {
			return this.infoMap.get(name);
		}
	}

	public ShowNumberControl() {
		compMapping = new ComponentMapping();
		infoMapping = new InfoMapping();
	}

	public void showNumber(BiConsumer<ComponentMapping, InfoMapping> csm) {
		csm.accept(compMapping, infoMapping);
	}

	public void add(String name, Component comp, Object info) {
		this.compMapping.add(name, comp);
		this.infoMapping.add(name, info);
	}
}
